import "definitions" from de.evoal.surrogate.ml;
import "definitions" from 'de.evoal.surrogate.pipeline';
import "definitions" from de.evoal.surrogate.simple.ml;

import "definitions" from 'de.evoal.pipeline.base';

import "data" from surrogate;


module 'training' {
	specify learning-task {
		input features 'x:0'
		output features 'y:0'
		
		learning from [ "data.json" ] 
		serialise to "output/simple.pson" 
	}
	
	specify validation steps []
	
	specify preparation steps []
	
	specify model 'linear-regression' {
	}
			
	specify gof begin 
		'R²'();
	end
	
	// The use cases are derived from the learning task when they are left out. This module
	// writes out the learning use case to show the derivation: the steps get their reads,
	// writes and settings (files, features, model, model file) from the learning task.
	// 'assessment-data' records the training rows after 'validation' for 'gof-calculator'.
	use cases
	  specify learning
	  begin
	  	'execute'([
	  		step {
	  			component 'training-data-loader' {}
	  		},
		  	pipeline 'validation',
			step {
				component 'assessment-data' { 'data-set' := "training"; }
			},
			pipeline 'preparation',
			step {
				component 'model-learner' {}
			}
	  	]);

		'gof-calculator'();

		'store-model'();
	  end;
	end
}
