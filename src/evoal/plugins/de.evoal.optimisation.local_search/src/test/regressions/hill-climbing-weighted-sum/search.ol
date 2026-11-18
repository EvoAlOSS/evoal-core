// Regression: hill climbing with two objectives in opposite directions (minimise the
// Rosenbrock function, maximise the weighted sphere), scaled and reduced to one fitness
// component by a normalised weighted sum. The memory model shows the fitness component
// 'weighted-sum', which belongs to no goal.
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
                },
                'benchmark-configuration' {
                    function := 'weighted-sphere' {};
                    reads := [data 'x:0', data 'x:1'];
                    writes := [data 'y:1'];
                }
            ];
        }

        and minimise data 'y:0', maximise data 'y:1'

        document ['candidates-per-iteration' {}, 'best-candidate-per-iteration' {}, 'memory-model' {}].
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
