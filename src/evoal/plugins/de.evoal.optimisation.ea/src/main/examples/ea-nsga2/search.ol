import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
	specify problem 'zdt1' {
		search for data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4', data 'x:5',
			data 'x:6', data 'x:7', data 'x:8', data 'x:9', data 'x:10', data 'x:11',
			data 'x:12', data 'x:13', data 'x:14', data 'x:15', data 'x:16', data 'x:17',
			data 'x:18', data 'x:19', data 'x:20', data 'x:21', data 'x:22', data 'x:23',
			data 'x:24', data 'x:25', data 'x:26', data 'x:27', data 'x:28', data 'x:29'

		map with 'benchmark-function' {
			'benchmarks' := [
				'benchmark-configuration' {
					function := zdt1 {};
					reads := [data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4', data 'x:5',
						data 'x:6', data 'x:7', data 'x:8', data 'x:9', data 'x:10', data 'x:11',
						data 'x:12', data 'x:13', data 'x:14', data 'x:15', data 'x:16', data 'x:17',
						data 'x:18', data 'x:19', data 'x:20', data 'x:21', data 'x:22', data 'x:23',
						data 'x:24', data 'x:25', data 'x:26', data 'x:27', data 'x:28', data 'x:29'];
					writes := [data 'f:1', data 'f:2'];
				}
			];
		}

		and minimise data 'f:1', minimise data 'f:2'

		// the first front of every generation, only the objectives
		document ['best-candidate-per-iteration' { 'store-search-space' := false; }].
	}

	configure 'evolutionary-algorithm' for 'zdt1' {
		'size-of-population' := 100;
		'number-of-offspring' := 100;
		'initialisation' := 'random-population' {};

		genotype := genotype {
			chromosomes := [
				'double-chromosome' {
					features := [data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4', data 'x:5',
						data 'x:6', data 'x:7', data 'x:8', data 'x:9', data 'x:10', data 'x:11',
						data 'x:12', data 'x:13', data 'x:14', data 'x:15', data 'x:16', data 'x:17',
						data 'x:18', data 'x:19', data 'x:20', data 'x:21', data 'x:22', data 'x:23',
						data 'x:24', data 'x:25', data 'x:26', data 'x:27', data 'x:28', data 'x:29'];
					// the operators of the NSGA-II paper: SBX (probability 0.9, index 20) and
					// polynomial mutation (index 20, 1 / 30 per gene)
					recombination := [ 'sbx-crossover' { probability := 0.9; 'distribution-index' := 20.0; } ];
					mutation := [ 'polynomial-mutation' { 'distribution-index' := 20.0; 'gene-probability' := 1.0 / 30.0; } ];
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
		'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 250; } ];
	}
}
