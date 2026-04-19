package de.evoal.surrogate.adaption.density.ea.fitness;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.surrogate.adaption.density.model.DensityData;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.info.PropertiesRanges;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.model.OptimisationFunction;
import de.evoal.optimisation.api.model.OptimisationFunctionDecorator;
import de.evoal.surrogate.api.io.ModelReader;
import jakarta.enterprise.inject.Vetoed;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.inject.Inject;
import java.util.function.BiFunction;

@Slf4j
@Vetoed
public abstract class DensityBasedFitness extends OptimisationFunctionDecorator {
    @Inject
    private AttributeHelper helper;

    private final BiFunction<ModelReader, EStructuralFeature, DensityData> modelCreator;

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
    private EAnnotationHelper mapperBetweenWorlds;

    private QuadrupelFunction<DensityData[], DensityData, Properties, Double, Double> probabilityCalculator;

    public DensityBasedFitness(final BiFunction<ModelReader, EStructuralFeature, DensityData> modelCreator) {
        this.modelCreator = modelCreator;
    }

    @Override
    public OptimisationFunction init(final Instance config) {
        log.info("Setting up density-based malus calculation.");
        super.init(config);
/*
        kind = helper.lookup(config, "kind");
        exponent = helper.lookup(config, "exponent");
        rootExponent = helper.lookup(config, "root-exponent");

        final List<PartialSurrogateFunction> regressions = surrogate.getFunctions();
        sourceDensityData = new DensityData[regressions.size()][];
        targetDensityData = new DensityData[regressions.size()][];

        for(int i = 0; i < regressions.size(); ++i) {
            final PartialSurrogateFunction function = regressions.get(i);
            final PropertiesSpecification sourceSpec = PropertiesSpecification.builder()
                            .add(mapperBetweenWorlds.dataDescriptionsOf(function.getInput()).stream())
                            .build();
            final PropertiesSpecification targetSpec = PropertiesSpecification.builder()
                            .add(mapperBetweenWorlds.dataDescriptionsOf(function.getOutputProperty()).stream())
                            .build();

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
*/
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
/*
        int index = 0;
        for(final EStructuralFeature feature : surrogate.getInputSpecification()) {
            final DataDescription dd = mapperBetweenWorlds.dataDescriptionOf(feature).get();

            final double probability = sourceData[index].probability(((Number)candidate.get(index)).doubleValue());
            final double offset = 1 / ((Number)ranges.get(new PropertySpecification(dd.getName(), dd))).doubleValue();

            result *= Math.pow(Math.min(1.0, probability + offset), 1.0 / candidate.size());

            index += 1;
        }
*/
        return result;
    }

    /**
     * Fix the range problem.
     */
    private double targetBasedProbabilityCalculator(final DensityData [] sourceData, final DensityData targetData, final Properties candidate, final double predicted) {
        /*
        final EStructuralFeature feature = surrogate.getOutputSpecification().iterator().next();
        final DataDescription dd = mapperBetweenWorlds.dataDescriptionOf(feature).get();

        final double probability = targetData.probability(predicted);
        final double offset = 1 / ((Number)ranges.get(new PropertySpecification(dd.getName(), dd))).doubleValue();

        return Math.min(1.0, probability + offset);
         */
        return 1.0;
    }
}
