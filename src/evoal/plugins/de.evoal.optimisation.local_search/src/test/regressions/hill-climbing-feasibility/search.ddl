import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the regression hill-climbing-feasibility: Rosenbrock in two dimensions with
 *   the non-linear constraint x_0^2 + x_1^2 <= 4 (a disc of radius 2).
 */
module search {
    data:
        /**
         * First dimension of the search space.
         */
        @LowerBoundary { boundary := -5.12; inclusive := true; }
        @UpperBoundary { boundary := 5.12; inclusive := true; }
        quotient real data 'x:0';

        /**
         * Second dimension of the search space.
         */
        @LowerBoundary { boundary := -5.12; inclusive := true; }
        @UpperBoundary { boundary := 5.12; inclusive := true; }
        quotient real data 'x:1';

        /**
         * Value of the benchmark function.
         */
        quotient real data 'y:0';

    constraints:
        constraint(data 'x:0' * data 'x:0' + data 'x:1' * data 'x:1' <= 4.0, "disc");
}
