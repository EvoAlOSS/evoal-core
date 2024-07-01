package de.evoal.optimisation.ea.main.alterer.model.mutator;

import de.evoal.optimisation.ea.api.alterer.EvoAlMutator;
import de.evoal.optimisation.ea.api.operators.AltererComponent;
import de.evoal.optimisation.ea.api.codec.model.ModelChromosome;
import de.evoal.optimisation.ea.api.codec.model.ModelGene;
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
public class LiteralMutator<A extends Comparable<? super A>> extends EvoAlMutator implements AltererComponent {
    public LiteralMutator(double probability) {
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
                .flatMap(i -> i.getAttributes().stream().filter(a -> a.getDefinition().getType() instanceof LiteralType))
                .toList();

        int numberOfChanges = 0;

        final Set<Integer> indices = new HashSet<>();
        do {
            final int index = random.nextInt(0, attributes.size());
            if(!indices.add(index) ) {
                break;
            }

            final Attribute attribute = attributes.get(index);
            final Literal literal = findLiteral(attribute.getValue());

            numberOfChanges += 1;
            if(literal instanceof IntegerLiteral iLiteral) {
                int value = random.nextInt(0, 4);
                log.info("Replacing {} by {}.", iLiteral.getLiteral(), value);
                iLiteral.setLiteral(value);
            } else if(literal instanceof BooleanLiteral bLiteral) {
                boolean value = random.nextBoolean();
                log.info("Replacing {} by {}.", bLiteral.isValue(), value);
                bLiteral.setValue(value);
            } else {
                throw new IllegalStateException("");
            }
        } while (random.nextInt() < P);

        log.info("Number of changes are {}.", numberOfChanges);
        return new MutatorResult<>(
                ModelChromosome.of(mc.builder(), copy),
                numberOfChanges
        );
    }

    private Literal findLiteral(final Expression value) {
        return (Literal) ((OrExpression)value)
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
