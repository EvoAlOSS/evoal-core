import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.generator.optimisation;
import "definitions" from de.evoal.generator.generator;
import "definitions" from de.evoal.optimisation.hc.optimisation;
import "definitions" from de.evoal.optimisation.sa.optimisation;

import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from search;

module search {
	specify problem 'example-search' {
		description := "Simple search";
		'search-space' := [data 'x:0', data 'x:1'];
		'optimisation-space' := [data 'y:0'];
		'maximise' := false;
		'optimisation-function' := 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' { function := ackley {};    reads := [data 'x:0', data 'x:1']; writes := [data 'y:0']; }
			];
		};
	}

	configure 'simulated-annealing-algorithm' for 'example-search' {

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

        //initial candidates can be randomly generated, read from a file, or specified directly in this file (as seen here)
        //note that a random order means that the starting individual will be randomly selected from those specified.
        //with non-random orders, the first candidate in the list serves as the initial candidate
		'initialisation' := 'specify-candidates' { 'candidate-list' := [
			'candidate' { 'values' := [ 'variable'{var := data 'x:0'; val := 1.0;}, 'variable'{var := data 'x:1'; val := 5.0;}, 'variable'{var := data 'y:0'; val := 5.0;}];},
			'candidate' { 'values' := [ 'variable'{var := data 'x:0'; val := 15.0;}, 'variable'{var := data 'x:1'; val := 1.0;}, 'variable'{var := data 'y:0'; val := 5.0;}];}];
			'random' := false;};

        //currently, only single-objective optimisation is supported
		'comparator' := 'numeric-comparator' {};

        //starting temperature for algorithm
		'initial-temperature' := 50.0;

		//choose cooling schedule
        'cooling-schedule' := 'geometric-cooling' { 'cooling-rate' := 0.95;};

        //choose acceptance probability function
        'acceptance-probability' := 'exponential-probability' {};

        //we already specified the optimisation function in the problem configuration. We reference that here.
		'optimisation-function' := 'problem-function' {};

        //we can document our results. For the hill-climbing algorithm, candidates-per-generation and
        //best-candidate-per-generation work identically
		documenting := ['candidates-per-generation' {}];
	}
}