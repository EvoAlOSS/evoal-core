package de.evoal.optimisation.ea.main.operators;

import java.util.List;
import java.util.OptionalDouble;
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
import de.evoal.optimisation.ea.api.operators.MutationOperator;
import de.evoal.optimisation.ea.main.correlation.CorrelationTransfer;

/**
 * Correlation-aware mutation (DL type {@code 'correlation-aware-mutation'}, specific to
 *   EvoAl): the wrapped {@code mutation} makes the primary change; its probability, gene
 *   probability and applicability are used. Afterwards, the change of every feature is
 *   propagated to the features correlated with it in the DDL ({@link CorrelationTransfer}),
 *   regardless of their chromosome and representation, up to {@code 'propagation-depth'}
 *   steps. The propagation is deterministic.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.correlation-aware-mutation")
@Slf4j
public class CorrelationAwareMutation implements MutationOperator {
    @Inject
    private FeatureBoundaries boundaries;

    @Inject
    private ProblemCorrelations correlations;

    /**
     * The number of propagation steps.
     */
    private int depth = 1;

    @Inject
    private AttributeEvaluator evaluator;

    @Inject
    private AttributeHelper helper;

    /**
     * The mutation that makes the primary change.
     */
    private MutationOperator mutation;

    /**
     * Transfers the changes along the correlations.
     */
    private CorrelationTransfer transfer;

    /**
     * Creates a mutation that is configured by {@link #init(EObject)}.
     */
    public CorrelationAwareMutation() {
    }

    /**
     * Creates a configured mutation, e.g., for tests.
     *
     * @param mutation The mutation that makes the primary change.
     * @param transfer Transfers the changes along the correlations.
     * @param depth The number of propagation steps, at least 1.
     */
    public CorrelationAwareMutation(final MutationOperator mutation, final CorrelationTransfer transfer, final int depth) {
        this.mutation = mutation;
        this.transfer = transfer;
        this.depth = depth;
    }

    /**
     * @return This mutation around the mutation the wrapped one chooses.
     */
    @Override
    public MutationOperator choose(final RandomGenerator random) {
        final MutationOperator chosen = mutation.choose(random);

        return chosen == mutation ? this : new CorrelationAwareMutation(chosen, transfer, depth);
    }

    @Override
    public OptionalDouble geneProbability() {
        return mutation.geneProbability();
    }

    @Override
    public MutationOperator init(final EObject configuration) throws InitializationException {
        mutation = BeanFactory.createComponent(MutationOperator.class, helper.lookup(configuration, "mutation"));
        depth = evaluator.attributeToInteger(configuration, "propagation-depth");

        final double minimum = evaluator.attributeToDouble(configuration, "minimum-correlation");
        transfer = new CorrelationTransfer(correlations.correlations().all(), minimum, boundaries, "correlation-aware-mutation");
        if(transfer.correlations().isEmpty()) {
            log.warn("The 'correlation-aware-mutation' around '{}' uses no correlation of the DDL; it only applies the "
                     + "wrapped mutation.", mutation.name());
        }

        return this;
    }

    @Override
    public void mutate(final Genes genes, final double geneProbability, final RandomGenerator random) {
        mutation.mutate(genes, geneProbability, random);
    }

    /**
     * @return The wrapped mutation.
     */
    public MutationOperator mutation() {
        return mutation;
    }

    @Override
    public String name() {
        return "correlation-aware-mutation(" + mutation.name() + ")";
    }

    @Override
    public double probability() {
        return mutation.probability();
    }

    /**
     * Propagates the changes of the wrapped mutation.
     *
     * @param before The candidate before the mutation.
     * @param after The candidate after the mutation; the propagated values are written into it.
     * @return The propagated changes, e.g. {@code x:2 from x:1 (0.9)}.
     */
    public List<String> propagate(final TypedEObject before, final TypedEObject after) {
        return transfer.propagate(before, after, depth);
    }

    /**
     * @return Transfers the changes along the correlations.
     */
    public CorrelationTransfer transfer() {
        return transfer;
    }
}
