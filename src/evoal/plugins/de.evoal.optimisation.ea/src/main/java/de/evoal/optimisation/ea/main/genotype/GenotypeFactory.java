package de.evoal.optimisation.ea.main.genotype;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.builder.ModelTypes;
import de.evoal.optimisation.api.models.ModelCandidates;
import de.evoal.optimisation.ea.api.genotype.BinaryChromosome;
import de.evoal.optimisation.ea.api.genotype.BoundaryHandling;
import de.evoal.optimisation.ea.api.genotype.Chromosome;
import de.evoal.optimisation.ea.api.genotype.DoubleChromosome;
import de.evoal.optimisation.ea.api.genotype.Genotype;
import de.evoal.optimisation.ea.api.genotype.IntegerChromosome;
import de.evoal.optimisation.ea.api.genotype.ModelChromosome;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;

/**
 * Creates the {@link Genotype} of the algorithm from the configured {@code genotype}.
 */
@Dependent
public class GenotypeFactory {
    @Inject
    private AttributeEvaluator attributes;

    @Inject
    private FeatureBoundaries boundaries;

    @Inject
    private AttributeHelper helper;

    /**
     * The models of the search space and their tables.
     */
    @Inject
    private ModelCandidates models;

    @Inject @Named("search-space")
    private Space searchSpace;

    /**
     * A configured chromosome with its operator configurations.
     *
     * @param chromosome The chromosome.
     * @param configuration Its configuration.
     */
    public record ConfiguredChromosome(Chromosome chromosome, EObject configuration) {
    }

    /**
     * @param genotype The configured {@code genotype}.
     * @param handling The boundary handling of the algorithm; a model chromosome keeps it for
     *   the values its mutations move.
     * @return The chromosomes.
     * @throws InitializationException if a chromosome cannot represent its features. That the
     *   search variables are bounded and that every chromosome has features of its
     *   representations is checked when the configuration is loaded ({@code @RequiresBoundaries}
     *   of {@code 'evolutionary-algorithm'}, {@code @RequiresRepresentation} of the chromosomes).
     *   A model chromosome is checked here: its features have to be structured data, the models
     *   must be buildable, and every integer and real attribute of their types needs a lower
     *   and an upper boundary.
     */
    public List<ConfiguredChromosome> create(final EObject genotype, final BoundaryHandling handling) throws InitializationException {
        final List<ConfiguredChromosome> chromosomes = configured(genotype, handling);

        try {
            new Genotype(chromosomes.stream().map(ConfiguredChromosome::chromosome).toList(), searchSpace);
        } catch(final IllegalArgumentException e) {
            throw new InitializationException(e.getMessage());
        }

        return chromosomes;
    }

    private List<ConfiguredChromosome> configured(final EObject genotype, final BoundaryHandling handling) throws InitializationException {
        final List<EObject> configurations = helper.lookup(genotype, "chromosomes");
        final List<ConfiguredChromosome> chromosomes = new ArrayList<>();

        for(final EObject configuration : configurations) {
            final List<EStructuralFeature> features = new ArrayList<>();
            final List<EStructuralFeature> referenced = helper.lookup(configuration, "features");
            for(final EStructuralFeature reference : referenced) {
                features.add(searchSpace.find(reference.getName())
                                        .orElseThrow(() -> new InitializationException("The chromosome feature '" + reference.getName()
                                                                                        + "' is not a search variable.")));
            }

            final String type = DynamicEClassProvider.dlTypeOf(configuration);
            final Chromosome chromosome = switch(type.substring(type.lastIndexOf('.') + 1)) {
                case "double-chromosome" -> doubleChromosome(features);
                case "integer-chromosome" -> integerChromosome(features);
                case "bit-chromosome" -> binaryChromosome(features, attributes.attributeToInteger(configuration, "precision"), false);
                case "gray-chromosome" -> binaryChromosome(features, attributes.attributeToInteger(configuration, "precision"), true);
                case "model-chromosome" -> modelChromosome(features, handling);
                default -> throw new InitializationException("Unknown chromosome type '" + type + "'.");
            };

            chromosomes.add(new ConfiguredChromosome(chromosome, configuration));
        }

        return chromosomes;
    }

