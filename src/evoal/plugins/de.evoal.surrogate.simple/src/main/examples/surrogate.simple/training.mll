import "definitions" from de.evoal.surrogate.ml;
import "definitions" from de.evoal.surrogate.simple.ml;

import "data" from surrogate;

module training {
	prediction svr
		maps 'x:0'
	    to 'y:0', 'y:1', 'y:2'
	    using
	    	layer transfer
				with 
				  function 'identity'
					mapping 'x:0'
					to 'y:0'

				  function 'linear-regression'
					mapping 'x:0'
					to 'y:1'
					with parameters
						intercept := 0.0;
						slope := 1.0;

				  function 'simple-quadratic-regression'
					mapping 'x:0'
					to 'y:2'
					with parameters
						intercept := 0.0;
						slope := 1.0;
						

        predict svr from "data.json"
        and measure
            'R²'();
        end
        and store to "simple.pson"
}