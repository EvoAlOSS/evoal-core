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
		serialise to "svr.pson" 
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
	
	use cases
	  specify learning 
	  begin
	  	'execute'([
	  		step {
	  			component 'training-data-loader' {}
	  			writes [data 'x:0', data 'y:0']; // should be default
	  		},
		  	pipeline 'validation',
			pipeline 'preparation',
			step {
				component 'model-learner' {}
				reads [data 'x:0', data 'y:0']; // should be default
			}
	  	]);
	  	
		'gof-calculator'( );
		
		'store-model'();
	  end;

	  specify predicting 
		begin 
            pipeline 'preparation'
            step {
                component 'model-prediction' {}
    			reads [data 'x:0']; // should be default
    			writes [data 'y:0']; // should be default
            }
		end;
	end
}