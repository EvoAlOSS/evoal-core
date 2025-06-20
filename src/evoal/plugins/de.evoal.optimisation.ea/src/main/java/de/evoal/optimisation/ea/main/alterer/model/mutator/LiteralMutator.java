package de.evoal.optimisation.ea.main.alterer.model.mutator;

import de.evoal.languages.model.base.definitions.EnumDefinition;
import de.evoal.languages.model.base.types.LiteralType;
import de.evoal.optimisation.ea.api.alterer.EvoAlMutator;
import de.evoal.optimisation.ea.api.operators.AltererComponent;
import de.evoal.optimisation.ea.api.codec.model.ModelChromosome;
import de.evoal.optimisation.ea.api.codec.model.ModelGene;
import de.evoal.languages.model.base.expressions.*;
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
                .flatMap(i -> i.getAttributes()
                               .stream()
                               .filter(a -> a.getDefinition().getType() instanceof LiteralType ||
                                            a.getDefinition().getType() instanceof de.evoal.languages.model.base.types.DefinitionReference &&
                                                    ((de.evoal.languages.model.base.types.DefinitionReference)a.getDefinition().getType()).getDefinition() instanceof EnumDefinition))
                .toList();

        int numberOfChanges = 0;

        final Set<Integer> indices = new HashSet<>();
        if (!attributes.isEmpty()) {
            do {
                final int index = random.nextInt(0, attributes.size());
                if (!indices.add(index)) {
                    break;
                }

                final Attribute attribute = attributes.get(index);
                if(attribute.getDefinition().getType() instanceof LiteralType) {
                    final Literal literal = findLiteral(attribute.getValue());

                    numberOfChanges += 1;
                    if (literal instanceof IntegerLiteral iLiteral) {
                        int value = random.nextInt(0, 4);
                        log.info("Replacing {} by {}.", iLiteral.getLiteral(), value);
                        iLiteral.setLiteral(value);
                    } else if (literal instanceof BooleanLiteral bLiteral) {
                        boolean value = random.nextBoolean();
                        log.info("Replacing {} by {}.", bLiteral.isLiteral(), value);
                        bLiteral.setLiteral(value);
                    } else {
                        throw new IllegalStateException("");
                    }
                } else if(attribute.getDefinition().getType() instanceof de.evoal.languages.model.base.types.DefinitionReference definition) {
                    int lIndex = random.nextInt(0, ((EnumDefinition)definition.getDefinition()).getLiterals().size());
                    final LiteralDefinitionReference reference = findDefinitionReference(attribute.getValue());

                    reference.setDefinition(((EnumDefinition)definition.getDefinition()).getLiterals().get(lIndex));
                    numberOfChanges += 1;
                } else {
                    throw new IllegalStateException("");
                }
            } while (random.nextInt() < P);
        }

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

    private LiteralDefinitionReference findDefinitionReference(final Expression value) {
        return (LiteralDefinitionReference) ((OrExpression)value)
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
