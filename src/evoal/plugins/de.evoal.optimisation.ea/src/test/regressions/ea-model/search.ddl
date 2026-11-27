import "definitions" from 'de.evoal.core.constraints';
import "definitions" from 'policies';

module search {
    data:
        /**
         * A policy of the 2048 example.
         */
        data 'policy' of instance policy;

        /**
         * A weight that the fitness does not read.
         */
        @LowerBoundary { boundary := 0.0; inclusive := true; }
        @UpperBoundary { boundary := 1.0; inclusive := true; }
        quotient real data 'weight';

        /**
         * The number of objects of the policy.
         */
        quotient integer data 'size';
}
