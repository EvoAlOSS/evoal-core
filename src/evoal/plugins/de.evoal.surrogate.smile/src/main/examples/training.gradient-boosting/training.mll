import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from de.evoal.surrogate.ml;
import "definitions" from 'de.evoal.surrogate.pipeline';
import "definitions" from de.evoal.surrogate.smile.ml;

import "data" from surrogate;

module 'training' {
	specify learning-task {
		input features 'x:0'
		output features 'y:0'

		// the three segments of training-data.generator, with growing noise
		learning from [ "output/left.csv", "output/middle.csv", "output/right.csv" ]

		// new points of the right segment, where the noise is largest
		testing with [ "output/test.csv" ]

		// the model is an ONNX file; it is written outside output/, whose files the CI compares
		// as text
		serialise to "model/gradient-boosting.onnx" and "output/gof.json"
	}

	specify validation steps []

	// The model learns y:0 with mean 0 and standard deviation 1; the prediction pipeline of the
	// model file undoes it for the prediction and both bounds of the interval.
	specify preparation steps [
		step {
			component 'z-score-normalisation' {
				'features' := [data 'y:0'];
			}
		}
	]

	// three models of 100 trees each: the median and the 0.05 and 0.95 quantiles
	specify model 'gradient-boosting' {
		'point-prediction' := 'point-prediction.median';
		'number-trees' := 100;
		shrinkage := 0.1;
		'max-depth' := 4;
		'max-nodes' := 8;
		'node-size' := 10;
		'sampling-fraction' := 0.7;
		'row-sampling' := 'row-sampling.shared';
		coverage := 0.9;
	}

	specify gof begin
		'rmse'();
		'R²'();
		'picp'();
		'mpiw'();
	end
}
