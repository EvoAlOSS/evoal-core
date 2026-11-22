package de.evoal.optimisation.main.statistics.memory;

import java.util.List;

import tools.jackson.databind.node.ObjectNode;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.languages.ExpressionText;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.base.expressions.IntegerLiteral;
import de.evoal.models.v202704.core.CorePackage;

/**
 * Tests the conversion of a configuration with the attribute values as the components read
 *   them ({@link ConfigurationJson#of(AttributeEvaluator)}).
 */
public class ConfigurationJsonTest {
    private final ConfigurationJson json = ConfigurationJson.of(new AttributeEvaluator());

    /**
     * The module {@code de.evoal.test} that holds the test types.
     */
    private EPackage module;

    private static EAttribute attribute(final EClass type, final String name, final EClassifier eType,
                                        final int lowerBound) {
        final EAttribute attribute = EcoreFactory.eINSTANCE.createEAttribute();
        attribute.setName(name);
        attribute.setEType(eType);
        attribute.setLowerBound(lowerBound);
        type.getEStructuralFeatures().add(attribute);

        return attribute;
    }

    @BeforeEach
    public void createModule() {
        final EPackage root = EcoreFactory.eINSTANCE.createEPackage();
        module = EcoreFactory.eINSTANCE.createEPackage();
        module.setName("de.evoal.test");
        root.getESubpackages().add(module);
    }

    private static EReference reference(final EClass type, final String name, final EClassifier eType,
                                        final boolean containment, final int upperBound) {
        final EReference reference = EcoreFactory.eINSTANCE.createEReference();
        reference.setName(name);
        reference.setEType(eType);
        reference.setContainment(containment);
        reference.setLowerBound(0);
        reference.setUpperBound(upperBound);
        type.getEStructuralFeatures().add(reference);

        return reference;
    }

    private EClass type(final String name) {
        final EClass type = EcoreFactory.eINSTANCE.createEClass();
        type.setName(name);
        type.getESuperTypes().add(CorePackage.Literals.CONFIGURATION);
        module.getEClassifiers().add(type);

        return type;
    }

    @Test
    public void allKindsOfValuesAreWrittenInTheOrderOfTheType() {
        // given
        final EClass step = type("step");
        final EAttribute weight = attribute(step, "weight", EcorePackage.Literals.EDOUBLE, 0);
        weight.setDefaultValueLiteral("1.0");

        final EEnum order = EcoreFactory.eINSTANCE.createEEnum();
        order.setName("order");
        final EEnumLiteral fixed = EcoreFactory.eINSTANCE.createEEnumLiteral();
        fixed.setName("fixed");
        order.getELiterals().add(fixed);
        module.getEClassifiers().add(order);

        final EClass algorithm = type("algorithm");
        final EAttribute size = attribute(algorithm, "size", EcorePackage.Literals.EINT, 1);
        final EAttribute normalise = attribute(algorithm, "normalise", EcorePackage.Literals.EBOOLEAN, 0);
        normalise.setDefaultValueLiteral("true");
        final EAttribute orderAttribute = attribute(algorithm, "order", order, 1);
        final EAttribute objective = attribute(algorithm, "objective", EcorePackage.Literals.ESTRUCTURAL_FEATURE, 1);
        final EReference condition = reference(algorithm, "condition", ExpressionsPackage.Literals.EXPRESSION, false, 1);
        final EReference first = reference(algorithm, "first", step, true, 1);
        final EReference steps = reference(algorithm, "steps", step, true, -1);

        final EObject firstStep = EcoreUtil.create(step);
        firstStep.eSet(weight, 2.0);

        final IntegerLiteral expression = ExpressionsFactory.eINSTANCE.createIntegerLiteral();
        expression.setLiteral(3);

        final EObject configuration = EcoreUtil.create(algorithm);
        configuration.eSet(size, 10);
        configuration.eSet(normalise, true);
        configuration.eSet(orderAttribute, fixed);
        configuration.eSet(objective, size);
        configuration.eSet(condition, expression);
        configuration.eSet(first, firstStep);
        configuration.eSet(steps, List.of(EcoreUtil.create(step)));

        // when
        final ObjectNode node = json.toConfiguration(configuration);

        // then
        final String expected = "{\"type\":\"de.evoal.test.algorithm\",\"attributes\":{"
                + "\"size\":10,\"normalise\":true,\"order\":\"fixed\",\"objective\":\"size\","
                + "\"condition\":\"" + ExpressionText.of(expression) + "\","
                + "\"first\":{\"type\":\"de.evoal.test.step\",\"attributes\":{\"weight\":2.0}},"
                + "\"steps\":[{\"type\":\"de.evoal.test.step\",\"attributes\":{\"weight\":1.0}}]}}";
        Assertions.assertEquals(expected, node.toString());
    }

    @Test
    public void unsetOptionalAttributesAreNullAndUnsetArraysEmpty() {
        // given
        final EClass repair = type("repair");
        final EClass mutation = type("mutation");
        attribute(mutation, "gene-probability", EcorePackage.Literals.EDOUBLE_OBJECT, 0);
        attribute(mutation, "group", EcorePackage.Literals.ESTRING, 0);
        reference(mutation, "repair", repair, true, 1);
        reference(mutation, "condition", ExpressionsPackage.Literals.EXPRESSION, false, 1);
        reference(mutation, "repairs", repair, true, -1);

        // when
        final ObjectNode node = json.toConfiguration(EcoreUtil.create(mutation));

        // then
        Assertions.assertEquals("{\"type\":\"de.evoal.test.mutation\",\"attributes\":{"
                                + "\"gene-probability\":null,\"group\":null,\"repair\":null,"
                                + "\"condition\":null,\"repairs\":[]}}",
                                node.toString());
    }

    @Test
    public void aSetOptionalAttributeIsWritten() {
        // given
        final EClass mutation = type("mutation");
        final EStructuralFeature geneProbability = attribute(mutation, "gene-probability", EcorePackage.Literals.EDOUBLE_OBJECT, 0);
        final EObject configuration = EcoreUtil.create(mutation);
        configuration.eSet(geneProbability, 0.25);

        // when
        final ObjectNode node = json.toConfiguration(configuration);

        // then
        Assertions.assertEquals("{\"type\":\"de.evoal.test.mutation\",\"attributes\":{\"gene-probability\":0.25}}",
                                node.toString());
    }

    @Test
    public void anOptionalAttributeSetToZeroIsWritten() {
        // given
        final EClass mutation = type("mutation");
        final EStructuralFeature geneProbability = attribute(mutation, "gene-probability", EcorePackage.Literals.EDOUBLE_OBJECT, 0);
        final EObject configuration = EcoreUtil.create(mutation);
        configuration.eSet(geneProbability, 0.0);

        // when
        final ObjectNode node = json.toConfiguration(configuration);

        // then
        Assertions.assertEquals("{\"type\":\"de.evoal.test.mutation\",\"attributes\":{\"gene-probability\":0.0}}",
                                node.toString());
    }
}
