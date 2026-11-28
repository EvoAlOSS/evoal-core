// Regression: an EA on 2048 policies whose classes come from an Ecore metamodel in two files
// (policy.ecore, conditions.ecore; @EcoreType in search.ddl). The model chromosome is changed by
// subtree crossover, subtree, array size and array reorder mutations and the value mutations
// random reset, creep (the ordinal direction of 'ScoreGain') and bit flip. The metamodel has
// restricted integer types with facets, an optional containment and an unsettable attribute
// ('optional-probability'), a container reference and a derived attribute, which are not
// searched. The deterministic 'model-measures' fitness maximises the size of the policy;
// 'model-xmi' writes the best policy so far as XMI whenever it changes.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'policies' {
        search for data 'policy'

        map with 'unknown-function' {}

        and maximise data 'size'

        document [
            'memory-model' {},
            'model-xmi' { feature := data 'policy'; candidates := 'model-candidates.best-so-far'; }
        ].
    }

    configure 'evolutionary-algorithm' for 'policies' {
        'size-of-population' := 12;
        'number-of-offspring' := 12;
        'initialisation' := 'random-population' {
            method := 'ramped-half-and-half' { 'minimum-depth' := 5; 'maximum-depth' := 6; 'maximum-size' := 20; 'optional-probability' := 0.5; };
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
                            method := grow { 'maximum-depth' := 5; 'maximum-size' := 30; 'optional-probability' := 0.5; };
                        },
                        'array-size-mutation' {
                            probability := 0.3;
                            method := grow { 'maximum-depth' := 5; 'maximum-size' := 30; 'optional-probability' := 0.5; };
                        },
                        'array-reorder-mutation' { probability := 0.2; },
                        'random-reset-mutation' { probability := 0.5; },
                        'creep-mutation' { probability := 0.3; },
                        'bit-flip-mutation' { probability := 0.3; }
                    ];
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
                depth := 6;
                reaction := 'check-reaction.repair';
            }
        ];
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
