import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from de.evoal.surrogate.ml;
import "definitions" from 'de.evoal.surrogate.pipeline';
import "definitions" from de.evoal.surrogate.simple.ml;

import "data" from measurements;

// The learning task reads the ARFF file directly. The rows at x = 0.2 (no output) and with the
// missing input are left out, so the model learns from 9 of the 11 rows.
module 'training' {
	specify learning-task {
		input features 'x:0'
		output features 'y:0'

		learning from [ "data.arff" ]

		serialise to "output/model.pson" and "output/gof.json"
	}

	specify validation steps []

	specify preparation steps []

	specify model 'linear-regression' {}

	specify gof begin
		'rmse'();
		'R²'();
	end
}
