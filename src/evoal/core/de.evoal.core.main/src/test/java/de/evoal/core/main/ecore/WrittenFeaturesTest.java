package de.evoal.core.main.ecore;

import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.core.api.ecore.io.EObjectWriter;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

/**
 * The writers write the features of the space they are opened with, in its order, and the JSON
 *   writer writes every value it can read back (#357).
 */
public class WrittenFeaturesTest {
    private final EAttribute x = attribute("x:0", EcorePackage.Literals.EDOUBLE);
    private final EAttribute n = attribute("n", EcorePackage.Literals.EINT);
    private final EAttribute l = attribute("l", EcorePackage.Literals.ELONG);
    private final EAttribute s = attribute("s", EcorePackage.Literals.ESTRING);
    private final EAttribute d = attribute("d", EcorePackage.Literals.EDATE);
    private final Space space = space(x, n, l, s, d);

    @TempDir
    Path folder;

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

    private TypedEObject row() {
        final TypedEObject row = space.newEObject();
        row.eSet(x, 1.5);
        row.eSet(n, 2);
        row.eSet(l, 1L << 40);
        row.eSet(s, "a");

        return row;
    }

    private String write(final File file, final EObjectWriter writer, final Space written, final TypedEObject row) throws Exception {
        try(final EObjectWriter testee = writer.init(file, written)) {
            testee.add(row);
        }

        return Files.readString(file.toPath());
    }

    private TypedEObject read(final File file, final EObjectReader reader) throws Exception {
        return read(file, reader, space);
    }

    private TypedEObject read(final File file, final EObjectReader reader, final Space read) throws Exception {
        try(final EObjectReader testee = reader.init(file, read)) {
            return testee.next();
        }
    }

    @Test
    public void theJsonWriterWritesTheFeaturesOfItsSpaceInItsOrder() throws Exception {
        // given
        final File file = folder.resolve("data.json").toFile();

        // when
        final String json = write(file, new JsonPropertiesWriter(), space.subSpace(List.of(s, x)), row());

        // then
        Assertions.assertEquals("[[{\"name\":\"s\",\"value\":\"a\"},{\"name\":\"x:0\",\"value\":1.5}]]", json);
    }

    @Test
    public void theJsonAndCsvWritersWriteTheSameFeatures() throws Exception {
        // given
        final Space written = space.subSpace(List.of(s, x));
        final File json = folder.resolve("data.json").toFile();
        final File csv = folder.resolve("data.csv").toFile();

        // when
        write(json, new JsonPropertiesWriter(), written, row());
        write(csv, new CSVEObjectWriter(), written, row());

        // then: the CSV reader needs a column for each feature it reads
        Assertions.assertTrue(Files.readString(csv.toPath()).startsWith("s,x:0\r\n"));
        final TypedEObject fromJson = read(json, new JsonEObjectReader());
        final TypedEObject fromCsv = read(csv, new CSVEObjectReader(), written);
        for(final EStructuralFeature feature : space) {
            Assertions.assertEquals(written.contains(feature), fromJson.eIsSet(feature), feature.getName());
            Assertions.assertEquals(written.contains(feature), fromCsv.eIsSet(feature), feature.getName());
            Assertions.assertEquals(fromCsv.eGet(feature), fromJson.eGet(feature), feature.getName());
        }
    }

    @Test
    public void aLongValueIsWrittenAsANumberAndReadBackAsALong() throws Exception {
        // given
        final File file = folder.resolve("data.json").toFile();

        // when
        final String json = write(file, new JsonPropertiesWriter(), space.subSpace(List.of(n, l)), row());

        // then
        Assertions.assertEquals("[[{\"name\":\"n\",\"value\":2},{\"name\":\"l\",\"value\":1099511627776}]]", json);
        final TypedEObject read = read(file, new JsonEObjectReader());
        Assertions.assertEquals(2, read.eGet(n));
        Assertions.assertEquals(1L << 40, read.eGet(l));
    }

    @Test
    public void aValueTheJsonWriterCannotWriteIsAnError() {
        // given
        final File file = folder.resolve("data.json").toFile();
        final TypedEObject row = row();
        row.eSet(d, new Date(0));

        // when
        final EvoalIOException e = Assertions.assertThrows(EvoalIOException.class,
                () -> write(file, new JsonPropertiesWriter(), space, row));

        // then
        Assertions.assertTrue(e.getMessage().contains("'d' (Date)"), e.getMessage());
    }

    @Test
    public void aNumberThatDoesNotFitIntoItsFeatureIsAnError() throws Exception {
        // given
        final Path file = folder.resolve("data.json");
        Files.writeString(file, "[[{\"name\":\"n\",\"value\":1099511627776}]]");

        // when
        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> read(file.toFile(), new JsonEObjectReader()));

        // then
        Assertions.assertTrue(e.getMessage().contains("'n'"), e.getMessage());
    }
}
