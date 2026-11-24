package de.evoal.optimisation.ea.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.optimisation.ea.api.replacement.ReplacementStrategy;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;
import de.evoal.optimisation.ea.main.replacement.CommaReplacement;
import de.evoal.optimisation.ea.main.replacement.PlusReplacement;
import de.evoal.optimisation.ea.main.replacement.SurvivorReplacement;
import de.evoal.optimisation.ea.main.selection.EliteSelection;
import de.evoal.optimisation.ea.main.selection.Nsga2Selection;
import de.evoal.optimisation.ea.main.selection.TournamentSelection;

/**
 * The configuration checks of NSGA-II in the evolutionary algorithm.
 */
class Nsga2ConfigurationTest {
    private static final SelectionMethod TOURNAMENT = new TournamentSelection(2);

    private static void rejected(final String message, final Executable check) {
        final InitializationException exception = Assertions.assertThrows(InitializationException.class, check);
        Assertions.assertTrue(exception.getMessage().contains(message), exception.getMessage());
    }

    @Test
    @DisplayName("NSGA-II: crowded comparator, nsga2-selection in a plus or comma replacement")
    void accepted() {
        Assertions.assertDoesNotThrow(
                () -> EvolutionaryAlgorithm.checkNsga2(TOURNAMENT, new PlusReplacement(new Nsga2Selection()), true));
        Assertions.assertDoesNotThrow(
                () -> EvolutionaryAlgorithm.checkNsga2(TOURNAMENT, new CommaReplacement(new Nsga2Selection()), true));
    }

    @Test
    @DisplayName("without NSGA-II nothing is checked")
    void other() {
        Assertions.assertDoesNotThrow(
                () -> EvolutionaryAlgorithm.checkNsga2(TOURNAMENT, new PlusReplacement(TOURNAMENT), false));
    }

    @Test
    @DisplayName("the crowded comparator needs nsga2-selection")
    void comparatorWithoutSelection() {
        rejected("'crowded-comparator' needs 'nsga2-selection'",
                 () -> EvolutionaryAlgorithm.checkNsga2(TOURNAMENT, new PlusReplacement(TOURNAMENT), true));
    }

    @Test
    @DisplayName("nsga2-selection needs the crowded comparator")
    void selectionWithoutComparator() {
        rejected("needs 'crowded-comparator'",
                 () -> EvolutionaryAlgorithm.checkNsga2(TOURNAMENT, new PlusReplacement(new Nsga2Selection()), false));
    }

    @Test
    @DisplayName("nsga2-selection is no parent selection")
    void parentSelection() {
        final ReplacementStrategy replacement = new PlusReplacement(new Nsga2Selection());
        rejected("survivor selection", () -> EvolutionaryAlgorithm.checkNsga2(new Nsga2Selection(), replacement, true));
    }

    @Test
    @DisplayName("nsga2-selection cannot be nested")
    void nested() {
        final ReplacementStrategy replacement = new PlusReplacement(new EliteSelection(2, new Nsga2Selection()));
        rejected("cannot be nested", () -> EvolutionaryAlgorithm.checkNsga2(TOURNAMENT, replacement, true));
    }

    @Test
    @DisplayName("nsga2-selection does not work with the survivor replacement")
    void survivorReplacement() {
        final ReplacementStrategy replacement = new SurvivorReplacement(new Nsga2Selection());
        rejected("needs 'plus-replacement' or 'comma-replacement'",
                 () -> EvolutionaryAlgorithm.checkNsga2(TOURNAMENT, replacement, true));
    }
}
