import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from 'de.evoal.surrogate.ml';
import "definitions" from 'de.evoal.surrogate.knn.ml';
import "definitions" from 'de.evoal.surrogate.pipeline';

import "data" from surrogate;

module training {
	specify learning-task {
		input features 'x:0', 'x:1', 'x:2', 'x:3', 'x:4', 'x:5'
		output features 'y:0'
		
		learning from ["data.json"]
		serialise to "output/knn.pson"
	}
	
	specify validation steps []
	
	specify preparation steps []
	
	specify model 'knn' {
		'k' := 5;
	}
			
	specify gof begin 
		'rmse'();
		'R²'();
	end
}
