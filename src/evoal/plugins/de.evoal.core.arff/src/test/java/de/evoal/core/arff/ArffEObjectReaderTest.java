package de.evoal.core.arff;

import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.arff.io.ArffEObjectReader;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.core.junit.resources.ResourceUtils;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ArffEObjectReaderTest {

    @Test
    public void testSimpleArff() throws EvoalIOException, IOException {
        final Path temporary = Files.createTempDirectory("evoal");
        final File temporaryFolder = temporary.toFile();
        ResourceUtils.unpack(getClass().getClassLoader(), temporaryFolder, "simple/input.arff");

        final DataDescriptionModule model = LanguageHelper.loadFromClasspath("simple/specification.ddl");
        final Space specification = readSpecification(model);

        final EObjectReader testee = new ArffEObjectReader()
                        .init(new File(temporaryFolder, "simple/input.arff"), specification);


        final EStructuralFeature sepalLength = specification.find("sepallength").get();
        final EStructuralFeature sepalWidth = specification.find("sepalwidth").get();
        final EStructuralFeature petalLength = specification.find("petallength").get();
        final EStructuralFeature petalWidth = specification.find("petalwidth").get();
        final EStructuralFeature category = specification.find("class").get();

        {
            Assertions.assertTrue(testee.hasNext());
            final TypedEObject p = testee.next();
            Assertions.assertEquals(5.1, p.eGet(sepalLength));
            Assertions.assertEquals(3.5, p.eGet(sepalWidth));
            Assertions.assertEquals(1.4, p.eGet(petalLength));
            Assertions.assertEquals(0.2, p.eGet(petalWidth));
            Assertions.assertEquals("Iris-setosa", p.eGet(category));
        }
        {
            Assertions.assertTrue(testee.hasNext());
            final TypedEObject p = testee.next();
            Assertions.assertEquals(4.9, p.eGet(sepalLength));
            Assertions.assertEquals(3.0, p.eGet(sepalWidth));
            Assertions.assertEquals(1.4, p.eGet(petalLength));
            Assertions.assertEquals(0.2, p.eGet(petalWidth));
            Assertions.assertEquals("Iris-setosa", p.eGet(category));
        }
        {
            Assertions.assertTrue(testee.hasNext());
            final TypedEObject p = testee.next();
            Assertions.assertEquals(4.7, p.eGet(sepalLength));
            Assertions.assertEquals(3.2, p.eGet(sepalWidth));
            Assertions.assertEquals(1.3, p.eGet(petalLength));
            Assertions.assertEquals(0.2, p.eGet(petalWidth));
            Assertions.assertEquals("Iris-setosa", p.eGet(category));
        }
        {
            Assertions.assertTrue(testee.hasNext());
            final TypedEObject p = testee.next();
            Assertions.assertEquals(4.6, p.eGet(sepalLength));
            Assertions.assertEquals(3.1, p.eGet(sepalWidth));
            Assertions.assertEquals(1.5, p.eGet(petalLength));
            Assertions.assertEquals(0.2, p.eGet(petalWidth));
            Assertions.assertEquals("Iris-setosa", p.eGet(category));
        }

        Assertions.assertFalse(testee.hasNext());
    }

    @Test
    public void testExceptionDuringInit() throws EvoalIOException {
        final File file = Mockito.mock(File.class);
        final Space specification = Mockito.mock(Space.class);

        Mockito.when(file.toString())
               .thenThrow(new RuntimeException())
               .thenReturn("<mock file>");

        final EObjectReader testee = new ArffEObjectReader();
        Assertions.assertThrows(EvoalIOException.class, () ->testee.init(file, specification));
    }

    @Test
    public void testClose() throws Exception {
        final EObjectReader testee = new ArffEObjectReader();
        testee.close();
    }

    private Space readSpecification(final DataDescriptionModule model) {
        final EClass eClass = new EClassProvider().eClassFor(model);

        return new Space(eClass);
    }
}
