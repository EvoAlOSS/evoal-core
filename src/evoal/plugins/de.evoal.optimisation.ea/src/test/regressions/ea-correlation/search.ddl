import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the regression ea-correlation: Rastrigin in two real and one integer
 *   dimension; x:0 is correlated with x:1 (linear) and with the ordinal k:0 (rank), and
 *   x:1 with k:0 only in a range.
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
        ordinal integer data 'k:0';

        /**
         * Value of the benchmark function.
         */
        quotient real data 'y:0';

    constraints:
        correlation(data 'x:0', data 'x:1', 0.8);
        correlation(data 'x:0', data 'k:0', -0.6);
        'ranged-correlation'(data 'x:1', range(0.0, 5.12), data 'k:0', range(-5.0, 0.0), 0.3);
}
