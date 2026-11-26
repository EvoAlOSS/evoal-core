package de.evoal.core.main.ecore;

import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.core.api.ecore.io.EObjectWriter;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * The JSON and CSV files keep a feature without a value (unset) apart from a value, also from
 *   0, {@code false} and the empty string (#356).
 */
public class MissingValuesIOTest {
    private final EAttribute x = attribute("x:0", EcorePackage.Literals.EDOUBLE);
    private final EAttribute n = attribute("n", EcorePackage.Literals.EINT);
    private final EAttribute b = attribute("b", EcorePackage.Literals.EBOOLEAN);
    private final EAttribute s = attribute("s", EcorePackage.Literals.ESTRING);
    private final Space space = space(x, n, b, s);

    @TempDir
    Path folder;

    /**
     * @return An attribute as {@code EClassProvider} creates it for a data description.
     */
    private static EAttribute attribute(final String name, final EDataType type) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(type);
        attribute.setUnsettable(true);

        return attribute;
    }

    private static Space space(final EAttribute... features) {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.getEStructuralFeatures().addAll(List.of(features));
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    private TypedEObject row(final Double xValue, final Integer nValue, final Boolean bValue, final String sValue) {
        final TypedEObject row = space.newEObject();
        if(xValue != null) row.eSet(x, xValue);
        if(nValue != null) row.eSet(n, nValue);
        if(bValue != null) row.eSet(b, bValue);
        if(sValue != null) row.eSet(s, sValue);

        return row;
    }

    /**
     * Rows with 0, false and "", a row without values, and rows with one missing value each.
     */
    private List<TypedEObject> rows() {
        return List.of(row(0.0, 0, false, ""),
                       row(null, null, null, null),
                       row(null, 1, true, "a"),
                       row(1.5, null, true, "a"),
                       row(1.5, 1, null, "a"),
                       row(1.5, 1, true, null));
    }

    private List<TypedEObject> writeAndRead(final File file, final EObjectWriter writer, final EObjectReader reader) throws Exception {
        try(final EObjectWriter testee = writer.init(file, space)) {
            for(final TypedEObject row : rows()) {
                testee.add(row);
            }
        }

        final List<TypedEObject> result = new ArrayList<>();
        try(final EObjectReader testee = reader.init(file, space)) {
            while(testee.hasNext()) {
                result.add(testee.next());
            }
        }

        return result;
    }

    private void assertSameValues(final List<TypedEObject> read) {
        final List<TypedEObject> expected = rows();
        Assertions.assertEquals(expected.size(), read.size());

        for(int i = 0; i < expected.size(); ++i) {
            for(final EStructuralFeature feature : space) {
                final String where = "row " + i + ", " + feature.getName();
                Assertions.assertEquals(expected.get(i).eIsSet(feature), read.get(i).eIsSet(feature), where);
                Assertions.assertEquals(expected.get(i).eGet(feature), read.get(i).eGet(feature), where);
            }
        }
    }

    @Nested
    @DisplayName("JSON")
    class Json {
        @Test
        public void aFeatureWithoutAValueStaysWithoutAValue() throws Exception {
            final File file = folder.resolve("data.json").toFile();

            assertSameValues(writeAndRead(file, new JsonPropertiesWriter(), new JsonEObjectReader()));
        }

        @Test
        public void aFeatureWithoutAValueHasNoEntry() throws Exception {
            // given
            final File file = folder.resolve("data.json").toFile();

            // when
            try(final EObjectWriter testee = new JsonPropertiesWriter().init(file, space)) {
                testee.add(row(0.5, null, null, null));
            }

            // then
            Assertions.assertEquals("[[{\"name\":\"x:0\",\"value\":0.5}]]", Files.readString(file.toPath()));
        }

        @Test
        public void anEntryWithoutAValueOrWithNullLeavesItsFeatureUnset() throws Exception {
            // given
            final Path file = folder.resolve("data.json");
            Files.writeString(file, "[[{\"name\":\"x:0\"},{\"name\":\"n\",\"value\":null},{\"name\":\"b\",\"value\":true}]]");

            // when
            final TypedEObject row;
            try(final EObjectReader testee = new JsonEObjectReader().init(file.toFile(), space)) {
                row = testee.next();
            }

            // then
            Assertions.assertFalse(row.eIsSet(x));
            Assertions.assertFalse(row.eIsSet(n));
            Assertions.assertTrue(row.eIsSet(b));
        }
    }

    @Nested
    @DisplayName("CSV")
    class Csv {
        @Test
        public void aFeatureWithoutAValueStaysWithoutAValue() throws Exception {
            final File file = folder.resolve("data.csv").toFile();

            assertSameValues(writeAndRead(file, new CSVEObjectWriter(), new CSVEObjectReader()));
        }

        @Test
        public void anEmptyCellHasNoValueAndAQuotedEmptyStringIsAValue() throws Exception {
            // given
            final File file = folder.resolve("data.csv").toFile();

            // when
            try(final EObjectWriter testee = new CSVEObjectWriter().init(file, space)) {
                testee.add(row(0.0, 0, false, ""));
                testee.add(row(null, 1, null, "a, b"));
            }

            // then: the cells are quoted only where needed, as before
            Assertions.assertEquals("x:0,n,b,s\r\n0.0,0,false,\"\"\r\n,1,,\"a, b\"\r\n", Files.readString(file.toPath()));
        }
    }
}
