import "definitions" from 'de.evoal.optimisation.core';
import "definitions" from 'de.evoal.optimisation.test.imported.algorithm';

import "data" from 'de.evoal.optimisation.test.imported.data';

module de.evoal.optimisation.test.imported.problem {
    specify problem 'sphere' {
        search for data 'x'

        map with 'unknown-function' {}

        and minimise data 'y'
    }
}
