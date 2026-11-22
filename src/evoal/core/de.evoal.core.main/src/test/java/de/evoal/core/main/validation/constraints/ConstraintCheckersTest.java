package de.evoal.core.main.validation.constraints;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;

/**
 * Tests the checkers of the boundary and element-count annotations on computed values.
 */
public class ConstraintCheckersTest {
    private static void assertSatisfied(final ConstraintCheck result) {
        Assertions.assertInstanceOf(ConstraintCheck.Satisfied.class, result, result.toString());
    }

    private static String assertViolated(final ConstraintCheck result) {
        return Assertions.assertInstanceOf(ConstraintCheck.Violated.class, result, result.toString()).message();
    }

    private static void assertNotCheckable(final ConstraintCheck result) {
        Assertions.assertInstanceOf(ConstraintCheck.NotCheckable.class, result, result.toString());
    }

    @Nested
    class LowerBoundary {
        @Test
        public void anInclusiveBoundAcceptsTheBound() {
            assertSatisfied(new LowerBoundaryChecker(0, true).check(0));
            assertSatisfied(new LowerBoundaryChecker(0.0, true).check(0.0));
        }

        @Test
        public void anExclusiveBoundRejectsTheBound() {
            Assertions.assertEquals("is 0.0, but must be > 0.0", assertViolated(new LowerBoundaryChecker(0.0, false).check(0.0)));
        }

        @Test
        public void smallerValuesAreRejectedAndLargerAccepted() {
            Assertions.assertEquals("is -1, but must be >= 0", assertViolated(new LowerBoundaryChecker(0, true).check(-1)));
            assertSatisfied(new LowerBoundaryChecker(0.0, false).check(1.0E-9));
        }

        @Test
        public void integersAndRealsAreCompared() {
            assertSatisfied(new LowerBoundaryChecker(1, true).check(1.0));
            assertViolated(new LowerBoundaryChecker(1.0, false).check(1));
        }

        @Test
        public void notANumberIsRejected() {
            assertViolated(new LowerBoundaryChecker(0.0, true).check(Double.NaN));
        }
    }

    @Nested
    class UpperBoundary {
        @Test
        public void anInclusiveBoundAcceptsTheBound() {
            assertSatisfied(new UpperBoundaryChecker(1.0, true).check(1.0));
        }

        @Test
        public void anExclusiveBoundRejectsTheBound() {
            Assertions.assertEquals("is 1.0, but must be < 1.0", assertViolated(new UpperBoundaryChecker(1.0, false).check(1.0)));
        }

        @Test
        public void largerValuesAreRejected() {
            Assertions.assertEquals("is 1.3, but must be <= 1.0", assertViolated(new UpperBoundaryChecker(1.0, true).check(1.3)));
        }
    }

    @Nested
    class Arrays {
        @Test
        public void everyElementIsChecked() {
            assertSatisfied(new LowerBoundaryChecker(0.0, true).check(List.of(0.0, 1.0, 2.0)));
            Assertions.assertEquals("has the element [1] = -1.0, but must be >= 0.0",
                                    assertViolated(new LowerBoundaryChecker(0.0, true).check(List.of(0.0, -1.0))));
        }

        @Test
        public void nestedArraysAreChecked() {
            Assertions.assertEquals("has the element [1][0] = 2.0, but must be <= 1.0",
                                    assertViolated(new UpperBoundaryChecker(1.0, true).check(List.of(List.of(0.5), List.of(2.0)))));
        }

        @Test
        public void anEmptyArrayHasNoViolatingElement() {
            assertSatisfied(new LowerBoundaryChecker(0.0, true).check(List.of()));
        }
    }

    @Nested
    class ValuesOfTheRun {
        @Test
        public void aBoundaryCannotCheckADefinition() {
            // e.g. a data reference, which ConstantEvaluator returns as its definition
            assertNotCheckable(new LowerBoundaryChecker(0.0, true).check(DefinitionsFactory.eINSTANCE.createAttributeDefinition()));
        }

        @Test
        public void anElementCountCannotCheckANonArray() {
            assertNotCheckable(new MinimumNumberOfElementsChecker(1).check(DefinitionsFactory.eINSTANCE.createAttributeDefinition()));
        }
    }

    @Nested
    class ElementCounts {
        @Test
        public void aMinimumIsChecked() {
            assertSatisfied(new MinimumNumberOfElementsChecker(1).check(List.of("a")));
            Assertions.assertEquals("has 0 elements, but needs at least 1", assertViolated(new MinimumNumberOfElementsChecker(1).check(List.of())));
        }

        @Test
        public void aMaximumIsChecked() {
            assertSatisfied(new MaximumNumberOfElementsChecker(2).check(List.of(1, 2)));
            Assertions.assertEquals("has 3 elements, but may have at most 2", assertViolated(new MaximumNumberOfElementsChecker(2).check(List.of(1, 2, 3))));
        }
    }
}
