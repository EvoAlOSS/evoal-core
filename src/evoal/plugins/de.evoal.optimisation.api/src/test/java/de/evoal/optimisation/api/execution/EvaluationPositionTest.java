package de.evoal.optimisation.api.execution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class EvaluationPositionTest {
    @Nested
    @DisplayName("given an evaluation without target points")
    class WithoutTarget {
        @Test
        public void theFolderIsNamedAfterTheRepetition() {
            // given
            final EvaluationPosition position = EvaluationPosition.withoutTarget(7, 10);

            // when
            final String folder = position.relativeFolder();

            // then
            Assertions.assertEquals("repetition-7", folder);
        }

        @Test
        public void theRepetitionIsPaddedToTheLargestRepetition() {
            // given
            final EvaluationPosition position = EvaluationPosition.withoutTarget(7, 11);

            // when
            final String folder = position.relativeFolder();

            // then
            Assertions.assertEquals("repetition-07", folder);
        }
    }

    @Nested
    @DisplayName("given an evaluation with target points")
    class WithTarget {
        @Test
        public void theRepetitionFolderIsInsideTheTargetFolder() {
            // given
            final EvaluationPosition position = EvaluationPosition.withTarget(3, 100, 2, 12);

            // when
            final String folder = position.relativeFolder();

            // then
            Assertions.assertEquals("target-02/repetition-03", folder);
        }
    }
}
