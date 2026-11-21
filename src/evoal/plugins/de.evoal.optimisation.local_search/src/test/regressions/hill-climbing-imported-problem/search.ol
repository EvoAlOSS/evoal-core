// Regression: hill climbing from a fixed start candidate, with the problem from the imported module
// benchmark; the reference is the one of the regression hill-climbing.
import "definitions" from 'de.evoal.core.math';

import "definitions" from 'de.evoal.optimisation.core';
import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from 'de.evoal.pipeline.benchmarks';
import "definitions" from 'de.evoal.pipeline.optimisation';
import "definitions" from 'de.evoal.optimisation.local_search.optimisation';

import "data" from 'search';

import "optimisation" from 'benchmark';

module 'search' {
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
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
