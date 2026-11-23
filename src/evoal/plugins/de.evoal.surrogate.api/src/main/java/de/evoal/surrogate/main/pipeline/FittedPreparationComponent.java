package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.pipeline.api.model.PipelineStreamProcessor;
import de.evoal.surrogate.api.function.FittedParameters;
import jakarta.inject.Inject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Base class of the preparation steps ({@code 'preparation-step'}): transforms each of its
 *   {@code features} with parameters of that feature. If the configuration states the
 *   parameters, the step applies them row by row; otherwise it collects the whole stream, fits
 *   the parameters on it, records them ({@link FittedParameters}) and passes the transformed
 *   rows on. With {@code inverse}, the step undoes the transformation.
 */
@Slf4j
public abstract class FittedPreparationComponent extends PipelineComponentImpl implements PipelineStreamProcessor {
    @Inject
    private AttributeHelper attributes;

    /**
     * Reads the attributes of the configuration.
     */
    @Inject
    protected AttributeEvaluator evaluator;

    /**
     * The configuration of the step, the key of its fitted parameters.
     */
    private EObject configuration;

    /**
     * The features to transform.
     */
    private List<EStructuralFeature> features;

    /**
     * The parameters per feature (in the order of {@link #parameterNames()}), or {@code null}
     *   until they are fitted.
     */
    private double[][] parameters;

    /**
     * Whether the step undoes the transformation.
     */
    private boolean inverse;

    /**
     * @return The names of the parameter attributes, e.g. {@code minimum} and {@code maximum}.
     */
    protected abstract List<String> parameterNames();

    /**
     * Fits the parameters of one feature.
     *
     * @param feature The feature, for messages.
     * @param values The values of the feature in the training data.
     * @return The parameters, in the order of {@link #parameterNames()}.
     */
    protected abstract double[] fit(final @NonNull EStructuralFeature feature, final double @NonNull [] values);

    /**
     * @param value A value of a feature.
     * @param parameters The parameters of the feature.
     * @return The transformed value.
     */
    protected abstract double transform(final double value, final double @NonNull [] parameters);

    /**
     * @param value A transformed value of a feature.
     * @param parameters The parameters of the feature.
     * @return The original value.
     */
    protected abstract double invert(final double value, final double @NonNull [] parameters);

    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        this.configuration = configuration;
        features = List.copyOf(attributes.<List<EStructuralFeature>>lookup(configuration, "features"));
        inverse = evaluator.attributeToBoolean(configuration, "inverse");

        final String type = configuration.eClass().getName();
        for(final EStructuralFeature feature : features) {
            final Class<?> instanceClass = feature.getEType().getInstanceClass();
            if(instanceClass != double.class && instanceClass != Double.class) {
                throw new InitializationException("'" + type + "' transforms real features only, but '" + feature.getName() + "' is not real.");
            }
        }

        final List<List<?>> stated = new ArrayList<>();
        for(final String name : parameterNames()) {
            final Object value = configuration.eGet(configuration.eClass().getEStructuralFeature(name));
            stated.add(value instanceof List<?> list ? list : List.of());
        }

        if(stated.stream().allMatch(List::isEmpty)) {
            parameters = null;
            return this;
        }

        parameters = new double[features.size()][parameterNames().size()];
        for(int p = 0; p < stated.size(); ++p) {
            final List<?> values = stated.get(p);
            if(values.size() != features.size()) {
                throw new InitializationException("'" + type + "' states " + values.size() + " values for '" + parameterNames().get(p)
                                                  + "' but has " + features.size() + " features.");
            }

            for(int f = 0; f < values.size(); ++f) {
                parameters[f][p] = ((Number) values.get(f)).doubleValue();
            }
        }

        return this;
    }

    @Override
    public @NonNull Stream<@NonNull TypedEObject> process(final @NonNull Stream<@NonNull TypedEObject> rows) {
        if(parameters != null) {
            return rows.map(this::apply);
        }

        // lazy: the rows are collected when the stream is consumed
        return Stream.of(rows)
                     .flatMap(stream -> {
                         final List<TypedEObject> collected = stream.toList();
                         fitOn(collected);
                         return collected.stream().map(this::apply);
                     });
    }

    private void fitOn(final List<TypedEObject> rows) {
        if(inverse) {
            throw new IllegalStateException("The inverse of '" + configuration.eClass().getName() + "' needs fitted parameters.");
        }

        parameters = new double[features.size()][];
        for(int f = 0; f < features.size(); ++f) {
            final EStructuralFeature feature = features.get(f);
            final double[] values = rows.stream()
                                        .mapToDouble(row -> row.eGetAsDouble(feature))
                                        .toArray();
            parameters[f] = fit(feature, values);
        }

        final Map<String, List<Double>> fitted = new LinkedHashMap<>();
        for(int p = 0; p < parameterNames().size(); ++p) {
            final List<Double> values = new ArrayList<>();
            for(final double[] parameter : parameters) {
                values.add(parameter[p]);
            }
            fitted.put(parameterNames().get(p), values);
        }

        log.info("'{}' fitted on {} rows: {}.", configuration.eClass().getName(), rows.size(), fitted);
        FittedParameters.of(getContext()).record(configuration, fitted);
    }

    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject row) {
        if(parameters == null) {
            throw new IllegalStateException("'" + configuration.eClass().getName() + "' is applied before its parameters are fitted.");
        }

        for(int f = 0; f < features.size(); ++f) {
            final EStructuralFeature feature = features.get(f);
            final double value = row.eGetAsDouble(feature);
            row.eSet(feature, inverse ? invert(value, parameters[f]) : transform(value, parameters[f]));
        }

        return row;
    }
}
