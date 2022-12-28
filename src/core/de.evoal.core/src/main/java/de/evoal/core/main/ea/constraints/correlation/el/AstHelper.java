package de.evoal.core.main.ea.constraints.correlation.el;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.main.ea.constraints.el.StringSwitch;
import de.evoal.core.api.ea.correlations.Range;
import de.evoal.languages.model.el.Expression;

public final class AstHelper {
    private AstHelper() {
    }

    public static Range findRange(final Expression expression) {
        return new RangeSwitch().doSwitch(expression);
    }

    public static int findChromosomeIndex(final PropertiesSpecification specification, final Expression expression) {
        final String name = new StringSwitch().doSwitch(expression);

        return specification.indexOf(new PropertySpecification(name));
    }
}
