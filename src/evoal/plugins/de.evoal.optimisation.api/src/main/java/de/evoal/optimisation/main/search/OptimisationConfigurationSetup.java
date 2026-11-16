package de.evoal.optimisation.main.search;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EClass;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.producer.SpaceProducer;
import de.evoal.optimisation.main.producer.OptimisationModuleLoader;

/**
 * Prepares the optimisation configuration of an OL file for the search applications:
 *   it loads the file, sets up the search and optimisation space, transforms the OL
 *   model into the runtime model and binds the runtime model to
 *   {@link OptimisationBlackboardEntries#OPTIMISATION_CONFIGURATION}.
 */
@ApplicationScoped
@Slf4j
public class OptimisationConfigurationSetup {
    @Inject
    private Blackboard board;

    @Inject
    private EClassProvider eClassProvider;

    @Inject
    private OptimisationModuleLoader loader;

    @Inject
    private SpaceProducer spaceProducer;

    @Inject
    private OptimisationModelTransformer transformer;

    /**
     * Loads and prepares the configuration.
     *
     * @param configurationFile The OL file.
     * @return The runtime model of the configuration.
     */
    public OptimisationModule setUp(final String configurationFile) {
        final de.evoal.languages.model.ol.OptimisationModule configurationModel = loader.load(configurationFile);
        setupSpaces(configurationModel);

        final Space merged = spaceProducer.optimisationSpace()
                                          .merge(spaceProducer.searchSpace());

        final OptimisationModule runtimeModel = transformer.transform(configurationModel, merged);
        board.bind(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, runtimeModel);

        return runtimeModel;
    }

    private void setupSpaces(final de.evoal.languages.model.ol.OptimisationModule module) {
        log.info("Setting up search and optimisation space.");

        final Pair<EClass, EClass> spaceClasses = eClassProvider.eClassFor(module.getProblem());

        spaceProducer.setSearchSpace(new Space(spaceClasses.getFirst()));
        spaceProducer.setOptimisationSpace(new Space(spaceClasses.getSecond()));
    }
}
