package de.evoal.optimisation.api.model;

import de.evoal.models.core.cdi.EvoalComponent;
import de.evoal.models.v202704.optimisation.memory.Iteration;

/**
 * A measure of the stopping criterion {@code 'stagnation'}: one value per iteration, where
 *   smaller is better (canonical minimisation). The criterion stops a run when the value has
 *   not improved for a number of iterations. Measures are instances of the DL type
 *   {@code 'stagnation-measure'}; plugins add measures as {@code @Named} components with the
 *   fully qualified name of their DL type.
 */
public interface StagnationMeasure extends EvoalComponent<StagnationMeasure> {
    /**
     * @param iteration The recorded iteration.
     * @return The value of the iteration; a non-finite value (e.g. {@code NaN} if no
     *   individual has a fitness) never counts as an improvement.
     */
    double measure(Iteration iteration);
}
