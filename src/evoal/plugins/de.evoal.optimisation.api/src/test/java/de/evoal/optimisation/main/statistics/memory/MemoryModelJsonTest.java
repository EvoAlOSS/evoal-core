package de.evoal.optimisation.main.statistics.memory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import tools.jackson.databind.node.ObjectNode;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.memory.Execution;
import de.evoal.models.v202704.optimisation.memory.FitnessComponentDefinition;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.PropertyDefinition;
import de.evoal.models.v202704.optimisation.memory.PropertyScope;
import de.evoal.models.v202704.optimisation.memory.PropertyValueType;
import de.evoal.models.v202704.optimisation.memory.Recombination;
import de.evoal.models.v202704.optimisation.memory.Replacement;
import de.evoal.models.v202704.optimisation.memory.UnorderedIterationStep;
import de.evoal.models.v202704.optimisation.model.Problem;

import de.evoal.optimisation.api.execution.EvaluationPosition;
import de.evoal.optimisation.api.fitness.Goal;
import de.evoal.optimisation.api.fitness.Goals;
import de.evoal.optimisation.main.fitness.RelativeDistance;

public class MemoryModelJsonTest {
    /**
     * A single run whose seed is larger than 2^53, which JSON readers like JavaScript cannot
     *   represent exactly as a number.
     */
    private static final RunSetup SINGLE_RUN = new RunSetup("2027.4.0", 9_007_199_254_740_993L, 0, null);

    private final MemoryModelJson json = new MemoryModelJson(new EAnnotationHelper(), new ConfigurationJson(EObject::eGet));

    @TempDir
    private Path folder;

    /**
     * @return The violations of the document against the schema of the file name.
     */
    private List<String> violationsOf(final ObjectNode document, final String fileName) throws Exception {
        final Path file = folder.resolve(fileName);
        Files.writeString(file, document.toString());

        return MemoryModelSchemas.violationsOf(file);
    }

    private static PropertyDefinition propertyDefinition(final String name, final PropertyScope scope,
                                                         final PropertyValueType valueType, final boolean list) {
        final PropertyDefinition definition = MemoryFactory.eINSTANCE.createPropertyDefinition();
        definition.setName(name);
        definition.setScope(scope);
        definition.setValueType(valueType);
        definition.setList(list);
        definition.setDescription("Description of " + name + ".");

        return definition;
    }

    @Nested
    @DisplayName("given properties of individuals and relationships")
    class Properties {
        @Test
        public void theDefinitionsAreWrittenAndValid() throws Exception {
            // given
            final Execution execution = MemoryModels.execution();
            execution.getPropertyDefinitions().add(propertyDefinition("reason", PropertyScope.RELATIONSHIP,
                                                                      PropertyValueType.TEXT, false));
            execution.getPropertyDefinitions().add(propertyDefinition("sizes", PropertyScope.INDIVIDUAL,
                                                                      PropertyValueType.INTEGER, true));

            // when
            final ObjectNode document = json.toExecutionInformation(MemoryModels.problem(),
                                                                    MemoryModels.goals(MemoryModels.problem()),
                                                                    "de.evoal.test.algorithm",
                                                                    List.of(),
                                                                    execution,
                                                                    SINGLE_RUN);

            // then
            Assertions.assertEquals("[{\"name\":\"reason\",\"scope\":\"relationship\",\"valueType\":\"text\","
                                    + "\"list\":false,\"description\":\"Description of reason.\"},"
                                    + "{\"name\":\"sizes\",\"scope\":\"individual\",\"valueType\":\"integer\","
                                    + "\"list\":true,\"description\":\"Description of sizes.\"}]",
                                    document.get("propertyDefinitions").toString());
            Assertions.assertEquals(List.of(), violationsOf(document, "execution-information.json"));
        }

