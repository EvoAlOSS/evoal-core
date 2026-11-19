package de.evoal.optimisation.main.checks;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.checks.CheckReaction;
import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.ConstraintEvaluation;
import de.evoal.optimisation.api.constraints.ConstraintKind;
import de.evoal.optimisation.api.constraints.Constraints;
import de.evoal.optimisation.api.constraints.LinearForm;
import de.evoal.optimisation.api.constraints.ViolationRecord;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.main.constraints.ExactMeasure;
import de.evoal.optimisation.main.constraints.ProjectionRepair;
import de.evoal.optimisation.main.constraints.SaturationRepair;

/**
 * The {@link ConstraintCheck}: its configuration checks, the test and the degrees it keeps.
 */
public class ConstraintCheckTest {
    private final Space space = space();

    private final EStructuralFeature x = space.getEClass().getEStructuralFeature("x");

    private final EStructuralFeature y = space.getEClass().getEStructuralFeature("y");

    private final ConstraintEvaluation evaluation = new ConstraintEvaluation();

    /**
     * 1 (box): x >= 1; 2 (sum): x + y >= 2; 3 (objective): reads an objective; 4 (box): x <= 3.
     */
    private final Constraints constraints = new Constraints(List.of(
            linear(1, "box", Map.of(x, 1.0), -1.0),
            linear(2, "sum", new java.util.LinkedHashMap<>(Map.of(x, 1.0, y, 1.0)), -2.0),
            new Constraint(3, "objective", "f >= 0", ConstraintKind.INEQUALITY, false, List.of(), List.of(y), Map.of(),
                           values -> values.valueOf(y), null),
            linear(4, "box", Map.of(x, -1.0), 3.0)));

    private static Space space() {
        final EClass eClass = EcoreFactory.eINSTANCE.createEClass();

        for(final String name : List.of("x", "y")) {
            final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
            feature.setName(name);
            feature.setEType(EcorePackage.Literals.EDOUBLE);
            eClass.getEStructuralFeatures().add(feature);
        }

        EcoreFactory.eINSTANCE.createEPackage().getEClassifiers().add(eClass);

        return new Space(eClass);
    }

    private static Constraint linear(final int number, final String group, final Map<EStructuralFeature, Double> coefficients,
                                     final double constant) {
        return new Constraint(number, group, "c" + number, ConstraintKind.INEQUALITY, false,
                              List.copyOf(coefficients.keySet()), List.of(), Map.of(), values -> {
                                  double sum = constant;
                                  for(final Map.Entry<EStructuralFeature, Double> term : coefficients.entrySet()) {
                                      sum += term.getValue() * values.valueOf(term.getKey());
                                  }
                                  return sum;
                              }, new LinearForm(coefficients, constant));
    }

    private Candidate candidate(final double valueOfX, final double valueOfY) {
        final TypedEObject input = space.newEObject();
        input.eSet(x, valueOfX);
        input.eSet(y, valueOfY);

        return new Candidate(input, Lineage.NONE);
    }

    @BeforeEach
    public void measureExactly() {
        evaluation.setUp(constraints, new ExactMeasure(1.0e-4));
    }

    @Test
    public void aCandidateThatSatisfiesTheGroupPasses() throws InitializationException {
        final ConstraintCheck check = new ConstraintCheck("box", CheckReaction.WARN, 10, evaluation, null, CheckReaction.WARN);

        Assertions.assertEquals(Optional.empty(), check.test(candidate(2.0, 0.0)));
    }

    @Test
    public void aViolatingCandidateFailsWithTheViolationOfTheGroup() throws InitializationException {
        final ConstraintCheck check = new ConstraintCheck("box", CheckReaction.WARN, 10, evaluation, null, CheckReaction.WARN);

        Assertions.assertEquals(Optional.of("violation 0.5 of the group 'box' (constraints 1)"),
                                check.test(candidate(0.5, 0.0)));
        Assertions.assertEquals(Optional.of("violation 1.0 of the group 'box' (constraints 4)"),
                                check.test(candidate(4.0, 0.0)));
    }

    @Test
    public void theDegreesAreKeptAndNotMeasuredAgainInTheEvaluation() throws InitializationException {
        // given
        final ConstraintCheck check = new ConstraintCheck("box", CheckReaction.WARN, 10, evaluation, null, CheckReaction.WARN);
        final Candidate candidate = candidate(0.5, 0.0);

        // when
        check.test(candidate);
        final long afterCheck = evaluation.numberOfEvaluations();
        final ViolationRecord record = evaluation.measure(candidate.input(), space.newEObject(), candidate.measuredViolations());

        // then: the check measured 2 constraints, the evaluation the other 2
        Assertions.assertEquals(2, afterCheck);
        Assertions.assertEquals(4, evaluation.numberOfEvaluations());
        Assertions.assertEquals(0.5, record.degree(constraints.get(1)));
        Assertions.assertEquals(1.5, record.degree(constraints.get(2)));
        Assertions.assertEquals(0.0, record.degree(constraints.get(4)));
    }

    @Test
    public void theRepairOfTheCheckRepairsTheGroup() throws InitializationException {
        // given
        final ConstraintCheck check = new ConstraintCheck("sum", CheckReaction.REPAIR, 10, evaluation, new ProjectionRepair(),
                                                          CheckReaction.WARN);

        // when
        final TypedEObject repaired = check.repair().orElseThrow().attempt().apply(candidate(0.0, 0.0).input());

        // then
        Assertions.assertEquals("projection-repair", check.repair().orElseThrow().name());
        Assertions.assertEquals(1.0, repaired.eGet(x));
        Assertions.assertEquals(1.0, repaired.eGet(y));
    }

    @Test
    public void anUndeclaredGroupIsRejected() {
        Assertions.assertThrows(InitializationException.class,
                                () -> new ConstraintCheck("unknown", CheckReaction.WARN, 10, evaluation, null, CheckReaction.WARN));
    }

    @Test
    public void aGroupWithConstraintsOnObjectivesIsRejected() {
        Assertions.assertThrows(InitializationException.class,
                                () -> new ConstraintCheck("objective", CheckReaction.WARN, 10, evaluation, null, CheckReaction.WARN));
    }

    @Test
    public void theReactionRepairAndTheRepairBelongTogether() {
        Assertions.assertThrows(InitializationException.class,
                                () -> new ConstraintCheck("box", CheckReaction.REPAIR, 10, evaluation, null, CheckReaction.WARN));
        Assertions.assertThrows(InitializationException.class,
                                () -> new ConstraintCheck("box", CheckReaction.WARN, 10, evaluation, new SaturationRepair(),
                                                          CheckReaction.WARN));
    }

    @Test
    public void theFallbackCannotBeRepair() {
        Assertions.assertThrows(InitializationException.class,
                                () -> new ConstraintCheck("box", CheckReaction.REPAIR, 10, evaluation, new SaturationRepair(),
                                                          CheckReaction.REPAIR));
    }

    @Test
    public void aRepairThatCannotHandleAConstraintOfTheGroupIsRejected() {
        Assertions.assertThrows(InitializationException.class,
                                () -> new ConstraintCheck("sum", CheckReaction.REPAIR, 10, evaluation, new SaturationRepair(),
                                                          CheckReaction.WARN));
        Assertions.assertDoesNotThrow(() -> new ConstraintCheck("box", CheckReaction.REPAIR, 10, evaluation,
                                                                new SaturationRepair(), CheckReaction.WARN));
    }
}
