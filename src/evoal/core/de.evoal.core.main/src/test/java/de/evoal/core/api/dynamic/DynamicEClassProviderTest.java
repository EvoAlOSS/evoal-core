package de.evoal.core.api.dynamic;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.base.definitions.EnumDefinition;
import de.evoal.languages.model.base.definitions.EnumLiteralDefinition;
import de.evoal.languages.model.base.types.ArrayType;
import de.evoal.languages.model.base.types.EnumDefinitionReference;
import de.evoal.languages.model.base.types.Type;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.IntegerLiteral;
import de.evoal.languages.model.base.expressions.ValueDefinitionReference;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import de.evoal.languages.model.base.types.TypesFactory;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.dl.DlFactory;
import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.core.CorePackage;

public class DynamicEClassProviderTest {
    /**
     * Creates the DL type {@code de.evoal.core.base.configuration} and a sub type of it.
     */
    private static ClassDefinition createSubTypeOfConfiguration() {
        final DefinitionModule base = DlFactory.eINSTANCE.createDefinitionModule();
        base.setName("de.evoal.core.base");
        final ClassDefinition configuration = DefinitionsFactory.eINSTANCE.createClassDefinition();
        configuration.setName("configuration");
        base.getTypes().add(configuration);

        final DefinitionModule plugin = DlFactory.eINSTANCE.createDefinitionModule();
        plugin.setName("com.example.plugin");
        final ClassDefinition component = DefinitionsFactory.eINSTANCE.createClassDefinition();
        component.setName("component");
        component.setSuperType(configuration);
        plugin.getTypes().add(component);

        return component;
    }

    @Test
    public void mappedSuperClassIsUsedForRegisteredPackage() {
        final DynamicEClassProvider provider = new DynamicEClassProvider();
        provider.registerPackage(CorePackage.eINSTANCE);

        final EClass eClass = provider.toEClass(createSubTypeOfConfiguration());
        final EObject object = provider.getEObject(eClass);

        Assertions.assertInstanceOf(Configuration.class, object);
        Assertions.assertSame(eClass, object.eClass());
    }

    /**
     * Creates a DL type with the attribute {@code matrix : array array real}.
     */
    private static ClassDefinition createTypeWithMatrix() {
        final DefinitionModule module = DlFactory.eINSTANCE.createDefinitionModule();
        module.setName("com.example.plugin");

        final ClassDefinition type = DefinitionsFactory.eINSTANCE.createClassDefinition();
        type.setName("distribution");
        module.getTypes().add(type);

        final ArrayType inner = TypesFactory.eINSTANCE.createArrayType();
        inner.setElements(TypesFactory.eINSTANCE.createRealType());
        final ArrayType outer = TypesFactory.eINSTANCE.createArrayType();
        outer.setElements(inner);

        final AttributeDefinition matrix = DefinitionsFactory.eINSTANCE.createAttributeDefinition();
        matrix.setName("matrix");
        matrix.setType(outer);
        type.getAttributes().add(matrix);

        return type;
    }

    @Test
    public void multiDimensionalArrayIsMappedToContainedArrayObjects() {
        final DynamicEClassProvider provider = new DynamicEClassProvider();
        final EClass eClass = provider.toEClass(createTypeWithMatrix());

        final EStructuralFeature matrix = eClass.getEStructuralFeature("matrix");
        final EReference reference = Assertions.assertInstanceOf(EReference.class, matrix);
        Assertions.assertTrue(reference.isContainment());
        Assertions.assertTrue(reference.isMany());

        final EClass arrayClass = reference.getEReferenceType();
        Assertions.assertTrue(DynamicArrays.isArrayClass(arrayClass));

        final EStructuralFeature values = DynamicArrays.valuesFeature(arrayClass);
        Assertions.assertInstanceOf(EAttribute.class, values);
        Assertions.assertTrue(values.isMany());
        Assertions.assertFalse(values.isUnique());
        Assertions.assertSame(EcorePackage.Literals.EDOUBLE, values.getEType());
    }