        @Test
        public void withoutDefinitionsThereIsNoSuchField() {
            // when
            final ObjectNode document = json.toExecutionInformation(MemoryModels.problem(),
                                                                    MemoryModels.goals(MemoryModels.problem()),
                                                                    "de.evoal.test.algorithm",
                                                                    List.of(),
                                                                    MemoryModels.execution(),
                                                                    SINGLE_RUN);

            // then
            Assertions.assertFalse(document.has("propertyDefinitions"));
        }

        @Test
        public void replacementsAreWrittenWithTheirProperties() throws Exception {
            // given
            final Individual replaced = MemoryModels.individual(0, new double[] {0.0, 0.0}, 0.0);
            final Individual replacement = MemoryModels.individual(1, new double[] {0.5, 0.0}, 0.25);
            final Replacement relationship = MemoryModels.relate(replacement, MemoryFactory.eINSTANCE.createReplacement(), replaced);
            relationship.getProperties().put("reason", "maximum-age: age 3 exceeds 2 iterations");

            // when
            final ObjectNode document = json.toIteration(MemoryModels.iteration(1, replacement));

            // then
            Assertions.assertEquals("[{\"kind\":\"replacement\",\"targets\":[0],"
                                    + "\"properties\":{\"reason\":\"maximum-age: age 3 exceeds 2 iterations\"}}]",
                                    document.get("individuals").get(0).get("relationships").toString());
            Assertions.assertEquals(List.of(), violationsOf(document, "iteration-1.json"));
        }

        @Test
        public void individualPropertiesAreWrittenInOrderAndEmptyOnesAreLeftOut() throws Exception {
            // given
            final Individual withProperties = MemoryModels.individual(0, new double[] {0.0, 0.0}, 0.0);
            withProperties.getProperties().put("reason", "too old");
            withProperties.getProperties().put("sizes", List.of(1L, 2L));
            withProperties.getProperties().put("valid", true);
            withProperties.getProperties().put("share", 0.5);
            final Individual without = MemoryModels.individual(1, new double[] {0.5, 0.0}, 0.25);

            // when
            final ObjectNode document = json.toIteration(MemoryModels.iteration(0, withProperties, without));

            // then
            Assertions.assertEquals("{\"reason\":\"too old\",\"sizes\":[1,2],\"valid\":true,\"share\":0.5}",
                                    document.get("individuals").get(0).get("properties").toString());
            Assertions.assertFalse(document.get("individuals").get(1).has("properties"));
            Assertions.assertEquals(List.of(), violationsOf(document, "iteration-0.json"));
        }
    }

    @Nested
    @DisplayName("given a problem with declared bounds and scales")
    class ExecutionInformation {
        @Test
        public void featuresHaveTypeAndOnlyTheDeclaredScaleAndBounds() {
            // when
            final ObjectNode document = json.toExecutionInformation(MemoryModels.problem(),
                                                                    MemoryModels.goals(MemoryModels.problem()),
                                                                    "de.evoal.test.algorithm",
                                                                    List.of(),
                                                                    MemoryModels.execution(),
                                                                    SINGLE_RUN);

            // then
            final String expectedSearchSpace = "[{\"name\":\"x:0\",\"type\":\"real\",\"scale\":\"quotient\","
                    + "\"lowerBound\":{\"value\":-5.0,\"inclusive\":true},"
                    + "\"upperBound\":{\"value\":5.0,\"inclusive\":false}},"
                    + "{\"name\":\"x:1\",\"type\":\"real\"}]";
            Assertions.assertEquals(expectedSearchSpace, document.get("searchSpace").toString());
        }

        @Test
        public void metricDefinitionsUseLowerCaseLiterals() {
            // when
            final ObjectNode document = json.toExecutionInformation(MemoryModels.problem(),
                                                                    MemoryModels.goals(MemoryModels.problem()),
                                                                    "de.evoal.test.algorithm",
                                                                    List.of(),
                                                                    MemoryModels.execution(),
                                                                    SINGLE_RUN);

            // then
            final String expectedFirstDefinition = "{\"name\":\"evaluations.real\",\"kind\":\"counter\","
                    + "\"valueType\":\"integer\",\"scope\":\"iteration\","
                    + "\"description\":\"Description of evaluations.real.\"}";
            Assertions.assertEquals(expectedFirstDefinition, document.get("metricDefinitions").get(0).toString());
        }

