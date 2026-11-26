package de.evoal.pipeline.impl.components.statistics;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.optimisation.api.correlations.CorrelationEstimate;
import de.evoal.optimisation.api.correlations.CorrelationEstimator;
import de.evoal.optimisation.api.correlations.CorrelationKind;
import de.evoal.optimisation.api.correlations.CorrelationRange;
import de.evoal.optimisation.api.correlations.RankStandardError;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.pipeline.api.model.PipelineSink;
import de.evoal.pipeline.api.values.PipelineValues;

/**
 * Estimates the correlation of every pair of the features it reads when the stream has ended
 *   (DL type {@code 'correlation-estimation'}) and publishes the estimates as a named
 *   {@link PipelineValues pipeline value}: a list with one map per estimate. The computation is
 *   the one of {@code 'correlation-statistics'} ({@link CorrelationEstimator}).
 * <ul>
 *   <li>The kind of a pair follows from the DDL scales of its features
 *     ({@link CorrelationKind#of}); pairs with a nominal feature are skipped.</li>
 *   <li>A row without a (finite) value of one of the two features is left out for that pair
 *     only.</li>
 *   <li>Every pair gets an estimate on all rows and, if both features have ranges, one per
 *     combination of their ranges.</li>
 *   <li>Estimates with a smaller absolute coefficient than {@code 'minimum-correlation'}, and
 *     estimates without a coefficient (fewer than two rows, a constant feature), are left
 *     out.</li>
 * </ul>
 */
@Dependent
@Named("de.evoal.pipeline.statistics.correlation-estimation")
@Slf4j
public class CorrelationEstimation extends PipelineComponentImpl implements PipelineSink {
    @Inject
    private EAnnotationHelper annotations;

    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The confidence level of the intervals.
     */
    private double confidenceLevel;

    /**
     * The features, in the order of {@code reads}.
     */
    private final List<EStructuralFeature> features = new ArrayList<>();

    /**
     * The scales of the features.
     */
    private final List<ScaleType> scales = new ArrayList<>();

    /**
     * Estimates with a smaller absolute coefficient are left out.
     */
    private double minimumCorrelation;

    /**
     * The variance of a Spearman correlation.
     */
    private RankStandardError rankError;

    /**
     * The ranges per feature.
     */
    private final Map<EStructuralFeature, List<CorrelationRange>> ranges = new LinkedHashMap<>();

    /**
     * The name of the pipeline value that holds the estimates.
     */
    private String result;

