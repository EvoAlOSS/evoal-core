package de.evoal.optimisation.main.statistics.memory;

import java.util.List;

import tools.jackson.databind.node.ObjectNode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Recombination;
import de.evoal.models.v202704.optimisation.memory.UnorderedIterationStep;
import de.evoal.models.v202704.optimisation.model.ModelFactory;
import de.evoal.models.v202704.optimisation.model.Problem;
import de.evoal.models.v202704.optimisation.model.TargetGoal;

import de.evoal.optimisation.api.execution.EvaluationPosition;

public class MemoryModelJsonTest {
    /**
     * A single run whose seed is larger than 2^53, which JSON readers like JavaScript cannot
     *   represent exactly as a number.
     */
    private static final RunSetup SINGLE_RUN = new RunSetup("2027.4.0", 9_007_199_254_740_993L, 0, null);

    private final MemoryModelJson json = new MemoryModelJson(new EAnnotationHelper());

    @Nested
    @DisplayName("given a problem with declared bounds and scales")
    class ExecutionInformation {
        @Test
        public void featuresHaveTypeAndOnlyTheDeclaredScaleAndBounds() {
            // when
            final ObjectNode document = json.toExecutionInformation(MemoryModels.problem(),
                                                                    "de.evoal.test.algorithm",
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
                                                                    "de.evoal.test.algorithm",
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
                                                                    "de.evoal.test.algorithm",
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
        public void targetGoalsWriteTheirTarget() {
            // given
            final Problem problem = MemoryModels.problem();
            final TargetGoal goal = ModelFactory.eINSTANCE.createTargetGoal();
            goal.setData(problem.getGoals().getFirst().getData());
            goal.setValue(1.5);
            problem.getGoals().set(0, goal);

            // when
            final ObjectNode document = json.toExecutionInformation(problem,
                                                                    "de.evoal.test.algorithm",
                                                                    MemoryModels.execution(),
                                                                    SINGLE_RUN);

            // then
            Assertions.assertEquals("[{\"feature\":\"y:0\",\"direction\":\"target\",\"target\":1.5}]",
                                    document.get("problem").get("goals").toString());
        }

        @Test
        public void theEvaluationSetupWritesRepetitionAndTarget() {
            // given
            final EvaluationPosition position = EvaluationPosition.withTarget(3, 10, 1, 2);
            final RunSetup setup = new RunSetup("2027.4.0", -7, 13, position);

            // when
            final ObjectNode document = json.toExecutionInformation(MemoryModels.problem(),
                                                                    "de.evoal.test.algorithm",
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
                    + "\"relationships\":[]},"
                    + "{\"id\":4,\"input\":{\"x:0\":1.5,\"x:1\":2.0},\"output\":{\"y:0\":1.0},"
                    + "\"relationships\":[]}]";
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
        public void anIdWithOtherValuesIsRejected() {
            // given
            final Individual different = MemoryModels.individual(4, new double[] {9.0, 9.0}, 9.0);
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
        public void unevaluatedIndividualsHaveNoOutputValues() {
            // given
            final Individual individual = MemoryModels.individual(0, new double[] {1.0, 1.0}, 0.0);
            individual.setOutput(null);

            // when
            final ObjectNode document = json.toIteration(MemoryModels.iteration(0, individual));

            // then
            Assertions.assertEquals("{}", document.get("individuals").get(0).get("output").toString());
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
