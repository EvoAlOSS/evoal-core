package de.evoal.optimisation.ea.main.statistics;

import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.optimisation.api.statistics.Candidate;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
import io.jenetics.Phenotype;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * An adapter, c.f. GOF: adapter pattern, for adapting Jenetic's {@link Phenotype} to
 *   EvoAl's {@link Candidate}.
 */
@Dependent
public class CandidateAdapter implements Candidate {

    /**
     * Generation for which the adapter was created for (necessary for calculating
     *   the candidate's age).
     */
    private int generation;

    /**
     * The candidate's phenotype.
     */
    private Phenotype<?, OptimisationValue> phenotype;

    @Inject @Named("codec")
    private CustomCodec codec;

    public CandidateAdapter init(final Phenotype<?, OptimisationValue> phenotype, final int generation) {
        this.phenotype = phenotype;
        this.generation = generation;

        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Properties searchSpaceRepresentation() {
        return (Properties) codec.decoder().apply(phenotype.genotype());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int age() {
        return (int) phenotype.age(generation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OptimisationValue value() {
        return phenotype.fitness();
    }
}