    /**
     * The values of the features per row, NaN for a missing value.
     */
    private final List<double[]> rows = new ArrayList<>();

    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject object) {
        final double[] row = new double[features.size()];
        for(int i = 0; i < row.length; ++i) {
            // an unset feature has no value (eGet would give its default, e.g. 0.0); a set 0.0
            //   is a value, since the data attributes are unsettable (#355)
            final EStructuralFeature feature = features.get(i);
            row[i] = object.eIsSet(feature) ? valueOf(object.eGet(feature)) : Double.NaN;
        }
        rows.add(row);

        return object;
    }

    /**
     * @throws InitializationException if the step writes data, reads fewer than two data,
     *   reads data that is neither numeric nor nominal, or a range belongs to data the step
     *   does not read.
     */
    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        if(!isEmpty(getWrites())) {
            throw new InitializationException("'correlation-estimation' writes no data; remove its 'writes'.");
        }

        for(final EStructuralFeature feature : getReads()) {
            features.add(feature);
            scales.add(scaleOf(feature));
        }
        checkFeatures(features, scales);

        result = evaluator.attributeToString(configuration, "result");
        minimumCorrelation = evaluator.attributeToDouble(configuration, "minimum-correlation");
        confidenceLevel = evaluator.attributeToDouble(configuration, "confidence-level");
        if(!(0.0 < confidenceLevel && confidenceLevel < 1.0)) {
            throw new InitializationException("The 'confidence-level' of 'correlation-estimation' must lie in (0, 1), "
                                              + "but is " + confidenceLevel + ".");
        }

        try {
            rankError = RankStandardError.ofTypeName(evaluator.attributeToEObject(configuration, "confidence-interval")
                                                              .eClass()
                                                              .getName());
            readRanges(configuration);
        } catch(final IllegalArgumentException e) {
            throw new InitializationException(e.getMessage(), e);
        }

        return this;
    }

    /**
     * @throws InitializationException if there are fewer than two features or a feature is
     *   neither numeric nor nominal.
     */
    static void checkFeatures(final List<EStructuralFeature> features, final List<ScaleType> scales)
            throws InitializationException {
        if(features.size() < 2) {
            throw new InitializationException("'correlation-estimation' needs at least two data in its 'reads', but has "
                                              + features.size() + ".");
        }
        for(int i = 0; i < features.size(); ++i) {
            if(scales.get(i) != ScaleType.NOMINAL && !isNumeric(features.get(i).getEType())) {
                throw new InitializationException("'correlation-estimation' cannot estimate correlations of '"
                                                  + features.get(i).getName() + "': its values are no numbers (e.g. an "
                                                  + "ordinal enum). Only nominal data may be non-numeric; its pairs are "
                                                  + "skipped.");
            }
        }
    }

    /**
     * Configures the estimation without a DL configuration, e.g., for tests.
     *
     * @param features The features, in the order of the pairs.
     * @param featureScales The scales of the features.
     * @param resultName The name of the pipeline value.
     * @param minimum The minimum absolute coefficient.
     * @param level The confidence level.
     * @param method The variance of a Spearman correlation.
     * @param featureRanges The ranges per feature.
     * @return This component.
     * @throws InitializationException if the features cannot be estimated.
     */
    CorrelationEstimation configure(final List<EStructuralFeature> features, final List<ScaleType> featureScales,
                                    final String resultName, final double minimum, final double level,
                                    final RankStandardError method,
                                    final Map<EStructuralFeature, List<CorrelationRange>> featureRanges)
            throws InitializationException {
        checkFeatures(features, featureScales);
        this.features.addAll(features);
        this.scales.addAll(featureScales);
        this.result = resultName;
        this.minimumCorrelation = minimum;
        this.confidenceLevel = level;
        this.rankError = method;
        this.ranges.putAll(featureRanges);

        return this;
    }

    @Override
    public void streamEnded() {
        final List<Map<String, Object>> estimates = new ArrayList<>();

        for(int i = 0; i < features.size(); ++i) {
            for(int j = i + 1; j < features.size(); ++j) {
                final CorrelationKind kind = CorrelationKind.of(scales.get(i), scales.get(j));
                if(kind == CorrelationKind.NOMINAL) {
                    log.info("Skipping '{}' and '{}': nominal data have no order.", features.get(i).getName(),
                             features.get(j).getName());
                    continue;
                }

                estimate(i, j, kind, null, null).ifPresent(estimates::add);
                for(final CorrelationRange first : ranges.getOrDefault(features.get(i), List.of())) {
                    for(final CorrelationRange second : ranges.getOrDefault(features.get(j), List.of())) {
                        estimate(i, j, kind, first, second).ifPresent(estimates::add);
                    }
                }
            }
        }

        log.info("Estimated {} correlations from {} rows.", estimates.size(), rows.size());
        PipelineValues.of(getContext()).put(result, estimates);
    }

    /**
     * @return The estimate of the pair in the ranges (all rows without ranges), empty if it is
     *   left out.
     */
    private Optional<Map<String, Object>> estimate(final int i, final int j, final CorrelationKind kind,
                                                            final CorrelationRange firstRange,
                                                            final CorrelationRange secondRange) {
        final List<double[]> pairs = new ArrayList<>();
        for(final double[] row : rows) {
            final double first = row[i];
            final double second = row[j];
            if(Double.isNaN(first) || Double.isNaN(second)) {
                continue;
            }
            if(firstRange != null && !(firstRange.contains(first) && secondRange.contains(second))) {
                continue;
            }
            pairs.add(new double[] {first, second});
        }

        final double[] firstValues = pairs.stream().mapToDouble(p -> p[0]).toArray();
        final double[] secondValues = pairs.stream().mapToDouble(p -> p[1]).toArray();
        final CorrelationEstimate estimate = CorrelationEstimator.estimate(kind, firstValues, secondValues,
                                                                           confidenceLevel, rankError);
        final String description = "'" + features.get(i).getName() + "' and '" + features.get(j).getName() + "'"
                                   + (firstRange == null ? "" : " in " + firstRange + " x " + secondRange);

        if(estimate.coefficient() == null) {
            log.warn("The correlation of {} cannot be estimated from {} rows (too few rows or a constant feature).",
                     description, estimate.n());
            return Optional.empty();
        }
        if(Math.abs(estimate.coefficient()) < minimumCorrelation) {
            log.info("Leaving out the correlation {} of {} (below 'minimum-correlation').", estimate.coefficient(),
                     description);
            return Optional.empty();
        }

        final Map<String, Object> entry = new LinkedHashMap<>();
        entry.put("first", features.get(i).getName());
        entry.put("second", features.get(j).getName());
        entry.put("firstLower", firstRange == null ? null : firstRange.lower());
        entry.put("firstUpper", firstRange == null ? null : firstRange.upper());
        entry.put("secondLower", secondRange == null ? null : secondRange.lower());
        entry.put("secondUpper", secondRange == null ? null : secondRange.upper());
        entry.put("ranged", firstRange != null);
        entry.put("kind", kind == CorrelationKind.RANK ? "spearman" : "pearson");
        entry.put("n", estimate.n());
        entry.put("coefficient", estimate.coefficient());
        entry.put("absoluteCoefficient", Math.abs(estimate.coefficient()));
        entry.put("confidenceLower", estimate.confidenceLower());
        entry.put("confidenceUpper", estimate.confidenceUpper());
        entry.put("confidenceLevel", confidenceLevel);
        entry.put("intervalMethod", kind == CorrelationKind.RANK ? rankError.typeName() : "fisher");

        return Optional.of(entry);
    }

    private static boolean isEmpty(final Space space) {
        return space == null || space.isEmpty();
    }

    private static boolean isNumeric(final EClassifier type) {
        final EcorePackage ecore = EcorePackage.eINSTANCE;

        return type == ecore.getEDouble() || type == ecore.getEDoubleObject()
               || type == ecore.getEFloat() || type == ecore.getEFloatObject()
               || type == ecore.getEInt() || type == ecore.getEIntegerObject()
               || type == ecore.getELong() || type == ecore.getELongObject()
               || type == ecore.getEShort() || type == ecore.getEShortObject()
               || type == ecore.getEByte() || type == ecore.getEByteObject()
               || type != null && type.getInstanceClass() != null && Number.class.isAssignableFrom(type.getInstanceClass());
    }

    /**
     * @return The feature of {@code reads} that a {@code data} attribute names.
     * @throws IllegalArgumentException if the step does not read it.
     */
    private EStructuralFeature readFeatureOf(final Object value) {
        final String name;
        if(value instanceof EStructuralFeature feature) {
            name = feature.getName();
        } else if(value instanceof DataDescription description) {
            name = description.getName();
        } else {
            throw new IllegalArgumentException("A 'feature-range' needs a 'feature' := data '…';.");
        }

        return features.stream()
                       .filter(feature -> feature.getName().equals(name))
                       .findFirst()
                       .orElseThrow(() -> new IllegalArgumentException("The range of '" + name + "' belongs to data that "
                                                                       + "'correlation-estimation' does not read."));
    }

    private void readRanges(final EObject configuration) {
        final EStructuralFeature attribute = configuration.eClass().getEStructuralFeature("ranges");
        final Object value = configuration.eGet(attribute);
        if(value == null || value instanceof List<?> list && list.isEmpty()) {
            return;
        }

        for(final EObject range : evaluator.attributeToEObjectArray(configuration, "ranges")) {
            final EStructuralFeature feature = readFeatureOf(range.eGet(range.eClass().getEStructuralFeature("feature")));
            final CorrelationRange bounds = new CorrelationRange(evaluator.attributeToDouble(range, "lower"),
                                                                 evaluator.attributeToDouble(range, "upper"));
            ranges.computeIfAbsent(feature, f -> new ArrayList<>()).add(bounds);
        }
    }

    private ScaleType scaleOf(final EStructuralFeature feature) {
        return annotations.dataDescriptionOf(feature)
                          .filter(BaseDataDescription.class::isInstance)
                          .map(BaseDataDescription.class::cast)
                          .map(BaseDataDescription::getScale)
                          .orElse(ScaleType.UNKNOWN);
    }

    /**
     * @return The value as a double, NaN if it is missing or no finite number.
     */
    private static double valueOf(final Object value) {
        if(!(value instanceof Number number)) {
            return Double.NaN;
        }

        final double result = number.doubleValue();

        return Double.isFinite(result) ? result : Double.NaN;
    }
}
