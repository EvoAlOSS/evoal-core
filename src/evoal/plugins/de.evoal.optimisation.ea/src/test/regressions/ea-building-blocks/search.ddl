import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the regression ea-building-blocks: Rastrigin in six real dimensions with
 *   two building blocks that overlap in x:2, and a third building block.
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
         * Third dimension of the search space.
         */
        @LowerBoundary { boundary := -5.12; inclusive := true; }
        @UpperBoundary { boundary := 5.12; inclusive := true; }
        quotient real data 'x:2';

        /**
         * Fourth dimension of the search space.
         */
        @LowerBoundary { boundary := -5.12; inclusive := true; }
        @UpperBoundary { boundary := 5.12; inclusive := true; }
        quotient real data 'x:3';

        /**
         * Fifth dimension of the search space.
         */
        @LowerBoundary { boundary := -5.12; inclusive := true; }
        @UpperBoundary { boundary := 5.12; inclusive := true; }
        quotient real data 'x:4';

        /**
         * Sixth dimension of the search space.
         */
        @LowerBoundary { boundary := -5.12; inclusive := true; }
        @UpperBoundary { boundary := 5.12; inclusive := true; }
        quotient real data 'x:5';

        /**
         * Value of the benchmark function.
         */
        quotient real data 'y:0';

    constraints:
        'building-block'([data 'x:0', data 'x:2', data 'x:4']);
        'building-block'([data 'x:2', data 'x:5']);
        'building-block'([data 'x:1', data 'x:3']);
}