        @Test
        public void problemAlgorithmAndSetupAreDescribed() {
            // when
            final ObjectNode document = json.toExecutionInformation(MemoryModels.problem(),
                                                                    MemoryModels.goals(MemoryModels.problem()),
                                                                    "de.evoal.test.algorithm",
                                                                    List.of(),
                                                                    MemoryModels.execution(),
                                                                    SINGLE_RUN);

            // then
            Assertions.assertEquals("2027.4.0", document.get("formatVersion").asString());
            Assertions.assertEquals("{\"name\":\"sphere\",\"goals\":[{\"feature\":\"y:0\",\"direction\":\"minimise\"}]}",
                                    document.get("problem").toString());
            Assertions.assertEquals("{\"type\":\"de.evoal.test.algorithm\"}", document.get("algorithm").toString());
            Assertions.assertEquals("{\"evoalVersion\":\"2027.4.0\",\"seed\":\"9007199254740993\",\"run\":0}",
                                    document.get("setup").toString());
        }

        @Test
        public void targetGoalsWriteTheirTargetAndDistance() {
            // given
            final Problem problem = MemoryModels.targetProblem(1.0, MemoryModels.distance(0.5));
            final EStructuralFeature objective = problem.getGoals().getFirst().getData();
            final Goals goals = new Goals(List.of(new Goal.Target(objective, 1.5, new RelativeDistance())));

            // when
            final ObjectNode document = json.toExecutionInformation(problem,
                                                                    goals,
                                                                    "de.evoal.test.algorithm",
                                                                    List.of(),
                                                                    MemoryModels.execution(),
                                                                    SINGLE_RUN);

            // then
            Assertions.assertEquals("[{\"feature\":\"y:0\",\"direction\":\"target\",\"target\":1.5,"
                                    + "\"distance\":{\"type\":\"de.evoal.test.relative-distance\","
                                    + "\"attributes\":{\"scale\":0.5}}}]",
                                    document.get("problem").get("goals").toString());
        }

        @Test
        public void theFitnessComponentsAndConfiguredStepsAreDescribed() {
            // given
            final Execution execution = MemoryModels.execution();
            final FitnessComponentDefinition violation = MemoryFactory.eINSTANCE.createFitnessComponentDefinition();
            violation.setName("violation");
            execution.getFitnessComponents().add(violation);

            final Configuration step = MemoryModels.distance(2.0);

            // when
            final ObjectNode document = json.toExecutionInformation(MemoryModels.problem(),
                                                                    MemoryModels.goals(MemoryModels.problem()),
                                                                    "de.evoal.test.algorithm",
                                                                    List.of(step),
                                                                    execution,
                                                                    SINGLE_RUN);

            // then
            Assertions.assertEquals("{\"components\":[{\"name\":\"y:0\",\"goal\":\"y:0\"},{\"name\":\"violation\"}],"
                                    + "\"steps\":[{\"type\":\"de.evoal.test.relative-distance\","
                                    + "\"attributes\":{\"scale\":2.0}}]}",
                                    document.get("fitness").toString());
        }

        @Test
        public void theEvaluationSetupWritesRepetitionAndTarget() {
            // given
            final EvaluationPosition position = EvaluationPosition.withTarget(3, 10, 1, 2);
            final RunSetup setup = new RunSetup("2027.4.0", -7, 13, position);

            // when
            final ObjectNode document = json.toExecutionInformation(MemoryModels.problem(),
                                                                    MemoryModels.goals(MemoryModels.problem()),
                                                                    "de.evoal.test.algorithm",
                                                                    List.of(),
                                                                    MemoryModels.execution(),
                                                                    setup);

            // then
            final String expectedSetup = "{\"evoalVersion\":\"2027.4.0\",\"seed\":\"-7\",\"run\":13,"
                    + "\"repetition\":3,\"target\":1}";
            Assertions.assertEquals(expectedSetup, document.get("setup").toString());
        }
    }

