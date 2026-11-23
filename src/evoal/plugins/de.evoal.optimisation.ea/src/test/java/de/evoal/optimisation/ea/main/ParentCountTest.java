package de.evoal.optimisation.ea.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.optimisation.ea.main.selection.EliteSelection;
import de.evoal.optimisation.ea.main.selection.StochasticRankingSelection;
import de.evoal.optimisation.ea.main.selection.TournamentSelection;

/**
 * The start-up check that the parent selection can choose 2 * ceil(lambda / 2) parents from
 *   the mu candidates of the population.
 */
class ParentCountTest {
    @Test
    @DisplayName("a selection with replacement chooses any number of parents")
    void withReplacement() {
        Assertions.assertDoesNotThrow(() -> EvolutionaryAlgorithm.checkParentCount(new TournamentSelection(2), 4, 101));
    }

    @Test
    @DisplayName("a selection without replacement chooses at most mu parents")
    void withoutReplacement() {
        Assertions.assertDoesNotThrow(() -> EvolutionaryAlgorithm.checkParentCount(new StochasticRankingSelection(), 10, 9));

        // 11 offspring need 12 parents
        final InitializationException exception = Assertions.assertThrows(InitializationException.class,
                () -> EvolutionaryAlgorithm.checkParentCount(new StochasticRankingSelection(), 10, 11));
        Assertions.assertTrue(exception.getMessage().contains("'stochastic-ranking-selection' can choose at most 10"),
                              exception.getMessage());
    }

    @Test
    @DisplayName("elitism adds its elite to what the nested selection can choose")
    void elite() {
        // 2 elite + at most 10 of the rest
        Assertions.assertDoesNotThrow(
                () -> EvolutionaryAlgorithm.checkParentCount(new EliteSelection(2, new StochasticRankingSelection()), 10, 12));
        Assertions.assertThrows(InitializationException.class,
                () -> EvolutionaryAlgorithm.checkParentCount(new EliteSelection(2, new StochasticRankingSelection()), 10, 13));
        Assertions.assertDoesNotThrow(
                () -> EvolutionaryAlgorithm.checkParentCount(new EliteSelection(2, new TournamentSelection(2)), 10, 99));
    }
}
