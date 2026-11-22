import "definitions" from 'de.evoal.core.constraints';

module surrogate {
    data:
        /**
         * Input of the surrogate.
         */
        @LowerBoundary{ boundary := 0.0; 'inclusive' := true; }
        @UpperBoundary{ boundary := 1.0; 'inclusive' := true; }
        quotient real data 'x:0';

        /**
         * Prediction of the surrogate (trained on the Forrester function).
         */
        quotient real data 'y:0';
}
