package de.evoal.core.main.constraints.constraint;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.constraints.model.Constraint;
import de.evoal.core.api.constraints.model.Constraints;
import de.evoal.core.api.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertiesSpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import de.evoal.core.main.constraints.constraint.ast.ConditionConverter;
import de.evoal.core.main.constraints.el.ElHelper;
import de.evoal.core.main.constraints.el.LogHelper;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.FunctionName;
import de.evoal.languages.model.el.Call;
import de.evoal.languages.model.instance.Instance;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
@Slf4j
public class ConstraintProducer {
    private PropertiesSpecification optisationSpaceSpecification;
    private PropertiesSpecification searchSpaceSecification;

    @Produces
    @ApplicationScoped
    public Constraints create(final DataConstraints constraints,
                              @Named("search-space-specification") final PropertiesSpecification searchSpaceSecification,
                              @Named("optimisation-space-specification") final PropertiesSpecification optisationSpaceSpecification) {
        this.optisationSpaceSpecification = optisationSpaceSpecification;
        this.searchSpaceSecification = searchSpaceSecification;


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

    private Optional<Constraint> convert(final Call constraint, final DataDescription context) {
        if(constraint.getParameters().size() != 2) {
            LogHelper.parameterMismatch(log,"constraint", constraint, 2);
            return Optional.empty();
        }

        final Constraint result = new Constraint();
        result.setGroup(ElHelper.findString(constraint.getParameters().get(1)));

        final ConditionConverter converter = new ConditionConverter(searchSpaceSecification, optisationSpaceSpecification, context);
        converter.doSwitch(constraint.getParameters().get(0));

        result.setFunction(converter.getFunction());
        result.setUsedProperties(converter.getUsedProperties());
        result.setConstraintType(converter.getType());

        return Optional.of(result);
    }
}
