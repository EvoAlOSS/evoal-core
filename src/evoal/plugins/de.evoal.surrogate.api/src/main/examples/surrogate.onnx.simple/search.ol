import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.optimisation.ea.optimisation;
import "definitions" from de.evoal.surrogate.optimisation;

import "data" from surrogate;

module 'search' {
	specify problem 'example-search' {
		search for data 'Input_0'

		map with 'unknown-function' {}

		and maximise data 'output'

		document ['candidates-per-iteration' {}, 'best-candidate-per-iteration' {}].
	}

	configure 'evolutionary-algorithm' for 'example-search' {
		'size-of-population' := 50;
		'number-of-offspring' := 30;
		'initialisation' := 'random-population' {};

		// one double chromosome: the child is the mean of its parents, then it is mutated
		// polynomially
		genotype := genotype {
			chromosomes := [
				'double-chromosome' {
					features := [data 'Input_0'];
					recombination := [ 'arithmetic-crossover' { probability := 0.5; alpha := 0.5; } ];
					mutation := [ 'polynomial-mutation' {} ];
				}
			];
		};

		'parent-selection' := 'tournament-selection' { size := 2; };
		// 20 parents survive (the best 5 for sure), the 30 children replace the others
		replacement := 'survivor-replacement' {
			selection := 'elite-selection' {
				count := 5;
				rest := 'tournament-selection' { size := 2; };
			};
		};
		// a candidate that has survived 10 generations is replaced by a random one (the default
		// 'replacement-source')
		'candidate-checks' := [
			'maximum-age' { iterations := 10; reaction := 'check-reaction.replace'; }
		];

		'comparator' := 'numeric-comparator' {};
		// the input and output names are the names of the tensors in the ONNX model
		'optimisation-function' := 'surrogate' {
			'model-file' := "in_1number-out_number_divided_by_in.onnx";
			'input-space' := [data 'Input_0'];
			'output-space' := [data 'output'];
		};

		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
	}
}
