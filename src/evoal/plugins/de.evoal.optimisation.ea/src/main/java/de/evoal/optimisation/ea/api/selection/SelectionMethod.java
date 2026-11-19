package de.evoal.optimisation.ea.api.selection;

import java.util.List;
import java.util.random.RandomGenerator;

import de.evoal.models.core.cdi.EvoalComponent;

import de.evoal.optimisation.api.run.Candidate;

/**
 * A selection (DL type {@code selection}): chooses a number of candidates from a list. A
 *   candidate can be chosen more than once.
 */
public interface SelectionMethod extends EvoalComponent<SelectionMethod> {
    /**
     * @return The name of the DL type, e.g., {@code tournament-selection}.
     */
    String name();

    /**
     * @return Whether the selection uses the fitness itself, which then must have one
     *   component, instead of comparing the candidates; includes nested selections.
     */
    default boolean needsSingleFitness() {
        return false;
    }

    /**
     * @return Whether the selection sorts the candidates into non-dominated fronts
     *   ({@code 'nsga2-selection'}); includes nested selections.
     */
    default boolean sortsIntoFronts() {
        return false;
    }

    /**
     * @param candidates The evaluated candidates to choose from; not empty.
     * @param count The number of candidates to choose.
     * @param order The order in which the candidates are compared.
     * @param random The random numbers of the selection.
     * @return The chosen candidates, in the order they were chosen.
     */
    List<Candidate> select(List<Candidate> candidates, int count, CandidateOrder order, RandomGenerator random);
}
