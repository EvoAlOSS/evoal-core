package de.evoal.optimisation.pso.main.impl;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.Component;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;

import de.evoal.optimisation.api.cdi.TerminationCriterionProducer;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.model.OptimisationValueComparator;
import de.evoal.optimisation.api.events.RunEventDispatcher;
import de.evoal.optimisation.api.run.Candidate;
import de.evoal.optimisation.api.run.OptimisationRun;
import de.evoal.optimisation.api.steps.Step;
import de.evoal.optimisation.api.steps.Template;

import de.evoal.optimisation.pso.api.optimiser.Swarm;

/**
 * Particle swarm optimisation (DL type {@code 'particle-swarm-optimisation'}) as a template
 *   of steps ({@link SwarmSteps}). The particles of the swarm are its strategy state.
 * <p>
 * Initialisation: create and evaluate the particles (Initialization).
 * <p>
 * Every iteration:
 * <ol>
 *   <li>ParameterAdjustment: adjust the swarm, e.g., the direction of ARPSO,</li>
 *   <li>Adaption: move the particles,</li>
 *   <li>FitnessCalculation: evaluate their new positions,</li>
 *   <li>Acceptance: update the personal bests.</li>
 * </ol>
 * The population of an iteration consists of the particles ({@link SwarmPopulation}).
 */
@Slf4j
@Dependent
@Named("de.evoal.optimisation.pso.optimisation.particle-swarm-optimisation")
public class ParticleSwarmAlgorithm implements OptimisationAlgorithm {

    @Inject @Dependent @Component
    private OptimisationValueComparator comparator;

    private TerminationCriterion criterion;

    @Inject
    private AttributeHelper helper;

    @Inject
    private TerminationCriterionProducer producer;

    /**
     * Executes the run.
     */
    @Inject
    private OptimisationRun kernel;

    /**
     * Publishes the executed steps.
     */
    @Inject
    private RunEventDispatcher events;

    /**
     * The used swarm implementation
     */
    private Swarm swarm;

    @Inject
    @Named("search-space")
    private Space searchSpace;

    /**
     * Checks that every search variable is real-valued: the movers add velocities to the
     *   positions and set the results as {@code double} values.
     *
     * @throws InitializationException if a search variable is not real-valued.
     */
    @Override
    public OptimisationAlgorithm init(final EObject configuration) throws InitializationException {
        for(final EStructuralFeature feature : searchSpace) {
            if(!EClassifierHelper.isReal(feature.getEType())) {
                throw new InitializationException("Particle swarm optimisation supports only real search variables, but '" + feature.getName() + "' is of type " + feature.getEType().getName() + ".");
            }
        }

        swarm = BeanFactory.createComponent(Swarm.class, helper.lookup(configuration, "swarm"));
        criterion = producer.create(configuration);

        return this;
    }

    @Override
    public void run() {
        kernel.execute(criterion, new SwarmTemplate());
    }

    /**
     * The template of particle swarm optimisation; its population describes the particles.
     */
    private final class SwarmTemplate extends Template {
        /**
         * Describes the particles as members.
         */
        private final SwarmPopulation population = new SwarmPopulation();

        private SwarmTemplate() {
            super(events,
                  List.<Step>of(SwarmSteps.initialise(swarm)),
                  List.of(SwarmSteps.adjust(swarm),
                          SwarmSteps.move(swarm),
                          SwarmSteps.evaluate(swarm),
                          SwarmSteps.updatePersonalBests(swarm)));
        }

        @Override
        protected List<Candidate> members() {
            return population.toMembers(swarm.getParticles());
        }
    }
}
