import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.core.optimisation;
import "definitions" from de.evoal.generator.optimisation;
import "definitions" from de.evoal.generator.generator;

import "definitions" from de.evoal.core.pso.optimisation;


import "data" from 'ackley-data';

module 'pso-arpso-arpso' {
	specify problem 'regression-search' {
		description := "Regression for default PSO with basic mover";

		'search-space' := [data 'x:0', data 'x:1'] ;
		'optimisation-space' := [data 'y:0'];
		'maximise' := false;
		
		'optimisation-function' := 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' {
					function := 'ackley' {};
					reads := [  data 'x:0', data 'x:1']; 
					writes := [data 'y:0'];
				}
			];
		};
	}

	configure 'particle-swarm-optimisation' for 'regression-search' {
		'comparator' := 'numeric-comparator' {};
	
		'initialisation' := 'random-population' {};

		'mover' := 'attractive-repulsive-mover' {
			'boundary-type' := "WRAP";
			'inertia-start' := 1.0;
			'inertia-end' := 0.0;
			'c1' := 2.0;
			'c2' := 2.0;
		};
		
		'neighborhood-size' := 3;
		
		'number-of-generations' := 10;

		'optimisation-function' := 'problem-function' {};

		'size-of-population' 	:= 10;

		'swarm' := 'arpso-swarm' {
			'diversity-low' := 1.0;
			'diversity-high' := 2.0;
		};
		
		topology := "STAR";
		
		documenting := ['individuals-per-generation'{}, 'best-individual-per-generation' {}];
	}
}