import "definitions" from 'de.evoal.core.constraints';

/**
 * Search space of the topology example: the Rastrigin function in two variables.
 *   It has a local minimum at every integer point and its global minimum 0 at (0, 0).
 */
module search {
	data:
		/**
		 * First variable of the search space.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:0';

		/**
		 * Second variable of the search space.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:1';

		/**
		 * Value of the benchmark function, minimised by the search.
		 */
		quotient real data 'y:0';
}
