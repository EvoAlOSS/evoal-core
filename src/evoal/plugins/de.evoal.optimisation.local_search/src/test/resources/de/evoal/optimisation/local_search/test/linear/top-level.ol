import "definitions" from de.evoal.optimisation.core;
import "definitions" from de.evoal.pipeline.optimisation;
import "definitions" from de.evoal.optimisation.local_search.optimisation;

import "data" from 'de.evoal.optimisation.local_search.test.linear.data';

module de.evoal.optimisation.local_search.test.linear.top_level {
    specify problem 'p' {
        search for data 'x'

        map with 'benchmark-function' {}

        and minimise data 'y'
    }

    configure 'local-search' for 'p' {
        'accepting-strategy' := 'simulated-annealing' {
            'decreasing-function' := 'linear-decrease' { 'iterations' := 10; };
        };
        'stopping-criteria' := [ 'iteration-count' { 'maximum-iterations' := 5; } ];
    }
}
