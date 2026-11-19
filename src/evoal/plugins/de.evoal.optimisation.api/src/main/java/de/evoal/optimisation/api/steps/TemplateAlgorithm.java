package de.evoal.optimisation.api.steps;

import java.util.List;
import java.util.Set;

import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;

import de.evoal.optimisation.api.cdi.TerminationCriterionProducer;
import de.evoal.optimisation.api.checks.CandidateCheckProducer;
import de.evoal.optimisation.api.checks.CheckNewCandidates;
import de.evoal.optimisation.api.checks.CheckPoint;
import de.evoal.optimisation.api.checks.CheckPopulation;
import de.evoal.optimisation.api.checks.ConfiguredCheck;
import de.evoal.optimisation.api.checks.Resampler;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.api.model.OptimisationAlgorithm;
import de.evoal.optimisation.api.run.OptimisationRun;

/**
 * An optimisation algorithm that is a template of steps. It creates the termination
 *   criterion and the candidate checks of its configuration and runs its {@link Template}
 *   on the run kernel ({@link OptimisationRun}). A subclass reads the rest of its
 *   configuration in {@link #configure(EObject)} and assembles its steps in
 *   {@link #template()}.
 * <p>
 * A subclass states the check points it offers ({@link #checkPoints()}) and places the
 *   steps of {@link #populationChecks(Evaluator)} and {@link #newCandidateChecks()} at them.
 *   A configured check whose check point the algorithm does not offer is rejected.
 */
public abstract class TemplateAlgorithm implements OptimisationAlgorithm {
    /**
     * The termination criterion of the configuration.
     */
    private TerminationCriterion criterion;

    /**
     * The candidate checks of the configuration.
     */
    private List<ConfiguredCheck> checks = List.of();

    @Inject
    private CandidateCheckProducer checkProducer;

    /**
     * Executes the run.
     */
    @Inject
    private OptimisationRun kernel;

    @Inject
    private TerminationCriterionProducer producer;

    /**
     * Creates the termination criterion and the candidate checks, then lets the subclass read
     *   its configuration.
     *
     * @throws InitializationException if a candidate check cannot be used with the algorithm.
     */
    @Override
    public final OptimisationAlgorithm init(final EObject configuration) throws InitializationException {
        criterion = producer.create(configuration);
        checks = checkProducer.create(configuration, checkPoints(), resamples());
        configure(configuration);
        return this;
    }

    /**
     * @return The check points at which the algorithm applies candidate checks; none by
     *   default.
     */
    protected Set<CheckPoint> checkPoints() {
        return Set.of();
    }

    /**
     * @return The step that applies the checks of new candidates, empty if none are
     *   configured. A new step for every template, so every run has its own replacement
     *   sources.
     */
    protected final List<Step> newCandidateChecks() {
        return newCandidateChecks(null);
    }

    /**
     * @param resampler Redoes the variation for the reaction {@code resample}; {@code null}
     *   if the algorithm cannot resample ({@link #resamples()}).
     * @return The step that applies the checks of new candidates, empty if none are
     *   configured. A new step for every template, so every run has its own replacement
     *   sources.
     */
    protected final List<Step> newCandidateChecks(final Resampler resampler) {
        final List<ConfiguredCheck> configured = checksAt(CheckPoint.NEW_CANDIDATES);

        return configured.isEmpty() ? List.of() : List.of(new CheckNewCandidates(configured, resampler));
    }

    /**
     * @return Whether the algorithm can redo the variation of a new candidate and passes a
     *   {@link Resampler} to {@link #newCandidateChecks(Resampler)}; {@code false} by default.
     */
    protected boolean resamples() {
        return false;
    }

    /**
     * @param evaluator Evaluates the replacements.
     * @return The step that applies the population checks, empty if none are configured. A
     *   new step for every template, so every run has its own replacement sources.
     */
    protected final List<Step> populationChecks(final Evaluator evaluator) {
        final List<ConfiguredCheck> configured = checksAt(CheckPoint.POPULATION);

        return configured.isEmpty() ? List.of() : List.of(new CheckPopulation(configured, evaluator));
    }

    private List<ConfiguredCheck> checksAt(final CheckPoint point) {
        return checks.stream()
                     .filter(configured -> configured.check().checkPoint() == point)
                     .toList();
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
