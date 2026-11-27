package de.evoal.core.api.dynamic;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.ConstantDefinition;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.EnumLiteralDefinition;
import de.evoal.languages.model.base.definitions.TypeDefinition;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.expressions.util.ExpressionsSwitch;
import de.evoal.languages.model.interpreter.numeric.ArithmeticNumberOperations;
import de.evoal.languages.model.interpreter.numeric.BooleanNumberOperations;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;
import de.evoal.languages.model.interpreter.ConstantEvaluator;
import de.evoal.core.api.languages.base.ElementSwitch;
import de.evoal.models.core.ecore.Space;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Dependent
public class ValueConverter extends ExpressionsSwitch<Object> {
    /**
     * Logger instance.
     */
    private final static Logger log = LoggerFactory.getLogger(ValueConverter.class);

    @Inject
    private EAnnotationHelper helper;

    @Inject
    private DynamicEClassProvider provider;

    /**
     * The space of the optimisation problem
     */
    private Space space;


    /**
     * The target type to generate
     */
    private EStructuralFeature targetType = null;

    /**
     * For evaluating constants.
     */
    private Optional<ConstantEvaluator> constantEvaluator = Optional.empty();

    public ValueConverter setConstantEvaluator(final ConstantEvaluator evaluator) {
        this.constantEvaluator = Optional.of(evaluator);
        return this;
    }

    public ValueConverter setSpace(final Space space) {
        this.space = space;
        return this;
    }

    public ValueConverter setTargetType(final EStructuralFeature targetType) {
        this.targetType = targetType;
        return this;
    }

    public Object convert(final EObject eObject) {
        log.info("Converting {} to {}.", eObject,  targetType);

        if(targetType != null && targetType.getEType() == ExpressionsPackage.Literals.EXPRESSION) {
            // expressions are stored unevaluated and evaluated later by the component
            if(targetType.isMany() && eObject instanceof Array array) {
                return new ArrayList<>(array.getValues());
            }

            return eObject;
        }

        if(targetType != null && targetType.getEType() == ExpressionsPackage.Literals.PATH_EXPRESSION) {
            // paths are stored unevaluated and evaluated later from the object they are checked for
            if(targetType.isMany() && eObject instanceof Array array) {
                return array.getValues()
                            .stream()
                            .map(this::toPathExpression)
                            .collect(Collectors.toList());
            }

            return toPathExpression(eObject);
        }

        final Object value = toTargetType(doSwitch(eObject));
        log.info("Converted {} ({}) to {}.", eObject, targetType, value);
        return value;
    }

    /**
     * @return The path expression the expression consists of.
     * @throws IllegalArgumentException if the expression is no path expression.
     */
    private PathExpression toPathExpression(final EObject expression) {
        final Optional<ReadExpression> element = expression instanceof Expression value
                                                 ? ElementSwitch.elementOf(value)
                                                 : Optional.empty();
        if(element.isPresent() && element.get() instanceof PathExpression path) {
            return path;
        }

        throw new IllegalArgumentException("Invalid value for attribute '" + targetType.getName()
                                           + "': expected a path expression, e.g. path \"../features\".");
    }

    /**
     * Converts numbers to the type of the target feature, e.g., the integer literal
     *   {@code 1} assigned to an attribute of type {@code real}. The dynamic model does
     *   not convert values on {@code eSet}, so an {@code EDouble} attribute would
     *   otherwise contain an {@link Integer}. For multi-valued features, each element
     *   is converted. See {@link NumericConversions} for the conversion rules.
     */
    private Object toTargetType(final Object value) {
        if(targetType == null) {
            return value;
        }

        try {
            if(targetType.getEType() instanceof EEnum eEnum) {
                return toEnumLiteral(value, eEnum);
            }

            return NumericConversions.toType(value, targetType.getEType());
        } catch(final IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid value for attribute '" + targetType.getName() + "': " + e.getMessage(), e);
        }
    }

    /**
     * Converts DL enum literals into the literals of the generated EEnum (element-wise for lists).
     */
    private static Object toEnumLiteral(final Object value, final EEnum eEnum) {
        if(value instanceof List<?> values) {
            return values.stream()
                         .map(v -> toEnumLiteral(v, eEnum))
                         .collect(Collectors.toList());
        }

        if(!(value instanceof EnumLiteralDefinition definition)) {
            throw new IllegalArgumentException("Expected a literal of enum '" + eEnum.getName() + "' but got '" + value + "'.");
        }

        final EEnumLiteral literal = eEnum.getEEnumLiteral(definition.getName());
        if(literal == null) {
            throw new IllegalArgumentException("Enum '" + eEnum.getName() + "' has no literal '" + definition.getName() + "'.");
        }

        return literal;
    }

