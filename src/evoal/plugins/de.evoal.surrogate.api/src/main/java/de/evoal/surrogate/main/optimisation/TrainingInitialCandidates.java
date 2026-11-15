package de.evoal.surrogate.main.optimisation;

import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.ecore.stream.EObjectStreamSupplier;
import de.evoal.core.api.ecore.stream.FileBasedEObjectStreamSupplier;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.io.File;
import java.util.List;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

@Slf4j
@Named("de.evoal.surrogate.optimisation.training")
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

    private Space mergedSpace;

    private EObjectStreamSupplier streamSupplier;

    @Inject
    private AttributeHelper helper;

    @Inject
    private RandomService randomService;

    private Stream<TypedEObject> createInitialPopulation() {
        final List<TypedEObject> properties = streamSupplier.apply(mergedSpace)
                        .toList();
        final int upperLimit = properties.size();
        final RandomGenerator random = randomService.random("de.evoal.surrogate.optimisation.training");
        final Supplier<TypedEObject> chooseRandomly = () -> {
            int index = random.nextInt(upperLimit);
            return properties.get(index);
        };

        return Stream.iterate(chooseRandomly.get(), x -> chooseRandomly.get());
    }

    @Override
    public InitialCandidatesProvider init(final EObject configuration) {
        mergedSpace = sourceSpecification.merge(targetSpecification);

        final EStructuralFeature trainingFile = configuration.eClass().getEStructuralFeature("training-file");
        if(configuration.eIsSet(trainingFile)) {
            streamSupplier = createStreamFromConfiguration(configuration);
        } else {
            streamSupplier = createStreamFromBlackboard();
        }

        return this;
    }

    private EObjectStreamSupplier createStreamFromBlackboard() {
        final String filename = board.get(SurrogateBlackboardEntries.SURROGATE_TRAINING_DATA_FILE);

        return createStreamFromFilename(filename);
    }

    private EObjectStreamSupplier createStreamFromConfiguration(final EObject configuration) {
        final String filename = helper.lookup(configuration, "training-file");

        return createStreamFromFilename(filename);
    }


    private EObjectStreamSupplier createStreamFromFilename(final String filename) {
        log.info("Using training data from {} for population.", filename);

        final File trainingFile = new File(filename);
        return new FileBasedEObjectStreamSupplier(trainingFile, mergedSpace);
    }

    @Override
    public Stream<TypedEObject> create() {
        return createInitialPopulation();
    }
}
