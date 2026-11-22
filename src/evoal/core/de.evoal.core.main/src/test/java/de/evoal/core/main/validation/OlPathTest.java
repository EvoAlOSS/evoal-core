package de.evoal.core.main.validation;

import static de.evoal.core.main.validation.ValidationModels.array;
import static de.evoal.core.main.validation.ValidationModels.assignment;
import static de.evoal.core.main.validation.ValidationModels.attribute;
import static de.evoal.core.main.validation.ValidationModels.instance;
import static de.evoal.core.main.validation.ValidationModels.type;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.dl.DlFactory;
import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.OLFactory;
import de.evoal.languages.model.ol.OptimisationModule;

/**
 * Tests the paths that {@link OlPath} builds for OL and DL elements.
 */
public class OlPathTest {
    @Test
    public void anOlInstanceInAnArrayHasThePathOfTheConfiguration() {
        // given: algorithm := ea { instance := genetic { mutator := [m, m]; }; };
        final AttributeDefinition mutatorAttribute = attribute("mutator");
        final AttributeDefinition instanceAttribute = attribute("instance");
        final ClassDefinition mutatorType = type("mutator");
        final Instance first = instance(mutatorType);
        final Instance second = instance(mutatorType);
        final Instance genetic = instance(type("genetic", mutatorAttribute), assignment(mutatorAttribute, array(first, second)));
        final AlgorithmInstance algorithm = instance(OLFactory.eINSTANCE.createAlgorithmInstance(), type("ea", instanceAttribute), assignment(instanceAttribute, genetic));
        final OptimisationModule module = OLFactory.eINSTANCE.createOptimisationModule();
        module.setAlgorithm(algorithm);

        // then
        Assertions.assertEquals("algorithm", OlPath.of(algorithm));
        Assertions.assertEquals("algorithm.instance", OlPath.of(genetic));
        Assertions.assertEquals("algorithm.instance.mutator[1]", OlPath.of(second));
    }

    @Test
    public void aDlAnnotationOnAnAttributeHasThePathOfTheAttribute() {
        // given: type Type { @Annotation probability : real; }
        final AttributeDefinition probability = attribute("probability");
        final Instance annotation = instance(type("Annotation"));
        probability.getConstraints().add(annotation);
        final ClassDefinition type = type("Type", probability);
        final DefinitionModule module = DlFactory.eINSTANCE.createDefinitionModule();
        module.getTypes().add(type);

        // then
        Assertions.assertEquals("Type", OlPath.of(type));
        Assertions.assertEquals("Type.probability", OlPath.of(annotation));
    }

    @Test
    public void anElementOutsideAModuleHasThePathOfItsAttributes() {
        // given
        final AttributeDefinition child = attribute("child");
        final Instance inner = instance(type("Inner"));
        final Instance outer = instance(type("Outer", child), assignment(child, inner));

        // then
        Assertions.assertEquals("", OlPath.of(outer));
        Assertions.assertEquals("child", OlPath.of(inner));
    }
}
