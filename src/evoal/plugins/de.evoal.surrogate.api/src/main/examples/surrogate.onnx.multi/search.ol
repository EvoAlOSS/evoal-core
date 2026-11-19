import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.optimisation.ea.optimisation;
import "definitions" from de.evoal.surrogate.optimisation;

import "data" from surrogate;

module 'search' {
	specify problem 'example-search' {
		search for data 'x0', data 'x1', data 'x2'

		map with 'unknown-function' {}

		and maximise data 'y0', maximise data 'y1', maximise data 'y2'

		document ['candidates-per-iteration' {}, 'best-candidate-per-iteration' {}].
	}

	configure 'evolutionary-algorithm' for 'example-search' {
		'size-of-population' := 50;
		'number-of-offspring' := 30;
		'initialisation' := 'random-population' {};

		// one double chromosome per variable
		genotype := genotype {
			chromosomes := [
				'double-chromosome' { features := [data 'x0']; },
				'double-chromosome' { features := [data 'x1']; },
				'double-chromosome' { features := [data 'x2']; }
			];
		};

		'parent-selection' := 'tournament-selection' { size := 2; };
		// the child is the mean of its parents; the mutation is the default of a double
		// chromosome, 'polynomial-mutation'
		recombination := [ 'arithmetic-crossover' { probability := 0.5; alpha := 0.5; } ];
		// 20 parents survive (the best 5 for sure), the 30 children replace the others
		replacement := 'survivor-replacement' {
			selection := 'elite-selection' {
				count := 5;
				rest := 'tournament-selection' { size := 2; };
			};
		};
		// a candidate that has survived 10 generations is replaced by a random one
		'candidate-checks' := [
			'maximum-age' { iterations := 10; reaction := 'check-reaction.replace'; }
		];

		'comparator' := 'numeric-comparator' {};
		// the three goals become one fitness: their sum with equal weights
		'fitness-pipeline' := [ 'weighted-sum' {} ];
		// the input and output names are the names of the tensors in the ONNX model
		'optimisation-function' := 'surrogate' {
			'model-file' := "in_3Num-out-3_x+y_x+y-z_z.onnx";
			'input-space' := [data 'x0', data 'x1', data 'x2'];
			'output-space' := [data 'y0', data 'y1', data 'y2'];
		};

		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
	}
}
