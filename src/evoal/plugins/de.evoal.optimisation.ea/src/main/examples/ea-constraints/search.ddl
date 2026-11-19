import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the example ea-constraints: the Ackley function of three variables with two
 *   constraint groups, "strict" (x:0 < x:1) and "vague" (x:0 + x:1 < x:2).
 */
module 'search' {
	data:
		/**
		 * First variable of the search.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:0';

		/**
		 * Second variable of the search.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:1';

		/**
		 * Third variable of the search.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:2';

		/**
		 * The value of the Ackley function.
		 */
		quotient real data 'y:0';

	constraints:
		constraint(data 'x:0' < data 'x:1', "strict");
		constraint(data 'x:0' + data 'x:1' < data 'x:2', "vague");
}
