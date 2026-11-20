// Regression: correlation-aware mutation (depth 2) and linkage crossover across a double and
// an integer chromosome. The memory model records the primary, propagated and linked features.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1', data 'k:0'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rastrigin {};
                    reads := [data 'x:0', data 'x:1', data 'k:0'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['best-candidate-per-iteration' {}, 'correlation-statistics' { 'covariance-difference' := true; }, 'memory-model' {}].
    }

    configure 'evolutionary-algorithm' for 'regression' {
        'size-of-population' := 16;
        'number-of-offspring' := 8;
        'initialisation' := 'random-population' {};
        genotype := genotype {
            chromosomes := [
                'double-chromosome' {
                    features := [data 'x:0', data 'x:1'];
                    recombination := [
                        'linkage-crossover' {
                            crossover := 'single-point-crossover' { probability := 0.9; };
                            'minimum-correlation' := 0.5;
                        }
                    ];
                    mutation := [
                        'correlation-aware-mutation' {
                            mutation := 'gaussian-mutation' { sigma := 0.5; 'gene-probability' := 0.5; };
                            'minimum-correlation' := 0.0;
                            'propagation-depth' := 2;
                        }
                    ];
                },
                'integer-chromosome' {
                    features := [data 'k:0'];
                    recombination := [ 'uniform-crossover' { probability := 0.9; 'swap-probability' := 0.5; } ];
                    mutation := [ 'random-reset-mutation' { 'gene-probability' := 0.3; } ];
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
