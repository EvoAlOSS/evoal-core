// Minimises the Ackley function under two constraint groups: "strict" is repaired before the
// evaluation, "vague" is penalised after it, see README.md.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
	specify problem 'example-search-with-constraints' {
		search for data 'x:0', data 'x:1', data 'x:2'

		map with 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' {
					function := ackley {};
					reads := [data 'x:0', data 'x:1', data 'x:2'];
					writes := [data 'y:0'];
				}
			];
		}

		and minimise data 'y:0'

		document ['best-candidate-per-iteration' {}, 'constraint-statistics' {}, 'memory-model' {}].
	}

	configure 'evolutionary-algorithm' for 'example-search-with-constraints' {
		'size-of-population' := 20;
		'number-of-offspring' := 20;
		'initialisation' := 'random-population' {};
		genotype := genotype {
			chromosomes := [
				'double-chromosome' {
					features := [data 'x:0', data 'x:1', data 'x:2'];
					recombination := [ 'sbx-crossover' { probability := 0.9; 'distribution-index' := 15.0; } ];
					mutation := [ 'polynomial-mutation' { 'distribution-index' := 20.0; 'gene-probability' := 0.34; } ];
				}
			];
		};
		'parent-selection' := 'tournament-selection' { size := 2; };
		replacement := 'plus-replacement' {
			selection := 'elite-selection' { count := 2; rest := 'tournament-selection' { size := 2; }; };
		};

		// "strict": a new candidate with x:0 >= x:1 is projected onto x:0 = x:1; if that
		// fails three times, a random candidate replaces it
		'candidate-checks' := [
			'constraint-check' {
				group := "strict";
				reaction := 'check-reaction.repair';
				repair := 'projection-repair' {};
				'repair-fallback' := 'check-reaction.replace';
				'replacement-source' := 'random-population' {};
				'maximum-attempts' := 3;
			}
		];

		// "vague": the violation is added 10 times to the fitness
		'fitness-pipeline' := [ 'constraint-penalty' { group := "vague"; weight := 10.0; } ];
		'constraint-measure' := 'exact-measure' { 'equality-tolerance' := 1.0e-4; };

		'comparator' := 'numeric-comparator' {};
		'optimisation-function' := 'problem-function' {};
		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 20; } ];
	}
}
