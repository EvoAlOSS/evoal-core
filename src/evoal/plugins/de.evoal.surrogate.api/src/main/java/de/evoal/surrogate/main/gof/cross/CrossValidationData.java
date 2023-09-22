package de.evoal.surrogate.main.gof.cross;

import de.evoal.surrogate.api.configuration.Parameter;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;

public class CrossValidationData {
    private final int k;
    private final double mean;
    private final int partitionSize;
    private final double sd;

    public CrossValidationData(final int k, final double mean, final int partitionSize, final double sd) {
        this.k = k;
        this.mean = mean;
        this.partitionSize = partitionSize;
        this.sd = sd;
    }

    public double getMean() {
        return mean;
    }

    public double getSd() {
        return sd;
    }

    public void attachTo(final PartialFunctionConfiguration regression, final String outputName) {
        attach(regression, outputName, "cross-validation-k", k);
        attach(regression, outputName, "cross-validation-mean", mean);
        attach(regression, outputName, "cross-validation-partition-size", partitionSize);
        attach(regression, outputName, "cross-validation-sd", sd);
    }

    private void attach(final PartialFunctionConfiguration regression, final String output, final String name, final Object value) {
        final Parameter parameter = Parameter.builder()
                                             .name(name)
                                             .value(value)
                                             .build();

        regression.addOutputParameter(output, parameter);
    }
}
