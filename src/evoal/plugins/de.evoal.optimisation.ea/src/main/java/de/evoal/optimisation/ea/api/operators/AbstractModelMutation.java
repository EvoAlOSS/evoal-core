package de.evoal.optimisation.ea.api.operators;

import java.util.OptionalDouble;
import java.util.random.RandomGenerator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.ea.api.genotype.Chromosome;
import de.evoal.optimisation.ea.api.genotype.Genes;
import de.evoal.optimisation.ea.api.genotype.ModelChromosome;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;

/**
 * Base class of the structural mutations of models, e.g. the domain operators of a plugin: they
 *   change the tree of every model of a {@code 'model-chromosome'} once per application
 *   ({@link #mutateModel}), so {@code 'gene-probability'} does not apply and is rejected.
 *   Subclasses read their own attributes in {@link #configureModel}.
 */
public abstract class AbstractModelMutation extends AbstractMutation {
    /**
     * Creates a mutation that is configured by {@link #init(EObject)}.
     */
    protected AbstractModelMutation() {
    }

    /**
     * Creates a configured mutation, e.g., for tests.
     *
     * @param probability The probability that the mutation is applied to a child.
     */
    protected AbstractModelMutation(final double probability) {
        super(probability, Double.NaN);
    }

    /**
     * Rejects every chromosome but a model chromosome.
     */
    @Override
    public void check(final Chromosome chromosome) throws InitializationException {
        if(!(chromosome instanceof ModelChromosome)) {
            throw new InitializationException("The '" + name() + "' changes models, but " + chromosome + " has none.");
        }
    }

    @Override
    protected final void configure(final EObject configuration, final AttributeEvaluator attributes) throws InitializationException {
        if(geneProbability().isPresent()) {
            throw new InitializationException("The '" + name() + "' changes every model once, so it has no 'gene-probability'.");
        }

        configureModel(configuration, attributes);
    }

    /**
     * Reads the attributes of the mutation type.
     */
    protected void configureModel(final EObject configuration, final AttributeEvaluator attributes) throws InitializationException {
    }

    @Override
    public final void mutate(final Genes genes, final double geneProbability, final RandomGenerator random) {
        final ModelGenes models = (ModelGenes) genes;

        for(int model = 0; model < models.size(); ++model) {
            mutateModel(models, model, random);
        }
    }

    /**
     * Changes the tree of one model.
     *
     * @param models The genes; {@link ModelGenes#setRoot} replaces the whole model.
     * @param model The index of the model.
     * @param random The random numbers of the mutation.
     */
    protected abstract void mutateModel(ModelGenes models, int model, RandomGenerator random);

    /**
     * @return The value of the optional real attribute, empty if it is not set.
     */
    protected static OptionalDouble optionalReal(final EObject configuration, final String name, final AttributeEvaluator attributes) {
        final EStructuralFeature feature = configuration.eClass().getEStructuralFeature(name);
        if(feature == null || !configuration.eIsSet(feature)) {
            return OptionalDouble.empty();
        }

        return OptionalDouble.of(attributes.attributeToDouble(configuration, name));
    }
}
