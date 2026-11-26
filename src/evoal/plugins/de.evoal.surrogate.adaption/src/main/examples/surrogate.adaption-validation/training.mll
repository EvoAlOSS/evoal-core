import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from 'de.evoal.pipeline.misc';
import "definitions" from de.evoal.surrogate.ml;
import "definitions" from 'de.evoal.surrogate.pipeline';
import "definitions" from de.evoal.surrogate.simple.ml;
import "definitions" from de.evoal.surrogate.adaption.density.ml;

import "data" from surrogate;

// The validation pipeline cuts the gap 0.7 <= x <= 0.8, with its two outliers, out of the
// training data. The model learns from the 17 rows that are left, and the goodness of fit on
// the training data and the density of the inputs describe the same 17 rows.
module 'training' {
	specify learning-task {
		input features 'x:0'
		output features 'y:0'

		learning from [ "data.json" ]

		serialise to "output/model.pson" and "output/gof.json"
	}

	specify validation steps [
		step {
			component 'condition-filter' {
				// the filter drops at most three rows one after the other
				'maximum-consecutive-rejections' := 5;
				'condition' := data 'x:0' < 0.7 OR data 'x:0' > 0.8;
			}

			reads [data 'x:0'];
		}
	]

	specify preparation steps []

	specify model 'linear-regression' {}

	specify gof begin
		'rmse'();
		'R²'();
		// the mean and standard deviation of the inputs, stored with the model for the
		// density adaption
		'gaussian-density-estimation'(0.05);
	end
}
