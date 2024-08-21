package de.evoal.optimisation.ea.main.alterer.model.crossover;

import de.evoal.optimisation.ea.api.operators.AltererComponent;
import de.evoal.languages.model.base.*;
import io.jenetics.util.RandomRegistry;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.*;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

@Slf4j
public class FeatureSwapCrossover extends TreeCrossover implements AltererComponent {
    private final RandomGenerator random = RandomRegistry.random();

    /**
     * Constructs an alterer with a given recombination probability.
     *
     * @param probability The recombination probability.
     * @throws IllegalArgumentException if the {@code probability} is not in the
     *                                  valid range of {@code [0, 1]} or the given {@code order} is
     *                                  smaller than two.
     */
    protected FeatureSwapCrossover(double probability) {
        super(probability);
    }

    @Override
    protected void crossover(final Instance tree1, final Instance tree2) {
        final List<Instance> instances1 = collectInstances(tree1);
        final List<Instance> instances2 = collectInstances(tree2);

        final Map<AttributeDefinition, List<Instance>> categories1 = calculateCategories(instances1);
        final Map<AttributeDefinition, List<Instance>> categories2 = calculateCategories(instances2);

        while(true) {
            final AttributeDefinition definition = chooseAttributeRandomly(categories1.keySet(), categories2.keySet());

            // check if we have an instance in both trees
            if(!categories1.containsKey(definition) || !categories2.containsKey(definition)) {
                continue;
            }

            // select instances
            final Instance instance1 = chooseInstanceWithAttributeRandomly(instances1, definition);
            final Instance instance2 = chooseInstanceWithAttributeRandomly(instances2, definition);

            if(definition.getType() instanceof ArrayType && swapArrayMember()) {
                log.info("Swapping attribute elements in '{}' between '{}' and '{}'.", definition.getName(), instance1.getDefinition().getName(), instance2.getDefinition().getName());

                final Attribute attribute1 = instance1.findAttribute(definition.getName());
                final Attribute attribute2 = instance2.findAttribute(definition.getName());

                final Array array1 = findArray(attribute1.getValue());
                final Array array2 = findArray(attribute2.getValue());

                final int index1 = random.nextInt(0, array1.getValues().size());
                final int index2 = random.nextInt(0, array2.getValues().size());

                final Value temporary = array1.getValues().get(index1);
                array1.getValues().set(index1, EcoreUtil.copy(array2.getValues().get(index2)));
                array2.getValues().set(index2, temporary);
            } else {
                log.info("Swapping attribute '{}' between '{}' and '{}'.", definition.getName(), instance1.getDefinition().getName(), instance2.getDefinition().getName());

                final Attribute attribute1 = instance1.findAttribute(definition.getName());
                final Attribute attribute2 = instance2.findAttribute(definition.getName());

                final Expression temporary = attribute1.getValue();
                attribute1.setValue(attribute2.getValue());
                attribute2.setValue(temporary);
            }

            break;
        }
    }

    /**
     * @return <code>true</code> iff an element of an array should be swapped or the complete array.
     */
    private boolean swapArrayMember() {
        return random.nextInt(100) < 98;
    }

    private Instance chooseInstanceWithAttributeRandomly(final List<Instance> instances, final AttributeDefinition definition) {
        final List<Instance> possible = instances.stream()
                .filter(i -> i.getAttributes().stream().anyMatch(a -> definition.equals(a.getDefinition())))
                .collect(Collectors.toUnmodifiableList());

        int index = random.nextInt(possible.size());

        return possible.get(index);
    }

    private AttributeDefinition chooseAttributeRandomly(final Set<AttributeDefinition> definitions1, final Set<AttributeDefinition> definitions2) {
        final Set<AttributeDefinition> combined = new HashSet<>(definitions1);
        combined.retainAll(definitions2);

        final List<AttributeDefinition> combinedList = new ArrayList<>(combined);

        int index = random.nextInt(combined.size());

        return combinedList.get(index);
    }

    private Map<AttributeDefinition, List<Instance>> calculateCategories(final List<Instance> instances) {
        final Map<AttributeDefinition, List<Instance>> categories = new HashMap<>();
        instances.forEach(instance -> {
            instance.getDefinition().getAttributes().forEach(attribute -> {
                if (!categories.containsKey(attribute)) {
                    final List<Instance> sublist = new ArrayList<>();
                    sublist.add(instance);
                    categories.put(attribute, sublist);
                } else {
                    categories.get(attribute).add(instance);
                }
            });
        });

        return categories;
    }

    private List<Instance> collectInstances(final Instance tree) {
        final List<Instance> instances = new ArrayList<>();

        final TreeIterator<EObject> iterator = tree.eAllContents();
        while (iterator.hasNext()) {
            final EObject object = iterator.next();
            if (object instanceof Instance instance) {
                instances.add(instance);
            }
        }

        return instances;
    }

    private Array findArray(final Expression value) {
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

    public static FeatureSwapCrossover of(final double probability) {
        return new FeatureSwapCrossover(probability);
    }
}
