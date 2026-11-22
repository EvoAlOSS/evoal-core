package de.evoal.pipeline.impl.components.misc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.languages.ExpressionText;
import de.evoal.core.api.languages.base.DynamicSwitch;
import de.evoal.languages.model.base.definitions.DataDescription;
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
import org.eclipse.emf.ecore.EStructuralFeature;

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
    private Expression condition;

    /**
     * The values of the read data of the current row.
     */
    private final Map<EStructuralFeature, Object> symbolTable = new HashMap<>();

    /**
     * Evaluates the condition on {@link #symbolTable}.
     */
    private DynamicSwitch evaluator;

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

        final EStructuralFeature feature = configuration.eClass().getEStructuralFeature("condition");
        if(feature == null || !(configuration.eGet(feature) instanceof Expression expression)) {
            throw new InitializationException("A 'condition-filter' needs a 'condition'.");
        }
        configure(expression);

        return this;
    }

    private void configure(final Expression expression) throws InitializationException {
        condition = expression;

        final Map<DataDescription, EStructuralFeature> features = readData(helper);
        requireRead(features);

        evaluator = new DynamicSwitch(symbolTable, features);
    }

    /**
     * @throws InitializationException if the condition uses data that the step does not read.
     */
    private void requireRead(final Map<DataDescription, EStructuralFeature> features) throws InitializationException {
        final Set<String> unread = new TreeSet<>();
        final Consumer<EObject> check = element -> element.eCrossReferences()
                                                          .stream()
                                                          .filter(DataDescription.class::isInstance)
                                                          .map(DataDescription.class::cast)
                                                          .filter(description -> !features.containsKey(description))
                                                          .forEach(description -> unread.add("'" + description.getName() + "'"));

        check.accept(condition);
        condition.eAllContents().forEachRemaining(check);

        if(!unread.isEmpty()) {
            throw new InitializationException("The condition '" + ExpressionText.of(condition) + "' uses the data " + unread
                                              + ", which the step does not read.");
        }
    }

    @Override
    protected Optional<String> violation(final @NonNull TypedEObject row) {
        for(final EStructuralFeature feature : getReads()) {
            symbolTable.put(feature, row.eGet(feature));
        }

        final Object result = evaluator.doSwitch(condition);
        if(!(result instanceof Boolean passes)) {
            throw new IllegalStateException("The condition '" + ExpressionText.of(condition) + "' is no boolean, but " + result + ".");
        }

        return passes ? Optional.empty() : Optional.of("does not satisfy '" + ExpressionText.of(condition) + "'");
    }
}
