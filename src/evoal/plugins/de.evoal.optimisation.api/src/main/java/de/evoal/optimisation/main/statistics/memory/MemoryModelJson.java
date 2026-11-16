package de.evoal.optimisation.main.statistics.memory;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import lombok.NonNull;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.node.ArrayNode;
import tools.jackson.databind.node.JsonNodeFactory;
import tools.jackson.databind.node.ObjectNode;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.ecore.info.FeatureBoundaries;
import de.evoal.core.api.ecore.misc.EClassifierHelper;
import de.evoal.core.api.utils.TypedEObjects;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.memory.Execution;
import de.evoal.models.v202704.optimisation.memory.Identity;
import de.evoal.models.v202704.optimisation.memory.Individual;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.IterationStep;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.Mutation;
import de.evoal.models.v202704.optimisation.memory.OrderedIterationStep;
import de.evoal.models.v202704.optimisation.memory.Rank;
import de.evoal.models.v202704.optimisation.memory.Recombination;
import de.evoal.models.v202704.optimisation.memory.Relationship;
import de.evoal.models.v202704.optimisation.memory.UnorderedIterationStep;
import de.evoal.models.v202704.optimisation.model.MaximiseGoal;
import de.evoal.models.v202704.optimisation.model.MinimiseGoal;
import de.evoal.models.v202704.optimisation.model.OptimisationGoal;
import de.evoal.models.v202704.optimisation.model.Problem;
import de.evoal.models.v202704.optimisation.model.TargetGoal;

import de.evoal.optimisation.api.execution.EvaluationPosition;

/**
 * Converts the memory model of a run into the JSON documents of the memory model format
 *   (schemas in {@code de/evoal/optimisation/schemas/memory-model}, version
 *   {@value #FORMAT_VERSION}). The properties are created in a fixed order, so the same
 *   run always gives the same documents.
 * <p>
 * Numbers that JSON cannot represent ({@code NaN}, infinity) are written as the strings
 *   {@code "NaN"}, {@code "Infinity"} and {@code "-Infinity"}.
 */
public class MemoryModelJson {
    /**
     * The version of the format, the EvoAl release that defined it.
     */
    public static final String FORMAT_VERSION = "2027.4.0";

    /**
     * Creates the JSON nodes.
     */
    private static final JsonNodeFactory NODES = JsonNodeFactory.instance;

    /**
     * Finds the data descriptions of the features, which declare their scale.
     */
    private final EAnnotationHelper annotationHelper;

    /**
     * @param annotationHelper Finds the data descriptions of the features.
     */
    public MemoryModelJson(final @NonNull EAnnotationHelper annotationHelper) {
        this.annotationHelper = annotationHelper;
    }

    /**
     * Adds the declared bounds of the feature, if there are any.
     */
    private static void addBounds(final ObjectNode featureNode, final EStructuralFeature feature) {
        final EAnnotation boundary = feature.getEAnnotation(FeatureBoundaries.BOUNDARIES_SOURCE);
        if(boundary == null) {
            return;
        }

        toBound(feature, boundary, FeatureBoundaries.LOWER, FeatureBoundaries.LOWER_INCLUSIVE)
                .ifPresent(bound -> featureNode.set("lowerBound", bound));
        toBound(feature, boundary, FeatureBoundaries.UPPER, FeatureBoundaries.UPPER_INCLUSIVE)
                .ifPresent(bound -> featureNode.set("upperBound", bound));
    }

    /**
     * Adds the repetition and, if target points are used, the target index.
     */
    private static void addEvaluationPosition(final ObjectNode setup, final EvaluationPosition position) {
        setup.put("repetition", position.repetition());

        if(position.hasTarget()) {
            setup.put("target", position.target());
        }
    }

    /**
     * Adds the individual to the individuals of the iteration, unless an individual with the
     *   same id is already collected.
     *
     * @throws IllegalStateException if the already collected individual has other values.
     */
    private static void collect(final Map<Integer, Individual> individuals, final Individual individual) {
        final Individual collected = individuals.putIfAbsent(individual.getId(), individual);
        if(collected == null || collected == individual) {
            return;
        }

        final boolean sameInput = haveSameValues(collected.getInput(), individual.getInput());
        final boolean sameOutput = haveSameValues(collected.getOutput(), individual.getOutput());
        if(!sameInput || !sameOutput) {
            throw new IllegalStateException("The iteration contains two different individuals with the id "
                                            + individual.getId() + ".");
        }
    }

