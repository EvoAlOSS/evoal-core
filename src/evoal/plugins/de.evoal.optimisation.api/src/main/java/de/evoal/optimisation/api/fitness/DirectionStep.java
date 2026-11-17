package de.evoal.optimisation.api.fitness;

/**
 * The first step of every {@link FitnessPipeline}: converts the objectives into the
 *   canonical direction (minimisation), one component per goal.
 * <ul>
 *   <li>minimise: {@code v}</li>
 *   <li>maximise: {@code -v}</li>
 *   <li>target {@code t}: {@code abs(v - t)}</li>
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
     * @param goal The goal of the component.
     * @param value The value of the objective.
     * @return The canonical value.
     */
    static double toCanonical(final Goal goal, final double value) {
        return switch(goal) {
            case Goal.Minimise minimise -> value;
            // 0.0 - v instead of -v, so that a value of 0 does not become -0.0, which
            //   Double.compare orders before 0.0
            case Goal.Maximise maximise -> 0.0 - value;
            case Goal.Target target -> Math.abs(value - target.target());
        };
    }
}
