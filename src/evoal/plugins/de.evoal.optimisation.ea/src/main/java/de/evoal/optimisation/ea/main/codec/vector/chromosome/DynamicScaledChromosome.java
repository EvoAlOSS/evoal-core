package de.evoal.optimisation.ea.main.codec.vector.chromosome;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.info.PropertiesBoundaries;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.Instance;
import io.jenetics.util.DoubleRange;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@Slf4j
public abstract class DynamicScaledChromosome extends DynamicBoundedDoubleChromosome {
    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    private PropertiesBoundaries boundaries;

    protected int scale;

    @Override
    public DynamicChromosome init(final Instance specification) {
        scale = evaluator.attributeToInteger(specification, "scale");

        super.init(specification);
        Requirements.requireSize(dataRepresented, 1);
        Requirements.requireSize(ranges, 1);

        return this;
    }

    protected DoubleRange toRange(final DataDescription dataDescription) {
        double min = -Double.MAX_VALUE / 2;
        double max = Double.MAX_VALUE / 2;

        final PropertySpecification spec = new PropertySpecification(dataDescription.getName(), dataDescription);
        if(boundaries.contains(spec)) {
            final PropertiesBoundaries.Boundaries bounds = boundaries.get(spec);
            min = Math.max(min, bounds.lower().doubleValue());
            max = Math.min(max, bounds.upper().doubleValue());
        }

        final double scaleMax = Math.pow(2.0, scale);

        max = Math.min(max, scaleMax);
        min = Math.max(min, -scaleMax);

        log.info("Chromosome for property {} has boundaries [{},{}]", dataDescription.getName(), min, max);

        return DoubleRange.of(min, max);
    }
}
