package de.evoal.core.api.languages.paths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.ReadExpression;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.interpreter.ConstantEvaluator;

import de.evoal.core.api.languages.base.ElementSwitch;

/**
 * Evaluates a {@link Path} on the parsed model of a file. The model is seen as one tree of
 *   objects:
 *
 * <ul>
 *   <li>a DL instance (e.g. {@code 'arpso-swarm' { … }}) has its DL attributes as children;
 *     an attribute that the instance does not set has its DL default, and an attribute
 *     without either has no value;</li>
 *   <li>any other object of the languages (a language construct, e.g. a module, a problem or a
 *     generator step) has its ecore features as children, e.g. {@code problem} of the
 *     {@code configure} block. The {@code configure} block is both: a DL attribute wins over
 *     an ecore feature of the same name;</li>
 *   <li>a value of an array is each of its elements, a reference to data is the data
 *     description, a constant (number, string, boolean, enum literal) is its value;</li>
 *   <li>{@code ..} is the nearest containing instance or construct (attributes and expressions
 *     around a value are skipped), {@code /} the module of the file. A value has no parent;</li>
 *   <li>{@code *} and {@code //} follow only what an object contains: the DL attributes of an
 *     instance and the containment features of a construct, not references such as
 *     {@code problem}.</li>
 * </ul>
 *
 * The result keeps the order of the selection; an object is selected at most once, a value as
 *   often as it is reached. A type filter has to name a DL type of a DL module in the resource
 *   set of the selected objects.
 */
public final class PathEvaluator {
    /**
     * The most rounds of a {@code (p)*} or {@code (p)+}; the configuration tree is finite, so a
     *   repetition ends long before.
     */
    private static final int MAXIMUM_REPETITIONS = 10_000;

    /**
     * Computes constant values, e.g. a number or an enum literal.
     */
    private final ConstantEvaluator constants = new ConstantEvaluator();

    private PathEvaluator() {
    }

    private List<Object> allChildren(final Object node) {
        if(!(node instanceof EObject object)) {
            return List.of();
        }

        final List<Object> children = new ArrayList<>();
        if(object instanceof Instance instance) {
            for(final AttributeDefinition attribute : instance.getDefinition().getAllAttributes()) {
                final List<Object> values = valueOf(instance, attribute);
                children.addAll(values);
            }
        }

        for(final EReference containment : object.eClass().getEAllContainments()) {
            if(containment == ExpressionsPackage.Literals.INSTANCE__ATTRIBUTES) {
                continue;
            }

            final List<Object> values = valuesOf(object, containment);
            children.addAll(values);
        }

        return children;
    }

    private List<Object> apply(final Path path, final List<Object> selection) {
        return switch(path) {
            case Path.Self self -> selection;
            case Path.Root root -> rootsOf(selection);
            case Path.Parent parent -> distinct(selection.stream()
                                                         .map(PathEvaluator::parentOf)
                                                         .flatMap(Optional::stream)
                                                         .toList());
            case Path.Child child -> distinct(selection.stream()
                                                       .flatMap(node -> childrenNamed(node, child.name()).stream())
                                                       .toList());
            case Path.AllChildren all -> distinct(selection.stream()
                                                           .flatMap(node -> allChildren(node).stream())
                                                           .toList());
            case Path.Descendants descendants -> descendantsOf(selection);
            case Path.TypeFilter filter -> instancesOf(filter, selection);
            case Path.Repetition repetition -> repeat(repetition, selection);
            case Path.Sequence sequence -> applySteps(sequence.steps(), selection);
            case Path.Union union -> distinct(union.alternatives()
                                                   .stream()
                                                   .flatMap(alternative -> apply(alternative, selection).stream())
                                                   .toList());
        };
    }

    private List<Object> applySteps(final List<Path> steps, final List<Object> selection) {
        List<Object> current = selection;
        for(final Path step : steps) {
            current = apply(step, current);
        }

        return current;
    }

