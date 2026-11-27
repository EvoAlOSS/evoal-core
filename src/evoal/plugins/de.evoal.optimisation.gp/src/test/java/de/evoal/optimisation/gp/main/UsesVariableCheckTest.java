package de.evoal.optimisation.gp.main;

import java.util.EnumSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.checks.CheckPoint;
import de.evoal.optimisation.api.checks.CheckReaction;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;

import de.evoal.optimisation.gp.Expressions;

/**
 * {@code 'uses-variable'} on expressions of the terminals x0, x1 and c.
 */
public class UsesVariableCheckTest {
    private final Expressions expressions = new Expressions("de/evoal/optimisation/gp/test/terms.dl");

    private final EReference function = EcoreFactory.eINSTANCE.createEReference();

    private final Space space;

    public UsesVariableCheckTest() {
        final EClass search = EcoreFactory.eINSTANCE.createEClass();
        function.setName("f");
        function.setContainment(true);
        function.setEType(expressions.library("expression"));
        search.getEStructuralFeatures().add(function);
        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(search);
        space = new Space(search);
    }

    private Candidate candidate(final EObject root) {
        final TypedEObject input = space.newEObject();
        input.eSet(function, root);

        return new Candidate(input, Lineage.NONE);
    }

    @Test
    public void aConstantExpressionFails() {
        // given
        final UsesVariableCheck check = new UsesVariableCheck(CheckReaction.RESAMPLE, function, 1);
        final EObject constant = expressions.function("plus", expressions.constant("c", 1.0), expressions.constant("c", 2.0));

        // then
        Assertions.assertEquals("the expression 'f' uses 0 different variables, at least 1 are required",
                                check.test(candidate(constant)).orElseThrow());
    }

    @Test
    public void theVariableTypesAreCountedOnce() {
        // given
        final UsesVariableCheck one = new UsesVariableCheck(CheckReaction.WARN, function, 1);
        final UsesVariableCheck two = new UsesVariableCheck(CheckReaction.WARN, function, 2);
        final EObject square = expressions.function("multiply", expressions.variable("x0"), expressions.variable("x0"));
        final EObject sum = expressions.function("plus", expressions.variable("x0"), expressions.variable("x1"));

        // then
        Assertions.assertTrue(one.test(candidate(square)).isEmpty());
        Assertions.assertEquals("the expression 'f' uses 1 different variables, at least 2 are required",
                                two.test(candidate(square)).orElseThrow());
        Assertions.assertTrue(two.test(candidate(sum)).isEmpty());
        Assertions.assertTrue(one.test(candidate(expressions.variable("x1"))).isEmpty(), "the root counts");
    }

    @Test
    public void theCheckTestsNewCandidatesWithoutRepair() {
        // given
        final UsesVariableCheck check = new UsesVariableCheck(CheckReaction.WARN, function, 1);

        // then
        Assertions.assertEquals(CheckPoint.NEW_CANDIDATES, check.checkPoint());
        Assertions.assertEquals(EnumSet.of(CheckReaction.WARN, CheckReaction.REPLACE, CheckReaction.RESAMPLE),
                                check.supportedReactions());
        Assertions.assertTrue(check.repair().isEmpty());
    }
}
