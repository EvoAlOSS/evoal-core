package de.evoal.surrogate.main.gof.rsquare;

import lombok.Data;

@Data
public class RSquareData {
    private final double value;

    public RSquareData(final double value) {
        this.value = value;
    }
    /*
    public void attachTo(final PartialFunctionConfiguration regression, final String outputName) {
        attach(regression, outputName, "r²", value);
    }

    private void attach(final PartialFunctionConfiguration regression, final String output, final String name, final Object value) {
        final Parameter parameter = Parameter.builder()
                                             .name(name)
                                             .value(value)
                                             .build();

        regression.addOutputParameter(output, parameter);
    }
     */
}
