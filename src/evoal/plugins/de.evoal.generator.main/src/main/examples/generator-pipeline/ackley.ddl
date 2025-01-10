import "definitions" from 'de.evoal.core.math';
import "definitions" from 'de.evoal.core.constraints';

module ackley {
  data:
	/**
	 * Input dimension for the Ackley generator function.
	 */
	@LowerBoundary { 'boundary' := -32768.0; 'inclusive' := true; }
	@UpperBoundary { 'boundary' :=  32768.0; 'inclusive' := true; }
	quotient real data 'x:0';
		
	@LowerBoundary { 'boundary' := -32768.0; 'inclusive' := true; }
	@UpperBoundary { 'boundary' :=  32768.0; 'inclusive' := true; }
	quotient real data 'x:1';

	@LowerBoundary { 'boundary' := -32768.0; 'inclusive' := true; }
	@UpperBoundary { 'boundary' :=  32768.0; 'inclusive' := true; }
	quotient real data 'x:2';

	@LowerBoundary { 'boundary' := -32768.0; 'inclusive' := true; }
	@UpperBoundary { 'boundary' :=  32768.0; 'inclusive' := true; }
	quotient real data 'x:3';

	@LowerBoundary { 'boundary' := -32768.0; 'inclusive' := true; }
	@UpperBoundary { 'boundary' :=  32768.0; 'inclusive' := true; }
	quotient real data 'x:4';

	/**
	 * Output dimension for the Ackley generator function.
	 */
	quotient real data 'y:0';
}

