import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;


module time_value{
	data:
		/**
		 * The time steps 1, 2, 3, ...
		 */
		@LowerBoundary { boundary := 1; }
		quotient real data 'time';
		quotient real data 'value';
}