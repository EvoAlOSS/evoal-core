package de.evoal.surrogate.main.statistics.correlated;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.EObjectStreamSupplier;
import de.evoal.core.api.ecore.stream.FileBasedEObjectStreamSupplier;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.definitions.DataDescription;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import smile.tensor.*;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.properties.Properties;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.api.model.Candidate;
import de.evoal.optimisation.api.model.Iteration;
import de.evoal.optimisation.api.statistics.io.Writer;
import de.evoal.optimisation.api.statistics.io.WriterException;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.Column;
import de.evoal.optimisation.api.statistics.writer.ColumnType;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;


/**
 * Small helper class for collecting and writing the generation-based statistics.
 */
@Slf4j
@Named("de.evoal.surrogate.optimisation.correlated")
@Dependent
public class GenerationStatisticsWriter implements StatisticsWriter {
    @Inject
    private EAnnotationHelper helper;

    @Inject
    private AttributeHelper attribute;

    @Inject
    private EClassProvider dynamic;

    private long endTime;

    private Iteration firstGeneration;

    private Iteration generationWithBestIndividual;

    private long startTime;

    @Inject
    private Blackboard board;

    private Space sourceSpec;

    private Space targetSpec;


    private List<TypedEObject> sourceTrainingPoints;

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
    public StatisticsWriter init(final Instance configuration) {
        try {
            final List<DataDescription> inputSpace = attribute.lookup(configuration, "input-space");
            final List<DataDescription> outputSpace = attribute.lookup(configuration, "output-space");

            final EClass dynamicEClass = dynamic.eClassFor(inputSpace, outputSpace);
            final Space dynamicSpace = new Space(dynamicEClass);
            sourceSpec = helper.subSpaceOf(dynamicSpace, inputSpace);
            targetSpec = helper.subSpaceOf(dynamicSpace, outputSpace);

            this.writer = createWriter();
        } catch (WriterException e) {
            log.error("Could not create Correlated Statistics Writer: ", e);
        }
        return this;
    }

    private DenseMatrix calculateCovarianceMatrix(final DenseMatrix data) {
        final int dimensions = data.nrow();
        final int dataSize = data.ncol();
        final Vector means = data.rowMeans();

        final DenseMatrix covarianceMatrix = DenseMatrix.zeros(ScalarType.Float64, dimensions, dimensions);
        for(int x = 0; x < dimensions; ++x) {
            for(int y = 0; y < dimensions; ++y) {
                double value = 0.0;
                for(int t = 0; t < dataSize; ++t) {
                    value += ((data.get(x, t) - means.get(x))*(data.get(y, t) - means.get(y)));
                }
                value = value / dataSize;
                covarianceMatrix.set(x, y, value);
            }
        }

        return covarianceMatrix;
    }

    private void calculateCovariance(final Properties candidate, final Object[] data, final int index) {
        final int dimensions = sourceSpec.size();
        List<Candidate> candidateList = firstGeneration.candidates().toList();

        final int trainingsSize = candidateList.size();
        log.info("training size is {}.", trainingsSize);
        final int onTheFlySize = trainingsSize + 1;

        final DenseMatrix trainingsMatrix = DenseMatrix.zeros(ScalarType.Float64, dimensions, trainingsSize);
        final DenseMatrix onTheFlyMatrix = DenseMatrix.zeros(ScalarType.Float64, dimensions, onTheFlySize);

        final List<EStructuralFeature> features = new ArrayList<>(sourceSpec.size());
        sourceSpec.iterator().forEachRemaining(features::add);

        // calculate covariance matrix for trainings data
        for(int t = 0; t < trainingsSize; t++) {
            for(int d = 0; d < dimensions; ++d) {

                // According to the specification of the used toList collector, sourceTrainingPoints is an ArrayList,
                //   making the .get call an O(1) operation
                final double value = sourceTrainingPoints
                        .get(t)
                        .eGetAsDouble(features.get(d));
                trainingsMatrix.set(d, t, value);
                onTheFlyMatrix.set(d, t, value);
            }
        }

        for(int d = 0; d < dimensions; ++d) {
            onTheFlyMatrix.set(d, onTheFlySize - 1, candidate.getAsDouble(d));
        }

        final DenseMatrix trainingsCovarianceMatrix = calculateCovarianceMatrix(trainingsMatrix);
        final DenseMatrix firstGenerationMatrix = createFirstGenerationMatrix();
        final DenseMatrix firstGenerationCovariance = calculateCovarianceMatrix(firstGenerationMatrix);

        {
            final DenseMatrix onTheFlyCovarianceMatrix = calculateCovarianceMatrix(onTheFlyMatrix);
            calculateDifference(firstGenerationCovariance, onTheFlyCovarianceMatrix, data, index);
        }

        {
            final DenseMatrix bestGenerationMatrix = createBestGenerationMatrix();
            final DenseMatrix bestGenerationCovariance = calculateCovarianceMatrix(bestGenerationMatrix);
            calculateDifference(firstGenerationCovariance, bestGenerationCovariance, data, index +  dimensions * dimensions + 2);
        }
    }

