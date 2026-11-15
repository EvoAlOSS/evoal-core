package de.evoal.optimisation.main.initial;

import de.evoal.core.api.ecore.stream.EObjectStreamSupplier;
import de.evoal.core.api.ecore.stream.FileBasedEObjectStreamSupplier;
import de.evoal.core.api.ecore.stream.ListBasedEObjectStreamSupplier;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.VariableToEObjectHelper;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.random.RandomGenerator;
import java.io.File;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Named("de.evoal.optimisation.core.specify-candidates")
@Dependent
public class SpecifiedInitialCandidates implements InitialCandidatesProvider {

    @Inject
    @Named("search-space")
    private Space searchSpace;

    private EObjectStreamSupplier streamSupplier;

    @Inject
    private AttributeHelper helper;

    private boolean random;

    @Inject
    protected VariableToEObjectHelper toEObjectHelper;

    @Inject
    private RandomService randomService;

    private Stream<TypedEObject> createInitialPopulation() {
        final List<TypedEObject> objects = streamSupplier
                .apply(searchSpace)
                .toList();

        // random or linearly ordered infinite properties stream
        return getStreamByOrder(objects);
    }

    @Override
    public InitialCandidatesProvider init(final EObject configuration) {
        final EStructuralFeature candidateFile = configuration.eClass().getEStructuralFeature("candidate-file");
        final EStructuralFeature variableList = configuration.eClass().getEStructuralFeature("candidate-list");

        final boolean hasFile = candidateFile != null && configuration.eIsSet(candidateFile);
        final boolean hasList = variableList  != null && configuration.eIsSet(variableList);

        this.random = helper.lookup(configuration, "random");

        if(!hasFile && !hasList) {
            log.error("No candidates have been specified! Please specify candidate list or candidates from file");
        } else if(!hasFile) {
            //read list of instances from attribute
            final List<EObject> candidates = helper.lookup(configuration, "candidate-list");
            streamSupplier = createStreamFromCandidateList(candidates);
        } else {
            //create stream from file, this takes priority over candidate list
            final String filename = helper.lookup(configuration, "candidate-file");
            streamSupplier = createStreamFromFilename(filename);        }

        return this;
    }

    private EObjectStreamSupplier createStreamFromFilename(final String filename) {
        log.info("Creating stream supplier from candidates in {}.", filename);
        final File candidateFile = new File(filename);

        return new FileBasedEObjectStreamSupplier(candidateFile, searchSpace);
    }

    private EObjectStreamSupplier createStreamFromCandidateList(List<EObject> candidates) {
        log.info("Creating stream supplier from candidates specified in .ol file.");

        //generate list of properties from candidates
        List<TypedEObject> properties = new ArrayList<>();
        for (final EObject i : candidates) {
            final TypedEObject object = toEObjectHelper.fromCandidate(i, searchSpace);

            log.info("read properties {}", object);
            properties.add(object);
        }

        return new ListBasedEObjectStreamSupplier(properties);
    }

    private Stream<TypedEObject> getStreamByOrder(final List<TypedEObject> objects) {
        if (this.random) {
            log.info("Creating initial candidates stream with random order");
            final int upperLimit = objects.size();
            final RandomGenerator random = randomService.random("de.evoal.optimisation.core.specify-candidates");
            final Supplier<TypedEObject> chooseRandomly = () -> {
                int index = random.nextInt(upperLimit);
                return objects.get(index);
            };

            return Stream.iterate(chooseRandomly.get(), x -> chooseRandomly.get());
        } else {
            log.info("Creating initial candidates stream with linear order");
            return Stream
                    .iterate(0, i -> (i + 1) % objects.size())
                    .map(objects::get);
        }
    }

    @Override
    public Stream<TypedEObject> create() {
        return createInitialPopulation();
    }
}