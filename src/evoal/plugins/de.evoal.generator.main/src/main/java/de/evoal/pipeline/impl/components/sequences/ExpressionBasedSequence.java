package de.evoal.pipeline.impl.components.sequences;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.languages.base.DynamicSwitch;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.pipeline.api.sequence.Sequence;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Map;


@Dependent
@Named("de.evoal.pipeline.sequences.expression-based-sequence")
@Slf4j
public class ExpressionBasedSequence implements Sequence {

    /**
     * The switch to calculate values.
     */
    private DynamicSwitch dynamicSwitch;

    /**
     * The (parsed) expression to evaluate.
     */
    private Expression expression;

    @Inject
    private AttributeEvaluator evaluator;

    /**
     * The initial value of {@link #variable}.
     */
    private double initialValue;

    /**
     * The feature (data) to write.
     */
    @Getter
    private EStructuralFeature variable;

    @Override
    public ExpressionBasedSequence init(final EObject configuration) {
        this.variable = (EStructuralFeature) configuration.eGet(configuration.eClass().getEStructuralFeature("variable"));
        this.initialValue = evaluator.attributeToDouble(configuration, "initial");
        this.expression = (Expression) configuration.eGet(configuration.eClass().getEStructuralFeature("expression"));

        return this;
    }

    @Override
    public void setSymbolTable(final Map<EStructuralFeature, Object> symbolTable, final Map<DataDescription, EStructuralFeature> features) {
        this.dynamicSwitch = new DynamicSwitch(symbolTable, features);
    }

    @Override
    public Object getInitialValue() {
        return initialValue;
    }

    @Override
    public Object next() {
        return dynamicSwitch.evaluateAndUpdate(variable, expression);
    }
}
