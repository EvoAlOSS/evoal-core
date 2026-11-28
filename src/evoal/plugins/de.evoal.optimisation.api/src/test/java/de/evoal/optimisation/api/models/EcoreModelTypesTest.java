package de.evoal.optimisation.api.models;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.info.FeatureScales;
import de.evoal.core.api.ecore.models.EcoreModels;
import de.evoal.core.api.random.RandomService;
import de.evoal.languages.model.base.definitions.ScaleType;

import de.evoal.optimisation.api.builder.BuildSettings;
import de.evoal.optimisation.api.builder.ModelBuilder;
import de.evoal.optimisation.api.builder.ModelFeatures;
import de.evoal.optimisation.api.builder.ModelTypes;
import de.evoal.optimisation.api.builder.TreeMethod;
import de.evoal.optimisation.api.builder.ValueDrawer;

/**
 * The random builder on the 2048 policy types as an Ecore metamodel in two files
 *   ({@code policy.ecore} with the policy, {@code conditions.ecore} with the conditions).
 */
public class EcoreModelTypesTest {
    private static final String FOLDER = "/de/evoal/optimisation/test/models/ecore/";

    private static final int MODELS = 200;

    private final FeatureBoundaries boundaries = new FeatureBoundaries();

    private EcoreModels models;

    private EClass policy;

    private ModelTypes types;

    private static URI folder() throws URISyntaxException {
        final URL url = EcoreModelTypesTest.class.getResource(FOLDER + "policy.ecore");
        Assertions.assertNotNull(url, "policy.ecore is missing");

        return URI.createURI(url.toURI().toString());
    }

    private EClass classOf(final String name) {
        return (EClass) packageOf(name).getEClassifier(name);
    }

    private EPackage packageOf(final String name) {
        final EPackage policies = policy.getEPackage();
        if(policies.getEClassifier(name) != null) {
            return policies;
        }

        return ((EClass) policy.getEStructuralFeature("entries").getEType()).getEStructuralFeature("condition").getEType().getEPackage();
    }

    private List<EObject> build(final TreeMethod method, final Double optionalProbability, final long seed) {
        final BuildSettings settings = new BuildSettings(method, BuildSettings.NO_SIZE_LIMIT, optionalProbability);
        final ModelBuilder builder = new ModelBuilder(types, new ValueDrawer(boundaries), settings,
                                                      RandomService.withSeed(seed).random("de.evoal.optimisation.test.ecore"));

        final List<EObject> built = new ArrayList<>();
        for(int i = 0; i < MODELS; i++) {
            built.add(builder.build(policy, i));
        }

        return built;
    }

    private static List<EObject> objectsOf(final List<EObject> roots, final String name) {
        final List<EObject> objects = new ArrayList<>();
        for(final EObject root : roots) {
            if(name.equals(root.eClass().getName())) {
                objects.add(root);
            }
            root.eAllContents().forEachRemaining(object -> {
                if(name.equals(object.eClass().getName())) {
                    objects.add(object);
                }
            });
        }

        return objects;
    }

    @BeforeEach
    public void loadTypes() throws URISyntaxException {
        models = new EcoreModels(List.of());
        policy = models.classOf(List.of("policy.ecore", "conditions.ecore"), "policy.ecore#//Policy",
                                folder(), "the test");
        types = new ModelTypes(new EcoreModelTypes(models), new ValueDrawer(boundaries), List.of(policy));
    }

    @Test
    public void theTypesCanBeBuilt() {
        Assertions.assertEquals(List.of(), types.problems());
        Assertions.assertTrue(types.hasOptionalFeatures());
    }

    @Test
    public void theSubtypesComeFromBothFilesInTheOrderOfTheirTypeNames() {
        final List<String> comparisons = models.concreteSubclassesOf(classOf("Comparison"))
                                               .stream()
                                               .map(EcoreModels::typeNameOf)
                                               .toList();

        Assertions.assertEquals(List.of("http://evoal.de/test/conditions#//BooleanComparison",
                                        "http://evoal.de/test/conditions#//IntegerComparison"), comparisons);
    }

    @Test
    public void theBoundariesComeFromTheFacetsAlongTheBaseTypes() {
        final FeatureBoundaries.Boundaries action = boundaries.get(policy.getEStructuralFeature("action"));
        Assertions.assertEquals(new FeatureBoundaries.Boundaries(0, true, 3, true), action);

        final FeatureBoundaries.Boundaries direction = boundaries.get(classOf("ScoreGain").getEStructuralFeature("direction"));
        Assertions.assertEquals(new FeatureBoundaries.Boundaries(0, true, 4, false), direction);
    }

