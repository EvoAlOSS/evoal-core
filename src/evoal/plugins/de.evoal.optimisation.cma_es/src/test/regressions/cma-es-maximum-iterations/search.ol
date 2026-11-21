// Regression: IPOP-CMA-ES with an iteration limit per CMA-ES run on the weighted sphere. With
// n = 2, 'quadratic-iteration-limit' { a = 10, b = 1 } gives L = 10 + 25 / sqrt(lambda): the
// runs with lambda 6, 12, 24 and 48 end after 21, 18, 16 and 14 iterations, before any other
// criterion of CMA-ES holds. The memory model records the CMA-ES run of every candidate.
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
                    function := 'weighted-sphere' {};
                    reads := [data 'x:0', data 'x:1'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['best-candidate-per-iteration' {}, 'memory-model' {}].
    }

    configure 'cma-es' for 'regression' {
        'initial-step-size' := 1.0;
        'covariance-model' := 'full-covariance' {};
        'restart-strategy' := 'ipop-restart' { 'maximum-restarts' := 3; };
        termination := 'cma-es-termination' {
            'maximum-iterations' := 'quadratic-iteration-limit' { 'a' := 10.0; 'b' := 1.0; };
        };
        'initialisation' := 'random-population' {};
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};

        'stopping-criteria' := [
            'iteration-count' { 'maximum-iterations' := 80; }
        ];
    }
}
