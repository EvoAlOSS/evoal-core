// Regression: roulette wheel selection and stochastic universal sampling on two objectives in
// opposite directions (minimise the Rosenbrock function, maximise the weighted sphere), scaled
// and reduced to one fitness component by a weighted sum. Both selections need a single
// fitness component, which the 'weighted-sum' step provides (#125).
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rosenbrock {};
                    reads := [data 'x:0', data 'x:1'];
                    writes := [data 'y:0'];
                },
                'benchmark-configuration' {
                    function := 'weighted-sphere' {};
                    reads := [data 'x:0', data 'x:1'];
                    writes := [data 'y:1'];
                }
            ];
        }

        and minimise data 'y:0', maximise data 'y:1'

        document ['best-candidate-per-iteration' {}, 'memory-model' {}].
    }

    configure 'evolutionary-algorithm' for 'regression' {
        'size-of-population' := 20;
        'number-of-offspring' := 10;
        'initialisation' := 'random-population' {};
        genotype := genotype {
            chromosomes := [
                'double-chromosome' {
                    features := [data 'x:0', data 'x:1'];
                    recombination := [ 'uniform-crossover' {} ];
                    mutation := [ 'gaussian-mutation' { sigma := 0.1; } ];
                }
            ];
        };
        'parent-selection' := 'roulette-wheel-selection' {};
        replacement := 'survivor-replacement' {
            selection := 'stochastic-universal-sampling' {};
        };
        'comparator' := 'numeric-comparator' {};
        'fitness-pipeline' := [
            scaling {
                references := ['variable' { var := data 'y:0'; val := 100.0; }];
            },
            'weighted-sum' {
                weights := [
                    'variable' { var := data 'y:0'; val := 2.0; },
                    'variable' { var := data 'y:1'; val := 1.0; }
                ];
            }
        ];
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
