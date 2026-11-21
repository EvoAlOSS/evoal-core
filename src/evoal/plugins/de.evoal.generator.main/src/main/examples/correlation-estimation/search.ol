// Minimises the Ackley function with correlation-aware operators that use the correlations
// estimated from data by estimate.generator, see README.md.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

// the estimated correlations: their constraints belong to the problem of this module
import "data" from 'estimated-correlations';

module 'search' {
	specify problem 'example-search-with-estimated-correlations' {
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
			'correlation-statistics' { 'empirical-correlation' := true; 'covariance-difference' := false; }
		].
	}

	configure 'evolutionary-algorithm' for 'example-search-with-estimated-correlations' {
		'size-of-population' := 20;
		'number-of-offspring' := 20;
		'initialisation' := 'random-population' {};

		genotype := genotype {
			chromosomes := [
				'double-chromosome' {
					features := [data 'x:0', data 'x:1', data 'x:2'];
					recombination := [
						'linkage-crossover' {
							crossover := 'uniform-crossover' { probability := 0.9; 'swap-probability' := 0.5; };
							'minimum-correlation' := 0.5;
						}
					];
					mutation := [
						'correlation-aware-mutation' {
							mutation := 'polynomial-mutation' { 'distribution-index' := 20.0; 'gene-probability' := 0.3; };
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
