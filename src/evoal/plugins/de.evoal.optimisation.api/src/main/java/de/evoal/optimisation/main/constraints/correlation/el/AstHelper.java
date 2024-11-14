package de.evoal.optimisation.main.constraints.correlation.el;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.languages.base.DataReferenceSwitch;
import de.evoal.optimisation.api.correlations.Range;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.Expression;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class AstHelper {
    private AstHelper() {
    }

    public static Range findRange(final Expression expression) {
        return new RangeSwitch().doSwitch(expression);
    }

    public static int findChromosomeIndex(final PropertiesSpecification specification, final Expression expression) {
        final DataDescription data = new DataReferenceSwitch().doSwitch(expression);
        final String name = data.getName();

        log.info("Looking up index of {} in  {}.", name, specification);

        return specification.indexOf(name);
    }
}
