package de.evoal.core.ea.main.codec.chromosome;

import de.evoal.core.api.languages.ExpressionEvaluator;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.IntegerLiteral;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.base.Literal;
import io.jenetics.util.DoubleRange;

import javax.inject.Inject;

public abstract class DynamicScaledChromosome extends DynamicBoundedDoubleChromosome {
    @Inject
    private ExpressionEvaluator evaluator;

    protected int scale;

    @Override
    public void init(final Instance specification) {
        super.init(specification);
        Requirements.requireSize(dataRepresented, 1);
        Requirements.requireSize(ranges, 1);

        scale = evaluator.attributeToInteger(specification, "scale");
    }

    protected DoubleRange toRange(final DataDescription dataDescription) {
        double min = -Double.MAX_VALUE / 2;
        double max = Double.MAX_VALUE / 2;

        final double scaleMax = Math.pow(2.0, scale);

        max = Math.min(max, scaleMax);
        min = Math.max(min, -scaleMax);

        // TODO Find actual ranges from DDL
        return DoubleRange.of(min, max);
    }
}
