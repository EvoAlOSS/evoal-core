import "definitions" from 'de.evoal.core.constraints';

module surrogate {
	data:
		/**
		 * Index of a grid point of the prediction; the generator computes x:0 from it.
		 */
		quotient real data 'k';

		/**
		 * Input of the model.
		 */
		@LowerBoundary{ boundary := 0.0; 'inclusive' := true; }
		@UpperBoundary{ boundary := 1.0; 'inclusive' := true; }
		quotient real data 'x:0';

		/**
		 * Output of the model: the Forrester function of x:0 with noise.
		 */
		quotient real data 'y:0';
}
