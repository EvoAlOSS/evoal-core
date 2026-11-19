// Regression: hill climbing with the feasibility rules ('feasibility-comparator') outside the
// evolutionary algorithm. The start candidate (2, 5) violates the constraint group 'disc', so
// the search first reduces the violation; once inside the disc, it minimises Rosenbrock. The
// memory model records the degree of violation of every individual.
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.local_search.optimisation;

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

        document ['best-candidate-per-iteration' {}, 'memory-model' {}].
    }

    configure 'local-search' for 'regression' {
        'neighbour-choosing-strategy' := 'manual-strategy' {
            'step-size' := [
                'variable' { var := data 'x:0'; val := 0.25; },
                'variable' { var := data 'x:1'; val := 0.25; }
            ];
            'neighbour-order' := 'neighbour-order.fixed';
        };
        'accepting-strategy' := 'hill-climber' {};
        'initialisation' := 'specify-candidates' {
            'candidate-list' := [
                'candidate' {
                    'values' := [
                        'variable' { var := data 'x:0'; val := 2.0; },
                        'variable' { var := data 'x:1'; val := 5.0; }
                    ];
                }
            ];
            'random' := false;
        };
        'constraint-measure' := 'exact-measure' { 'equality-tolerance' := 1.0e-4; };
        'comparator' := 'feasibility-comparator' { group := "disc"; };
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 25; } ];
    }
}
