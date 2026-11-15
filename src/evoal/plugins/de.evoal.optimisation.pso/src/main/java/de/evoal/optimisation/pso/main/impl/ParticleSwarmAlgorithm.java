package de.evoal.optimisation.pso.main.impl;

import de.evoal.models.v202704.optimisation.execution.OptimisationFunction;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.Rank;
import de.evoal.optimisation.api.cdi.TerminationCriterionProducer;
import de.evoal.optimisation.api.model.*;
import de.evoal.optimisation.api.statistics.writer.StatisticsWriter;
import de.evoal.optimisation.pso.api.optimiser.Swarm;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.optimisation.pso.api.swarm.Particle;
import lombok.extern.slf4j.Slf4j;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.eclipse.emf.ecore.EObject;

import java.util.*;

@Slf4j
@Dependent
@Named("de.evoal.optimisation.pso.optimisation.particle-swarm-optimisation")
public class ParticleSwarmAlgorithm implements OptimisationAlgorithm {

    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    private TerminationCriterion criterion;

    @Inject
    private AttributeHelper helper;

    private int maximumNumberOfGenerations;

    @Inject @Dependent @Component
    private OptimisationFunction optimisationFunction;

    @Inject
    private TerminationCriterionProducer producer;

    @Inject @Component
    private StatisticsWriter statistics;

    /**
     * The used swarm implementation
     */
    private Swarm swarm;

    @Override
    public OptimisationAlgorithm init(final EObject configuration) {
        swarm = BeanFactory.createComponent(Swarm.class, helper.lookup(configuration, "swarm"));
        criterion = producer.create(configuration);
        maximumNumberOfGenerations = helper.lookup(configuration, "number-of-generations");

        return this;
    }

    @Override
    public void run() {
        int generation = 0;
        swarm.initialise();

        Iteration snapshot = toIteration(generation, swarm);

        statistics.add(snapshot);
        while(criterion.shouldContinue(snapshot)) {
            generation = generation + 1;

            log.info("Processing generation: {}", generation);

            swarm.move(generation, maximumNumberOfGenerations);
            swarm.evaluate();

            snapshot = toIteration(generation, swarm);
            statistics.add(snapshot);
        }

        statistics.write();
    }

    private Iteration toIteration(final int generation, final Swarm swarm) {
        final Iteration result = MemoryFactory.eINSTANCE.createIteration();

        result.setNumber(generation);

        result.getRanks()
              .addAll(toRanks(swarm));


        return result;
    }

    private Collection<? extends Rank> toRanks(final Swarm swarm) {
        final List<Particle> particles = Arrays.asList(swarm.getParticles());

        particles.sort(Comparator.comparing(Particle::getCurrentFitness));

        final List<Rank> ranks = new ArrayList<>();

        int rankNumber = 0;
        Particle lastParticle = particles.getFirst();

        Rank rank = MemoryFactory.eINSTANCE.createRank();
        rank.setNumber(rankNumber++);
        rank.getMembers().add(lastParticle.toIndividual());
        ranks.add(rank);

        for(int i = 1; i < particles.size(); i++) {
            Particle particle = particles.get(i);

            if(particle.getCurrentFitness().isWorse(lastParticle.getCurrentFitness())) {
                rank =  MemoryFactory.eINSTANCE.createRank();
                rank.setNumber(rankNumber++);

                ranks.add(rank);
            }

            rank.getMembers().add(particle.toIndividual());
            lastParticle = particle;
        }


        return ranks;
    }
}
