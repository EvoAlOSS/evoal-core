// Regression: the elite of a (mu + lambda) replacement survives unchanged and grows old; the
// candidate check 'maximum-age' replaces a candidate that survived more than 3 generations by
// a random one. Linear ranking selects the parents, truncation the rest of the survivors.
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
        'size-of-population' := 10;
        'number-of-offspring' := 10;
        'initialisation' := 'random-population' {};
        'parent-selection' := 'linear-ranking-selection' { 'eta-minus' := 0.5; };
        replacement := 'plus-replacement' {
            selection := 'elite-selection' { count := 2; rest := 'truncation-selection' { threshold := 0.5; }; };
        };
        'candidate-checks' := [
            'maximum-age' { iterations := 3; reaction := 'check-reaction.replace'; }
        ];
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 12; } ];
    }
}
