module search {
	data:
		/**
		 * Source dimension of the training data.
		 */
		quotient real data 'x:0' with constraints:
            value >= -5.12;
            value <= 5.12;
        ;


		/**
		 * Target dimension of the training data.
		 */
		quotient real data 'y:0';

}