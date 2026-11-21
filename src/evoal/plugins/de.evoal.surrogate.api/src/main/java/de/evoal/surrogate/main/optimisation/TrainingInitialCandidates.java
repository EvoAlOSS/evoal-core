package de.evoal.surrogate.main.optimisation;

import java.io.File;
import java.util.List;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.ecore.stream.FileBasedEObjectStreamSupplier;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import de.evoal.surrogate.api.TrainingData;

/**
 * Initial candidates drawn uniformly with repetition from training data (DL type
 *   {@code 'training-population'}): from its {@code 'training-file'}, or, if it has none,
 *   from the training data of the run, which is read once from the file of the command-line
 *   entry {@code surrogate:training-data-file} and kept on the blackboard as
 *   {@code surrogate:training-data}. Without both, the population is rejected when it is
 *   created.
 */
@Slf4j
@Named("de.evoal.surrogate.optimisation.training-population")
@Dependent
public class TrainingInitialCandidates implements InitialCandidatesProvider {
    @Inject
    private Blackboard board;

    @Inject
    @Named("search-space")
    private Space sourceSpecification;

    @Inject
    @Named("optimisation-space")
    private Space targetSpecification;

    @Inject
    private AttributeHelper helper;

    @Inject
    private RandomService randomService;

    /**
     * Supplies the training data when the population is created.
     */
    private Supplier<List<TypedEObject>> trainingData;

    @Override
    public InitialCandidatesProvider init(final EObject configuration) throws InitializationException {
        final EStructuralFeature trainingFile = configuration.eClass().getEStructuralFeature("training-file");
        if(configuration.eIsSet(trainingFile)) {
            final String filename = helper.lookup(configuration, "training-file");
            trainingData = () -> read(filename);
            return this;
        }

        final String filename = board.getOrNull(SurrogateBlackboardEntries.SURROGATE_TRAINING_DATA_FILE);
        if(filename == null) {
            throw new InitializationException("The 'training-population' needs its 'training-file' or the training data of the run"
                                              + " (-B" + SurrogateBlackboardEntries.SURROGATE_TRAINING_DATA_FILE + "=<file>).");
        }
        trainingData = () -> runData(filename).candidates();

        return this;
    }

    /**
     * @return The training data of the run, read from the file at the first call.
     */
    private TrainingData runData(final String filename) {
        synchronized(board) {
            TrainingData data = board.getOrNull(SurrogateBlackboardEntries.SURROGATE_TRAINING_DATA);
            if(data == null) {
                data = new TrainingData(filename, read(filename));
                board.bind(SurrogateBlackboardEntries.SURROGATE_TRAINING_DATA, data);
            }

            return data;
        }
    }

    private List<TypedEObject> read(final String filename) {
        log.info("Using training data from {} for population.", filename);

        // the training data holds the search and the optimisation variables
        final Space space = sourceSpecification.merge(targetSpecification);
        return new FileBasedEObjectStreamSupplier(new File(filename), space).apply(space)
                                                                            .toList();
    }

    @Override
    public Stream<TypedEObject> create() {
        final List<TypedEObject> candidates = trainingData.get();
        if(candidates.isEmpty()) {
            throw new IllegalStateException("The training data of the 'training-population' has no data points.");
        }

        final RandomGenerator random = randomService.random("de.evoal.surrogate.optimisation.training-population");
        final Supplier<TypedEObject> draw = () -> candidates.get(random.nextInt(candidates.size()));

        return Stream.iterate(draw.get(), previous -> draw.get());
    }
}
