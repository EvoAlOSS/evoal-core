package de.evoal.optimisation.local_search.main.accepting;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.core.exceptions.InitializationException;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.random.RandomGenerator;


import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.random.RandomService;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;
import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;
import de.evoal.optimisation.local_search.api.probability.AcceptanceProbabilityFunction;
import org.eclipse.emf.ecore.EObject;


@Named("de.evoal.optimisation.local_search.optimisation.simulated-annealing")
@Dependent
public class SimulatedAnnealingStrategy implements AcceptingStrategy {

    @Inject
    private RandomService randomService;

    private RandomGenerator random;

    @Inject
    @Named("decreasing-function")
    private DecreasingFunction coolingStrategy;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION,
                        access = "algorithm.accepting-strategy.initial-temperature")
    private double initialTemperature;

    @Inject
    @Named("acceptance-function")
    private AcceptanceProbabilityFunction probabilityFunction;

    private double temperature;

    @Override
    public AcceptingStrategy init(final EObject configuration) throws InitializationException {
        temperature = initialTemperature;
        random = randomService.random("de.evoal.optimisation.local_search.optimisation.simulated-annealing");

        return this;
    }

    /**
     * @return {@code false}: a rejection is random, a later iteration may accept a neighbour.
     */
    @Override
    public boolean rejectionIsFinal() {
        return false;
    }

    /**
     * @return {@code true}: as in the textbook version, every iteration tests a single random
     *   neighbour, so a worse neighbour is accepted with exactly the acceptance probability.
     */
    @Override
    public boolean testsSingleNeighbour() {
        return true;
    }

    @Override
    public boolean acceptCandidate(final OptimisationValue candidateValue, final OptimisationValue currentValue) {
        final double acceptanceProb = probabilityFunction.apply(currentValue, candidateValue, temperature);

        // nextDouble() is in [0, 1), so a probability of 0 never accepts and 1 always does
        return random.nextDouble() < acceptanceProb;
    }

    @Override
    public void setIteration(final int iteration) {
        temperature = coolingStrategy.decrease(temperature, initialTemperature, iteration);
    }
}
