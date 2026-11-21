package de.evoal.optimisation.api.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.IterationStep;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.PropertyScope;
import de.evoal.models.v202704.optimisation.memory.Rank;
import de.evoal.models.v202704.optimisation.memory.Recombination;
import de.evoal.models.v202704.optimisation.memory.Relationship;
import de.evoal.models.v202704.optimisation.memory.UnorderedIterationStep;

import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.model.IndividualIDGenerator;

/**
 * Turns the candidates of one iteration into the individuals of the memory model, in two
 *   versions with the same ids:
 * <ul>
 *   <li>the <em>steps</em>: every executed step holds its outputs as individuals, related to
 *     their direct predecessors ({@link Candidate#stepLineage()}), which may be outputs of an
 *     earlier step of the same iteration;</li>
 *   <li>the <em>ranks</em>: the members of the population, related to the individuals of the
 *     previous iteration ({@link Candidate#lineage()}).</li>
 * </ul>
 * Every candidate gets its id when it first occurs in the outputs of the steps, in execution
 *   order, or else in the members. A candidate that occurs several times in one list, e.g., a
 *   member that a selection chose twice, is a further individual per further occurrence; the
 *   n-th occurrence in every list is the same individual. A copy that occurs in no list, e.g.,
 *   an unchanged member carried over into the iteration, gets no id: it stands for its
 *   original ({@link Lineage.Kind#IDENTITY}).
 * <p>
 * An individual of a step and the individual of the same member in the ranks are different
 *   objects with the same id and the same values; an individual that occurs in several steps is
 *   a copy in each further one. The recombinations of two individuals whose lineages share a
 *   pair ({@link Lineage#pair()}) refer to each other as siblings ({@code other}): in the ranks
 *   two members, in the steps two outputs of the same step that have no sibling yet, e.g. the
 *   children of a recombination.
 */
final class IterationRecording {
    /**
     * Creates the ids of the individuals.
     */
    private final IndividualIDGenerator idGenerator;

    /**
     * The occurrences of the candidates of the iteration, in the order of their ids.
     */
    private final Map<Candidate, List<Occurrence>> occurrences = new IdentityHashMap<>();

    /**
     * The individuals of the members of the previous iteration.
     */
    private final Map<Candidate, Individual> previous;

    /**
     * The recombinations of the ranks by the pair of their lineage, the first one per candidate.
     */
    private final Map<Object, Map<Candidate, Recombination>> rankPairs = new IdentityHashMap<>();

    /**
     * Checks and defines the properties of the individuals and relationships.
     */
    private final ExecutionRecorder recorder;

    /**
     * @param idGenerator Creates the ids of the individuals.
     * @param recorder Checks and defines the properties.
     * @param previous The individuals of the members of the previous iteration.
     */
    IterationRecording(final IndividualIDGenerator idGenerator,
                       final ExecutionRecorder recorder,
                       final Map<Candidate, Individual> previous) {
        this.idGenerator = idGenerator;
        this.recorder = recorder;
        this.previous = previous;
    }

    /**
     * @return The individual of a predecessor in the steps version: its own individual if it
     *   occurred in a step of this iteration before the individual with the given id, else the
     *   one of the previous iteration that it stands for.
     * @throws IllegalStateException if the predecessor belongs to neither.
     */
    private Individual directIndividualOf(final Candidate predecessor, final int id) {
        Candidate candidate = predecessor;

        while(true) {
            final List<Occurrence> recorded = occurrences.get(candidate);
            if(recorded != null && recorded.getFirst().id < id) {
                return inSteps(recorded.getFirst());
            }

            final Individual earlier = previous.get(candidate);
            if(earlier != null) {
                return earlier;
            }

            if(candidate.lineage().kind() != Lineage.Kind.IDENTITY) {
                throw new IllegalStateException("The predecessor " + predecessor + " is neither an output of an "
                                                + "earlier step nor a member of the previous iteration.");
            }

            candidate = candidate.lineage().predecessor();
        }
    }

    /**
     * @return The individual of the occurrence in the ranks, related to the individuals of the
     *   previous iteration; created at the first call.
     */
    Individual inRanks(final Occurrence occurrence) {
        if(occurrence.inRanks == null) {
            occurrence.inRanks = newIndividual(occurrence);

            final Lineage lineage = occurrence.candidate.lineage();
            if(lineage.kind() != Lineage.Kind.NONE) {
                final Relationship relationship = toRelationship(occurrence.candidate, lineage, rankPairs);
                for(final Candidate predecessor : lineage.predecessors()) {
                    relationship.getTarget().add(previousIndividualOf(predecessor));
                }
                occurrence.inRanks.getRelationships().add(relationship);
            }
        }

        return occurrence.inRanks;
    }