    @Test
    public void arrayObjectsAreConvertedToNestedLists() {
        final DynamicEClassProvider provider = new DynamicEClassProvider();
        final EClass eClass = provider.toEClass(createTypeWithMatrix());
        final EReference matrix = (EReference) eClass.getEStructuralFeature("matrix");

        final EObject object = provider.getEObject(eClass);
        @SuppressWarnings("unchecked")
        final List<EObject> rows = (List<EObject>) object.eGet(matrix);

        for(final List<Double> row : List.of(List.of(1.0, 0.0), List.of(0.0, 0.0))) {
            final EObject array = provider.getEObject(matrix.getEReferenceType());
            DynamicArrays.valuesOf(array).addAll(row);
            rows.add(array);
        }

        Assertions.assertSame(object, rows.get(0).eContainer());
        Assertions.assertEquals(List.of(List.of(1.0, 0.0), List.of(0.0, 0.0)), DynamicArrays.toJava(object.eGet(matrix)));

        final EObject copy = EcoreUtil.copy(object);
        Assertions.assertTrue(EcoreUtil.equals(object, copy));
        Assertions.assertNotSame(rows.get(0), ((List<?>) copy.eGet(matrix)).get(0));
    }

    @Test
    public void expressionIsMappedToNonContainmentReference() {
        final DefinitionModule module = DlFactory.eINSTANCE.createDefinitionModule();
        module.setName("com.example.plugin");
        final ClassDefinition type = DefinitionsFactory.eINSTANCE.createClassDefinition();
        type.setName("sequence");
        module.getTypes().add(type);

        final AttributeDefinition expression = DefinitionsFactory.eINSTANCE.createAttributeDefinition();
        expression.setName("expression");
        expression.setType(TypesFactory.eINSTANCE.createExpressionType());
        type.getAttributes().add(expression);

        final EClass eClass = new DynamicEClassProvider().toEClass(type);

        final EReference reference = Assertions.assertInstanceOf(EReference.class, eClass.getEStructuralFeature("expression"));
        Assertions.assertFalse(reference.isContainment());
        Assertions.assertSame(ExpressionsPackage.Literals.EXPRESSION, reference.getEType());
    }

    /**
     * Creates {@code enum topology ( global, star, ring )} and a type with an attribute of it.
     */
    static ClassDefinition createTypeWithEnum() {
        final DefinitionModule module = DlFactory.eINSTANCE.createDefinitionModule();
        module.setName("com.example.plugin");

        final EnumDefinition topology = DefinitionsFactory.eINSTANCE.createEnumDefinition();
        topology.setName("topology");
        for(final String name : List.of("global", "star", "ring")) {
            final EnumLiteralDefinition literal = DefinitionsFactory.eINSTANCE.createEnumLiteralDefinition();
            literal.setName(name);
            topology.getLiterals().add(literal);
        }
        module.getEnums().add(topology);

        final ClassDefinition type = DefinitionsFactory.eINSTANCE.createClassDefinition();
        type.setName("algorithm");
        module.getTypes().add(type);

        final EnumDefinitionReference reference = TypesFactory.eINSTANCE.createEnumDefinitionReference();
        reference.setDefinition(topology);
        final AttributeDefinition attribute = DefinitionsFactory.eINSTANCE.createAttributeDefinition();
        attribute.setName("topology");
        attribute.setType(reference);
        type.getAttributes().add(attribute);

        return type;
    }

    @Test
    public void enumIsMappedToEEnum() {
        final DynamicEClassProvider provider = new DynamicEClassProvider();
        final ClassDefinition type = createTypeWithEnum();
        final EClass eClass = provider.toEClass(type);

        final EAttribute attribute = Assertions.assertInstanceOf(EAttribute.class, eClass.getEStructuralFeature("topology"));
        final EEnum eEnum = Assertions.assertInstanceOf(EEnum.class, attribute.getEType());

        Assertions.assertEquals("topology", eEnum.getName());
        Assertions.assertEquals(List.of("global", "star", "ring"), eEnum.getELiterals().stream().map(EEnumLiteral::getName).toList());
        Assertions.assertEquals(2, eEnum.getEEnumLiteral("ring").getValue());
        Assertions.assertSame(eClass.getEPackage(), eEnum.getEPackage());

        final EnumDefinition definition = ((EnumDefinitionReference) ((AttributeDefinition) type.getAttributes().get(0)).getType()).getDefinition();
        Assertions.assertSame(eEnum, provider.toEEnum(definition));
    }

