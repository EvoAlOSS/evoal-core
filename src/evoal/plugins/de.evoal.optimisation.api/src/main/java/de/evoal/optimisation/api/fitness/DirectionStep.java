package de.evoal.optimisation.api.fitness;

/**
 * The first step of every {@link FitnessPipeline}: converts the objectives into the
 *   canonical direction (minimisation), one component per goal.
 * <ul>
 *   <li>minimise: {@code v}</li>
 *   <li>maximise: {@code -v}</li>
 *   <li>target {@code t}: the goal's distance of {@code v} from {@code t}</li>
 * </ul>
 * The steps after it see canonical values only and do not need to know the goals'
 *   directions.
 */
public final class DirectionStep implements FitnessStep {
    @Override
    public Fitness apply(final FitnessContext context, final Fitness current) {
        final Goals goals = context.goals();
        final double[] values = new double[goals.size()];

        for(int index = 0; index < values.length; ++index) {
            final Goal goal = goals.get(index);
            final double value = current.value(index);

            values[index] = toCanonical(goal, value);
        }

        return new Fitness(current.layout(), values);
    }

    /**
     * Converts a canonical value of a {@code minimise} or {@code maximise} goal back into the
     *   value of its objective. A target goal cannot be converted back, since its distance
     *   does not tell on which side of the target the value lies.
     *
     * @param goal The goal of the component.
     * @param canonical The canonical value.
     * @return The value of the objective.
     * @throws IllegalArgumentException if the goal is a target goal.
     */
    public static double toObjective(final Goal goal, final double canonical) {
        return switch(goal) {
            case Goal.Minimise minimise -> canonical;
            case Goal.Maximise maximise -> 0.0 - canonical;
            case Goal.Target target -> throw new IllegalArgumentException("The canonical value of the target goal for '"
                                                                          + target.name()
                                                                          + "' cannot be converted back into its objective.");
        };
    }

    /**
     * @param goal The goal of the component.
     * @param value The value of the objective.
     * @return The canonical value.
     */
    public static double toCanonical(final Goal goal, final double value) {
        return switch(goal) {
            case Goal.Minimise minimise -> value;
            // 0.0 - v instead of -v, so that a value of 0 does not become -0.0, which
            //   Double.compare orders before 0.0
            case Goal.Maximise maximise -> 0.0 - value;
            case Goal.Target target -> target.distanceOf(value);
        };
    }
}
