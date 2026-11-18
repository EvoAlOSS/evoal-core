import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.optimisation.local_search.optimisation;
import "definitions" from de.evoal.surrogate.optimisation;

import "definitions" from de.evoal.surrogate.adaption.density.optimisation;
import "definitions" from de.evoal.surrogate.adaption.interval.optimisation;

import "data" from surrogate;

module 'search' {
    specify problem 'example-search' {
        search for data 'x:0'

        map with 'unknown-function' {}

        and maximise data 'y:0'

        document ['candidates-per-iteration' {}, 'memory-model' {}].
    }

    configure 'local-search' for 'example-search' {
        'neighbour-choosing-strategy' := 'manual-strategy' {
            'step-size' := ['variable' { var := data 'x:0'; val := 0.2; }];
            'neighbour-order' := 'neighbour-order.fixed';
        };
        'accepting-strategy' := 'hill-climber' {};
        'initialisation' := 'specify-candidates' {
            'candidate-list' := [
                'candidate' { 'values' := ['variable' { var := data 'x:0'; val := -4.0; }]; }
            ];
            'random' := false;
        };
        'comparator' := 'numeric-comparator' {};

        'optimisation-function' := 'surrogate' {
            'model-file' := "model.pson";
            'input-space' := [data 'x:0'];
            'output-space' := [data 'y:0'];
        };

        'fitness-pipeline' := [
            'prediction-interval' {},
            'gaussian-density' {
                kind := "source-based";
                exponent := 1.0;
                'root-exponent' := 1.0;
            },
            'kernel-density' {
                kind := "source-based";
                exponent := 1.0;
                'root-exponent' := 1.0;
            }
        ];

        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 20; } ];
    }
}
