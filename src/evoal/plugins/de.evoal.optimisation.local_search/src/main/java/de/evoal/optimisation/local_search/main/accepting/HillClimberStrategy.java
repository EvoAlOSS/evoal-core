package de.evoal.optimisation.local_search.main.accepting;

import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.properties.Properties;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Named("de.evoal.optimisation.local_search.optimisation.hill-climber")
@Dependent
public class HillClimberStrategy implements AcceptingStrategy {

    @Inject
    @Named("optimisation-function")
    private OptimisationFunction fitness;

    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    @Override
    public boolean acceptCandidate(final Properties candidate, final OptimisationValue bestFitnessValue) {
        final double[] candidateFitness = fitness.evaluate(candidate);
        final OptimisationValue alternateBestValue = comparator.apply(candidateFitness);

        return alternateBestValue.isBetter(bestFitnessValue);
    }
}
