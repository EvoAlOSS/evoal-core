import "definitions" from de.evoal.surrogate.ml;
import "definitions" from de.evoal.surrogate.smile.ml;

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

	  model 'hellinger-svr'
		mapping 'x:0'
		to 'y:1'
		with parameters
			'ε' := 1.4;
			'σ' := 3.0;
			'soft-margin' := 0.15;
			tolerance := 0.1;

	  model 'hyperbolic-tangent-svr'
		mapping 'x:0'
		to 'y:2'
		with parameters
			'ε' := 1.4;
			'σ' := 3.0;
			'soft-margin' := 0.15;
			tolerance := 0.1;
			scale := 1.0;
			offset := 1.0;

	  model 'laplacian-svr'
		mapping 'x:0'
		to 'y:3'
		with parameters
			'ε' := 1.4;
			'σ' := 3.0;
			'soft-margin' := 0.15;
			tolerance := 0.1;

	  model 'linear-svr'
		mapping 'x:0'
		to 'y:4'
		with parameters
			'ε' := 1.4;
			'σ' := 3.0;
			'soft-margin' := 0.15;
			tolerance := 0.1;

	  model 'pearson-svr'
		mapping 'x:0'
		to 'y:5'
		with parameters
			'ε' := 1.4;
			'σ' := 3.0;
			'soft-margin' := 0.15;
			tolerance := 0.1;
			'ω' := 0.2;

	  model 'polynomial-svr'
		mapping 'x:0'
		to 'y:6'
		with parameters
			'ε' := 1.4;
			'σ' := 3.0;
			'soft-margin' := 0.15;
			tolerance := 0.1;
			'degree' := 2;
			'scale'  := 1.0;
			offset := 1.0;

	  model 'thin-plate-spline-svr'
		mapping 'x:0'
		to 'y:7'
		with parameters
			'ε' := 1.4;
			'σ' := 3.0;
			'soft-margin' := 0.15;
			tolerance := 0.1;

	begin
        predict svr from "data.json"
        and measure
            'R²'();
        end
        and store to "svr.pson"
    end
}