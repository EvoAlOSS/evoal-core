// Problem module of the regression hill-climbing-imported-problem: the problem of the regression
// hill-climbing in a module of its own.
import "definitions" from 'de.evoal.core.math';

import "definitions" from 'de.evoal.optimisation.core';
import "definitions" from 'de.evoal.pipeline.base';
import "definitions" from 'de.evoal.pipeline.benchmarks';
import "definitions" from 'de.evoal.pipeline.optimisation';
import "definitions" from 'de.evoal.optimisation.local_search.optimisation';

import "data" from 'search';

module benchmark {
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

        document ['candidates-per-iteration' {}, 'best-candidate-per-iteration' {}].
    }
}
