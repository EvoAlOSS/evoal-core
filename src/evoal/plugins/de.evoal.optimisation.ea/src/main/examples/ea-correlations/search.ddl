import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

/**
 * Search space of the example ea-correlations: the Ackley function of three variables with
 *   three ranged correlations.
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
		'ranged-correlation'(data 'x:1', range(-1.12, 3.00), data 'x:2', range(-2.00, 0.00), 0.9);
		'ranged-correlation'(data 'x:0', range(1.00, 4.00), data 'x:1', range(-5.12, -3.00), 0.9);
		'ranged-correlation'(data 'x:0', range(-5.12, -3.00), data 'x:2', range(2.00, 5.12), 0.9);
}
