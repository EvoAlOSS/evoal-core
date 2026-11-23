package de.evoal.optimisation.main.statistics.memory;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.base.definitions.UntypedBaseDataDescription;
import de.evoal.languages.model.dynamic.DefinitionMapping;
import de.evoal.languages.model.dynamic.DynamicFactory;
import de.evoal.languages.model.dynamic.DynamicPackage;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.core.CorePackage;
import de.evoal.models.v202704.optimisation.memory.Execution;
import de.evoal.models.v202704.optimisation.memory.FitnessComponentDefinition;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.IndividualRecord;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricKind;
import de.evoal.models.v202704.optimisation.memory.MetricScope;
import de.evoal.models.v202704.optimisation.memory.MetricValueType;
import de.evoal.models.v202704.optimisation.memory.Rank;
import de.evoal.models.v202704.optimisation.memory.Relationship;
import de.evoal.models.v202704.optimisation.model.MinimiseGoal;
import de.evoal.models.v202704.optimisation.model.ModelFactory;
import de.evoal.models.v202704.optimisation.model.Problem;
import de.evoal.models.v202704.optimisation.model.TargetGoal;

import de.evoal.optimisation.api.fitness.Goals;
import de.evoal.optimisation.api.fitness.TargetDistance;

/**
 * Builds small memory models for the tests of the memory model writer: a problem with a
 *   two-dimensional real search space ({@code x:0} with declared bounds and scale,
 *   {@code x:1} without) and a real optimisation space ({@code y:0}) that is minimised, so
 *   the fitness of an individual is its objective.
 */
final class MemoryModels {
    /**
     * The search space.
     */
    static final Space SEARCH_SPACE = space(feature("x:0", true), feature("x:1", false));

    /**
     * The optimisation space.
     */
    static final Space OPTIMISATION_SPACE = space(feature("y:0", false));

    private MemoryModels() {
    }

    private static void addBounds(final EAttribute feature) {
        final EAnnotation boundary = EcoreFactory.eINSTANCE.createEAnnotation();
        boundary.setSource(FeatureBoundaries.BOUNDARIES_SOURCE);
        boundary.getDetails().put(FeatureBoundaries.LOWER, "-5.0");
        boundary.getDetails().put(FeatureBoundaries.LOWER_INCLUSIVE, "true");
        boundary.getDetails().put(FeatureBoundaries.UPPER, "5.0");
        boundary.getDetails().put(FeatureBoundaries.UPPER_INCLUSIVE, "false");

        feature.getEAnnotations().add(boundary);
    }

    private static void addDataDescription(final EAttribute feature) {
        final UntypedBaseDataDescription description = DefinitionsFactory.eINSTANCE.createUntypedBaseDataDescription();
        description.setName(feature.getName());
        description.setScale(ScaleType.QUOTIENT);

        final DefinitionMapping mapping = DynamicFactory.eINSTANCE.createDefinitionMapping();
        mapping.setSource(description);
        mapping.setTarget(feature);

        final EAnnotation annotation = EcoreFactory.eINSTANCE.createEAnnotation();
        annotation.setSource(DynamicPackage.eNS_URI);
        annotation.getContents().add(mapping);

        feature.getEAnnotations().add(annotation);
    }

    /**
     * @return The configuration of an algorithm of the DL type {@code de.evoal.test.algorithm}.
     */
    static EObject algorithmConfiguration() {
        return configuration("algorithm");
    }

    /**
     * @return A configuration without attributes of the DL type {@code de.evoal.test.<name>}.
     */
    static Configuration configuration(final String name) {
        final EPackage root = EcoreFactory.eINSTANCE.createEPackage();
        final EPackage module = EcoreFactory.eINSTANCE.createEPackage();
        module.setName("de.evoal.test");
        root.getESubpackages().add(module);

        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        type.setName(name);
        type.getESuperTypes().add(CorePackage.Literals.CONFIGURATION);
        module.getEClassifiers().add(type);

        return (Configuration) EcoreUtil.create(type);
    }

    /**
     * @return The configuration of the DL type {@code de.evoal.test.relative-distance} with
     *   the attribute {@code scale}.
     */
    static Configuration distance(final double scale) {
        final EPackage root = EcoreFactory.eINSTANCE.createEPackage();
        final EPackage module = EcoreFactory.eINSTANCE.createEPackage();
        module.setName("de.evoal.test");
        root.getESubpackages().add(module);

        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        type.setName("relative-distance");
        type.getESuperTypes().add(CorePackage.Literals.CONFIGURATION);
        module.getEClassifiers().add(type);

        final EAttribute scaleAttribute = EcoreFactory.eINSTANCE.createEAttribute();
        scaleAttribute.setName("scale");
        scaleAttribute.setEType(EcorePackage.Literals.EDOUBLE);
        type.getEStructuralFeatures().add(scaleAttribute);

        final Configuration distance = (Configuration) EcoreUtil.create(type);
        distance.eSet(scaleAttribute, scale);

        return distance;
    }

