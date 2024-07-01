package de.evoal.optimisation.api.statistics;

import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.core.api.properties.Properties;

public class SimpleCandidate implements Candidate{

    private final Properties searchSpaceRepresentation;
    private final OptimisationValue value;
    private final int age;

    public SimpleCandidate(final Properties searchSpaceRepresentation, final OptimisationValue value, final int age) {
        this.searchSpaceRepresentation = searchSpaceRepresentation;
        this.value = value;
        this.age = age;
    }

    @Override
    public int age() {
        return age;
    }

    @Override
    public Properties searchSpaceRepresentation() {
        return searchSpaceRepresentation;
    }

    @Override
    public OptimisationValue value() {
        return value;
    }
}
