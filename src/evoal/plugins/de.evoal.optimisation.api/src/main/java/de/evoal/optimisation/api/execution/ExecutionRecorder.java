package de.evoal.optimisation.api.execution;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;

import lombok.Getter;

import de.evoal.core.api.reproducibility.ReproducibilityProtocol;

import de.evoal.models.v202704.optimisation.memory.Execution;
import de.evoal.models.v202704.optimisation.memory.FitnessComponentDefinition;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.MetricScope;
import de.evoal.models.v202704.optimisation.memory.PropertyDefinition;
import de.evoal.models.v202704.optimisation.memory.PropertyScope;
import de.evoal.models.v202704.optimisation.memory.PropertyValueType;
import de.evoal.models.v202704.optimisation.memory.ReproducibilityNote;

import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.fitness.Goal;

/**
 * Records the description of the current run: the metrics it records
 *   ({@link Execution#getMetricDefinitions()}), the values of its execution metrics
 *   ({@link Execution#getMetrics()}), the properties of its individuals and relationships
 *   ({@link Execution#getPropertyDefinitions()}) and the components of the fitness of its
 *   individuals ({@link Execution#getFitnessComponents()}).
 * <p>
 * A run passes through three phases, and the recorder rejects calls in the wrong phase:
 * <ol>
 *   <li>{@link #startRun()} opens the <em>definition phase</em>. The applications call it
 *     before they create the algorithm. The {@link MetricContributor}s and the components
 *     of the algorithm (e.g., stopping criteria) define all metrics
 *     ({@link #define(MetricDefinition)}) and properties
 *     ({@link #defineProperty(PropertyDefinition)}). The applications define the components
 *     of the fitness ({@link #defineFitness(FitnessLayout)}).</li>
 *   <li>{@link #beginExecution()} closes the definitions and records the notes of the
 *     {@link ReproducibilityProtocol}. The applications call it after
 *     they created the algorithm and before they run it. From now on, the definitions are
 *     complete and can be written, e.g., to the description of the run. The algorithm
 *     passes every iteration to {@link #recordMetrics(Iteration)}.</li>
 *   <li>{@link #finishRun()} ends the run. The execution metrics are final.</li>
 * </ol>
 * Execution metrics ({@link #recordExecutionMetric(String, Number)}) can be recorded until
 *   the run is finished.
 */
@ApplicationScoped
public class ExecutionRecorder {
    /**
     * All components that record metrics.
     */
    @Inject @Any
    private Instance<MetricContributor> contributors;

    /**
     * The parts of the process whose results may not be reproducible on other platforms.
     */
    @Inject
    private ReproducibilityProtocol reproducibility;

    /**
     * The position of the current run in the evaluation setup, {@code null} for a single run.
     */
    private EvaluationPosition evaluationPosition;

    /**
     * The execution of the current run.
     */
    @Getter
    private Execution execution = MemoryFactory.eINSTANCE.createExecution();

    /**
     * The property definitions of the current run by scope and name, so that
     *   {@link #requireProperty} finds a definition without searching the list of the
     *   execution; every property of every recorded individual is checked.
     */
    private final Map<PropertyScope, Map<String, PropertyDefinition>> propertyDefinitions = new EnumMap<>(PropertyScope.class);

    /**
     * The phase of the current run.
     */
    private Phase phase = Phase.NO_RUN;

    /**
     * Closes the definitions of the current run and starts its execution.
     *
     * @throws IllegalStateException if the run is not in the definition phase.
     */
    public void beginExecution() {
        requirePhase(Phase.DEFINITION, "begin the execution");

        recordReproducibilityNotes();
        phase = Phase.EXECUTION;
    }

    /**
     * Copies the notes of the {@link ReproducibilityProtocol} into the execution. The
     *   components report them while they are set up, i.e. before the execution begins.
     */
    private void recordReproducibilityNotes() {
        execution.getReproducibilityNotes().clear();
        reproducibility.notes()
                       .stream()
                       .map(ExecutionRecorder::toNote)
                       .forEach(execution.getReproducibilityNotes()::add);
    }

    private static ReproducibilityNote toNote(final de.evoal.core.api.reproducibility.ReproducibilityNote note) {
        final ReproducibilityNote recorded = MemoryFactory.eINSTANCE.createReproducibilityNote();
        recorded.setComponent(note.component());
        recorded.setReason(note.reason());

        return recorded;
    }

