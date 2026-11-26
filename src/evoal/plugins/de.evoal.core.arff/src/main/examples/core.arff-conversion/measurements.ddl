/**
 * The data of the example core.arff-conversion: output/measurements.ddl as derived from
 *   data.arff, with the scale types reviewed.
 */
module measurements {
	data:
		/**
		 * The input.
		 */
		quotient real data 'x:0';

		/**
		 * The measured output.
		 */
		quotient real data 'y:0';

		/**
		 * Where the value was measured.
		 */
		nominal string data 'source';
}
