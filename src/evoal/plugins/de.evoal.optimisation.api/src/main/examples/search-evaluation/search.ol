import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.local_search.optimisation;

import "data" from 'search';

module 'search' {
	specify problem 'rastrigin' {
		search for data 'x:0', data 'x:1'

		map with 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' { function := rastrigin {}; reads := [data 'x:0', data 'x:1']; writes := [data 'y:0']; }
			];
		}

		and minimise data 'y:0'

		// one row per iteration: the current candidate
		// the best candidate found so far; the last row of a run is its result
		document ['best-candidate-so-far' {}].
	}

	configure 'local-search' for 'rastrigin' {
		// neighbours: every combination of -0.5, 0 and +0.5 per variable, offered in random order
		'neighbour-choosing-strategy' := 'manual-strategy' {
			'step-size' := [
				'variable' { var := data 'x:0'; val := 0.5; },
				'variable' { var := data 'x:1'; val := 0.5; }
			];
		};

		// accept worse neighbours with probability exp(-difference / temperature)
		'accepting-strategy' := 'simulated-annealing' {
			'initial-temperature' := 40.0;

			// the temperature falls by 0.2% per iteration (to about 0.1 after 3000 iterations)
			'decreasing-function' := 'geometric-decrease' { 'decrease-rate' := 0.998; };
			'acceptance-probability' := 'exponential-probability' {};
		};

		// all local search examples start at the same point
		'initialisation' := 'specify-candidates' {
			'candidate-list' := [
				'candidate' { 'values' := [ 'variable' { var := data 'x:0'; val := 4.5; }, 'variable' { var := data 'x:1'; val := -4.5; } ]; }
			];
			'random' := false;
		};

		'comparator' := 'numeric-comparator' {};
		'optimisation-function' := 'problem-function' {};

		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 3000; } ];
	}
}
