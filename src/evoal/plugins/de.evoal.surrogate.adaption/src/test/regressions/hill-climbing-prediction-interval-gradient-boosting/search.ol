// Regression: hill climbing on a gradient boosting surrogate whose minimised prediction is
// adapted by the width of the prediction interval that the model predicts (coverage 0.9).
// model.onnx is the model of the example training.gradient-boosting (Forrester function with
// noise that grows with x:0; z-score of y:0, so both bounds go through the steps after the
// prediction). The search starts at 0.5, where the interval widens to the right.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.optimisation.local_search.optimisation;
import "definitions" from de.evoal.surrogate.optimisation;

import "definitions" from de.evoal.surrogate.adaption.density.optimisation;
import "definitions" from de.evoal.surrogate.adaption.interval.optimisation;

import "data" from surrogate;

module 'search' {
    specify problem 'regression' {
        search for data 'x:0'

        map with 'unknown-function' {}

        and minimise data 'y:0'

        document ['candidates-per-iteration' {}, 'memory-model' {}].
    }

    configure 'local-search' for 'regression' {
        'neighbour-choosing-strategy' := 'manual-strategy' {
            'step-size' := ['variable' { var := data 'x:0'; val := 0.05; }];
            'neighbour-order' := 'neighbour-order.fixed';
        };
        'accepting-strategy' := 'hill-climber' {};
        'initialisation' := 'specify-candidates' {
            'candidate-list' := [
                'candidate' { 'values' := ['variable' { var := data 'x:0'; val := 0.5; }]; }
            ];
            'random' := false;
        };
        'comparator' := 'numeric-comparator' {};

        'optimisation-function' := 'surrogate' {
            'model-file' := "model.onnx";
            'input-space' := [data 'x:0'];
            'output-space' := [data 'y:0'];
        };

        'fitness-pipeline' := ['prediction-interval' {}];

        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
