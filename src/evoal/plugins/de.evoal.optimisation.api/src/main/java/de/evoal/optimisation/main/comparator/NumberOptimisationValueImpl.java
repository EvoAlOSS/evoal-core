package de.evoal.optimisation.main.comparator;

import de.evoal.languages.model.interpreter.numeric.ArithmeticNumberOperations;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.impl.OptimisationValueWithDistanceImpl;
import de.evoal.models.core.ecore.TypedEObject;

import java.util.function.Function;

class NumberOptimisationValueImpl extends OptimisationValueWithDistanceImpl {
    final TypedEObject optimisationSpaceValue;

    final Number fitnessValue;

    final Function<Number, Number> valueConversion;

    public NumberOptimisationValueImpl(final TypedEObject optimisationSpaceValue, final Number fitnessValue, final Function<Number, Number> valueConversion) {
        this.optimisationSpaceValue = optimisationSpaceValue.copy();
        this.fitnessValue = fitnessValue;
        this.valueConversion = valueConversion;
    }

    @Override
    public int compareTo(final OptimisationValue other) {
        if(!(other instanceof NumberOptimisationValue otherNumeric)) {
            throw new IllegalArgumentException("Only allowed to compare NumericOptimisationValue");
        }

        final Number thisConvertedValue = valueConversion
                .apply(this.fitnessValue);
        final Number otherConvertedValue = valueConversion
                .apply(otherNumeric.delegate.fitnessValue);

        return ArithmeticNumberOperations.compare(thisConvertedValue, otherConvertedValue);
    }
}
