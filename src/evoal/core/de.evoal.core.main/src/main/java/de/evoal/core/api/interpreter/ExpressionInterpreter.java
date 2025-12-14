package de.evoal.core.api.interpreter;

import de.evoal.core.main.interpreter.LiteralSwitch;
import de.evoal.languages.model.base.expressions.Expression;

public class ExpressionInterpreter {
    private final InterpreterState context;

    public ExpressionInterpreter(final InterpreterState context) {
        this.context = context;
    }

    public Object execute(final Expression expression) {
        return new LiteralSwitch(context)
                .doSwitch(expression);
    }
}
