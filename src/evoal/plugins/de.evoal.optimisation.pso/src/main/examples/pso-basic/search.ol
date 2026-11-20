import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.pso.optimisation;

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

		// all particles and the best particle of every iteration
		document ['candidates-per-iteration' {}, 'best-candidate-per-iteration' {}].
	}

	configure 'particle-swarm-optimisation' for 'ackley' {
		'size-of-population' := 20;
		'swarm' := 'default-swarm' {};
		// v' = w * v + c1 * r1 * (personal best - x) + c2 * r2 * (neighbourhood best - x)
		'mover' := 'basic-mover' {
			// the inertia w falls from 0.9 to 0.4 within the 100 iterations
			'inertia-start' := 0.9;
			'inertia-end' := 0.4;
			'inertia-iterations' := 100;
			'c1' := 2.0;
			'c2' := 2.0;
			'boundary-type' := 'boundary-handling.bounce';
		};

		// every particle is informed by the best particle of the whole swarm
		'neighborhood-size' := 4;
		'topology' := 'topology.global';
		'initialisation' := 'random-population' {};
		'comparator' := 'numeric-comparator' {};
		'optimisation-function' := 'problem-function' {};

		// stops at the iteration limit or as soon as the best candidate so far is below 0.01
		'stopping-criteria' := [
			'iteration-count' { 'maximum-iterations' := 100; },
			'target-value' { 'objective' := data 'y:0'; 'target' := 0.01; }
		];
	}
}