    /**
     * @return The individuals of the iteration (from its steps and its ranks), each once, in the
     *   order of their first occurrence.
     */
    private static Collection<Individual> collectIndividuals(final Iteration iteration) {
        final Map<Integer, Individual> individuals = new LinkedHashMap<>();

        final Stream<Individual> fromSteps = iteration.getSteps()
                                                      .stream()
                                                      .flatMap(MemoryModelJson::individualsOf);
        final Stream<Individual> fromRanks = iteration.getRanks()
                                                      .stream()
                                                      .flatMap(rank -> rank.getMembers().stream());

        Stream.concat(fromSteps, fromRanks)
              .forEach(individual -> collect(individuals, individual));

        return individuals.values();
    }

    /**
     * @return Whether both values are missing or have the same values.
     */
    private static boolean haveSameValues(final TypedEObject first, final TypedEObject second) {
        final boolean bothMissing = first == null && second == null;
        if(bothMissing) {
            return true;
        }

        final boolean oneMissing = first == null || second == null;
        if(oneMissing) {
            return false;
        }

        return TypedEObjects.haveSameValues(first, second);
    }

    /**
     * @return The individuals the step refers to.
     */
    private static Stream<Individual> individualsOf(final IterationStep step) {
        return switch(step) {
            case OrderedIterationStep ordered -> ordered.getRanks()
                                                        .stream()
                                                        .flatMap(rank -> rank.getMembers().stream());
            case UnorderedIterationStep unordered -> unordered.getIndividuals().stream();
            default -> throw new IllegalStateException("Unsupported iteration step " + step.eClass().getName() + ".");
        };
    }

    /**
     * @return The name of the enum literal in lower case, e.g. {@code counter} for
     *   {@code Counter}.
     */
    private static String lowerCaseNameOf(final Enumerator literal) {
        return literal.getName().toLowerCase(Locale.ROOT);
    }

    /**
     * @return A new document that starts with the format version.
     */
    private static ObjectNode newDocument() {
        final ObjectNode document = NODES.objectNode();
        document.put("formatVersion", FORMAT_VERSION);

        return document;
    }

    /**
     * @return The literal of a non-finite number: {@code NaN}, {@code Infinity} or {@code -Infinity}.
     */
    private static String nonFiniteLiteral(final double value) {
        return Double.toString(value);
    }

    /**
     * @return The id of the individual that holds the other relationship of the recombination.
     *
     * @throws IllegalStateException if the recombination has no partner.
     */
    private static int partnerOf(final Recombination recombination) {
        final Recombination other = recombination.getOther();
        final EObject partner = other == null ? null : other.eContainer();

        if(partner instanceof Individual individual) {
            return individual.getId();
        }

        throw new IllegalStateException("A recombination has no partner individual.");
    }

    /**
     * @return The scale of the feature's data description, if it declares one.
     */
    private Optional<String> scaleOf(final EStructuralFeature feature) {
        final Optional<DataDescription> description = annotationHelper.dataDescriptionOf(feature);

        return description.filter(BaseDataDescription.class::isInstance)
                          .map(BaseDataDescription.class::cast)
                          .map(BaseDataDescription::getScale)
                          .filter(scale -> scale != ScaleType.UNKNOWN)
                          .map(ScaleType::getLiteral);
    }

    /**
     * @return The elements as a JSON array.
     */
    private static ArrayNode toArray(final Collection<?> elements) {
        final ArrayNode array = NODES.arrayNode();
        elements.stream()
                .map(MemoryModelJson::toValue)
                .forEach(array::add);

        return array;
    }

    /**
     * @return The bound, or empty if the feature declares no bound on this side.
     *
     * @param boundary The annotation with the declared bounds of the feature.
     * @param valueKey The key of the bound's value.
     * @param inclusiveKey The key that tells whether the bound is included.
     */
    private static Optional<ObjectNode> toBound(final EStructuralFeature feature,
                                                final EAnnotation boundary,
                                                final String valueKey,
                                                final String inclusiveKey) {
        final String literal = boundary.getDetails().get(valueKey);
        if(literal == null) {
            return Optional.empty();
        }

        final EDataType type = (EDataType) feature.getEType();
        final Object value = EcoreUtil.createFromString(type, literal);
        final String inclusiveLiteral = boundary.getDetails().get(inclusiveKey);
        final boolean inclusive = Boolean.parseBoolean(inclusiveLiteral);

        final ObjectNode bound = NODES.objectNode();
        bound.set("value", toNumber((Number) value));
        bound.put("inclusive", inclusive);

        return Optional.of(bound);
    }

