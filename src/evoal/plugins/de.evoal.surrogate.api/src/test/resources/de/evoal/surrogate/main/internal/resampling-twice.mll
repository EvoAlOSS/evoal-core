import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from 'de.evoal.surrogate.ml';
import "definitions" from 'de.evoal.surrogate.pipeline';
import "definitions" from 'de.evoal.surrogate.main.internal.model';

import "data" from 'de.evoal.surrogate.main.internal.data';

module 'resampling-twice' {
	specify learning-task {
		input features 'x:0', 'x:1'
		output features 'y:0'

		learning from ["training.json"]
		assessing with [
			'k-fold-cross-validation' { 'k' := 5; },
			'k-fold-cross-validation' { 'k' := 10; }
		]
		serialise to "output/model.pson"
	}

	specify validation steps []

	specify preparation steps []

	specify model 'test-model' {}

	specify gof begin
		rmse();
	end
}
