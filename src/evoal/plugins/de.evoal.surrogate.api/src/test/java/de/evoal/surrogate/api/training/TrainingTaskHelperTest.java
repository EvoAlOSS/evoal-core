package de.evoal.surrogate.api.training;

import de.evoal.core.api.ecore.io.EObjectIOFactory;
import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.languages.model.mll.MllFactory;
import de.evoal.languages.model.mll.TaskDescription;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
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
 *   the training data (#325), and which rows it leaves out (#356).
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
        // as EClassProvider creates it for a data description (#355)
        attribute.setUnsettable(true);
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
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(type);
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
    public void theTestDataLoaderReadsItsFilesWithItsFeatures() throws IOException {
        // given
        final File stated = file("test.json");

        // when
        helper.loadTestData(context, List.of(stated.getPath()), List.of(x, y)).count();

        // then
        verifyRead(stated, List.of(x, y), 1);
    }

    @Test
    public void aRowWithoutAValueForAFeatureIsLeftOut() throws Exception {
        // given: (0, 1), (2, no value), (no value for x, 3)
        final File stated = file("stated.json");
        final TypedEObject zero = row(0.0, 1.0);
        final TypedEObject noOutput = row(2.0, null);
        final TypedEObject noInput = row(null, 3.0);

        final EObjectReader reader = Mockito.mock(EObjectReader.class);
        Mockito.when(reader.hasNext()).thenReturn(true, true, true, false);
        Mockito.when(reader.next()).thenReturn(zero, noOutput, noInput);
        io.when(() -> EObjectIOFactory.reader(Mockito.eq(stated), Mockito.any())).thenReturn(reader);

        // when
        final List<TypedEObject> rows = helper.loadTrainingData(context, List.of(stated.getPath()), List.of(x, y)).toList();

        // then: the row with a 0 is kept (#355, #356)
        Assertions.assertEquals(List.of(zero), rows);
    }

    private TypedEObject row(final Double xValue, final Double yValue) {
        final TypedEObject row = context.getSpace().newEObject();
        if(xValue != null) row.eSet(x, xValue);
        if(yValue != null) row.eSet(y, yValue);

        return row;
    }

    @Test
    public void theTestDataLoaderNeedsFiles() {
        // when / then
        Assertions.assertThrows(IllegalStateException.class,
                                () -> helper.loadTestData(context, List.of(), List.of(x, y)));
    }
}
