// Regression: BIPOP-CMA-ES on Rastrigin. A coarse 'tol-fun' and 'tol-x' end the CMA-ES runs early, so the
// restarts of both regimes occur within the budget; the budget ends in the middle of an
// iteration ('cut-off'). The metrics show the step size, the population size and the number
// of the CMA-ES run of every iteration.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from 'de.evoal.optimisation.cma_es.optimisation';

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

        document ['best-candidate-so-far' {}, 'metrics-per-iteration' {}].
    }

    configure 'cma-es' for 'regression' {
        'initial-step-size' := 2.0;
        'covariance-model' := 'full-covariance' {};
        'restart-strategy' := 'bipop-restart' { 'population-factor' := 2.0; 'maximum-restarts' := 3; };
        termination := 'cma-es-termination' { 'tol-fun' := 0.5; 'tol-x' := 0.05; };
        'initialisation' := 'random-population' {};
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};

        'stopping-criteria' := [
            'evaluation-budget' { 'maximum-evaluations' := 1200; 'exhaustion' := 'budget-exhaustion.cut-off'; },
            'iteration-count' { 'maximum-iterations' := 1000; }
        ];
    }
}
