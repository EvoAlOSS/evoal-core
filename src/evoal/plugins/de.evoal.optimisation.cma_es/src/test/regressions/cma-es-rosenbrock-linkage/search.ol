// Regression: CMA-ES with a full covariance matrix on Rosenbrock without restarts. The memory
// model records the distribution of every iteration and the correlations it implies for the
// building block and the correlation of the DDL; 'learned-linkage' compares them.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from 'de.evoal.optimisation.cma_es.optimisation';

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1', data 'x:2'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rosenbrock {};
                    reads := [data 'x:0', data 'x:1', data 'x:2'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['best-candidate-per-iteration' {}, 'learned-linkage' {}, 'memory-model' {}].
    }

    configure 'cma-es' for 'regression' {
        'initial-step-size' := 1.0;
        'covariance-model' := 'full-covariance' {};
        'restart-strategy' := 'no-restart' {};
        termination := 'cma-es-termination' {};
        'initialisation' := 'random-population' {};
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};

        'stopping-criteria' := [
            'iteration-count' { 'maximum-iterations' := 8; }
        ];
    }
}
