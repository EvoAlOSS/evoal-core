import "definitions" from 'de.evoal.core.constraints';

module surrogate {
	data:
		/**
		 * Source dimension of the training data.
		 */
		@LowerBoundary { 'boundary' := -5.0; inclusive := true; }
		@UpperBoundary { 'boundary' :=  5.0; inclusive := true; }
		quotient real data 'x:0';
		
		
		/**
		 * Target dimension of the training data.
		 */
		quotient real data 'y:0';
}