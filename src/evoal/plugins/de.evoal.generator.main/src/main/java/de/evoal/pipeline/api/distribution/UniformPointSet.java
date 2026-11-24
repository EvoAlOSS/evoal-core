package de.evoal.pipeline.api.distribution;

/**
 * A set of points in the box [lower, upper) whose coordinates are uniformly distributed
 *   (DL type {@code 'uniform-point-set'}). Each {@link #sample()} returns the next point.
 */
public interface UniformPointSet extends Distribution {
    /**
     * @return The lower bounds (inclusive) of the box, one per dimension (a copy).
     */
    double [] lower();

    /**
     * @return The upper bounds (exclusive) of the box, one per dimension (a copy).
     */
    double [] upper();

    /**
     * @return The dimension of the box.
     */
    @Override
    default int dimension() {
        return lower().length;
    }
}
