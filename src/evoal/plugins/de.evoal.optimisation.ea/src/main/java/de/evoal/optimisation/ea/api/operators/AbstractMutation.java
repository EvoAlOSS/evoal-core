package de.evoal.optimisation.ea.api.operators;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.random.RandomGenerator;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.builder.AttributeSlots.Slot;
import de.evoal.optimisation.ea.api.genotype.Chromosome;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.ModelChromosome;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;

/**
 * Base class of the mutations: reads {@code probability} and {@code 'gene-probability'}.
 *   Subclasses read their own attributes in {@link #configure} and change single genes in
 *   {@link #mutate}.
 * <p>
 * A value mutation that also changes models names the attributes it applies to
 *   ({@link #modelAttributes}); the genes of a model are then its attribute values of these
 *   attributes ({@link ModelGenes#slots}), each changed with the gene probability
 *   ({@link #mutateModel}), and the default gene probability counts them.
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

    /**
     * Rejects a model chromosome if the mutation does not change models or the models have no
     *   attribute it applies to.
     */
    @Override
    public void check(final Chromosome chromosome) throws InitializationException {
        if(!(chromosome instanceof ModelChromosome model)) {
            return;
        }

        final Optional<Predicate<EAttribute>> applies = modelAttributes(model.context());
        if(applies.isEmpty()) {
            throw new InitializationException("The '" + name() + "' cannot change the models of " + chromosome + ".");
        }

        final boolean changesAnything = model.context()
                                             .types()
                                             .classes()
                                             .stream()
                                             .flatMap(eClass -> eClass.getEAllAttributes().stream())
                                             .anyMatch(applies.get());
        if(!changesAnything) {
            throw new InitializationException("The '" + name() + "' of " + chromosome + " would never change anything: "
                                              + "the models have no attribute it applies to.");
        }
    }

    /**
     * {@inheritDoc}
     * <p>
     * For the genes of a model, the number of its attribute values the mutation applies to.
     */
    @Override
    public int geneCount(final Genes genes) {
        if(genes instanceof ModelGenes models) {
            return modelSlots(models).size();
        }

        return genes.size();
    }

    /**
     * @param context The context of the models.
     * @return The attributes of a model whose values the mutation changes; empty if the mutation
     *   does not change models.
     */
    protected Optional<Predicate<EAttribute>> modelAttributes(final ModelGenes.Context context) {
        return Optional.empty();
    }

    /**
     * Changes the attribute values of the models that the mutation applies to, each with the
     *   gene probability, one draw per value in the order of {@link ModelGenes#slots}.
     *
     * @param models The genes of the models.
     * @param geneProbability The probability that a value is changed.
     * @param random The random numbers of the mutation.
     * @param change Changes one value.
     */
    protected final void mutateModel(final ModelGenes models, final double geneProbability, final RandomGenerator random,
                                     final SlotChange change) {
        for(final Slot slot : modelSlots(models)) {
            if(random.nextDouble() < geneProbability) {
                change.apply(slot, models.context(), random);
            }
        }
    }

    private List<Slot> modelSlots(final ModelGenes models) {
        final Predicate<EAttribute> applies = modelAttributes(models.context()).orElse(attribute -> false);

        return models.slots(slot -> applies.test(slot.attribute()));
    }

    /**
     * Changes one attribute value of a model.
     */
    @FunctionalInterface
    protected interface SlotChange {
        /**
         * @param slot The value.
         * @param context The context of the models.
         * @param random The random numbers of the mutation.
         */
        void apply(Slot slot, ModelGenes.Context context, RandomGenerator random);
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
