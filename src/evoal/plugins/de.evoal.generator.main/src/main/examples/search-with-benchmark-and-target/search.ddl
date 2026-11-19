import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the example: the Ackley function of one variable with the constraint
 *   x:0 >= 1 (group "region"), so the minimum 0 at x:0 = 0 is excluded.
 */
module search {
	data:
		/**
		 * The variable of the search.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:0';

		/**
		 * The value of the Ackley function.
		 */
		quotient real data 'y:0';

	constraints:
		constraint(data 'x:0' >= 1.0, "region");
}
