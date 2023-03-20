package de.evoal.surrogate.main.statistics.correlated;

import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.optimisation.OptimisationValue;
import de.evoal.core.api.statistics.*;
import de.evoal.core.api.statistics.io.Writer;
import de.evoal.core.api.statistics.io.WriterException;
import de.evoal.core.api.statistics.io.WriterStrategy;
import de.evoal.core.api.statistics.writer.Column;
import de.evoal.core.api.statistics.writer.ColumnType;
import de.evoal.core.api.statistics.writer.StatisticsWriter;
import de.evoal.core.api.utils.LanguageHelper;
import de.evoal.languages.model.instance.Instance;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.surrogate.api.training.TrainingDataManager;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import lombok.extern.slf4j.Slf4j;

import smile.math.matrix.Matrix;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("correlated")
@Dependent
public class GenerationStatisticsWriter implements StatisticsWriter {
    /**
     * List of all existing fitness functions.
     */
    private List<Function<Properties, Properties>> functions;

    /**
     * List of all function names
     */
    // TODO @Inject @Named("function-names")
    private List<String> functionNames;


    private long startTime;

    private IterationResult generationWithBestIndividual;
    private long endTime;

    @Inject
    private Provider<Function<Properties, Properties>> fitnessFactory;

    @Inject @ConfigurationValue(entry = CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.optimisation-function.function")
    private Instance config;

    @Inject
    private TrainingDataManager manager;

    @Inject @Named("surrogate-source-properties-specification")
    private PropertiesSpecification sourceSpec;

    @Inject @Named("surrogate-target-properties-specification")
    private PropertiesSpecification targetSpec;
        private List<Properties> sourceTrainingPoints;

    /**
     * Creates a new GenerationStatistics instance.
     */

    @Inject
    private WriterStrategy strategy;

    @PostConstruct
    public void init() {
        final String selectedFunctionName = LanguageHelper.lookup(config, "name");

        startTime = System.currentTimeMillis();
        // create fitness functions for comparison
        this.functionNames.sort((a, b) -> {
            if(selectedFunctionName.equals(a)) {
                return Integer.MIN_VALUE;
            } else if(selectedFunctionName.equals(b)) {
                return Integer.MAX_VALUE;
            } else {
                return String.CASE_INSENSITIVE_ORDER.compare(a, b);
            }
        });
        this.functions = functionNames.stream()
                .map(name -> {
                    setFitnessType(config, name);
                    return fitnessFactory.get();
                })
                .collect(Collectors.toList());

        // restore fitness function
        setFitnessType(config, selectedFunctionName);
    }

    @Override
    public StatisticsWriter init(Instance configuration) {
        return this;
    }

    private Matrix calculateCovarianceMatrix(final Matrix data) {
        final int dimensions = data.nrows();
        final int dataSize = data.ncols();
        final double [] means = data.rowMeans();

        final Matrix covarianceMatrix = new Matrix(dimensions, dimensions);
        for(int x = 0; x < dimensions; ++x) {
            for(int y = 0; y < dimensions; ++y) {
                double value = 0.0;
                for(int t = 0; t < dataSize; ++t) {
                    value += ((data.get(x, t) - means[x])*(data.get(y, t) - means[y]));
                }
                value = value / dataSize;
                covarianceMatrix.set(x, y, value);
            }
        }

        return covarianceMatrix;
    }

    private void calculateCovariance(final Properties candidate, final Object[] data, final int index) {
        final int dimensions = sourceSpec.size();
        final int trainingsSize = sourceTrainingPoints.size();
        final int onTheFlySize = trainingsSize + 1;

        final Matrix trainingsMatrix = new Matrix(dimensions, trainingsSize);
        final Matrix onTheFlyMatrix = new Matrix(dimensions, onTheFlySize);

        // calculate covariance matrix for trainings data
        for(int t = 0; t < trainingsSize; t++) {
            for(int d = 0; d < dimensions; ++d) {
                final double value = sourceTrainingPoints
                                            .get(t)
                                            .getAsDouble(d);
                trainingsMatrix.set(d, t, value);
                onTheFlyMatrix.set(d, t, value);
            }
        }

        for(int d = 0; d < dimensions; ++d) {
            onTheFlyMatrix.set(d, onTheFlySize - 1, candidate.getAsDouble(d));
        }

        final Matrix trainingsCovarianceMatrix = calculateCovarianceMatrix(trainingsMatrix);

        {
            final Matrix onTheFlyCovarianceMatrix = calculateCovarianceMatrix(onTheFlyMatrix);
            calculateDifference(new Matrix(trainingsCovarianceMatrix.toArray()), onTheFlyCovarianceMatrix, data, index);
        }

        {
            final Matrix bestGenerationMatrix = createBestGenerationMatrix();
            final Matrix bestGenerationCovariance = calculateCovarianceMatrix(bestGenerationMatrix);
            calculateDifference(new Matrix(trainingsCovarianceMatrix.toArray()), bestGenerationCovariance, data, index +  dimensions * dimensions + 2);
        }
    }

    private Matrix createBestGenerationMatrix() {
        final List<Candidate> candidates = generationWithBestIndividual.candidates().collect(Collectors.toList());

        final int dimensions = sourceSpec.size();
        final Optional<Integer> optSize = generationWithBestIndividual.candidateCount();
        final int size = optSize.orElse(candidates.size());

        final Matrix result = new Matrix(dimensions, size);

        for(int i = 0; i < size; ++i) {
            final Candidate candidate = candidates.get(i);
            final Properties individual = candidate.searchSpaceRepresentation();

            final Object [] data = individual.getValues();

            for(int j = 0; j < data.length; ++j) {
                result.set(i, j, (Double)data[j]);
            }
        }

        return result;
    }

    private void calculateDifference(final Matrix matrix1, final Matrix matrix2, final Object [] data, final int start) {
        final Matrix differenceMatrix = matrix1.sub(matrix2);
        double sumOfAbs = 0.0;
        double sumOfSquares = 0.0;

        for(int x = 0; x < differenceMatrix.nrows(); ++x) {
            for (int y = 0; y < differenceMatrix.ncols(); ++y) {
                data[start + x * differenceMatrix.nrows() + y] = differenceMatrix.get(x,y);
                sumOfAbs += Math.abs(differenceMatrix.get(x, y));
                sumOfSquares += (Math.pow(differenceMatrix.get(x, y), 2));
            }
        }

        data[start + differenceMatrix.nrows() * differenceMatrix.ncols()] = sumOfAbs;
        data[start + differenceMatrix.nrows() * differenceMatrix.ncols() + 1] = sumOfSquares;
    }

    private Writer createWriter() throws WriterException {
        final List<Column> columns = new ArrayList<>();

        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("individual", ColumnType.String));
        columns.add(new Column("age", ColumnType.Integer));

        final int nmrOfFunctions = functionNames.size();
        for (int i = 0; i < nmrOfFunctions; ++i) {
            columns.add(new Column(functionNames.get(i), ColumnType.Double));
        }

        for (int x = 0; x < sourceSpec.size(); ++x) {
            for (int y = 0; y < sourceSpec.size(); ++y) {
                columns.add(new Column("ind. difference(" + x + "/" + y + ")", ColumnType.Double));
            }
        }
        columns.add(new Column("sum(abs(ind. difference))", ColumnType.Double));
        columns.add(new Column("sum(sqr(ind. difference))", ColumnType.Double));

        for (int x = 0; x < sourceSpec.size(); ++x) {
            for (int y = 0; y < sourceSpec.size(); ++y) {
                columns.add(new Column("pop. difference(" + x + "/" + y + ")", ColumnType.Double));
            }
        }
        columns.add(new Column("sum(abs(pop. difference))", ColumnType.Double));
        columns.add(new Column("sum(sqr(pop. difference))", ColumnType.Double));

        columns.add(new Column("time", ColumnType.Integer));

        return strategy.create("best-individual-statistics", columns);
    }

