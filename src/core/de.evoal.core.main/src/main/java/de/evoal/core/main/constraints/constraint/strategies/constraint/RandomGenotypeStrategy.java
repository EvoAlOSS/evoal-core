package de.evoal.core.main.constraints.constraint.strategies.constraint;

import de.evoal.core.api.constraints.strategies.RepairStrategy;
import de.evoal.core.api.optimisation.InitialCandidatesProvider;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.main.initial.RandomInitialCandidates;
import de.evoal.languages.model.base.Instance;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
@Named("repair-with-random")
public class RandomGenotypeStrategy implements RepairStrategy {

    @Inject @Named("random")
    private InitialCandidatesProvider generator;

    @Override
    public Properties apply(final Properties individual, long generation) {
        return generator.create().findFirst().get();
    }

    @Override
    public RepairStrategy init(Instance configuration) {
        return null;
    }
}
