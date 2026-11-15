package de.evoal.optimisation.local_search.main.accepting;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Named("de.evoal.optimisation.local_search.optimisation.hill-climber")
@Dependent
public class HillClimberStrategy implements AcceptingStrategy {

    @Override
    public boolean acceptCandidate(final OptimisationValue candidateValue, final OptimisationValue currentValue) {
        return candidateValue.isBetter(currentValue);
    }
}
