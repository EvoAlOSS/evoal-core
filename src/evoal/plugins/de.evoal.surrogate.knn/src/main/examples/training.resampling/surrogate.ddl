module surrogate {
	data:
		/**
		 * Index of a grid point; the generator computes x:0 from it.
		 */
		quotient real data 'k';

		/**
		 * Input of the surrogate, between 1 and 11.
		 */
		quotient real data 'x:0';

		/**
		 * Output of the surrogate: y = x (12 - x).
		 */
		quotient real data 'y:0';
}
