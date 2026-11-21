// Regression: the literature of a run (citations.bib). The configuration uses the linkage
// crossover with a building block of the DDL and the epsilon-level comparison, so the citations
// list the EvoAl paper, Harik and Goldberg 1997, Takahama and Sakai 2006 and the sources of the
// other types (uniform crossover, Gaussian mutation, tournament selection, Rastrigin), each once.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.ea.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1', data 'x:2', data 'x:3'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := rastrigin {};
                    reads := [data 'x:0', data 'x:1', data 'x:2', data 'x:3'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['best-candidate-per-iteration' {}].
    }

    configure 'evolutionary-algorithm' for 'regression' {
        'size-of-population' := 8;
        'number-of-offspring' := 8;
        'initialisation' := 'random-population' {};
        genotype := genotype {
            chromosomes := [
                'double-chromosome' {
                    features := [data 'x:0', data 'x:1', data 'x:2', data 'x:3'];
                    recombination := [
                        'linkage-crossover' {
                            crossover := 'uniform-crossover' { probability := 0.9; 'swap-probability' := 0.5; };
                            'minimum-correlation' := 0.0;
                        }
                    ];
                    mutation := [ 'gaussian-mutation' { sigma := 0.5; 'gene-probability' := 0.25; } ];
                }
            ];
        };
        'parent-selection' := 'tournament-selection' { size := 2; };
        replacement := 'plus-replacement' { selection := 'truncation-selection' { threshold := 0.5; }; };
        'constraint-measure' := 'exact-measure' { 'equality-tolerance' := 1.0e-4; };

        'comparator' := 'epsilon-comparator' { group := "budget"; epsilon := 0.1; };
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 3; } ];
    }
}
