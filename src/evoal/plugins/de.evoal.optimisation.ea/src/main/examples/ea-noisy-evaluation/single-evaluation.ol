import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'single-evaluation' {
	specify problem 'rastrigin' {
		search for data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4'

		map with 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' {
					function := rastrigin {};
					reads := [data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4'];
					writes := [data 'y:0'];
				}
			];
		}

		and minimise data 'y:0'

		// all candidates with their (noisy) objective and, for the same rows, the value of the
		// function without noise
		document ['candidates-per-iteration' {}, 'best-candidate-per-iteration' {},
		          'reference-values-per-individual' { reference := 'problem-function' {}; }].
	}

	configure 'evolutionary-algorithm' for 'rastrigin' {
		// mu = 40 parents create lambda = 40 children per generation
		'size-of-population' := 40;
		'number-of-offspring' := 40;
		'initialisation' := 'random-population' {};

		// the five real variables form one double chromosome with simulated binary crossover
		// (probability 0.9) and polynomial mutation
		genotype := genotype {
			chromosomes := [
				'double-chromosome' {
					features := [data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4'];
					recombination := [ 'sbx-crossover' { probability := 0.9; } ];
					mutation := [ 'polynomial-mutation' {} ];
				}
			];
		};

		'parent-selection' := 'tournament-selection' { size := 3; };

		// (mu + lambda): the best 2 of parents and children survive for sure, the other 38
		// are chosen by binary tournaments
		replacement := 'plus-replacement' {
			selection := 'elite-selection' {
				count := 2;
				rest := 'tournament-selection' { size := 2; };
			};
		};

		'comparator' := 'numeric-comparator' {};
		// every evaluation adds Gaussian noise with the standard deviation 2 to the Rastrigin value
		'optimisation-function' := 'noisy-function' {
			function := 'problem-function' {};
			'standard-deviation' := 2.0;
		};
		// every candidate is evaluated once (the default, stated for the comparison)
		'evaluation-strategy' := 'single-evaluation' {};
		// both configurations get the same budget of 4000 evaluations
		'stopping-criteria' := [
			'iteration-count' { 'maximum-iterations' := 1000; },
			'evaluation-budget' { 'maximum-evaluations' := 4000; 'exhaustion' := 'budget-exhaustion.cut-off'; }
		];
	}
}
