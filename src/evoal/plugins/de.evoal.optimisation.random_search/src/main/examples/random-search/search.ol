import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.random_search.optimisation;

import "data" from 'search';

module 'search' {
	specify problem 'ackley' {
		search for data 'x:0', data 'x:1'

		map with 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' { function := ackley {}; reads := [data 'x:0', data 'x:1']; writes := [data 'y:0']; }
			];
		}

		and minimise data 'y:0'

		// the best sample of every iteration and the best sample found so far
		document ['best-candidate-per-iteration' {}, 'best-candidate-so-far' {}].
	}

	configure 'random-search' for 'ackley' {
		// 20 random samples in each of the iterations 0 to 100: 2020 evaluations, as many as
		//   the example pso-basic uses
		'samples-per-iteration' := 20;
		'initialisation' := 'random-population' {};
		'comparator' := 'numeric-comparator' {};
		'optimisation-function' := 'problem-function' {};

		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 100; } ];
	}
}
