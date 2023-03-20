package de.evoal.core.main.constraints.deviation;

import de.evoal.core.api.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import de.evoal.core.main.constraints.deviation.model.Deviation;
import de.evoal.core.main.constraints.deviation.model.Deviations;
import de.evoal.core.main.constraints.el.ElHelper;
import de.evoal.core.main.constraints.el.LogHelper;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.el.Call;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Optional;

@ApplicationScoped
@Slf4j
public class DeviationProducer {
    private PropertiesSpecification specification;

    @Produces
    @ApplicationScoped
    public Deviations create(
            final DataConstraints constraints) {
        this.specification = specification;
        final Deviations deviations = new Deviations(specification);

        constraints.stream()
                   .forEach(p -> {
                       final DataDescription context = p.getFirst();

                       p.getSecond()
                        .stream()
                        .map(ElHelper::findCall)
                        .filter(Objects::nonNull)
                        .map(Call.class::cast)
                        .filter(c -> "standardDeviation".equals(((de.evoal.languages.model.ddl.FunctionName)c.getFunction()).getDefinition().getName()))
                        .map(c -> convert(c, context))
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .forEach(deviations::add);

                   });

        return deviations;
    }

    private Optional<Deviation> convert(final Call constraint, final DataDescription context) {
        if(constraint.getParameters().size() != 2) {
            LogHelper.parameterMismatch(log, "standardDeviation", constraint, 2);
            return Optional.empty();
        }

        final String propertyName = ElHelper.findValueReference(constraint.getParameters().get(0), context);
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
