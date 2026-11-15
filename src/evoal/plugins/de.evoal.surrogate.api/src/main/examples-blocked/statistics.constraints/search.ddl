import "definitions" from 'de.evoal.core.constraints';
import "definitions" from de.evoal.optimisation.constraint;

module 'search' {
	data:
		/**
		 * Source dimension of the training data.
		 */
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:0';
		
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:1';
		
		@LowerBoundary { boundary := -5.12; inclusive := true; }
		@UpperBoundary { boundary := 5.12; inclusive := true; }
		quotient real data 'x:2';
		
		
		/**
		 * Target dimension of the training data.
		 */
		quotient real data 'y:0';
		
	constraints: 
	 constraint(data 'x:0' < data 'x:1', "strict" );
	 constraint(data 'x:0' + data 'x:1' < data 'x:2', "vague");
		
}