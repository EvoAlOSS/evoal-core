// Regression: a genotype with a Gray-coded chromosome (a real and an integer feature), an
// integer chromosome and a bit chromosome (a boolean). Every chromosome has a uniform
// crossover; the Gray and bit chromosomes are mutated by bit flips, the integer chromosome by
// random resets. Roulette wheel selection selects the parents,
// stochastic universal sampling the survivors.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'n:0', data 'k:0', data 'b:0'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rastrigin {};
                    reads := [data 'x:0', data 'n:0', data 'k:0'];
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
        genotype := genotype {
            chromosomes := [
                'gray-chromosome' {
                    features := [data 'x:0', data 'n:0'];
                    precision := 12;
                    recombination := [ 'uniform-crossover' {} ];
                    mutation := [ 'bit-flip-mutation' {} ];
                },
                'integer-chromosome' {
                    features := [data 'k:0'];
                    recombination := [ 'uniform-crossover' {} ];
                    mutation := [ 'random-reset-mutation' { 'gene-probability' := 0.3; } ];
                },
                'bit-chromosome' {
                    features := [data 'b:0'];
                    recombination := [ 'uniform-crossover' {} ];
                    mutation := [ 'bit-flip-mutation' {} ];
                }
            ];
        };
        'parent-selection' := 'roulette-wheel-selection' {};
        replacement := 'survivor-replacement' {
            selection := 'stochastic-universal-sampling' {};
        };
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 10; } ];
    }
}
