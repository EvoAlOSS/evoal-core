package de.evoal.optimisation.main.comparator;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.utils.AttributeHelper;

/**
 * The feasibility rules (DL type {@code 'feasibility-comparator'}; K. Deb: An efficient
 *   constraint handling method for genetic algorithms. Computer Methods in Applied Mechanics
 *   and Engineering 186(2-4), 2000, pp. 311-338): a feasible candidate is better than an
 *   infeasible one; two feasible candidates are compared by their fitness, two infeasible
 *   ones by the violation of the group. Feasible means that every constraint of the group is
 *   satisfied.
 */
@Dependent
@Named("de.evoal.optimisation.core.feasibility-comparator")
public class FeasibilityComparator extends AbstractFeasibilityComparator {
    /**
     * The constraint group.
     */
    private String group;

    @Inject
    private AttributeHelper helper;

    /**
     * Creates the comparator without configuration. CDI uses it before {@link #init(EObject)}.
     */
    public FeasibilityComparator() {
    }

    /**
     * @param group The constraint group.
     */
    public FeasibilityComparator(final String group) {
        this.group = group;
    }

    @Override
    protected double epsilon() {
        return 0.0;
    }

    @Override
    protected boolean fitnessOnEqualViolation() {
        return false;
    }

    @Override
    protected String group() {
        return group;
    }

    @Override
    public FeasibilityComparator init(final EObject configuration) {
        group = helper.lookup(configuration, "group");

        return this;
    }
}
