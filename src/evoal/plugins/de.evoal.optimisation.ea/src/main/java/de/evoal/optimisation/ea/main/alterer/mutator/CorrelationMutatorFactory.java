package de.evoal.optimisation.ea.main.alterer.mutator;

import de.evoal.core.api.board.Blackboard;
import de.evoal.optimisation.api.correlations.Correlations;
import de.evoal.optimisation.ea.api.codec.CustomCodec;
import io.jenetics.Alterer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.function.BiFunction;

@ApplicationScoped
public final class CorrelationMutatorFactory {
    private final static Logger log = LoggerFactory.getLogger(CorrelationMutatorFactory.class);

    @Inject
    private Blackboard board;

    @Inject @Named("codec")
    private CustomCodec codec;

    @Produces
    public BiFunction<Double, Double, Alterer> create(final Correlations correlations) {
        return (probability, threshold) -> new GaussianCorrelationMutator(probability, threshold, correlations, codec);
    }
}
