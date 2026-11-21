import "definitions" from 'de.evoal.core.constraints';

/**
 * Data of the example correlation-estimation: three variables, of which x:0 and x:1 are
 *   correlated in the generated data, and the value of the Ackley function.
 */
module 'search' {
	data:
		/**
		 * First variable.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:0';

		/**
		 * Second variable, correlated with x:0 (rho = 0.8 in the generated data).
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:1';

		/**
		 * Third variable, independent of the others.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:2';

		/**
		 * The value of the Ackley function.
		 */
		quotient real data 'y:0';
}
