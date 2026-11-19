import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
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

		// all candidates and the best candidate of every iteration
		document ['candidates-per-iteration' {}, 'best-candidate-per-iteration' {}].
	}

	configure 'evolutionary-algorithm' for 'rastrigin' {
		// mu = 40 parents create lambda = 40 children per generation
		'size-of-population' := 40;
		'number-of-offspring' := 40;
		'initialisation' := 'random-population' {};

		// no genotype: the five real variables form one double chromosome, which gets the
		// default operators 'sbx-crossover' (probability 0.9) and 'polynomial-mutation'
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
		'optimisation-function' := 'problem-function' {};
		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 100; } ];
	}
}
