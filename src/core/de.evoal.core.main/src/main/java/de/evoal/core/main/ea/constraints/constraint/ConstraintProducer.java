package de.evoal.core.main.ea.constraints.constraint;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.ea.constraints.model.Constraint;
import de.evoal.core.api.ea.constraints.model.Constraints;
import de.evoal.core.api.ea.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertiesSpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import de.evoal.core.main.ea.constraints.el.ElHelper;
import de.evoal.core.main.ea.constraints.el.LogHelper;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.FunctionName;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.el.Call;
import de.evoal.core.main.ea.constraints.constraint.ast.ConditionConverter;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Attribute;
import de.evoal.languages.model.instance.DataReference;
import de.evoal.languages.model.instance.Instance;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.xtext.serializer.impl.Serializer;

import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
@Slf4j
public class ConstraintProducer {
    private PropertiesSpecification fitnessSpec;
    private PropertiesSpecification genoSpec;

    @Produces
    @ApplicationScoped
    public Constraints create(final DataConstraints constraints,
                              @Named("genotype-specification") final PropertiesSpecification genoSpec,
                              @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.fitness") final Instance fitnessConfig) {
        this.genoSpec = genoSpec;
        this.fitnessSpec = toInnerSpecification(fitnessConfig);
        final Constraints result = new Constraints();

        constraints.stream()
                   .forEach(p -> {
                       final DataDescription context = p.getFirst();

                       p.getSecond()
                        .stream()
                        .map(ElHelper::findCall)
                        .filter(Objects::nonNull)
                        .map(Call.class::cast)
                        .filter(c -> "constraint".equals(((FunctionName)c.getFunction()).getDefinition().getName()))
                        .map(c -> convert(c, context))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .forEach(result.getConstraints()::add);
        });
        log.info("Loaded {} constraints.", result.getConstraints().size());

        return result;
    }

    private PropertiesSpecification toInnerSpecification(final Instance fitnessConfig) {
        final Attribute subFunction = fitnessConfig.findAttribute("function");

        if(subFunction != null) {
            return toInnerSpecification((Instance)subFunction.getValue());
        }

        final Attribute mapping = fitnessConfig.findAttribute("maps-to");

        return PropertiesSpecification.builder()
                        .add(((Array)mapping.getValue())
                                            .getValues()
                                            .stream()
                                            .map(DataReference.class::cast)
                                            .map(DataReference::getDefinition)
                        )
                        .build();
    }

    private Optional<Constraint> convert(final Call constraint, final DataDescription context) {
        if(constraint.getParameters().size() != 2) {
            LogHelper.parameterMismatch(log,"constraint", constraint, 2);
            return Optional.empty();
        }

        final Constraint result = new Constraint();
        result.setGroup(ElHelper.findString(constraint.getParameters().get(1)));

        final ConditionConverter converter = new ConditionConverter(genoSpec, fitnessSpec, context);
        converter.doSwitch(constraint.getParameters().get(0));

        result.setFunction(converter.getFunction());
        result.setUsedProperties(converter.getUsedProperties());
        result.setConstraintType(converter.getType());

        return Optional.of(result);
    }
}
