package de.evoal.optimisation.main.constraints.deviation.model;

import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Deviations {
    private final PropertiesSpecification specification;

    private final List<Optional<Double>> standardDeviations = new ArrayList<>();

    public Deviations(final PropertiesSpecification specification) {
        this.specification = specification;
        for(int i = 0; i < specification.size(); ++i) {
            standardDeviations.add(Optional.empty());
        }
    }

    public void add(final Deviation deviation) {
        standardDeviations.set(deviation.getIndex(), Optional.of(deviation.getDeviation()));
    }

    public Optional<Double> find(final int propertyIndex) {
        return standardDeviations.get(propertyIndex);
    }

    public Optional<Double> find(final PropertySpecification spec) {
        return standardDeviations.get(specification.indexOf(spec));
    }
}
