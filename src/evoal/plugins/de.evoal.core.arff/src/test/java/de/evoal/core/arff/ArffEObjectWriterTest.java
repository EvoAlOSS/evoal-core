package de.evoal.core.arff;

import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.core.api.ecore.io.EObjectWriter;
import de.evoal.core.arff.io.ArffEObjectReader;
import de.evoal.core.arff.io.ArffEObjectWriter;
import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Writing an ARFF file and reading it back gives the same values, and a feature without a
 *   value is missing again (#356).
 */
public class ArffEObjectWriterTest {
    private MissingValuesData data;

    @BeforeEach
    void setUp() throws Exception {
        data = new MissingValuesData();
    }

    private TypedEObject row(final Double x, final Integer n, final Boolean b, final String s) {
        final TypedEObject row = data.space.newEObject();
        if(x != null) row.eSet(data.x, x);
        if(n != null) row.eSet(data.n, n);
        if(b != null) row.eSet(data.b, b);
        if(s != null) row.eSet(data.s, s);

        return row;
    }

    private List<TypedEObject> writeAndRead(final List<TypedEObject> rows) throws Exception {
        final File file = data.folder.resolve("out.arff").toFile();

        try(final EObjectWriter writer = new ArffEObjectWriter().init(file, data.space)) {
            for(final TypedEObject row : rows) {
                writer.add(row);
            }
        }

        final List<TypedEObject> result = new ArrayList<>();
        try(final EObjectReader reader = new ArffEObjectReader().init(file, data.space)) {
            while(reader.hasNext()) {
                result.add(reader.next());
            }
        }

        return result;
    }

    private void assertSameValues(final TypedEObject expected, final TypedEObject actual) {
        for(final EStructuralFeature feature : data.space) {
            Assertions.assertEquals(expected.eIsSet(feature), actual.eIsSet(feature), feature.getName());
            Assertions.assertEquals(expected.eGet(feature), actual.eGet(feature), feature.getName());
        }
    }

    @Test
    public void theRowsOfAnArffFileAreWrittenAgain() throws Exception {
        // given
        final List<TypedEObject> rows = new ArrayList<>();
        try(final EObjectReader reader = new ArffEObjectReader().init(data.input(), data.space)) {
            while(reader.hasNext()) {
                rows.add(reader.next());
            }
        }

        // when
        final List<TypedEObject> read = writeAndRead(rows);

        // then: the row of missing values is missing again, 0, false and "" are values
        Assertions.assertEquals(3, read.size());
        for(int i = 0; i < rows.size(); ++i) {
            assertSameValues(rows.get(i), read.get(i));
        }
    }

    @Test
    public void realsKeepAllDigitsAndInfinity() throws Exception {
        // given
        final List<TypedEObject> rows = List.of(row(0.1 + 0.2, 1, true, "x"),
                                                row(Double.POSITIVE_INFINITY, 3, true, "x"),
                                                row(Double.NEGATIVE_INFINITY, 3, true, "x"),
                                                row(-1.0E-300, 4, true, "x"));

        // when
        final List<TypedEObject> read = writeAndRead(rows);

        // then
        for(int i = 0; i < rows.size(); ++i) {
            assertSameValues(rows.get(i), read.get(i));
        }
    }

    @Test
    public void aNaNIsMissingBecauseWekaStoresMissingValuesAsNaN() throws Exception {
        // when
        final List<TypedEObject> read = writeAndRead(List.of(row(Double.NaN, 2, true, "x")));

        // then
        Assertions.assertFalse(read.getFirst().eIsSet(data.x));
        Assertions.assertEquals(2, read.getFirst().eGet(data.n));
    }

    @Test
    public void stringsAreQuoted() throws Exception {
        // given
        final List<TypedEObject> rows = List.of(row(1.0, 1, false, "it's, quoted"),
                                                row(1.0, 1, false, "?"),
                                                row(1.0, 1, false, "%"));

        // when
        final List<TypedEObject> read = writeAndRead(rows);

        // then
        for(int i = 0; i < rows.size(); ++i) {
            assertSameValues(rows.get(i), read.get(i));
        }
    }

    @Test
    public void theFileNamesTheRelationAndMarksMissingValues() throws Exception {
        // given
        final File file = data.folder.resolve("points.arff").toFile();

        // when
        try(final EObjectWriter writer = new ArffEObjectWriter().init(file, data.space)) {
            writer.add(row(0.5, null, null, null));
        }

        // then
        Assertions.assertEquals("""
                                @relation points

                                @attribute x:0 numeric
                                @attribute n numeric
                                @attribute b {false,true}
                                @attribute s string

                                @data
                                0.5,?,?,?
                                """, Files.readString(file.toPath()));
    }
}