    /**
     * Defines a metric of the current run.
     *
     * @param definition The definition of the metric.
     * @throws IllegalStateException if the run is not in the definition phase.
     * @throws IllegalArgumentException if a metric with the same name is already defined.
     */
    public void define(final MetricDefinition definition) {
        final String name = definition.getName();
        requirePhase(Phase.DEFINITION, "define the metric '" + name + "'");

        final boolean alreadyDefined = findDefinition(name).isPresent();
        if(alreadyDefined) {
            throw new IllegalArgumentException("The metric '" + name + "' is already defined.");
        }

        execution.getMetricDefinitions().add(definition);
    }

    /**
     * Defines a property of the individuals or relationships of the current run.
     *
     * @param definition The definition of the property.
     * @throws IllegalStateException if the run is not in the definition phase.
     * @throws IllegalArgumentException if a property with the same name and scope is already
     *   defined.
     */
    public void defineProperty(final PropertyDefinition definition) {
        final String name = definition.getName();
        requirePhase(Phase.DEFINITION, "define the property '" + name + "'");

        final boolean alreadyDefined = findPropertyDefinition(name, definition.getScope()).isPresent();
        if(alreadyDefined) {
            throw new IllegalArgumentException("The property '" + name + "' is already defined with the scope "
                                               + definition.getScope() + ".");
        }

        execution.getPropertyDefinitions().add(definition);
        propertyDefinitions.computeIfAbsent(definition.getScope(), scope -> new HashMap<>())
                           .put(name, definition);
    }

    /**
     * Defines a property of the current run, see {@link #defineProperty(PropertyDefinition)}.
     *
     * @param name The name of the property.
     * @param scope Where the property is recorded.
     * @param valueType The type of the values, or of their elements for a list.
     * @param list Whether a value is a list.
     * @param description What the property describes.
     */
    public void defineProperty(final String name,
                               final PropertyScope scope,
                               final PropertyValueType valueType,
                               final boolean list,
                               final String description) {
        final PropertyDefinition definition = MemoryFactory.eINSTANCE.createPropertyDefinition();
        definition.setName(name);
        definition.setScope(scope);
        definition.setValueType(valueType);
        definition.setList(list);
        definition.setDescription(description);

        defineProperty(definition);
    }

    /**
     * @param name The name of the property.
     * @param scope Where the property is recorded.
     * @return The definition of the property in the current run, if there is one.
     */
    public Optional<PropertyDefinition> findPropertyDefinition(final String name, final PropertyScope scope) {
        return Optional.ofNullable(propertyDefinitions.getOrDefault(scope, Map.of()).get(name));
    }

    /**
     * Checks a property value before it is recorded.
     *
     * @param name The name of the property.
     * @param scope Where the property is recorded.
     * @param value The value of the property.
     * @throws IllegalStateException if the property is not defined with the scope, or if the
     *   value does not match its definition.
     */
    public void requireProperty(final String name, final PropertyScope scope, final Object value) {
        final PropertyDefinition definition = findPropertyDefinition(name, scope).orElseThrow(
                () -> new IllegalStateException("The property '" + name + "' is not defined with the scope " + scope + "."));

        final boolean matches = definition.isList()
                ? value instanceof List<?> values && values.stream().allMatch(element -> hasType(element, definition.getValueType()))
                : hasType(value, definition.getValueType());

        if(!matches) {
            throw new IllegalStateException("The value " + value + " of the property '" + name + "' is not "
                                            + (definition.isList() ? "a list of " : "a ") + definition.getValueType() + ".");
        }
    }

    /**
     * @return Whether the value is stored as the value type requires.
     */
    private static boolean hasType(final Object value, final PropertyValueType valueType) {
        return switch(valueType) {
            case INTEGER -> value instanceof Long;
            case REAL -> value instanceof Double;
            case TEXT -> value instanceof String;
            case BOOLEAN -> value instanceof Boolean;
        };
    }

    /**
     * Defines the components of the fitness of the current run, in the order of the fitness
     *   values of its individuals. Replaces earlier definitions of the run.
     *
     * @param layout The components of the fitness the algorithm computes.
     * @throws IllegalStateException if the run is not in the definition phase.
     */
    public void defineFitness(final FitnessLayout layout) {
        requirePhase(Phase.DEFINITION, "define the fitness components");

        execution.getFitnessComponents().clear();
        layout.components()
              .stream()
              .map(ExecutionRecorder::toDefinition)
              .forEach(execution.getFitnessComponents()::add);
    }

    /**
     * @param name The name of the metric.
     * @return The definition of the metric in the current run, if there is one.
     */
    public Optional<MetricDefinition> findDefinition(final String name) {
        return execution.getMetricDefinitions()
                        .stream()
                        .filter(definition -> definition.getName().equals(name))
                        .findFirst();
    }

