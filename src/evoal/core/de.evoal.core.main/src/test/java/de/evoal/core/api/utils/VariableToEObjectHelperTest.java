package de.evoal.core.api.utils;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
public class VariableToEObjectHelperTest {
    @Mock
    private AttributeHelper attributeHelper;

    @InjectMocks
    private VariableToEObjectHelper helper;

    private EStructuralFeature x0;
    private EStructuralFeature x1;
    private EStructuralFeature y0;

    /** Search space consisting of {@code x:0} and {@code x:1}. */
    private Space searchSpace;

    @BeforeEach
    public void setUp() {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("Individual");

        // EMF requires dynamic classes to be contained in a package
        final EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("test");
        ePackage.setNsURI("http://www.evoal.de/test/variable-to-eobject");
        ePackage.getEClassifiers().add(eClass);
        x0 = createAttribute(eClass, "x:0");
        x1 = createAttribute(eClass, "x:1");
        y0 = createAttribute(eClass, "y:0");

        searchSpace = new Space(eClass).subSpace(List.of(x0, x1));
    }

    @Test
    public void allVariablesSet() {
        final TypedEObject result = helper.fromVariables(List.of(variable(x0, 1.0), variable(x1, 0.0)), searchSpace);

        Assertions.assertEquals(1.0, result.eGet(x0));
        Assertions.assertEquals(0.0, result.eGet(x1));
    }

    @Test
    public void variableOutsideOfSpaceIsIgnored() {
        final TypedEObject result = helper.fromVariables(List.of(variable(x0, 1.0), variable(x1, 5.0), variable(y0, 5.0)), searchSpace);

        Assertions.assertEquals(1.0, result.eGet(x0));
        Assertions.assertEquals(5.0, result.eGet(x1));
    }

    @Test
    public void missingVariableIsRejected() {
        final List<EObject> variables = List.of(variable(x0, 1.0), variable(y0, 5.0));

        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class, () -> helper.fromVariables(variables, searchSpace));
        Assertions.assertTrue(e.getMessage().contains("x:1"), e.getMessage());
    }

    @Test
    public void valuesGetTheTypeOfTheFeature() {
        final TypedEObject result = helper.fromVariables(List.of(variable(x0, 1), variable(x1, 2L)), searchSpace);

        Assertions.assertEquals(Double.valueOf(1.0), result.eGet(x0));
        Assertions.assertEquals(Double.valueOf(2.0), result.eGet(x1));
    }

    @Test
    public void lossyValuesAreRejected() {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);
        final EAttribute n = createAttribute(eClass, "n");
        n.setEType(EcorePackage.Literals.EINT);
        final Space space = new Space(eClass);

        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> helper.fromVariables(List.of(variable(n, 0.5)), space));
        Assertions.assertTrue(e.getMessage().contains("'n'"), e.getMessage());
    }

    private EObject variable(final EStructuralFeature feature, final Object value) {
        final EObject variable = mock(EObject.class);
        doReturn(feature).when(attributeHelper).lookup(variable, "var");
        doReturn(value).when(attributeHelper).lookup(variable, "val");
        return variable;
    }

    private static EAttribute createAttribute(final EClass eClass, final String name) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(EcorePackage.Literals.EDOUBLE);
        eClass.getEStructuralFeatures().add(attribute);
        return attribute;
    }
}
