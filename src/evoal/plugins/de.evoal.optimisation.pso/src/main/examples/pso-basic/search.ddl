import "definitions" from 'de.evoal.core.constraints';

/**
 * Search space of the PSO examples with the Ackley function in two variables.
 *   Its global minimum 0 is at (0, 0).
 */
module search {
	data:
		/**
		 * First variable of the search space.
		 */
		@LowerBoundary { boundary := -32.768; inclusive := true; }
		@UpperBoundary { boundary := 32.768; inclusive := true; }
		quotient real data 'x:0';

		/**
		 * Second variable of the search space.
		 */
		@LowerBoundary { boundary := -32.768; inclusive := true; }
		@UpperBoundary { boundary := 32.768; inclusive := true; }
		quotient real data 'x:1';

		/**
		 * Value of the benchmark function, minimised by the search.
		 */
		quotient real data 'y:0';
}
