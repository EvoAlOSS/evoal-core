// Regression: sep-CMA-ES (diagonal covariance matrix) with IPOP restarts on the weighted sphere.
// A constraint check resamples candidates that violate x_0 + x_1 >= 1; a coarse 'tol-x' ends
// the first CMA-ES run, so one restart with the doubled population occurs. The memory model
// records the candidates with their CMA-ES run and the genotype of those that the bounds
// changed.
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
        'restart-strategy' := 'ipop-restart' { 'maximum-restarts' := 1; };
        termination := 'cma-es-termination' { 'tol-x' := 0.4; };
        'initialisation' := 'random-population' {};
        'candidate-checks' := [
            'constraint-check' {
                group := "budget";
                reaction := 'check-reaction.resample';
                'maximum-attempts' := 5;
            }
        ];
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};

        'stopping-criteria' := [
            'iteration-count' { 'maximum-iterations' := 30; }
        ];
    }
}
