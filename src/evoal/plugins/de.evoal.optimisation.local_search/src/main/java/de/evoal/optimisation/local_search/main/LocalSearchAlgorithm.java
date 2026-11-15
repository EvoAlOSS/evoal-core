package de.evoal.optimisation.local_search.main;

import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;

import de.evoal.core.api.cdi.RunScoped;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Identity;
import de.evoal.models.v202704.optimisation.memory.Mutation;
import de.evoal.models.v202704.optimisation.memory.Relationship;
import de.evoal.models.v202704.optimisation.memory.Rank;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.optimisation.api.producer.SpaceProducer;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;


import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.cdi.ConfigurationValue;
import de.evoal.core.api.utils.AttributeHelper;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.cdi.TerminationCriterionProducer;
import de.evoal.optimisation.api.model.*;

import de.evoal.optimisation.local_search.api.accepting.AcceptingStrategy;
import de.evoal.optimisation.local_search.api.neighbour.NeighbourChoosingStrategy;
import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.eclipse.emf.ecore.EObject;

/**
 * A local search algorithm.
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

    @Inject
    @ConfigurationValue(entry = OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION, access = "algorithm.number-of-iterations")
    private int maxIterations;

    @Inject
    @Named("optimisation-function")
    private OptimisationFunction fitness;

    @Inject
    private AttributeHelper helper;

    @Inject
    private TerminationCriterionProducer producer;

    @Inject @Named("initial")
    private InitialCandidatesProvider provider;

    @Inject @Named("neighbour-strategy")
    private NeighbourChoosingStrategy strategy;

    @Inject @Component
    private StatisticsWriter statistics;

    @Inject
    private IndividualIDGenerator idGenerator;

    /**
     * The individual of the previous iteration, i.e., the one the current candidate is a neighbour of.
     */
    private Individual previousIndividual;

    @Override
    public OptimisationAlgorithm init(final EObject instance) {
        criterion = producer.create(instance);
        acceptingStrategy = BeanFactory.createComponent(AcceptingStrategy.class, helper.lookup(instance, "accepting-strategy"));

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
        final TypedEObject output = fitness.evaluate(candidate);
        return new Evaluated(candidate, output, comparator.apply(output));
    }

    @Override
    public void run() {
        log.info("Setting up local search algorithm.");

        final CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.getContextControl()
                    .startContext(RunScoped.class);

        //1. create init new search space candidate
        Evaluated current = evaluate(provider.create().findFirst().get());

        // Log initial iteration
        Iteration state = toIteration(0, current);
        statistics.add(state);

        // 2. iterate  until stopping criteria is met or there is no new neighbour
        int iterationNumber = 1;
        while(criterion.shouldContinue(state)) {
            // 2.1 Just a final copy to satisfy Java
            final OptimisationValue currentValue = current.value();

            // 2.2 Search for acceptable candidate (lazily, every neighbour is evaluated once)
            final Optional<Evaluated> acceptableCandidate =
                    strategy.neighbours(current.candidate())
                            .map(this::evaluate)
                            .filter(c -> acceptingStrategy.acceptCandidate(c.value(), currentValue))
                            .findFirst();

            // 2.3 No candidate found
            if(acceptableCandidate.isEmpty()) {
                log.info("No improvement in generation {}. Terminating optimisation.", iterationNumber);

                // the candidate stays the same, record the final iteration anyway
                statistics.add(toIteration(iterationNumber, current, false));
                break;
            }

            // 2.4 update candidate information
            current = acceptableCandidate.get();

            // 2.5 Update protocol
            state = toIteration(iterationNumber, current);
            statistics.add(state);

            // 2.6 Update iteration-specific data
            acceptingStrategy.setIteration(iterationNumber, maxIterations);
            iterationNumber += 1;
        }

        log.info("Candidate after {} iterations: {}", iterationNumber - 1, current.candidate());

        this.statistics.write();
        cdiContainer.getContextControl()
                    .stopContext(RunScoped.class);

    }

    private Iteration toIteration(final int iteration, final Evaluated evaluated) {
        return toIteration(iteration, evaluated, true);
    }

    /**
     * Creates the memory state of an iteration.
     *
     * @param moved {@code true} if the candidate is a neighbour of the previous one ({@link Mutation}),
     *   {@code false} if it is unchanged ({@link Identity}).
     */
    private Iteration toIteration(final int iteration, final Evaluated evaluated, final boolean moved) {
        log.info("{}: {} -> {}.", iteration, evaluated.candidate(), evaluated.value());

        final Individual individual = MemoryFactory.eINSTANCE.createIndividual();
        individual.setId(idGenerator.nextId());
        individual.setInput(evaluated.candidate());
        individual.setOutput(evaluated.output());

        // the candidate is either a neighbour, i.e., a mutated version, of the previous one or the same
        if(previousIndividual != null) {
            final Relationship relationship = moved ? MemoryFactory.eINSTANCE.createMutation()
                                                    : MemoryFactory.eINSTANCE.createIdentity();
            relationship.getTarget().add(previousIndividual);
            individual.getRelationships().add(relationship);
        }
        previousIndividual = individual;

        final Rank first = MemoryFactory.eINSTANCE.createRank();
        first.setNumber(0);
        first.getMembers().add(individual);

        final Iteration state = MemoryFactory.eINSTANCE.createIteration();
        state.setNumber(iteration);
        state.getRanks().add(first);

        return state;
    }
}
