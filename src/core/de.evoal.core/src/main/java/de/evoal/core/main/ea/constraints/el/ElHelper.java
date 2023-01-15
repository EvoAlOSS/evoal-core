package de.evoal.core.main.ea.constraints.el;

import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.el.Call;
import de.evoal.languages.model.el.Expression;

public final class ElHelper {
    private ElHelper() {
    }

    public static Number findNumber(final Expression expression) {
        return new NumberSwitch().doSwitch(expression);
    }

    public static String findString(final Expression expression) {
        return new StringSwitch().doSwitch(expression);
    }

    public static String findValueReference(final Expression expression, DataDescription context) {
        return new ValueReferenceSwitch(context).doSwitch(expression);
    }

    public static Call findCall(final Expression expression) {
        return new CallSwitch().doSwitch(expression);
    }
}
