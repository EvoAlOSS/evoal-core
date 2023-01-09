package de.evoal.generator.main.generators;

import de.evoal.core.api.utils.InitializationException;
import de.evoal.generator.api.GeneratorFunction;
import de.evoal.languages.model.el.DoubleLiteral;
import de.evoal.languages.model.generator.Step;
import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Instance;
import de.evoal.languages.model.instance.LiteralValue;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

//@Named("multivariate-uniform-distribution")
public class MultivariateUniformDistribution extends MultivariateRealDistributionBase {
    private record Range(double lowerBound, double upperBound) {
    }

    @Override
    public GeneratorFunction init(final Step configuration) throws InitializationException {
        super.init(configuration);

        final List<Range> ranges = readRanges(configuration);

        double [] lhs = ranges.stream().mapToDouble(Range::lowerBound).toArray();
        double [] rhs = ranges.stream().mapToDouble(Range::upperBound).toArray();

       // setDistribution(new org.apache.commons.math3.distribution.MultivariateRealDistribution(lhs, rhs));

        return this;
    }

    private List<Range> readRanges(final Step configuration) {
        final Array ranges = (Array)configuration.getInstance().findAttribute("ranges");
        return ranges.getValues()
                     .stream()
                     .map(Instance.class::cast)
                     .map(this::readRange)
                     .collect(Collectors.toUnmodifiableList());
    }

    public Range readRange(final Instance value) {
        return new Range(readDouble(value, "lower-bound"), readDouble(value, "upper-bound"));
    }

    private double readDouble(final Instance value, final String name) {
        return ((DoubleLiteral)((LiteralValue)value.findAttribute(name)).getLiteral()).getValue();
    }

}