    @Test
    public void theScaleComesFromTheAnnotationOfTheAttribute() {
        Assertions.assertEquals(ScaleType.ORDINAL, FeatureScales.scaleOf(classOf("ScoreGain").getEStructuralFeature("direction")));
        Assertions.assertEquals(ScaleType.NOMINAL, FeatureScales.scaleOf(policy.getEStructuralFeature("action")));
    }

    @Test
    public void containmentsByLowerBoundAndAttributesOnlyWhenUnsettableAreOptional() {
        final EStructuralFeature literal = classOf("BooleanComparison").getEStructuralFeature("leftOperand");
        final EStructuralFeature value = classOf("BooleanLiteral").getEStructuralFeature("value");
        final EStructuralFeature negated = classOf("BooleanComparison").getEStructuralFeature("negated");
        final EStructuralFeature action = policy.getEStructuralFeature("action");

        Assertions.assertTrue(types.isOptional(literal));
        Assertions.assertTrue(types.isOptional(value));
        Assertions.assertFalse(types.isOptional(negated));
        Assertions.assertFalse(types.isOptional(action));
    }

    @Test
    public void theContainerAndDerivedFeaturesAreNotSearched() {
        final List<String> entry = ModelFeatures.of(classOf("Entry")).stream().map(EStructuralFeature::getName).toList();
        final List<String> root = ModelFeatures.of(policy).stream().map(EStructuralFeature::getName).toList();

        Assertions.assertEquals(List.of("action", "condition"), entry);
        Assertions.assertEquals(List.of("entries", "action"), root);
    }

    @Test
    public void theMinimalDepthAndSizeFollowFromTheRequiredFeatures() {
        // Policy > Entry > OrExpression > AndExpression > Comparison > operand; the smallest
        // comparison is a BooleanComparison with its required right operand only
        Assertions.assertEquals(5, types.minimumDepth(policy));
        Assertions.assertEquals(6, types.minimumSize(policy));
    }

    @Test
    public void builtModelsAreValidForTheMetamodel() {
        for(final EObject model : build(new TreeMethod.RampedHalfAndHalf(5, 7), 0.5, 42)) {
            final Diagnostic diagnostic = Diagnostician.INSTANCE.validate(model);

            Assertions.assertEquals(Diagnostic.OK, diagnostic.getSeverity(), () -> diagnostic.getChildren().toString());
        }
    }

    @Test
    public void entriesKnowTheirPolicy() {
        for(final EObject model : build(new TreeMethod.Grow(5), 0.5, 7)) {
            for(final Object entry : (List<?>) model.eGet(policy.getEStructuralFeature("entries"))) {
                Assertions.assertSame(model, ((EObject) entry).eGet(classOf("Entry").getEStructuralFeature("policy")));
            }
        }
    }

    @Test
    public void restrictedIntegersAreDrawnWithinTheirFacets() {
        final List<EObject> calls = objectsOf(build(new TreeMethod.Grow(5), 0.5, 11), "ScoreGain");
        Assertions.assertFalse(calls.isEmpty());

        final EStructuralFeature direction = classOf("ScoreGain").getEStructuralFeature("direction");
        final boolean[] seen = new boolean[4];
        for(final EObject call : calls) {
            final int value = (int) call.eGet(direction);
            Assertions.assertTrue(0 <= value && value < 4, "direction " + value);
            seen[value] = true;
        }

        Assertions.assertArrayEquals(new boolean[] {true, true, true, true}, seen);
    }

    @Test
    public void optionalFeaturesAreSetWithTheProbability() {
        final List<EObject> comparisons = objectsOf(build(new TreeMethod.Grow(5), 0.5, 13), "BooleanComparison");
        final EStructuralFeature literal = classOf("BooleanComparison").getEStructuralFeature("leftOperand");

        final long set = comparisons.stream().filter(comparison -> comparison.eIsSet(literal)).count();
        final double share = (double) set / comparisons.size();

        Assertions.assertTrue(comparisons.size() > 50, "comparisons " + comparisons.size());
        Assertions.assertTrue(0.3 < share && share < 0.7, "share " + share);
    }
}
