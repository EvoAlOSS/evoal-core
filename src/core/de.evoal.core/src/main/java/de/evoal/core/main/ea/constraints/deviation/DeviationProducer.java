package de.evoal.core.main.ea.constraints.deviation;

import de.evoal.core.api.ea.codec.CustomCodec;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import javax.inject.Named;

import de.evoal.core.main.ea.constraints.deviation.model.Deviation;
import de.evoal.core.main.ea.constraints.deviation.model.Deviations;
import de.evoal.core.main.ea.constraints.el.ElHelper;
import de.evoal.languages.model.el.Call;
import de.evoal.languages.model.el.Expression;
import de.evoal.languages.model.el.FunctionName;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
@Slf4j
public class DeviationProducer {
    private PropertiesSpecification specification;

    @Produces
    @ApplicationScoped
    public Deviations create(
            final @Named("data-constraints") Collection<Expression> expressions,
            final CustomCodec codec) {
        this.specification = specification;
        final Deviations deviations = new Deviations(specification);

        expressions.stream()
                   .map(ElHelper::findCall)
                   .filter(Objects::nonNull)
                   .map(Call.class::cast)
                   .filter(c -> "standardDeviation".equals(((de.evoal.languages.model.ddl.FunctionName)c.getFunction()).getDefinition().getName()))
                   .map(c -> convert(c))
                   .filter(Optional::isPresent)
                   .map(Optional::get)
                   .forEach(deviations::add);

        return deviations;
    }

    private Optional<Deviation> convert(final Call constraint) {
        if(constraint.getParameters().size() != 1) {
            log.error("Deviation has more than two parameters. Skipping.");
            return Optional.empty();
        }

        final String propertyName = ElHelper.findValueReference(constraint.getParameters().get(0));
        final double deviation = ElHelper.findNumber(constraint.getParameters().get(1)).doubleValue();

        final int specIndex = specification.indexOf(propertyName);
        final PropertySpecification spec = specification.get(specIndex);

        final Deviation result = new Deviation();
        result.setSpecification(spec);
        result.setIndex(specIndex);
        result.setDeviation(deviation);

        return Optional.of(result);
    }
}
