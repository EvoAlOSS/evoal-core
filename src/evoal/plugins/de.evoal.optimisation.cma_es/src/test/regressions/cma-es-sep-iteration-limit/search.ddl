import "definitions" from 'de.evoal.core.constraints';

/**
 * Search space of the regression cma-es-sep-iteration-limit: the weighted sphere in four real
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
}
