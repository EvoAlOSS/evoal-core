package de.evoal.optimisation.api.correlations;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.RunScoped;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.v202704.optimisation.model.Problem;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.main.constraints.CorrelationCompiler;

/**
 * The correlations and the building blocks of the optimisation problem of the run, declared
 *   in the DDL ({@code correlation}, {@code 'ranged-correlation'}, {@code 'building-block'}).
 *   Every run has its own bean, which reads them when it is created. A correlation with a
 *   nominal feature is rejected when the DDL file is loaded, since no component can use it.
 */
@RunScoped
public class ProblemCorrelations {
    @Inject
    private Blackboard board;

    @Inject
    private CorrelationCompiler compiler;

    /**
     * The correlations of the run.
     */
    private Correlations correlations = Correlations.NONE;

    @Inject
    private AttributeHelper helper;

    /**
     * @return The correlations of the run.
     */
    public Correlations correlations() {
        return correlations;
    }

    /**
     * Uses the given correlations, e.g., for tests.
     *
     * @param given The correlations.
     */
    public void setUp(final Correlations given) {
        correlations = given;
    }

    /**
     * Reads the correlations of the problem from the optimisation configuration.
     */
    @PostConstruct
    public void initialise() {
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
