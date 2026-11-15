package de.evoal.optimisation.main.statistics.individuals;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

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

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Rank;

import de.evoal.optimisation.api.statistics.io.WriterStrategy;
import de.evoal.optimisation.api.statistics.writer.AbstractCandidateStatisticsWriter;
import de.evoal.optimisation.api.statistics.writer.WriterContext;
import de.evoal.optimisation.main.statistics.io.csv.CsvStrategy;

public class CandidateWritersTest {
    private final AttributeEvaluator evaluator = Mockito.mock(AttributeEvaluator.class);

    private final Space optimisationSpace = space("y");

    @TempDir
    private Path outputFolder;

    private final Space searchSpace = space("x");

    private final CsvStrategy strategy = new CsvStrategy();

    private Individual individual(final int id, final double x, final double y) {
        final TypedEObject input = searchSpace.newEObject();
        final EAttribute xFeature = (EAttribute) searchSpace.getEClass().getEStructuralFeature("x");
        input.eSet(xFeature, x);

        final TypedEObject output = optimisationSpace.newEObject();
        final EAttribute yFeature = (EAttribute) optimisationSpace.getEClass().getEStructuralFeature("y");
        output.eSet(yFeature, y);

        final Individual individual = MemoryFactory.eINSTANCE.createIndividual();
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
    public void injectDependencies() throws Exception {
        final File folder = outputFolder.toFile();
        inject(CsvStrategy.class, strategy, "outputFolder", folder);
        inject(WriterStrategy.class, strategy, "context", new WriterContext());

        Mockito.when(evaluator.attributeToBoolean(ArgumentMatchers.any(), ArgumentMatchers.eq("prefix-data")))
               .thenReturn(false);
        Mockito.when(evaluator.attributeToBoolean(ArgumentMatchers.any(), ArgumentMatchers.eq("store-search-space")))
               .thenReturn(true);
        Mockito.when(evaluator.attributeToBoolean(ArgumentMatchers.any(),
                                                  ArgumentMatchers.eq("store-optimisation-space")))
               .thenReturn(true);
    }

    private List<String> linesOf(final String fileName) throws IOException {
        final Path file = outputFolder.resolve(fileName);
        return Files.readAllLines(file);
    }

    private Rank rank(final int number, final Individual... members) {
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

    private <T extends AbstractCandidateStatisticsWriter> T writer(final T writer) throws Exception {
        inject(AbstractCandidateStatisticsWriter.class, writer, "evaluator", evaluator);
        inject(AbstractCandidateStatisticsWriter.class, writer, "optimisationSpace", optimisationSpace);
        inject(AbstractCandidateStatisticsWriter.class, writer, "searchSpace", searchSpace);
        inject(AbstractCandidateStatisticsWriter.class, writer, "strategy", strategy);

        final EObject configuration = Mockito.mock(EObject.class);
        writer.init(configuration);

        return writer;
    }

    @Nested
    @DisplayName("given an iteration whose best individual is not the first survivor")
    class BestIndividualIsNotFirst {
        private Iteration iteration;

        @BeforeEach
        public void createIteration() {
            iteration = MemoryFactory.eINSTANCE.createIteration();
            iteration.setNumber(4);
            iteration.getRanks().add(rank(0, individual(7, 0.5, 1.0)));
            iteration.getRanks().add(rank(1, individual(3, 1.5, 2.0), individual(5, 2.5, 3.0)));
        }

        @Test
        public void bothFilesWriteTheIdOfTheMemoryModel() throws Exception {
            // given
            final CandidatesPerGeneration candidates = writer(new CandidatesPerGeneration());
            final BestCandidatePerGeneration best = writer(new BestCandidatePerGeneration());

            // when
            candidates.add(iteration);
            best.add(iteration);
            strategy.closeAll();

            // then
            final List<String> candidateLines = linesOf("candidates-per-iteration.csv");
            final List<String> bestLines = linesOf("best-candidate-per-iteration.csv");

            final List<String> expectedCandidates = List.of("individual-id,generation,x,y",
                                                            "7,4,0.5,1.0",
                                                            "3,4,1.5,2.0",
                                                            "5,4,2.5,3.0");
            Assertions.assertEquals(expectedCandidates, candidateLines);
            Assertions.assertEquals(List.of("individual-id,generation,x,y", "7,4,0.5,1.0"), bestLines);
        }
    }
}
