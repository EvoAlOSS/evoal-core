package de.evoal.core.main.ddl.constraint.strategies.constraint;

import io.jenetics.Gene;
import io.jenetics.Phenotype;

public interface RepairStrategy<G extends Gene<?, G>, C extends Comparable<? super C>> {
     public Phenotype<G,C> apply(Phenotype<G,C> individual, long generation);
}
