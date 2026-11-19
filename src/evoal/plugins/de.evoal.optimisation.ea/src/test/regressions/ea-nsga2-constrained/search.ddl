import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the regression ea-nsga2-constrained: ZDT1 with 5 variables in [0, 1] and
 *   the objective constraint f_1 >= 0.25.
 */
module search {
    data:
        /**
         * Variable x_1 of ZDT1.
         */
        @LowerBoundary { boundary := 0.0; inclusive := true; }
        @UpperBoundary { boundary := 1.0; inclusive := true; }
        quotient real data 'x:0';

        /**
         * Variable x_2 of ZDT1.
         */
        @LowerBoundary { boundary := 0.0; inclusive := true; }
        @UpperBoundary { boundary := 1.0; inclusive := true; }
        quotient real data 'x:1';

        /**
         * Variable x_3 of ZDT1.
         */
        @LowerBoundary { boundary := 0.0; inclusive := true; }
        @UpperBoundary { boundary := 1.0; inclusive := true; }
        quotient real data 'x:2';

        /**
         * Variable x_4 of ZDT1.
         */
        @LowerBoundary { boundary := 0.0; inclusive := true; }
        @UpperBoundary { boundary := 1.0; inclusive := true; }
        quotient real data 'x:3';

        /**
         * Variable x_5 of ZDT1.
         */
        @LowerBoundary { boundary := 0.0; inclusive := true; }
        @UpperBoundary { boundary := 1.0; inclusive := true; }
        quotient real data 'x:4';

        /**
         * First objective of ZDT1, f_1 = x_1, minimised.
         */
        quotient real data 'f:1';

        /**
         * Second objective of ZDT1, f_2 = g * (1 - sqrt(f_1 / g)), minimised.
         */
        quotient real data 'f:2';

    constraints:
        constraint(data 'f:1' >= 0.25, "region");
}
