package de.evoal.optimisation.api.execution;

/**
 * The position of a run in the evaluation setup ({@code heuristic-search-evaluation}), which
 *   repeats the search several times, optionally for each point of a target file.
 *
 * @param repetition The index of the repetition for the current target, starting at 0.
 * @param numberOfRepetitions The number of repetitions per target.
 * @param target The index of the target point, starting at 0. Only meaningful if
 *   {@link #hasTarget()}.
 * @param numberOfTargets The number of target points, 0 if no target file is used.
 */
public record EvaluationPosition(int repetition, int numberOfRepetitions, int target, int numberOfTargets) {
    /**
     * @return The position of a run without target points.
     */
    public static EvaluationPosition withoutTarget(final int repetition, final int numberOfRepetitions) {
        return new EvaluationPosition(repetition, numberOfRepetitions, 0, 0);
    }

    /**
     * @return The position of a run for a target point.
     */
    public static EvaluationPosition withTarget(final int repetition,
                                                final int numberOfRepetitions,
                                                final int target,
                                                final int numberOfTargets) {
        return new EvaluationPosition(repetition, numberOfRepetitions, target, numberOfTargets);
    }

    /**
     * @return {@code true} if the run belongs to a point of a target file.
     */
    public boolean hasTarget() {
        return numberOfTargets > 0;
    }

    /**
     * @return The index, padded with zeros to the number of digits of the largest index
     *   ({@code count - 1}).
     */
    private static String padded(final int index, final int count) {
        final int largestIndex = Math.max(count - 1, 0);
        final int width = Integer.toString(largestIndex).length();

        return String.format("%0" + width + "d", index);
    }

    /**
     * @return The relative folder of the run's output, e.g. {@code repetition-07} or
     *   {@code target-2/repetition-07}. The numbers are padded with zeros to the width of the
     *   largest index, so the folders sort in order.
     */
    public String relativeFolder() {
        final String repetitionFolder = "repetition-" + padded(repetition, numberOfRepetitions);
        if(!hasTarget()) {
            return repetitionFolder;
        }

        return "target-" + padded(target, numberOfTargets) + "/" + repetitionFolder;
    }
}
