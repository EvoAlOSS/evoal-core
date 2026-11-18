package de.evoal.optimisation.main.statistics.memory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import jakarta.enterprise.inject.Instance;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import org.mockito.Mockito;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.random.RandomService;
import de.evoal.models.v202704.optimisation.memory.Execution;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.Mutation;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.UnorderedIterationStep;

import de.evoal.optimisation.api.execution.EvaluationPosition;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.execution.MetricContributor;

public class MemoryModelWriterTest {
    @TempDir
    private Path outputFolder;

    private ExecutionRecorder recorder;

    /**
     * @return The configuration of an algorithm of the DL type {@code de.evoal.test.algorithm}.
     */
    private static EObject algorithmConfiguration() {
        final EPackage root = EcoreFactory.eINSTANCE.createEPackage();
        final EPackage module = EcoreFactory.eINSTANCE.createEPackage();
        module.setName("de.evoal.test");
        root.getESubpackages().add(module);

        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        type.setName("algorithm");
        module.getEClassifiers().add(type);

        return EcoreUtil.create(type);
    }

    /**
     * @return The names of the files and folders in the folder, sorted.
     */
    private static List<String> contentOf(final Path folder) throws IOException {
        try(Stream<Path> paths = Files.list(folder)) {
            return paths.map(Path::getFileName)
                        .map(Path::toString)
                        .sorted()
                        .toList();
        }
    }

    @BeforeEach
    public void createRecorder() throws Exception {
        recorder = new ExecutionRecorder();

        @SuppressWarnings("unchecked")
        final Instance<MetricContributor> noContributors = Mockito.mock(Instance.class);
        inject(recorder, "contributors", noContributors);
    }

