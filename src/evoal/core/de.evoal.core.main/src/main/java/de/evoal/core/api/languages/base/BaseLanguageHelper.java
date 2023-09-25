package de.evoal.core.api.languages.base;

import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.base.Call;
import de.evoal.languages.model.base.Expression;

public final class BaseLanguageHelper {
    private BaseLanguageHelper() {
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
