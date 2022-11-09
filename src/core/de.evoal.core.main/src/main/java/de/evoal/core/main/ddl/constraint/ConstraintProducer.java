package de.evoal.core.main.ddl.constraint;

import de.evoal.core.api.ea.constraints.model.Constraint;
import de.evoal.core.api.ea.constraints.model.Constraints;
import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.properties.PropertiesSpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import de.evoal.core.main.ddl.constraint.ast.ConditionConverter;
import de.evoal.core.main.ddl.el.ElHelper;
import de.evoal.languages.model.ddl.FunctionName;
import de.evoal.languages.model.el.Call;
import de.evoal.languages.model.el.Expression;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Named;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
@Slf4j
public class ConstraintProducer {
    private PropertiesSpecification specification;

    @Produces
    @ApplicationScoped
    public Constraints create(final @Named("data-constraints") Collection<Expression> constraints,
                              final CustomCodec codec) {
        this.specification = specification;

        final Constraints result = new Constraints();

        constraints.stream()
                   .map(ElHelper::findCall)
                   .filter(Objects::nonNull)
                   .map(Call.class::cast)
                   .filter(c -> "constraint".equals(((FunctionName)c.getFunction()).getDefinition().getName()))
                   .map(this::convert)
                   .filter(Optional::isPresent)
                   .map(Optional::get)
                   .forEach(result.getConstraints()::add);

        log.info("Loaded {} constraints.", result.getConstraints().size());

        return result;
    }

    private Optional<Constraint> convert(final Call constraint) {
        if(constraint.getParameters().size() != 2) {
            log.error("Constraint has more than two parameters. Skipping.");
            return Optional.empty();
        }

        final Constraint result = new Constraint();
        result.setGroup(ElHelper.findString(constraint.getParameters().get(1)));

        final ConditionConverter converter = new ConditionConverter(specification);
        converter.doSwitch(constraint.getParameters().get(0));

        result.setFunction(converter.getFunction());
        result.setUsedProperties(converter.getUsedProperties());
        result.setConstraintType(converter.getType());

        return Optional.of(result);
    }
}
