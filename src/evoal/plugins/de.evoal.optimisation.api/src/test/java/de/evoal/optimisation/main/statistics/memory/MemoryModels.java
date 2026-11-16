package de.evoal.optimisation.main.statistics.memory;

import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.base.definitions.UntypedBaseDataDescription;
import de.evoal.languages.model.dynamic.DefinitionMapping;
import de.evoal.languages.model.dynamic.DynamicFactory;
import de.evoal.languages.model.dynamic.DynamicPackage;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.Execution;
import de.evoal.models.v202704.optimisation.memory.Individual;
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

/**
 * Builds small memory models for the tests of the memory model writer: a problem with a
 *   two-dimensional real search space ({@code x:0} with declared bounds and scale,
 *   {@code x:1} without) and a real optimisation space ({@code y:0}) that is minimised.
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
     * @return An execution with the evaluation counters (iteration scope) and the budget
     *   (execution scope, recorded as 20).
     */
    static Execution execution() {
        final Execution execution = MemoryFactory.eINSTANCE.createExecution();
        execution.getMetricDefinitions()
                 .add(metricDefinition("evaluations.real", MetricKind.COUNTER, MetricScope.ITERATION));
        execution.getMetricDefinitions()
                 .add(metricDefinition("evaluations.real.budget", MetricKind.MEASURE, MetricScope.EXECUTION));
        execution.getMetrics().put("evaluations.real.budget", 20);

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
     * @return An individual with the search space values {@code x} and the optimisation space
     *   value {@code y}.
     */
    static Individual individual(final int id, final double[] x, final double y) {
        final TypedEObject input = SEARCH_SPACE.newEObject();
        final List<EAttribute> searchFeatures = SEARCH_SPACE.getEClass().getEAllAttributes();
        for(int i = 0; i < x.length; ++i) {
            input.eSet(searchFeatures.get(i), x[i]);
        }

        final TypedEObject output = OPTIMISATION_SPACE.newEObject();
        final EAttribute outputFeature = OPTIMISATION_SPACE.getEClass().getEAllAttributes().getFirst();
        output.eSet(outputFeature, y);

        final Individual individual = MemoryFactory.eINSTANCE.createIndividual();
        individual.setId(id);
        individual.setInput(input);
        individual.setOutput(output);

        return individual;
    }

    /**
     * @return An iteration with one rank 0 that contains the individuals, and the counter
     *   {@code evaluations.real}.
     */
    static Iteration iteration(final int number, final Individual... best) {
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
     * @return The problem {@code sphere} that minimises {@code y:0}.
     */
    static Problem problem() {
        final MinimiseGoal goal = ModelFactory.eINSTANCE.createMinimiseGoal();
        goal.setData(OPTIMISATION_SPACE.getEClass().getEAllAttributes().getFirst());

        final Problem problem = ModelFactory.eINSTANCE.createProblem();
        problem.setName("sphere");
        problem.setSearchSpace(SEARCH_SPACE.getEClass());
        problem.setOptimisationSpace(OPTIMISATION_SPACE.getEClass());
        problem.getGoals().add(goal);

        return problem;
    }

    static Rank rank(final int number, final Individual... members) {
        final Rank rank = MemoryFactory.eINSTANCE.createRank();
        rank.setNumber(number);
        rank.getMembers().addAll(List.of(members));

        return rank;
    }

    /**
     * Adds the relationship to the individual, pointing to the targets.
     */
    static <T extends Relationship> T relate(final Individual individual,
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
