// Minimises the Ackley function with correlation-aware operators: a mutation of a variable
// is propagated to the variables correlated with it, and a crossover keeps correlated
// variables together, see README.md.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
	specify problem 'example-search-with-ranged-correlations' {
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

		document [
			'best-candidate-per-iteration' {},
			'correlation-statistics' { 'empirical-correlation' := true; 'covariance-difference' := true; },
			'memory-model' {}
		].
	}

	configure 'evolutionary-algorithm' for 'example-search-with-ranged-correlations' {
		'size-of-population' := 20;
		'number-of-offspring' := 20;
		'initialisation' := 'random-population' {};

		// x:0 and x:2 are real genes, x:1 is Gray-coded; the correlations cross the chromosomes
		genotype := genotype {
			chromosomes := [
				'double-chromosome' {
					features := [data 'x:0', data 'x:2'];
					recombination := [
						'linkage-crossover' {
							crossover := 'uniform-crossover' { probability := 0.9; 'swap-probability' := 0.5; };
							'minimum-correlation' := 0.5;
						}
					];
					mutation := [
						'correlation-aware-mutation' {
							mutation := 'polynomial-mutation' { 'distribution-index' := 20.0; 'gene-probability' := 0.5; };
							'minimum-correlation' := 0.5;
							'propagation-depth' := 1;
						}
					];
				},
				'gray-chromosome' {
					features := [data 'x:1'];
					precision := 16;
					recombination := [ 'single-point-crossover' { probability := 0.9; } ];
					mutation := [
						'correlation-aware-mutation' {
							mutation := 'bit-flip-mutation' { 'gene-probability' := 0.1; };
							'minimum-correlation' := 0.5;
							'propagation-depth' := 1;
						}
					];
				}
			];
		};
		'parent-selection' := 'tournament-selection' { size := 2; };
		replacement := 'plus-replacement' {
			selection := 'elite-selection' { count := 2; rest := 'tournament-selection' { size := 2; }; };
		};

		'comparator' := 'numeric-comparator' {};
		'optimisation-function' := 'problem-function' {};
		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 20; } ];
	}
}
