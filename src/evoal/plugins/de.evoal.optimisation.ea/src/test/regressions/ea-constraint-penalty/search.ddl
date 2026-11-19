import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the regression ea-constraint-penalty: Rastrigin in two dimensions with the
 *   linear constraint x_0 + x_1 >= 1 and a measurement uncertainty of x_0.
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
        constraint(data 'x:0' + data 'x:1' >= 1.0, "budget");
        'standard-deviation'(data 'x:0', 0.05);
}