    private BinaryChromosome binaryChromosome(final List<EStructuralFeature> features, final int precision, final boolean gray)
            throws InitializationException {
        final BinaryChromosome.Kind[] kinds = new BinaryChromosome.Kind[features.size()];
        final double[] lower = new double[features.size()];
        final double[] upper = new double[features.size()];

        for(int i = 0; i < kinds.length; ++i) {
            final EStructuralFeature feature = features.get(i);
            final EClassifier type = feature.getEType();

            if(EClassifierHelper.isBoolean(type)) {
                kinds[i] = BinaryChromosome.Kind.BOOLEAN;
            } else if(EClassifierHelper.isInteger(type)) {
                kinds[i] = BinaryChromosome.Kind.INTEGER;
                final long[] bounds = integerBounds(feature);
                lower[i] = bounds[0];
                upper[i] = bounds[1];
            } else if(EClassifierHelper.isDouble(type)) {
                kinds[i] = BinaryChromosome.Kind.REAL;
                final double[] bounds = realBounds(feature);
                lower[i] = bounds[0];
                upper[i] = bounds[1];
            } else {
                // excluded when the configuration is loaded (@RequiresRepresentation)
                throw new IllegalStateException("A bit chromosome cannot represent the feature '" + feature.getName()
                                                + "' of type " + type.getName() + ".");
            }
        }

        try {
            return new BinaryChromosome(features, kinds, lower, upper, precision, gray);
        } catch(final IllegalArgumentException e) {
            throw new InitializationException(e.getMessage());
        }
    }

    private ModelChromosome modelChromosome(final List<EStructuralFeature> features, final BoundaryHandling handling)
            throws InitializationException {
        final List<String> problems = new ArrayList<>();
        final List<EClass> rootTypes = new ArrayList<>();
        for(final EStructuralFeature feature : features) {
            if(feature instanceof EReference model) {
                rootTypes.add(model.getEReferenceType());
            } else {
                problems.add("'" + feature.getName() + "' is no structured data");
            }
        }

        final ModelTypes types = models.types();
        if(problems.isEmpty()) {
            problems.addAll(types.problems());
            for(final EClass eClass : types.classes()) {
                for(final EAttribute attribute : eClass.getEAllAttributes()) {
                    final boolean isNumeric = EClassifierHelper.isInteger(attribute.getEType()) || EClassifierHelper.isDouble(attribute.getEType());
                    if(isNumeric && !FeatureBoundaries.isBounded(attribute)) {
                        problems.add("'" + eClass.getName() + "." + attribute.getName() + "' needs a lower and an upper boundary");
                    }
                }
            }
        }

        if(!problems.isEmpty()) {
            throw new InitializationException("The 'model-chromosome' of " + features.stream().map(EStructuralFeature::getName).toList()
                                              + " cannot represent its models: " + String.join("; ", problems.stream().distinct().toList())
                                              + ".");
        }

        final ModelGenes.Context context = new ModelGenes.Context(types, models.values(), boundaries, handling, rootTypes);

        return new ModelChromosome(features, context);
    }

    private DoubleChromosome doubleChromosome(final List<EStructuralFeature> features) throws InitializationException {
        final double[] lower = new double[features.size()];
        final double[] upper = new double[features.size()];

        for(int i = 0; i < features.size(); ++i) {
            final double[] bounds = realBounds(features.get(i));
            lower[i] = bounds[0];
            upper[i] = bounds[1];
        }

        return new DoubleChromosome(features, lower, upper);
    }

    private IntegerChromosome integerChromosome(final List<EStructuralFeature> features) throws InitializationException {
        final long[] lower = new long[features.size()];
        final long[] upper = new long[features.size()];

        for(int i = 0; i < features.size(); ++i) {
            final long[] bounds = integerBounds(features.get(i));
            lower[i] = bounds[0];
            upper[i] = bounds[1];
        }

        return new IntegerChromosome(features, lower, upper);
    }

    /**
     * @return The inclusive boundaries of an integer feature.
     */
    private long[] integerBounds(final EStructuralFeature feature) throws InitializationException {
        final FeatureBoundaries.Boundaries bounds = boundaries.get(feature);
        final long lower = bounds.lower().longValue() + (bounds.lowerIncluded() ? 0 : 1);
        final long upper = bounds.upper().longValue() - (bounds.UpperIncluded() ? 0 : 1);

        if(lower > upper) {
            throw new InitializationException("The feature '" + feature.getName() + "' has no valid value.");
        }

        return new long[] {lower, upper};
    }

    /**
     * @return The inclusive boundaries of a real feature; an exclusive boundary is replaced by
     *   the nearest value within.
     */
    private double[] realBounds(final EStructuralFeature feature) throws InitializationException {
        final FeatureBoundaries.Boundaries bounds = boundaries.get(feature);
        final double lower = bounds.lowerIncluded() ? bounds.lower().doubleValue() : Math.nextUp(bounds.lower().doubleValue());
        final double upper = bounds.UpperIncluded() ? bounds.upper().doubleValue() : Math.nextDown(bounds.upper().doubleValue());

        if(lower > upper) {
            throw new InitializationException("The feature '" + feature.getName() + "' has no valid value.");
        }

        return new double[] {lower, upper};
    }

    /**
     * @return The search space.
     */
    public Space searchSpace() {
        return searchSpace;
    }
}
