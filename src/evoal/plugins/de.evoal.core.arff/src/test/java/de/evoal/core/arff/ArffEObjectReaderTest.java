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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    @Nested
    @DisplayName("given an ARFF file with missing values")
    class MissingValues {
        private MissingValuesData data;

        @BeforeEach
        void setUp() throws IOException {
            data = new MissingValuesData();
        }

        @Test
        public void everyAttributeSetsItsFeatureAndAZeroIsAValue() throws Exception {
            try(final EObjectReader testee = new ArffEObjectReader().init(data.input(), data.space)) {
                final TypedEObject row = testee.next();

                Assertions.assertTrue(row.eIsSet(data.x));
                Assertions.assertEquals(0.0, row.eGet(data.x));
                Assertions.assertEquals(3, row.eGet(data.n));
                Assertions.assertEquals(true, row.eGet(data.b));
                Assertions.assertEquals("a b", row.eGet(data.s));
            }
        }

        @Test
        public void aMissingValueLeavesItsFeatureUnset() throws Exception {
            try(final EObjectReader testee = new ArffEObjectReader().init(data.input(), data.space)) {
                testee.next();
                final TypedEObject row = testee.next();

                for(final EStructuralFeature feature : data.space) {
                    Assertions.assertFalse(row.eIsSet(feature), feature.getName());
                }
            }
        }

        @Test
        public void falseAndTheEmptyStringAreValues() throws Exception {
            try(final EObjectReader testee = new ArffEObjectReader().init(data.input(), data.space)) {
                testee.next();
                testee.next();
                final TypedEObject row = testee.next();

                Assertions.assertEquals(1.5, row.eGet(data.x));
                Assertions.assertEquals(-2, row.eGet(data.n));
                Assertions.assertTrue(row.eIsSet(data.b));
                Assertions.assertEquals(false, row.eGet(data.b));
                Assertions.assertTrue(row.eIsSet(data.s));
                Assertions.assertEquals("", row.eGet(data.s));
                Assertions.assertFalse(testee.hasNext());
            }
        }

        @Test
        public void anIntegerFeatureRejectsAFraction() throws Exception {
            final File file = data.arff("fraction.arff", "1.0,2.5,true,a");

            try(final EObjectReader testee = new ArffEObjectReader().init(file, data.space)) {
                final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, testee::next);
                Assertions.assertTrue(e.getMessage().contains("'n' has the value 2.5"), e.getMessage());
            }
        }

        @Test
        public void aBooleanFeatureRejectsOtherValues() throws Exception {
            final Path file = data.folder.resolve("yes.arff");
            Files.writeString(file, """
                    @relation yes
                    @attribute b {no,yes}
                    @data
                    yes
                    """);

            try(final EObjectReader testee = new ArffEObjectReader().init(file.toFile(), data.space)) {
                final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, testee::next);
                Assertions.assertTrue(e.getMessage().contains("'b' has the value 'yes'"), e.getMessage());
            }
        }

        @Test
        public void anAttributeThatDoesNotFitItsFeatureFailsInit() throws Exception {
            final Path file = data.folder.resolve("string-as-real.arff");
            Files.writeString(file, """
                    @relation mismatch
                    @attribute 'x:0' string
                    @data
                    a
                    """);

            final EvoalIOException e = Assertions.assertThrows(EvoalIOException.class,
                                                               () -> new ArffEObjectReader().init(file.toFile(), data.space));
            Assertions.assertTrue(e.getCause().getMessage().contains("Cannot read the string attribute 'x:0' into the feature 'x:0'"),
                                  e.getCause().getMessage());
        }
    }

    private Space readSpecification(final DataDescriptionModule model) {
        final EClass eClass = new EClassProvider().eClassFor(model);

        return new Space(eClass);
    }
}