    /**
     * @return An execution with the evaluation counters (iteration scope), the budget
     *   (execution scope, recorded as 20) and the fitness component of the goal for
     *   {@code y:0}.
     */
    static Execution execution() {
        final Execution execution = MemoryFactory.eINSTANCE.createExecution();
        execution.getMetricDefinitions()
                 .add(metricDefinition("evaluations.real", MetricKind.COUNTER, MetricScope.ITERATION));
        execution.getMetricDefinitions()
                 .add(metricDefinition("evaluations.real.budget", MetricKind.MEASURE, MetricScope.EXECUTION));
        execution.getMetrics().put("evaluations.real.budget", 20);

        final FitnessComponentDefinition component = MemoryFactory.eINSTANCE.createFitnessComponentDefinition();
        component.setName("y:0");
        component.setObjective(OPTIMISATION_SPACE.getEClass().getEAllAttributes().getFirst());
        execution.getFitnessComponents().add(component);

        return execution;
    }

    /**
     * @return A real attribute; with {@code declared}, it gets the bounds [-5, 5) and the
     *   scale quotient of its data description.
     */
    private static EAttribute feature(final String name, final boolean declared) {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName(name);
        feature.setEType(EcorePackage.Literals.EDOUBLE);

        if(declared) {
            addBounds(feature);
            addDataDescription(feature);
        }

        return feature;
    }

    /**
     * @return The goals of the problem; the problem must not contain target goals from the
     *   evaluation.
     */
    static Goals goals(final Problem problem) {
        return Goals.of(problem, null, MemoryModels::noDistance);
    }

    /**
     * @return An individual with the search space values {@code x}, the optimisation space
     *   value {@code y} and the fitness {@code y}.
     */
    static IndividualRecord individual(final int id, final double[] x, final double y) {
        final TypedEObject input = SEARCH_SPACE.newEObject();
        final List<EAttribute> searchFeatures = SEARCH_SPACE.getEClass().getEAllAttributes();
        for(int i = 0; i < x.length; ++i) {
            input.eSet(searchFeatures.get(i), x[i]);
        }

        final TypedEObject output = OPTIMISATION_SPACE.newEObject();
        final EAttribute outputFeature = OPTIMISATION_SPACE.getEClass().getEAllAttributes().getFirst();
        output.eSet(outputFeature, y);

        final IndividualRecord individual = MemoryFactory.eINSTANCE.createIndividualRecord();
        individual.setId(id);
        individual.setInput(input);
        individual.setOutput(output);
        individual.getFitness().add(y);

        return individual;
    }

    /**
     * @return An iteration with one rank 0 that contains the individuals, and the counter
     *   {@code evaluations.real}.
     */
    static Iteration iteration(final int number, final IndividualRecord... best) {
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.setNumber(number);
        iteration.getRanks().add(rank(0, best));
        iteration.getMetrics().put("evaluations.real", number + 1);

        return iteration;
    }

    private static MetricDefinition metricDefinition(final String name,
                                                     final MetricKind kind,
                                                     final MetricScope scope) {
        final MetricDefinition definition = MemoryFactory.eINSTANCE.createMetricDefinition();
        definition.setName(name);
        definition.setKind(kind);
        definition.setValueType(MetricValueType.INTEGER);
        definition.setScope(scope);
        definition.setDescription("Description of " + name + ".");

        return definition;
    }

    /**
     * Fails: the goals of the tests have no distances to create.
     */
    private static TargetDistance noDistance(final Configuration configuration) {
        throw new IllegalStateException("The test goals have no distance.");
    }

    /**
     * @return The problem {@code sphere} that minimises {@code y:0} with the optimisation
     *   function {@code de.evoal.test.sphere-function}.
     */
    static Problem problem() {
        final MinimiseGoal goal = ModelFactory.eINSTANCE.createMinimiseGoal();
        goal.setData(OPTIMISATION_SPACE.getEClass().getEAllAttributes().getFirst());

        final Problem problem = ModelFactory.eINSTANCE.createProblem();
        problem.setName("sphere");
        problem.setSearchSpace(SEARCH_SPACE.getEClass());
        problem.setOptimisationSpace(OPTIMISATION_SPACE.getEClass());
        problem.getGoals().add(goal);
        problem.setOptimisationFunction(configuration("sphere-function"));

        return problem;
    }

    /**
     * @return The problem {@code sphere} whose goal optimises {@code y:0} towards the target
     *   with the distance.
     */
    static Problem targetProblem(final double target, final Configuration distance) {
        final TargetGoal goal = ModelFactory.eINSTANCE.createTargetGoal();
        goal.setData(OPTIMISATION_SPACE.getEClass().getEAllAttributes().getFirst());
        goal.setValue(target);
        goal.setDistance(distance);

        final Problem problem = problem();
        problem.getGoals().clear();
        problem.getGoals().add(goal);

        return problem;
    }

    static Rank rank(final int number, final IndividualRecord... members) {
        final Rank rank = MemoryFactory.eINSTANCE.createRank();
        rank.setNumber(number);
        rank.getMembers().addAll(List.of(members));

        return rank;
    }

    /**
     * Adds the relationship to the individual, pointing to the targets.
     */
    static <T extends Relationship> T relate(final IndividualRecord individual,
                                             final T relationship,
                                             final Individual... targets) {
        relationship.getTarget().addAll(List.of(targets));
        individual.getRelationships().add(relationship);

        return relationship;
    }

    private static Space space(final EAttribute... features) {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("Space");
        eClass.getEStructuralFeatures().addAll(List.of(features));
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }
}
