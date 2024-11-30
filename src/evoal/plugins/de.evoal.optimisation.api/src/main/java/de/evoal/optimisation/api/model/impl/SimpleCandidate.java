package de.evoal.optimisation.api.model.impl;

import de.evoal.optimisation.api.model.Candidate;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.core.api.properties.Properties;

public record SimpleCandidate(Properties searchSpaceRepresentation,
                              OptimisationValue value,
                              int age) implements Candidate {

}
