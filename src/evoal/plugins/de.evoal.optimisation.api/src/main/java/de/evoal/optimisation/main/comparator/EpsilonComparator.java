package de.evoal.optimisation.main.comparator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;

/**
 * The epsilon-level comparison (DL type {@code 'epsilon-comparator'}; T. Takahama, S. Sakai:
 *   Constrained optimization by the epsilon constrained differential evolution with
 *   gradient-based mutation and feasible elites. IEEE Congress on Evolutionary Computation
 *   2006, pp. 1-8): a candidate whose violation of the group is at most {@code epsilon} counts
 *   as feasible. Two feasible candidates, and two candidates with the same violation, are
 *   compared by their fitness; a feasible candidate is better than an infeasible one; two
 *   other infeasible candidates are compared by their violation.
 */
@Dependent
@Named("de.evoal.optimisation.core.epsilon-comparator")
public class EpsilonComparator extends AbstractFeasibilityComparator {
    /**
     * The violation up to which a candidate counts as feasible.
     */
    private double epsilon;

    /**
     * The constraint group.
     */
    private String group;

    @Inject
    private AttributeHelper helper;

    /**
     * Creates the comparator without configuration. CDI uses it before {@link #init(EObject)}.
     */
    public EpsilonComparator() {
    }

    /**
     * @param group The constraint group.
     * @param epsilon The violation up to which a candidate counts as feasible.
     * @throws IllegalArgumentException if epsilon is negative.
     */
    public EpsilonComparator(final String group, final double epsilon) {
        this.group = group;
        this.epsilon = requireEpsilon(epsilon);
    }

    @Override
    protected double epsilon() {
        return epsilon;
    }

    @Override
    protected boolean fitnessOnEqualViolation() {
        return true;
    }

    @Override
    protected String group() {
        return group;
    }

    @Override
    public EpsilonComparator init(final EObject configuration) throws InitializationException {
        group = helper.lookup(configuration, "group");
        final double configuredEpsilon = helper.<Number>lookup(configuration, "epsilon")
                                               .doubleValue();

        try {
            epsilon = requireEpsilon(configuredEpsilon);
        } catch(final IllegalArgumentException e) {
            throw new InitializationException(e.getMessage());
        }

        return this;
    }

    private static double requireEpsilon(final double epsilon) {
        // also rejects NaN
        if(!(epsilon >= 0.0)) {
            throw new IllegalArgumentException("The 'epsilon' of 'epsilon-comparator' must not be negative, but is "
                                               + epsilon + ".");
        }

        return epsilon;
    }
}
