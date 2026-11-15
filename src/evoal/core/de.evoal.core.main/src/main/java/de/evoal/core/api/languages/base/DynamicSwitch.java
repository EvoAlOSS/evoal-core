package de.evoal.core.api.languages.base;

import java.util.Map;

import de.evoal.languages.model.interpreter.AbstractExpressionEvaluator;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.definitions.DataDescription;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Evaluates (parsed) expressions against a symbol table that contains the current value
 *   of each feature of the runtime model. Data references in the expression, e.g.,
 *   {@code data time}, refer to {@link DataDescription}s of the parsed model and are
 *   translated into the corresponding features.
 */
@Slf4j
public class DynamicSwitch extends AbstractExpressionEvaluator {

    /**
     * Current value of each feature.
     */
    private final Map<EStructuralFeature, Object> symbolTable;

    /**
     * Translation of data descriptions (parsed model) into features (runtime model).
     */
    private final Map<DataDescription, EStructuralFeature> features;

    /**
     * @param symbolTable The symbol table that is read and updated during evaluation.
     * @param features Translation of the data descriptions used in expressions into features.
     */
    public DynamicSwitch(final @NonNull Map<EStructuralFeature, Object> symbolTable, final @NonNull Map<DataDescription, EStructuralFeature> features) {
        this.symbolTable = symbolTable;
        this.features = features;
        setConstantEvaluator(new ConstantEvaluator());
    }

    @Override
    public Object caseValueReference(final ValueReference object) {
        Object value = super.caseValueReference(object);

        if(value instanceof DataDescription description) {
            final EStructuralFeature feature = features.get(description);
            if(feature == null) {
                throw new IllegalStateException("Expression uses data '" + description.getName() + "' that is not available.");
            }

            value = symbolTable.get(feature);
        }

        return value;
    }

    /**
     * Evaluates the given expression {@code exp}, stores the new value under {@code ref} in the symbol table, and
     *   returns the value that was replaced.
     *
     * @param ref The feature to store the value for.
     * @param exp The expression to evaluate.
     * @return The value stored for {@code ref} before.
     */
    public Object evaluateAndUpdate(final EStructuralFeature ref, final Expression exp) {
        //first do switch then update map
        final Object result = this.doSwitch(exp);

        return symbolTable.put(ref, result);
    }
}