    private Object[] dataOfBest() {
        fetchTrainingData();

        final Object [] data = new Object[3 + functionNames.size() + (int)Math.pow(sourceSpec.size(), 2) + 2 + (int)Math.pow(sourceSpec.size(), 2) + 2 + 1];

        final Candidate bestCandidate = generationWithBestIndividual.bestCandidate();
        final Properties candidate = bestCandidate.searchSpaceRepresentation();

        data[0] = generationWithBestIndividual.iteration();
        data[1] = Arrays.toString(candidate.getValues());
        data[2] = bestCandidate.age();

        for(int i = 0; i < functions.size(); ++i) {
            final OptimisationValue fitness = (OptimisationValue) functions.get(i).apply(candidate);
            data[3 + i] = fitness;
            throw new IllegalArgumentException("fix me");
        }

        calculateCovariance(candidate, data, 3 + functions.size());

        data[data.length - 1] = endTime - startTime;

        return data;
    }

    private void fetchTrainingData() {
        final PropertiesSpecification spec = PropertiesSpecification.builder()
                                                                    .add(sourceSpec)
                                                                    .add(targetSpec)
                                                                    .build();

        sourceTrainingPoints = manager.getTrainingStream()
                                      .apply(spec)
                                      .collect(Collectors.toList());
    }

    /**
     * Changes the fitness type entry in the given config object.
     */
    private static void setFitnessType(final Instance config, final String name) {
        //config.put("name", name);
        throw new IllegalStateException("We have to change the actual fitness type by looking up the correct definition.");
    }

    @Override
    public void add(final IterationResult result) {
        updateBestGeneration(result);
    }

    private void updateBestGeneration(final IterationResult result) {
        if(generationWithBestIndividual == null) {
            generationWithBestIndividual = result;
        } else if(generationWithBestIndividual.bestCandidate().value().compareTo(result.bestCandidate().value()) <= 0) {
            generationWithBestIndividual = result;
        }
    }

    public void write() {
        endTime = System.currentTimeMillis();
        try {
            final Writer writer = createWriter();

            writer.addRecord(dataOfBest());

            writer.close();
        } catch (final WriterException e) {
            log.error("Failed to write statistics:", e);
        }
    }
}
