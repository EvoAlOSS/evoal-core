// Regression: (mu, lambda) replacement with Boltzmann selection from 30 children, exponential
// ranking as parent selection, two-point crossover, random reset mutation and wrapping at the
// boundaries.
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
        'size-of-population' := 15;
        'number-of-offspring' := 30;
        'initialisation' := 'random-population' {};
        'parent-selection' := 'exponential-ranking-selection' { 'c' := 0.9; };
        recombination := [ 'multi-point-crossover' { points := 2; } ];
        mutation := [ 'random-reset-mutation' { probability := 0.5; } ];
        replacement := 'comma-replacement' {
            selection := 'boltzmann-selection' { temperature := 5.0; };
        };
        'boundary-handling' := 'boundary-handling.wrap';
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
