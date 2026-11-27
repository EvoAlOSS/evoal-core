package de.evoal.optimisation.main.checks;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.random.RandomService;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.builder.BuildSettings;
import de.evoal.optimisation.api.builder.ModelBuilder;
import de.evoal.optimisation.api.builder.ModelTrees;
import de.evoal.optimisation.api.builder.TreeMethod;
import de.evoal.optimisation.api.checks.CheckReaction;
import de.evoal.optimisation.api.checks.Repair;
import de.evoal.optimisation.api.models.ModelCandidates;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;

/**
 * {@code 'maximum-size'} and {@code 'maximum-depth'} on candidates with a policy of the 2048
 *   example.
 */
public class ModelLimitChecksTest {
    private final DynamicEClassProvider dynamicClasses = new DynamicEClassProvider();

    private final EClass spaceClass = EcoreFactory.eINSTANCE.createEClass();

    private ModelCandidates models;

    private Space space;

    private EReference policy;

    @BeforeEach
    public void createSearchSpace() {
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(spaceClass);
        final DefinitionModule module = LanguageHelper.loadFromClasspath("de/evoal/optimisation/test/models/policy.dl");
        final ClassDefinition policyType = module.getTypes().stream().filter(type -> "policy".equals(type.getName())).findFirst().orElseThrow();

        policy = EcoreFactory.eINSTANCE.createEReference();
        policy.setName("policy");
        policy.setContainment(true);
        policy.setEType(dynamicClasses.toEClass(policyType));
        spaceClass.getEStructuralFeatures().add(policy);

        space = new Space(spaceClass);
        models = new ModelCandidates(space, new FeatureBoundaries(), dynamicClasses);
    }

    private List<Candidate> candidates(final long seed) {
        final BuildSettings settings = new BuildSettings(new TreeMethod.Full(5), BuildSettings.NO_SIZE_LIMIT, null);
        final ModelBuilder builder = new ModelBuilder(models.types(), models.values(), settings,
                                                      RandomService.withSeed(seed).random("test"));
        final List<Candidate> candidates = new ArrayList<>();
        for(int i = 0; i < 50; ++i) {
            final TypedEObject input = space.newEObject();
            input.eSet(policy, builder.build(policy.getEReferenceType(), i));
            candidates.add(new Candidate(input, Lineage.NONE));
        }

        return candidates;
    }

    private EObject policyOf(final TypedEObject input) {
        return (EObject) input.eGet(policy);
    }

    @Test
    public void tooLargeModelsFailAndAreRepaired() throws InitializationException {
        // given
        final MaximumSizeCheck check = new MaximumSizeCheck(CheckReaction.REPAIR, 3, 10, CheckReaction.WARN, models,
                                                            RandomService.withSeed(1));
        final Repair repair = check.repair().orElseThrow();

        // when / then
        int failed = 0;
        for(final Candidate candidate : candidates(2)) {
            final int size = ModelTrees.size(policyOf(candidate.input()));
            if(size <= 10) {
                Assertions.assertTrue(check.test(candidate).isEmpty());
                continue;
            }

            ++failed;
            Assertions.assertEquals("the model 'policy' has " + size + " objects, the limit is 10", check.test(candidate).orElseThrow());

            final TypedEObject repaired = repair.attempt().apply(candidate.input());
            Assertions.assertTrue(ModelTrees.size(policyOf(repaired)) <= 10);
            Assertions.assertEquals(size, ModelTrees.size(policyOf(candidate.input())), "the candidate itself stays unchanged");
            Assertions.assertTrue(check.test(new Candidate(repaired, Lineage.NONE)).isEmpty());
        }
        Assertions.assertTrue(failed > 0);
        Assertions.assertEquals("minimal-subtree-repair", repair.name());
    }

    @Test
    public void theDepthIsCountedFromTheRoot() throws InitializationException {
        // given: every policy has depth 5
        final MaximumDepthCheck tight = new MaximumDepthCheck(CheckReaction.WARN, 1, 4, CheckReaction.WARN, models,
                                                              RandomService.withSeed(1));
        final MaximumDepthCheck loose = new MaximumDepthCheck(CheckReaction.WARN, 1, 5, CheckReaction.WARN, models,
                                                              RandomService.withSeed(1));
        final Candidate candidate = candidates(3).getFirst();

        // then
        Assertions.assertEquals("the model 'policy' has depth 5, the limit is 4", tight.test(candidate).orElseThrow());
        Assertions.assertTrue(loose.test(candidate).isEmpty());
        Assertions.assertTrue(tight.repair().isEmpty());
    }

    @Test
    public void aSearchSpaceWithoutModelsIsRejected() {
        // given
        final EClass tabular = EcoreFactory.eINSTANCE.createEClass();
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(tabular);
        final ModelCandidates none = new ModelCandidates(new Space(tabular), new FeatureBoundaries(), dynamicClasses);

        // then
        Assertions.assertThrows(InitializationException.class,
                                () -> new MaximumSizeCheck(CheckReaction.WARN, 1, 10, CheckReaction.WARN, none, RandomService.withSeed(1)));
        Assertions.assertThrows(InitializationException.class,
                                () -> new MaximumSizeCheck(CheckReaction.REPAIR, 1, 10, CheckReaction.REPAIR, models, RandomService.withSeed(1)));
    }
}
