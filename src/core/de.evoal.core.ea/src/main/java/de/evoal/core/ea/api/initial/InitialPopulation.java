package de.evoal.core.ea.api.initial;

import de.evoal.languages.model.instance.Instance;
import io.jenetics.Gene;
import io.jenetics.engine.Engine;
import io.jenetics.engine.EvolutionStream;

public interface InitialPopulation<G extends Gene<?, G>, C extends Comparable<C>> {
    InitialPopulation init(final Instance initialization);

    public EvolutionStream<G, C> create(final Engine<G, C> engine);
}