    @Override
    public Object caseAddOrSubtractExpression(final AddOrSubtractExpression object) {
        Object result = this.doSwitch(object.getLeftOperand());

        for (int i = 0; i < object.getOperands().size(); ++i) {
            final Object rOp = doSwitch(object.getOperands().get(i));

            result = switch (object.getOperators().get(i)) {
                case ADD:
                    if (result instanceof Number && rOp instanceof Number) {
                        yield ArithmeticNumberOperations.add(result, rOp);
                    } else if (result instanceof String || rOp instanceof String) {
                        yield Objects.toString(result) + Objects.toString(rOp);
                    } else {
                        throw new IllegalStateException("Failed to add values " + Objects.toString(result) + " and " + Objects.toString(rOp));
                    }

                case SUBTRACT:
                    if (result instanceof Number && rOp instanceof Number) {
                        yield ArithmeticNumberOperations.minus(result, rOp);
                    } else {
                        throw new IllegalStateException("Failed to subtract values " + Objects.toString(result) + " and " + Objects.toString(rOp));
                    }
            };
        }

        return result;
    }

    @Override
    public Object caseAndExpression(AndExpression object) {
        if (object.getSubExpressions().size() == 1) {
            return doSwitch(object.getSubExpressions().get(0));
        }

        boolean result = true;

        for (final NotExpression sub : object.getSubExpressions()) {
            Object subResult = doSwitch(sub);

            if (!(subResult instanceof Boolean)) {
                log.warn("Subexpression of 'and' did not return a boolean value: {}. Testing it for null and continue.", subResult);
                subResult = subResult != null;
            }

            result = result && (Boolean) subResult;

            if (!result) {
                // short-circuit
                break;
            }
        }

        return result;
    }

    @Override
    public Object caseArray(final Array object) {
        if(targetType != null && targetType.getEType() instanceof EClass arrayClass && DynamicArrays.isArrayClass(arrayClass)) {
            return toArrayObjects(object, arrayClass);
        }

        return object.getValues()
                .stream()
                .map(this::doSwitch)
                .collect(Collectors.toList());
    }

    /**
     * Converts a multi-dimensional array: each element of the given array is converted
     *   into an array object of the given array class (see {@link DynamicArrays}).
     */
    private List<EObject> toArrayObjects(final Array object, final EClass arrayClass) {
        final EStructuralFeature valuesFeature = DynamicArrays.valuesFeature(arrayClass);
        final List<EObject> result = new ArrayList<>();

        for(final Expression element : object.getValues()) {
            // push the target type of the next dimension
            final EStructuralFeature targetTypeStack = this.targetType;
            final Object value = setTargetType(valuesFeature).convert(element);
            setTargetType(targetTypeStack);

            if(!(value instanceof List<?> values)) {
                throw new IllegalStateException("Expected an array for dimension " + arrayClass.getName() + " but got " + value);
            }

            final EObject array = provider.getEObject(arrayClass);
            DynamicArrays.valuesOf(array).addAll(values);
            result.add(array);
        }

        return result;
    }

    @Override
    public Object caseAttribute(Attribute object) {
        throw new IllegalStateException("Not yet implemented");
    }

    @Override
    public Object caseCall(Call object) {
        throw new IllegalStateException("Not yet implemented");
    }

    @Override
    public Object caseComparisonExpression(final ComparisonExpression object) {
        Object result = doSwitch(object.getLeftOperand());

        for (final PartialComparisonExpression subExpression : object.getComparison()) {
            final Object rOp = doSwitch(subExpression.getSubExpression());

            result = switch (subExpression.getOperator()) {
                case EQUAL:
                    yield Objects.equals(result, rOp);
                case UNEQUAL:
                    yield !Objects.equals(result, rOp);
                case GREATER_EQUAL:
                    yield BooleanNumberOperations.isGreaterThanOrEqualTo(result, rOp);
                case GREATER_THAN:
                    yield BooleanNumberOperations.isGreaterThan(result, rOp);
                case LESS_EQUAL:
                    yield BooleanNumberOperations.isLesserThanOrEqualTo(result, rOp);
                case LESS_THAN:
                    yield BooleanNumberOperations.isLesserThan(result, rOp);
                default:
                    throw new IllegalStateException("Not yet implemented: " + subExpression.getOperator().getName());
            };
        }

        return result;
    }

