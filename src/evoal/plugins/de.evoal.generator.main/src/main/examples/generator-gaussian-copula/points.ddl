/**
 * A normal and a log-normal variable.
 */
module points {
	data:
		/**
		 * Standard normal.
		 */
		quotient real data 'x';

		/**
		 * Log-normal with μ = 0 and σ = 0.5 (of ln y).
		 */
		quotient real data 'y';
}
