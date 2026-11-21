// Regression: linkage crossover with building blocks, two of them overlapping in x:2, and a
// correlation; x:0 to x:2 use the linkage crossover, x:3 to x:5 a plain uniform crossover. The
// memory model records the linked features and the linkage metrics, 'linkage-statistics' the
// rates.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4', data 'x:5'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rastrigin {};
                    reads := [data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4', data 'x:5'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['best-candidate-per-iteration' {}, 'linkage-statistics' {}, 'memory-model' {}].
    }

    configure 'evolutionary-algorithm' for 'regression' {
        'size-of-population' := 16;
        'number-of-offspring' := 8;
        'initialisation' := 'random-population' {};
        genotype := genotype {
            chromosomes := [
                'double-chromosome' {
                    features := [data 'x:0', data 'x:1', data 'x:2'];
                    recombination := [
                        'linkage-crossover' {
                            crossover := 'uniform-crossover' { probability := 0.9; 'swap-probability' := 0.5; };
                            'minimum-correlation' := 0.0;
                        }
                    ];
                    mutation := [ 'gaussian-mutation' { sigma := 0.5; 'gene-probability' := 0.3; } ];
                },
                'double-chromosome' {
                    features := [data 'x:3', data 'x:4', data 'x:5'];
                    recombination := [ 'uniform-crossover' { probability := 0.9; 'swap-probability' := 0.5; } ];
                    mutation := [ 'gaussian-mutation' { sigma := 0.5; 'gene-probability' := 0.3; } ];
                }
            ];
        };
        'parent-selection' := 'tournament-selection' { size := 2; };
        replacement := 'survivor-replacement' {
            selection := 'elite-selection' { count := 2; rest := 'tournament-selection' { size := 2; }; };
        };

        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
