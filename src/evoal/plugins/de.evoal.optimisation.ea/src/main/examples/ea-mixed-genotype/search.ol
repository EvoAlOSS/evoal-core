import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
	specify problem 'rastrigin' {
		search for data 'x:0', data 'x:1', data 'n:0', data 'n:1'

		map with 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' {
					function := rastrigin {};
					reads := [data 'x:0', data 'x:1', data 'n:0', data 'n:1'];
					writes := [data 'y:0'];
				}
			];
		}

		and minimise data 'y:0'

		// all candidates, the best candidate of every iteration and the lineage
		document ['candidates-per-iteration' {}, 'best-candidate-per-iteration' {}, 'memory-model' {}].
	}

	configure 'evolutionary-algorithm' for 'rastrigin' {
		'size-of-population' := 30;
		'number-of-offspring' := 20;
		'initialisation' := 'random-population' {};

		genotype := genotype {
			chromosomes := [
				// the real variables as bit strings: 12 bits per variable in Gray code, so
				// neighbouring values differ in one bit
				'gray-chromosome' { features := [data 'x:0', data 'x:1']; precision := 12; },
				// the integer variables as integers, with their own operators
				'integer-chromosome' {
					features := [data 'n:0', data 'n:1'];
					recombination := [ 'uniform-crossover' {} ];
					mutation := [ 'creep-mutation' { step := 1; 'gene-probability' := 0.5; } ];
				}
			];
		};

		// fitness-proportional: a candidate is chosen with a probability that grows with
		// the distance of its value to the worst value of the population
		'parent-selection' := 'roulette-wheel-selection' {};

		// operators of the algorithm: they apply to the Gray chromosome only, the integer
		// chromosome has its own
		recombination := [ 'multi-point-crossover' { points := 2; probability := 0.8; } ];
		mutation := [ 'bit-flip-mutation' {} ];

		// 10 parents survive (the best 2 for sure), the 20 children replace the others
		replacement := 'survivor-replacement' {
			selection := 'elite-selection' {
				count := 2;
				rest := 'stochastic-universal-sampling' {};
			};
		};

		'comparator' := 'numeric-comparator' {};
		'optimisation-function' := 'problem-function' {};
		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 50; } ];
	}
}
