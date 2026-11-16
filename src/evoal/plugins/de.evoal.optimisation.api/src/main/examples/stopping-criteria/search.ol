import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.pso.optimisation;

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

		// the best individual and the number of evaluations of every iteration
		document [
			'best-candidate-per-iteration' {},
			'metrics-per-iteration' {}
		].
	}

	configure 'particle-swarm-optimisation' for 'rastrigin' {
		'size-of-population' := 20;
		'swarm' := 'default-swarm' {};
		'mover' := 'basic-mover' {
			'inertia-start' := 0.9;
			'inertia-end' := 0.4;
			'inertia-iterations' := 10;
			'c1' := 2.0;
			'c2' := 2.0;
			'boundary-type' := 'boundary-handling.bounce';
		};
		'neighborhood-size' := 4;
		'topology' := 'topology.global';
		'initialisation' := 'random-population' {};
		'comparator' := 'numeric-comparator' {};
		'optimisation-function' := 'problem-function' {};

		// the run stops as soon as one of the criteria is met: here, the budget of 310
		// evaluations runs out before the 1000 iterations are reached
		'stopping-criteria' := [
			'iteration-count' { 'maximum-iterations' := 1000; },
			'evaluation-budget' {
				'maximum-evaluations' := 310;
				'exhaustion' := 'budget-exhaustion.finish-iteration';
			}
		];
	}
}
