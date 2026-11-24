/**
 * Properties of a manufactured part, each drawn from a distribution that suits it.
 */
module parts {
	data:
		/**
		 * Thickness in mm: N(2.0, 0.1²), parts outside [1.85, 2.15] are sorted out.
		 */
		quotient real data 'thickness';

		/**
		 * Cycle time in s: an expert estimate of at least 40, most likely 45, at most 60.
		 */
		quotient real data 'cycle-time';

		/**
		 * Share of usable material: beta(8, 2).
		 */
		quotient real data 'yield';

		/**
		 * Lifetime in h: Weibull with shape 1.5 and scale 1000.
		 */
		quotient real data 'lifetime';

		/**
		 * Surface defects per part: Poisson with mean 2.
		 */
		quotient integer data 'defects';

		/**
		 * Design variant 1, 2 or 3.
		 */
		nominal integer data 'variant';

		/**
		 * Machine load in %: two operating points, 50 % and 80 %.
		 */
		quotient real data 'load';

		/**
		 * Tool failures per shift: Poisson with mean 3, more at a high load.
		 */
		quotient integer data 'failures';
}
