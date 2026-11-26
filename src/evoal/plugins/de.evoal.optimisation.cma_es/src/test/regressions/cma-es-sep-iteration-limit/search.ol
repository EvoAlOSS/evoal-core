// Regression: IPOP-SEP-CMA-ES (diagonal covariance matrix) with an iteration limit per CMA-ES
// run on the weighted sphere. With n = 4, the default population size is 8 and
// 'sep-iteration-limit' { a = 10, b = 2 } gives L = 10 + 16 / sqrt(lambda): the runs with
// lambda 8, 16, 32 and 64 end after 16, 14, 13 and 12 iterations, before any other criterion
// of CMA-ES holds. The memory model records the CMA-ES run of every candidate.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from 'de.evoal.optimisation.cma_es.optimisation';

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1', data 'x:2', data 'x:3'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := 'weighted-sphere' {};
                    reads := [data 'x:0', data 'x:1', data 'x:2', data 'x:3'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['best-candidate-per-iteration' {}, 'memory-model' {}].
    }

    configure 'cma-es' for 'regression' {
        'initial-step-size' := 1.0;
        'covariance-model' := 'diagonal-covariance' {};
        'restart-strategy' := 'ipop-restart' { 'maximum-restarts' := 3; };
        termination := 'cma-es-termination' {
            'maximum-iterations' := 'sep-iteration-limit' { 'a' := 10.0; 'b' := 2.0; };
        };
        'initialisation' := 'random-population' {};
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};

        'stopping-criteria' := [
            'iteration-count' { 'maximum-iterations' := 80; }
        ];
    }
}
