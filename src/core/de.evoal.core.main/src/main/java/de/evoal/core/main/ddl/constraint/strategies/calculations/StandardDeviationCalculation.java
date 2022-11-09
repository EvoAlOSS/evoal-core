package de.evoal.core.main.ddl.constraint.strategies.calculations;

import de.evoal.core.api.ea.constraints.model.Constraint;
import de.evoal.core.api.ea.constraints.model.ConstraintResult;
import de.evoal.core.api.ea.constraints.strategies.CalculationResult;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.main.ddl.constraint.strategies.CalculationStrategy;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import javax.enterprise.context.Dependent;

import de.evoal.core.main.ddl.deviation.model.Deviations;
import de.evoal.languages.model.instance.Instance;
import lombok.NonNull;
import org.apache.commons.math3.util.Pair;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;
import java.util.stream.Collectors;

@Dependent
@Named("standard-deviation")
public class StandardDeviationCalculation implements CalculationStrategy {
    @Inject
    private Deviations deviations;

    @Inject @Named("source-properties-specification")
    private PropertiesSpecification source;

    private Instance configuration;
    private Constraint constraint;
    private double factor;
    private List<Pair<Integer, Double>> allowedDeviations;

    @Override
    public @NonNull CalculationResult calculate(final Properties properties) {
        return new CalculationResult(calculateMinimalDifference(0, new HashMap<>(), properties));
    }

    private ConstraintResult calculateMinimalDifference(final int index, final Map<Integer, Double> differences, final Properties properties) {
        if(index == allowedDeviations.size()) {
            final Properties adaptedProperties = new Properties(properties);

            for(final Map.Entry<Integer, Double> entry : differences.entrySet()) {
                final Integer propIndex = entry.getKey();
                final double value = adaptedProperties.get(propIndex) + entry.getValue();
                adaptedProperties.put(propIndex, value);
            }

            return constraint.apply(adaptedProperties);
        }

        final Pair<Integer, Double> deviation = allowedDeviations.get(index);

        // no deviation
        differences.put(deviation.getFirst(), 0.0);
        ConstraintResult minimalResult = calculateMinimalDifference(index + 1, differences, properties);

        if(CalculationResult.isSuccessful(minimalResult) || deviation.getSecond() == 0.0) {
            return minimalResult;
        }

        // - deviation
        {
            differences.put(deviation.getFirst(), -deviation.getSecond() * factor);
            ConstraintResult result = calculateMinimalDifference(index + 1, differences, properties);

            if(CalculationResult.isSuccessful(result)) {
                return result;
            } else if(Math.abs(result.getComparisonDifference()) < Math.abs(minimalResult.getComparisonDifference())) {
                minimalResult = result;
            }
        }

        // + deviation
        {
            differences.put(deviation.getFirst(), deviation.getSecond() * factor);
            ConstraintResult result = calculateMinimalDifference(index + 1, differences, properties);

            if(CalculationResult.isSuccessful(result)) {
                return result;
            } else if(Math.abs(result.getComparisonDifference()) < Math.abs(minimalResult.getComparisonDifference())) {
                minimalResult = result;
            }

            return minimalResult;
        }
    }

    @Override
    public void init(final Constraint constraint, final Instance configuration) {
        this.configuration = configuration;
        this.constraint = constraint;
        this.factor = LanguageHelper.lookup(configuration, "factor");

        final List<PropertySpecification> sourceProperties = constraint.getUsedProperties();

        allowedDeviations = sourceProperties
                .stream()
                .map(ps -> new Pair<PropertySpecification, Optional<Double>>(ps, deviations.find(ps)))
                .map(p -> new Pair<Integer, Double>(source.indexOf(p.getFirst()), p.getSecond().orElse(0.0)))
                .collect(Collectors.toList());
    }
}
