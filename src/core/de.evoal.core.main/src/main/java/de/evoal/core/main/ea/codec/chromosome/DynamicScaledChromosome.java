package de.evoal.core.main.ea.codec.chromosome;

import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.el.IntegerLiteral;
import de.evoal.languages.model.instance.Instance;
import de.evoal.languages.model.instance.LiteralValue;
import io.jenetics.util.DoubleRange;

public abstract class DynamicScaledChromosome extends DynamicBoundedDoubleChromosome {
    protected int scale;

    @Override
    public void init(final Instance specification) {
        super.init(specification);
        Requirements.requireSize(dataRepresented, 1);
        Requirements.requireSize(ranges, 1);

        scale = ((IntegerLiteral)((LiteralValue)specification.findAttribute("scale").getValue()).getLiteral()).getValue();
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
