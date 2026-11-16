// Regression: basic mover that stops as soon as the budget of 40 evaluations runs out
//   (9 particles: in generation 4, 4 particles are evaluated and 5 undo their move).
import "definitions" from de.evoal.core.math;

import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.base;
import "definitions" from de.evoal.pipeline.benchmarks;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.pso.optimisation;

import "data" from 'search';

module 'search' {
    specify problem 'regression' {
        search for data 'x:0', data 'x:1'

        map with 'benchmark-function' {
            'benchmarks' := [
                'benchmark-configuration' {
                    function := ackley {};
                    reads := [data 'x:0', data 'x:1'];
                    writes := [data 'y:0'];
                }
            ];
        }

        and minimise data 'y:0'

        document ['candidates-per-iteration' {}, 'best-candidate-per-iteration' {}, 'metrics-per-iteration' {}].
    }

    configure 'particle-swarm-optimisation' for 'regression' {
        'number-of-generations' := 10;
        'size-of-population' := 9;
        'neighborhood-size' := 3;
        'swarm' := 'default-swarm' {};
        'mover' := 'basic-mover' {
            'inertia-start' := 0.75;
            'inertia-end' := 0.25;
            'c1' := 2.05;
            'c2' := 2.05;
            'boundary-type' := 'boundary-handling.wrap';
        };
        'topology' := 'topology.global';
        'initialisation' := 'random-population' {};
        'comparator' := 'numeric-comparator' {};
        'optimisation-function' := 'problem-function' {};
        'stopping-criteria' := [
            'iteration-count' { 'maximum-iterations' := 10; },
            'evaluation-budget' {
                'maximum-evaluations' := 40;
                'exhaustion' := 'budget-exhaustion.cut-off';
            }
        ];
    }
}
