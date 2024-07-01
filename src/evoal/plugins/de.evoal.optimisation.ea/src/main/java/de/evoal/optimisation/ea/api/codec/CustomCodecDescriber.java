package de.evoal.optimisation.ea.api.codec;

import de.evoal.core.api.cdi.EvoalComponent;
import de.evoal.languages.model.base.Definition;

import java.util.List;

/**
 * Additional interface that a codec implementer has to implement to give a
 *   description of the data/instances a codec configuration maps. In case
 *   of the vector genotype codec it is the list of all used data descriptions.
 *   The describer has to expand the name of the codec by the suffix "-describer"
 *   in the @Named annotation.
 */
public interface CustomCodecDescriber extends EvoalComponent<CustomCodecDescriber> {
    /**
     * @return The mapped data.
     */
    public List<Definition> describe();
}