    /**
     * Ends the current run. The execution metrics are final.
     *
     * @throws IllegalStateException if the run is not in the execution phase.
     */
    public void finishRun() {
        requirePhase(Phase.EXECUTION, "finish the run");

        phase = Phase.FINISHED;
    }

    /**
     * @return The position of the current run in the evaluation setup, empty for a single run.
     */
    public Optional<EvaluationPosition> getEvaluationPosition() {
        return Optional.ofNullable(evaluationPosition);
    }

    /**
     * @return The contributors, ordered by the name of their class. CDI does not define the
     *   order of the beans, so the order of the metric definitions and values in the memory
     *   model would otherwise change from run to run.
     */
    private List<MetricContributor> orderedContributors() {
        return contributors.stream()
                           .sorted(Comparator.comparing(contributor -> contributor.getClass().getName()))
                           .toList();
    }

    /**
     * Records the value of an execution metric, e.g., a limit.
     *
     * @param name The name of the metric.
     * @param value The value of the metric.
     * @throws IllegalStateException if the run is not started or already finished, or if the
     *   metric is not defined with the scope {@link MetricScope#EXECUTION}.
     */
    public void recordExecutionMetric(final String name, final Number value) {
        final boolean isRunning = phase == Phase.DEFINITION || phase == Phase.EXECUTION;
        if(!isRunning) {
            throw new IllegalStateException("Cannot record the metric '" + name + "' in phase " + phase + ".");
        }

        requireDefinition(name, MetricScope.EXECUTION);

        execution.getMetrics().put(name, value);
    }

    /**
     * Writes the current values of all iteration metrics into the iteration.
     *
     * @param iteration The iteration to write the values into.
     * @throws IllegalStateException if the run is not in the execution phase, or if a
     *   contributor wrote a metric that is not defined with the scope
     *   {@link MetricScope#ITERATION}.
     */
    public void recordMetrics(final Iteration iteration) {
        requirePhase(Phase.EXECUTION, "record the metrics of iteration " + iteration.getNumber());

        orderedContributors().forEach(contributor -> contributor.contributeTo(iteration));

        iteration.getMetrics()
                 .keySet()
                 .forEach(name -> requireDefinition(name, MetricScope.ITERATION));
    }

    /**
     * @throws IllegalStateException if the metric is not defined with the given scope.
     */
    private void requireDefinition(final String name, final MetricScope scope) {
        final boolean isDefined = findDefinition(name).filter(definition -> definition.getScope() == scope)
                                                      .isPresent();

        if(!isDefined) {
            throw new IllegalStateException("The metric '" + name + "' is not defined with the scope " + scope + ".");
        }
    }

    /**
     * @param action What the caller tries to do, for the error message.
     * @throws IllegalStateException if the current run is not in the expected phase.
     */
    private void requirePhase(final Phase expected, final String action) {
        if(phase != expected) {
            throw new IllegalStateException("Cannot " + action + " in phase " + phase + ", only in phase "
                                            + expected + ".");
        }
    }

    /**
     * Starts a single run (not part of the evaluation setup), see {@link #startRun(EvaluationPosition)}.
     */
    public void startRun() {
        startRun(null);
    }

    /**
     * Starts a new run with a new execution and opens its definition phase. All
     *   contributors reset their state and define their metrics.
     *
     * @param evaluationPosition The position of the run in the evaluation setup, {@code null}
     *   for a single run.
     */
    public void startRun(final EvaluationPosition evaluationPosition) {
        this.evaluationPosition = evaluationPosition;
        execution = MemoryFactory.eINSTANCE.createExecution();
        propertyDefinitions.clear();
        phase = Phase.DEFINITION;

        orderedContributors().forEach(contributor -> contributor.startRun(this));
    }

    /**
     * @return The definition of the fitness component for the memory model.
     */
    private static FitnessComponentDefinition toDefinition(final FitnessComponent component) {
        final FitnessComponentDefinition definition = MemoryFactory.eINSTANCE.createFitnessComponentDefinition();
        definition.setName(component.name());
        component.goal()
                 .map(Goal::objective)
                 .ifPresent(definition::setObjective);

        return definition;
    }

    /**
     * The phases of a run.
     */
    private enum Phase {
        /**
         * No run has been started yet.
         */
        NO_RUN,

        /**
         * The metrics are being defined.
         */
        DEFINITION,

        /**
         * The algorithm runs and records its iterations.
         */
        EXECUTION,

        /**
         * The run is finished.
         */
        FINISHED
    }
}
