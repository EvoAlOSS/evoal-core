package de.evoal.surrogate.api.training;

import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.execution.NamedVariable;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The goodness-of-fit values of a training run and the data set that is assessed next.
 *   The values are kept per output feature, per measure (the qualified name of its DL
 *   function, e.g. {@code de.evoal.surrogate.ml.rmse}) and per data set ({@value #TRAINING},
 *   {@value #TEST}, or the name of a resampling scheme). A value is a number, or the
 *   {@link ResampledValues} of a resampling scheme. They live in the outermost interpreter
 *   state, so the use cases share them, and {@code 'store-model'} writes them.
 */
public final class GoodnessOfFit {
    /**
     * The data set of the training data, assessed while learning.
     */
    public static final String TRAINING = "training";

    /**
     * The data set of the test data ({@code testing with [...]}), assessed while testing.
     */
    public static final String TEST = "test";

    /**
     * The name of the variable that holds the values in the outermost interpreter state.
     */
    private static final String VARIABLE = "goodness-of-fit";

    /**
     * Output feature → measure → data set → value ({@link Double} or {@link ResampledValues}),
     *   in the order of recording.
     */
    private final Map<EStructuralFeature, Map<String, Map<String, Object>>> values = new LinkedHashMap<>();

    /**
     * The data set that is assessed.
     */
    private String dataSet = TRAINING;

    /**
     * The data of {@link #dataSet}, or {@code null} for the training data, which the
     *   calculators load from the learning task.
     */
    private EObjectPairStreamSupplier data = null;

    /**
     * Returns the values of the program that the given state belongs to.
     *
     * @param context The state of the interpreter.
     * @return The values, created on first use.
     */
    public static GoodnessOfFit of(final @NonNull InterpreterState context) {
        final InterpreterState root = context.root();
        if(root.getByName(VARIABLE) instanceof GoodnessOfFit existing) {
            return existing;
        }

        final NamedVariable variable = ExecutionFactory.eINSTANCE.createNamedVariable();
        variable.setName(VARIABLE);

        final GoodnessOfFit created = new GoodnessOfFit();
        root.put(variable, created);

        return created;
    }

    /**
     * Sets the data set that the next goodness-of-fit calculation assesses.
     *
     * @param dataSet The name of the data set, e.g. {@value #TEST}.
     * @param data Pairs of input and expected output.
     */
    public void assess(final @NonNull String dataSet, final @NonNull EObjectPairStreamSupplier data) {
        this.dataSet = dataSet;
        this.data = data;
    }

    /**
     * @return The name of the data set that is assessed.
     */
    public String dataSet() {
        return dataSet;
    }

    /**
     * @return The data of the assessed data set, or empty for the training data.
     */
    public Optional<EObjectPairStreamSupplier> data() {
        return Optional.ofNullable(data);
    }

    /**
     * @return {@code true} if the training data is assessed.
     */
    public boolean assessesTrainingData() {
        return TRAINING.equals(dataSet);
    }

    /**
     * Records a value. A second value for the same feature, measure and data set replaces the
     *   first.
     *
     * @param feature The output feature.
     * @param measure The qualified name of the measure.
     * @param dataSet The name of the data set.
     * @param value The value.
     */
    public void record(final @NonNull EStructuralFeature feature, final @NonNull String measure, final @NonNull String dataSet, final double value) {
        put(feature, measure, dataSet, value);
    }

    /**
     * Records the values of a resampling scheme. A second value for the same feature, measure
     *   and data set replaces the first.
     *
     * @param feature The output feature.
     * @param measure The qualified name of the measure.
     * @param dataSet The name of the scheme.
     * @param value The values of the parts and their summary.
     */
    public void record(final @NonNull EStructuralFeature feature, final @NonNull String measure, final @NonNull String dataSet, final @NonNull ResampledValues value) {
        put(feature, measure, dataSet, value);
    }

    private void put(final EStructuralFeature feature, final String measure, final String dataSet, final Object value) {
        values.computeIfAbsent(feature, f -> new LinkedHashMap<>())
              .computeIfAbsent(measure, m -> new LinkedHashMap<>())
              .put(dataSet, value);
    }

    /**
     * @return Output feature → measure → data set → value ({@link Double} or
     *   {@link ResampledValues}), in the order of recording.
     */
    public Map<EStructuralFeature, Map<String, Map<String, Object>>> values() {
        return Collections.unmodifiableMap(values);
    }
}
