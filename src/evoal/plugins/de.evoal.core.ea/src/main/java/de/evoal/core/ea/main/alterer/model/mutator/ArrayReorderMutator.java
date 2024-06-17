package de.evoal.core.ea.main.alterer.model.mutator;

import de.evoal.core.ea.api.alterer.EvoAlMutator;
import de.evoal.core.ea.api.operators.AltererComponent;
import de.evoal.core.ea.api.codec.model.ModelChromosome;
import de.evoal.core.ea.api.codec.model.ModelGene;
import de.evoal.languages.model.base.*;
import io.jenetics.Chromosome;
import io.jenetics.MutatorResult;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.*;
import java.util.random.RandomGenerator;
import java.util.stream.StreamSupport;

@Slf4j
public class ArrayReorderMutator<A extends Comparable<? super A>> extends EvoAlMutator implements AltererComponent {
    public ArrayReorderMutator(double probability) {
        super(probability);
    }

    protected MutatorResult<Chromosome<ModelGene>> mutate(
            final Chromosome chromosome,
            final double p,
            final RandomGenerator random
    ) {
        final int P = toInt(p);

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
            final int index = random.nextInt(0, attributes.size());
            if(!indices.add(index) ) {
                break;
            }

            final Array array = findArray(attributes.get(index).getValue());
            numberOfChanges += 1;

            if(array.getValues().size() == 1) {
                continue;
            } else {
                int index1 = random.nextInt(0, array.getValues().size());
                int index2 = random.nextInt(0, array.getValues().size());

                log.info("Swapping children {} and {}.", index1, index2);
                final Value value1 = EcoreUtil.copy(array.getValues().get(index1));
                final Value value2 = EcoreUtil.copy(array.getValues().get(index2));

                array.getValues().set(index1, value2);
                array.getValues().set(index2, value1);
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
}