    @Nested
    @DisplayName("given an iteration whose step and ranks share individuals")
    class SharedIndividuals {
        private Iteration iteration;

        @BeforeEach
        public void createIteration() {
            final Individual first = MemoryModels.individual(3, new double[] {0.5, 1.0}, 2.0);
            final Individual second = MemoryModels.individual(4, new double[] {1.5, 2.0}, 1.0);
            final Individual firstAgain = MemoryModels.individual(3, new double[] {0.5, 1.0}, 2.0);

            final UnorderedIterationStep step = MemoryFactory.eINSTANCE.createUnorderedIterationStep();
            step.setDescription("neighbours");
            step.getIndividuals().addAll(List.of(first, second));

            iteration = MemoryModels.iteration(1, firstAgain);
            iteration.getSteps().add(step);
        }

        @Test
        public void everyIndividualIsListedOnceInOrderOfFirstOccurrence() {
            // when
            final ObjectNode document = json.toIteration(iteration);

            // then
            final String expectedIndividuals = "[{\"id\":3,\"input\":{\"x:0\":0.5,\"x:1\":1.0},\"output\":{\"y:0\":2.0},"
                    + "\"fitness\":[2.0],\"relationships\":[]},"
                    + "{\"id\":4,\"input\":{\"x:0\":1.5,\"x:1\":2.0},\"output\":{\"y:0\":1.0},"
                    + "\"fitness\":[1.0],\"relationships\":[]}]";
            Assertions.assertEquals(expectedIndividuals, document.get("individuals").toString());
        }

        @Test
        public void stepsAndRanksReferToTheIds() {
            // when
            final ObjectNode document = json.toIteration(iteration);

            // then
            Assertions.assertEquals("[{\"kind\":\"unordered\",\"description\":\"neighbours\",\"individuals\":[3,4]}]",
                                    document.get("steps").toString());
            Assertions.assertEquals("[{\"number\":0,\"members\":[3]}]", document.get("ranks").toString());
            Assertions.assertEquals("{\"evaluations.real\":2}", document.get("metrics").toString());
        }

        @Test
        public void theFinalVersionHoldsOnlyTheMembersWithTheirRelationshipsToThePreviousIteration() {
            // given: in the step, 3 mutates 4; in the ranks, 3 is a copy of 1 of the previous iteration
            final Individual previous = MemoryModels.individual(1, new double[] {0.5, 1.0}, 2.0);
            MemoryModels.relate(firstOfStep(), MemoryFactory.eINSTANCE.createMutation(), secondOfStep());
            MemoryModels.relate(iteration.getRanks().getFirst().getMembers().getFirst(),
                                MemoryFactory.eINSTANCE.createIdentity(), previous);

            // when
            final ObjectNode document = json.toIteration(iteration, false);

            // then
            final String expectedIndividuals = "[{\"id\":3,\"input\":{\"x:0\":0.5,\"x:1\":1.0},\"output\":{\"y:0\":2.0},"
                    + "\"fitness\":[2.0],\"relationships\":[{\"kind\":\"identity\",\"targets\":[1]}]}]";
            Assertions.assertEquals(expectedIndividuals, document.get("individuals").toString());
            Assertions.assertEquals("[]", document.get("steps").toString());
        }

