package de.evoal.optimisation.main.search;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.apache.commons.math3.util.Pair;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.OLPackage;
import de.evoal.languages.model.ol.ProblemInstance;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.producer.SpaceProducer;
import de.evoal.optimisation.main.constraints.ConstraintGroupCheck;
import de.evoal.optimisation.main.producer.OptimisationModuleLoader;

/**
 * Prepares the optimisation configuration of an OL file for the search applications:
 *   it loads the file, sets up the search and optimisation space, transforms the OL
 *   model into the runtime model, checks its constraint groups
 *   ({@link ConstraintGroupCheck}) and binds the runtime model to
 *   {@link OptimisationBlackboardEntries#OPTIMISATION_CONFIGURATION}.
 * <p>
 * The problem of a run is the problem of its algorithm configuration
 *   ({@code configure … for <problem>}, {@link #problemOf}); it may be specified in the same
 *   module or in an imported one ({@code import "optimisation" from …;}).
 */
@ApplicationScoped
@Slf4j
public class OptimisationConfigurationSetup {
    @Inject
    private Blackboard board;

    /**
     * Checks the constraint groups of the configuration.
     */
    @Inject
    private ConstraintGroupCheck constraintGroups;

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
        setupSpaces(problemOf(configurationModel));

        final Space merged = spaceProducer.optimisationSpace()
                                          .merge(spaceProducer.searchSpace());

        final OptimisationModule runtimeModel = transformer.transform(configurationModel, merged);
        constraintGroups.check(runtimeModel);
        board.bind(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, runtimeModel);

        return runtimeModel;
    }

    /**
     * @param module The OL module of the configuration.
     * @return The problem of the run: the problem of the algorithm configuration.
     * @throws IllegalArgumentException if the module configures no algorithm, its problem
     *   cannot be found, or the module specifies another problem than the one of its
     *   algorithm.
     */
    public static ProblemInstance problemOf(final de.evoal.languages.model.ol.OptimisationModule module) {
        final AlgorithmInstance algorithm = module.getAlgorithm();
        if(algorithm == null) {
            throw new IllegalArgumentException("The module '" + module.getName() + "' configures no algorithm "
                                               + "(configure … for <problem>).");
        }

        final ProblemInstance problem = algorithm.getProblem();
        if(problem == null || problem.eIsProxy()) {
            throw new IllegalArgumentException("The algorithm of the module '" + module.getName() + "' is configured for "
                                               + "the problem '" + referencedProblem(algorithm) + "', which cannot be "
                                               + "found. Specify it in the module or import its module with "
                                               + "import \"optimisation\" from …;.");
        }

        final ProblemInstance own = module.getProblem();
        if(own != null && own != problem) {
            throw new IllegalArgumentException("The module '" + module.getName() + "' specifies the problem '"
                                               + own.getName() + "', but configures its algorithm for the problem '"
                                               + problem.getName() + "'. A module may only specify the problem of its "
                                               + "algorithm.");
        }

        return problem;
    }

    /**
     * @return The problem reference of the algorithm as written in the OL file.
     */
    private static String referencedProblem(final AlgorithmInstance algorithm) {
        final List<INode> nodes = NodeModelUtils.findNodesForFeature(algorithm, OLPackage.Literals.ALGORITHM_INSTANCE__PROBLEM);
        if(nodes.isEmpty()) {
            return "?";
        }

        return NodeModelUtils.getTokenText(nodes.getFirst());
    }

    private void setupSpaces(final ProblemInstance problem) {
        log.info("Setting up search and optimisation space of the problem '{}'.", problem.getName());

        final Pair<EClass, EClass> spaceClasses = eClassProvider.eClassFor(problem);

        spaceProducer.setSearchSpace(new Space(spaceClasses.getFirst()));
        spaceProducer.setOptimisationSpace(new Space(spaceClasses.getSecond()));
    }
}
