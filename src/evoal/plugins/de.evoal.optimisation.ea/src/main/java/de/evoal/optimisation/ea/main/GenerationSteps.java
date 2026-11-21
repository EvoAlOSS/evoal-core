package de.evoal.optimisation.ea.main;

import java.util.ArrayList;
import java.util.List;
import java.util.random.RandomGenerator;

import de.evoal.optimisation.api.checks.Resampler;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.steps.Acceptance;
import de.evoal.optimisation.api.steps.Adaption;
import de.evoal.optimisation.api.steps.SearchState;
import de.evoal.optimisation.api.steps.Selection;
import de.evoal.optimisation.api.steps.StateKey;
import de.evoal.optimisation.ea.api.genotype.Genome;
import de.evoal.optimisation.ea.api.replacement.ReplacementStrategy;
import de.evoal.optimisation.ea.api.selection.CandidateOrder;
import de.evoal.optimisation.ea.api.selection.CrowdedOrder;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * The steps of a generation of the evolutionary algorithm. The children between the
 *   recombination and the mutation are kept in the strategy state. The recombined children
 *   are the outputs of the recombination; the mutated ones, which the mutation relates to them,
 *   are the outputs of the mutation.
 */
final class GenerationSteps {
    /**
     * The children of the current generation and their candidates after the recombination.
     */
    private static final StateKey<OffspringList> OFFSPRING = new StateKey<>("offspring", OffspringList.class);

    /**
     * A list of children with their candidates after the recombination; a class, so it can be a
     *   value of the strategy state.
     *
     * @param children The children.
     * @param recombined The candidates of the children after the recombination, in their order.
     */
    record OffspringList(List<Offspring> children, List<Candidate> recombined) {
    }

    private GenerationSteps() {
    }

    /**
     * The parent selection: selects 2 * ceil(lambda / 2) parents of the population, which
     *   become the current candidates. Consecutive parents form a pair.
     */
    static Selection selectParents(final SelectionMethod selection, final int offspring, final CandidateOrder order,
                                   final RandomGenerator random) {
        final int parents = 2 * ((offspring + 1) / 2);

        return new Selection() {
            @Override
            public String description() {
                return "select " + parents + " parents by " + selection.name();
            }

            @Override
            public void execute(final SearchState state) {
                state.setCandidates(selection.select(state.getPopulation(), parents, order, random));
            }
        };
    }

    /**
     * The recombination: recombines every pair of parents into two children and keeps the
     *   first lambda of them, which become the current candidates.
     */
    static Adaption recombine(final Variation variation, final int offspring) {
        return new Adaption() {
            @Override
            public String description() {
                return "recombine " + ((offspring + 1) / 2) + " pairs";
            }

            @Override
            public void execute(final SearchState state) {
                final List<Candidate> parents = state.getCandidates();
                final List<Offspring> children = new ArrayList<>(parents.size());

                for(int i = 0; i + 1 < parents.size(); i += 2) {
                    children.addAll(variation.recombine(parents.get(i), parents.get(i + 1)));
                }

                final List<Offspring> kept = List.copyOf(children.subList(0, offspring));
                final List<Candidate> recombined = kept.stream()
                                                       .map(variation::toCandidate)
                                                       .toList();

                state.setStrategy(OFFSPRING, new OffspringList(kept, recombined));
                state.setCandidates(recombined);
            }
        };
    }

    /**
     * The mutation: mutates the children, which become the current candidates. A mutated child
     *   is a mutation of its recombined child; one that the mutation left unchanged is the
     *   recombined child itself.
     */
    static Adaption mutate(final Variation variation, final int offspring) {
        return new Adaption() {
            @Override
            public String description() {
                return "mutate " + offspring + " children";
            }

            @Override
            public void execute(final SearchState state) {
                final OffspringList recombination = state.strategy(OFFSPRING)
                                                         .orElseThrow(() -> new IllegalStateException("No children to mutate."));
                final List<Offspring> children = recombination.children();

                final List<Candidate> candidates = new ArrayList<>(children.size());
                for(int i = 0; i < children.size(); ++i) {
                    final Offspring child = children.get(i);
                    final Genome beforeMutation = child.genome().copy();
                    final int operatorsBefore = child.operators.size();

                    variation.mutate(child);
                    candidates.add(variation.toMutatedCandidate(child, recombination.recombined().get(i), beforeMutation,
                                                                operatorsBefore));
                }

                state.setCandidates(candidates);
            }
        };
    }

    /**
     * @return Redoes the variation of the child at an index of the current candidates for
     *   the check reaction {@code resample}; the children are kept in the strategy state until
     *   the replacement.
     */
    static Resampler resampler(final Variation variation) {
        return (state, index) -> {
            final List<Offspring> children = state.strategy(OFFSPRING)
                                                  .orElseThrow(() -> new IllegalStateException("No children to resample."))
                                                  .children();

            return variation.toCandidate(variation.revary(children.get(index)));
        };
    }

    /**
     * The replacement: forms the next population from the population and the evaluated
     *   children.
     */
    static Acceptance replace(final ReplacementStrategy replacement, final int size, final CandidateOrder order,
                              final RandomGenerator random) {
        return new Acceptance() {
            @Override
            public String description() {
                return replacement.name() + " by " + replacement.selection().name();
            }

            @Override
            public void execute(final SearchState state) {
                state.setPopulation(replacement.replace(state.getPopulation(), state.getCandidates(), size, order, random));
                state.setCandidates(List.of());
                state.setStrategy(OFFSPRING, new OffspringList(List.of(), List.of()));
            }
        };
    }

    /**
     * Sorts the population into non-dominated fronts and sets the front and the crowding
     *   distance of every member ({@link CrowdedOrder#assign}), if a member has none: after
     *   the initialisation, and after a population check replaced a member. Otherwise the
     *   members keep the values of {@code 'nsga2-selection'}.
     *
     * @param constraintGroup The constraint group of the constrained domination, {@code null}
     *   for plain Pareto dominance.
     */
    static Acceptance sortIntoFronts(final String constraintGroup) {
        return new Acceptance() {
            @Override
            public String description() {
                return "sort the population into non-dominated fronts";
            }

            @Override
            public void execute(final SearchState state) {
                final List<Candidate> population = state.getPopulation();

                if(!population.stream().allMatch(CrowdedOrder::isRanked)) {
                    CrowdedOrder.assign(population, constraintGroup);
                }
            }
        };
    }
}