    @Override
    public Object caseLiteralDefinitionReference(final LiteralDefinitionReference object) {
        if (object.getDefinition() instanceof ConstantDefinition) {
            if (constantEvaluator.isEmpty()) {
                throw new IllegalStateException("There is no constant evaluator");
            }

            return constantEvaluator.get().evaluate(object);
        }

        return super.caseLiteralDefinitionReference(object);
    }

    @Override
    public Object caseInstance(final Instance instance) {
        log.info("Converting instance {}.", instance.getDefinition().getName());

        final EClass clazz = provider.toEClass(instance.getDefinition());
        final EObject object =  provider.getEObject(clazz);
        final Set<String> specified = new HashSet<>();

        for(final Attribute attribute : instance.getAttributes()) {
            final EStructuralFeature feature = provider.getFeature(attribute.getDefinition());
            assign(object, feature, attribute.getValue());
            specified.add(feature.getName());
        }

        applyDefaults(object, instance.getDefinition(), specified);

        return object;
    }

    /**
     * Assigns the default values of all attributes of the type (including inherited ones)
     *   that are not specified. If an attribute is redefined, the most specific definition wins.
     *   The default values are converted like specified values, so each object gets its own
     *   values (e.g., new instances for defaults of type {@code instance}).
     *
     * @param object The runtime object to complete.
     * @param definition The DL type of the object.
     * @param specified Names of the attributes that have been specified explicitly.
     */
    public void applyDefaults(final EObject object, final ClassDefinition definition, final Set<String> specified) {
        final Set<String> handled = new HashSet<>(specified);

        // getAllAttributes returns the attributes of the most specific type first
        for(final AttributeDefinition attribute : definition.getAllAttributes()) {
            if(!handled.add(attribute.getName()) || attribute.getInitialisation() == null) {
                continue;
            }

            log.info("Using default value for {}.{}", definition.getName(), attribute.getName());
            assign(object, provider.getFeature(attribute), attribute.getInitialisation());
        }
    }

    /**
     * Converts the expression to the type of the feature and assigns it to the object.
     */
    private void assign(final EObject object, final EStructuralFeature feature, final Expression expression) {
        // for converting the attribute, we have to push the target type on the stack and overwrite it with the new target type
        final EStructuralFeature targetTypeStack = this.targetType;
        final Object value = setTargetType(feature).convert(expression);
        setTargetType(targetTypeStack);

        if(value == null) {
            return;
        }

        final boolean isContainment = feature instanceof EReference reference && reference.isContainment();

        if(feature.isMany()) {
            final List<Object> values = (List<Object>) object.eGet(feature);
            final List<?> converted = (List<?>) value;
            values.clear();
            converted.stream()
                     .map(element -> isContainment ? uncontained(element) : element)
                     .forEach(values::add);
        } else {
            object.eSet(feature, isContainment ? uncontained(value) : value);
        }
    }

    /**
     * Returns an object that can be put into a containment feature: the object itself if no
     *   other object contains it, else a copy. Adding a contained object to a containment feature
     *   would move it out of its container, e.g. a value that two attributes share.
     */
    private static Object uncontained(final Object value) {
        if(value instanceof EObject object && object.eContainer() != null) {
            return EcoreUtil.copy(object);
        }

        return value;
    }

    @Override
    public Object caseLiteral(final Literal object) {
        log.info("Vising {}", object);

        return object.getValue();
    }

    @Override
    public Object caseMultiplyDivideModuloExpression(MultiplyDivideModuloExpression object) {
        Object result = doSwitch(object.getLeftOperand());

        for (int i = 0; i < object.getOperands().size(); ++i) {
            final Object rOp = doSwitch(object.getOperands().get(i));

            result = switch (object.getOperators().get(i)) {
                case DIVIDE:
                    yield ArithmeticNumberOperations.divide(result, rOp);
                case MODULO:
                    yield ArithmeticNumberOperations.modulo(result, rOp);
                case MULTIPLY:
                    yield ArithmeticNumberOperations.multiply(result, rOp);
            };
        }

        return result;
    }

