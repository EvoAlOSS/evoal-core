package de.evoal.optimisation.api.correlations;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.model.Problem;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.execution.MetricContributor;
import de.evoal.optimisation.main.constraints.CorrelationCompiler;

/**
 * The correlations of the optimisation problem of the current run, declared in the DDL
 *   ({@code correlation}, {@code 'ranged-correlation'}). They are read at the start of every
 *   run, before the algorithm is created; the bean uses the run start of the
 *   {@link MetricContributor}s for this and contributes no metrics. Correlations with a
 *   nominal feature are reported, since no component can use them.
 */
@ApplicationScoped
@Slf4j
public class ProblemCorrelations implements MetricContributor {
    @Inject
    private Blackboard board;

    @Inject
    private CorrelationCompiler compiler;

    /**
     * The correlations of the current run.
     */
    private Correlations correlations = Correlations.NONE;

    @Inject
    private AttributeHelper helper;

    /**
     * @return The correlations of the current run.
     */
    public Correlations correlations() {
        return correlations;
    }

    @Override
    public void contributeTo(final Iteration iteration) {
    }

    /**
     * Uses the given correlations, e.g., for tests.
     *
     * @param given The correlations.
     */
    public void setUp(final Correlations given) {
        correlations = given;
    }

    @Override
    public void startRun(final ExecutionRecorder recorder) {
        final EObject configuration = board.getOrNull(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION);
        if(configuration == null) {
            setUp(Correlations.NONE);

            return;
        }

        final Problem problem = helper.lookup(configuration, "problem");
        setUp(compiler.compile(problem));

        correlations.all()
                    .stream()
                    .filter(correlation -> correlation.kind() == CorrelationKind.NOMINAL)
                    .forEach(correlation -> log.warn("The {} has a nominal feature; its values have no order, so it is "
                                                     + "skipped.", correlation));
    }
}
