package de.evoal.core.main.ea.constraints.deviation.model;

import de.evoal.core.api.properties.PropertySpecification;
import lombok.Data;

@Data
public class Deviation {
    /**
     * The configured deviation value.
     */
    private double deviation;

    /**
     * Index of the property.
     */
    private int index;

    /**
     * The property specification of the used property.
     */
    private PropertySpecification specification;
}
