package de.evoal.pipeline.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import jakarta.inject.Inject;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Base class of the filters (DL type {@code Filter}). It counts the kept and dropped rows and
 *   stops the run once {@code 'maximum-consecutive-rejections'} rows in a row were dropped, so
 *   a filter that the data never passes cannot run forever on an endless source.
 */
@Slf4j
public abstract class PipelineFilterImpl extends PipelineComponentImpl implements PipelineFilter {
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The name of the filter's DL type, e.g. {@code condition-filter}.
     */
    private String name;

    /**
     * The number of rows in a row that the filter may drop.
     */
    private int maximumConsecutiveRejections;

    /**
     * The number of rows dropped since the last kept row.
     */
    private int consecutiveRejections;

    private long kept;

    private long dropped;

    /**
     * Creates a filter that is configured by {@link #init(EObject)}.
     */
    protected PipelineFilterImpl() {
    }

    /**
     * Creates a configured filter, e.g., for tests.
     *
     * @param name The name of the filter's DL type.
     * @param maximumConsecutiveRejections The number of rows in a row that the filter may drop.
     */
    protected PipelineFilterImpl(final String name, final int maximumConsecutiveRejections) {
        this.name = name;
        this.maximumConsecutiveRejections = maximumConsecutiveRejections;
    }

    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        name = configuration.eClass().getName();
        maximumConsecutiveRejections = evaluator.attributeToInteger(configuration, "maximum-consecutive-rejections");
        if(maximumConsecutiveRejections < 1) {
            throw new InitializationException("'maximum-consecutive-rejections' of '" + name + "' must be at least 1, but is "
                                              + maximumConsecutiveRejections + ".");
        }

        return this;
    }

    /**
     * @param helper Finds the data description of a feature.
     * @return The data that the step reads, by their data description.
     */
    protected Map<DataDescription, EStructuralFeature> readData(final @NonNull EAnnotationHelper helper) {
        final Map<DataDescription, EStructuralFeature> result = new LinkedHashMap<>();

        for(final EStructuralFeature feature : getReads()) {
            final DataDescription description = helper.dataDescriptionOf(feature)
                                                      .orElseThrow(() -> new IllegalStateException("The read data '" + feature.getName()
                                                                                                   + "' has no data description."));
            result.put(description, feature);
        }

        return result;
    }

    /**
     * @param row The row.
     * @return Why the row is dropped, or empty if it is passed on.
     */
    protected abstract Optional<String> violation(final @NonNull TypedEObject row);

    @Override
    public final boolean test(final @NonNull TypedEObject row) {
        final Optional<String> violation = violation(row);

        if(violation.isEmpty()) {
            ++kept;
            consecutiveRejections = 0;
            return true;
        }

        ++dropped;
        ++consecutiveRejections;
        log.debug("'{}' drops a row: {}.", name, violation.get());

        if(consecutiveRejections >= maximumConsecutiveRejections) {
            throw new IllegalStateException("'" + name + "' dropped " + consecutiveRejections + " rows in a row, its "
                                            + "'maximum-consecutive-rejections'; the last row " + violation.get() + ".");
        }

        return false;
    }

    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject object) {
        return object;
    }

    @Override
    public void streamEnded() {
        log.info("'{}' kept {} of {} rows.", name, kept, kept + dropped);
    }
}
