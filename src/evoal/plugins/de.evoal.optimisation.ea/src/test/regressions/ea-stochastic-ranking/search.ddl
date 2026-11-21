import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the regression ea-stochastic-ranking: Rosenbrock in two dimensions, whose
 *   unconstrained minimum (1, 1) lies outside the group 'region' (a disc and a half-plane).
 */
module search {
    data:
        /**
         * First dimension of the search space.
         */
        @LowerBoundary { boundary := -2.0; inclusive := true; }
        @UpperBoundary { boundary := 2.0; inclusive := true; }
        quotient real data 'x:0';

        /**
         * Second dimension of the search space.
         */
        @LowerBoundary { boundary := -2.0; inclusive := true; }
        @UpperBoundary { boundary := 2.0; inclusive := true; }
        quotient real data 'x:1';

        /**
         * Value of the benchmark function.
         */
        quotient real data 'y:0';

    constraints:
        constraint(data 'x:0' * data 'x:0' + data 'x:1' * data 'x:1' <= 1.5, "region");
        constraint(data 'x:0' >= 0.2, "region");
}
