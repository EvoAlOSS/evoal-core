// Regression: evolutionary algorithm with the default mapping (one double chromosome with
// 'sbx-crossover' and 'polynomial-mutation'), binary tournaments as parent selection and
// survivor replacement: the two best parents survive, the remaining eight are chosen by
// tournaments, and all ten children survive.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1', data 'x:2'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rastrigin {};
                    reads := [data 'x:0', data 'x:1', data 'x:2'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['candidates-per-iteration' {}, 'best-candidate-so-far' {}, 'memory-model' { 'steps' := true; }].
    }

    configure 'evolutionary-algorithm' for 'regression' {
        'size-of-population' := 20;
        'number-of-offspring' := 10;
        'initialisation' := 'random-population' {};
        'parent-selection' := 'tournament-selection' { size := 2; };
        replacement := 'survivor-replacement' {
            selection := 'elite-selection' { count := 2; rest := 'tournament-selection' { size := 2; }; };
        };
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
