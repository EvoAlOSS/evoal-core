package de.evoal.optimisation.ea.main.selection;

import java.util.List;
import java.util.OptionalInt;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.Candidates;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;

/**
 * The selection {@code 'stochastic-ranking-selection'}.
 */
class StochasticRankingSelectionTest {
    private final RandomGenerator random = RandomGeneratorFactory.of("L64X128MixRandom").create(23);

    private static StochasticRankingSelection selection(final double fitnessProbability,
                                                        final StochasticRankingSelection.Penalty penalty) {
        return new StochasticRankingSelection(Candidates.GROUP, fitnessProbability, OptionalInt.empty(), penalty);
    }

    @Test
    void itSelectsTheFirstCandidatesOfTheRankingAndRecordsEveryPlace() {
        // feasible: f 3 and f 1; infeasible: violation 1 and 2
        final Candidate feasibleWorse = Candidates.withViolation(3.0, 0.0);
        final Candidate feasibleBetter = Candidates.withViolation(1.0, 0.0);
        final Candidate slightlyInfeasible = Candidates.withViolation(0.0, 1.0);
        final Candidate infeasible = Candidates.withViolation(-1.0, 2.0);
        final List<Candidate> candidates = List.of(infeasible, feasibleWorse, slightlyInfeasible, feasibleBetter);

        final List<Candidate> selected = selection(0.0, StochasticRankingSelection.Penalty.SQUARED_SUM)
                .select(candidates, 2, CandidateOrder.BY_VALUE, random);

        Assertions.assertEquals(List.of(feasibleBetter, feasibleWorse), selected);
        Assertions.assertEquals(0L, feasibleBetter.properties().get(StochasticRankingSelection.RANK));
        Assertions.assertEquals(1L, feasibleWorse.properties().get(StochasticRankingSelection.RANK));
        Assertions.assertEquals(2L, slightlyInfeasible.properties().get(StochasticRankingSelection.RANK));
        Assertions.assertEquals(3L, infeasible.properties().get(StochasticRankingSelection.RANK));
    }

    @Test
    void itSelectsWithoutReplacement() {
        final List<Candidate> candidates = Candidates.withFitness(1.0, 2.0);

        final IllegalArgumentException e = Assertions.assertThrows(IllegalArgumentException.class,
                () -> selection(0.45, StochasticRankingSelection.Penalty.SUM).select(candidates, 3, CandidateOrder.BY_VALUE, random));
        Assertions.assertTrue(e.getMessage().contains("without replacement"), e.getMessage());
    }

    @Test
    void itRanksStochastically() {
        Assertions.assertTrue(selection(0.45, StochasticRankingSelection.Penalty.SUM).ranksStochastically());
        Assertions.assertTrue(new EliteSelection(1, selection(0.45, StochasticRankingSelection.Penalty.SUM)).ranksStochastically());
    }

    @Test
    void thePenaltiesHaveTheNamesOfTheDl() {
        Assertions.assertEquals(StochasticRankingSelection.Penalty.SUM, StochasticRankingSelection.Penalty.of("sum"));
        Assertions.assertEquals(StochasticRankingSelection.Penalty.SQUARED_SUM, StochasticRankingSelection.Penalty.of("squared-sum"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> StochasticRankingSelection.Penalty.of("other"));
    }

    @Test
    void theDlStatesTheDefaultsOfThePaper() {
        final DefinitionModule module = LanguageHelper.loadFromClasspath("de/evoal/optimisation/ea/optimisation.dl");
        final ClassDefinition type = module.getTypes()
                                           .stream()
                                           .filter(definition -> "stochastic-ranking-selection".equals(definition.getName()))
                                           .findFirst()
                                           .orElseThrow();

        final AttributeDefinition group = type.findAttribute("group");
        Assertions.assertFalse(group.isOptional());
        Assertions.assertNull(group.getInitialisation());

        Assertions.assertNotNull(type.findAttribute("fitness-probability").getInitialisation());
        Assertions.assertTrue(type.findAttribute("sweeps").isOptional());
        Assertions.assertNotNull(type.findAttribute("penalty").getInitialisation());
    }
}
