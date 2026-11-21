import "definitions" from 'de.evoal.optimisation.constraint';
import "data" from 'de.evoal.optimisation.test.imported.data';

/**
 * Constraints of the tests of imported DDL modules: the module declares no data, it refers to
 *   the data of another module.
 */
module 'de.evoal.optimisation.test.imported.estimated' {
    constraints:
        'standard-deviation'(data 'x', 0.5);
}
