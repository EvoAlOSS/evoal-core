import "definitions" from 'de.evoal.core.constraints';

module surrogate {
	data:
		/**
		 * Input of the Gaussian process model.
		 */
		@LowerBoundary { boundary := -15.0; inclusive := true; }
		@UpperBoundary { boundary := 15.0; inclusive := true; }
		quotient real data 'x:0';

		/**
		 * Input of the Gaussian process model.
		 */
		@LowerBoundary { boundary := -15.0; inclusive := true; }
		@UpperBoundary { boundary := 15.0; inclusive := true; }
		quotient real data 'x:1';
		
		/**
		 * Input of the Gaussian process model.
		 */
		@LowerBoundary { boundary := -15.0; inclusive := true; }
		@UpperBoundary { boundary := 15.0; inclusive := true; }
		quotient real data 'x:2';

		/**
		 * Input of the Gaussian process model.
		 */
		@LowerBoundary { boundary := -15.0; inclusive := true; }
		@UpperBoundary { boundary := 15.0; inclusive := true; }
		quotient real data 'x:3';

		/**
		 * Input of the Gaussian process model.
		 */
		@LowerBoundary { boundary := -15.0; inclusive := true; }
		@UpperBoundary { boundary := 15.0; inclusive := true; }
		quotient real data 'x:4';

		/**
		 * Input of the Gaussian process model.
		 */
		@LowerBoundary { boundary := -15.0; inclusive := true; }
		@UpperBoundary { boundary := 15.0; inclusive := true; }
		quotient real data 'x:5';

		/**
		 * Prediction of the Gaussian process model, maximised by the search.
		 */
		quotient real data 'y:0';
}
