package de.evoal.surrogate.api.training;

import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.core.api.cdi.EvoalBuiltinFunction;
import de.evoal.languages.model.mll.TaskDescription;
import de.evoal.surrogate.api.function.ModelFunctionData;
import lombok.extern.slf4j.Slf4j;

import jakarta.inject.Inject;
import java.util.Optional;

/**
 * Calculates information on the trained surrogate, such as goodness-of-fit measures or the
 *   data a surrogate adaption needs. The calculators are listed in {@code specify gof}.
 */
@Slf4j
public abstract class SurrogateInformationCalculator implements EvoalBuiltinFunction {
    protected ModelFunctionData functionData;

    @Inject
    protected TrainingTaskHelper helper;

    protected TaskDescription task;

    /**
     * The goodness-of-fit values and the data set that is assessed.
     */
    protected GoodnessOfFit goodnessOfFit;

    @Override
    public final Optional<Object> call(final InterpreterState context, final Object[] arguments) {
        task = (TaskDescription) context.getByName("learning-task");
        functionData = (ModelFunctionData) context.getByName("model-function");
        goodnessOfFit = GoodnessOfFit.of(context);

        if(describesTrainingData() && !goodnessOfFit.assessesTrainingData()) {
            log.info("Skipping {} on the {} data: it describes the training data.", getClass().getSimpleName(), goodnessOfFit.dataSet());
            return Optional.empty();
        }

        return calculate(context, arguments);
    }

    /**
     * A calculator that describes the training data (e.g. its density) runs only while
     *   learning; a goodness-of-fit measure runs on every assessed data set.
     *
     * @return {@code true} if the calculator runs only on the training data.
     */
    protected boolean describesTrainingData() {
        return true;
    }

    public abstract Optional<Object> calculate(final InterpreterState context, final Object[] arguments);

    /**
     * @return The data of the assessed data set: the training rows after {@code validation}
     *   while learning, the test data while testing.
     * @throws IllegalStateException if no step has recorded the rows of the data set.
     */
    protected EObjectPairStreamSupplier assessedData() {
        return goodnessOfFit.data()
                            .orElseThrow(() -> new IllegalStateException("No step has recorded the rows of the " + goodnessOfFit.dataSet()
                                                                         + " data that " + getClass().getSimpleName() + " needs; add step { component "
                                                                         + "'assessment-data' { 'data-set' := \"" + goodnessOfFit.dataSet()
                                                                         + "\"; } } after pipeline 'validation'."));
    }
}
