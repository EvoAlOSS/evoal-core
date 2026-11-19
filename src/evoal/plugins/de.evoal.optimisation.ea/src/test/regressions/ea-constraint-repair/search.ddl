import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the regression ea-constraint-repair: Rastrigin in three dimensions with the
 *   linear constraint x_0 + x_1 >= 1 (group "budget") and the strict bound k_0 > 2 of an
 *   integer feature (group "box").
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
         * An integer dimension of the search space.
         */
        @LowerBoundary { boundary := -5; inclusive := true; }
        @UpperBoundary { boundary := 5; inclusive := true; }
        quotient integer data 'k:0';

        /**
         * Value of the benchmark function.
         */
        quotient real data 'y:0';

    constraints:
        constraint(data 'x:0' + data 'x:1' >= 1.0, "budget");
        constraint(data 'k:0' > 2, "box");
}
