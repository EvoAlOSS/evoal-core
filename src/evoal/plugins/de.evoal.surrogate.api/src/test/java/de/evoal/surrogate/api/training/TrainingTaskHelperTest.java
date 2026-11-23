package de.evoal.surrogate.api.training;

import de.evoal.core.api.ecore.io.EObjectIOFactory;
import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.mll.MllFactory;
import de.evoal.languages.model.mll.TaskDescription;
import de.evoal.models.core.ecore.Space;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Which data {@link TrainingTaskHelper} loads for the loaders and for the goodness of fit on
 *   the training data (#325).
 */
public class TrainingTaskHelperTest {
    @TempDir
    private File directory;

    private final TrainingTaskHelper helper = new TrainingTaskHelper();

    private InterpreterState context;

    private EAttribute x;

    private EAttribute y;

    private MockedStatic<EObjectIOFactory> io;

    private static EAttribute attribute(final EClass type, final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        type.getEStructuralFeatures().add(attribute);

        return attribute;
    }

    private File file(final String name) throws IOException {
        final File file = new File(directory, name);
        Assertions.assertTrue(file.createNewFile());

        return file;
    }

    @BeforeEach
    void setUp() {
        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        x = attribute(type, "x:0");
        y = attribute(type, "y:0");

        context = new InterpreterState();
        context.setSpace(new Space(type));

        final TaskDescription task = MllFactory.eINSTANCE.createTaskDescription();
        task.setName("learning-task");
        task.getLearningData().add(new File(directory, "task.json").getPath());
        context.put(task, task);

        io = Mockito.mockStatic(EObjectIOFactory.class);
        io.when(() -> EObjectIOFactory.reader(Mockito.any(), Mockito.any()))
          .thenAnswer(invocation -> Mockito.mock(EObjectReader.class));
    }

    @AfterEach
    void tearDown() {
        io.close();
    }

    private void verifyRead(final File file, final List<EStructuralFeature> features, final int times) {
        io.verify(() -> EObjectIOFactory.reader(Mockito.eq(file),
                                                Mockito.argThat(space -> List.copyOf(space).equals(features))),
                  Mockito.times(times));
    }

    @Test
    public void theTrainingDataLoaderReadsItsFilesWithItsFeatures() throws IOException {
        // given
        final File stated = file("stated.json");

        // when
        helper.loadTrainingData(context, List.of(stated.getPath()), List.of(x, y)).count();

        // then
        verifyRead(stated, List.of(x, y), 1);
    }

    @Test
    public void theGoodnessOfFitUsesTheDataTheLoaderLoaded() throws IOException {
        // given
        final File stated = file("stated.json");
        file("task.json");
        helper.loadTrainingData(new InterpreterState(context), List.of(stated.getPath()), List.of(x, y)).count();

        // when
        helper.loadTrainingDataPaired(new InterpreterState(context)).get().count();

        // then
        verifyRead(stated, List.of(x, y), 2);
        io.verify(() -> EObjectIOFactory.reader(Mockito.eq(new File(directory, "task.json")), Mockito.any()), Mockito.never());
    }

    @Test
    public void theTestDataLoaderReadsItsFilesWithItsFeatures() throws IOException {
        // given
        final File stated = file("test.json");

        // when
        helper.loadTestData(context, List.of(stated.getPath()), List.of(x, y)).count();

        // then
        verifyRead(stated, List.of(x, y), 1);
    }

    @Test
    public void theTestDataLoaderNeedsFiles() {
        // when / then
        Assertions.assertThrows(IllegalStateException.class,
                                () -> helper.loadTestData(context, List.of(), List.of(x, y)));
    }
}
