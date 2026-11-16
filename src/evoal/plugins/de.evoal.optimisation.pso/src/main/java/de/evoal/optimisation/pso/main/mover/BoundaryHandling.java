package de.evoal.optimisation.pso.main.mover;

import de.evoal.optimisation.pso.api.BoundaryType;

/**
 * Keeps a moved coordinate of a particle within the boundaries of its variable. The
 *   movers limit the velocity to the range of the variable, so a single reflection or
 *   wrap brings the position back into the boundaries.
 * <ul>
 *   <li>{@code BOUNCE}: the position is reflected at the boundary and the velocity
 *     component is negated, so the particle moves away from the boundary.</li>
 *   <li>{@code STICK}: the position is set to the boundary and the velocity component
 *     to 0, so the particle does not keep pushing against the boundary.</li>
 *   <li>{@code WRAP}: the position enters the range from the other side (periodic
 *     boundaries); the velocity component is kept.</li>
 * </ul>
 */
final class BoundaryHandling {
    /**
     * A coordinate of a particle after its move.
     *
     * @param position The position within the boundaries.
     * @param velocity The velocity that continues the move.
     */
    record Moved(double position, double velocity) {
    }

    private BoundaryHandling() {
    }

    /**
     * @param type How the boundaries are handled.
     * @param position The position after the move, possibly outside of the boundaries.
     * @param velocity The velocity of the move.
     * @param minimum The lower boundary of the variable.
     * @param maximum The upper boundary of the variable.
     * @return The position within the boundaries and the velocity.
     */
    static Moved apply(final BoundaryType type, final double position, final double velocity, final double minimum, final double maximum) {
        final double range = maximum - minimum;

        if(position > maximum) {
            return switch(type) {
                case BOUNCE -> new Moved(2. * maximum - position, -velocity);
                case STICK  -> new Moved(maximum, 0.);
                case WRAP   -> new Moved(position - range, velocity);
            };
        } else if(position < minimum) {
            return switch(type) {
                case BOUNCE -> new Moved(2. * minimum - position, -velocity);
                case STICK  -> new Moved(minimum, 0.);
                case WRAP   -> new Moved(position + range, velocity);
            };
        }

        return new Moved(position, velocity);
    }
}
