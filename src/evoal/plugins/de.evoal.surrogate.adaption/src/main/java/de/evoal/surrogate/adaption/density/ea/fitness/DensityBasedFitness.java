package de.evoal.surrogate.adaption.density.ea.fitness;

import de.evoal.surrogate.adaption.density.model.DensityData;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.info.PropertiesRanges;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.Instance;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationFunctionDecorator;
import de.evoal.surrogate.api.configuration.PartialFunctionConfiguration;
import de.evoal.surrogate.api.function.FunctionCombiner;
import de.evoal.surrogate.api.function.PartialSurrogateFunction;
import de.evoal.surrogate.api.function.SurrogateFunction;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;
import java.util.List;
import java.util.function.BiFunction;

@Slf4j
@Vetoed
public abstract class DensityBasedFitness extends OptimisationFunctionDecorator {
    @Inject
    private LanguageHelper helper;

    private final BiFunction<PartialFunctionConfiguration, String, DensityData> modelCreator;

    /**
     * Pre-calculated density data for the prediction's source properties.
     */
    private DensityData[][] sourceDensityData;

    /**
     * Pre-calculated density data for the prediction's target properties.
     */
    private DensityData[][] targetDensityData;

    @Inject
    private PropertiesRanges ranges;

    private String kind;

    private double exponent;

    private double rootExponent;

    @Inject
    private SurrogateFunction surrogate;

    private QuadrupelFunction<DensityData[], DensityData, Properties, Double, Double> probabilityCalculator;

    public DensityBasedFitness(final BiFunction<PartialFunctionConfiguration, String, DensityData> modelCreator) {
        this.modelCreator = modelCreator;
    }

    @Override
    public OptimisationFunction init(final Instance config) {
        log.info("Setting up density-based fitness calculation.");
        super.init(config);

        kind = helper.lookup(config, "kind");
        exponent = helper.lookup(config, "exponent");
        rootExponent = helper.lookup(config, "root-exponent");

        // TODO Check this section if it is really correct in all cases.
        final List<FunctionCombiner> mappings = surrogate.getMappings();
        final FunctionCombiner mapping = mappings.get(mappings.size() - 1);

        final PartialSurrogateFunction[] regressions = mapping.getFunctions();
        sourceDensityData = new DensityData[regressions.length][];
        targetDensityData = new DensityData[regressions.length][];

        for(int i = 0; i < regressions.length; ++i) {
            final PartialSurrogateFunction function = regressions[i];
            final PropertiesSpecification sourceSpec = function.getUsedProperties();
            final PropertiesSpecification targetSpec = function.getOutputProperty();

            Requirements.requireSizeGreaterThan(sourceSpec, 0);
            Requirements.requireSize(targetSpec, 1);

            sourceDensityData[i] = new DensityData[sourceSpec.size()];
            targetDensityData[i] = new DensityData[targetSpec.size()];

            for(int j = 0; j < sourceSpec.size(); ++j) {
                sourceDensityData[i][j] = modelCreator.apply(function.getConfiguration(), sourceSpec.getProperties().get(j).name());
            }

            for(int j = 0; j < targetSpec.size(); ++j) {
                targetDensityData[i][j] = modelCreator.apply(function.getConfiguration(), targetSpec.getProperties().get(j).name());
            }
        }

        if("both".equals(kind)) {
            probabilityCalculator = this::bothProbabilityCalculator;
        } else if("source-based".equals(kind)) {
            probabilityCalculator = this::sourceBasedProbabilityCalculator;
        } else if("target-based".equals(kind)) {
            probabilityCalculator = this::targetBasedProbabilityCalculator;
        }

        return this;
    }

    @Override
    public double [] evaluate(final Properties candidate) {
        final double [] current = decoratedFunction.evaluate(candidate);
        final double [] fitness = new double[current.length];

        for(int i = 0; i  < fitness.length; ++i) {
            final DensityData [] sourceData = sourceDensityData[i];
            final DensityData targetData = targetDensityData[i][0];

            final double predictedValue = current[i];
            final double probability = probabilityCalculator.apply(sourceData, targetData, candidate, predictedValue);

            fitness[i] = current[i] * Math.pow(probability, rootExponent) + (1 - probability) / Math.pow(probability, exponent);
        }

        return fitness;
    }

    /**
     * Fix-conditional probability problem.
     */
    private double bothProbabilityCalculator(final DensityData [] sourceData, final DensityData targetData, final Properties candidate, final double predicted) {
        return sourceBasedProbabilityCalculator(sourceData, targetData, candidate, predicted) * targetBasedProbabilityCalculator(sourceData, targetData, candidate, predicted);
    }

    /**
     * "Now, it's really fine."
     */
    private double sourceBasedProbabilityCalculator(final DensityData [] sourceData, final DensityData targetData, final Properties candidate, final double predicted) {
        double result = 1.0;
        for(int i = 0; i < candidate.size(); ++i) {
            final double probability = sourceData[i].probability(((Number)candidate.get(i)).doubleValue());
            final double offset = 1 / ((Number)ranges.get(surrogate.getInputSpecification().get(i))).doubleValue();

            result *= Math.pow(Math.min(1.0, probability + offset), 1.0 / candidate.size());
        }

        return result;
    }

    /**
     * Fix the range problem.
     */
    private double targetBasedProbabilityCalculator(final DensityData [] sourceData, final DensityData targetData, final Properties candidate, final double predicted) {
        final double probability = targetData.probability(predicted);
        final double offset = 1 / ((Number)ranges.get(surrogate.getOutputSpecification().get(0))).doubleValue();

        return Math.min(1.0, probability + offset);
    }
}
