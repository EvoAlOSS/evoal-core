// Searches for an x:0 >= 1 whose Ackley value is closest to the target of the evaluation; the
// feasibility rules prefer feasible candidates, see README.md.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
	specify problem 'example-search' {
		search for data 'x:0'

		map with 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' { function := ackley {}; reads := [data 'x:0']; writes := [data 'y:0']; }
			];
		}

		and optimise data 'y:0' towards target with distance {}

		document ['best-candidate-per-iteration' {}, 'constraint-statistics' {}].
	}

	configure 'evolutionary-algorithm' for 'example-search' {
		'size-of-population' := 20;
		'number-of-offspring' := 20;
		'initialisation' := 'random-population' {};
		genotype := genotype {
			chromosomes := [
				'double-chromosome' {
					features := [data 'x:0'];
					recombination := [ 'sbx-crossover' { probability := 0.9; 'distribution-index' := 15.0; } ];
					mutation := [ 'polynomial-mutation' { 'distribution-index' := 20.0; 'gene-probability' := 1.0; } ];
				}
			];
		};
		'parent-selection' := 'tournament-selection' { size := 2; };
		replacement := 'plus-replacement' {
			selection := 'elite-selection' { count := 2; rest := 'tournament-selection' { size := 2; }; };
		};

		'constraint-measure' := 'exact-measure' { 'equality-tolerance' := 1.0e-4; };

		// feasible candidates are better than infeasible ones; two infeasible ones are
		// compared by their violation
		'comparator' := 'feasibility-comparator' { group := "region"; };
		'optimisation-function' := 'problem-function' {};
		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 20; } ];
	}
}
