import "definitions" from 'de.evoal.core.test.paths.types';

import "data" from 'de.evoal.core.test.paths.data';

import "optimisation" from 'de.evoal.core.test.paths.problem';

module de.evoal.core.test.paths.configuration {
    configure 'test-algorithm' for 'p' {
        'swarm' := 'swarm' {};
        'mover' := 'special-mover' {};
        'criteria' := [
            'count-criterion' { 'maximum' := 100; },
            'any-of' { 'criteria' := [ 'count-criterion' { 'maximum' := 50; },
                                       'any-of' { 'criteria' := [ 'count-criterion' {} ]; } ]; },
            'all-of' { 'criteria' := [ 'count-criterion' { 'maximum' := 1; } ]; }
        ];
        'features' := [ data 'x', data 'y' ];
        'others' := [ data 'bounded', data 'positive', data 'colour' ];
        'decreases' := [ 'decrease' { 'iterations' := 10; }, 'decrease' { 'iterations' := 11; } ];
    }
}
