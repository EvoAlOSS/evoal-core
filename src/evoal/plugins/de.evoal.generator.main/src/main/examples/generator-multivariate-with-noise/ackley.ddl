import "definitions" from de.evoal.optimisation.constraint;

module 'ackley' {
  data:
    quotient real data 'x.0' with constraints:
    	value > -20.0;
    	value < 30.0;
    	;
    quotient real data 'x.1' with constraints:
    	value > -20.0;
    	value < 30.0;
    	;
    quotient real data 'y.0';
}