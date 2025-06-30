package de.evoal.optimisation.local_search.main.accepting;

import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;
import de.evoal.optimisation.local_search.api.cooling.DecreasingFunction;
import de.evoal.optimisation.local_search.api.probability.AcceptanceProbabilityFunction;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Random;

@Named("de.evoal.optimisation.local_search.optimisation.simulated-annealing")
@Dependent
public class SimulatedAnnealingStrategy implements AcceptingStrategy {

    private final Random random = new Random();

    @Inject @Named("comparator")
    private OptimisationValueComparator comparator;

    @Inject
    @Named("decreasing-function")
    private DecreasingFunction coolingStrategy;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.accepting-strategy.initial-temperature")
    private double initialTemperature;

    @Inject
    @Named("optimisation-function")
    private OptimisationFunction fitness;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.maximise")
    private boolean maximise;

    @Inject
    @Named("acceptance-function")
    private AcceptanceProbabilityFunction probabilityFunction;

    private double temperature;

    @Override
    public AcceptingStrategy init(Instance configuration) throws InitializationException {
        temperature = initialTemperature;

        return this;
    }

    @Override
    public boolean acceptCandidate(final Properties candidate, final OptimisationValue bestFitnessValue) {
        final Object [] data = bestFitnessValue.toStatistics();
        double [] parameter = new double[data.length];
        for (int i = 0; i < parameter.length; i++) {
            parameter[i] = ((Number)data[i]).doubleValue();
        }

        double acceptanceProb = probabilityFunction.apply(parameter, fitness.evaluate(candidate), temperature);

        return acceptanceProb >= random.nextDouble();
    }

    @Override
    public void setIteration(int iteration, int maximum) {
        temperature = coolingStrategy.decrease(temperature, initialTemperature, iteration);
    }
}