    /**
     * @return The document {@code execution-finished.json}.
     *
     * @param numberOfIterations The number of written iteration files.
     * @param best The ids of the best individuals of the last iteration.
     * @param execution The execution with the final execution metrics.
     */
    public ObjectNode toExecutionFinished(final int numberOfIterations,
                                          final List<Integer> best,
                                          final Execution execution) {
        final ObjectNode document = newDocument();
        document.put("numberOfIterations", numberOfIterations);

        final ArrayNode bestIds = document.putArray("best");
        best.forEach(bestIds::add);

        final ObjectNode metrics = toMetrics(execution.getMetrics());
        document.set("metrics", metrics);

        return document;
    }

    /**
     * @return The document {@code execution-information.json}.
     *
     * @param problem The optimisation problem.
     * @param algorithmType The fully qualified DL type of the algorithm.
     * @param execution The execution with the complete metric definitions.
     * @param setup What is needed to repeat the run.
     */
    public ObjectNode toExecutionInformation(final Problem problem,
                                             final String algorithmType,
                                             final Execution execution,
                                             final RunSetup setup) {
        final ObjectNode document = newDocument();

        final ObjectNode problemNode = toProblem(problem);
        document.set("problem", problemNode);

        final ObjectNode algorithm = document.putObject("algorithm");
        algorithm.put("type", algorithmType);

        final ArrayNode searchSpace = toFeatures(problem.getSearchSpace());
        document.set("searchSpace", searchSpace);

        final ArrayNode optimisationSpace = toFeatures(problem.getOptimisationSpace());
        document.set("optimisationSpace", optimisationSpace);

        final ArrayNode metricDefinitions = document.putArray("metricDefinitions");
        execution.getMetricDefinitions()
                 .stream()
                 .map(MemoryModelJson::toMetricDefinition)
                 .forEach(metricDefinitions::add);

        final ObjectNode setupNode = toSetup(setup);
        document.set("setup", setupNode);

        return document;
    }

    /**
     * @return The feature with its name, type, scale (if declared) and bounds (if declared).
     */
    private ObjectNode toFeature(final EStructuralFeature feature) {
        final ObjectNode featureNode = NODES.objectNode();
        featureNode.put("name", feature.getName());

        final String type = toFeatureType(feature);
        featureNode.put("type", type);

        scaleOf(feature).ifPresent(scale -> featureNode.put("scale", scale));
        addBounds(featureNode, feature);

        return featureNode;
    }

    /**
     * @return The features of the space in declaration order.
     */
    private ArrayNode toFeatures(final EClass space) {
        final ArrayNode features = NODES.arrayNode();
        space.getEAllStructuralFeatures()
             .stream()
             .map(this::toFeature)
             .forEach(features::add);

        return features;
    }

    /**
     * @return The type of the feature in the format: boolean, integer, real or string.
     */
    private static String toFeatureType(final EStructuralFeature feature) {
        final EClassifier type = feature.getEType();

        if(EClassifierHelper.isBoolean(type)) {
            return "boolean";
        } else if(EClassifierHelper.isLongOrShorter(type)) {
            return "integer";
        } else if(EClassifierHelper.isReal(type)) {
            return "real";
        } else if(EClassifierHelper.isString(type)) {
            return "string";
        }

        throw new IllegalStateException("The data '" + feature.getName() + "' has the unsupported type "
                                        + type.getName() + ".");
    }

    /**
     * @return The goal: its feature, direction and, for a target goal, the target value.
     */
    private static ObjectNode toGoal(final OptimisationGoal goal) {
        final ObjectNode goalNode = NODES.objectNode();
        goalNode.put("feature", goal.getData().getName());

        switch(goal) {
            case MaximiseGoal maximise -> goalNode.put("direction", "maximise");
            case MinimiseGoal minimise -> goalNode.put("direction", "minimise");
            case TargetGoal target -> {
                goalNode.put("direction", "target");
                goalNode.set("target", toValue(target.getValue()));
            }
            default -> throw new IllegalStateException("Unsupported goal " + goal.eClass().getName() + ".");
        }

        return goalNode;
    }

