package de.evoal.optimisation.ea.main.alterer.model;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.ea.api.operators.AltererComponentProvider;
import de.evoal.optimisation.ea.main.alterer.model.crossover.FeatureSwapCrossover;
import de.evoal.optimisation.ea.main.alterer.model.mutator.ArrayReorderMutator;
import de.evoal.optimisation.ea.main.alterer.model.mutator.ArraySizeMutator;
import de.evoal.optimisation.ea.main.alterer.model.mutator.LiteralMutator;
import de.evoal.languages.model.base.expressions.Instance;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
public class MutatorProducer {
    @Inject
    private AttributeHelper helper;

    private double probability(final Instance instance) {
        return helper.lookup(instance, "probability");
    }

    @Produces
    @Dependent
    @Named("de.evoal.optimisation.ea.mdo.feature-swap-crossover")
    public AltererComponentProvider createFeatureSwapCrossover() {
        return instance -> FeatureSwapCrossover.of(probability(instance));
    }

    @Produces
    @Dependent
    @Named("de.evoal.optimisation.ea.mdo.array-size-mutator")
    public AltererComponentProvider createArraySizeMutator() {
        return instance -> new ArraySizeMutator<>(probability(instance));
    }

    @Produces
    @Dependent
    @Named("de.evoal.optimisation.ea.mdo.array-reorder-mutator")
    public AltererComponentProvider createArrayReorderMutator() {
        return instance -> new ArrayReorderMutator<>(probability(instance));
    }

    @Produces
    @Dependent
    @Named("de.evoal.optimisation.ea.mdo.literal-mutator")
    public AltererComponentProvider createLiteralMutator() {
        return instance -> {
            final LiteralMutator<?> mutator = new LiteralMutator<>(probability(instance));
            BeanFactory.injectFields(mutator);
            mutator.init(instance);

            return mutator;
        };
    }
}
