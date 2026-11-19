// Regression: NSGA-II on ZDT1 with 5 variables: 'crowded-comparator', binary tournaments by
// the crowded comparison, 'nsga2-selection' in a plus replacement, SBX and polynomial mutation.
// The memory model records the fronts as ranks and front and crowding distance of every
// individual.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
	specify problem 'regression' {
		search for data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4'

		map with 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' {
					function := zdt1 {};
					reads := [data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4'];
					writes := [data 'f:1', data 'f:2'];
				}
			];
		}

		and minimise data 'f:1', minimise data 'f:2'

		document ['candidates-per-iteration' {}, 'best-candidate-per-iteration' {}, 'memory-model' { 'steps' := true; }].
	}

	configure 'evolutionary-algorithm' for 'regression' {
		'size-of-population' := 12;
		'number-of-offspring' := 12;
		'initialisation' := 'random-population' {};

		genotype := genotype {
			chromosomes := [
				'double-chromosome' {
					features := [data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4'];
					// the operators of the NSGA-II paper: SBX (probability 0.9, index 20) and
					// polynomial mutation (index 20, 1 / 5 per gene)
					recombination := [ 'sbx-crossover' { probability := 0.9; 'distribution-index' := 20.0; } ];
					mutation := [ 'polynomial-mutation' { 'distribution-index' := 20.0; 'gene-probability' := 1.0 / 5.0; } ];
				}
			];
		};

		// binary tournaments by the crowded-comparison operator: lower front, then larger
		// crowding distance
		'parent-selection' := 'tournament-selection' { size := 2; };
		'comparator' := 'crowded-comparator' {};

		// (mu + lambda): parents and children are sorted into non-dominated fronts; the best
		// fronts survive, the last one cut by crowding distance
		replacement := 'plus-replacement' { selection := 'nsga2-selection' {}; };

		'optimisation-function' := 'problem-function' {};
		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
	}
}
