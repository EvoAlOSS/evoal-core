import "definitions" from 'de.evoal.core.constraints';

module surrogate {
	data:
		/**
		 * Index of a grid point; the generator computes x:0 from it.
		 */
		quotient real data 'k';

		/**
		 * Input of the Gaussian process.
		 */
		@LowerBoundary{ boundary := 0.0; 'inclusive' := true; }
		@UpperBoundary{ boundary := 1.0; 'inclusive' := true; }
		quotient real data 'x:0';

		/**
		 * Output of the Gaussian process: the Forrester function of x:0.
		 */
		quotient real data 'y:0';
}
