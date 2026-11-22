// Regression: hill climbing on a Gaussian process surrogate whose minimised prediction is
// adapted by the width of its prediction interval ŷ ± z · σ, with the predictive standard
// deviation σ of the model (former formula, see #288).
// model.pson is the Gaussian process of the example training.gaussianprocess (Forrester
// function, training data with a gap (0.6, 0.9)); the search starts in the gap.
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
                'candidate' { 'values' := ['variable' { var := data 'x:0'; val := 0.75; }]; }
            ];
            'random' := false;
        };
        'comparator' := 'numeric-comparator' {};

        'optimisation-function' := 'surrogate' {
            'model-file' := "model.pson";
            'input-space' := [data 'x:0'];
            'output-space' := [data 'y:0'];
        };

        'fitness-pipeline' := ['prediction-interval' {}];

        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
