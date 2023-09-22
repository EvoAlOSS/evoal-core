package de.evoal.core.api.properties;

import org.apache.commons.math3.util.Pair;

/**
 * A pair of properties.
 */
public class PropertiesPair extends Pair<Properties, Properties> {
    public PropertiesPair(Properties properties, Properties properties2) {
        super(properties, properties2);
    }

    public PropertiesPair(Pair<? extends Properties, ? extends Properties> entry) {
        super(entry);
    }
}
