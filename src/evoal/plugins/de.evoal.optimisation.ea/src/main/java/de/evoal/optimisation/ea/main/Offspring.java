package de.evoal.optimisation.ea.main;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.genotype.Genome;

/**
 * A child during the variation of a generation, before it becomes a {@link Candidate}.
 */
final class Offspring {
    /**
     * The genome of the parent whose place the child takes, unchanged.
     */
    final Genome parentGenome;

    /**
     * The parents, the parent whose place the child takes first.
     */
    final List<Candidate> parents;

    /**
     * Shared with the sibling of the same recombination.
     */
    final Object pair;

    /**
     * The genome of the child.
     */
    final Genome genome;

    /**
     * The operators that changed the genome, in their order.
     */
    final List<String> operators = new ArrayList<>();

    /**
     * The features that a correlation-aware mutation changed itself, in their order.
     */
    final Set<String> primaryFeatures = new LinkedHashSet<>();

    /**
     * The changes that a correlation-aware mutation propagated, e.g. {@code x:2 from x:1 (0.9)}.
     */
    final List<String> propagatedFeatures = new ArrayList<>();

    /**
     * The features that a linkage crossover set, e.g. {@code x:2 with x:1} or
     *   {@code x:7, x:12 with x:0}.
     */
    final List<String> linkedFeatures = new ArrayList<>();

    /**
     * Whether a recombination changed the genome.
     */
    boolean recombined;

    /**
     * @return The genome of the child.
     */
    Genome genome() {
        return genome;
    }

    Offspring(final Genome parentGenome, final List<Candidate> parents, final Object pair) {
        this.parentGenome = parentGenome;
        this.parents = List.copyOf(parents);
        this.pair = pair;
        this.genome = parentGenome.copy();
    }
}
