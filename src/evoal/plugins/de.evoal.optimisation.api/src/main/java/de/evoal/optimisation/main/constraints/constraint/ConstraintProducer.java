package de.evoal.optimisation.main.constraints.constraint;

import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.optimisation.api.constraints.model.Constraint;
import de.evoal.optimisation.api.constraints.model.Constraints;
import de.evoal.optimisation.api.constraints.model.DataConstraints;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.main.constraints.constraint.utils.ConfigurationUtils;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import javax.enterprise.context.ApplicationScoped;
import de.evoal.core.api.utils.Requirements;
import javax.enterprise.inject.Produces;
import de.evoal.optimisation.main.constraints.constraint.utils.EpsilonUtils;
import javax.inject.Named;

import de.evoal.optimisation.main.constraints.constraint.ast.ConditionConverter;
import de.evoal.core.api.languages.base.BaseLanguageHelper;
import de.evoal.core.api.languages.base.LogHelper;
import de.evoal.languages.model.base.definitions.DefinedFunctionName;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Call;
import lombok.extern.slf4j.Slf4j;
import javax.inject.Inject;

import java.util.*;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
@Slf4j
public class ConstraintProducer {
    private PropertiesSpecification optimisationSpaceSpecification;
    private PropertiesSpecification searchSpaceSecification;

    @Inject
    private ConfigurationUtils configUtil;
    @Inject
    private AttributeEvaluator attributeEvaluator;

    @Inject
    private EpsilonUtils epsilonUtils;

    @Produces
    @ApplicationScoped
    public Constraints create(final DataConstraints constraints,
                              @Named("search-space-specification") final PropertiesSpecification searchSpaceSecification,
                              @Named("optimisation-space-specification") final PropertiesSpecification optimisationSpaceSpecification,
                              final @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.handlers") List<Instance> handlerConfigurations) {


        this.optimisationSpaceSpecification = optimisationSpaceSpecification;
        this.searchSpaceSecification = searchSpaceSecification;

        final Constraints result = new Constraints();

        constraints.stream()
                .peek(p -> System.out.println(p))
                   .forEach(p -> {
                       final DataDescription context = p.getFirst();

                       p.getSecond()
                        .stream()
                        .map(BaseLanguageHelper::findCall)
                        .filter(Objects::nonNull)
                        .map(Call.class::cast)
                        .filter(c -> "constraint".equals(c.getFunction().getName()))
                        .map(c -> convert(c, context))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .forEach(result.getConstraints()::add);
        });

        //TODO here would be I think where to add the constraints of the epsilon handler...
        /*
           access handler config, read out constraints and add to constraints list...
         */
        Optional<Instance> epsilonHandler = configUtil.findEpsilonHandler(handlerConfigurations);
        epsilonHandler.ifPresent(handler -> {
            DataDescription[] epsilonData = attributeEvaluator.attributeToDataDescriptionArray(handler, "objectives");
            double[] bounds = attributeEvaluator.attributeToDoubleArray(handler, "bounds");
            Requirements.requireSameSize(bounds, epsilonData);
            for (int i=0; i<epsilonData.length;i++) {
                PropertySpecification data = optimisationSpaceSpecification.find(epsilonData[i].getName());
                int dataIndex = optimisationSpaceSpecification.indexOf(data);
                result.getConstraints().add(epsilonUtils.convert(data, dataIndex, bounds[i]));
            }
        });

        log.info("Loaded {} constraints.", result.getConstraints().size());

        return result;
    }

    private Optional<Constraint> convert(final Call constraint, final DataDescription context) {
        if(constraint.getParameters().size() != 2) {
            LogHelper.parameterMismatch(log, "constraint", constraint, 2);
            return Optional.empty();
        }

        final Constraint result = new Constraint();
        result.setGroup(BaseLanguageHelper.findString(constraint.getParameters().get(1)));

        final ConditionConverter converter = new ConditionConverter(searchSpaceSecification, optimisationSpaceSpecification, context);
        try {
            converter.doSwitch(constraint.getParameters().get(0));

            result.setFunction(converter.getFunction());
            result.setUsedProperties(converter.getUsedProperties());
            result.setConstraintType(converter.getType());

            return Optional.of(result);
        } catch(final IllegalStateException e) {
            log.info("Failed to convert expression to condition.", e);
            return Optional.empty();
        }
    }
}
