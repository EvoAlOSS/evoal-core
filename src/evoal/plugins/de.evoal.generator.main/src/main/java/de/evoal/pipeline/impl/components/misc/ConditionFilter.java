package de.evoal.pipeline.impl.components.misc;

import java.util.List;
import java.util.Optional;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.pipeline.api.model.PipelineFilterImpl;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;

/**
 * Passes on the rows for which the {@code 'condition'} is true (DL type
 *   {@code 'condition-filter'}). The condition may only use data the step reads.
 */
@Dependent
@Named("de.evoal.pipeline.misc.condition-filter")
public class ConditionFilter extends PipelineFilterImpl {
    @Inject
    private EAnnotationHelper helper;

    /**
     * The condition.
     */
    private ReadDataExpression condition;

    /**
     * Creates a filter that is configured by {@link #init(EObject)}.
     */
    public ConditionFilter() {
    }

    /**
     * Creates a configured filter, e.g., for tests.
     *
     * @param maximumConsecutiveRejections The number of rows in a row that the filter may drop.
     * @param condition The condition.
     * @param pipeline The space of the pipeline.
     * @param reads The data the step reads.
     * @throws InitializationException if the condition uses data that the step does not read.
     */
    ConditionFilter(final int maximumConsecutiveRejections, final Expression condition, final Space pipeline, final Space reads) throws InitializationException {
        super("condition-filter", maximumConsecutiveRejections);
        this.helper = new EAnnotationHelper();
        setFeatures(pipeline, reads, pipeline.subSpace(List.of()));
        configure(condition);
    }

    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);
        configure(ReadDataExpression.of(configuration, "condition"));

        return this;
    }

    private void configure(final Expression expression) throws InitializationException {
        condition = new ReadDataExpression("condition", expression, readData(helper));
    }

    @Override
    protected Optional<String> violation(final @NonNull TypedEObject row) {
        final Object result = condition.evaluate(row);
        if(!(result instanceof Boolean passes)) {
            throw new IllegalStateException("The condition '" + condition.text() + "' is no boolean, but " + result + ".");
        }

        return passes ? Optional.empty() : Optional.of("does not satisfy '" + condition.text() + "'");
    }
}
