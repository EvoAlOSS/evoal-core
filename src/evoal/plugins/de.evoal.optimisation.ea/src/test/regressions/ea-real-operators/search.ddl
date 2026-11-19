import "definitions" from 'de.evoal.core.constraints';

module search {
    data:
        /**
         * A real dimension of the benchmark.
         */
        @LowerBoundary { boundary := -5.12; inclusive := true; }
        @UpperBoundary { boundary := 5.12; inclusive := true; }
        quotient real data 'x:0';

        /**
         * A second real dimension of the benchmark.
         */
        @LowerBoundary { boundary := -5.12; inclusive := true; }
        @UpperBoundary { boundary := 5.12; inclusive := true; }
        quotient real data 'x:1';

        /**
         * An integer dimension of the benchmark.
         */
        @LowerBoundary { boundary := -5; inclusive := true; }
        @UpperBoundary { boundary := 5; inclusive := true; }
        quotient integer data 'n:0';

        /**
         * Value of the benchmark function.
         */
        quotient real data 'y:0';
}
