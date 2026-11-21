package de.evoal.optimisation.main.stopping;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.model.StagnationMeasure;

/**
 * The mean fitness of an iteration: the mean of the fitness of all ranked members, i.e. the
 *   population that continues, not the intermediate candidates of the steps.
 */
@Dependent
@Named("de.evoal.optimisation.core.mean-fitness")
public class MeanFitnessMeasure implements StagnationMeasure {
    @Override
    public MeanFitnessMeasure init(final EObject configuration) {
        return this;
    }

    /**
     * @return The mean fitness of the members, {@code NaN} if no member has a fitness.
     */
    @Override
    public double measure(final Iteration iteration) {
        return FitnessValues.of(iteration.survivedIndividuals())
                            .average()
                            .orElse(Double.NaN);
    }
}
