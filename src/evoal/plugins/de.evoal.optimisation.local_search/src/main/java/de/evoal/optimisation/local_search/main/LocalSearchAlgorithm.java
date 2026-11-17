package de.evoal.optimisation.local_search.main;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;

import de.evoal.optimisation.api.cdi.TerminationCriterionProducer;
import de.evoal.optimisation.api.evaluation.EvaluationService;
import de.evoal.optimisation.api.model.InitialCandidatesProvider;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.Lineage;
import de.evoal.optimisation.api.run.OptimisationRun;
import de.evoal.optimisation.api.run.Population;
import de.evoal.optimisation.api.run.Progress;
import de.evoal.optimisation.api.run.SearchProcedure;

import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;
import de.evoal.optimisation.local_search.api.neighbour.NeighbourChoosingStrategy;

/**
 * A local search algorithm. It holds a single candidate and moves to an acceptable
 *   neighbour in every iteration; the run itself is executed by the {@link OptimisationRun}.
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.local_search.optimisation.local-search")
public class LocalSearchAlgorithm implements OptimisationAlgorithm {
    private AcceptingStrategy acceptingStrategy;

    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    /**
     * The stopping criterion to use.
     */
    private TerminationCriterion criterion;

    /**
     * Evaluates and counts the candidates.
     */
    @Inject
    private EvaluationService evaluationService;

    @Inject
    private AttributeHelper helper;

    @Inject
    private TerminationCriterionProducer producer;

    @Inject @Named("initial")
    private InitialCandidatesProvider provider;

    @Inject @Named("neighbour-strategy")
    private NeighbourChoosingStrategy strategy;

    /**
     * Executes the run.
     */
    @Inject
    private OptimisationRun kernel;

    @Override
    public OptimisationAlgorithm init(final EObject instance) {
        criterion = producer.create(instance);
        final EObject acceptingConfiguration = helper.lookup(instance, "accepting-strategy");
        acceptingStrategy = BeanFactory.createComponent(AcceptingStrategy.class, acceptingConfiguration);

        return this;
    }

    /**
     * A candidate together with its evaluation. Each candidate is evaluated exactly once.
     *
     * @param candidate The search-space value.
     * @param output The result of the optimisation function.
     * @param value The optimisation value of the output.
     */
    private record Evaluated(TypedEObject candidate, TypedEObject output, OptimisationValue value) {}

    private Evaluated evaluate(final TypedEObject candidate) {
        final TypedEObject output = evaluationService.evaluate(candidate);
        return new Evaluated(candidate, output, comparator.apply(output));
    }

    @Override
    public void run() {
        log.info("Setting up local search algorithm.");

        kernel.execute(criterion, new Search());
    }

    /**
     * The search of a run: the current candidate and whether it changed since the previous
     *   iteration.
     */
    private final class Search implements SearchProcedure {
        /**
         * The current candidate, {@code null} before it is evaluated.
         */
        private Evaluated current;

        /**
         * Whether the current candidate is a neighbour of the previous one
         *   ({@link Lineage.Kind#MUTATION}) or the same ({@link Lineage.Kind#IDENTITY}).
         */
        private Lineage.Kind change = Lineage.Kind.NONE;

        /**
         * The member of the previous population, {@code null} before the first one.
         */
        private Candidate previous;

        @Override
        public void initialise() {
            current = evaluate(provider.create().findFirst().get());
            log.info("0: {} -> {}.", current.candidate(), current.value());
        }

        /**
         * Searches for an acceptable neighbour; every neighbour is evaluated once. Some
         *   strategies (simulated annealing) test a single random neighbour per iteration.
         *
         * @return {@link Progress#STOP} if no neighbour is acceptable and the rejection is
         *   final or there are no neighbours at all. Otherwise, the candidate stays and the
         *   next iteration tries again.
         */
        @Override
        public Progress iterate(final int iteration) {
            final OptimisationValue currentValue = current.value();

            // the candidate stays the same until a neighbour is accepted
            change = Lineage.Kind.IDENTITY;

            final Stream<TypedEObject> offeredNeighbours = acceptingStrategy.testsSingleNeighbour()
                    ? strategy.randomNeighbour(current.candidate()).stream()
                    : strategy.neighbours(current.candidate());
            final AtomicInteger numberOfNeighbours = new AtomicInteger();
            final Optional<Evaluated> acceptableCandidate =
                    offeredNeighbours.peek(neighbour -> numberOfNeighbours.incrementAndGet())
                                     .map(LocalSearchAlgorithm.this::evaluate)
                                     .filter(c -> acceptingStrategy.acceptCandidate(c.value(), currentValue))
                                     .findFirst();

            if(acceptableCandidate.isEmpty()) {
                if(acceptingStrategy.rejectionIsFinal() || numberOfNeighbours.get() == 0) {
                    log.info("No acceptable neighbour in generation {}. Terminating optimisation.", iteration);
                    return Progress.STOP;
                }

                log.info("No acceptable neighbour in generation {}. Keeping the candidate.", iteration);
                acceptingStrategy.setIteration(iteration);
                return Progress.CONTINUE;
            }

            // the neighbour is a mutated version of the previous candidate
            current = acceptableCandidate.get();
            change = Lineage.Kind.MUTATION;
            log.info("{}: {} -> {}.", iteration, current.candidate(), current.value());

            acceptingStrategy.setIteration(iteration);
            return Progress.CONTINUE;
        }

        /**
         * @return The current candidate in rank 0, no member before the initial candidate
         *   is evaluated.
         */
        @Override
        public Population population() {
            if(current == null) {
                return new Population(List.of(), List.of());
            }

            final Lineage lineage = switch(change) {
                case NONE -> Lineage.NONE;
                case IDENTITY -> Lineage.identity(previous);
                case MUTATION -> Lineage.mutation(previous);
                case RECOMBINATION -> throw new IllegalStateException("Local search does not recombine.");
            };
            final Candidate member = Candidate.evaluated(current.candidate(), current.output(), current.value(), lineage);
            previous = member;

            return Population.of(member);
        }
    }
}
