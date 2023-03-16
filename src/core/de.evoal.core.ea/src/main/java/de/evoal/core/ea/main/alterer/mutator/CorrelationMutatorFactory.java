package de.evoal.core.ea.main.alterer.mutator;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.ea.api.correlations.Correlations;
import io.jenetics.Alterer;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.function.BiFunction;

@ApplicationScoped
public final class CorrelationMutatorFactory {
    private final static Logger log = LoggerFactory.getLogger(CorrelationMutatorFactory.class);

    @Inject
    private Blackboard board;

    @Produces
    public BiFunction<Double, Double, Alterer> create(final Correlations correlations) {
        return (probability, threshold) -> new GaussianCorrelationMutator(probability, threshold, correlations);
    }
}
