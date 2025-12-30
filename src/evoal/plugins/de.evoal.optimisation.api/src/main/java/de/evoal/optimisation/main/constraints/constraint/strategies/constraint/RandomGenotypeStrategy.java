package de.evoal.optimisation.main.constraints.constraint.strategies.constraint;

import de.evoal.optimisation.api.constraints.strategies.RepairStrategy;
import de.evoal.core.api.properties.Properties;
import de.evoal.optimisation.main.initial.RandomInitialCandidates;
import de.evoal.languages.model.base.expressions.Instance;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.stream.Stream;

@Dependent
@Named("de.evoal.optimisation.ea.optimisation.repair-with-random")
public class RandomGenotypeStrategy implements RepairStrategy {

    @Inject //@Named("de.evoal.optimisation.core.random-population")
    private RandomInitialCandidates generator;

    @Override
    public Properties apply(final Properties individual, long generation) {
        final Stream<Properties> stream = generator.create();
        return stream.findFirst()
                     .get();
    }

    @Override
    public RepairStrategy init(Instance configuration) {
        return this;
    }
}
