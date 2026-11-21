import "definitions" from 'de.evoal.optimisation.core';
import "definitions" from 'de.evoal.optimisation.test.imported.algorithm';

import "data" from 'de.evoal.optimisation.test.imported.data';

import "optimisation" from 'de.evoal.optimisation.test.imported.problem';

module de.evoal.optimisation.test.imported.qualified {
    configure 'test-algorithm' for de.evoal.optimisation.test.imported.problem.'sphere' {}
}
