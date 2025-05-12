import "definitions" from de.evoal.surrogate.ml;
import "definitions" from de.evoal.surrogate.smile.ml;
import "definitions" from de.evoal.surrogate.adaption.density.ml;
import "definitions" from de.evoal.surrogate.adaption.interval.ml;

import "data" from surrogate;

module training {
	function svr using 
		model 'gaussian-svr'
			mapping 'x:0'
			to 'y:0'
			with parameters
				'ε' := 1.4;
				'σ' := 3.0;
				'soft-margin' := 0.15;
				tolerance := 0.1;
	
	begin
	    predict svr from "data.json"
	    and measure
	    	begin
	            'cross-validation'(10);
	            'R²'();
	            'kernel-density-estimation'(0.2);
	            'gaussian-density-estimation'(0.2);
	            'predictive-error'();
	    	end
	    and store to "surrogate.pson"
	end
}