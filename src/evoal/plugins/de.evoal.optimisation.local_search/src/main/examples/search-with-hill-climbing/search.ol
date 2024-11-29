import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.generator.optimisation;
import "definitions" from de.evoal.generator.generator;
import "definitions" from de.evoal.optimisation.local_search.optimisation;

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
				'benchmark-configuration' { function := rosenbrock {};    reads := [data 'x:0', data 'x:1']; writes := [data 'y:0']; }
			];
		};
	}


	configure 'hill-climbing-algorithm' for 'example-search' {

        //maximum number of iterations
	    'number-of-iterations' := 200;

	    //strategy by which hill climbing algorithm will identify and evaluate neighbours. Here, we choose
	    //a manual strategy, that will look for a better solutions in all directions (increasing or
	    //decreasing each value by step-size).
        'neighbour-choosing-strategy' := 'manual-strategy' {
            'step-size' := [
                'variable' { var := data 'x:0';
                             val := 0.1;
                                 },
                'variable' { var := data 'x:1';
                             val := 0.1;
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

		'comparator' := 'numeric-comparator' {};

        //we already specified the optimisation function in the problem configuration. We reference that here.
		'optimisation-function' := 'problem-function' {};

        //we can document our results. For the hill-climbing algorithm, candidates-per-generation and
        //best-candidate-per-generation work identically
		documenting := ['candidates-per-generation' {}];
	}
}