package de.evoal.core.main.ea.initial;

import de.evoal.core.api.ea.initial.InitialPopulation;
import de.evoal.languages.model.instance.Instance;
import io.jenetics.Gene;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionStream;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

public class RandomInitialPopulation<G extends Gene<?, G>, C extends Comparable<C>> implements InitialPopulation<G, C> {
    @Override
    public InitialPopulation init(final Instance initialization) {
        // this is not the function you are looking for.
        return this;
    }

    @Override
    public EvolutionStream<G, C> create(final Engine<G, C> engine) {
        return engine.stream();
    }
}
