// Regression: simulated annealing near the minimum of a Rosenbrock function with additive noise
// and re-evaluation: the current candidate is evaluated once more in every iteration, so a
// neighbour is compared with the mean of all samples of the current candidate. A candidate that
// no neighbour replaces keeps collecting samples.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.local_search.optimisation;

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
                }
            ];
        }

        and minimise data 'y:0'

        document ['best-candidate-per-iteration' {}, 'memory-model' {}].
    }

    configure 'local-search' for 'regression' {
        'neighbour-choosing-strategy' := 'manual-strategy' {
            'step-size' := [
                'variable' { var := data 'x:0'; val := 0.1; },
                'variable' { var := data 'x:1'; val := 0.1; }
            ];
            'neighbour-order' := 'neighbour-order.fixed';
        };
        'accepting-strategy' := 'simulated-annealing' {
            'initial-temperature' := 0.2;
            'decreasing-function' := 'geometric-decrease' { 'decrease-rate' := 0.9; };
            'acceptance-probability' := 'exponential-probability' {};
        };
        'initialisation' := 'specify-candidates' {
            'candidate-list' := [
                'candidate' {
                    'values' := [
                        'variable' { var := data 'x:0'; val := 1.1; },
                        'variable' { var := data 'x:1'; val := 1.3; }
                    ];
                },
                'candidate' {
                    'values' := [
                        'variable' { var := data 'x:0'; val := -3.0; },
                        'variable' { var := data 'x:1'; val := 4.0; }
                    ];
                }
            ];
            'random' := false;
        };
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'noisy-function' {
            function := 'problem-function' {};
            'standard-deviation' := 0.5;
        };
        'evaluation-strategy' := 're-evaluation' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
