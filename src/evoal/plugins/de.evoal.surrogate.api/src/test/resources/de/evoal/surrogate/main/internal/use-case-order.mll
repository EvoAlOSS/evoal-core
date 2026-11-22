import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from 'de.evoal.surrogate.ml';
import "definitions" from 'de.evoal.surrogate.pipeline';
import "definitions" from 'de.evoal.surrogate.main.internal.model';

import "data" from 'de.evoal.surrogate.main.internal.data';

// The use cases have no pipeline steps, so no configuration has to be transformed.
module 'use-case-order' {
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
		'gof-calculator'();
	  end;

	  specify predicting
	  begin
	  end;

	  specify testing
	  begin
		'store-model'();
	  end;
	end
}
