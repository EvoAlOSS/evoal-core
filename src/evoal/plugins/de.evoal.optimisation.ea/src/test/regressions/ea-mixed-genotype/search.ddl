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
         * An integer dimension of the benchmark.
         */
        @LowerBoundary { boundary := -5; inclusive := true; }
        @UpperBoundary { boundary := 5; inclusive := true; }
        quotient integer data 'n:0';

        /**
         * An integer dimension of the benchmark.
         */
        @LowerBoundary { boundary := 0; inclusive := true; }
        @UpperBoundary { boundary := 10; inclusive := true; }
        quotient integer data 'k:0';

        /**
         * A flag that the benchmark does not read.
         */
        nominal boolean data 'b:0';

        /**
         * Value of the benchmark function.
         */
        quotient real data 'y:0';
}
