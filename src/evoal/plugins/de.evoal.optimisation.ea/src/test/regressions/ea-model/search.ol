// Regression: an EA on 2048 policies (models) and a real weight. The genotype combines a
// model chromosome, changed by subtree crossover, subtree, array size and array reorder
// mutations and the value mutations random reset, creep (the ordinal operator enum) and bit
// flip, with a double chromosome. The deterministic 'model-measures' fitness maximises the
// size of the policy, so the candidates run against the size limit and the 'maximum-size'
// check repairs them; 'maximum-depth' repairs the trees that get too deep.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'policies' {
        search for data 'policy', data 'weight'

        map with 'unknown-function' {}

        and maximise data 'size'

        document ['memory-model' {}].
    }

    configure 'evolutionary-algorithm' for 'policies' {
        'size-of-population' := 12;
        'number-of-offspring' := 12;
        'initialisation' := 'random-population' {
            method := 'ramped-half-and-half' { 'minimum-depth' := 5; 'maximum-depth' := 5; 'maximum-size' := 20; };
        };
        'parent-selection' := 'tournament-selection' { size := 2; };
        genotype := genotype {
            chromosomes := [
                'model-chromosome' {
                    features := [data 'policy'];
                    recombination := [ 'subtree-crossover' { probability := 0.8; 'internal-node-probability' := 0.9; } ];
                    mutation := [
                        'subtree-mutation' {
                            probability := 0.3;
                            method := grow { 'maximum-depth' := 5; 'maximum-size' := 30; };
                        },
                        'array-size-mutation' {
                            probability := 0.3;
                            method := grow { 'maximum-depth' := 5; 'maximum-size' := 30; };
                        },
                        'array-reorder-mutation' { probability := 0.2; },
                        'random-reset-mutation' { probability := 0.5; },
                        'creep-mutation' { probability := 0.3; },
                        'bit-flip-mutation' { probability := 0.3; }
                    ];
                },
                'double-chromosome' {
                    features := [data 'weight'];
                    recombination := [];
                    mutation := [ 'gaussian-mutation' { sigma := 0.2; } ];
                }
            ];
        };
        replacement := 'plus-replacement' {
            selection := 'elite-selection' { count := 12; rest := 'random-selection' {}; };
        };
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'model-measures' { model := data 'policy'; size := data 'size'; };
        'candidate-checks' := [
            'maximum-size' {
                size := 25;
                reaction := 'check-reaction.repair';
                'maximum-attempts' := 2;
            },
            'maximum-depth' {
                depth := 5;
                reaction := 'check-reaction.repair';
            }
        ];
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