    /**
     * @return The ids of the individuals.
     */
    private static ArrayNode toIds(final List<Individual> individuals) {
        final ArrayNode ids = NODES.arrayNode();
        individuals.stream()
                   .map(Individual::getId)
                   .forEach(ids::add);

        return ids;
    }

    /**
     * @return The individual with its id, values and relationships.
     */
    private ObjectNode toIndividual(final Individual individual) {
        final ObjectNode individualNode = NODES.objectNode();
        individualNode.put("id", individual.getId());

        final ObjectNode input = toValues(individual.getInput());
        individualNode.set("input", input);

        final ObjectNode output = toValues(individual.getOutput());
        individualNode.set("output", output);

        final ArrayNode relationships = individualNode.putArray("relationships");
        individual.getRelationships()
                  .stream()
                  .map(MemoryModelJson::toRelationship)
                  .forEach(relationships::add);

        return individualNode;
    }

    /**
     * @return The document {@code iteration-<number>.json}.
     */
    public ObjectNode toIteration(final Iteration iteration) {
        final ObjectNode document = newDocument();
        document.put("number", iteration.getNumber());

        final ArrayNode individuals = document.putArray("individuals");
        collectIndividuals(iteration).stream()
                                     .map(this::toIndividual)
                                     .forEach(individuals::add);

        final ArrayNode steps = document.putArray("steps");
        iteration.getSteps()
                 .stream()
                 .map(MemoryModelJson::toStep)
                 .forEach(steps::add);

        final ArrayNode ranks = toRanks(iteration.getRanks());
        document.set("ranks", ranks);

        // the best individual can belong to an earlier iteration, so it is written as id only
        final Individual bestSoFar = iteration.getBestSoFar();
        if(bestSoFar != null) {
            document.put("bestSoFar", bestSoFar.getId());
        }

        final ObjectNode metrics = toMetrics(iteration.getMetrics());
        document.set("metrics", metrics);

        return document;
    }

    /**
     * @return The definition of a metric.
     */
    private static ObjectNode toMetricDefinition(final MetricDefinition definition) {
        final ObjectNode definitionNode = NODES.objectNode();
        definitionNode.put("name", definition.getName());
        final String kind = lowerCaseNameOf(definition.getKind());
        definitionNode.put("kind", kind);

        final String valueType = lowerCaseNameOf(definition.getValueType());
        definitionNode.put("valueType", valueType);

        final String scope = lowerCaseNameOf(definition.getScope());
        definitionNode.put("scope", scope);

        final String description = Objects.requireNonNullElse(definition.getDescription(), "");
        definitionNode.put("description", description);

        return definitionNode;
    }

    /**
     * @return The values of the metrics, keyed by metric name, in the order they were recorded.
     */
    private static ObjectNode toMetrics(final EMap<String, Number> metrics) {
        final ObjectNode metricsNode = NODES.objectNode();
        metrics.forEach(entry -> metricsNode.set(entry.getKey(), toNumber(entry.getValue())));

        return metricsNode;
    }

    /**
     * @return The number as a JSON number, or as a string if it is not finite.
     */
    private static JsonNode toNumber(final Number number) {
        return switch(number) {
            case Double value when !Double.isFinite(value) -> NODES.stringNode(nonFiniteLiteral(value));
            case Float value when !Float.isFinite(value) -> NODES.stringNode(nonFiniteLiteral(value));
            case Double value -> NODES.numberNode(value);
            case Float value -> NODES.numberNode(value);
            case Long value -> NODES.numberNode(value);
            case Integer value -> NODES.numberNode(value);
            case Short value -> NODES.numberNode(value);
            case Byte value -> NODES.numberNode(value);
            default -> throw new IllegalStateException("Unsupported number type " + number.getClass().getName() + ".");
        };
    }

    /**
     * @return The problem with its name and goals.
     */
    private static ObjectNode toProblem(final Problem problem) {
        final ObjectNode problemNode = NODES.objectNode();
        problemNode.put("name", problem.getName());

        final ArrayNode goals = problemNode.putArray("goals");
        problem.getGoals()
               .stream()
               .map(MemoryModelJson::toGoal)
               .forEach(goals::add);

        return problemNode;
    }

    /**
     * @return The rank with its number and the ids of its members.
     */
    private static ObjectNode toRank(final Rank rank) {
        final ObjectNode rankNode = NODES.objectNode();
        rankNode.put("number", rank.getNumber());
        rankNode.set("members", toIds(rank.getMembers()));

        return rankNode;
    }

