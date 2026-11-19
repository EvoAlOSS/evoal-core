// Regression: simulated annealing that starts in the optimum at a low temperature, so most
// neighbours are rejected and the candidate grows old. The check 'maximum-age' replaces a
// candidate that was kept for more than 3 iterations by a random one (random restart). The
// memory model shows the replacements and the check steps.
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

        document ['candidates-per-iteration' {}, 'best-candidate-so-far' {}, 'memory-model' { 'steps' := true; }].
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
            'initial-temperature' := 0.1;
            'decreasing-function' := 'geometric-decrease' { 'decrease-rate' := 0.9; };
            'acceptance-probability' := 'exponential-probability' {};
        };
        'initialisation' := 'specify-candidates' {
            'candidate-list' := [
                'candidate' {
                    'values' := [
                        'variable' { var := data 'x:0'; val := 1.0; },
                        'variable' { var := data 'x:1'; val := 1.0; }
                    ];
                }
            ];
            'random' := false;
        };
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};
        'candidate-checks' := [
            'maximum-age' {
                iterations := 3;
                reaction := 'check-reaction.replace';
                'replacement-source' := 'random-population' {};
            }
        ];
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 20; } ];
    }
}
