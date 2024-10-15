import "definitions" from de.evoal.optimisation.constraint;

module 'search' {
	data:
		/**
		 * Source dimension of the training data.
		 */
		quotient real data 'x:0' with constraints:
            value >= -5.12;
            value <= 5.12;
        ;
		
		quotient real data 'x:1' with constraints:
            value >= -5.12;
            value <= 5.12;
        ;
		
		quotient real data 'x:2' with constraints:
            value >= -5.12;
            value <= 5.12;
        ;
		
		
		/**
		 * Target dimension of the training data.
		 */
		quotient real data 'y:0';
		
	constraints: 
	 constraint(data 'x:0' < data 'x:1', "strict" );
	 constraint(data 'x:0' + data 'x:1' < data 'x:2', "vague");
		
}