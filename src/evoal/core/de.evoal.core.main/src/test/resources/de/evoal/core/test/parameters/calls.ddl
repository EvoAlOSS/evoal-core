import "definitions" from 'de.evoal.core.constraints';
import "definitions" from 'de.evoal.core.test.parameters.functions';

/**
 * Calls for the tests of parameter annotations: the first two calls are valid, the others
 *   break one rule each.
 */
module 'calls' {
    data:
        /**
         * An ordered feature.
         */
        ordinal integer data 'level';

        /**
         * A feature without order.
         */
        nominal integer data 'colour';

    constraints:
        weigh(data 'level', 0.5);
        group([data 'level', data 'colour']);
        weigh(data 'colour', 0.5);
        weigh(data 'level', 1.5);
        group([data 'level']);
}
