import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from 'de.evoal.surrogate.ml';
import "definitions" from 'de.evoal.surrogate.pipeline';
import "definitions" from 'de.evoal.surrogate.main.internal.model';

import "data" from 'de.evoal.surrogate.main.internal.data';

module 'outside-features' {
	specify learning-task {
		input features 'x:0'
		output features 'y:0'

		learning from ["training.json"]
		serialise to "output/model.pson"
	}

	specify validation steps []

	specify preparation steps []

	specify model 'test-model' {}

	specify gof begin
		rmse();
	end

	use cases
	  specify learning
	  begin
		'execute'([
			step {
				component 'training-data-loader' {}
			},
			step {
				component 'model-learner' {
					'input-features' := [data 'y:0'];
				}
			}
		]);
	  end;

	  specify predicting
	  begin
		step {
			component 'model-prediction' {}
			reads [data 'z:0'];
		}
	  end;
	end
}
