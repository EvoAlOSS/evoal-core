package de.evoal.optimisation.api.correlations;

import java.util.List;

/**
 * The correlations of an optimisation problem in the order of the DDL.
 */
public final class Correlations {
    /**
     * A problem without correlations.
     */
    public static final Correlations NONE = new Correlations(List.of());

    /**
     * The correlations in the order of the DDL.
     */
    private final List<Correlation> all;

    /**
     * @param all The correlations in the order of the DDL; their numbers are their positions,
     *   from 1.
     * @throws IllegalArgumentException if a number does not match the position.
     */
    public Correlations(final List<Correlation> all) {
        for(int index = 0; index < all.size(); ++index) {
            final Correlation correlation = all.get(index);

            if(correlation.number() != index + 1) {
                throw new IllegalArgumentException("The " + correlation + " has the number " + correlation.number()
                                                   + " at position " + (index + 1) + ".");
            }
        }

        this.all = List.copyOf(all);
    }

    /**
     * @return The correlations in the order of the DDL.
     */
    public List<Correlation> all() {
        return all;
    }

    /**
     * @return Whether the problem has no correlations.
     */
    public boolean isEmpty() {
        return all.isEmpty();
    }

    /**
     * @param minimum The smallest absolute coefficient, in [0, 1].
     * @return The correlations whose absolute coefficient is at least the minimum, in the order
     *   of the DDL.
     */
    public List<Correlation> atLeast(final double minimum) {
        return all.stream()
                  .filter(correlation -> Math.abs(correlation.coefficient()) >= minimum)
                  .toList();
    }

    /**
     * @return The number of correlations.
     */
    public int size() {
        return all.size();
    }

    @Override
    public String toString() {
        return all.toString();
    }
}
