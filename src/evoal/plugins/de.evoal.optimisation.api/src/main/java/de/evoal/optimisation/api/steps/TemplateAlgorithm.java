package de.evoal.optimisation.api.steps;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;

import de.evoal.optimisation.api.cdi.TerminationCriterionProducer;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.run.OptimisationRun;

/**
 * An optimisation algorithm that is a template of steps. It creates the termination
 *   criterion of its configuration and runs its {@link Template} on the run kernel
 *   ({@link OptimisationRun}). A subclass reads the rest of its configuration in
 *   {@link #configure(EObject)} and assembles its steps in {@link #template()}.
 */
public abstract class TemplateAlgorithm implements OptimisationAlgorithm {
    /**
     * The termination criterion of the configuration.
     */
    private TerminationCriterion criterion;

    /**
     * Executes the run.
     */
    @Inject
    private OptimisationRun kernel;

    @Inject
    private TerminationCriterionProducer producer;

    /**
     * Creates the termination criterion, then lets the subclass read its configuration.
     */
    @Override
    public final OptimisationAlgorithm init(final EObject configuration) throws InitializationException {
        criterion = producer.create(configuration);
        configure(configuration);
        return this;
    }

    /**
     * Reads the algorithm-specific part of the configuration.
     *
     * @param configuration The configuration of the algorithm.
     * @throws InitializationException if the configuration cannot be used.
     */
    protected abstract void configure(EObject configuration) throws InitializationException;

    @Override
    public final void run() {
        kernel.execute(criterion, template());
    }

    /**
     * @return A new template of the algorithm for one run.
     */
    protected abstract Template template();
}
