package de.evoal.optimisation.ea.main.operators;

import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.correlations.ProblemCorrelations;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.operators.GeneExchange;
import de.evoal.optimisation.ea.api.operators.RecombinationOperator;
import de.evoal.optimisation.ea.main.correlation.CorrelationTransfer;

/**
 * Linkage crossover (DL type {@code 'linkage-crossover'}, specific to EvoAl): the wrapped
 *   {@code crossover} exchanges the genes; its probability and applicability are used.
 *   Afterwards, correlated features of the DDL are inherited from the same parent, regardless
 *   of their chromosome and representation ({@link CorrelationTransfer#link}). The linkage of
 *   a group of genes is the probability that the crossover conserves it (G. R. Harik,
 *   D. E. Goldberg: Learning linkage. Foundations of Genetic Algorithms 4, 1996,
 *   pp. 247-262, section 2); the operator conserves every correlated pair whose anchor comes
 *   from one parent. Only recombinations that exchange genes ({@link GeneExchange}) can be
 *   wrapped.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.linkage-crossover")
@Slf4j
public class LinkageCrossover implements RecombinationOperator {
    @Inject
    private FeatureBoundaries boundaries;

    @Inject
    private ProblemCorrelations correlations;

    /**
     * The recombination that exchanges the genes.
     */
    private RecombinationOperator crossover;

    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    private AttributeHelper helper;

    /**
     * Keeps correlated features together.
     */
    private CorrelationTransfer transfer;

    /**
     * Creates a crossover that is configured by {@link #init(EObject)}.
     */
    public LinkageCrossover() {
    }

    /**
     * Creates a configured crossover, e.g., for tests.
     *
     * @param crossover The recombination that exchanges the genes.
     * @param transfer Keeps correlated features together.
     * @throws IllegalArgumentException if the recombination does not exchange genes.
     */
    public LinkageCrossover(final RecombinationOperator crossover, final CorrelationTransfer transfer) {
        if(!(crossover instanceof GeneExchange)) {
            throw new IllegalArgumentException(rejection(crossover));
        }

        this.crossover = crossover;
        this.transfer = transfer;
    }

    @Override
    public RecombinationOperator init(final EObject configuration) throws InitializationException {
        crossover = BeanFactory.createComponent(RecombinationOperator.class, helper.lookup(configuration, "crossover"));
        if(!(crossover instanceof GeneExchange)) {
            throw new InitializationException(rejection(crossover));
        }

        final double minimum = evaluator.attributeToDouble(configuration, "minimum-correlation");
        transfer = new CorrelationTransfer(correlations.correlations().all(), minimum, boundaries, "linkage-crossover");
        if(transfer.correlations().isEmpty()) {
            log.warn("The 'linkage-crossover' around '{}' uses no correlation of the DDL; it only applies the wrapped "
                     + "crossover.", crossover.name());
        }

        return this;
    }

    /**
     * Keeps the correlated features of two children together.
     *
     * @param parentA The parent whose place the first child takes.
     * @param parentB The other parent.
     * @param childA The first child after the crossover; its values are changed.
     * @param childB The second child after the crossover; its values are changed.
     * @return The set features, e.g. {@code x:2 with x:1}.
     */
    public List<String> link(final TypedEObject parentA, final TypedEObject parentB, final TypedEObject childA,
                             final TypedEObject childB) {
        return transfer.link(parentA, parentB, childA, childB);
    }

    @Override
    public String name() {
        return "linkage-crossover(" + crossover.name() + ")";
    }

    @Override
    public double probability() {
        return crossover.probability();
    }

    @Override
    public void recombine(final Genes first, final Genes second, final RandomGenerator random) {
        crossover.recombine(first, second, random);
    }

    private static String rejection(final RecombinationOperator crossover) {
        return "The 'linkage-crossover' can only wrap recombinations that exchange genes (e.g. 'single-point-crossover', "
               + "'multi-point-crossover', 'uniform-crossover'), but '" + crossover.name() + "' creates new values.";
    }

    /**
     * @return Keeps correlated features together.
     */
    public CorrelationTransfer transfer() {
        return transfer;
    }
}
