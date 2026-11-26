package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.surrogate.api.training.GoodnessOfFit;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Collects the data objects that reach it and, when the pipeline ends, makes them the data set
 *   that {@code 'gof-calculator'} assesses next: the test data in the testing use case, the
 *   training rows after {@code validation} in the learning use case. Every object is a pair of
 *   inputs and expected outputs; the measures predict the outputs from the inputs and compare.
 * <p>
 * The component stores copies and passes on the objects unchanged: later steps may change the
 *   objects in place, e.g. the preparation steps of the learning use case, while the measures
 *   predict through the prediction pipeline, which prepares the inputs itself.
 */
@Dependent
@Slf4j
@Named("de.evoal.surrogate.pipeline.assessment-data")
public class AssessmentDataComponent extends PipelineComponentImpl {
    @Inject
    private AttributeHelper helper;

    /**
     * The name of the data set, e.g. {@value GoodnessOfFit#TEST}.
     */
    private String dataSet;

    /**
     * Copies of the collected data objects, in the order of the pipeline.
     */
    private final List<TypedEObject> data = new ArrayList<>();

    /**
     * Creates a component that is configured by {@link #init(EObject)}.
     */
    public AssessmentDataComponent() {
    }

    /**
     * Creates a configured component, e.g., for tests.
     *
     * @param dataSet The name of the data set.
     */
    AssessmentDataComponent(final @NonNull String dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        dataSet = helper.lookup(configuration, "data-set");

        return this;
    }

    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject object) {
        data.add(new TypedEObject(object));

        return object;
    }

    @Override
    public void close() {
        log.info("Collected {} data objects of the {} data.", data.size(), dataSet);

        final List<TypedEObject> collected = List.copyOf(data);
        final EObjectPairStreamSupplier pairs = () -> collected.stream()
                                                               .map(o -> new EObjectPair(o, o));

        GoodnessOfFit.of(getContext()).assess(dataSet, pairs);
    }
}
