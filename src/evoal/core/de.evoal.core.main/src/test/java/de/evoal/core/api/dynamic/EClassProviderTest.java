package de.evoal.core.api.dynamic;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;

import org.apache.commons.math3.util.Pair;

import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.definitions.RepresentationType;
import de.evoal.languages.model.base.definitions.UntypedBaseDataDescription;
import de.evoal.languages.model.base.expressions.ExpressionsFactory;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.ddl.DdlFactory;
import de.evoal.languages.model.ol.MinimiseGoal;
import de.evoal.languages.model.ol.OLFactory;
import de.evoal.languages.model.ol.ProblemInstance;

public class EClassProviderTest {
    /**
     * Enough data descriptions that a hash-based order differs from the declaration order.
     */
    private static final int NUMBER_OF_DESCRIPTIONS = 30;

    private final EClassProvider provider = new EClassProvider();

    private static List<String> declaredNames(final String prefix) {
        return IntStream.range(0, NUMBER_OF_DESCRIPTIONS)
                        .mapToObj(index -> prefix + index)
                        .toList();
    }

    private static List<DataDescription> descriptions(final List<String> names) {
        return names.stream()
                    .map(EClassProviderTest::description)
                    .toList();
    }

    private static DataDescription description(final String name) {
        final UntypedBaseDataDescription description = DefinitionsFactory.eINSTANCE.createUntypedBaseDataDescription();
        description.setName(name);
        description.setRepresentation(RepresentationType.REAL);

        return description;
    }

    private static TypeDefinitionReference reference(final DataDescription description) {
        final TypeDefinitionReference reference = ExpressionsFactory.eINSTANCE.createTypeDefinitionReference();
        reference.setDefinition(description);

        return reference;
    }

    private static MinimiseGoal goal(final DataDescription description) {
        final MinimiseGoal goal = OLFactory.eINSTANCE.createMinimiseGoal();
        final TypeDefinitionReference reference = reference(description);
        goal.setData(reference);

        return goal;
    }

    private static List<String> featureNames(final EClass eClass) {
        return eClass.getEStructuralFeatures()
                     .stream()
                     .map(ENamedElement::getName)
                     .toList();
    }

    @Nested
    @DisplayName("given a data description module with many descriptions")
    class DataDescriptionModuleWithManyDescriptions {
        private final List<String> declaredNames = declaredNames("x:");

        private final DataDescriptionModule module = DdlFactory.eINSTANCE.createDataDescriptionModule();

        @Test
        public void featuresFollowTheDeclarationOrder() {
            // given
            final List<DataDescription> descriptions = descriptions(declaredNames);
            module.getDescriptions().addAll(descriptions);

            // when
            final EClass eClass = provider.eClassFor(module);

            // then
            final List<String> featureNames = featureNames(eClass);
            Assertions.assertEquals(declaredNames, featureNames);
        }
    }

    @Nested
    @DisplayName("given an optimisation problem with many search and optimisation variables")
    class ProblemWithManyVariables {
        private final List<String> searchNames = declaredNames("x:");

        private final List<String> goalNames = declaredNames("y:");

        private final ProblemInstance problem = OLFactory.eINSTANCE.createProblemInstance();

        @Test
        public void searchSpaceFeaturesFollowTheDeclarationOrder() {
            // given
            final List<DataDescription> descriptions = descriptions(searchNames);
            final List<TypeDefinitionReference> references = descriptions.stream()
                                                                         .map(EClassProviderTest::reference)
                                                                         .toList();
            problem.getSearchSpace().addAll(references);

            // when
            final Pair<EClass, EClass> spaces = provider.eClassFor(problem);

            // then
            final List<String> featureNames = featureNames(spaces.getFirst());
            Assertions.assertEquals(searchNames, featureNames);
        }

        @Test
        public void optimisationSpaceFeaturesFollowTheDeclarationOrder() {
            // given
            final List<DataDescription> descriptions = descriptions(goalNames);
            final List<MinimiseGoal> goals = descriptions.stream()
                                                         .map(EClassProviderTest::goal)
                                                         .toList();
            problem.getOptimisationSpace().addAll(goals);

            // when
            final Pair<EClass, EClass> spaces = provider.eClassFor(problem);

            // then
            final List<String> featureNames = featureNames(spaces.getSecond());
            Assertions.assertEquals(goalNames, featureNames);
        }
    }
}
