package de.evoal.optimisation.main.statistics.individuals;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import jakarta.enterprise.inject.Instance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import de.evoal.core.api.cdi.ComponentProducer;
import de.evoal.core.api.reproducibility.ReproducibilityProtocol;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;
import de.evoal.models.v202704.optimisation.memory.IndividualRecord;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricKind;
import de.evoal.models.v202704.optimisation.memory.MetricScope;
import de.evoal.models.v202704.optimisation.memory.Rank;

import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.execution.MetricContributor;
import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.WriterContext;
import de.evoal.optimisation.main.statistics.io.csv.CsvStrategy;

public class ReferenceValuesPerIndividualTest {
    private final AttributeHelper attributes = Mockito.mock(AttributeHelper.class);

    private final ReferenceEvaluations evaluations = new ReferenceEvaluations();

    private final Space optimisationSpace = space("y");

    @TempDir
    private Path outputFolder;

    private final ComponentProducer producer = Mockito.mock(ComponentProducer.class);

    private final ExecutionRecorder recorder = new ExecutionRecorder();

    private final Space searchSpace = space("x");

    private final CsvStrategy strategy = new CsvStrategy();

    private static EAttribute feature(final Space space, final String name) {
        return (EAttribute) space.getEClass().getEStructuralFeature(name);
    }

    private IndividualRecord individual(final int id, final double x, final double y) {
        final EAttribute xFeature = feature(searchSpace, "x");
        final TypedEObject input = searchSpace.newEObject();
        input.eSet(xFeature, x);

        final EAttribute yFeature = feature(optimisationSpace, "y");
        final TypedEObject output = optimisationSpace.newEObject();
        output.eSet(yFeature, y);

        final IndividualRecord individual = MemoryFactory.eINSTANCE.createIndividualRecord();
        individual.setId(id);
        individual.setInput(input);
        individual.setOutput(output);

        return individual;
    }

