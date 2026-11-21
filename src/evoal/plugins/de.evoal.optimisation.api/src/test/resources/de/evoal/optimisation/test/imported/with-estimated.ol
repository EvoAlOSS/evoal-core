import "definitions" from 'de.evoal.optimisation.core';
import "definitions" from 'de.evoal.optimisation.test.imported.algorithm';

import "data" from 'de.evoal.optimisation.test.imported.data';
import "data" from 'de.evoal.optimisation.test.imported.estimated';

module de.evoal.optimisation.test.imported.'with-estimated' {
    specify problem 'local' {
        search for data 'x'

        map with 'unknown-function' {}

        and minimise data 'y'
    }

    configure 'test-algorithm' for 'local' {}
}
