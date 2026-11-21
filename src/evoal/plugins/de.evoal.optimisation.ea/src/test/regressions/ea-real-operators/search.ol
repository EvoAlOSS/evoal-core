// Regression: the real-valued crossovers BLX-alpha, line and arithmetic crossover on a double
// chromosome with a single-choice mutation that chooses between Gaussian and polynomial
// mutation, and an integer chromosome with uniform crossover and creep mutation.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1', data 'n:0'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rastrigin {};
                    reads := [data 'x:0', data 'x:1', data 'n:0'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['candidates-per-iteration' {}, 'best-candidate-so-far' {}, 'memory-model' { 'steps' := true; }].
    }

    configure 'evolutionary-algorithm' for 'regression' {
        'size-of-population' := 20;
        'number-of-offspring' := 10;
        'initialisation' := 'random-population' {};
        genotype := genotype {
            chromosomes := [
                'double-chromosome' {
                    features := [data 'x:0', data 'x:1'];
                    recombination := [
                        'blx-alpha-crossover' { probability := 0.5; alpha := 0.5; },
                        'line-crossover' { probability := 0.3; extension := 0.25; },
                        'arithmetic-crossover' { probability := 0.2; alpha := 0.3; }
                    ];
                    mutation := [
                        'single-choice-mutation' {
                            probability := 0.6;
                            children := [ 'gaussian-mutation' { sigma := 0.05; }, 'polynomial-mutation' {} ];
                            weights := [2.0, 1.0];
                        }
                    ];
                },
                'integer-chromosome' {
                    features := [data 'n:0'];
                    recombination := [ 'uniform-crossover' {} ];
                    mutation := [ 'creep-mutation' { step := 2; 'gene-probability' := 0.5; } ];
                }
            ];
        };
        'parent-selection' := 'tournament-selection' { size := 3; };
        replacement := 'survivor-replacement' {
            selection := 'elite-selection' { count := 2; rest := 'tournament-selection' { size := 2; }; };
        };
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
