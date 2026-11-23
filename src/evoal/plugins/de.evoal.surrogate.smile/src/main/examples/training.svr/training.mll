import "definitions" from de.evoal.surrogate.ml;
import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from 'de.evoal.surrogate.pipeline';
import "definitions" from de.evoal.surrogate.smile.ml;

import "data" from surrogate;

module training {
	specify learning-task {
		input features 'x:0'
		output features 'y:0'
		
		learning from [ "data.json" ] 
		serialise to "output/svr.pson" 
	}
	
	specify validation steps []
	
	specify preparation steps []

	specify model 'epsilon-svr' {
		'ε' := 1.4;
		'soft-margin' := 0.1;
		tolerance := 0.15;
		
		'kernel' := linear {};
	}

			
	specify gof begin 
		'R²'();
	end
}
