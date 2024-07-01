package de.evoal.optimisation.main.constraints.deviation;

import de.evoal.optimisation.api.constraints.model.DataConstraints;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import de.evoal.optimisation.main.constraints.deviation.model.Deviation;
import de.evoal.optimisation.main.constraints.deviation.model.Deviations;
import de.evoal.core.api.languages.base.BaseLanguageHelper;
import de.evoal.core.api.languages.base.LogHelper;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.Call;
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
                        .map(BaseLanguageHelper::findCall)
                        .filter(Objects::nonNull)
                        .map(Call.class::cast)
                        .filter(c -> "standardDeviation".equals(((de.evoal.languages.model.base.DefinedFunctionName)c.getFunction()).getDefinition().getName()))
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

        final String propertyName = BaseLanguageHelper.findValueReference(constraint.getParameters().get(0), context);
        final double deviation = BaseLanguageHelper.findNumber(constraint.getParameters().get(1)).doubleValue();

        final int specIndex = specification.indexOf(propertyName);
        final PropertySpecification spec = specification.get(specIndex);

        final Deviation result = new Deviation();
        result.setSpecification(spec);
        result.setIndex(specIndex);
        result.setDeviation(deviation);

        return Optional.of(result);
    }
}
