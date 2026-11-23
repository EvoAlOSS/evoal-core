import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from de.evoal.surrogate.ml;
import "definitions" from 'de.evoal.surrogate.pipeline';
import "definitions" from de.evoal.surrogate.smile.ml;

import "data" from surrogate;

module 'training' {
	specify learning-task {
		input features 'x:0'
		output features 'y:0'

		learning from [ "output/training.csv" ]
		testing with [ "output/test.csv" ]

		serialise to "output/model.pson" and "output/gof.json"
	}

	specify validation steps []

	// The SVR learns on prepared data: the temperature mapped to [0, 1] and the output with
	// mean 0 and standard deviation 1. The parameters (minimum and maximum, μ and σ) are fitted
	// on the training data and stored in the prediction pipeline of the model file, which also
	// undoes the z-score normalisation after the prediction, so the model predicts in the
	// original unit of y:0.
	specify preparation steps [
		step {
			component 'min-max-normalisation' {
				'features' := [data 'x:0'];
			}
		}
		step {
			component 'z-score-normalisation' {
				'features' := [data 'y:0'];
			}
		}
	]

	// ε and σ refer to the prepared data: 0.05 standard deviations of y:0 and 0.2 of the
	// temperature range.
	specify model 'epsilon-svr' {
		'ε' := 0.05;
		'soft-margin' := 10.0;
		tolerance := 0.001;
		'kernel' := gaussian { 'σ' := 0.2; };
	}

	specify gof begin
		'rmse'();
		'R²'();
	end
}