    private static void inject(final Object target, final String name, final Object value) throws Exception {
        final Field field = target.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    /**
     * Starts a run whose execution has the metrics of {@link MemoryModels#execution()}.
     */
    private void startRun(final EvaluationPosition position) {
        recorder.startRun(position);

        final Execution metrics = MemoryModels.execution();
        List.copyOf(metrics.getMetricDefinitions())
            .forEach(recorder::define);
        recorder.recordExecutionMetric("evaluations.real.budget", 20);
        recorder.beginExecution();
    }

    private MemoryModelWriter writer(final File output) throws Exception {
        final MemoryModelWriter writer = new MemoryModelWriter();
        inject(writer, "algorithm", algorithmConfiguration());
        inject(writer, "annotationHelper", new EAnnotationHelper());
        inject(writer, "goals", MemoryModels.goals(MemoryModels.problem()));
        inject(writer, "outputFolder", output);
        inject(writer, "problem", MemoryModels.problem());
        inject(writer, "randomService", RandomService.withSeed(42));
        inject(writer, "recorder", recorder);

        return writer;
    }

    /**
     * Starts the writer and adds iteration 0 with the start individual and iteration 1 with
     *   its mutation.
     */
    private static void addTwoIterations(final MemoryModelWriter writer) {
        writer.start();

        final Individual start = MemoryModels.individual(0, new double[] {1.0, 1.0}, 2.0);
        writer.add(MemoryModels.iteration(0, start));

        final Individual neighbour = MemoryModels.individual(1, new double[] {0.5, 1.0}, 1.25);
        final Mutation mutation = MemoryFactory.eINSTANCE.createMutation();
        MemoryModels.relate(neighbour, mutation, start);
        writer.add(MemoryModels.iteration(1, neighbour));
    }

    @Nested
    @DisplayName("given a single run")
    class SingleRun {
        private Path memoryModel;

        private MemoryModelWriter writer;

        @BeforeEach
        public void createWriter() throws Exception {
            startRun(null);
            writer = writer(outputFolder.toFile());
            memoryModel = outputFolder.resolve("memory-model");
        }

        @Test
        public void allFilesAreWrittenAndValid() throws Exception {
            // when
            addTwoIterations(writer);
            writer.write();

            // then
            final List<String> expectedFiles = List.of("execution-finished.json",
                                                       "execution-information.json",
                                                       "iteration-0.json",
                                                       "iteration-1.json");
            Assertions.assertEquals(expectedFiles, contentOf(memoryModel));

            for(final String file : expectedFiles) {
                final Path path = memoryModel.resolve(file);
                Assertions.assertEquals(List.of(), MemoryModelSchemas.violationsOf(path));
            }
        }

        @Test
        public void executionFinishedNamesTheBestOfTheLastIteration() throws Exception {
            // when
            addTwoIterations(writer);
            writer.write();

            // then
            final String finished = Files.readString(memoryModel.resolve("execution-finished.json"));
            final String expected = """
                    {
                      "formatVersion" : "2027.4.0",
                      "numberOfIterations" : 2,
                      "best" : [ 1 ],
                      "metrics" : {
                        "evaluations.real.budget" : 20
                      }
                    }
                    """;
            Assertions.assertEquals(expected, finished);
        }

        @Test
        public void filesOfAnEarlierExecutionAreDeleted() throws Exception {
            // given
            Files.createDirectories(memoryModel.resolve(".incomplete"));
            Files.writeString(memoryModel.resolve("iteration-7.json"), "{}");

            // when
            addTwoIterations(writer);
            writer.write();

            // then
            Assertions.assertFalse(Files.exists(memoryModel.resolve("iteration-7.json")));
        }

        @Test
        public void theRunIsDescribedWhenItStarts() throws Exception {
            // when
            writer.start();

            // then
            Assertions.assertEquals(List.of(".incomplete", "execution-information.json"), contentOf(memoryModel));
        }

        @Test
        public void anIterationBeforeTheStartIsRejected() {
            // given
            final Iteration first = MemoryModels.iteration(0, MemoryModels.individual(0, new double[] {1.0, 1.0}, 2.0));

            // when / then
            Assertions.assertThrows(IllegalStateException.class, () -> writer.add(first));
        }

        @Test
        public void iterationsOutOfOrderAreRejected() {
            // given
            writer.start();
            writer.add(MemoryModels.iteration(0, MemoryModels.individual(0, new double[] {1.0, 1.0}, 2.0)));
            final Iteration skipped = MemoryModels.iteration(2, MemoryModels.individual(1, new double[] {0.0, 0.0}, 0.0));

            // when / then
            Assertions.assertThrows(IllegalStateException.class, () -> writer.add(skipped));
        }
    }

    @Nested
    @DisplayName("given an iteration with executed steps")
    class ExecutedSteps {
        private Path iterationFile;

        /**
         * Writes iteration 0 with the step "Initialization: sample", with or without steps.
         */
        private String writeIteration(final boolean writeSteps) throws Exception {
            startRun(null);
            final MemoryModelWriter writer = writer(outputFolder.toFile());
            final AttributeHelper attributes = Mockito.mock(AttributeHelper.class);
            Mockito.when(attributes.lookup(Mockito.any(EObject.class), Mockito.eq("steps"))).thenReturn(writeSteps);
            inject(writer, "attributes", attributes);
            writer.init(algorithmConfiguration());

            final Iteration iteration = MemoryModels.iteration(0, MemoryModels.individual(0, new double[] {1.0, 1.0}, 2.0));
            final UnorderedIterationStep step = MemoryFactory.eINSTANCE.createUnorderedIterationStep();
            step.setDescription("Initialization: sample");
            iteration.getSteps().add(step);

            writer.start();
            writer.add(iteration);

            iterationFile = outputFolder.resolve("memory-model/iteration-0.json");
            return Files.readString(iterationFile);
        }

        @Test
        public void theStepsAreWrittenIfConfigured() throws Exception {
            // when
            final String document = writeIteration(true);

            // then
            Assertions.assertTrue(document.contains("\"description\" : \"Initialization: sample\""));
            Assertions.assertEquals(List.of(), MemoryModelSchemas.violationsOf(iterationFile));
        }

        @Test
        public void theStepsAreNotWrittenByDefault() throws Exception {
            // when
            final String document = writeIteration(false);

            // then
            Assertions.assertFalse(document.contains("Initialization: sample"));
            Assertions.assertTrue(document.contains("\"steps\" : [ ]"));
        }
    }

    @Nested
    @DisplayName("given a run of the evaluation setup with target points")
    class EvaluationSetup {
        @Test
        public void theRunHasItsOwnFolder() throws Exception {
            // given
            startRun(EvaluationPosition.withTarget(3, 10, 1, 2));
            final MemoryModelWriter writer = writer(outputFolder.toFile());

            // when
            addTwoIterations(writer);
            writer.write();

            // then
            final Path runFolder = outputFolder.resolve("memory-model/target-1/repetition-3");
            Assertions.assertTrue(Files.exists(runFolder.resolve("execution-finished.json")));
        }
    }

    @Nested
    @DisplayName("given an output folder that cannot be written")
    class UnwritableOutput {
        @Test
        public void theRunContinuesWithoutMemoryModel() throws Exception {
            // given
            startRun(null);
            final Path blocked = outputFolder.resolve("blocked");
            Files.writeString(blocked, "a file, not a folder");
            final MemoryModelWriter writer = writer(blocked.toFile());

            // when
            Assertions.assertDoesNotThrow(() -> {
                addTwoIterations(writer);
                writer.write();
            });

            // then
            Assertions.assertEquals(List.of("blocked"), contentOf(outputFolder));
        }
    }
}
