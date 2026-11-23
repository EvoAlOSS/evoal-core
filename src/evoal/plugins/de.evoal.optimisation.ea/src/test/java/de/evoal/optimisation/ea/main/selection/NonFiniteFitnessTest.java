package de.evoal.optimisation.ea.main.selection;

import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.Candidates;
import de.evoal.optimisation.ea.Statistics;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * The fitness-proportional selections with a fitness that is not finite: +Infinity is the
 *   worst value, -Infinity the best, NaN an error.
 */
class NonFiniteFitnessTest {
    private static final int SELECTIONS = 20_000;

    private final RandomGenerator random = RandomGeneratorFactory.of("L64X128MixRandom").create(11);

    static Stream<SelectionMethod> selections() {
        return Stream.of(new RouletteWheelSelection(), new StochasticUniversalSampling(), new BoltzmannSelection(2.0));
    }

    private Map<Candidate, Long> counts(final SelectionMethod selection, final List<Candidate> candidates) {
        final Map<Candidate, Long> counts = new IdentityHashMap<>();
        selection.select(candidates, SELECTIONS, CandidateOrder.BY_VALUE, random)
                 .forEach(candidate -> counts.merge(candidate, 1L, Long::sum));

        return counts;
    }

    @ParameterizedTest
    @MethodSource("selections")
    void positiveInfinityIsNeverSelected(final SelectionMethod selection) {
        final List<Candidate> candidates = Candidates.withFitness(Double.POSITIVE_INFINITY, 0.0, 1.0, 2.0);

        final Map<Candidate, Long> counts = counts(selection, candidates);

        Assertions.assertEquals(0L, counts.getOrDefault(candidates.get(0), 0L), selection.name());
        Assertions.assertTrue(counts.getOrDefault(candidates.get(1), 0L) > 0L, selection.name());
    }

    @ParameterizedTest
    @MethodSource("selections")
    void positiveInfinityIsNotPartOfTheUniformFallback(final SelectionMethod selection) {
        // windowing gives the equal finite fitness the weight 0
        final List<Candidate> candidates = Candidates.withFitness(1.0, Double.POSITIVE_INFINITY, 1.0);

        final Map<Candidate, Long> counts = counts(selection, candidates);

        Assertions.assertEquals(0L, counts.getOrDefault(candidates.get(1), 0L), selection.name());
        Statistics.assertBinomial(counts.getOrDefault(candidates.get(0), 0L), SELECTIONS, 0.5, selection.name());
    }

    @ParameterizedTest
    @MethodSource("selections")
    void onlyNegativeInfinityIsSelected(final SelectionMethod selection) {
        final List<Candidate> candidates = Candidates.withFitness(Double.NEGATIVE_INFINITY, 0.0, Double.NEGATIVE_INFINITY, 5.0);

        final Map<Candidate, Long> counts = counts(selection, candidates);

        Assertions.assertEquals(0L, counts.getOrDefault(candidates.get(1), 0L), selection.name());
        Assertions.assertEquals(0L, counts.getOrDefault(candidates.get(3), 0L), selection.name());
        Statistics.assertBinomial(counts.getOrDefault(candidates.get(0), 0L), SELECTIONS, 0.5, selection.name());
    }

    @ParameterizedTest
    @MethodSource("selections")
    void onlyPositiveInfinityIsSelectedUniformly(final SelectionMethod selection) {
        final List<Candidate> candidates = Candidates.withFitness(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY);

        final Map<Candidate, Long> counts = counts(selection, candidates);

        Statistics.assertBinomial(counts.getOrDefault(candidates.get(0), 0L), SELECTIONS, 0.5, selection.name());
    }

    @ParameterizedTest
    @MethodSource("selections")
    void notANumberIsRejected(final SelectionMethod selection) {
        final List<Candidate> candidates = Candidates.withFitness(1.0, Double.NaN, 2.0);

        final IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class,
                () -> selection.select(candidates, 2, CandidateOrder.BY_VALUE, random));

        Assertions.assertTrue(exception.getMessage().contains("'" + selection.name() + "'"), exception.getMessage());
        Assertions.assertTrue(exception.getMessage().contains("NaN"), exception.getMessage());
    }
}
