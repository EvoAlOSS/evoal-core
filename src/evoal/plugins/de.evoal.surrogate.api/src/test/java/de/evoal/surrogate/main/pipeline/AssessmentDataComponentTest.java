package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.ecore.EObjectPair;
import de.evoal.core.api.interpreter.InterpreterState;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.surrogate.api.training.GoodnessOfFit;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * The rows that {@code 'assessment-data'} records for the goodness of fit (#347).
 */
public class AssessmentDataComponentTest {
    private EAttribute x;
    private Space space;
    private InterpreterState context;

    @BeforeEach
    void setUp() {
        x = EcoreFactory.eINSTANCE.createEAttribute();
        x.setName("x");
        x.setEType(EcorePackage.Literals.EDOUBLE);

        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        type.setName("data");
        type.getEStructuralFeatures().add(x);

        final EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
        pkg.setName("test");
        pkg.setNsURI("http://www.evoal.de/test/assessment-data");
        pkg.getEClassifiers().add(type);

        space = new Space(type);
        context = new InterpreterState();
    }

    private TypedEObject row(final double value) {
        final TypedEObject row = new TypedEObject(space);
        row.eSet(x, value);

        return row;
    }

    private List<Double> assessedValues() {
        return GoodnessOfFit.of(context)
                            .data()
                            .orElseThrow()
                            .get()
                            .map(EObjectPair::getFirst)
                            .map(row -> row.eGetAsDouble(x))
                            .toList();
    }

    @Test
    public void theRowsArePassedOnUnchanged() {
        // given
        final AssessmentDataComponent component = new AssessmentDataComponent(GoodnessOfFit.TRAINING);
        final TypedEObject row = row(1.0);

        // when
        final TypedEObject passed = component.apply(row);

        // then
        Assertions.assertSame(row, passed);
    }

    @Test
    public void theRecordedRowsAreTheAssessedDataSet() {
        // given
        final AssessmentDataComponent component = new AssessmentDataComponent(GoodnessOfFit.TRAINING);
        component.setContext(context);

        // when
        component.apply(row(1.0));
        component.apply(row(2.0));
        component.close();

        // then
        Assertions.assertEquals(GoodnessOfFit.TRAINING, GoodnessOfFit.of(context).dataSet());
        Assertions.assertEquals(List.of(1.0, 2.0), assessedValues());
    }

    @Test
    public void aLaterStepDoesNotChangeTheRecordedRows() {
        // given
        final AssessmentDataComponent component = new AssessmentDataComponent(GoodnessOfFit.TRAINING);
        component.setContext(context);

        // when: a preparation step after the component normalises the row in place
        final TypedEObject passed = component.apply(row(4.0));
        passed.eSet(x, 0.5);
        component.close();

        // then
        Assertions.assertEquals(List.of(4.0), assessedValues());
    }
}