    /**
     * Creates {@code type base { rate : real := 1; }} and
     *   {@code type component extends base { count : int := 10; topology : enum topology := topology.star; name : string; }}.
     */
    static ClassDefinition createTypeWithDefaults() {
        final ClassDefinition component = createTypeWithEnum();
        component.setName("component");
        final DefinitionModule module = (DefinitionModule) component.eContainer();

        final ClassDefinition base = DefinitionsFactory.eINSTANCE.createClassDefinition();
        base.setName("base");
        module.getTypes().add(base);
        component.setSuperType(base);

        final AttributeDefinition rate = attribute("rate", TypesFactory.eINSTANCE.createRealType(), integer(1));
        base.getAttributes().add(rate);

        component.getAttributes().add(attribute("count", TypesFactory.eINSTANCE.createIntType(), integer(10)));
        component.getAttributes().add(attribute("name", TypesFactory.eINSTANCE.createStringType(), null));

        final AttributeDefinition topology = (AttributeDefinition) component.getAttributes().get(0);
        final EnumDefinition topologyEnum = ((EnumDefinitionReference) topology.getType()).getDefinition();
        final ValueDefinitionReference star = ExpressionsFactory.eINSTANCE.createValueDefinitionReference();
        star.setDefinition(topologyEnum.getLiterals().get(1));
        topology.setInitialisation(star);

        return component;
    }

    private static AttributeDefinition attribute(final String name, final Type type, final Expression initialisation) {
        final AttributeDefinition attribute = DefinitionsFactory.eINSTANCE.createAttributeDefinition();
        attribute.setName(name);
        attribute.setType(type);
        attribute.setInitialisation(initialisation);
        return attribute;
    }

    static IntegerLiteral integer(final int value) {
        final IntegerLiteral literal = ExpressionsFactory.eINSTANCE.createIntegerLiteral();
        literal.setLiteral(value);
        return literal;
    }

    @Test
    public void defaultValuesAreDocumentedAsDefaultValueLiterals() {
        final DynamicEClassProvider provider = new DynamicEClassProvider();
        final EClass eClass = provider.toEClass(createTypeWithDefaults());

        final EStructuralFeature count = eClass.getEStructuralFeature("count");
        final EStructuralFeature topology = eClass.getEStructuralFeature("topology");
        final EStructuralFeature rate = eClass.getEAllStructuralFeatures().stream().filter(f -> "rate".equals(f.getName())).findFirst().get();
        final EStructuralFeature name = eClass.getEStructuralFeature("name");

        Assertions.assertEquals("10", count.getDefaultValueLiteral());
        Assertions.assertEquals("star", topology.getDefaultValueLiteral());
        Assertions.assertEquals("1.0", rate.getDefaultValueLiteral());
        Assertions.assertNull(name.getDefaultValueLiteral());

        // attributes with a default value do not have to be specified
        Assertions.assertEquals(0, count.getLowerBound());
        Assertions.assertEquals(1, name.getLowerBound());

        // EMF uses the literal for unset attributes
        final EObject object = provider.getEObject(eClass);
        Assertions.assertEquals(10, object.eGet(count));
        Assertions.assertEquals(1.0, object.eGet(rate));
        Assertions.assertSame(((EEnum) topology.getEType()).getEEnumLiteral("star"), object.eGet(topology));
    }

