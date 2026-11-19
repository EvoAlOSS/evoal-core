package de.evoal.optimisation.ea.api.selection;

import java.util.List;
import java.util.Optional;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;

/**
 * The crowded-comparison operator of NSGA-II (Deb et al. 2002, section III-B): a candidate in
 *   a lower front is better; in the same front, the one with the larger crowding distance is
 *   better. Front and crowding distance are the candidate properties {@value #FRONT} and
 *   {@value #CROWDING_DISTANCE}, which {@code 'nsga2-selection'} and the sorting of the
 *   population ({@link #assign}) set.
 * <p>
 * A member of the population is a copy of the candidate the replacement selected (an
 *   identity of it); if the member has no front, the properties of its predecessor are used.
 */
public final class CrowdedOrder implements CandidateOrder {
    /**
     * The property with the front of a candidate (a {@code Long}), 0 for the first front.
     */
    public static final String FRONT = "front";

    /**
     * The property with the crowding distance of a candidate within its front.
     */
    public static final String CROWDING_DISTANCE = "crowding-distance";

    @Override
    public int compare(final Candidate first, final Candidate second) {
        final Ranked a = ranked(first);
        final Ranked b = ranked(second);

        // a lower front is better
        final int byFront = Integer.compare(b.front(), a.front());
        if(byFront != 0) {
            return byFront;
        }

        // a larger crowding distance is better
        return Double.compare(a.distance(), b.distance());
    }

    /**
     * @return Whether the candidate or its predecessor has a front.
     */
    public static boolean isRanked(final Candidate candidate) {
        return rankedSource(candidate).isPresent();
    }

    /**
     * Sorts the candidates into non-dominated fronts on their canonical fitness and sets the
     *   properties {@value #FRONT} and {@value #CROWDING_DISTANCE} of every candidate.
     *
     * @param candidates The evaluated candidates.
     * @return The indices of the candidates in every front, the first front first.
     */
    public static List<List<Integer>> assign(final List<Candidate> candidates) {
        final List<double[]> fitness = candidates.stream()
                                                 .map(candidate -> candidate.fitness().values())
                                                 .toList();
        final List<List<Integer>> fronts = ParetoFronts.fronts(fitness);

        for(int f = 0; f < fronts.size(); ++f) {
            final List<Integer> front = fronts.get(f);
            final double[] distances = ParetoFronts.crowdingDistances(fitness, front);

            for(int i = 0; i < front.size(); ++i) {
                final Candidate candidate = candidates.get(front.get(i));
                candidate.setProperty(FRONT, (long) f);
                candidate.setProperty(CROWDING_DISTANCE, distances[i]);
            }
        }

        return fronts;
    }

    private static Ranked ranked(final Candidate candidate) {
        final Candidate source = rankedSource(candidate)
                .orElseThrow(() -> new IllegalStateException("The candidate " + candidate.input()
                                                             + " has no front; 'crowded-comparator' needs 'nsga2-selection'."));

        return new Ranked(((Number) source.properties().get(FRONT)).intValue(),
                          ((Number) source.properties().get(CROWDING_DISTANCE)).doubleValue());
    }

    private static Optional<Candidate> rankedSource(final Candidate candidate) {
        if(candidate.properties().containsKey(FRONT)) {
            return Optional.of(candidate);
        }

        final Lineage lineage = candidate.lineage();
        if(lineage.kind() == Lineage.Kind.IDENTITY && lineage.predecessor().properties().containsKey(FRONT)) {
            return Optional.of(lineage.predecessor());
        }

        return Optional.empty();
    }

    private record Ranked(int front, double distance) {
    }
}
