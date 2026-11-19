import "definitions" from 'de.evoal.core.constraints';

module surrogate {
	data:
		/**
		 * Source dimension of the training data.
		 */
    @LowerBoundary { 'boundary' := -5.0; inclusive := true; }
    @UpperBoundary { 'boundary' :=  5.0; inclusive := true; }
	quotient real data 'x0';

    @LowerBoundary { 'boundary' := -5.0; inclusive := true; }
	@UpperBoundary { 'boundary' :=  5.0; inclusive := true; }
	quotient real data 'x1';

    @LowerBoundary { 'boundary' := -5.0; inclusive := true; }
	@UpperBoundary { 'boundary' :=  5.0; inclusive := true; }
	quotient real data 'x2';
		
		
		/**
		 * Target dimension of the training data.
		 */
		quotient real data 'y0';
        quotient real data 'y1';
        quotient real data 'y2';
}
