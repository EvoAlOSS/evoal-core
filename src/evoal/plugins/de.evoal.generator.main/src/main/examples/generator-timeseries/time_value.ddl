import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;


module time_value{
	data:
		@UpperBoundary { boundary := 0; inclusive := false; }
		quotient real data 'time';
		quotient real data 'value';
}