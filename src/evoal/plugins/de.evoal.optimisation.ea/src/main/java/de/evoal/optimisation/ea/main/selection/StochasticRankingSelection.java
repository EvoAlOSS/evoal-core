package de.evoal.optimisation.ea.main.selection;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.random.RandomGenerator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.optimisation.api.constraints.ViolationRecord;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;
import de.evoal.optimisation.ea.api.selection.StochasticRanking;
import de.evoal.optimisation.ea.main.statistics.StochasticRankingStatistics;

/**
 * Stochastic ranking selection (DL type {@code 'stochastic-ranking-selection'}; T. P.
 *   Runarsson, X. Yao: Stochastic ranking for constrained evolutionary optimization. IEEE
 *   Transactions on Evolutionary Computation 4(3), 2000, pp. 284-294): ranks the candidates
 *   by {@link StochasticRanking} on their canonical fitness and the penalty of a constraint
 *   group, and selects the first candidates of the ranking. Like {@code 'nsga2-selection'}, it
 *   selects without replacement.
 * <p>
 * Every ranked candidate gets the property {@value #RANK}, its place in the ranking (0 for the
 *   first); a later ranking in the same iteration overwrites it. The rankings are counted in
 *   the {@link StochasticRankingStatistics}. The selection does not use the order of the
 *   comparator.
 */
@Dependent
@Named("de.evoal.optimisation.ea.optimisation.stochastic-ranking-selection")
public class StochasticRankingSelection implements SelectionMethod {
    /**
     * The name of the property with the place of a candidate in the ranking.
     */
    public static final String RANK = "stochastic-rank";

    /**
     * The penalty of a candidate: how its violation of the group is measured.
     */
    public enum Penalty {
        /**
         * The violation of the group, the sum of the degrees of its constraints.
         */
        SUM,

        /**
         * The sum of the squared degrees of the constraints of the group, the quadratic loss
         *   of the paper (eq. 5).
         */
        SQUARED_SUM;

        /**
         * @param name The name of the DL literal, {@code sum} or {@code squared-sum}.
         * @return The penalty.
         * @throws IllegalArgumentException if the name is unknown.
         */
        public static Penalty of(final String name) {
            return switch(name) {
                case "sum" -> SUM;
                case "squared-sum" -> SQUARED_SUM;
                default -> throw new IllegalArgumentException("Unknown penalty '" + name + "'.");
            };
        }

        double of(final ViolationRecord violations, final String group) {
            return this == SUM ? violations.violation(group) : violations.squaredViolation(group);
        }
    }

    @Inject
    private AttributeHelper helper;

    @Inject
    private StochasticRankingStatistics statistics;

    /**
     * The constraint group.
     */
    private String group;

    /**
     * The probability P_f that neighbours, at least one of them infeasible, are compared by
     *   their fitness.
     */
    private double fitnessProbability;

    /**
     * The maximum number of sweeps; empty for the number of ranked candidates.
     */
    private OptionalInt sweeps = OptionalInt.empty();

    private Penalty penalty;

    /**
     * Creates the selection without configuration. CDI uses it before {@link #init(EObject)}.
     */
    public StochasticRankingSelection() {
    }

    /**
     * @param group The constraint group.
     * @param fitnessProbability The probability P_f, in [0, 1].
     * @param sweeps The maximum number of sweeps, at least 1; empty for the number of ranked
     *   candidates.
     * @param penalty How the violation of the group is measured.
     */
    public StochasticRankingSelection(final String group, final double fitnessProbability, final OptionalInt sweeps,
                                      final Penalty penalty) {
        this.group = group;
        this.fitnessProbability = fitnessProbability;
        this.sweeps = sweeps;
        this.penalty = penalty;
    }

    @Override
    public StochasticRankingSelection init(final EObject configuration) {
        group = helper.lookup(configuration, "group");
        fitnessProbability = helper.<Number>lookup(configuration, "fitness-probability").doubleValue();

        final EStructuralFeature sweepsFeature = configuration.eClass().getEStructuralFeature("sweeps");
        sweeps = sweepsFeature != null && configuration.eIsSet(sweepsFeature)
                ? OptionalInt.of(helper.<Number>lookup(configuration, "sweeps").intValue())
                : OptionalInt.empty();

        final EEnumLiteral literal = helper.lookup(configuration, "penalty");
        penalty = Penalty.of(literal.getName());

        return this;
    }

    @Override
    public String name() {
        return "stochastic-ranking-selection";
    }

    /**
     * @return {@code true}: the ranking compares the fitness itself.
     */
    @Override
    public boolean needsSingleFitness() {
        return true;
    }

    @Override
    public boolean ranksStochastically() {
        return true;
    }

    /**
     * @throws IllegalArgumentException if more candidates are to be selected than there are.
     */
    @Override
    public List<Candidate> select(final List<Candidate> candidates, final int count, final CandidateOrder order,
                                  final RandomGenerator random) {
        if(count > candidates.size()) {
            throw new IllegalArgumentException("'stochastic-ranking-selection' selects without replacement and cannot select "
                                               + count + " of " + candidates.size() + " candidates.");
        }

        final double[] fitness = new double[candidates.size()];
        final double[] penalties = new double[candidates.size()];
        for(int i = 0; i < candidates.size(); ++i) {
            final Candidate candidate = candidates.get(i);
            fitness[i] = candidate.fitness().value(0);
            penalties[i] = penalty.of(candidate.evaluation().violations(), group);
        }

        final StochasticRanking.Result result = StochasticRanking.rank(fitness, penalties, fitnessProbability,
                                                                       sweeps.orElse(candidates.size()), random);
        if(statistics != null) {
            statistics.count(result);
        }

        final int[] ranking = result.order();
        final List<Candidate> selected = new ArrayList<>(count);
        for(int place = 0; place < ranking.length; ++place) {
            final Candidate candidate = candidates.get(ranking[place]);
            candidate.setProperty(RANK, (long) place);
            if(place < count) {
                selected.add(candidate);
            }
        }

        return selected;
    }
}
