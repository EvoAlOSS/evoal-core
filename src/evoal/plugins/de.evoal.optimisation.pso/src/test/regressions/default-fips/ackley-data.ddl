module 'ackley-data' {
	data:
	
		/**
		 * Source dimension for 'x:0'.
		 */
		quotient real data'x:0' with constraints:
                 value >= -32.0;
                 value <= 32.0;
        ;
		/**
		 * Source dimension for 'x:1'.
		 */	   
		quotient real data 'x:1' with constraints:
                 value >= -32.0;
                 value <= 32.0;
        ;
		
		/**
		 * Target dimension of the training data.
		 */
		quotient real data 'y:0'
		;		 
}