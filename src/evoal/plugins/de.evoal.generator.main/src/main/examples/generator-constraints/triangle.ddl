import "definitions" from 'de.evoal.core.constraints';
import "definitions" from 'de.evoal.optimisation.constraint';

/**
 * Two variables in the triangle x >= 0, y >= 0, x + y <= 1.
 */
module triangle {
	data:
		/**
		 * The first variable.
		 */
		@LowerBoundary { boundary := 0.0; }
		@UpperBoundary { boundary := 1.0; }
		quotient real data 'x';

		/**
		 * The second variable.
		 */
		@LowerBoundary { boundary := 0.0; }
		@UpperBoundary { boundary := 1.0; }
		quotient real data 'y';

	constraints:
		constraint(data 'x' + data 'y' <= 1.0, "triangle");
}
