package de.evoal.optimisation.api.fitness;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.evaluation.SampleAggregation;
import lombok.NonNull;

/**
 * The samples of the objectives of a candidate: the results of all evaluations of the
 *   candidate ({@link de.evoal.optimisation.api.evaluation.EvaluationStrategy}) and their
 *   aggregate, which is the output of the {@link Evaluation}.
 * <p>
 * With one sample and no aggregation ({@link #single}), the aggregate is the sample itself
 *   and nothing is recorded. Otherwise every objective is aggregated over the samples, and
 *   the memory model records the number of samples ({@value #SAMPLES}) and, from two samples
 *   on, the sample standard deviation of every objective ({@value #STANDARD_DEVIATIONS}, in
 *   the order of the objectives).
 */
public final class ObjectiveSamples {
    /**
     * The property of an individual with the number of samples.
     */
    public static final String SAMPLES = "samples";

    /**
     * The property of an individual with the sample standard deviations of the objectives.
     */
    public static final String STANDARD_DEVIATIONS = "objective-standard-deviations";

    /**
     * The results of the evaluations, in their order.
     */
    private final List<TypedEObject> samples;

    /**
     * How the samples are aggregated, {@code null} for a single sample that is not recorded.
     */
    private final SampleAggregation aggregation;

    /**
     * The aggregate of the samples.
     */
    private final TypedEObject aggregate;

    private ObjectiveSamples(final List<TypedEObject> samples, final SampleAggregation aggregation) {
        if(samples.isEmpty()) {
            throw new IllegalArgumentException("A candidate has at least one sample.");
        }
        if(aggregation == null && samples.size() != 1) {
            throw new IllegalArgumentException("Several samples need an aggregation.");
        }

        this.samples = List.copyOf(samples);
        this.aggregation = aggregation;
        this.aggregate = aggregation == null || samples.size() == 1 ? samples.getFirst() : aggregate(samples, aggregation);
    }

    /**
     * @param output The result of the only evaluation.
     * @return The samples of a candidate that is evaluated once and whose samples are not
     *   recorded.
     */
    public static ObjectiveSamples single(final @NonNull TypedEObject output) {
        return new ObjectiveSamples(List.of(output), null);
    }

    /**
     * @param samples The results of the evaluations, at least one; the objectives have to be
     *   real-valued.
     * @param aggregation How the samples are aggregated.
     * @return The samples of a candidate.
     */
    public static ObjectiveSamples of(final @NonNull List<TypedEObject> samples, final @NonNull SampleAggregation aggregation) {
        return new ObjectiveSamples(samples, aggregation);
    }

    /**
     * @param more The results of further evaluations of the candidate.
     * @return The samples with the further results.
     * @throws IllegalStateException for a single sample without aggregation.
     */
    public ObjectiveSamples with(final @NonNull List<TypedEObject> more) {
        if(aggregation == null) {
            throw new IllegalStateException("A single evaluation has no further samples.");
        }

        final List<TypedEObject> all = new ArrayList<>(samples);
        all.addAll(more);

        return new ObjectiveSamples(all, aggregation);
    }

    /**
     * @return The aggregate of the samples: per objective the aggregation of its samples, the
     *   only sample itself if there is one.
     */
    public TypedEObject aggregate() {
        return aggregate;
    }

    /**
     * @return The results of the evaluations, in their order.
     */
    public List<TypedEObject> samples() {
        return samples;
    }

    /**
     * @return The number of samples.
     */
    public int size() {
        return samples.size();
    }

    /**
     * @return The properties of the individual: empty for a single sample without
     *   aggregation, otherwise the number of samples and, from two samples on, the sample
     *   standard deviations.
     */
    public Map<String, Object> toProperties() {
        if(aggregation == null) {
            return Map.of();
        }

        final Map<String, Object> properties = new LinkedHashMap<>();
        properties.put(SAMPLES, (long) samples.size());

        if(samples.size() >= 2) {
            final List<Double> deviations = new ArrayList<>();
            for(final EAttribute objective : objectivesOf(samples.getFirst())) {
                deviations.add(standardDeviation(valuesOf(samples, objective)));
            }
            properties.put(STANDARD_DEVIATIONS, deviations);
        }

        return properties;
    }

    /**
     * @return A copy of the first sample whose objectives are the aggregates.
     */
    private static TypedEObject aggregate(final List<TypedEObject> samples, final SampleAggregation aggregation) {
        final TypedEObject aggregate = new TypedEObject(samples.getFirst());

        for(final EAttribute objective : objectivesOf(aggregate)) {
            aggregate.eSet(objective, aggregation.apply(valuesOf(samples, objective)));
        }

        return aggregate;
    }

    /**
     * @return The objectives, the attributes of the optimisation space.
     */
    private static List<EAttribute> objectivesOf(final TypedEObject output) {
        return output.eClass().getEAllAttributes();
    }

    private static double[] valuesOf(final List<TypedEObject> samples, final EAttribute objective) {
        final double[] values = new double[samples.size()];
        for(int i = 0; i < values.length; ++i) {
            values[i] = ((Number) samples.get(i).eGet(objective)).doubleValue();
        }

        return values;
    }

    /**
     * @return The sample standard deviation (with n - 1) of at least two values.
     */
    static double standardDeviation(final double[] values) {
        final double mean = SampleAggregation.MEAN.apply(values);

        double sum = 0.0;
        for(final double value : values) {
            final double deviation = value - mean;
            sum += deviation * deviation;
        }

        return Math.sqrt(sum / (values.length - 1));
    }
}
