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
		// switches to repulsion if the diversity falls below 'diversity-low' and back to
		// attraction if it rises above 'diversity-high'
		'swarm' := 'arpso-swarm' {
			'diversity-low' := 0.02;
			'diversity-high' := 0.25;
		};
		// like the basic mover, but the attraction is reversed while the swarm repels
		'mover' := 'arpso-mover' {
			'inertia-start' := 0.9;
			'inertia-end' := 0.4;
			'inertia-iterations' := 50;
			'c1' := 2.0;
			'c2' := 2.0;
			'boundary-type' := 'boundary-handling.bounce';
		};

		'neighborhood-size' := 4;
		'topology' := 'topology.global';
		'initialisation' := 'random-population' {};
		'comparator' := 'numeric-comparator' {};
		'optimisation-function' := 'problem-function' {};

		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 200; } ];
	}
}