    private List<Object> childrenNamed(final Object node, final String name) {
        if(!(node instanceof EObject object)) {
            return List.of();
        }

        if(object instanceof Instance instance) {
            final Optional<AttributeDefinition> attribute = instance.getDefinition()
                                                                    .getAllAttributes()
                                                                    .stream()
                                                                    .filter(definition -> name.equals(definition.getName()))
                                                                    .findFirst();
            if(attribute.isPresent()) {
                final AttributeDefinition definition = attribute.get();

                return valueOf(instance, definition);
            }
        }

        final EStructuralFeature feature = object.eClass().getEStructuralFeature(name);
        if(feature == null) {
            return List.of();
        }

        return valuesOf(object, feature);
    }

    private List<Object> constantOf(final Expression expression) {
        try {
            final Object value = constants.doSwitch(expression);

            return value == null ? List.of() : List.of(value);
        } catch(final RuntimeException e) {
            return List.of();
        }
    }

    private List<Object> descendantsOf(final List<Object> selection) {
        final List<Object> result = new ArrayList<>();
        final Set<Object> visited = Collections.newSetFromMap(new IdentityHashMap<>());
        final List<Object> pending = new ArrayList<>(selection);

        while(!pending.isEmpty()) {
            final Object node = pending.removeFirst();
            final boolean isVisitedObject = node instanceof EObject && !visited.add(node);
            if(isVisitedObject) {
                continue;
            }

            result.add(node);

            final List<Object> children = allChildren(node);
            pending.addAll(0, children);
        }

        return result;
    }

    /**
     * @return The selection with every object once; values (e.g. numbers) are kept as often as
     *   they are selected.
     */
    private static List<Object> distinct(final List<Object> selection) {
        final Set<Object> seen = Collections.newSetFromMap(new IdentityHashMap<>());

        return selection.stream()
                        .filter(node -> !(node instanceof EObject) || seen.add(node))
                        .toList();
    }

    /**
     * Evaluates the path from the start object.
     *
     * @param text The text of the path, e.g. {@code ../mover[arpso-mover]}.
     * @param start The object the path starts at, e.g. the instance an annotation is checked for.
     * @return The selected objects and values, possibly empty.
     * @throws PathException if the path is invalid, e.g. names an unknown type.
     */
    public static List<Object> evaluate(final String text, final EObject start) {
        final Path path = PathParser.parse(text);
        requireKnownTypes(text, path, start);

        final PathEvaluator evaluator = new PathEvaluator();

        return evaluator.apply(path, List.of(start));
    }

    private static boolean hasType(final Instance instance, final Path.TypeFilter filter) {
        final ClassDefinition type = instance.getDefinition();
        if(filter.exactly()) {
            return filter.typeName().equals(type.getName());
        }

        for(ClassDefinition current = type; current != null; current = current.getSuperType()) {
            if(filter.typeName().equals(current.getName())) {
                return true;
            }
        }

        return false;
    }

    private static List<Object> instancesOf(final Path.TypeFilter filter, final List<Object> selection) {
        return selection.stream()
                        .filter(Instance.class::isInstance)
                        .filter(node -> hasType((Instance) node, filter))
                        .toList();
    }

    /**
     * @return Whether the object is an instance or a language construct, not an attribute or an
     *   expression around a value.
     */
    private static boolean isNode(final EObject object) {
        final boolean isExpression = object instanceof Expression && !(object instanceof Instance);

        return !(object instanceof Attribute) && !isExpression;
    }

    private static boolean isTypeIn(final ResourceSet resources, final String typeName) {
        return resources.getResources()
                        .stream()
                        .flatMap(resource -> resource.getContents().stream())
                        .filter(DefinitionModule.class::isInstance)
                        .flatMap(module -> ((DefinitionModule) module).getTypes().stream())
                        .anyMatch(type -> typeName.equals(type.getName()));
    }

    private static Optional<Object> parentOf(final Object node) {
        if(!(node instanceof EObject object)) {
            return Optional.empty();
        }

        for(EObject container = object.eContainer(); container != null; container = container.eContainer()) {
            if(isNode(container)) {
                return Optional.of(container);
            }
        }

        return Optional.empty();
    }

