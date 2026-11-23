import "definitions" from 'de.evoal.core.constraints';
import "definitions" from 'de.evoal.optimisation.constraint';

/**
 * Data with constraints for the tests of 'constraint-validation'.
 */
module 'de.evoal.pipeline.test.constrained' {
    data:
        /**
         * At most 1.
         */
        @UpperBoundary { boundary := 1.0; }
        quotient real data 'a';

        quotient real data 'b';

        quotient real data 'c';

        /**
         * At least 0, as a warning.
         */
        @LowerBoundary { boundary := 0.0; severity := Severity.warning; }
        quotient real data 'd';

    constraints:
        constraint(data 'a' + data 'b' < 1.5, "sum");
}
