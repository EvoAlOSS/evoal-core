import "definitions" from 'de.evoal.core.test.paths.types';

import "data" from 'de.evoal.core.test.paths.data';

module de.evoal.core.test.paths.problem {
    specify 'test-problem' 'p' {
        search for data 'x', data 'y'

        map with 'test-function' {}

        and minimise data 'z'
    }
}
