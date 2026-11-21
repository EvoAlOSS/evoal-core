// CMA-ES on the Rosenbrock function with IPOP restarts, see README.md.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from 'de.evoal.optimisation.cma_es.optimisation';

import "data" from 'search';

module 'search' {
    specify problem 'rosenbrock' {
        search for data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rosenbrock {};
                    reads := [data 'x:0', data 'x:1', data 'x:2', data 'x:3', data 'x:4'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['best-candidate-per-iteration' {}, 'metrics-per-iteration' {}, 'learned-linkage' {}].
    }

    configure 'cma-es' for 'rosenbrock' {
        'initial-step-size' := 3.0;
        'covariance-model' := 'full-covariance' {};
        'restart-strategy' := 'ipop-restart' { 'population-factor' := 2.0; };
        termination := 'cma-es-termination' {};
        'initialisation' := 'random-population' {};
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};

        'stopping-criteria' := [
            'evaluation-budget' { 'maximum-evaluations' := 5000; 'exhaustion' := 'budget-exhaustion.cut-off'; },
            'target-value' { 'objective' := data 'y:0'; 'target' := 1.0e-10; }
        ];
    }
}
