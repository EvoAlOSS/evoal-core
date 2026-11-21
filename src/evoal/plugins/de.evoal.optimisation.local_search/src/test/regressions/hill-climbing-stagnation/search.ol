// Regression: hill climbing on the Rosenbrock function that stops when the best fitness has
// not improved by more than 15 for 2 iterations ('stagnation'): after iteration 8, before the
// hill climber reaches its local optimum (iteration 11) and long before the safety limit of
// 200 iterations. The improvements from 65 to 50 and from 37 to 26 are too small; the next
// values count against the old reference. The memory model shows the stopping criteria in
// execution-information.json.
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
        'accepting-strategy' := 'hill-climber' {};
        'initialisation' := 'specify-candidates' {
            'candidate-list' := [
                'candidate' {
                    'values' := [
                        'variable' { var := data 'x:0'; val := 2.0; },
                        'variable' { var := data 'x:1'; val := 5.0; }
                    ];
                }
            ];
            'random' := false;
        };
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [
            'iteration-count' { 'maximum-iterations' := 200; },
            'stagnation' {
                'iterations' := 2;
                'absolute-tolerance' := 15.0;
                'measure' := 'best-fitness' {};
            }
        ];
    }
}
