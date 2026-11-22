package de.evoal.pipeline.impl.components.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

import de.evoal.core.api.languages.ExpressionText;
import de.evoal.core.api.languages.base.DynamicSwitch;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * An expression attribute of a filter that is evaluated on the read data of every row, e.g. the
 *   {@code 'condition'} of {@code 'condition-filter'}. It may only use data the step reads; other
 *   data stops the run at start-up.
 */
final class ReadDataExpression {
    /**
     * The name of the attribute, e.g. {@code condition}.
     */
    private final String attribute;

    private final Expression expression;

    /**
     * The values of the read data of the current row.
     */
    private final Map<EStructuralFeature, Object> symbolTable = new HashMap<>();

    /**
     * The read data, by their data description.
     */
    private final Map<DataDescription, EStructuralFeature> readData;

    /**
     * Evaluates the expression on {@link #symbolTable}.
     */
    private final DynamicSwitch evaluator;

    /**
     * @param attribute The name of the attribute, e.g. {@code condition}.
     * @param expression The expression.
     * @param readData The data the step reads, by their data description.
     * @throws InitializationException if the expression uses data that the step does not read.
     */
    ReadDataExpression(final @NonNull String attribute, final @NonNull Expression expression, final @NonNull Map<DataDescription, EStructuralFeature> readData) throws InitializationException {
        this.attribute = attribute;
        this.expression = expression;
        this.readData = readData;
        requireRead();

        evaluator = new DynamicSwitch(symbolTable, readData);
    }

    /**
     * @param configuration The configuration of the filter.
     * @param attribute The name of the expression attribute.
     * @return The expression of the attribute.
     * @throws InitializationException if the configuration has no such expression.
     */
    static Expression of(final @NonNull EObject configuration, final @NonNull String attribute) throws InitializationException {
        final EStructuralFeature feature = configuration.eClass().getEStructuralFeature(attribute);
        if(feature == null || !(configuration.eGet(feature) instanceof Expression expression)) {
            throw new InitializationException("A '" + configuration.eClass().getName() + "' needs an expression '" + attribute + "'.");
        }

        return expression;
    }

    private void requireRead() throws InitializationException {
        final Set<String> unread = new TreeSet<>();
        final Consumer<EObject> check = element -> element.eCrossReferences()
                                                          .stream()
                                                          .filter(DataDescription.class::isInstance)
                                                          .map(DataDescription.class::cast)
                                                          .filter(description -> !readData.containsKey(description))
                                                          .forEach(description -> unread.add("'" + description.getName() + "'"));

        check.accept(expression);
        expression.eAllContents().forEachRemaining(check);

        if(!unread.isEmpty()) {
            throw new InitializationException("The " + attribute + " '" + text() + "' uses the data " + unread
                                              + ", which the step does not read.");
        }
    }

    /**
     * @param row The row.
     * @return The value of the expression for the read data of the row.
     */
    Object evaluate(final @NonNull TypedEObject row) {
        for(final EStructuralFeature feature : readData.values()) {
            symbolTable.put(feature, row.eGet(feature));
        }

        return evaluator.doSwitch(expression);
    }

    /**
     * @return The expression as written in the configuration.
     */
    String text() {
        return ExpressionText.of(expression);
    }
}