    private static void inject(final Class<?> owner, final Object target, final String name, final Object value)
            throws Exception {
        final Field field = owner.getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    @BeforeEach
    @SuppressWarnings("unchecked")
    public void injectDependencies() throws Exception {
        final File folder = outputFolder.toFile();
        inject(CsvStrategy.class, strategy, "outputFolder", folder);
        inject(WriterStrategy.class, strategy, "context", new WriterContext());

        final Instance<MetricContributor> contributors = Mockito.mock(Instance.class, Mockito.CALLS_REAL_METHODS);
        Mockito.doAnswer(invocation -> List.<MetricContributor>of(evaluations).iterator())
               .when(contributors)
               .iterator();
        inject(ExecutionRecorder.class, recorder, "contributors", contributors);
        inject(ExecutionRecorder.class, recorder, "reproducibility", new ReproducibilityProtocol());

        recorder.startRun();
    }

    private Iteration iteration(final int number, final Rank... ranks) {
        final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();
        iteration.setNumber(number);
        iteration.getRanks().addAll(List.of(ranks));

        return iteration;
    }

    private List<String> linesOf(final String fileName) throws IOException {
        final Path file = outputFolder.resolve(fileName);
        return Files.readAllLines(file);
    }

    private Rank rank(final int number, final IndividualRecord... members) {
        final Rank rank = MemoryFactory.eINSTANCE.createRank();
        rank.setNumber(number);
        rank.getMembers().addAll(List.of(members));

        return rank;
    }

    private static Space space(final String featureName) {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName(featureName);
        feature.setEType(EcorePackage.Literals.EDOUBLE);

        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.getEStructuralFeatures().add(feature);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    private TypedEObject tenTimes(final TypedEObject input) {
        final EAttribute xFeature = feature(searchSpace, "x");
        final double x = (Double) input.eGet(xFeature);

        final EAttribute yFeature = feature(optimisationSpace, "y");
        final TypedEObject output = optimisationSpace.newEObject();
        output.eSet(yFeature, 10.0 * x);

        return output;
    }

    /**
     * @return A reference that computes {@code y = 10 x}, unlike the run, whose outputs are
     *   set by {@link #individual}.
     */
    private OptimisationFunction tenTimesX() {
        final OptimisationFunction reference = Mockito.mock(OptimisationFunction.class);
        Mockito.when(reference.evaluate(ArgumentMatchers.any()))
               .thenAnswer(invocation -> tenTimes(invocation.getArgument(0)));

        return reference;
    }

    /**
     * @return A writer whose configuration names the reference.
     */
    private ReferenceValuesPerIndividual writer(final OptimisationFunction reference) throws Exception {
        final EObject configuration = Mockito.mock(EObject.class);
        final EObject referenceConfiguration = Mockito.mock(EObject.class);
        Mockito.when(attributes.lookup(configuration, "reference")).thenReturn(referenceConfiguration);
        Mockito.when(producer.create(OptimisationFunction.class, referenceConfiguration)).thenReturn(reference);

        final ReferenceValuesPerIndividual writer = new ReferenceValuesPerIndividual();
        inject(ReferenceValuesPerIndividual.class, writer, "attributes", attributes);
        inject(ReferenceValuesPerIndividual.class, writer, "evaluations", evaluations);
        inject(ReferenceValuesPerIndividual.class, writer, "optimisationSpace", optimisationSpace);
        inject(ReferenceValuesPerIndividual.class, writer, "producer", producer);
        inject(ReferenceValuesPerIndividual.class, writer, "strategy", strategy);
        writer.init(configuration);

        return writer;
    }

    @Nested
    @DisplayName("given a run without the writer")
    class WithoutWriter {
        @Test
        public void theMetricIsNotDefined() {
            // when
            final Optional<MetricDefinition> definition = recorder.findDefinition(ReferenceEvaluations.METRIC_NAME);

            // then
            Assertions.assertTrue(definition.isEmpty());
        }
    }

    @Nested
    @DisplayName("given two iterations and a reference that differs from the run's function")
    class TwoIterations {
        private ReferenceValuesPerIndividual writer;

        @BeforeEach
        public void runTwoIterations() throws Exception {
            writer = writer(tenTimesX());
            recorder.beginExecution();

            writer.add(iteration(0, rank(0, individual(7, 0.5, 1.0)), rank(1, individual(3, 1.5, 2.0))));
            writer.add(iteration(1, rank(0, individual(7, 0.5, 1.0), individual(9, 0.25, 0.0))));
            writer.write();
            strategy.closeAll();
        }

        @Test
        public void everySurvivorGetsTheValueOfTheReference() throws Exception {
            // when
            final List<String> lines = linesOf("reference-values-per-individual.csv");

            // then
            final List<String> expected = List.of("individual-id,generation,y",
                                                  "7,0,5.0",
                                                  "3,0,15.0",
                                                  "7,1,5.0",
                                                  "9,1,2.5");
            Assertions.assertEquals(expected, lines);
        }

        @Test
        public void theEvaluationsAreAnExecutionMetric() {
            // when
            final MetricDefinition definition = recorder.findDefinition(ReferenceEvaluations.METRIC_NAME)
                                                        .orElseThrow();
            final Number value = recorder.getExecution()
                                         .getMetrics()
                                         .get(ReferenceEvaluations.METRIC_NAME);

            // then
            Assertions.assertEquals(MetricScope.EXECUTION, definition.getScope());
            Assertions.assertEquals(MetricKind.COUNTER, definition.getKind());
            Assertions.assertEquals(4L, value);
        }
    }

    @Nested
    @DisplayName("given two writers in one run")
    class TwoWriters {
        @Test
        public void theyShareOneCounter() throws Exception {
            // given
            final ReferenceValuesPerIndividual first = writer(tenTimesX());
            final ReferenceValuesPerIndividual second = writer(tenTimesX());
            recorder.beginExecution();

            // when
            final Iteration iteration = iteration(0, rank(0, individual(1, 0.5, 1.0), individual(2, 1.0, 1.0)));
            first.add(iteration);
            second.add(iteration);

            // then
            final Number value = recorder.getExecution()
                                         .getMetrics()
                                         .get(ReferenceEvaluations.METRIC_NAME);
            Assertions.assertEquals(4L, value);
        }
    }

    @Nested
    @DisplayName("given a reference that fails")
    class FailingReference {
        @Test
        public void theFailureNamesTheIndividual() throws Exception {
            // given
            final OptimisationFunction reference = Mockito.mock(OptimisationFunction.class);
            Mockito.when(reference.evaluate(ArgumentMatchers.any()))
                   .thenThrow(new IllegalStateException("The task stream 'x' is only available during an evaluation."));
            final ReferenceValuesPerIndividual writer = writer(reference);
            recorder.beginExecution();

            // when
            final Iteration iteration = iteration(0, rank(0, individual(5, 0.5, 1.0)));
            final IllegalStateException failure = Assertions.assertThrows(IllegalStateException.class,
                                                                          () -> writer.add(iteration));

            // then
            Assertions.assertTrue(failure.getMessage().contains("individual 5"), failure.getMessage());
            Assertions.assertEquals(1L, evaluations.numberOfEvaluations());
        }
    }
}
