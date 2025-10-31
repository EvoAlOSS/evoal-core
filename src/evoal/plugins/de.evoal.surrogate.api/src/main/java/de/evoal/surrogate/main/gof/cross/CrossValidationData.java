package de.evoal.surrogate.main.gof.cross;

import lombok.Getter;

/**
 * The cross validation data serialised to the pson file.
 */
public class CrossValidationData {
    private final int k;
    @Getter
    private final double mean;
    private final int partitionSize;
    @Getter
    private final double sd;

    public CrossValidationData(final int k, final double mean, final int partitionSize, final double sd) {
        this.k = k;
        this.mean = mean;
        this.partitionSize = partitionSize;
        this.sd = sd;
    }
/*
    public void attachTo(final SurrogateConfiguration regression, final String outputName) {
        attach(regression, outputName, "cross-validation-k", k);
        attach(regression, outputName, "cross-validation-mean", mean);
        attach(regression, outputName, "cross-validation-partition-size", partitionSize);
        attach(regression, outputName, "cross-validation-sd", sd);
    }

    private void attach(final SurrogateConfiguration regression, final String output, final String name, final Object value) {
        final Parameter parameter = Parameter.builder()
                                             .name(name)
                                             .value(value)
                                             .build();

        regression.addOutputParameter(output, parameter);
    }
    */
}
