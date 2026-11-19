package de.evoal.optimisation.ea.api.operators;

import java.util.OptionalDouble;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * Base class of the mutations: reads {@code probability} and {@code 'gene-probability'}.
 *   Subclasses read their own attributes in {@link #configure} and change single genes in
 *   {@link #mutate}.
 */
public abstract class AbstractMutation implements MutationOperator {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The configured gene probability, {@code NaN} for the default.
     */
    private double geneProbability = Double.NaN;

    /**
     * The probability that the mutation is applied to a child.
     */
    private double probability = 1.0;

    /**
     * Creates a mutation that is configured by {@link #init(EObject)}.
     */
    protected AbstractMutation() {
    }

    /**
     * Creates a configured mutation, e.g., for tests.
     *
     * @param probability The probability that the mutation is applied to a child.
     * @param geneProbability The probability that a gene is changed, {@code NaN} for the
     *   default.
     */
    protected AbstractMutation(final double probability, final double geneProbability) {
        this.probability = probability;
        this.geneProbability = geneProbability;
    }

    /**
     * Reads the attributes of the mutation type.
     */
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) throws InitializationException {
    }

    @Override
    public OptionalDouble geneProbability() {
        return Double.isNaN(geneProbability) ? OptionalDouble.empty() : OptionalDouble.of(geneProbability);
    }

    @Override
    public final MutationOperator init(final EObject configuration) throws InitializationException {
        probability = evaluator.attributeToDouble(configuration, "probability");

        final EStructuralFeature feature = configuration.eClass().getEStructuralFeature("gene-probability");
        if(feature != null && configuration.eIsSet(feature)) {
            geneProbability = evaluator.attributeToDouble(configuration, "gene-probability");
        }

        configure(configuration, evaluator);

        return this;
    }

    @Override
    public double probability() {
        return probability;
    }

    @Override
    public String toString() {
        return name() + "(probability " + probability + ", gene probability "
               + (Double.isNaN(geneProbability) ? "1/n" : geneProbability) + ")";
    }
}