        @Test
        public void theStepsVersionRelatesTheIndividualsOfTheStepsToTheirDirectPredecessors() {
            // given
            final Individual previous = MemoryModels.individual(1, new double[] {0.5, 1.0}, 2.0);
            MemoryModels.relate(firstOfStep(), MemoryFactory.eINSTANCE.createMutation(), secondOfStep());
            MemoryModels.relate(iteration.getRanks().getFirst().getMembers().getFirst(),
                                MemoryFactory.eINSTANCE.createIdentity(), previous);

            // when
            final ObjectNode document = json.toIteration(iteration, true);

            // then
            Assertions.assertEquals("[{\"kind\":\"mutation\",\"targets\":[4]}]",
                                    document.get("individuals").get(0).get("relationships").toString());
        }

        private Individual firstOfStep() {
            return ((UnorderedIterationStep) iteration.getSteps().getFirst()).getIndividuals().get(0);
        }

        private Individual secondOfStep() {
            return ((UnorderedIterationStep) iteration.getSteps().getFirst()).getIndividuals().get(1);
        }

        @Test
        public void anIdWithOtherValuesIsRejected() {
            // given
            final Individual different = MemoryModels.individual(4, new double[] {9.0, 9.0}, 9.0);
            iteration.getRanks().getFirst().getMembers().add(different);

            // when / then
            Assertions.assertThrows(IllegalStateException.class, () -> json.toIteration(iteration));
        }

        @Test
        public void anIdWithAnotherFitnessIsRejected() {
            // given
            final Individual different = MemoryModels.individual(4, new double[] {1.5, 2.0}, 1.0);
            different.getFitness().set(0, -1.0);
            iteration.getRanks().getFirst().getMembers().add(different);

            // when / then
            Assertions.assertThrows(IllegalStateException.class, () -> json.toIteration(iteration));
        }
    }

    @Nested
    @DisplayName("given individuals with relationships to earlier individuals")
    class Lineage {
        @Test
        public void mutationsReferToTheirTargetsById() {
            // given
            final Individual parent = MemoryModels.individual(0, new double[] {0.0, 0.0}, 0.0);
            final Individual child = MemoryModels.individual(1, new double[] {0.5, 0.0}, 0.25);
            MemoryModels.relate(child, MemoryFactory.eINSTANCE.createMutation(), parent);

            // when
            final ObjectNode document = json.toIteration(MemoryModels.iteration(1, child));

            // then
            Assertions.assertEquals("[{\"kind\":\"mutation\",\"targets\":[0]}]",
                                    document.get("individuals").get(0).get("relationships").toString());
        }

        @Test
        public void recombinationsWriteTheirPartner() {
            // given
            final Individual father = MemoryModels.individual(0, new double[] {0.0, 0.0}, 0.0);
            final Individual mother = MemoryModels.individual(1, new double[] {1.0, 1.0}, 2.0);
            final Individual son = MemoryModels.individual(2, new double[] {0.0, 1.0}, 1.0);
            final Individual daughter = MemoryModels.individual(3, new double[] {1.0, 0.0}, 1.0);

            final Recombination sonsOrigin =
                    MemoryModels.relate(son, MemoryFactory.eINSTANCE.createRecombination(), father, mother);
            final Recombination daughtersOrigin =
                    MemoryModels.relate(daughter, MemoryFactory.eINSTANCE.createRecombination(), father, mother);
            sonsOrigin.setOther(daughtersOrigin);
            daughtersOrigin.setOther(sonsOrigin);

            // when
            final ObjectNode document = json.toIteration(MemoryModels.iteration(1, son, daughter));

            // then
            Assertions.assertEquals("[{\"kind\":\"recombination\",\"targets\":[0,1],\"partner\":3}]",
                                    document.get("individuals").get(0).get("relationships").toString());
        }

