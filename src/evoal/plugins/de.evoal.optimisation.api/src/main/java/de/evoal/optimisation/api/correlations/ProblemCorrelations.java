package de.evoal.optimisation.api.correlations;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

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
 * The correlations and the building blocks of the optimisation problem of the current run,
 *   declared in the DDL ({@code correlation}, {@code 'ranged-correlation'},
 *   {@code 'building-block'}). They are read at the start of every
 *   run, before the algorithm is created; the bean uses the run start of the
 *   {@link MetricContributor}s for this and contributes no metrics. A correlation with a
 *   nominal feature is rejected when the DDL file is loaded, since no component can use it.
 */
@ApplicationScoped
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
        // a correlation with a nominal feature is rejected when the DDL file is loaded
        setUp(compiler.compile(problem));
    }
}
