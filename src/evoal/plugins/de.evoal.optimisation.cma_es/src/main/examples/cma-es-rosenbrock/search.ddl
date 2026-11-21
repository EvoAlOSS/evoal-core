import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * The search space of the example cma-es-rosenbrock: the Rosenbrock function of five real
 *   variables in [-5, 5]. The DDL declares linkage that CMA-ES does not use but learns: a
 *   correlation of x:0 and x:1 and a building block of x:2, x:3 and x:4.
 */
module search {
    data:
        /**
         * First variable.
         */
        @LowerBoundary { boundary := -5.0; inclusive := true; }
        @UpperBoundary { boundary := 5.0; inclusive := true; }
        quotient real data 'x:0';

        /**
         * Second variable.
         */
        @LowerBoundary { boundary := -5.0; inclusive := true; }
        @UpperBoundary { boundary := 5.0; inclusive := true; }
        quotient real data 'x:1';

        /**
         * Third variable.
         */
        @LowerBoundary { boundary := -5.0; inclusive := true; }
        @UpperBoundary { boundary := 5.0; inclusive := true; }
        quotient real data 'x:2';

        /**
         * Fourth variable.
         */
        @LowerBoundary { boundary := -5.0; inclusive := true; }
        @UpperBoundary { boundary := 5.0; inclusive := true; }
        quotient real data 'x:3';

        /**
         * Fifth variable.
         */
        @LowerBoundary { boundary := -5.0; inclusive := true; }
        @UpperBoundary { boundary := 5.0; inclusive := true; }
        quotient real data 'x:4';

        /**
         * Value of the Rosenbrock function.
         */
        quotient real data 'y:0';

    constraints:
        correlation(data 'x:0', data 'x:1', 0.5);
        'building-block'([data 'x:2', data 'x:3', data 'x:4']);
}
