package de.evoal.surrogate.main.statistics.correlated;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.optimisation.api.model.OptimisationValue;
import de.evoal.optimisation.api.statistics.Candidate;
import de.evoal.optimisation.api.statistics.IterationResult;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.languages.model.base.Instance;
import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.surrogate.api.training.TrainingDataManager;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import lombok.extern.slf4j.Slf4j;

import smile.math.matrix.Matrix;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("de.evoal.surrogate.optimisation.correlated")
@Dependent
public class GenerationStatisticsWriter implements StatisticsWriter {

    @Inject
    private AttributeHelper helper;

    private long startTime;

    private IterationResult generationWithBestIndividual;
    private long endTime;

    @Inject @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.optimisation-function")
    private Instance config;

    @Inject
    private TrainingDataManager manager;

    @Inject @Named("surrogate-source-properties-specification")
    private PropertiesSpecification sourceSpec;

    @Inject @Named("surrogate-target-properties-specification")
    private PropertiesSpecification targetSpec;

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "problem.maximise")
    private boolean maximise;
    private List<Properties> sourceTrainingPoints;

    private Writer writer;

    /**
     * Creates a new GenerationStatistics instance.
     */

    @Inject
    @Named("csv")
    private WriterStrategy strategy;

    @PostConstruct
    public void init() {
        startTime = System.currentTimeMillis();
    }

    @Override
    public StatisticsWriter init(Instance configuration) {
        try {
            this.writer = createWriter();
        } catch (WriterException e) {
            log.error("Could not create Correlated Statistics Writer: ", e);
        }
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
        columns.add(new Column("fitness-function", ColumnType.Double));

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

        final Object [] data = new Object[3 + 1 + (int)Math.pow(sourceSpec.size(), 2) + 2 + (int)Math.pow(sourceSpec.size(), 2) + 2 + 1];
        final Candidate bestCandidate = generationWithBestIndividual.bestCandidate();
        final Properties candidate = bestCandidate.searchSpaceRepresentation();

        data[0] = generationWithBestIndividual.iteration();
        data[1] = Arrays.toString(candidate.getValues());
        data[2] = bestCandidate.age();
        final OptimisationValue fitness = (OptimisationValue) bestCandidate.value();
        data[3] = fitness;

        calculateCovariance(candidate, data, 3 + 1);
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

    @Override
    public void add(final IterationResult result) {
        updateBestGeneration(result);
    }

    private void updateBestGeneration(final IterationResult result) {
        if(generationWithBestIndividual == null) {
            generationWithBestIndividual = result;
        } else {
            int comparison = generationWithBestIndividual.bestCandidate().value().compareTo(result.bestCandidate().value());
            if (this.maximise && comparison <= 0 || !this.maximise && comparison >= 0) {
                generationWithBestIndividual = result;
            }
        }
    }

    public void write() {
        endTime = System.currentTimeMillis();
        try {
            writer.addRecord(dataOfBest());

            strategy.close(writer);
        } catch (final WriterException e) {
            log.error("Failed to write statistics:", e);
        }
    }
}
