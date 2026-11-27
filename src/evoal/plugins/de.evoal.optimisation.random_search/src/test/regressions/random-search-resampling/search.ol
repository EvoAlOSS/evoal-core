// Regression: random search on a Rastrigin function with multiplicative noise and resampling:
// every candidate is evaluated 3 times and its objective is the median of the samples. The cut-off budget of 100
// evaluations covers 3 iterations of 10 candidates and 3 whole candidates of the fourth.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.random_search.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rastrigin {};
                    reads := [data 'x:0', data 'x:1'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['best-candidate-per-iteration' {}, 'memory-model' {}].
    }

    configure 'random-search' for 'regression' {
        'samples-per-iteration' := 10;
        'initialisation' := 'random-population' {};
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'noisy-function' {
            function := 'problem-function' {};
            noise := 'noise-model.multiplicative';
            'standard-deviation' := 0.2;
        };
        'evaluation-strategy' := 'resampling' {
            samples := 3;
            aggregation := 'sample-aggregation.median';
        };

        'stopping-criteria' := [
            'iteration-count' { 'maximum-iterations' := 10; },
            'evaluation-budget' { 'maximum-evaluations' := 100; 'exhaustion' := 'budget-exhaustion.cut-off'; }
        ];
    }
}
