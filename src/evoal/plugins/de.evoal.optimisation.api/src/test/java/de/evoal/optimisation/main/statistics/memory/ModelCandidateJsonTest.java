package de.evoal.optimisation.main.statistics.memory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import tools.jackson.databind.node.ObjectNode;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.IndividualRecord;
import de.evoal.models.v202704.optimisation.model.MinimiseGoal;
import de.evoal.models.v202704.optimisation.model.ModelFactory;
import de.evoal.models.v202704.optimisation.model.Problem;

/**
 * A search space with structured data: the model of a candidate is written as a tree, and the
 *   feature as a model feature with the DL type of its root.
 */
public class ModelCandidateJsonTest {
    private static final RunSetup SINGLE_RUN = new RunSetup("2027.4.0", 1L, 0, null);

    private static final String TYPES = "de.evoal.optimisation.test.models.expressions.";

    private final MemoryModelJson json = new MemoryModelJson(new EAnnotationHelper(), new ConfigurationJson(EObject::eGet));

    private final DynamicEClassProvider provider = new DynamicEClassProvider();

    @TempDir
    private Path folder;

    private Space searchSpace;

    private EReference term;

    private DefinitionModule module;

    @BeforeEach
    public void createSearchSpace() {
        module = LanguageHelper.loadFromClasspath("de/evoal/optimisation/test/models/expressions.dl");

        term = EcoreFactory.eINSTANCE.createEReference();
        term.setName("term");
        term.setContainment(true);
        term.setEType(classOf("term"));

        final EClass space = EcoreFactory.eINSTANCE.createEClass();
        space.setName("Space");
        space.getEStructuralFeatures().add(term);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(space);
        searchSpace = new Space(space);
    }

    private EClass classOf(final String name) {
        final ClassDefinition type = module.getTypes()
                                           .stream()
                                           .filter(definition -> name.equals(definition.getName()))
                                           .findFirst()
                                           .orElseThrow();

        return provider.toEClass(type);
    }

    /**
     * @return The model {@code plus { left := constant { value := 0.5; }; right := variable { index := 1; }; }}.
     */
    private EObject sum() {
        final EObject constant = EcoreUtil.create(classOf("constant"));
        constant.eSet(constant.eClass().getEStructuralFeature("value"), 0.5);

        final EObject variable = EcoreUtil.create(classOf("variable"));
        variable.eSet(variable.eClass().getEStructuralFeature("index"), 1);

        final EObject plus = EcoreUtil.create(classOf("plus"));
        plus.eSet(plus.eClass().getEStructuralFeature("left"), constant);
        plus.eSet(plus.eClass().getEStructuralFeature("right"), variable);

        return plus;
    }

    private IndividualRecord individual() {
        final TypedEObject input = searchSpace.newEObject();
        input.eSet(term, sum());

        final IndividualRecord individual = MemoryModels.individual(0, new double[0], 1.0);
        individual.setInput(input);

        return individual;
    }

    @Test
    public void theModelOfACandidateIsWrittenAsATree() throws Exception {
        // when
        final ObjectNode document = json.toIteration(MemoryModels.iteration(0, individual()));

        // then
        final String expectedInput = "{\"term\":{\"type\":\"" + TYPES + "plus\",\"values\":{"
                + "\"left\":{\"type\":\"" + TYPES + "constant\",\"values\":{\"value\":0.5}},"
                + "\"right\":{\"type\":\"" + TYPES + "variable\",\"values\":{\"index\":1}}}}}";
        Assertions.assertEquals(expectedInput, document.get("individuals").get(0).get("input").toString());

        final Path file = folder.resolve("iteration-0.json");
        Files.writeString(file, document.toString());
        Assertions.assertEquals(List.of(), MemoryModelSchemas.violationsOf(file));
    }

    @Test
    public void theFeatureIsAModelFeatureWithTheTypeOfItsRoot() {
        // given
        final MinimiseGoal goal = ModelFactory.eINSTANCE.createMinimiseGoal();
        goal.setData(MemoryModels.OPTIMISATION_SPACE.getEClass().getEAllAttributes().getFirst());

        final Problem problem = ModelFactory.eINSTANCE.createProblem();
        problem.setName("regression");
        problem.setSearchSpace(searchSpace.getEClass());
        problem.setOptimisationSpace(MemoryModels.OPTIMISATION_SPACE.getEClass());
        problem.getGoals().add(goal);
        problem.setOptimisationFunction(MemoryModels.configuration("regression-function"));

        // when
        final ObjectNode document = json.toExecutionInformation(problem,
                                                                MemoryModels.goals(problem),
                                                                MemoryModels.algorithmConfiguration(),
                                                                List.of(),
                                                                List.of(),
                                                                MemoryModels.execution(),
                                                                SINGLE_RUN,
                                                                List.of());

        // then
        final String expectedSearchSpace = "[{\"name\":\"term\",\"type\":\"model\",\"modelType\":\"" + TYPES + "term\"}]";
        Assertions.assertEquals(expectedSearchSpace, document.get("searchSpace").toString());
    }
}
