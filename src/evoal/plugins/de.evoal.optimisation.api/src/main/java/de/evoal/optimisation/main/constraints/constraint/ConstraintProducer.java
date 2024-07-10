package de.evoal.optimisation.main.constraints.constraint;

import de.evoal.optimisation.api.constraints.model.Constraint;
import de.evoal.optimisation.api.constraints.model.Constraints;
import de.evoal.optimisation.api.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertiesSpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import de.evoal.optimisation.main.constraints.constraint.ast.ConditionConverter;
import de.evoal.core.api.languages.base.BaseLanguageHelper;
import de.evoal.core.api.languages.base.LogHelper;
import de.evoal.languages.model.base.DefinedFunctionName;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.Call;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
@Slf4j
public class ConstraintProducer {
    private PropertiesSpecification optimisationSpaceSpecification;
    private PropertiesSpecification searchSpaceSecification;

    @Produces
    @ApplicationScoped
    public Constraints create(final DataConstraints constraints,
                              @Named("search-space-specification") final PropertiesSpecification searchSpaceSecification,
                              @Named("optimisation-space-specification") final PropertiesSpecification optimisationSpaceSpecification) {
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
                        .filter(c -> "constraint".equals(((DefinedFunctionName)c.getFunction()).getDefinition().getName()))
                        .map(c -> convert(c, context))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .forEach(result.getConstraints()::add);
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
