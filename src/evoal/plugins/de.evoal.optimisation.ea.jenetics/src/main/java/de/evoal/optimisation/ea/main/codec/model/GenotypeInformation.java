package de.evoal.optimisation.ea.main.codec.model;

import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.optimisation.ea.api.codec.model.ModelChromosome;

public record GenotypeInformation(PropertySpecification searchSpaceProperty,
                                  ModelBuilder memento,
                                  ModelChromosome chromosome) {
}
