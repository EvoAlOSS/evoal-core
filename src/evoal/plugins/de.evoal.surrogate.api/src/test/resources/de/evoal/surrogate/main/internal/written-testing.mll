import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from 'de.evoal.surrogate.ml';
import "definitions" from 'de.evoal.surrogate.pipeline';
import "definitions" from 'de.evoal.surrogate.main.internal.model';

import "data" from 'de.evoal.surrogate.main.internal.data';

module 'written-testing' {
	specify learning-task {
		input features 'x:0'
		output features 'y:0'

		learning from ["training.json"]
		testing with ["test.json"]
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
				writes [data 'x:0', data 'y:0'];
			},
			pipeline 'validation',
			step {
				component 'model-learner' {}
				reads [data 'x:0', data 'y:0'];
			}
		]);

		'gof-calculator'();

		'store-model'();
	  end;

	  specify predicting
	  begin
		step {
			component 'model-prediction' {}
			reads [data 'x:0'];
			writes [data 'y:0'];
		}
	  end;

	  specify testing
	  begin
		'gof-calculator'();
	  end;
	end
}