    private List<Object> repeat(final Path.Repetition repetition, final List<Object> selection) {
        final List<Object> result = new ArrayList<>();
        final Set<Object> reached = Collections.newSetFromMap(new IdentityHashMap<>());
        if(!repetition.atLeastOnce()) {
            result.addAll(selection);
            reached.addAll(selection);
        }

        List<Object> frontier = selection;
        for(int round = 0; round < MAXIMUM_REPETITIONS && !frontier.isEmpty(); ++round) {
            final List<Object> next = apply(repetition.path(), frontier).stream()
                                                                         .filter(EObject.class::isInstance)
                                                                         .filter(reached::add)
                                                                         .toList();
            result.addAll(next);
            frontier = next;
        }

        return result;
    }

    /**
     * Checks that every type filter of the path names a DL type of a DL module in the resource
     *   set of the start object. Without a resource set, nothing is checked.
     *
     * @throws PathException for the first unknown type name.
     */
    private static void requireKnownTypes(final String text, final Path path, final EObject start) {
        final Resource resource = start.eResource();
        final ResourceSet resources = resource == null ? null : resource.getResourceSet();
        if(resources == null) {
            return;
        }

        final Optional<Path.TypeFilter> unknown = typeFiltersOf(path).stream()
                                                                     .filter(filter -> !isTypeIn(resources, filter.typeName()))
                                                                     .findFirst();
        if(unknown.isPresent()) {
            final Path.TypeFilter filter = unknown.get();
            throw new PathException(text, filter.offset(), "unknown type '" + filter.typeName() + "'");
        }
    }

    private static List<Object> rootsOf(final List<Object> selection) {
        return distinct(selection.stream()
                                 .filter(EObject.class::isInstance)
                                 .map(node -> (Object) EcoreUtil.getRootContainer((EObject) node))
                                 .toList());
    }

    private List<Object> toNodes(final Object value) {
        return switch(value) {
            case Instance instance -> List.of(instance);
            case TypeDefinitionReference reference -> List.of(reference.getDefinition());
            case Array array -> array.getValues()
                                     .stream()
                                     .flatMap(element -> valuesOf(element).stream())
                                     .toList();
            case Expression expression -> constantOf(expression);
            default -> List.of(value);
        };
    }

    private static List<Path.TypeFilter> typeFiltersOf(final Path path) {
        return switch(path) {
            case Path.TypeFilter filter -> List.of(filter);
            case Path.Repetition repetition -> typeFiltersOf(repetition.path());
            case Path.Sequence sequence -> sequence.steps()
                                                   .stream()
                                                   .flatMap(step -> typeFiltersOf(step).stream())
                                                   .toList();
            case Path.Union union -> union.alternatives()
                                          .stream()
                                          .flatMap(alternative -> typeFiltersOf(alternative).stream())
                                          .toList();
            default -> List.of();
        };
    }

    private List<Object> valueOf(final Instance instance, final AttributeDefinition attribute) {
        final Attribute value = instance.findAttribute(attribute);
        if(value != null) {
            return valuesOf(value.getValue());
        }

        return valuesOf(attribute.getInitialisation());
    }

    private List<Object> valuesOf(final EObject object, final EStructuralFeature feature) {
        final Object value = object.eGet(feature);
        final List<?> values = feature.isMany() ? (List<?>) value : Collections.singletonList(value);

        return values.stream()
                     .filter(Objects::nonNull)
                     .flatMap(element -> toNodes(element).stream())
                     .toList();
    }

    private List<Object> valuesOf(final Expression expression) {
        if(expression == null) {
            return List.of();
        }

        final Optional<ReadExpression> element = ElementSwitch.elementOf(expression);
        if(element.isEmpty()) {
            return constantOf(expression);
        }

        final ReadExpression value = element.get();

        return toNodes(value);
    }
}
