import "definitions" from 'de.evoal.core.constraints';

/**
 * The data of the example surrogate.adaption-validation.
 */
module surrogate {
	data:
		/**
		 * The input of the surrogate.
		 */
		@LowerBoundary { 'boundary' := 0.0; inclusive := true; }
		@UpperBoundary { 'boundary' := 1.0; inclusive := true; }
		quotient real data 'x:0';

		/**
		 * The output of the surrogate.
		 */
		quotient real data 'y:0';
}
