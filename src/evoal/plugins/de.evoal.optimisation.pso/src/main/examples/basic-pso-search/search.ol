import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;


import "definitions" from de.evoal.optimisation.ea.optimisation;
import "definitions" from de.evoal.optimisation.pso.optimisation;

import "data" from search;

module search {
	specify problem 'example-search' {
		description := "Simple search";
		'search-space' := [data 'x:0'];
		'optimisation-space' := [data 'y:0'];
		'maximise' := false;
		'optimisation-function' := 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' { function := ackley {};    reads := [data 'x:0']; writes := [data 'y:0']; }
			];
		};
	}


	configure 'particle-swarm-optimisation' for 'example-search' {
		'number-of-generations' := 200;
		'size-of-population' := 25;
		'swarm' := 'default-swarm' {};
        'neighborhood-size' := 5;
		'mover' := 'basic-mover' {
		    'inertia-start' := 0.75;
		    'inertia-end' := 0.25;
		    'c1' := 2.05;
		    'c2' := 2.05;
		    'boundary-type' := "BOUNCE";
        };
        'topology' := "GLOBAL";
		'initialisation' := 'random-population' {};
		'comparator' := 'numeric-comparator' {};
		'optimisation-function' := 'problem-function' {};
		documenting := [ 'candidates-per-iteration' {} ];
	}
}