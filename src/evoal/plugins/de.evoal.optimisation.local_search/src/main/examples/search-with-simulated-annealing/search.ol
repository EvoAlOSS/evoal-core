import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.local_search.optimisation;

import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
	specify problem 'example-search' {
		search for data 'x:0', data 'x:1'
		
		map with 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' { function := rosenbrock {};    reads := [data 'x:0', data 'x:1']; writes := [data 'y:0']; }
			];
		}
		
		and minimise data 'y:0'
	}

	configure 'local-search' for 'example-search' {

        //maximum number of iterations
	    'number-of-iterations' := 200;

	    //strategy by which simulated annealing algorithm will identify and evaluate neighbours. Here, we choose
	    //a manual strategy, that will look for a better solutions in all directions (increasing or
	    //decreasing each value by step-size).
        'neighbour-choosing-strategy' := 'manual-strategy' {
            'step-size' := [
                'variable' { var := data 'x:0';
                             val := 0.01;
                                 },
                'variable' { var := data 'x:1';
                             val := 0.01;
                                 }
            ];
        };

        //initial individuals can be randomly generated, read from a file, or specified directly in this file (as seen here)
        //note that a random order means that the starting individual will be randomly selected from those specified.
        //with non-random orders, the first individual in the list serves as the initial individual
		'initialisation' := 'specify-candidates' { 'candidate-list' := [
			'candidate' { 'values' := [ 'variable'{var := data 'x:0'; val := 1.0;}, 'variable'{var := data 'x:1'; val := 5.0;}, 'variable'{var := data 'y:0'; val := 5.0;}];},
			'candidate' { 'values' := [ 'variable'{var := data 'x:0'; val := 15.0;}, 'variable'{var := data 'x:1'; val := 1.0;}, 'variable'{var := data 'y:0'; val := 5.0;}];}];
			'random' := false;};

        //currently, only single-objective optimisation is supported
		'comparator' := 'numeric-comparator' {};

        'accepting-strategy' := 'simulated-annealing' {
	        //starting temperature for algorithm
			'initial-temperature' := 50.0;
	
			//choose cooling schedule
	        'decreasing-function' := 'geometric-decrease' { 'decrease-rate' := 0.95;};
	
	        //choose acceptance probability function
	        'acceptance-probability' := 'exponential-probability' {};        	
        };

        //we already specified the optimisation function in the problem configuration. We reference that here.
		'optimisation-function' := 'problem-function' {};

		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 200; } ];

        //we can document our results. For the hill-climbing algorithm, individuals-per-generation and
        //best-individual-per-generation work identically
		document := ['candidates-per-iteration' {}];
	}
}