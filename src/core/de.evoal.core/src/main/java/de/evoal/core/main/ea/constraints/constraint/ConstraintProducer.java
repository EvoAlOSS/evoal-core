package de.evoal.core.main.ea.constraints.constraint;

import de.evoal.core.api.ea.constraints.model.Constraint;
import de.evoal.core.api.ea.constraints.model.Constraints;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.ea.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertiesSpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import de.evoal.core.main.ea.constraints.el.ElHelper;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.FunctionName;
import de.evoal.languages.model.el.Call;
import de.evoal.core.main.ea.constraints.constraint.ast.ConditionConverter;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
@Slf4j
public class ConstraintProducer {
    private PropertiesSpecification specification;

    @Produces
    @ApplicationScoped
    public Constraints create(final DataConstraints constraints,
                              final CustomCodec codec) {
        this.specification = specification;

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

    private Optional<Constraint> convert(final Call constraint, DataDescription context) {
        if(constraint.getParameters().size() != 2) {
            log.error("Constraint has more than two parameters. Skipping.");
            return Optional.empty();
        }

        final Constraint result = new Constraint();
        result.setGroup(ElHelper.findString(constraint.getParameters().get(1)));

        final ConditionConverter converter = new ConditionConverter(specification, context);
        converter.doSwitch(constraint.getParameters().get(0));

        result.setFunction(converter.getFunction());
        result.setUsedProperties(converter.getUsedProperties());
        result.setConstraintType(converter.getType());

        return Optional.of(result);
    }
}
