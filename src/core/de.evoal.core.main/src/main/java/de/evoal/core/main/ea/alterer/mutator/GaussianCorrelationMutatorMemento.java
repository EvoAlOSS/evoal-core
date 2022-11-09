package de.evoal.core.main.ea.alterer.mutator;

import de.evoal.core.main.ea.functions.correlation.model.Correlation;
import lombok.Data;

import java.util.Random;

@Data
public final class GaussianCorrelationMutatorMemento implements CorrelationMutatorMemento<GaussianCorrelationMutatorMemento> {
    /**
     * Random gaussian value for altering value.
     */
    private double gaussian = new Random().nextGaussian();

    private final double threshold;

    public GaussianCorrelationMutatorMemento(final double threshold) {
        this.threshold = threshold;
    }

    @Override
    public void apply(final GaussianCorrelationMutatorMemento context, final Correlation correlation) {
        final double correlationFactor = correlation.getCorrelationFactor();

        if(correlationFactor >= threshold) {
            gaussian = context.getGaussian();
        } else if(correlationFactor >= 0.0) {
            gaussian = (context.getGaussian() + gaussian) / 2.0;
        } else if(correlationFactor > -threshold) {
            gaussian = (-context.getGaussian() + gaussian) / 2.0;
        } else {
            gaussian = -context.getGaussian();
        }
    }
}
