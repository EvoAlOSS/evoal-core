import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from 'de.evoal.surrogate.ml';
import "definitions" from 'de.evoal.surrogate.knn.ml';
import "definitions" from 'de.evoal.surrogate.pipeline';

import "data" from surrogate;

module training {
	specify learning-task {
		input features 'x:0'
		output features 'y:0'

		learning from ["output/training.csv"]

		// Each scheme learns on parts of the training data and assesses the rest; its values
		// are a data set of its own in the goodness-of-fit file.
		assessing with [
			'k-fold-cross-validation' { 'k' := 5; },
			'leave-one-out-cross-validation' {},
			'bootstrap' { 'repetitions' := 50; },
			// four intervals of x:0: each part predicts a quarter of the range it never saw
			'block-cross-validation' { blocks := 'grid-blocks' { intervals := 4; }; }
		]

		serialise to "output/model.pson" and "output/gof.json"
	}

	specify validation steps []

	specify preparation steps []

	// The nearest neighbour reproduces every training point, so its goodness of fit on the
	// training data is perfect.
	specify model 'knn' {
		'k' := 1;
	}

	specify gof begin
		'rmse'();
		'R²'();
	end
}
