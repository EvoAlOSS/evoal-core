package de.evoal.optimisation.api.run;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import de.evoal.models.v202704.optimisation.execution.OptimisationValue;

/**
 * Ranks the members of a population by their optimisation values. Rank 0 contains the
 *   members with the best value, every following rank the members with the next worse
 *   value. Members with an equal value share a rank and keep their order.
 */
public final class Ranking {
    private Ranking() {
    }

    /**
     * @param values The optimisation values of the members, by member index.
     * @return The member indices of every rank, the best rank first.
     */
    public static List<List<Integer>> byValue(final List<OptimisationValue> values) {
        // greater optimisation values are better; the sort is stable
        final Comparator<Integer> byValue = Comparator.comparing(values::get);
        final List<Integer> bestFirst = IntStream.range(0, values.size())
                                                 .boxed()
                                                 .sorted(byValue.reversed())
                                                 .toList();

        final List<List<Integer>> ranks = new ArrayList<>();
        List<Integer> rank = null;
        OptimisationValue previousValue = null;

        for(final int index : bestFirst) {
            final OptimisationValue value = values.get(index);
            final boolean startsNewRank = previousValue == null || value.isWorse(previousValue);

            if(startsNewRank) {
                rank = new ArrayList<>();
                ranks.add(rank);
            }

            rank.add(index);
            previousValue = value;
        }

        return ranks;
    }
}
