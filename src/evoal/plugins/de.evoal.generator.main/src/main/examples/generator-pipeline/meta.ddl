import "definitions" from 'de.evoal.core.math';
import "definitions" from 'de.evoal.core.constraints';

module meta {
  data:
    /**
     * The stored run number
     */
    quotient integer data 'run';

    /**
     * Input stored target number
     */
    quotient integer data 'target';

    /**
     * The stored generation
     */
    quotient integer data 'generation';

    /**
     * Input stored index
     */
    quotient integer data 'index';

   /**
	 * Output dimension for the Ackley generator function.
	 */
	quotient real data 'y:1';
}

