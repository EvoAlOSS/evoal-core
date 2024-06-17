package de.evoal.core.ea.main.codec.model;

import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.ea.api.codec.model.ModelChromosome;

public record GenotypeInformation(PropertySpecification searchSpaceProperty,
                                  ModelBuilder memento,
                                  ModelChromosome chromosome) {
}
