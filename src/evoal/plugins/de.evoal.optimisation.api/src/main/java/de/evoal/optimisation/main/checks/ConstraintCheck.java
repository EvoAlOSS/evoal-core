package de.evoal.optimisation.main.checks;

import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.checks.AbstractCandidateCheck;
import de.evoal.optimisation.api.checks.CheckPoint;
import de.evoal.optimisation.api.checks.CheckReaction;
import de.evoal.optimisation.api.checks.Repair;
import de.evoal.optimisation.api.constraints.Constraint;
import de.evoal.optimisation.api.constraints.ConstraintEvaluation;
import de.evoal.optimisation.api.constraints.ConstraintRepair;
import de.evoal.optimisation.api.constraints.Constraints;
import de.evoal.optimisation.api.constraints.PartialViolationRecord;
import de.evoal.optimisation.api.run.Candidate;

/**
 * Fails a new candidate that violates a constraint of its group (DL type
 *   {@code 'constraint-check'}), before the candidate is evaluated. The constraints of the
 *   group are measured with the {@code 'constraint-measure'} of the algorithm; the degrees are
 *   kept on the candidate, so its evaluation does not measure them again. For the reaction
 *   {@code repair}, the configured {@link ConstraintRepair} changes the candidate.
 * <p>
 * The configuration is rejected if the group is not declared in the DDL, if it contains a
 *   constraint on objectives (which can only be measured after the evaluation), if
 *   {@code repair} is set without the reaction {@code repair} or the other way round, if the
 *   fallback is {@code repair}, or if the repair cannot handle a constraint of the group.
 */
@Dependent
@Named("de.evoal.optimisation.core.constraint-check")
public class ConstraintCheck extends AbstractCandidateCheck {
    @Inject
    private ConstraintEvaluation evaluation;

    /**
     * The checked group.
     */
    private String group;

    /**
     * The constraints of the group, in the order of the DDL.
     */
    private List<Constraint> groupConstraints;

    @Inject
    private AttributeHelper helper;

    /**
     * The repair with its fallback, {@code null} without repair.
     */
    private Repair repair;

    /**
     * Creates a check that is configured by {@link #init(EObject)}.
     */
    public ConstraintCheck() {
    }

    /**
     * Creates a configured check, e.g., for tests.
     *
     * @param group The checked group.
     * @param reaction The reaction to a failed candidate.
     * @param maximumAttempts The maximum number of attempts of {@code resample} or {@code repair}.
     * @param evaluation Measures the constraints.
     * @param constraintRepair The repair strategy, {@code null} without repair.
     * @param fallback The reaction if the repair fails.
     * @throws InitializationException if the configuration cannot be used.
     */
    public ConstraintCheck(final String group, final CheckReaction reaction, final int maximumAttempts,
                           final ConstraintEvaluation evaluation, final ConstraintRepair constraintRepair,
                           final CheckReaction fallback) throws InitializationException {
        super(reaction, maximumAttempts);
        this.evaluation = evaluation;
        setUp(group, constraintRepair, fallback);
    }

    @Override
    public CheckPoint checkPoint() {
        return CheckPoint.NEW_CANDIDATES;
    }

    @Override
    protected void configure(final EObject configuration) throws InitializationException {
        final String configuredGroup = helper.lookup(configuration, "group");

        ConstraintRepair constraintRepair = null;
        final EStructuralFeature repairFeature = configuration.eClass().getEStructuralFeature("repair");
        if(repairFeature != null && configuration.eIsSet(repairFeature)) {
            constraintRepair = BeanFactory.createComponent(ConstraintRepair.class, (EObject) configuration.eGet(repairFeature));
        }

        final EEnumLiteral fallback = helper.lookup(configuration, "repair-fallback");
        setUp(configuredGroup, constraintRepair, CheckReaction.of(fallback));
    }

    @Override
    public String name() {
        return "constraint-check";
    }

    @Override
    public Optional<Repair> repair() {
        return Optional.ofNullable(repair);
    }

    /**
     * Validates the configuration and keeps it.
     */
    private void setUp(final String configuredGroup, final ConstraintRepair constraintRepair, final CheckReaction fallback)
            throws InitializationException {
        final Constraints constraints = evaluation.constraints();
        if(!constraints.hasGroup(configuredGroup)) {
            throw new InitializationException("The 'constraint-check' names the constraint group '" + configuredGroup
                                              + "', but the DDL declares only " + constraints.groups() + ".");
        }

        final List<Constraint> inGroup = constraints.inGroup(configuredGroup);
        final List<Constraint> onObjectives = inGroup.stream()
                                                     .filter(Constraint::usesObjectives)
                                                     .toList();
        if(!onObjectives.isEmpty()) {
            throw new InitializationException("The 'constraint-check' tests candidates before their evaluation, but the "
                                              + "group '" + configuredGroup + "' contains constraints on objectives: "
                                              + onObjectives + ".");
        }

        final boolean repairs = reaction() == CheckReaction.REPAIR;
        if(repairs && constraintRepair == null) {
            throw new InitializationException("The 'constraint-check' of the group '" + configuredGroup + "' has the "
                                              + "reaction 'repair', but no 'repair'.");
        }
        if(!repairs && constraintRepair != null) {
            throw new InitializationException("The 'constraint-check' of the group '" + configuredGroup + "' has a "
                                              + "'repair', but the reaction '" + reaction() + "'.");
        }
        if(fallback == CheckReaction.REPAIR) {
            throw new InitializationException("The 'repair-fallback' of the 'constraint-check' of the group '"
                                              + configuredGroup + "' cannot be 'repair'.");
        }

        if(constraintRepair != null) {
            final String unrepairable = inGroup.stream()
                                               .flatMap(constraint -> constraintRepair.cannotRepair(constraint)
                                                                                      .map(reason -> constraint + ": " + reason)
                                                                                      .stream())
                                               .collect(Collectors.joining("; "));
            if(!unrepairable.isEmpty()) {
                throw new InitializationException("The '" + constraintRepair.name() + "' cannot repair constraints of "
                                                  + "the group '" + configuredGroup + "': " + unrepairable + ".");
            }

            repair = new Repair(constraintRepair.name(), input -> constraintRepair.repair(input, inGroup), fallback);
        }

        group = configuredGroup;
        groupConstraints = inGroup;
    }

    @Override
    public Set<CheckReaction> supportedReactions() {
        return EnumSet.allOf(CheckReaction.class);
    }

    /**
     * Measures the constraints of the group and keeps the degrees on the candidate.
     */
    @Override
    public Optional<String> test(final Candidate candidate) {
        final PartialViolationRecord degrees = evaluation.measure(candidate.input(), groupConstraints);
        if(!candidate.isEvaluated()) {
            candidate.addMeasuredViolations(degrees);
        }

        final double violation = degrees.violation(groupConstraints);
        if(violation == 0.0) {
            return Optional.empty();
        }

        final String violated = groupConstraints.stream()
                                                .filter(constraint -> degrees.degree(constraint).orElseThrow() > 0.0)
                                                .map(constraint -> Integer.toString(constraint.number()))
                                                .collect(Collectors.joining(", "));

        return Optional.of("violation " + violation + " of the group '" + group + "' (constraints " + violated + ")");
    }
}
