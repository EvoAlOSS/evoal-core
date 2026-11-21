import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the regression cma-es-diagonal-ipop-resample: the weighted sphere in four
 *   real dimensions with the linear constraint x_0 + x_1 >= 1 (group "budget").
 */
module search {
    data:
        /**
         * First dimension of the search space.
         */
        @LowerBoundary { boundary := -5.0; inclusive := true; }
        @UpperBoundary { boundary := 5.0; inclusive := true; }
        quotient real data 'x:0';

        /**
         * Second dimension of the search space.
         */
        @LowerBoundary { boundary := -5.0; inclusive := true; }
        @UpperBoundary { boundary := 5.0; inclusive := true; }
        quotient real data 'x:1';

        /**
         * Third dimension of the search space.
         */
        @LowerBoundary { boundary := -5.0; inclusive := true; }
        @UpperBoundary { boundary := 5.0; inclusive := true; }
        quotient real data 'x:2';

        /**
         * Fourth dimension of the search space.
         */
        @LowerBoundary { boundary := -5.0; inclusive := true; }
        @UpperBoundary { boundary := 5.0; inclusive := true; }
        quotient real data 'x:3';

        /**
         * Value of the benchmark function.
         */
        quotient real data 'y:0';

    constraints:
        constraint(data 'x:0' + data 'x:1' >= 1.0, "budget");
}