    @Override
    public Object caseNotExpression(final NotExpression object) {
        Object subResult = doSwitch(object.getOperand());

        if (object.isNegated()) {
            if (!(subResult instanceof Boolean)) {
                log.warn("Subexpression of 'not' did not return a boolean value: {}. Testing it for null and continue.", subResult);
                subResult = subResult != null;
            }

            subResult = !(Boolean) subResult;
        }

        return subResult;
    }

    @Override
    public Object caseOrExpression(final OrExpression object) {
        if (object.getSubExpressions().size() == 1) {
            return doSwitch(object.getSubExpressions().get(0));
        }

        boolean result = false;

        for (final XorExpression sub : object.getSubExpressions()) {
            Object subResult = doSwitch(sub);

            if (!(subResult instanceof Boolean)) {
                log.warn("Subexpression of 'or' did not return a boolean value: {}. Testing it for null and continue.", subResult);
                subResult = subResult != null;
            }

            result = result || (Boolean) subResult;

            if (result) {
                // short-circuit
                break;
            }
        }

        return result;
    }

    @Override
    public Object caseParantheses(final Parantheses object) {
        return doSwitch(object.getSubExpression());
    }

    @Override
    public Object casePowerOfExpression(PowerOfExpression object) {
        Object result = doSwitch(object.getLeftOperand());

        if (object.getRightOperand() != null) {
            final Object rOp = doSwitch(object.getRightOperand());
            result = ArithmeticNumberOperations.pow(result, rOp);
        }

        return result;
    }

    @Override
    public Object caseUnaryAddOrSubtractExpression(final UnaryAddOrSubtractExpression object) {
        Object result = doSwitch(object.getSubExpression());

        if (!object.getOperators().isEmpty()) {
            if (!(result instanceof Number)) {
                throw new IllegalStateException("Cannot apply unary add/subtract to value " + result);
            }

            for (final AddOrSubtractOperator op : object.getOperators()) {
                result = switch (op) {
                    case ADD:
                        yield result;
                    case SUBTRACT:
                        yield ArithmeticNumberOperations.multiply(result, -1);
                };
            }
        }

        return result;
    }

    @Override
    public Object caseValueReference(final ValueReference object) {
        if (object instanceof ValueDefinitionReference reference) {
            if (reference.getDefinition() instanceof ConstantDefinition constant) {
                return doSwitch(constant.getValue());
            }

            return reference.getDefinition();
        } else if (object instanceof TypeDefinitionReference type) {
            final TypeDefinition description = type.getDefinition();

            return helper.featureOf(space.getEClass(), (DataDescription) description);

        } else if (object instanceof ConfigurationReference) {
            return object;
        } else {
            throw new IllegalStateException("Not yet implemented: " + object.eClass() + " -- " + object);
        }
    }

    @Override
    public Object caseXorExpression(XorExpression object) {
        if (object.getSubExpressions().size() == 1) {
            return doSwitch(object.getSubExpressions().get(0));
        }

        boolean result = true;

        for (final AndExpression sub : object.getSubExpressions()) {
            Object subResult = doSwitch(sub);

            if (!(subResult instanceof Boolean)) {
                log.warn("Subexpression of 'xor' did not return a boolean value: {}. Testing it for null and continue.", subResult);
                subResult = subResult != null;
            }

            result = result ^ (Boolean) subResult;
        }

        return result;
    }

    @Override
    public Object caseAttributeReference(final AttributeReference reference) {
        EObject base = (EObject) doSwitch(reference.getSelf());

        for (final ValueDefinitionReference child : reference.getChain()) {
            assert child.isAttributeReference();
            final AttributeDefinition attr = (AttributeDefinition) child.getDefinition();

            base = ((Instance) base)
                    .getAttributes()
                    .stream()
                    .filter(a -> a.getDefinition().equals(attr))
                    .findFirst()
                    .get()
                    .getValue();
        }

        return doSwitch(base);
    }

    @Override
    public Object casePathExpression(final PathExpression path) {
        throw new IllegalArgumentException("The path expression path \"" + path.getPath() + "\" can only be the value of a "
                                           + "'path' attribute or part of a constraint expression.");
    }

    @Override
    public Object defaultCase(EObject object) {
        throw new IllegalStateException("Not yet implemented: " + object.eClass().getName());
    }
}
