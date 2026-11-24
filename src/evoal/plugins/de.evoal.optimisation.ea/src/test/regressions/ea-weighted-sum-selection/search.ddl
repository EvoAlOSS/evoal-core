import "definitions" from 'de.evoal.core.constraints';

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
         * Value of the Rosenbrock function.
         */
        quotient real data 'y:0';

        /**
         * Value of the weighted sphere function.
         */
        quotient real data 'y:1';
}
