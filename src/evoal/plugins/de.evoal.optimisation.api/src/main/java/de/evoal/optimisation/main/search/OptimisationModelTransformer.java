package de.evoal.optimisation.main.search;

import java.util.Collection;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.apache.commons.math3.util.Pair;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.dynamic.ModelTransformer;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.Direction;
import de.evoal.languages.model.ol.OptimisationGoal;
import de.evoal.languages.model.ol.ProblemInstance;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.core.CorePackage;
import de.evoal.models.v202704.optimisation.execution.ExecutionPackage;
import de.evoal.models.v202704.optimisation.model.ModelFactory;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.models.v202704.optimisation.model.Problem;
import de.evoal.models.v202704.optimisation.model.TargetGoal;

/**
 * Transforms a parsed OL file into the runtime model of the optimisation
 *   ({@link OptimisationModule}): the problem with its spaces, goals,
 *   optimisation function and statistics writers, the algorithm configuration
 *   and the statistics writers of the algorithm. Configurations become dynamic
 *   objects of their DL types; the {@code configured-by} constraints
 *   are checked on the result.
 */
@ApplicationScoped
public class OptimisationModelTransformer extends ModelTransformer {
    /**
     * Factory for creating the ecore-based model.
     */
    private final static ModelFactory factory = ModelFactory.eINSTANCE;

    /**
     * Finds the feature of a space class that belongs to a data description.
     */
    @Inject
    private EAnnotationHelper eAnnotationHelper;

    /**
     * Dependency for generating dynamic ecore classes.
     */
    @Inject
    private EClassProvider eClassProvider;

    @Override
    protected Collection<EPackage> mappedPackages() {
        return List.of(CorePackage.eINSTANCE, ExecutionPackage.eINSTANCE);
    }

    /**
     * Transforms a parsed OL file into the runtime model.
     *
     * @param model The parsed OL file.
     * @param space The merged search and optimisation space, used to resolve data references.
     * @return The runtime model.
     * @throws IllegalArgumentException if a {@code document} list contains something other than instances.
     */
    public OptimisationModule transform(de.evoal.languages.model.ol.OptimisationModule model, final Space space) {
        this.space = space;

        OptimisationModule result = factory.createOptimisationModule();
        
        final AlgorithmInstance algorithm = model.getAlgorithm();
        final ProblemInstance problem = algorithm.getProblem();

        result.setProblem(transform(problem));
        result.setAlgorithm(transform(algorithm));

        final Array algorithmDocumentation = algorithm.getDocumentation();
        transformDocumentation(algorithmDocumentation, "the algorithm", result.getDocumentation());

        return checkConfiguredBy(result);
    }

    /**
     * @return The algorithm configuration as a dynamic object of its DL type.
     */
    private Configuration transform(final AlgorithmInstance algorithm) {
        return createDynamic(algorithm);
    }

    /**
     * @return The problem with its search and optimisation space classes, goals,
     *   optimisation function and statistics writers.
     */
    private Problem transform(final ProblemInstance problem) {
        final Problem result = factory.createProblem();
        result.setName(problem.getName());

        final Pair<EClass, EClass> spaceClasses = eClassProvider.eClassFor(problem);

        result.setSearchSpace(spaceClasses.getFirst());
        result.setOptimisationSpace(spaceClasses.getSecond());

        for(final OptimisationGoal goal : problem.getOptimisationSpace()) {
            result.getGoals().add(transform(goal, spaceClasses.getSecond()));
        }

        final Configuration configuration = createDynamic(problem.getOptimisationFunction());
        result.setOptimisationFunction(configuration);

        final Array problemDocumentation = problem.getDocumentation();
        transformDocumentation(problemDocumentation, "problem '" + problem.getName() + "'", result.getDocumentation());

        return result;
    }

    /**
     * @param classifier The optimisation space class that contains the goal's feature.
     * @return The goal (maximise, minimise or target) referring to its feature.
     */
    private de.evoal.models.v202704.optimisation.model.OptimisationGoal transform(final OptimisationGoal goal,
                                                                                  final EClass classifier) {
        final de.evoal.models.v202704.optimisation.model.OptimisationGoal result;

        if(goal.getDirection().equals(Direction.MAXIMISE)) {
            result = factory.createMaximiseGoal();
        } else if(goal.getDirection().equals(Direction.MINIMISE)) {
            result = factory.createMinimiseGoal();
        } else if(goal.getDirection().equals(Direction.TARGET)) {
            result = transform((de.evoal.languages.model.ol.TargetGoal) goal);
        } else {
            throw new InternalError();
        }

        final DataDescription description = (DataDescription) goal.getData().getDefinition();
        final EStructuralFeature feature = eAnnotationHelper.featureOf(classifier, description);
        result.setData(feature);

        return result;
    }

    /**
     * @return The target goal with its constant target or the marker that the target is
     *   taken from the evaluation, and the configuration of its distance. The data is set
     *   by the caller.
     */
    private TargetGoal transform(final de.evoal.languages.model.ol.TargetGoal goal) {
        final TargetGoal result = factory.createTargetGoal();
        result.setFromEvaluation(goal.isFromEvaluation());

        if(!goal.isFromEvaluation()) {
            final Object target = goal.getValue().getValue();
            result.setValue(target);
        }

        final Configuration distance = createDynamic(goal.getDistance());
        result.setDistance(distance);

        return result;
    }

    /**
     * Converts the statistics writers of a {@code document [...]} list into
     *   configurations.
     *
     * @param documentation The writer list from the OL file, or {@code null} if none is given.
     * @param owner The owner of the list in domain terms, used in the error message.
     * @param target The list the configurations are added to.
     * @throws IllegalArgumentException if the list contains something other than instances.
     */
    private void transformDocumentation(final Array documentation,
                                        final String owner,
                                        final List<Configuration> target) {
        if(documentation == null) {
            return;
        }

        for(final Expression writer : documentation.getValues()) {
            if(!(writer instanceof Instance instance)) {
                final String message = "The documentation of " + owner + " may only contain instances, but contains '"
                        + writer + "'.";
                throw new IllegalArgumentException(message);
            }

            final Configuration configuration = createDynamic(instance);
            target.add(configuration);
        }
    }
}
