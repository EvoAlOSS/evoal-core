package de.evoal.optimisation.api.constraints;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.emf.ecore.EObject;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricKind;
import de.evoal.models.v202704.optimisation.memory.MetricScope;
import de.evoal.models.v202704.optimisation.memory.MetricValueType;
import de.evoal.models.v202704.optimisation.memory.PropertyScope;
import de.evoal.models.v202704.optimisation.memory.PropertyValueType;
import de.evoal.models.v202704.optimisation.model.Problem;

import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import de.evoal.optimisation.api.execution.ExecutionRecorder;
import de.evoal.optimisation.api.execution.MetricContributor;
import de.evoal.optimisation.main.constraints.ConstraintCompiler;

/**
 * The constraint evaluation of the kernel: measures the constraints of the problem for a
 *   candidate with the {@code 'constraint-measure'} of the algorithm and returns its
 *   {@link ViolationRecord}. It never calls the optimisation function: constraints on
 *   objectives read the result of the evaluation, so constraint evaluations do not use the
 *   evaluation budget. Every measurement of a constraint counts in the metric
 *   {@value #METRIC}: a constraint that a {@code 'constraint-check'} measured before the
 *   evaluation is not measured again, but a repaired candidate is measured after every
 *   attempt.
 * <p>
 * At the start of every run, the constraints and the measure are read from the
 *   optimisation configuration. If the problem has constraints, the metric and the
 *   properties {@code violation-<n>} of the individuals are defined; without constraints,
 *   nothing is defined and every record is {@link ViolationRecord#NONE}.
 */
@ApplicationScoped
@Slf4j
public class ConstraintEvaluation implements MetricContributor {
    /**
     * The name of the metric with the number of measured constraints.
     */
    public static final String METRIC = "constraint-evaluations";

    @Inject
    private Blackboard board;

    @Inject
    private ConstraintCompiler compiler;

    /**
     * The constraints of the current run.
     */
    private Constraints constraints = Constraints.NONE;

    /**
     * The number of measured constraints in the current run.
     */
    private final AtomicLong evaluations = new AtomicLong();

    @Inject
    private AttributeHelper helper;

    /**
     * The measure of the current run; {@code null} if the problem has no constraints.
     */
    private ConstraintMeasure measure;

    /**
     * @return The constraints of the current run.
     */
    public Constraints constraints() {
        return constraints;
    }

    @Override
    public void contributeTo(final Iteration iteration) {
        if(constraints.isEmpty()) {
            return;
        }

        iteration.getMetrics().put(METRIC, evaluations.get());
    }

    /**
     * Defines the metric and the properties of the constraints.
     */
    private void define(final ExecutionRecorder recorder) {
        final MetricDefinition metric = MemoryFactory.eINSTANCE.createMetricDefinition();
        metric.setName(METRIC);
        metric.setKind(MetricKind.COUNTER);
        metric.setValueType(MetricValueType.INTEGER);
        metric.setScope(MetricScope.ITERATION);
        metric.setDescription("Number of constraint measurements, including the repeated measurements of candidate "
                              + "checks that repair candidates; they do not use the evaluation budget.");
        recorder.define(metric);

        for(final Constraint constraint : constraints.all()) {
            final String name = ViolationRecord.propertyName(constraint);
            final String description = "Degree of violation of the constraint " + constraint.number()
                                       + " of the group '" + constraint.group() + "': " + constraint.text()
                                       + " (0 if satisfied).";

            recorder.defineProperty(name, PropertyScope.INDIVIDUAL, PropertyValueType.REAL, false, description);
        }
    }

    /**
     * Measures all constraints of a candidate.
     *
     * @param input The candidate (a point of the search space).
     * @param objectives The result of the optimisation function for the candidate.
     * @return The violation record.
     */
    public ViolationRecord measure(final TypedEObject input, final TypedEObject objectives) {
        return measure(input, objectives, PartialViolationRecord.EMPTY);
    }

    /**
     * Measures the constraints of a candidate that are not measured yet.
     *
     * @param input The candidate (a point of the search space).
     * @param objectives The result of the optimisation function for the candidate.
     * @param known The degrees measured before the evaluation, e.g., by a
     *   {@code 'constraint-check'}; they are taken over and not counted again.
     * @return The violation record.
     */
    public ViolationRecord measure(final TypedEObject input, final TypedEObject objectives,
                                   final PartialViolationRecord known) {
        if(constraints.isEmpty()) {
            return ViolationRecord.NONE;
        }

        final double[] degrees = new double[constraints.size()];
        int measured = 0;
        for(final Constraint constraint : constraints.all()) {
            final Optional<Double> knownDegree = known.degree(constraint);
            if(knownDegree.isPresent()) {
                degrees[constraint.number() - 1] = knownDegree.get();
                continue;
            }

            degrees[constraint.number() - 1] = measure.degreeOf(constraint, input, objectives);
            measured += 1;
        }

        evaluations.addAndGet(measured);

        return new ViolationRecord(constraints, degrees);
    }

    /**
     * Measures some constraints of a candidate before its evaluation, e.g., for a
     *   {@code 'constraint-check'}. Every call counts in the metric {@value #METRIC}, also
     *   repeated measurements of a repaired candidate.
     *
     * @param input The candidate (a point of the search space).
     * @param measured Constraints of the problem that read no objectives.
     * @return The degrees of the constraints.
     * @throws IllegalArgumentException if a constraint reads objectives.
     */
    public PartialViolationRecord measure(final TypedEObject input, final List<Constraint> measured) {
        final Map<Integer, Double> degrees = new LinkedHashMap<>();

        for(final Constraint constraint : measured) {
            degrees.put(constraint.number(), measure.degreeOf(constraint, input, null));
        }

        evaluations.addAndGet(degrees.size());

        return PartialViolationRecord.of(degrees);
    }

    /**
     * @return The number of measured constraints in the current run.
     */
    public long numberOfEvaluations() {
        return evaluations.get();
    }

    /**
     * Uses the given constraints and measure, e.g., for tests.
     *
     * @param constraints The constraints.
     * @param measure The measure.
     */
    public void setUp(final Constraints constraints, final ConstraintMeasure measure) {
        this.constraints = constraints;
        this.measure = measure;
        evaluations.set(0);
    }

    @Override
    public void startRun(final ExecutionRecorder recorder) {
        final EObject configuration = board.getOrNull(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION);
        evaluations.set(0);

        if(configuration == null) {
            setUp(Constraints.NONE, null);

            return;
        }

        final Problem problem = helper.lookup(configuration, "problem");
        final Constraints problemConstraints = compiler.compile(problem);
        if(problemConstraints.isEmpty()) {
            setUp(Constraints.NONE, null);

            return;
        }

        final EObject algorithm = helper.lookup(configuration, "algorithm");
        final EObject measureConfiguration = helper.lookup(algorithm, "constraint-measure");
        final ConstraintMeasure problemMeasure = BeanFactory.createComponent(ConstraintMeasure.class,
                                                                             measureConfiguration);
        setUp(problemConstraints, problemMeasure);

        define(recorder);
        log.info("Measuring {} constraints with {}.", constraints.size(), measure);
    }
}
