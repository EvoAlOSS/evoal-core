// Regression: (mu + lambda) replacement that keeps the 20 best of parents and children, with
// random parent selection, single-point crossover, Gaussian mutation and
// bouncing at the boundaries.
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
        'number-of-offspring' := 20;
        'initialisation' := 'random-population' {};
        'parent-selection' := 'random-selection' {};
        genotype := genotype {
            chromosomes := [
                'double-chromosome' {
                    features := [data 'x:0', data 'x:1', data 'x:2'];
                    recombination := [ 'single-point-crossover' { probability := 0.8; } ];
                    mutation := [ 'gaussian-mutation' { 'gene-probability' := 0.5; sigma := 0.2; } ];
                }
            ];
        };
        replacement := 'plus-replacement' {
            selection := 'elite-selection' { count := 20; rest := 'random-selection' {}; };
        };
        'boundary-handling' := 'boundary-handling.bounce';
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
