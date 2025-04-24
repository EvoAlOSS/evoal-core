import "definitions" from de.evoal.optimisation.constraint;


module time_value{
	data:
		quotient real data 'time' with constraints:
			value<0;
		;
		quotient real data 'value';
}