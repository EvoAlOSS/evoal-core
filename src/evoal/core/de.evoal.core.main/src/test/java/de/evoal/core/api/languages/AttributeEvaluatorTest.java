package de.evoal.core.api.languages;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AttributeEvaluatorTest {
    private final AttributeEvaluator evaluator = new AttributeEvaluator();

    private EClass eClass;

    private EAttribute attribute(final String name, final EClassifier type, final boolean many) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(type);
        attribute.setUpperBound(many ? EStructuralFeature.UNBOUNDED_MULTIPLICITY : 1);
        attribute.setUnique(false);
        eClass.getEStructuralFeatures().add(attribute);
        return attribute;
    }

    @BeforeEach
    public void createClass() {
        final EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
        ePackage.setName("test");
        eClass = EcoreFactory.eINSTANCE.createEClass();
        eClass.setName("component");
        ePackage.getEClassifiers().add(eClass);
    }

    private Object read(final EObject object, final String name) {
        return evaluator.attributeToJava(object, name, eClass.getEStructuralFeature(name).getEType());
    }

    @Test
    public void numbersAreConvertedToTheFeatureType() {
        final EAttribute real = attribute("real", EcorePackage.Literals.EDOUBLE, false);
        final EAttribute integer = attribute("int", EcorePackage.Literals.EINT, false);
        final EAttribute longValue = attribute("long", EcorePackage.Literals.ELONG, false);
        final EAttribute floatValue = attribute("float", EcorePackage.Literals.EFLOAT, false);
        final EObject object = EcoreUtil.create(eClass);
        object.eSet(real, 2.0);
        object.eSet(integer, 3);
        object.eSet(longValue, 4L);
        object.eSet(floatValue, 1.5f);

        Assertions.assertEquals(2.0, read(object, "real"));
        Assertions.assertEquals(3, read(object, "int"));
        Assertions.assertEquals(4L, read(object, "long"));
        Assertions.assertEquals(1.5f, read(object, "float"));
    }

    @Test
    public void multiValuedNumbersAreConvertedElementWise() {
        final EAttribute values = attribute("values", EcorePackage.Literals.EDOUBLE, true);
        final EObject object = EcoreUtil.create(eClass);
        @SuppressWarnings("unchecked")
        final List<Object> list = (List<Object>) object.eGet(values);
        list.addAll(List.of(1.0, 2.5, 1.0));

        Assertions.assertEquals(List.of(1.0, 2.5, 1.0), read(object, "values"));
    }

    @Test
    public void lossyNumberIsRejectedWithAttributeName() {
        // EJavaObject attribute that holds a real value, read as int
        final EAttribute value = attribute("count", EcorePackage.Literals.EJAVA_OBJECT, false);
        final EObject object = EcoreUtil.create(eClass);
        object.eSet(value, 1.7);

        final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                () -> evaluator.attributeToJava(object, "count", EcorePackage.Literals.EINT));
        Assertions.assertTrue(e.getMessage().contains("'count'"), e.getMessage());
    }

    @Test
    public void nestedConfigurationsAreReturnedAsEObjects() {
        final EAttribute single = attribute("single", EcorePackage.Literals.EJAVA_OBJECT, false);
        final EAttribute many = attribute("many", EcorePackage.Literals.EJAVA_OBJECT, true);
        final EObject object = EcoreUtil.create(eClass);
        final EObject first = EcoreUtil.create(eClass);
        final EObject second = EcoreUtil.create(eClass);
        object.eSet(single, first);
        @SuppressWarnings("unchecked")
        final List<Object> list = (List<Object>) object.eGet(many);
        list.addAll(List.of(first, second));

        Assertions.assertSame(first, evaluator.attributeToEObject(object, "single"));
        Assertions.assertArrayEquals(new EObject[] {first, second}, evaluator.attributeToEObjectArray(object, "many"));
    }

    @Test
    public void nonEObjectsAreRejected() {
        final EAttribute single = attribute("single", EcorePackage.Literals.EJAVA_OBJECT, false);
        final EAttribute many = attribute("many", EcorePackage.Literals.EJAVA_OBJECT, true);
        final EObject object = EcoreUtil.create(eClass);
        object.eSet(single, "x");
        @SuppressWarnings("unchecked")
        final List<Object> list = (List<Object>) object.eGet(many);
        list.add(1.0);

        Assertions.assertThrows(IllegalStateException.class, () -> evaluator.attributeToEObject(object, "single"));
        Assertions.assertThrows(IllegalStateException.class, () -> evaluator.attributeToEObjectArray(object, "many"));
    }

    @Test
    public void booleansStringsAndOtherValuesAreReturned() {
        final EAttribute flag = attribute("flag", EcorePackage.Literals.EBOOLEAN, false);
        final EAttribute text = attribute("text", EcorePackage.Literals.ESTRING, false);
        final EAttribute any = attribute("any", EcorePackage.Literals.EJAVA_OBJECT, false);
        final EObject object = EcoreUtil.create(eClass);
        final Object value = new Object();
        object.eSet(flag, true);
        object.eSet(text, "x");
        object.eSet(any, value);

        Assertions.assertEquals(true, read(object, "flag"));
        Assertions.assertEquals("x", read(object, "text"));
        Assertions.assertSame(value, read(object, "any"));
    }
}
