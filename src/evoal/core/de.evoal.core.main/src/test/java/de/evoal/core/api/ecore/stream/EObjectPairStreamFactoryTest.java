package de.evoal.core.api.ecore.stream;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Which rows the pair streams and {@link EObjectStreamSupplier#apply} keep: a value of 0.0 is a
 *   value, a feature that no one set is missing (#355).
 */
public class EObjectPairStreamFactoryTest {
    private final EAttribute x = dataAttribute("x:0");
    private final EAttribute y = dataAttribute("y:0");
    private final Space space = space(x, y);
    private final Space inputs = space.subSpace(Stream.of(x));
    private final Space outputs = space.subSpace(Stream.of(y));

    /**
     * @return A real attribute as {@code EClassProvider} creates it for a data description.
     */
    private static EAttribute dataAttribute(final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        attribute.setUnsettable(true);

        return attribute;
    }

    private static Space space(final EAttribute... features) {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.getEStructuralFeatures().addAll(List.of(features));
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    private TypedEObject row(final double xValue, final double yValue) {
        final TypedEObject row = space.newEObject();
        row.eSet(x, xValue);
        row.eSet(y, yValue);

        return row;
    }

    /**
     * @return A row without a value for x:0, e.g. a missing value of an ARFF file.
     */
    private TypedEObject rowWithoutX(final double yValue) {
        final TypedEObject row = space.newEObject();
        row.eSet(y, yValue);

        return row;
    }

    private List<Double> xOf(final Stream<EObjectPair> pairs) {
        return pairs.map(EObjectPair::getFirst)
                    .map(row -> row.eGetAsDouble(x))
                    .toList();
    }

    private List<TypedEObject> rows() {
        return List.of(row(0.0, 5.0), rowWithoutX(3.0), row(2.0, 0.0));
    }

    @Test
    public void objectsKeepRowsWithZeroAndLeaveOutRowsWithoutAValue() {
        // when
        final EObjectPairStreamSupplier pairs = EObjectPairStreamFactory.createFromList(inputs, outputs, new ListBasedEObjectStreamSupplier(rows()));

        // then
        Assertions.assertEquals(List.of(0.0, 2.0), xOf(pairs.get()));
        Assertions.assertEquals(List.of(0.0, 2.0), xOf(pairs.get()));
    }

    @Test
    public void pairStreamsKeepRowsWithZeroAndLeaveOutRowsWithoutAValue() {
        // given
        final EObjectPairStreamSupplier base = () -> rows().stream().map(row -> new EObjectPair(row, row));

        // when
        final EObjectPairStreamSupplier pairs = EObjectPairStreamFactory.createFromList(inputs, outputs, base);

        // then
        Assertions.assertEquals(List.of(0.0, 2.0), xOf(pairs.get()));
    }

    @Test
    public void pairListsKeepRowsWithZeroAndLeaveOutRowsWithoutAValue() {
        // given
        final List<EObjectPair> base = rows().stream().map(row -> new EObjectPair(row, row)).toList();

        // when
        final EObjectPairStreamSupplier pairs = EObjectPairStreamFactory.createFromList(inputs, outputs, base);

        // then
        Assertions.assertEquals(List.of(0.0, 2.0), xOf(pairs.get()));
    }

    @Test
    public void aSupplierAskedForASpaceKeepsRowsWithZero() {
        // given
        final EObjectStreamSupplier supplier = new ListBasedEObjectStreamSupplier(rows());

        // when
        final List<Double> values = supplier.apply(space).map(row -> row.eGetAsDouble(y)).toList();

        // then
        Assertions.assertEquals(List.of(5.0, 0.0), values);
    }

    @Test
    public void theMissingFeaturesOfARowAreNamed() {
        // then
        Assertions.assertEquals(List.of(x), MissingValues.missing(rowWithoutX(1.0), space));
        Assertions.assertEquals(List.of(), MissingValues.missing(row(0.0, 0.0), space));
    }
}
