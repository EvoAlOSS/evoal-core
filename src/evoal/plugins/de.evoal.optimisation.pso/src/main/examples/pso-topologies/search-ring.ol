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

		// all particles and the best particle of every iteration
		document ['candidates-per-iteration' {}, 'best-candidate-per-iteration' {}].
	}

	configure 'particle-swarm-optimisation' for 'rastrigin' {
		'size-of-population' := 20;
		'swarm' := 'default-swarm' {};
		// constant inertia and the constants of Clerc and Kennedy, so the topology
		// alone decides how fast the swarm contracts
		'mover' := 'basic-mover' {
			'inertia-start' := 0.7298;
			'inertia-end' := 0.7298;
			'inertia-iterations' := 1;
			'c1' := 1.49618;
			'c2' := 1.49618;
			'boundary-type' := 'boundary-handling.bounce';
		};

		// every particle is informed by its 2 neighbours on a ring of all particles
		'neighborhood-size' := 2;
		'topology' := 'topology.ring';
		'initialisation' := 'random-population' {};
		'comparator' := 'numeric-comparator' {};
		'optimisation-function' := 'problem-function' {};

		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 100; } ];
	}
}
