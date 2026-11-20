// Regression: hill climbing from a fixed start candidate that stops when the best candidate so far
//   falls below the target value 3 (iteration 9: 2.0), before it ends in the local optimum 1.0
//   (iteration 11) and before the iteration limit of 100.
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

        document ['candidates-per-iteration' {}, 'best-candidate-so-far' {}].
    }

    configure 'local-search' for 'regression' {
        'neighbour-choosing-strategy' := 'manual-strategy' {
            'step-size' := [
                'variable' { var := data 'x:0'; val := 0.1; },
                'variable' { var := data 'x:1'; val := 0.1; }
            ];
            'neighbour-order' := 'neighbour-order.fixed';
        };
        'accepting-strategy' := 'hill-climber' {};
        'initialisation' := 'specify-candidates' {
            'candidate-list' := [
                'candidate' {
                    'values' := [
                        'variable' { var := data 'x:0'; val := 2.0; },
                        'variable' { var := data 'x:1'; val := 5.0; }
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
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [
            'iteration-count' { 'maximum-iterations' := 100; },
            'target-value' { 'objective' := data 'y:0'; 'target' := 3.0; }
        ];
    }
}
