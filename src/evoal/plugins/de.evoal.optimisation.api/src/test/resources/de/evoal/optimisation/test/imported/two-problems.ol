import "definitions" from 'de.evoal.optimisation.core';
import "definitions" from 'de.evoal.optimisation.test.imported.algorithm';

import "data" from 'de.evoal.optimisation.test.imported.data';

import "optimisation" from 'de.evoal.optimisation.test.imported.problem';

module de.evoal.optimisation.test.imported.two {
    specify problem 'local' {
        search for data 'x'

        map with 'unknown-function' {}

        and minimise data 'y'
    }

    configure 'test-algorithm' for 'sphere' {}
}
