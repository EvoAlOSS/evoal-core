package de.evoal.optimisation.api.producer;

import jakarta.enterprise.inject.Produces;
import lombok.Setter;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.models.core.ecore.Space;

@ApplicationScoped
public class SpaceProducer {
    @Setter
    private Space optimisationSpace;

    @Setter
    private Space searchSpace;

    @Produces @Dependent @Named("optimisation-space")
    public Space optimisationSpace() {
        return optimisationSpace;
    }

    @Produces @Dependent @Named("search-space")
    public Space searchSpace() {
        return searchSpace;
    }
}
