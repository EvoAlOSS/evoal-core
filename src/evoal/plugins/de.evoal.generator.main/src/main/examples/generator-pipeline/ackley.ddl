import "definitions" from 'de.evoal.core.constraints';

module ackley {
	data:
		/**
		 * Input dimension for the ackley generator function.
		 */
		@LowerBoundary { 'boundary' := 0.0; 'inclusive' := true; }		 
		@UpperBoundary { 'boundary' := 10.0; 'inclusive' := true; }		 
		quotient real data 'x:0';
		
		
		
		/**
		 * Output dimension for the ackley generator function.
		 */
		@LowerBoundary { 'boundary' := 0.0; 'inclusive' := true; }		 
		@UpperBoundary { 'boundary' := 10.0; 'inclusive' := true; }		 
		quotient real data 'y:0';
		
}