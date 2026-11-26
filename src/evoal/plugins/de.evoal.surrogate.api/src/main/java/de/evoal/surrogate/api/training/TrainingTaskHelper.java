package de.evoal.surrogate.api.training;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.FileBasedEObjectStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.execution.ExecutionFactory;
import de.evoal.languages.model.execution.NamedVariable;
import de.evoal.languages.model.mll.TaskDescription;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import java.io.File;
import java.util.*;
import java.util.stream.Stream;

/**
 * Loads the training and test data of a surrogate training.
 */
@Slf4j
@Dependent
public class TrainingTaskHelper {
    /**
     * The name of the variable in the outermost interpreter state that holds the files and
     *   features that {@code 'training-data-loader'} loaded.
     */
    private static final String TRAINING_DATA = "training-data";

    /**
     * The files and features that {@code 'training-data-loader'} loaded.
     */
    private record TrainingData(List<String> files, List<EStructuralFeature> features) {
    }

    @Inject
    private EAnnotationHelper provider;

    private List<File> collectInputFiles(final List<String> inputConfiguration) {
        // TODO collect all from directories and stuff

        List<File> inputs = inputConfiguration
                .stream()
                .map(File::new)
                .toList();

        inputs.stream()
                .filter(File::isDirectory)
                .forEach(f -> log.warn("Ignoring input {} since it is a directory", f));

        inputs = inputs.stream()
                .filter(File::isFile)
                .toList();

        return inputs;
    }

    /**
     * Loads the training data again, e.g. for the parts of a resampling scheme: the files and
     *   features that {@code 'training-data-loader'} loaded, or the training data of the
     *   learning task ({@code learning from [...]}) if no loader ran, with additional features
     *   read from the same files, e.g. the feature that names the block of a row in a block
     *   cross-validation. The rows have not passed {@code validation}.
     *
     * @param context The state of the interpreter, which holds the learning task.
     * @param additional Features to read in addition to the loaded ones.
     * @return The data objects of all training files, file after file.
     */
    public Stream<TypedEObject> loadInputStreams(final InterpreterState context, final @NonNull List<EStructuralFeature> additional) {
        final List<String> files;
        final List<EStructuralFeature> features = new ArrayList<>();
        if(context.root().getByName(TRAINING_DATA) instanceof TrainingData loaded) {
            files = loaded.files();
            features.addAll(loaded.features());
        } else {
            final TaskDescription task = (TaskDescription)context.getByName("learning-task");
            files = task.getLearningData();
            features.addAll(provider.subSpaceOf(context.getSpace(), Stream.concat(task.getInputs().stream(), task.getOutputs().stream()).toList())
                                    .stream()
                                    .toList());
        }

        additional.stream()
                  .filter(feature -> !features.contains(feature))
                  .forEach(features::add);

        return load(context, files, features);
    }

    /**
     * Loads the training data of {@code 'training-data-loader'} and records the files and
     *   features, so that the goodness of fit on the training data and the estimates of the
     *   adaption use the same data.
     *
     * @param context The state of the interpreter.
     * @param files The files to read, relative to the working folder.
     * @param features The features to read.
     * @return The data objects of all files, file after file.
     */
    public Stream<TypedEObject> loadTrainingData(final InterpreterState context, final @NonNull List<String> files, final @NonNull List<EStructuralFeature> features) {
        final NamedVariable variable = ExecutionFactory.eINSTANCE.createNamedVariable();
        variable.setName(TRAINING_DATA);
        context.root().put(variable, new TrainingData(List.copyOf(files), List.copyOf(features)));

        return load(context, files, features);
    }

    /**
     * Loads the test data of {@code 'test-data-loader'}.
     *
     * @param context The state of the interpreter.
     * @param files The files to read, relative to the working folder.
     * @param features The features to read.
     * @return The data objects of all files, file after file.
     * @throws IllegalStateException if no file is given.
     */
    public Stream<TypedEObject> loadTestData(final InterpreterState context, final @NonNull List<String> files, final @NonNull List<EStructuralFeature> features) {
        if(files.isEmpty()) {
            throw new IllegalStateException("The testing use case needs test data: add 'testing with [\"<file>\"]' to 'specify learning-task' of the MLL file or 'testing-files' to 'test-data-loader'.");
        }

        return load(context, files, features);
    }

    /**
     * Loads the given files for the given features.
     */
    private Stream<TypedEObject> load(final InterpreterState context, final List<String> files, final List<EStructuralFeature> features) {
        return loadFiles(collectInputFiles(files), context.getSpace().subSpace(features));
    }

    private Stream<TypedEObject> loadFiles(final List<File> files, final Space space) {
        Stream<@NonNull TypedEObject> result = Stream.empty();

        for(final File input : files) {
            result = Stream.concat(result, load(input, space));
        }

        return result;
    }

    /**
     * Reads a file. A row without a value for a feature of the space (e.g. a missing value of an
     *   ARFF file) is left out, with one warning for the file (#356).
     */
    private Stream<TypedEObject> load(final File file, final Space space) {
        log.info("Reading data from {}", file.getAbsolutePath());
        Requirements.requireTrue(file.exists());
        Requirements.requireTrue(file.canRead());

        return new FileBasedEObjectStreamSupplier(file, space).apply(space);
    }
}