    private DenseMatrix createBestGenerationMatrix() {
        final List<Candidate> individuals = generationWithBestIndividual.candidates().toList();

        final int dimensions = sourceSpec.size();
        final Optional<Integer> optSize = generationWithBestIndividual.candidateCount();
        final int size = optSize.orElse(individuals.size());

        final DenseMatrix result = DenseMatrix.zeros(ScalarType.Float64, dimensions, size);

        for(int i = 0; i < size; ++i) {
            final Candidate candidate = individuals.get(i);
            final Properties individual = candidate.searchSpaceRepresentation();

            final Object [] data = individual.getValues();

            for(int j = 0; j < data.length; ++j) {
                result.set(i, j, (Double)data[j]);
            }
        }

        return result;
    }

    private DenseMatrix createFirstGenerationMatrix() {
        final List<Candidate> candidates = firstGeneration.candidates().collect(Collectors.toList());

        final int dimensions = sourceSpec.size();
        final Optional<Integer> optSize = firstGeneration.candidateCount();
        final int size = optSize.orElse(candidates.size());

        final DenseMatrix result = DenseMatrix.zeros(ScalarType.Float64, dimensions, size);

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

    private void calculateDifference(final DenseMatrix matrix1, final DenseMatrix matrix2, final Object [] data, final int start) {
        final DenseMatrix differenceMatrix = matrix1.sub(matrix2);
        double sumOfAbs = 0.0;
        double sumOfSquares = 0.0;

        for(int x = 0; x < differenceMatrix.nrow(); ++x) {
            for (int y = 0; y < differenceMatrix.ncol(); ++y) {
                data[start + x * differenceMatrix.nrow() + y] = differenceMatrix.get(x,y);
                sumOfAbs += Math.abs(differenceMatrix.get(x, y));
                sumOfSquares += (Math.pow(differenceMatrix.get(x, y), 2));
            }
        }

        data[start + differenceMatrix.nrow() * differenceMatrix.ncol()] = sumOfAbs;
        data[start + differenceMatrix.nrow() * differenceMatrix.ncol() + 1] = sumOfSquares;
    }

    private Writer createWriter() throws WriterException {
        final List<Column> columns = new ArrayList<>();

        columns.add(new Column("generation", ColumnType.Integer));
        columns.add(new Column("individual", ColumnType.String));
        columns.add(new Column("age", ColumnType.Integer));

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

        calculateCovariance(candidate, data, 2 + 1);
        data[data.length - 1] = endTime - startTime;

        return data;
    }

    private void fetchTrainingData() {
        final Space spec = sourceSpec.merge(targetSpec);

        sourceTrainingPoints = createStreamFromBlackboard(spec)
                .apply(spec)
                .toList();
    }

    @Override
    public void add(final Iteration result) {
        updateBestGeneration(result);
    }

    private void updateBestGeneration(final Iteration result) {
        if(generationWithBestIndividual == null) {
            firstGeneration = result;
            generationWithBestIndividual = result;
        } else {
            boolean isBetter = generationWithBestIndividual.bestCandidate().value().isBetter(result.bestCandidate().value());
            if (isBetter) {
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

    private EObjectStreamSupplier createStreamFromBlackboard(final Space specification) {
        final String filename = board.get(SurrogateBlackboardEntries.SURROGATE_TRAINING_DATA_FILE);

        log.info("Using training data from {} for statistics.", filename);

        final File trainingFile = new File(filename);

        return new FileBasedEObjectStreamSupplier(trainingFile, specification);
    }
}
