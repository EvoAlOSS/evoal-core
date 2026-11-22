import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from de.evoal.surrogate.ml;
import "definitions" from 'de.evoal.surrogate.pipeline';
import "definitions" from de.evoal.surrogate.smile.ml;

import "data" from surrogate;

module 'training' {
	specify learning-task {
		input features 'x:0'
		output features 'y:0'

		// the nine points of training-data.generator, without (0.6, 0.9)
		learning from [ "output/left.csv", "output/right.csv" ]

		// the gap (0.6, 0.9); the default testing use case assesses the model on it
		testing with [ "output/test.csv" ]

		serialise to "output/gaussian-process.pson" and "output/gof.json"
	}

	specify validation steps []

	specify preparation steps []

	// the length scale σ and the noise are starting values: with 'iterations' > 0 they are
	// fitted to the training data; the fitted values are logged and stored in the model file
	specify model 'gaussian-process' {
		'kernel' := gaussian { 'σ' := 0.2; };
		'noise' := 0.01;
		'normalize' := true;
		'tolerance' := 1e-5;
		'iterations' := 100;
	}

	specify gof begin
	    'rmse'();
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
