package de.evoal.surrogate.simple.linear;

import de.evoal.core.api.ecore.Space;
import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.api.io.pson.AbstractPSONWriter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Setter
@Slf4j
@Named("de.evoal.surrogate.simple.ml.linear-regression-writer-pson")
@Dependent
public class LinearFunctionPSONWriter extends AbstractPSONWriter {
    /**
     * Name of the intercept parameter.
     */
    public static final String INTERCEPT_PARAMETER_NAME = "intercept";

    /**
     * Name of the slope parameter.
     */
    public static final String SLOPE_PARAMETER_NAME = "slope";

    @Override
    protected void toConfiguration(final @NonNull ModelFunction function, final @NonNull SurrogateConfiguration configuration) {
        final LinearFunction lFunction = (LinearFunction) function;

        final double slope = lFunction.getSlope();
        final double intercept = lFunction.getIntercept();

        configuration.getState()
                .add(new Parameter(SLOPE_PARAMETER_NAME, slope));
        configuration.getState()
                .add(new Parameter(INTERCEPT_PARAMETER_NAME, intercept));
    }
}
