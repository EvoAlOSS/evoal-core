package de.evoal.optimisation.ea.main.selection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.CrowdedOrder;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * The survivor selection of NSGA-II (DL type {@code 'nsga2-selection'}; K. Deb, A. Pratap,
 *   S. Agarwal, T. Meyarivan: A fast and elitist multiobjective genetic algorithm: NSGA-II.
 *   IEEE Transactions on Evolutionary Computation 6(2), 2002, pp. 182-197, section III-C).
 * <p>
 * It sorts the candidates into non-dominated fronts on their canonical fitness, computes the
 *   crowding distance in every front and sets both as the properties
 *   {@value CrowdedOrder#FRONT} and {@value CrowdedOrder#CROWDING_DISTANCE} of every
 *   candidate. The selected candidates are the fronts in their order; of the first front that
 *   does not fit completely, the candidates with the largest crowding distance are taken
 *   (equal distances keep their order). Unlike the other selections, it selects without
 *   replacement, so it can select at most all candidates. It does not use the random numbers
 *   or the order.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.nsga2-selection")
public class Nsga2Selection implements SelectionMethod {
    @Override
    public String name() {
        return "nsga2-selection";
    }

    @Override
    public boolean sortsIntoFronts() {
        return true;
    }

    /**
     * @throws IllegalArgumentException if more candidates are to be selected than there are.
     */
    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final CandidateOrder order,
                                  final RandomGenerator random) {
        if(count > candidates.size()) {
            throw new IllegalArgumentException("'nsga2-selection' selects without replacement and cannot select " + count
                                               + " of " + candidates.size() + " candidates.");
        }

        final List<List<Integer>> fronts = CrowdedOrder.assign(candidates);
        final List<Candidate> selected = new ArrayList<>(count);

        for(final List<Integer> front : fronts) {
            final List<Candidate> members = front.stream()
                                                 .map(candidates::get)
                                                 .toList();
            final int remaining = count - selected.size();

            if(members.size() <= remaining) {
                selected.addAll(members);
            } else {
                final List<Candidate> byDistance = new ArrayList<>(members);
                byDistance.sort(Comparator.comparingDouble(Nsga2Selection::crowdingDistance).reversed());
                selected.addAll(byDistance.subList(0, remaining));
            }

            if(selected.size() == count) {
                break;
            }
        }

        return selected;
    }

    private static double crowdingDistance(final Candidate candidate) {
        return ((Number) candidate.properties().get(CrowdedOrder.CROWDING_DISTANCE)).doubleValue();
    }
}