    /**
     * @return The ranks with their numbers and the ids of their members.
     */
    private static ArrayNode toRanks(final List<Rank> ranks) {
        final ArrayNode ranksNode = NODES.arrayNode();
        ranks.stream()
             .map(MemoryModelJson::toRank)
             .forEach(ranksNode::add);

        return ranksNode;
    }

    /**
     * @return The relationship with its kind, the ids of its targets and, for a recombination,
     *   the id of its partner.
     */
    private static ObjectNode toRelationship(final Relationship relationship) {
        final ObjectNode relationshipNode = NODES.objectNode();

        switch(relationship) {
            case Identity identity -> relationshipNode.put("kind", "identity");
            case Mutation mutation -> relationshipNode.put("kind", "mutation");
            case Recombination recombination -> relationshipNode.put("kind", "recombination");
            default -> throw new IllegalStateException("Unsupported relationship "
                                                       + relationship.eClass().getName() + ".");
        }

        relationshipNode.set("targets", toIds(relationship.getTarget()));

        if(relationship instanceof Recombination recombination) {
            final int partner = partnerOf(recombination);
            relationshipNode.put("partner", partner);
        }

        return relationshipNode;
    }

    /**
     * @return The setup of the run: EvoAl version, seed (as a string, since it may exceed the
     *   integers that every JSON reader represents exactly), run and, in the evaluation setup,
     *   repetition and target.
     */
    private static ObjectNode toSetup(final RunSetup setup) {
        final ObjectNode setupNode = NODES.objectNode();
        setupNode.put("evoalVersion", setup.evoalVersion());

        final String seed = Long.toString(setup.seed());
        setupNode.put("seed", seed);
        setupNode.put("run", setup.run());

        final EvaluationPosition position = setup.evaluationPosition();
        if(position != null) {
            addEvaluationPosition(setupNode, position);
        }

        return setupNode;
    }

    /**
     * @return The step with its kind, description and its ranks or individuals.
     */
    private static ObjectNode toStep(final IterationStep step) {
        final ObjectNode stepNode = NODES.objectNode();

        switch(step) {
            case OrderedIterationStep ordered -> {
                stepNode.put("kind", "ordered");
                stepNode.put("description", Objects.requireNonNullElse(step.getDescription(), ""));
                stepNode.set("ranks", toRanks(ordered.getRanks()));
            }
            case UnorderedIterationStep unordered -> {
                stepNode.put("kind", "unordered");
                stepNode.put("description", Objects.requireNonNullElse(step.getDescription(), ""));
                stepNode.set("individuals", toIds(unordered.getIndividuals()));
            }
            default -> throw new IllegalStateException("Unsupported iteration step " + step.eClass().getName() + ".");
        }

        return stepNode;
    }

    /**
     * @return The value as JSON: numbers (non-finite ones as strings), booleans, strings, enum
     *   literals by name, collections as arrays, {@code null} if there is no value.
     */
    private static JsonNode toValue(final Object value) {
        return switch(value) {
            case null -> NODES.nullNode();
            case Number number -> toNumber(number);
            case Boolean bool -> NODES.booleanNode(bool);
            case String string -> NODES.stringNode(string);
            case Enumerator literal -> NODES.stringNode(literal.getName());
            case Collection<?> collection -> toArray(collection);
            case Object[] array -> toArray(List.of(array));
            default -> throw new IllegalStateException("Unsupported value type " + value.getClass().getName() + ".");
        };
    }

    /**
     * @return The values of all features of the object's space, keyed by feature name; empty if
     *   there is no object (e.g., an individual that is not evaluated).
     */
    private static ObjectNode toValues(final TypedEObject values) {
        final ObjectNode valuesNode = NODES.objectNode();
        if(values == null) {
            return valuesNode;
        }

        values.eClass()
              .getEAllStructuralFeatures()
              .forEach(feature -> valuesNode.set(feature.getName(), valueOf(values, feature)));

        return valuesNode;
    }

    /**
     * @return The value of the feature, {@code null} if it has no value. {@code eIsSet} is not
     *   used, since it is {@code false} for values equal to the default (e.g. {@code 0.0}).
     */
    private static JsonNode valueOf(final TypedEObject values, final EStructuralFeature feature) {
        final Object value = values.eGet(feature);

        return toValue(value);
    }
}
