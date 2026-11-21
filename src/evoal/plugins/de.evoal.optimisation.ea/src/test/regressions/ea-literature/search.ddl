import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the regression ea-literature: Rastrigin in four real dimensions with a
 *   building block and the linear constraint x_0 + x_1 >= 1.
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
         * Value of the benchmark function.
         */
        quotient real data 'y:0';

    constraints:
        'building-block'([data 'x:0', data 'x:2']);
        constraint(data 'x:0' + data 'x:1' >= 1.0, "budget");
}
