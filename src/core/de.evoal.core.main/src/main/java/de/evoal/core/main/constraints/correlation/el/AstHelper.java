package de.evoal.core.main.constraints.correlation.el;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.main.constraints.el.DataReferenceSwitch;
import de.evoal.core.api.correlations.Range;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.Expression;

public final class AstHelper {
    private AstHelper() {
    }

    public static Range findRange(final Expression expression) {
        return new RangeSwitch().doSwitch(expression);
    }

    public static int findChromosomeIndex(final PropertiesSpecification specification, final Expression expression) {
        final DataDescription data = new DataReferenceSwitch().doSwitch(expression);

        return specification.indexOf(data.getName());
    }
}
