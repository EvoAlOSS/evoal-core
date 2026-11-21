package de.evoal.optimisation.ea.main.genotype;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.ea.api.genotype.BinaryChromosome;
import de.evoal.optimisation.ea.api.genotype.Chromosome;
import de.evoal.optimisation.ea.api.genotype.DoubleChromosome;
import de.evoal.optimisation.ea.api.genotype.Genotype;
import de.evoal.optimisation.ea.api.genotype.IntegerChromosome;
import de.evoal.optimisation.ea.api.genotype.MeasurementScale;

/**
 * Creates the {@link Genotype} of the algorithm from the configured {@code genotype}.
 */
@Dependent
public class GenotypeFactory {
    @Inject
    private EAnnotationHelper annotations;

    @Inject
    private AttributeEvaluator attributes;

    @Inject
    private FeatureBoundaries boundaries;

    @Inject
    private AttributeHelper helper;

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
     * @return The chromosomes.
     * @throws InitializationException if a chromosome cannot represent its features.
     */
    public List<ConfiguredChromosome> create(final EObject genotype) throws InitializationException {
        requireBoundedFeatures();

        final List<ConfiguredChromosome> chromosomes = configured(genotype);

        try {
            new Genotype(chromosomes.stream().map(ConfiguredChromosome::chromosome).toList(), searchSpace);
        } catch(final IllegalArgumentException e) {
            throw new InitializationException(e.getMessage());
        }

        return chromosomes;
    }

    private List<ConfiguredChromosome> configured(final EObject genotype) throws InitializationException {
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
                throw new InitializationException("A bit chromosome cannot represent the feature '" + feature.getName()
                                                  + "' of type " + type.getName() + ".");
            }
        }

        try {
            return new BinaryChromosome(features, kinds, lower, upper, precision, gray);
        } catch(final IllegalArgumentException e) {
            throw new InitializationException(e.getMessage());
        }
    }

    private DoubleChromosome doubleChromosome(final List<EStructuralFeature> features) throws InitializationException {
        final double[] lower = new double[features.size()];
        final double[] upper = new double[features.size()];

        for(int i = 0; i < features.size(); ++i) {
            final EStructuralFeature feature = features.get(i);
            if(!EClassifierHelper.isDouble(feature.getEType())) {
                throw new InitializationException("A double chromosome needs real features, but '" + feature.getName()
                                                  + "' is of type " + feature.getEType().getName() + ".");
            }

            final double[] bounds = realBounds(feature);
            lower[i] = bounds[0];
            upper[i] = bounds[1];
        }

        return new DoubleChromosome(features, lower, upper);
    }

    private IntegerChromosome integerChromosome(final List<EStructuralFeature> features) throws InitializationException {
        final long[] lower = new long[features.size()];
        final long[] upper = new long[features.size()];

        for(int i = 0; i < features.size(); ++i) {
            final EStructuralFeature feature = features.get(i);
            if(!EClassifierHelper.isInteger(feature.getEType())) {
                throw new InitializationException("An integer chromosome needs integer features, but '" + feature.getName()
                                                  + "' is of type " + feature.getEType().getName() + ".");
            }

            final long[] bounds = integerBounds(feature);
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
     * @throws InitializationException if a search variable that is not boolean has no lower
     *   or no upper boundary.
     */
    private void requireBoundedFeatures() throws InitializationException {
        for(final EStructuralFeature feature : searchSpace) {
            if(!EClassifierHelper.isBoolean(feature.getEType()) && !FeatureBoundaries.isBounded(feature)) {
                throw new InitializationException("The evolutionary algorithm needs a lower and an upper boundary for every search "
                                                  + "variable, but '" + feature.getName() + "' has none.");
            }
        }
    }

    /**
     * @return The declared scale of the feature, empty if it declares none.
     */
    public Optional<MeasurementScale> scaleOf(final EStructuralFeature feature) {
        return annotations.dataDescriptionOf(feature)
                          .filter(BaseDataDescription.class::isInstance)
                          .map(BaseDataDescription.class::cast)
                          .map(BaseDataDescription::getScale)
                          .filter(scale -> scale != ScaleType.UNKNOWN)
                          .map(scale -> MeasurementScale.of(scale.getLiteral()));
    }

    /**
     * @return The search space.
     */
    public Space searchSpace() {
        return searchSpace;
    }
}
