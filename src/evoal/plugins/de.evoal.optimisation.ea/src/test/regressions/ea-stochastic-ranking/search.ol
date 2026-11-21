// Regression: stochastic ranking (Runarsson and Yao 2000) as the survivor selection of a
// (10, 40) comma replacement, as in the paper's (mu, lambda) evolution strategy, on Rosenbrock
// with two constraints in the group 'region'. The memory model records the place of every
// ranked candidate (property 'stochastic-rank'), the degrees of violation and the metrics of
// the rankings (sweeps, comparisons decided by the fitness or by the penalty).
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rosenbrock {};
                    reads := [data 'x:0', data 'x:1'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['best-candidate-per-iteration' {}, 'metrics-per-iteration' {}, 'memory-model' {}].
    }

    configure 'evolutionary-algorithm' for 'regression' {
        'size-of-population' := 10;
        'number-of-offspring' := 40;
        'initialisation' := 'random-population' {};
        genotype := genotype {
            chromosomes := [
                'double-chromosome' {
                    features := [data 'x:0', data 'x:1'];
                    recombination := [];
                    mutation := [ 'gaussian-mutation' { sigma := 0.05; 'gene-probability' := 1.0; } ];
                }
            ];
        };
        'parent-selection' := 'random-selection' {};
        replacement := 'comma-replacement' {
            selection := 'stochastic-ranking-selection' {
                group := "region";
                'fitness-probability' := 0.45;
                penalty := 'stochastic-ranking-penalty.squared-sum';
            };
        };

        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 15; } ];
    }
}
