import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the regression cma-es-rosenbrock-linkage: Rosenbrock in three real
 *   dimensions with a building block and a correlation.
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
         * Value of the benchmark function.
         */
        quotient real data 'y:0';

    constraints:
        'building-block'([data 'x:0', data 'x:1']);
        correlation(data 'x:1', data 'x:2', 0.5);
}
