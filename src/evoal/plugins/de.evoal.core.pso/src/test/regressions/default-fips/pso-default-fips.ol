import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.core.optimisation;
import "definitions" from de.evoal.generator.optimisation;
import "definitions" from de.evoal.generator.generator;

import "definitions" from de.evoal.core.pso.optimisation;


import "data" from 'ackley-data';

module 'pso-default-fips' {
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

		'mover' := 'fips-mover' {
			'boundary-type' := "WRAP";
			'phi' := 1.3;
		};
		
		'neighborhood-size' := 3;
		
		'number-of-generations' := 10;

		'optimisation-function' := 'problem-function' {};

		'size-of-population' 	:= 10;

		'swarm' := 'default-swarm' {
		};
		
		topology := "STAR";
		
		documenting := ['candidates-per-generation'{}, 'best-candidate-per-generation' {}];
	}
}