    /**
     * Creates {@code type component { count : optional int; rate : optional real;
     *   enabled : optional boolean; size : optional int := 3; steps : int; }}.
     */
    private static ClassDefinition createTypeWithOptionalAttributes() {
        final DefinitionModule module = DlFactory.eINSTANCE.createDefinitionModule();
        module.setName("com.example.plugin");
        final ClassDefinition type = DefinitionsFactory.eINSTANCE.createClassDefinition();
        type.setName("component");
        module.getTypes().add(type);

        type.getAttributes().add(optional(attribute("count", TypesFactory.eINSTANCE.createIntType(), null)));
        type.getAttributes().add(optional(attribute("rate", TypesFactory.eINSTANCE.createRealType(), null)));
        type.getAttributes().add(optional(attribute("enabled", TypesFactory.eINSTANCE.createBooleanType(), null)));
        type.getAttributes().add(optional(attribute("size", TypesFactory.eINSTANCE.createIntType(), integer(3))));
        type.getAttributes().add(attribute("steps", TypesFactory.eINSTANCE.createIntType(), null));

        return type;
    }

    private static AttributeDefinition optional(final AttributeDefinition attribute) {
        attribute.setOptional(true);
        return attribute;
    }

    @Test
    public void optionalScalarsAreMappedToObjectTypes() {
        final EClass eClass = new DynamicEClassProvider().toEClass(createTypeWithOptionalAttributes());

        Assertions.assertSame(EcorePackage.Literals.EINTEGER_OBJECT, eClass.getEStructuralFeature("count").getEType());
        Assertions.assertSame(EcorePackage.Literals.EDOUBLE_OBJECT, eClass.getEStructuralFeature("rate").getEType());
        Assertions.assertSame(EcorePackage.Literals.EBOOLEAN_OBJECT, eClass.getEStructuralFeature("enabled").getEType());
        Assertions.assertSame(EcorePackage.Literals.EINTEGER_OBJECT, eClass.getEStructuralFeature("size").getEType());
        Assertions.assertSame(EcorePackage.Literals.EINT, eClass.getEStructuralFeature("steps").getEType());

        Assertions.assertEquals(0, eClass.getEStructuralFeature("count").getLowerBound());
        Assertions.assertEquals("3", eClass.getEStructuralFeature("size").getDefaultValueLiteral());
    }

    @Test
    public void optionalScalarsDistinguishZeroAndFalseFromUnset() {
        final DynamicEClassProvider provider = new DynamicEClassProvider();
        final EClass eClass = provider.toEClass(createTypeWithOptionalAttributes());
        final EObject unset = provider.getEObject(eClass);
        final EObject assigned = provider.getEObject(eClass);

        for(final String name : List.of("count", "rate", "enabled")) {
            final EStructuralFeature feature = eClass.getEStructuralFeature(name);
            Assertions.assertNull(unset.eGet(feature), name);
            Assertions.assertFalse(unset.eIsSet(feature), name);
        }

        assigned.eSet(eClass.getEStructuralFeature("count"), 0);
        assigned.eSet(eClass.getEStructuralFeature("rate"), 0.0);
        assigned.eSet(eClass.getEStructuralFeature("enabled"), false);
        for(final String name : List.of("count", "rate", "enabled")) {
            Assertions.assertTrue(assigned.eIsSet(eClass.getEStructuralFeature(name)), name);
        }
        Assertions.assertEquals(0, assigned.eGet(eClass.getEStructuralFeature("count")));
        Assertions.assertEquals(0.0, assigned.eGet(eClass.getEStructuralFeature("rate")));
        Assertions.assertEquals(false, assigned.eGet(eClass.getEStructuralFeature("enabled")));

        // the default of an optional attribute still applies
        Assertions.assertEquals(3, unset.eGet(eClass.getEStructuralFeature("size")));
    }

    @Test
    public void noMappedSuperClassWithoutRegistration() {
        final DynamicEClassProvider provider = new DynamicEClassProvider();

        final EObject object = provider.getEObject(provider.toEClass(createSubTypeOfConfiguration()));

        Assertions.assertFalse(object instanceof Configuration);
    }
}
