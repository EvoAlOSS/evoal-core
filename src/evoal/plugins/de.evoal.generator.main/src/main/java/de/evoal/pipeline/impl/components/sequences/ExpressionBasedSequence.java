package de.evoal.pipeline.impl.components.sequences;

import javax.enterprise.context.Dependent;

import de.evoal.core.api.languages.base.DynamicSwitch;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.Expression;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.pipeline.api.sequence.Sequence;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
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
     * The expression to evaluate
     */
    private Expression expression;

    @Inject
    private AttributeHelper helper;

    /**
     * The initial value of {@link #variable}.
     */
    private double initialValue;

    /**
     * The variable to write
     */
    @Getter
    private DataDescription variable;

    @Override
    public ExpressionBasedSequence init(final Instance configuration) {
        this.variable = helper.lookup(configuration, "variable");
        this.initialValue =helper.lookup(configuration, "initial");
        this.expression = configuration.findAttribute("expression").getValue();

        return this;
    }

    @Override
    public void setSymbolTable(final Map<DataDescription, Object> symbolTable) {
        this.dynamicSwitch = new DynamicSwitch(symbolTable);
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