import "definitions" from 'de.evoal.optimisation.core';
import "definitions" from 'de.evoal.optimisation.ea.optimisation';
import "definitions" from 'de.evoal.optimisation.gp.genetic-programming';
import "definitions" from 'gp-example';

import "data" from 'gp-example';

module example {
    specify problem 'regression-function-search' {
        search for data 'regression-function'

        map with 'unknown-function' {}

        and minimise data 'error'

        document [ 'memory-model' {} ].
    }

    configure 'evolutionary-algorithm' for 'regression-function-search' {
        'size-of-population' := 20;
        'number-of-offspring' := 20;

        'initialisation' := 'random-population' {
            method := 'ramped-half-and-half' { 'minimum-depth' := 2; 'maximum-depth' := 5; 'maximum-size' := 32; };
        };

        'parent-selection' := 'tournament-selection' { size := 3; };

        genotype := genotype {
            chromosomes := [
                'model-chromosome' {
                    features := [ data 'regression-function' ];
                    recombination := [ 'subtree-crossover' { probability := 0.9; 'internal-node-probability' := 0.9; } ];
                    mutation := [
                        'subtree-mutation' {
                            probability := 0.2;
                            method := grow { 'maximum-depth' := 4; 'maximum-size' := 16; };
                        },
                        'gaussian-mutation' { probability := 0.3; sigma := 0.02; }
                    ];
                }
            ];
        };

        replacement := 'plus-replacement' {
            selection := 'elite-selection' { count := 20; rest := 'random-selection' {}; };
        };

        'comparator' := 'numeric-comparator' {};

        'optimisation-function' := 'symbolic-regression-fitness' {
            function := data 'regression-function';
            input := [ 'variable-binding' { variable := x {}; 'data' := data 'x0'; } ];
            output := data 'y0';
            reference := "gp-example-function-data.csv";
            error := data 'error';
            measure := 'regression-error.sum-of-absolute-errors';
        };

        'candidate-checks' := [
            'maximum-size' { size := 64; reaction := 'check-reaction.resample'; },
            'uses-variable' { model := data 'regression-function'; count := 1; reaction := 'check-reaction.resample'; }
        ];

        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 20; } ];
    }
}