        @Test
        public void aRecombinationWithoutRecordedSiblingHasNoPartner() throws Exception {
            // given
            final Individual father = MemoryModels.individual(0, new double[] {0.0, 0.0}, 0.0);
            final Individual mother = MemoryModels.individual(1, new double[] {1.0, 1.0}, 2.0);
            final Individual son = MemoryModels.individual(2, new double[] {0.0, 1.0}, 1.0);
            MemoryModels.relate(son, MemoryFactory.eINSTANCE.createRecombination(), father, mother);

            // when
            final ObjectNode document = json.toIteration(MemoryModels.iteration(1, son));

            // then
            Assertions.assertEquals("[{\"kind\":\"recombination\",\"targets\":[0,1]}]",
                                    document.get("individuals").get(0).get("relationships").toString());
            Assertions.assertEquals(List.of(), violationsOf(document, "iteration-1.json"));
        }

        @Test
        public void theBestSoFarIsWrittenAsIdEvenFromAnEarlierIteration() {
            // given
            final Individual best = MemoryModels.individual(0, new double[] {0.0, 0.0}, 0.0);
            final Individual worse = MemoryModels.individual(1, new double[] {0.5, 0.0}, 0.25);
            final Iteration iteration = MemoryModels.iteration(1, worse);
            iteration.setBestSoFar(best);

            // when
            final ObjectNode document = json.toIteration(iteration);

            // then
            Assertions.assertEquals(0, document.get("bestSoFar").intValue());
        }

        @Test
        public void anIterationWithoutBestSoFarHasNoSuchField() {
            // when
            final ObjectNode document = json.toIteration(MemoryModels.iteration(0, MemoryModels.individual(0, new double[] {0.0, 0.0}, 0.0)));

            // then
            Assertions.assertFalse(document.has("bestSoFar"));
        }
    }

    @Nested
    @DisplayName("given values that are zero or not finite")
    class SpecialValues {
        @Test
        public void nonFiniteNumbersAreWrittenAsStrings() {
            // given
            final Individual individual = MemoryModels.individual(0,
                                                                  new double[] {Double.NaN, Double.NEGATIVE_INFINITY},
                                                                  Double.POSITIVE_INFINITY);

            // when
            final ObjectNode document = json.toIteration(MemoryModels.iteration(0, individual));

            // then
            final ObjectNode written = (ObjectNode) document.get("individuals").get(0);
            Assertions.assertEquals("{\"x:0\":\"NaN\",\"x:1\":\"-Infinity\"}", written.get("input").toString());
            Assertions.assertEquals("{\"y:0\":\"Infinity\"}", written.get("output").toString());
            Assertions.assertEquals("[\"Infinity\"]", written.get("fitness").toString());
        }

        @Test
        public void zeroIsWrittenAsANumber() {
            // given
            final Individual individual = MemoryModels.individual(0, new double[] {0.0, -0.0}, 0.0);

            // when
            final ObjectNode document = json.toIteration(MemoryModels.iteration(0, individual));

            // then
            final ObjectNode written = (ObjectNode) document.get("individuals").get(0);
            Assertions.assertEquals("{\"x:0\":0.0,\"x:1\":-0.0}", written.get("input").toString());
        }

        @Test
        public void unevaluatedIndividualsHaveNoOutputValuesAndNoFitness() {
            // given
            final Individual individual = MemoryModels.individual(0, new double[] {1.0, 1.0}, 0.0);
            individual.setOutput(null);
            individual.getFitness().clear();

            // when
            final ObjectNode document = json.toIteration(MemoryModels.iteration(0, individual));

            // then
            Assertions.assertEquals("{}", document.get("individuals").get(0).get("output").toString());
            Assertions.assertEquals("[]", document.get("individuals").get(0).get("fitness").toString());
        }
    }

    @Nested
    @DisplayName("given a finished execution")
    class ExecutionFinished {
        @Test
        public void numberOfIterationsBestAndExecutionMetricsAreWritten() {
            // when
            final ObjectNode document = json.toExecutionFinished(5, List.of(4), MemoryModels.execution());

            // then
            Assertions.assertEquals("{\"formatVersion\":\"2027.4.0\",\"numberOfIterations\":5,\"best\":[4],"
                                    + "\"metrics\":{\"evaluations.real.budget\":20}}",
                                    document.toString());
        }
    }
}
