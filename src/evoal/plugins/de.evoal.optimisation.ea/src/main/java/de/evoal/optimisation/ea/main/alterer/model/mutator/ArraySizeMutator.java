package de.evoal.optimisation.ea.main.alterer.model.mutator;

import de.evoal.optimisation.ea.api.alterer.EvoAlMutator;
import de.evoal.optimisation.ea.api.operators.AltererComponent;
import de.evoal.optimisation.ea.api.codec.model.ModelChromosome;
import de.evoal.optimisation.ea.api.codec.model.ModelGene;
import de.evoal.languages.model.base.*;
import io.jenetics.Chromosome;
import io.jenetics.MutatorResult;
import io.jenetics.util.RandomRegistry;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.*;
import java.util.random.RandomGenerator;
import java.util.stream.StreamSupport;

@Slf4j
public class ArraySizeMutator<A extends Comparable<? super A>> extends EvoAlMutator implements AltererComponent {
    private final RandomGenerator generator = RandomRegistry.random();

    public ArraySizeMutator(double probability) {
        super(probability);
    }

    protected MutatorResult<Chromosome<ModelGene>> mutate(
            final Chromosome chromosome,
            final double p,
            final RandomGenerator random
    ) {
        final int P = EvoAlMutator.toInt(p);

        final ModelChromosome mc = (ModelChromosome) chromosome;
        final Instance copy = EcoreUtil.copy(mc.getModel());

        final TreeIterator<EObject> iterator = copy.eAllContents();
        final List<Attribute> attributes = StreamSupport.stream(
                        Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED),
                        false)
                .filter(Instance.class::isInstance)
                .map(Instance.class::cast)
                .flatMap(i -> i.getAttributes().stream().filter(a -> a.getDefinition().getType() instanceof ArrayType))
                .toList();

        int numberOfChanges = 0;

        final Set<Integer> indices = new HashSet<>();
        do {
            final int index = generator.nextInt(0, attributes.size());
            if(!indices.add(index) ) {
                break;
            }

            final Attribute attribute = attributes.get(index);
            final Array array = findArray(attribute.getValue());
            numberOfChanges += 1;

            if(array.getValues().size() == 1 || shouldAdd(random)) {
                final int elementIndex = generator.nextInt(0, array.getValues().size() + 1);

                log.info("Adding a new child to array at position {}", elementIndex);
                final Value newChild = mc.builder().random("", ((ArrayType)attribute.getDefinition().getType()).getElements());
                if(elementIndex == array.getValues().size()) {
                    array.getValues().add(newChild);
                } else {
                    array.getValues().add(elementIndex, newChild);
                }
            } else {
                final int elementIndex = generator.nextInt(0, array.getValues().size());

                log.info("Removing child {} from array", elementIndex);

                array.getValues().remove(elementIndex);
            }
        } while (random.nextInt() < P);

        log.info("Number of changes are {}.", numberOfChanges);
        return new MutatorResult<>(
                ModelChromosome.of(mc.builder(), copy),
                numberOfChanges
        );
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


    boolean shouldAdd(final RandomGenerator random) {
        return random.nextDouble() < 0.50;
    }
}
