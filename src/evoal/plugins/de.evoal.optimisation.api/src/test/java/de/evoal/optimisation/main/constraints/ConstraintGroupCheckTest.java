package de.evoal.optimisation.main.constraints;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.evoal.optimisation.api.constraints.Constraints;
import de.evoal.optimisation.api.constraints.TestConstraints;

/**
 * The {@link ConstraintGroupCheck}: the groups an algorithm configuration names and their
 *   check against the groups of the DDL.
 */
public class ConstraintGroupCheckTest {
    private static final EcoreFactory ECORE = EcoreFactory.eINSTANCE;

    /**
     * A handling type with a {@code group} attribute.
     */
    private final EClass handling = ECORE.createEClass();

    /**
     * An algorithm type with a single and a list reference to handlings, both not containment
     *   (like the configurations of EvoAl).
     */
    private final EClass algorithm = ECORE.createEClass();

    private final EReference single = ECORE.createEReference();

    private final EReference list = ECORE.createEReference();

    {
        final EAttribute group = ECORE.createEAttribute();
        group.setName("group");
        group.setEType(EcorePackage.Literals.ESTRING);
        handling.setName("handling");
        handling.getEStructuralFeatures().add(group);

        single.setName("comparator");
        single.setEType(handling);
        list.setName("fitness-pipeline");
        list.setEType(handling);
        list.setUpperBound(-1);
        algorithm.setName("algorithm");
        algorithm.getEStructuralFeatures().addAll(List.of(single, list));

        final EPackage ePackage = ECORE.createEPackage();
        ePackage.getEClassifiers().addAll(List.of(handling, algorithm));
    }

    private EObject handlingOf(final String group) {
        final EObject instance = EcoreUtil.create(handling);
        instance.eSet(handling.getEStructuralFeature("group"), group);

        return instance;
    }

    @Nested
    @DisplayName("given an algorithm with handlings of the groups 'a', 'b' and 'a'")
    class Handlings {
        @Test
        @SuppressWarnings("unchecked")
        public void theGroupsOfAllHandlingsAreCollectedOnce() {
            // given
            final EObject configuration = EcoreUtil.create(algorithm);
            configuration.eSet(single, handlingOf("a"));
            ((List<EObject>) configuration.eGet(list)).addAll(List.of(handlingOf("b"), handlingOf("a")));

            // when
            final Set<String> groups = ConstraintGroupCheck.handledGroups(configuration);

            // then
            Assertions.assertEquals(List.of("a", "b"), List.copyOf(groups));
        }
    }

    @Nested
    @DisplayName("given the DDL groups 'strict' and 'vague'")
    class Groups {
        private final Constraints constraints = TestConstraints.constraints("strict", "vague");

        @Test
        public void anUndeclaredGroupIsRejected() {
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> ConstraintGroupCheck.check(constraints, Set.of("strict", "typo")));
        }

        @Test
        public void anUnhandledGroupIsOnlyAWarning() {
            Assertions.assertDoesNotThrow(() -> ConstraintGroupCheck.check(constraints, Set.of("strict")));
        }

        @Test
        public void handlingAllGroupsIsAccepted() {
            Assertions.assertDoesNotThrow(() -> ConstraintGroupCheck.check(constraints, Set.of("strict", "vague")));
        }
    }
}
