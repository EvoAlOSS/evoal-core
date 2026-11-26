package de.evoal.surrogate.knn;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.function.ModelFunction;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * A training row with a value of exactly 0 is a training row of the kNN model (#355).
 */
public class KNNLernerZeroValuesTest {
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

    private ModelFunction learn(final List<TypedEObject> rows) {
        final KNNLerner learner = new KNNLerner(1);
        learner.setFeatureSpaces(inputs, outputs);
        rows.forEach(learner::add);
        learner.learn();

        return learner.toFunction();
    }

    private double predict(final ModelFunction function, final double xValue) {
        final TypedEObject input = space.newEObject();
        input.eSet(x, xValue);
        final TypedEObject output = space.newEObject();
        function.apply(input, output);

        return output.eGetAsDouble(y);
    }

    @Test
    public void aRowAtZeroIsLearned() {
        // given
        final List<TypedEObject> rows = List.of(row(0.0, 5.0), row(1.0, 1.0), row(2.0, 1.0));

        // when
        final ModelFunction function = learn(rows);

        // then: the nearest neighbour of x = 0 is the row at 0, so the training error is 0
        Assertions.assertEquals(3, ((KNNFunction) function).getTrainingData().size());
        Assertions.assertEquals(5.0, predict(function, 0.0));
        Assertions.assertEquals(1.0, predict(function, 1.0));
        Assertions.assertEquals(1.0, predict(function, 2.0));
    }

    @Test
    public void aRowWithoutAValueIsLeftOut() {
        // given: the second row has no value for x:0, e.g. a missing value of an ARFF file
        final TypedEObject missing = space.newEObject();
        missing.eSet(y, 3.0);

        // when
        final ModelFunction function = learn(List.of(row(0.0, 5.0), missing, row(2.0, 1.0)));

        // then
        Assertions.assertEquals(List.of(0.0, 2.0),
                                ((KNNFunction) function).getTrainingDataSupplier().get().map(EObjectPair::getFirst).map(p -> p.eGetAsDouble(x)).toList());
    }
}
