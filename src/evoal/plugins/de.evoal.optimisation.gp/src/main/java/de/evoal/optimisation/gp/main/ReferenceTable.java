package de.evoal.optimisation.gp.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

import de.evoal.core.api.ecore.io.EObjectIOFactory;
import de.evoal.core.api.ecore.io.EObjectReader;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

/**
 * The rows of a reference table: the values of the inputs and the target of every row.
 *
 * @param inputs The values of the inputs of every row, in the order of the input data.
 * @param targets The target of every row.
 */
record ReferenceTable(double[][] inputs, double[] targets) {
    private static List<String> columnNamesOf(final Space columns) {
        return columns.stream()
                      .map(EStructuralFeature::getName)
                      .toList();
    }

    private static EAttribute columnOf(final EStructuralFeature data) {
        final EAttribute column = EcoreFactory.eINSTANCE.createEAttribute();
        column.setName(data.getName());
        column.setEType(data.getEType());
        column.setLowerBound(0);
        column.setUpperBound(1);
        column.setUnsettable(true);

        return column;
    }

    /**
     * @return The space of the columns: one attribute per data with its name and type, the
     *   inputs first, the output last.
     */
    static Space columnsOf(final List<EStructuralFeature> inputs, final EStructuralFeature output) {
        final EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("reference");
        final EClass table = EcoreFactory.eINSTANCE.createEClass();
        table.setName("ReferenceTable");
        ePackage.getEClassifiers().add(table);

        for(final EStructuralFeature data : inputs) {
            final EAttribute column = columnOf(data);
            table.getEStructuralFeatures().add(column);
        }
        final EAttribute outputColumn = columnOf(output);
        table.getEStructuralFeatures().add(outputColumn);

        return new Space(table);
    }

    /**
     * Converts the rows of a table.
     *
     * @param file The file of the table, for messages.
     * @param columns The columns, see {@link #columnsOf}.
     * @param rows The rows.
     * @return The table.
     * @throws IllegalArgumentException if there are no rows or a row has no value of a column.
     */
    static ReferenceTable of(final File file, final Space columns, final List<TypedEObject> rows) {
        if(rows.isEmpty()) {
            throw new IllegalArgumentException("The reference table '" + file + "' has no rows.");
        }

        final List<EStructuralFeature> features = List.copyOf(columns);
        final List<EStructuralFeature> inputColumns = features.subList(0, features.size() - 1);
        final EStructuralFeature outputColumn = features.getLast();

        final double[][] inputs = new double[rows.size()][];
        final double[] targets = new double[rows.size()];
        for(int i = 0; i < inputs.length; ++i) {
            final TypedEObject row = rows.get(i);
            final int rowNumber = i + 1;
            inputs[i] = valuesOf(row, inputColumns, file, rowNumber);
            targets[i] = valueOf(row, outputColumn, file, rowNumber);
        }

        return new ReferenceTable(inputs, targets);
    }

    /**
     * Reads a table whose columns are named by the data; the reader is chosen by the file
     *   extension (e.g. CSV with a header line).
     *
     * @param file The file.
     * @param inputs The numeric data of the inputs.
     * @param output The numeric data of the target.
     * @return The rows of the table.
     * @throws IllegalArgumentException if the file cannot be read, a column is missing, there are
     *   no rows or a row has no value of a column.
     */
    static ReferenceTable read(final File file, final List<EStructuralFeature> inputs,
                               final EStructuralFeature output) {
        final Space columns = columnsOf(inputs, output);
        final List<TypedEObject> rows = readRows(file, columns);

        return of(file, columns, rows);
    }

    /**
     * @return The rows of the file.
     * @throws IllegalArgumentException if the file cannot be read with the columns.
     */
    private static List<TypedEObject> readRows(final File file, final Space columns) {
        final List<TypedEObject> rows = new ArrayList<>();
        try(final EObjectReader reader = EObjectIOFactory.reader(file, columns)) {
            while(reader.hasNext()) {
                rows.add(reader.next());
            }
        } catch(final Exception e) {
            final List<String> names = columnNamesOf(columns);
            throw new IllegalArgumentException("The reference table '" + file + "' cannot be read with the columns "
                                               + names + ": " + e.getMessage(), e);
        }

        return rows;
    }

    /**
     * @return The number of rows.
     */
    int size() {
        return targets.length;
    }

    private static double valueOf(final TypedEObject row, final EStructuralFeature column, final File file,
                                  final int rowNumber) {
        if(!row.eIsSet(column)) {
            throw new IllegalArgumentException("Row " + rowNumber + " of the reference table '" + file
                                               + "' has no value of '" + column.getName() + "'.");
        }

        final Object value = row.eGet(column);

        return NumericConversions.toDouble(value);
    }

    private static double[] valuesOf(final TypedEObject row, final List<EStructuralFeature> columns, final File file,
                                     final int rowNumber) {
        final double[] values = new double[columns.size()];
        for(int i = 0; i < values.length; ++i) {
            values[i] = valueOf(row, columns.get(i), file, rowNumber);
        }

        return values;
    }
}
