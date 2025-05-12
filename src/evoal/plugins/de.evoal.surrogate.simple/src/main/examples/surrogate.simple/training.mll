import "definitions" from de.evoal.surrogate.ml;
import "definitions" from de.evoal.surrogate.simple.ml;

import "data" from surrogate;

module training {
	function svr using
	  model 'identity'
		mapping 'x:0'
		to 'y:0'

	  model 'linear-regression'
		mapping 'x:0'
		to 'y:1'
		with parameters
			intercept := 0.0;
			slope := 1.0;

	  model 'simple-quadratic-regression'
		mapping 'x:0'
		to 'y:2'
		with parameters
			intercept := 0.0;
			slope := 1.0;
						

	begin
        predict svr from "data.json"
        and measure begin
            'R²'();
        end
        and store to "simple.pson"
     end
}