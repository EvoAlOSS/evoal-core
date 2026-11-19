package de.evoal.optimisation.ea.api.operators;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Base class of the recombinations: reads {@code probability}. Subclasses read their own
 *   attributes in {@link #configure(EObject)}.
 */
public abstract class AbstractRecombination implements RecombinationOperator {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The probability that the recombination is applied to a pair.
     */
    private double probability = 1.0;

    /**
     * Creates a recombination that is configured by {@link #init(EObject)}.
     */
    protected AbstractRecombination() {
    }

    /**
     * Creates a configured recombination, e.g., for tests.
     */
    protected AbstractRecombination(final double probability) {
        this.probability = probability;
    }

    /**
     * Reads the attributes of the recombination type.
     */
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) throws InitializationException {
    }

    @Override
    public final RecombinationOperator init(final EObject configuration) throws InitializationException {
        probability = evaluator.attributeToDouble(configuration, "probability");
        configure(configuration, evaluator);

        return this;
    }

    @Override
    public double probability() {
        return probability;
    }

    @Override
    public String toString() {
        return name() + "(probability " + probability + ")";
    }
}
