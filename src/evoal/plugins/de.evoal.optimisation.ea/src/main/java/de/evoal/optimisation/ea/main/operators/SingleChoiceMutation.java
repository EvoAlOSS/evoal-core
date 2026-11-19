package de.evoal.optimisation.ea.main.operators;

import java.util.ArrayList;
import java.util.Arrays;
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
 *   chosen with the given {@code weights} (equal if empty) and applied to the child with its
 *   own gene probability; the {@code probability} of the chosen mutation is not used. It
 *   applies to the chromosomes all its children apply to.
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
     * @param weights The weight of every child; empty for equal weights.
     */
    public SingleChoiceMutation(final double probability, final List<MutationOperator> children, final double[] weights) {
        super(probability, Double.NaN);
        this.children = List.copyOf(children);
        this.weights = weights.length == 0 ? equalWeights(children.size()) : weights.clone();
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

        final double[] configured = attributes.attributeToDoubleArray(configuration, "weights");
        if(configured.length == 0) {
            weights = equalWeights(children.size());
            return;
        }

        if(configured.length != children.size()) {
            throw new InitializationException("The 'single-choice-mutation' has " + children.size() + " children, but "
                                              + configured.length + " weights.");
        }
        for(final double weight : configured) {
            if(!(weight >= 0.0)) {
                throw new InitializationException("The weights of the 'single-choice-mutation' must not be negative, but one is " + weight + ".");
            }
        }
        if(Rankings.sum(configured) <= 0.0) {
            throw new InitializationException("At least one weight of the 'single-choice-mutation' must be greater than 0.");
        }
        weights = configured;
    }

    private static double[] equalWeights(final int count) {
        final double[] equal = new double[count];
        Arrays.fill(equal, 1.0);
        return equal;
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
