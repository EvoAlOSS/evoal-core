import "definitions" from 'de.evoal.core.constraints';

module surrogate {
	data:
		/**
		 * Index of a grid point; the generator computes x:0 from it.
		 */
		quotient real data 'k';

		/**
		 * Input of the surrogate: a temperature in kelvin.
		 */
		@LowerBoundary{ boundary := 250.0; 'inclusive' := true; }
		@UpperBoundary{ boundary := 350.0; 'inclusive' := true; }
		quotient real data 'x:0';

		/**
		 * Output of the surrogate: a quantity of about 20000 that depends on the temperature.
		 */
		quotient real data 'y:0';
}
