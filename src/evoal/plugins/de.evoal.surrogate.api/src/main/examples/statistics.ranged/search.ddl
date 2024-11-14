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
		'ranged-connection'(data 'x:1', range(-1.12, 3.00), data 'x:2', range(-2.00, 0.00), 0.9);
		'ranged-connection'(data 'x:0', range(1.00, 4.00), data 'x:1', range(-5.12, -3.00), 0.9);
		'ranged-connection'(data 'x:0', range(-5.12, -3.00), data 'x:2', range(2.00, 5.12), 0.9);
		
}