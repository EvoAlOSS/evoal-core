package de.evoal.surrogate.api.training;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.ecore.Space;
import de.evoal.core.api.ecore.TypedEObject;
import de.evoal.core.api.ecore.stream.EObjectPairStreamSupplier;
import de.evoal.core.api.ecore.stream.FileBasedEObjectStreamSupplier;
import de.evoal.core.api.utils.Requirements;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.mll.TaskDescription;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EcorePackage;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.File;
import java.util.*;
import java.util.stream.Stream;

@Slf4j
@Dependent
public class TrainingTaskHelper {
    /**
     * Ecore package for checking types.
     */
    private final static EcorePackage ePackage = EcorePackage.eINSTANCE;

    @Inject
    private EAnnotationHelper provider;

    private List<File> collectInputFiles(final EList<String> inputConfiguration) {
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

    public Stream<TypedEObject> loadInputStreams(final InterpreterState context) {
        final TaskDescription task = (TaskDescription)context.getByName("learning-task");

        // collect data to load and mapping from specifications to features
        final List<DataDescription> specifications =
            Stream.concat(
                    task.getInputs().stream(),
                    task.getOutputs().stream())
                    .toList();

        final Space trainingSpace = provider.subSpaceOf(context.getSpace(), specifications);
        final List<File> inputs = collectInputFiles(task.getLearningData());

        Stream<@NonNull TypedEObject> result = Stream.empty();

        for(final File input : inputs) {
            final Stream<TypedEObject> stream = load(input, trainingSpace);
            result = Stream.concat(result, stream);
        }

        return result;
    }

    private Stream<TypedEObject> load(final File file, final Space space) {
        log.info("Reading data from {}", file.getAbsolutePath());
        Requirements.requireTrue(file.exists());
        Requirements.requireTrue(file.canRead());

        return new FileBasedEObjectStreamSupplier(file, space).get();
    }

    public EObjectPairStreamSupplier loadTrainingDataPaired(final InterpreterState context) {
        return new EObjectPairStreamSupplier() {

            @Override
            public Stream<EObjectPair> get() {
                final Stream<TypedEObject> stream = loadInputStreams(context);

                return stream.map(o -> new EObjectPair(o, o));
            }
        };
    }
}
