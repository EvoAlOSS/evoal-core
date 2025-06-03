package de.evoal.optimisation.ea.main.codec.model;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.types.*;
import de.evoal.languages.model.base.types.DefinitionReference;
import de.evoal.optimisation.ea.api.codec.model.ModelGene;
import de.evoal.languages.model.base.expressions.*;
import io.jenetics.util.RandomRegistry;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Stream;

@Slf4j
public record ModelBuilder(ClassDefinition root, Map<ClassDefinition, Set<ClassDefinition>> subtypes, Map<AttributeDefinition, Set<ClassDefinition>> attributes) {
    private static final ExpressionsFactory FACTORY = ExpressionsFactory.eINSTANCE;

    public Instance random() {
        return random(root);
    }

    public @NonNull Iterable<ModelGene> toIterable(final @NonNull Instance tree) {
        final List<ModelGene> genes = new ArrayList<>();

        toIterable(genes, tree);

        return genes;
    }

    private void toIterable(final @NonNull List<ModelGene> genes, @NonNull final Instance tree) {
        genes.add(ModelGene.of(this, tree));

        for(final Attribute attr : tree.getAttributes()) {
            final Type type = attr.getDefinition().getType();
            if(type instanceof DefinitionReference) {
                toIterable(genes, findInstance(attr.getValue()));
            } else if(type instanceof ArrayType arrayType && arrayType.getElements() instanceof DefinitionReference instanceType) {
                final Array array = findArray(attr.getValue());
                array.getValues()
                        .stream()
                        .map(Instance.class::cast)
                        .forEach(i -> toIterable(genes, i));
            }
        }
    }

    private Array findArray(Expression value) {
        return (Array) ((OrExpression)value)
                .getSubExpressions().get(0)
                .getSubExpressions().get(0)
                .getSubExpressions().get(0)
                .getOperand()
                .getLeftOperand()
                .getLeftOperand()
                .getLeftOperand()
                .getLeftOperand()
                .getSubExpression();
    }

    private Instance findInstance(final Expression value) {
        return (Instance) ((OrExpression)value)
                .getSubExpressions().get(0)
                .getSubExpressions().get(0)
                .getSubExpressions().get(0)
                .getOperand()
                .getLeftOperand()
                .getLeftOperand()
                .getLeftOperand()
                .getLeftOperand()
                .getSubExpression();
    }

    /**
     * Creates an instance of the given type and sets the attributes randomly.
     *
     * @param definition Instance type.
     * @return A valid instance.
     */
    private @NonNull Instance random(final ClassDefinition definition) {
        log.info("Creating instance of type {}", definition.getName());
        final Instance instance = FACTORY.createInstance();
        instance.setDefinition(definition);

        for(AttributeDefinition attributeDef : allAttributes(definition)) {
            instance.getAttributes().add(random(attributeDef));
        }

        return instance;
    }

    private Collection<AttributeDefinition> allAttributes(final ClassDefinition definition) {
        if(definition == null) {
            return new ArrayList<>();
        }

        final Collection<AttributeDefinition> attributes = allAttributes(definition.getSuperType());
        attributes.addAll(definition.getAttributes());

        return attributes;
    }

    /**
     * Creates an attribute for the given {@code definition} and initialises the
     *   value randomly.
     *
     * @param definition The attribute to generate.
     * @return A valid attribute.
     */
    public @NonNull Attribute random(final AttributeDefinition definition) {
        final Attribute attribute = FACTORY.createAttribute();

        attribute.setDefinition(definition);
        attribute.setValue(toExpression(random(definition.getName(), definition.getType())));

        return attribute;
    }

    private @NonNull Expression toExpression(@NonNull ReadExpression value) {
        final OrExpression or = FACTORY.createOrExpression();

        final XorExpression xor = FACTORY.createXorExpression();
        or.getSubExpressions().add(xor);

        final AndExpression and = FACTORY.createAndExpression();
        xor.getSubExpressions().add(and);

        final NotExpression not = FACTORY.createNotExpression();
        and.getSubExpressions().add(not);

        final ComparisonExpression comparison = FACTORY.createComparisonExpression();
        not.setOperand(comparison);
        not.setNegated(false);

        final AddOrSubtractExpression add = FACTORY.createAddOrSubtractExpression();
        comparison.setLeftOperand(add);

        final MultiplyDivideModuloExpression multiply = FACTORY.createMultiplyDivideModuloExpression();
        add.setLeftOperand(multiply);

        final PowerOfExpression power = FACTORY.createPowerOfExpression();
        multiply.setLeftOperand(power);

        final UnaryAddOrSubtractExpression unary = FACTORY.createUnaryAddOrSubtractExpression();
        power.setLeftOperand(unary);

        unary.setSubExpression(value);

        return or;
    }

    public @NonNull ReadExpression random(final @NonNull String name, final @NonNull Type type) {
        if(type instanceof ArrayType arrayType) {
            return random(name, arrayType);
        } else if(type instanceof DefinitionReference instanceType) {
            final Set<ClassDefinition> definitions = subtypes.get((ClassDefinition)instanceType.getDefinition());
            final List<ClassDefinition> types = new ArrayList<>(definitions);
            int index = RandomRegistry.random().nextInt(definitions.size());
            return random(types.get(index));
        } else if(type instanceof IntType) {
            return random(name, (IntType) type);
        } else if(type instanceof BooleanType) {
            return random((BooleanType) type);
        } else {
            throw new IllegalArgumentException("Unsupported type: " + type.eClass().getName());
        }
    }

    private @NonNull ReadExpression random(final String name, final IntType type) {
        final IntegerLiteral literal = FACTORY.createIntegerLiteral();
        int value = RandomRegistry.random().nextInt(0, 4);
        if("value".equals(name)) {
            value = RandomRegistry.random().nextInt(0, 16);
            value = (int)Math.pow(2, value);
        }
        literal.setLiteral(value);

        return literal;
    }

    private @NonNull ReadExpression random(final BooleanType type) {
        final BooleanLiteral literal = FACTORY.createBooleanLiteral();
        literal.setLiteral(RandomRegistry.random().nextInt(0, 2) == 1);

        return literal;
    }

    private @NonNull ReadExpression random(@NonNull  final String name, final @NonNull ArrayType type) {
        int count = "entries".equals(name) ? RandomRegistry.random().nextInt(1,5) : 1; // ; // TODO What about a gaussian distribution?

        final Array array = FACTORY.createArray();
        for(int i = 0; i < count; i++) {
            final ReadExpression child = random(name, type.getElements());
            array.getValues().add(child);
        }

        return array;
    }

    public int size(final Instance instance) {
        return 1 + instance.getAttributes()
                .stream()
                .filter(a -> {
                    Type t = a.getDefinition().getType();
                    if(t instanceof ArrayType) {
                        t = ((ArrayType)t).getElements();
                    }

                    return t instanceof DefinitionReference;
                })
                .flatMap(a -> {
                    Type t = a.getDefinition().getType();
                    if(t instanceof ArrayType) {
                        return findArray(a.getValue()).getValues().stream().map(Instance.class::cast);
                    }

                    return Stream.of(findInstance(a.getValue()));
                })
                .mapToInt(this::size)
                .sum();
    }
}
