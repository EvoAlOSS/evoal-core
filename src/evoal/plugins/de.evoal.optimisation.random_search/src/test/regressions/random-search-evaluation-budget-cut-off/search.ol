// Regression: random search that stops as soon as the budget of 35 evaluations runs out, in the
//   middle of iteration 3 (10 samples per iteration). The interrupted iteration keeps the population
//   of iteration 2.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.random_search.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rastrigin {};
                    reads := [data 'x:0', data 'x:1'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['candidates-per-iteration' {}, 'best-candidate-so-far' {}, 'metrics-per-iteration' {}].
    }

    configure 'random-search' for 'regression' {
        'samples-per-iteration' := 10;
        'initialisation' := 'random-population' {};
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};

        'stopping-criteria' := [
            'iteration-count' { 'maximum-iterations' := 20; },
            'evaluation-budget' {
                'maximum-evaluations' := 35;
                'exhaustion' := 'budget-exhaustion.cut-off';
            }
        ];
    }
}
