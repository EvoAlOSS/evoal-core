import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from 'de.evoal.surrogate.ml';
import "definitions" from 'de.evoal.surrogate.pipeline';
import "definitions" from 'de.evoal.surrogate.main.internal.model';

import "data" from 'de.evoal.surrogate.main.internal.data';
module 'wrong-preparation' {
	specify learning-task {
		input features 'x:0'
		output features 'y:0'

		learning from ["training.json"]
		serialise to "output/model.pson"
	}

	specify validation steps []

	specify preparation steps [
		step {
			component 'min-max-normalisation' {
				'features' := [data 'z:0'];
				inverse := true;
			}
		}
		step {
			component 'z-score-normalisation' {
				'features' := [data 'y:0'];
				'μ' := [20000.0, 1.0];
			}
		}
	]

	specify model 'test-model' {}

	specify gof begin
		rmse();
	end
}
