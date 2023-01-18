package de.evoal.core.api.ea.constraints.strategies;

import de.evoal.languages.model.instance.Instance;
import io.jenetics.Gene;
import io.jenetics.Phenotype;

/**
 * Repair strategy used by kill-at-birth.
 * @param <G>
 * @param <C>
 */
public interface RepairStrategy<G extends Gene<?, G>, C extends Comparable<? super C>> {
     public Phenotype<G,C> apply(Phenotype<G,C> individual, long generation);

    RepairStrategy init(final Instance configuration);
}
