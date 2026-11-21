package de.evoal.optimisation.ea.main.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.operators.AbstractMutation;
import de.evoal.optimisation.ea.api.operators.MutationOperator;
import de.evoal.optimisation.ea.api.selection.Rankings;

/**
 * Single-choice mutation (DL type {@code 'single-choice-mutation'}, specific to EvoAl): if it
 *   fires ({@code probability}, one draw per child), exactly one of its {@code children} is
 *   chosen with the given {@code weights} (one per child) and applied to the child with its
 *   own gene probability; the {@code probability} of the chosen mutation is not used. It
 *   applies to a chromosome all its children apply to.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.single-choice-mutation")
public class SingleChoiceMutation extends AbstractMutation {
    @Inject
    private AttributeHelper helper;

    /**
     * The configurations of the children, empty if the mutation was created in Java.
     */
    private List<EObject> configurations = List.of();

    /**
     * The mutations to choose from.
     */
    private List<MutationOperator> children = List.of();

    /**
     * The weight of every child.
     */
    private double[] weights = new double[0];

    public SingleChoiceMutation() {
    }

    /**
     * @param probability The probability that the mutation fires.
     * @param children The mutations to choose from.
     * @param weights The weight of every child.
     * @throws IllegalArgumentException if the weights are not valid ({@link #checkWeights}).
     */
    public SingleChoiceMutation(final double probability, final List<MutationOperator> children, final double[] weights) {
        super(probability, Double.NaN);
        this.children = List.copyOf(children);
        try {
            this.weights = checkWeights(weights, children.size());
        } catch(final InitializationException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    @Override
    public MutationOperator choose(final RandomGenerator random) {
        return children.get(Rankings.draw(weights, Rankings.sum(weights), random)).choose(random);
    }

    /**
     * @return The configurations of the children, for their applicability.
     */
    public List<EObject> childConfigurations() {
        return configurations;
    }

    @Override
    protected void configure(final EObject configuration, final AttributeEvaluator attributes) throws InitializationException {
        configurations = List.copyOf(helper.<List<EObject>>lookup(configuration, "children"));

        final List<MutationOperator> created = new ArrayList<>();
        for(final EObject child : configurations) {
            created.add(BeanFactory.createComponent(MutationOperator.class, child));
        }
        children = List.copyOf(created);

        weights = checkWeights(attributes.attributeToDoubleArray(configuration, "weights"), children.size());
    }

    /**
     * @param weights The configured weights.
     * @param children The number of children.
     * @return A copy of the weights.
     * @throws InitializationException if there is not exactly one weight per child, a weight
     *   is negative, or no weight is greater than 0.
     */
    static double[] checkWeights(final double[] weights, final int children) throws InitializationException {
        if(weights.length != children) {
            throw new InitializationException("The 'single-choice-mutation' needs one weight per child: it has " + children
                                              + " children, but " + weights.length + " weights.");
        }
        for(final double weight : weights) {
            if(!(weight >= 0.0)) {
                throw new InitializationException("The weights of the 'single-choice-mutation' must not be negative, but one is " + weight + ".");
            }
        }
        if(Rankings.sum(weights) <= 0.0) {
            throw new InitializationException("At least one weight of the 'single-choice-mutation' must be greater than 0.");
        }

        return weights.clone();
    }

    /**
     * Not used: the algorithm applies the chosen child ({@link #choose}).
     *
     * @throws UnsupportedOperationException always.
     */
    @Override
    public void mutate(final Genes genes, final double geneProbability, final RandomGenerator random) {
        throw new UnsupportedOperationException("The 'single-choice-mutation' applies the chosen child.");
    }

    @Override
    public String name() {
        return "single-choice-mutation";
    }
}
