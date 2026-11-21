import "definitions" from 'de.evoal.core.constraints';

/**
 * Search space of the regression cma-es-maximum-iterations: the weighted sphere in two real
 *   dimensions.
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
         * Value of the benchmark function.
         */
        quotient real data 'y:0';
}
