import "definitions" from 'de.evoal.core.constraints';

/**
 * Search space of the example ea-nsga2: ZDT1 with 30 variables in [0, 1]. Its Pareto-optimal
 *   front is f_2 = 1 - sqrt(f_1) for f_1 in [0, 1].
 */
module search {
	data:
		/**
		 * Variable x_1 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:0';

		/**
		 * Variable x_2 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:1';

		/**
		 * Variable x_3 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:2';

		/**
		 * Variable x_4 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:3';

		/**
		 * Variable x_5 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:4';

		/**
		 * Variable x_6 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:5';

		/**
		 * Variable x_7 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:6';

		/**
		 * Variable x_8 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:7';

		/**
		 * Variable x_9 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:8';

		/**
		 * Variable x_10 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:9';

		/**
		 * Variable x_11 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:10';

		/**
		 * Variable x_12 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:11';

		/**
		 * Variable x_13 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:12';

		/**
		 * Variable x_14 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:13';

		/**
		 * Variable x_15 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:14';

		/**
		 * Variable x_16 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:15';

		/**
		 * Variable x_17 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:16';

		/**
		 * Variable x_18 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:17';

		/**
		 * Variable x_19 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:18';

		/**
		 * Variable x_20 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:19';

		/**
		 * Variable x_21 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:20';

		/**
		 * Variable x_22 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:21';

		/**
		 * Variable x_23 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:22';

		/**
		 * Variable x_24 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:23';

		/**
		 * Variable x_25 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:24';

		/**
		 * Variable x_26 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:25';

		/**
		 * Variable x_27 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:26';

		/**
		 * Variable x_28 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:27';

		/**
		 * Variable x_29 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:28';

		/**
		 * Variable x_30 of ZDT1.
		 */
		@LowerBoundary { boundary := 0.0; inclusive := true; }
		@UpperBoundary { boundary := 1.0; inclusive := true; }
		quotient real data 'x:29';

		/**
		 * First objective of ZDT1, f_1 = x_1, minimised.
		 */
		quotient real data 'f:1';

		/**
		 * Second objective of ZDT1, f_2 = g * (1 - sqrt(f_1 / g)), minimised.
		 */
		quotient real data 'f:2';
}
