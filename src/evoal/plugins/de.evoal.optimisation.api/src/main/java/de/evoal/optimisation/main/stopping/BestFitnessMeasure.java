package de.evoal.optimisation.main.stopping;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.v202704.optimisation.memory.Iteration;

import de.evoal.optimisation.api.model.StagnationMeasure;

/**
 * The best fitness of an iteration: the smallest fitness of the best individuals (rank 0),
 *   which the algorithm's comparator chose, e.g. the feasible ones first.
 */
@Dependent
@Named("de.evoal.optimisation.core.best-fitness")
public class BestFitnessMeasure implements StagnationMeasure {
    @Override
    public BestFitnessMeasure init(final EObject configuration) {
        return this;
    }

    /**
     * @return The smallest fitness of rank 0, {@code NaN} if the iteration has no ranks or no
     *   individual of rank 0 has a fitness.
     */
    @Override
    public double measure(final Iteration iteration) {
        if(iteration.getRanks().isEmpty()) {
            return Double.NaN;
        }

        return FitnessValues.of(iteration.bestIndividuals())
                            .min()
                            .orElse(Double.NaN);
    }
}