    /**
     * @return The individual of the occurrence in the steps, related to its direct
     *   predecessors; created at the first call.
     */
    private Individual inSteps(final Occurrence occurrence) {
        if(occurrence.inSteps == null) {
            occurrence.inSteps = newIndividual(occurrence);

            final Lineage lineage = occurrence.candidate.stepLineage();
            if(lineage.kind() != Lineage.Kind.NONE) {
                final Relationship relationship = toRelationship(occurrence.candidate, lineage, null);
                for(final Candidate predecessor : lineage.predecessors()) {
                    relationship.getTarget().add(directIndividualOf(predecessor, occurrence.id));
                }
                occurrence.inSteps.getRelationships().add(relationship);
            }
        }

        return occurrence.inSteps;
    }

    /**
     * Links the recombinations of the siblings: a candidate that occurs several times is linked
     *   with its first individual; a recombination whose sibling is not recorded keeps no
     *   sibling.
     *
     * @throws IllegalStateException if more than two candidates share a pair.
     */
    private static void linkSiblings(final Map<Object, Map<Candidate, Recombination>> pairs) {
        for(final Map<Candidate, Recombination> siblings : pairs.values()) {
            if(siblings.size() > 2) {
                throw new IllegalStateException(siblings.size() + " candidates share the pair of a recombination.");
            }
            if(siblings.size() == 2) {
                final List<Recombination> recombinations = List.copyOf(siblings.values());
                recombinations.get(0).setOther(recombinations.get(1));
                recombinations.get(1).setOther(recombinations.get(0));
            }
        }
    }

    /**
     * Links the recombinations of two outputs of a step whose step lineages share a pair, if
     *   neither has a sibling yet; with more than two such outputs, none of them is linked.
     */
    private static void linkSiblingsOfStep(final List<Occurrence> outputs) {
        final Map<Object, List<Recombination>> byPair = new IdentityHashMap<>();
        for(final Occurrence occurrence : outputs) {
            // a lineage with a pair is a recombination
            final Object pair = occurrence.candidate.stepLineage().pair();
            if(pair == null) {
                continue;
            }

            final Recombination recombination = (Recombination) occurrence.inSteps.getRelationships().getFirst();
            final List<Recombination> siblings = byPair.computeIfAbsent(pair, ignored -> new ArrayList<>());
            if(recombination.getOther() == null && !siblings.contains(recombination)) {
                siblings.add(recombination);
            }
        }

        for(final List<Recombination> siblings : byPair.values()) {
            if(siblings.size() == 2) {
                siblings.get(0).setOther(siblings.get(1));
                siblings.get(1).setOther(siblings.get(0));
            }
        }
    }

    /**
     * @return The individual of the occurrence with its id, values, fitness, properties and
     *   degrees of constraint violation, without relationships. A candidate that was not
     *   evaluated, e.g., because the evaluation budget ran out, has no output.
     * @throws IllegalStateException if a property is not defined or does not match its
     *   definition.
     */
    private Individual newIndividual(final Occurrence occurrence) {
        final Candidate candidate = occurrence.candidate;

        final Individual individual = MemoryFactory.eINSTANCE.createIndividual();
        individual.setId(occurrence.id);
        individual.setInput(candidate.input());
        individual.setOutput(candidate.output());

        final Fitness fitness = candidate.fitness();
        if(fitness != null) {
            Arrays.stream(fitness.values())
                  .forEach(individual.getFitness()::add);
        }

        candidate.properties().forEach((name, value) -> {
            recorder.requireProperty(name, PropertyScope.INDIVIDUAL, value);
            individual.getProperties().put(name, value);
        });

        final Map<String, Double> violations = candidate.isEvaluated()
                ? candidate.evaluation().violations().toProperties()
                : Map.of();
        violations.forEach((name, degree) -> {
            recorder.requireProperty(name, PropertyScope.INDIVIDUAL, degree);
            individual.getProperties().put(name, degree);
        });

        return individual;
    }

    /**
     * @return The occurrences of the candidates of the list: the n-th occurrence of a candidate
     *   in the list is its n-th occurrence in the iteration, which gets the next id when it is
     *   new.
     */
    List<Occurrence> occurrencesOf(final List<Candidate> candidates) {
        final Map<Candidate, Integer> counts = new IdentityHashMap<>();
        final List<Occurrence> result = new ArrayList<>(candidates.size());

        for(final Candidate candidate : candidates) {
            final int index = counts.merge(candidate, 1, Integer::sum) - 1;
            final List<Occurrence> recorded = occurrences.computeIfAbsent(candidate, ignored -> new ArrayList<>());
            if(index == recorded.size()) {
                recorded.add(new Occurrence(candidate, idGenerator.nextId()));
            }

            result.add(recorded.get(index));
        }

        return result;
    }

