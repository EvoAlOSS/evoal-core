package de.evoal.optimisation.main.statistics.memory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import tools.jackson.databind.JsonNode;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.ecore.models.EcoreModels;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.IndividualRecord;

/**
 * A search space with a model of an Ecore metamodel (the 2048 policy types of the tests): the
 *   types are written as {@code <nsURI>#//<class>}, the reference to the container and derived
 *   features are left out.
 */
public class EcoreModelCandidateJsonTest {
    private static final String POLICY = "http://evoal.de/test/policy#//";

    private static final String CONDITIONS = "http://evoal.de/test/conditions#//";

    private final MemoryModelJson json = new MemoryModelJson(new EAnnotationHelper(), new ConfigurationJson(EObject::eGet));

    @TempDir
    private Path folder;

    private EClass policy;

    private EPackage conditions;

    private Space searchSpace;

    private EReference feature;

    @BeforeEach
    public void createSearchSpace() throws Exception {
        final URI base = URI.createURI(getClass().getResource("/de/evoal/optimisation/test/models/ecore/policy.ecore").toURI().toString());
        policy = new EcoreModels(List.of()).classOf(List.of("policy.ecore", "conditions.ecore"), "policy.ecore#//Policy", base, "the test");
        final EClass entry = (EClass) policy.getEPackage().getEClassifier("Entry");
        conditions = entry.getEStructuralFeature("condition").getEType().getEPackage();

        feature = EcoreFactory.eINSTANCE.createEReference();
        feature.setName("policy");
        feature.setContainment(true);
        feature.setEType(policy);

        final EClass space = EcoreFactory.eINSTANCE.createEClass();
        space.setName("Space");
        space.getEStructuralFeatures().add(feature);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(space);
        searchSpace = new Space(space);
    }

    private EObject create(final EPackage ePackage, final String name) {
        return EcoreUtil.create((EClass) ePackage.getEClassifier(name));
    }

    private static void set(final EObject object, final String name, final Object value) {
        object.eSet(object.eClass().getEStructuralFeature(name), value);
    }

    @SuppressWarnings("unchecked")
    private static void add(final EObject object, final String name, final EObject value) {
        ((List<EObject>) object.eGet(object.eClass().getEStructuralFeature(name))).add(value);
    }

    /**
     * @return A policy with one entry whose condition compares the score gains of two directions.
     */
    private EObject model() {
        final EObject left = create(conditions, "ScoreGain");
        set(left, "direction", 2);
        final EObject right = create(conditions, "ScoreGain");
        set(right, "direction", 0);

        final EObject comparison = create(conditions, "IntegerComparison");
        set(comparison, "operator", ((EEnum) conditions.getEClassifier("IntegerOperator")).getEEnumLiteral("greater").getInstance());
        set(comparison, "leftOperand", left);
        set(comparison, "rightOperand", right);

        final EObject and = create(conditions, "AndExpression");
        add(and, "comparisons", comparison);
        final EObject or = create(conditions, "OrExpression");
        add(or, "subexpressions", and);

        final EObject entry = create(policy.getEPackage(), "Entry");
        set(entry, "action", 1);
        set(entry, "condition", or);

        final EObject root = EcoreUtil.create(policy);
        add(root, "entries", entry);
        set(root, "action", 3);

        return root;
    }

    @Test
    public void theModelIsWrittenWithTheTypeNamesOfTheMetamodel() throws Exception {
        // given
        final TypedEObject input = searchSpace.newEObject();
        input.eSet(feature, model());
        final IndividualRecord individual = MemoryModels.individual(0, new double[0], 1.0);
        individual.setInput(input);

        // when
        final JsonNode written = json.toIteration(MemoryModels.iteration(0, individual))
                                     .get("individuals").get(0).get("input");

        // then
        final String expected = "{\"policy\":{\"type\":\"" + POLICY + "Policy\",\"values\":{"
                + "\"entries\":[{\"type\":\"" + POLICY + "Entry\",\"values\":{\"action\":1,\"condition\":"
                + "{\"type\":\"" + CONDITIONS + "OrExpression\",\"values\":{\"subexpressions\":["
                + "{\"type\":\"" + CONDITIONS + "AndExpression\",\"values\":{\"comparisons\":["
                + "{\"type\":\"" + CONDITIONS + "IntegerComparison\",\"values\":{\"operator\":\"greater\","
                + "\"leftOperand\":{\"type\":\"" + CONDITIONS + "ScoreGain\",\"values\":{\"direction\":2}},"
                + "\"rightOperand\":{\"type\":\"" + CONDITIONS + "ScoreGain\",\"values\":{\"direction\":0}}}}]}}]}}}}],"
                + "\"action\":3}}}";
        Assertions.assertEquals(expected, written.toString());

        final Path file = folder.resolve("iteration-0.json");
        Files.writeString(file, json.toIteration(MemoryModels.iteration(0, individual)).toString());
        Assertions.assertEquals(List.of(), MemoryModelSchemas.violationsOf(file));
    }
}
