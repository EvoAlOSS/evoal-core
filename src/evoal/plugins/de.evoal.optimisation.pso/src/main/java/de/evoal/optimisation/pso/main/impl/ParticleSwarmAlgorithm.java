package de.evoal.optimisation.pso.main.impl;

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
import de.evoal.optimisation.api.run.OptimisationRun;
import de.evoal.optimisation.api.run.Population;
import de.evoal.optimisation.api.run.Progress;
import de.evoal.optimisation.api.run.SearchProcedure;

import de.evoal.optimisation.pso.api.optimiser.Swarm;

/**
 * Particle swarm optimisation. Every iteration moves and evaluates the particles of the
 *   swarm; the run itself is executed by the {@link OptimisationRun}.
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
        kernel.execute(criterion, new Search());
    }

    /**
     * The search of a run: initialising, moving and evaluating the swarm.
     */
    private final class Search implements SearchProcedure {
        /**
         * Describes the particles as population.
         */
        private final SwarmPopulation population = new SwarmPopulation();

        @Override
        public void initialise() {
            swarm.initialise();
        }

        @Override
        public Progress iterate(final int iteration) {
            log.info("Processing generation: {}", iteration);

            swarm.move(iteration);
            swarm.evaluate();

            return Progress.CONTINUE;
        }

        @Override
        public Population population() {
            return population.toPopulation(swarm.getParticles());
        }
    }
}
