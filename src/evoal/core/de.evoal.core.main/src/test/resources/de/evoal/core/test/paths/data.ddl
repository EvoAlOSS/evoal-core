import "definitions" from 'de.evoal.core.constraints';

/**
 * Data of the tests of path expressions.
 */
module 'de.evoal.core.test.paths.data' {
    data:
        /**
         * A search variable.
         */
        quotient real data 'x';

        /**
         * Another search variable.
         */
        quotient real data 'y';

        /**
         * The objective.
         */
        quotient real data 'z';

        /**
         * Bounded on both sides.
         */
        @LowerBoundary { boundary := 0.0; }
        @UpperBoundary { boundary := 1.0; }
        quotient real data 'bounded';

        /**
         * Bounded only from below.
         */
        @LowerBoundary { boundary := 0.0; }
        quotient real data 'positive';

        /**
         * A category.
         */
        nominal integer data 'colour';
}