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
import de.evoal.optimisation.ea.api.replacement.ReplacementStrategy;
import de.evoal.optimisation.ea.api.selection.SelectionMethod;

/**
 * The steps of a generation of the evolutionary algorithm. The children between the
 *   recombination and the mutation are kept in the strategy state.
 */
final class GenerationSteps {
    /**
     * The children of the current generation before they become candidates.
     */
    private static final StateKey<OffspringList> OFFSPRING = new StateKey<>("offspring", OffspringList.class);

    /**
     * A list of children; a class, so it can be a value of the strategy state.
     */
    record OffspringList(List<Offspring> children) {
    }

    private GenerationSteps() {
    }

    /**
     * The parent selection: selects 2 * ceil(lambda / 2) parents of the population, which
     *   become the current candidates. Consecutive parents form a pair.
     */
    static Selection selectParents(final SelectionMethod selection, final int offspring, final RandomGenerator random) {
        final int parents = 2 * ((offspring + 1) / 2);

        return new Selection() {
            @Override
            public String description() {
                return "select " + parents + " parents by " + selection.name();
            }

            @Override
            public void execute(final SearchState state) {
                state.setCandidates(selection.select(state.getPopulation(), parents, random));
            }
        };
    }

    /**
     * The recombination: recombines every pair of parents into two children and keeps the
     *   first lambda of them.
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

                state.setStrategy(OFFSPRING, new OffspringList(List.copyOf(children.subList(0, offspring))));
                state.setCandidates(List.of());
            }
        };
    }

    /**
     * The mutation: mutates the children, which become the current candidates.
     */
    static Adaption mutate(final Variation variation, final int offspring) {
        return new Adaption() {
            @Override
            public String description() {
                return "mutate " + offspring + " children";
            }

            @Override
            public void execute(final SearchState state) {
                final List<Offspring> children = state.strategy(OFFSPRING)
                                                      .orElseThrow(() -> new IllegalStateException("No children to mutate."))
                                                      .children();

                final List<Candidate> candidates = new ArrayList<>(children.size());
                for(final Offspring child : children) {
                    variation.mutate(child);
                    candidates.add(variation.toCandidate(child));
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
    static Acceptance replace(final ReplacementStrategy replacement, final int size, final RandomGenerator random) {
        return new Acceptance() {
            @Override
            public String description() {
                return replacement.name() + " by " + replacement.selection().name();
            }

            @Override
            public void execute(final SearchState state) {
                state.setPopulation(replacement.replace(state.getPopulation(), state.getCandidates(), size, random));
                state.setCandidates(List.of());
                state.setStrategy(OFFSPRING, new OffspringList(List.of()));
            }
        };
    }
}
