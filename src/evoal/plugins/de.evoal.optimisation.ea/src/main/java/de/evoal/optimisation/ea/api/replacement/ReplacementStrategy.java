package de.evoal.optimisation.ea.api.replacement;

import java.util.List;
import java.util.random.RandomGenerator;

import de.evoal.models.core.cdi.EvoalComponent;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * A replacement (DL type {@code replacement}): forms the next population of N candidates
 *   from the N parents of the population and the lambda children.
 */
public interface ReplacementStrategy extends EvoalComponent<ReplacementStrategy> {
    /**
     * @param size The size of the population (N).
     * @param offspring The number of children (lambda).
     * @throws InitializationException if the replacement cannot form a population of N
     *   candidates from lambda children.
     */
    default void check(final int size, final int offspring) throws InitializationException {
    }

    /**
     * @return The name of the DL type, e.g., {@code plus-replacement}.
     */
    String name();

    /**
     * @param parents The parents (the population).
     * @param children The evaluated children.
     * @param size The size of the next population (N).
     * @param random The random numbers of the selection.
     * @return The next population.
     */
    List<Candidate> replace(List<Candidate> parents, List<Candidate> children, int size, RandomGenerator random);

    /**
     * @return Selects the candidates that survive.
     */
    SelectionMethod selection();
}
