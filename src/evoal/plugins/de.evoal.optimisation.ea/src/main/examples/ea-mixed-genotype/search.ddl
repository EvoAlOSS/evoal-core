import "definitions" from 'de.evoal.core.constraints';

/**
 * Search space of the example ea-mixed-genotype: the Rastrigin function of two real and two
 *   integer variables. Its global minimum 0 is at the origin.
 */
module search {
	data:
		/**
		 * First real variable.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:0';

		/**
		 * Second real variable.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:1';

		/**
		 * First integer variable.
		 */
		@LowerBoundary { boundary := -5; inclusive := true; }
		@UpperBoundary { boundary := 5; inclusive := true; }
		quotient integer data 'n:0';

		/**
		 * Second integer variable.
		 */
		@LowerBoundary { boundary := -5; inclusive := true; }
		@UpperBoundary { boundary := 5; inclusive := true; }
		quotient integer data 'n:1';

		/**
		 * Value of the benchmark function, minimised by the search.
		 */
		quotient real data 'y:0';
}
