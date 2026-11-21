// Regression: two constraint checks repair the new candidates before their evaluation. The
// group 'budget' (x_0 + x_1 >= 1) is repaired by the orthogonal projection, the group 'box'
// (k_0 > 2, integer) by saturation. The memory model records the repair strategy and the
// number of attempts on the relationships of the repaired candidates, the degrees of
// violation of every individual, and the constraint evaluations.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1', data 'k:0'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rastrigin {};
                    reads := [data 'x:0', data 'x:1', data 'k:0'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['best-candidate-per-iteration' {}, 'metrics-per-iteration' {}, 'memory-model' {}].
    }

    configure 'evolutionary-algorithm' for 'regression' {
        'size-of-population' := 16;
        'number-of-offspring' := 8;
        'initialisation' := 'random-population' {};
        genotype := genotype {
            chromosomes := [
                'double-chromosome' {
                    features := [data 'x:0', data 'x:1'];
                    recombination := [ 'sbx-crossover' { probability := 0.9; 'distribution-index' := 15.0; } ];
                    mutation := [ 'polynomial-mutation' { 'distribution-index' := 20.0; 'gene-probability' := 0.5; } ];
                },
                'integer-chromosome' {
                    features := [data 'k:0'];
                    recombination := [ 'uniform-crossover' {} ];
                    mutation := [ 'random-reset-mutation' { 'gene-probability' := 0.3; } ];
                }
            ];
        };
        'parent-selection' := 'tournament-selection' { size := 2; };
        replacement := 'survivor-replacement' {
            selection := 'elite-selection' { count := 2; rest := 'tournament-selection' { size := 2; }; };
        };

        'candidate-checks' := [
            'constraint-check' {
                group := "budget";
                reaction := 'check-reaction.repair';
                repair := 'projection-repair' {};
                'repair-fallback' := 'check-reaction.warn';
                'maximum-attempts' := 3;
            },
            'constraint-check' {
                group := "box";
                reaction := 'check-reaction.repair';
                repair := 'saturation-repair' {};
                'repair-fallback' := 'check-reaction.warn';
                'maximum-attempts' := 1;
            }
        ];
        'constraint-measure' := 'exact-measure' { 'equality-tolerance' := 1.0e-4; };

        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
