package de.evoal.optimisation.ea.api.selection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Pareto dominance, non-dominated sorting and crowding distance of NSGA-II (K. Deb,
 *   A. Pratap, S. Agarwal, T. Meyarivan: A fast and elitist multiobjective genetic algorithm:
 *   NSGA-II. IEEE Transactions on Evolutionary Computation 6(2), 2002, pp. 182-197). All
 *   fitness components are minimised (canonical fitness).
 */
public final class ParetoFronts {
    private ParetoFronts() {
    }

    /**
     * @return Whether the first fitness dominates the second: it is not worse in any
     *   component and better in at least one.
     * @throws IllegalArgumentException if the fitness vectors differ in length.
     */
    public static boolean dominates(final double[] first, final double[] second) {
        if(first.length != second.length) {
            throw new IllegalArgumentException("Fitness vectors of different length: " + first.length + " and "
                                               + second.length + ".");
        }

        boolean better = false;
        for(int i = 0; i < first.length; ++i) {
            if(first[i] > second[i]) {
                return false;
            }
            if(first[i] < second[i]) {
                better = true;
            }
        }

        return better;
    }

    /**
     * Fast non-dominated sorting (Deb et al. 2002, section III-A): the first front contains
     *   the vectors no other vector dominates, every further front the vectors that only the
     *   earlier fronts dominate.
     *
     * @param fitness The fitness vectors.
     * @return The indices of every front, the first front first; within a front, the indices
     *   are ascending.
     */
    public static List<List<Integer>> fronts(final List<double[]> fitness) {
        final int n = fitness.size();
        final List<List<Integer>> dominated = new ArrayList<>(n);
        final int[] dominatedBy = new int[n];

        for(int p = 0; p < n; ++p) {
            dominated.add(new ArrayList<>());
        }

        for(int p = 0; p < n; ++p) {
            for(int q = p + 1; q < n; ++q) {
                if(dominates(fitness.get(p), fitness.get(q))) {
                    dominated.get(p).add(q);
                    ++dominatedBy[q];
                } else if(dominates(fitness.get(q), fitness.get(p))) {
                    dominated.get(q).add(p);
                    ++dominatedBy[p];
                }
            }
        }

        final List<List<Integer>> fronts = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        for(int p = 0; p < n; ++p) {
            if(dominatedBy[p] == 0) {
                current.add(p);
            }
        }

        while(!current.isEmpty()) {
            fronts.add(current);

            final List<Integer> next = new ArrayList<>();
            for(final int p : current) {
                for(final int q : dominated.get(p)) {
                    if(--dominatedBy[q] == 0) {
                        next.add(q);
                    }
                }
            }
            next.sort(Comparator.naturalOrder());
            current = next;
        }

        return fronts;
    }

    /**
     * Crowding distance (Deb et al. 2002, section III-B): for every component, the members of
     *   the front are sorted by it; the first and the last member get an infinite distance, every
     *   other member the distance of its two neighbours in this component, divided by the
     *   range of the component in the front. The distances of all components are summed. A
     *   component with range 0 adds nothing to the inner members.
     *
     * @param fitness The fitness vectors.
     * @param front The indices of the members of one front.
     * @return The crowding distance of every member, in the order of {@code front}.
     */
    public static double[] crowdingDistances(final List<double[]> fitness, final List<Integer> front) {
        final int size = front.size();
        final double[] distances = new double[size];

        if(size == 0) {
            return distances;
        }
        if(size <= 2) {
            Arrays.fill(distances, Double.POSITIVE_INFINITY);
            return distances;
        }

        final int components = fitness.get(front.getFirst()).length;
        for(int m = 0; m < components; ++m) {
            final int component = m;
            // positions within the front, sorted by the component; the sort is stable
            final List<Integer> order = new ArrayList<>(size);
            for(int i = 0; i < size; ++i) {
                order.add(i);
            }
            order.sort(Comparator.comparingDouble(i -> fitness.get(front.get(i))[component]));

            final double minimum = fitness.get(front.get(order.getFirst()))[component];
            final double maximum = fitness.get(front.get(order.getLast()))[component];

            distances[order.getFirst()] = Double.POSITIVE_INFINITY;
            distances[order.getLast()] = Double.POSITIVE_INFINITY;

            final double range = maximum - minimum;
            if(range <= 0.0) {
                continue;
            }

            for(int k = 1; k < size - 1; ++k) {
                final double previous = fitness.get(front.get(order.get(k - 1)))[component];
                final double next = fitness.get(front.get(order.get(k + 1)))[component];
                distances[order.get(k)] += (next - previous) / range;
            }
        }

        return distances;
    }
}
