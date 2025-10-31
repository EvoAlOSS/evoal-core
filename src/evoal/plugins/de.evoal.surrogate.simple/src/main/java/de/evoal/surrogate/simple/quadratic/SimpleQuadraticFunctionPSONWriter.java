package de.evoal.surrogate.simple.quadratic;

import de.evoal.surrogate.api.function.ModelFunction;
import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.api.io.pson.AbstractPSONWriter;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Slf4j
public class SimpleQuadraticFunctionPSONWriter extends AbstractPSONWriter {
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
        final SimpleQuadraticFunction lFunction = (SimpleQuadraticFunction) function;

        final double slope = lFunction.getSlope();
        final double intercept = lFunction.getIntercept();

        configuration.getState()
                .add(new Parameter(SLOPE_PARAMETER_NAME, slope));
        configuration.getState()
                .add(new Parameter(INTERCEPT_PARAMETER_NAME, intercept));
    }
}