    /**
     * @return The individual of the previous iteration that a predecessor stands for: its own
     *   or, for an unchanged copy, the one of its original.
     * @throws IllegalStateException if the predecessor does not belong to the previous iteration.
     */
    private Individual previousIndividualOf(final Candidate predecessor) {
        Candidate candidate = predecessor;

        while(!previous.containsKey(candidate)) {
            if(candidate.lineage().kind() != Lineage.Kind.IDENTITY) {
                throw new IllegalStateException("The predecessor " + predecessor + " is not a member of the "
                                                + "previous iteration.");
            }

            candidate = candidate.lineage().predecessor();
        }

        return previous.get(candidate);
    }

    /**
     * Creates the ranks from the occurrences of the members; call it after {@link #toSteps}, so
     *   that the ids of the step outputs come first.
     *
     * @param members The occurrences of the members, indexed as the members.
     * @param ranks The member indices of every rank, the best rank first.
     * @return The ranks of the iteration.
     */
    List<Rank> toRanks(final List<Occurrence> members, final List<List<Integer>> ranks) {
        members.forEach(this::inRanks);
        linkSiblings(rankPairs);

        final List<Rank> result = new ArrayList<>();
        for(final List<Integer> indices : ranks) {
            final Rank rank = MemoryFactory.eINSTANCE.createRank();
            rank.setNumber(result.size());
            indices.forEach(index -> rank.getMembers().add(inRanks(members.get(index))));

            result.add(rank);
        }

        return result;
    }

    /**
     * @param pairs The recombinations by the pair of their lineage, to which a recombination with
     *   a pair is added for its sibling; {@code null} if siblings are linked otherwise.
     * @return The relationship of the lineage with its properties, without targets.
     * @throws IllegalStateException if a property is not defined or does not match its
     *   definition.
     */
    private Relationship toRelationship(final Candidate candidate,
                                        final Lineage lineage,
                                        final Map<Object, Map<Candidate, Recombination>> pairs) {
        final Relationship relationship = switch(lineage.kind()) {
            case IDENTITY -> MemoryFactory.eINSTANCE.createIdentity();
            case MUTATION -> MemoryFactory.eINSTANCE.createMutation();
            case RECOMBINATION -> MemoryFactory.eINSTANCE.createRecombination();
            case REPLACEMENT -> MemoryFactory.eINSTANCE.createReplacement();
            case NONE -> throw new IllegalArgumentException("A lineage without predecessors has no relationship.");
        };

        lineage.properties().forEach((name, value) -> {
            recorder.requireProperty(name, PropertyScope.RELATIONSHIP, value);
            relationship.getProperties().put(name, value);
        });

        if(pairs != null && lineage.pair() != null) {
            pairs.computeIfAbsent(lineage.pair(), pair -> new IdentityHashMap<>())
                 .putIfAbsent(candidate, (Recombination) relationship);
        }

        return relationship;
    }

    /**
     * Creates the steps of the memory model with their outputs; call it before {@link #toRanks}.
     *
     * @param steps The executed steps with their outputs, in execution order.
     * @return The steps, described as "kind: description".
     */
    List<IterationStep> toSteps(final List<ExecutedStep> steps) {
        final List<List<Occurrence>> outputs = steps.stream()
                                                    .map(step -> occurrencesOf(step.outputs()))
                                                    .toList();
        outputs.forEach(list -> list.forEach(this::inSteps));
        outputs.forEach(IterationRecording::linkSiblingsOfStep);

        final List<IterationStep> result = new ArrayList<>(steps.size());
        for(int i = 0; i < steps.size(); ++i) {
            final ExecutedStep step = steps.get(i);
            final UnorderedIterationStep executed = MemoryFactory.eINSTANCE.createUnorderedIterationStep();
            executed.setDescription(step.kind() + ": " + step.description());

            for(final Occurrence occurrence : outputs.get(i)) {
                final Individual individual = inSteps(occurrence);
                final boolean contained = individual.eContainer() != null;
                executed.getIndividuals().add(contained ? EcoreUtil.copy(individual) : individual);
            }

            result.add(executed);
        }

        return result;
    }

    /**
     * One occurrence of a candidate in the iteration: an individual with its id.
     */
    static final class Occurrence {
        /**
         * The candidate.
         */
        private final Candidate candidate;

        /**
         * The id of the individual.
         */
        private final int id;

        /**
         * The individual in the ranks, {@code null} until it is created.
         */
        private Individual inRanks;

        /**
         * The individual in the steps, {@code null} until it is created.
         */
        private Individual inSteps;

        Occurrence(final Candidate candidate, final int id) {
            this.candidate = candidate;
            this.id = id;
        }

        /**
         * @return The candidate.
         */
        Candidate candidate() {
            return candidate;
        }
    }
}
