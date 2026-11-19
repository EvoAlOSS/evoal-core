import "definitions" from 'de.evoal.core.constraints';

/**
 * Search space of the example ea-basic: the Rastrigin function in five variables. It has a
 *   local minimum at every integer point and its global minimum 0 at the origin.
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
		 * Third variable of the search space.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:2';

		/**
		 * Fourth variable of the search space.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:3';

		/**
		 * Fifth variable of the search space.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:4';

		/**
		 * Value of the benchmark function, minimised by the search.
		 */
		quotient real data 'y:0';
}
