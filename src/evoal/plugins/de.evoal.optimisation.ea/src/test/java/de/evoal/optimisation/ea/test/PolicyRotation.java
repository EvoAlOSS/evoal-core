package de.evoal.optimisation.ea.test;

import java.util.List;
import java.util.Set;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.languages.AttributeEvaluator;

import de.evoal.optimisation.api.builder.AttributeSlots;
import de.evoal.optimisation.api.builder.AttributeSlots.Slot;
import de.evoal.optimisation.ea.api.genotype.ModelGenes;
import de.evoal.optimisation.ea.api.operators.AbstractModelMutation;

/**
 * A domain operator as a plugin would write it (DL type {@code 'policy-rotation'} of
 *   {@code rotation.dl}): all values of the named attributes of a 2048 policy, the directions,
 *   change by the same r in {1, 2, 3}, modulo 4, so the policy plays the same game rotated. It
 *   replaces the {@code policy-rotation} mutator of the 2048 plugin.
 */
@Dependent
@Named("de.evoal.optimisation.ea.test.rotation.policy-rotation")
public class PolicyRotation extends AbstractModelMutation {
    /**
     * The names of the rotated attributes.
     */
    private Set<String> attributes = Set.of();

    public PolicyRotation() {
    }

    /**
     * @param probability The probability that the mutation is applied to a child.
     * @param attributes The names of the rotated attributes.
     */
    public PolicyRotation(final double probability, final Set<String> attributes) {
        super(probability);
        this.attributes = Set.copyOf(attributes);
    }

    @Override
    protected void configureModel(final EObject configuration, final AttributeEvaluator evaluator) {
        final EStructuralFeature feature = configuration.eClass().getEStructuralFeature("attributes");
        attributes = ((List<?>) configuration.eGet(feature)).stream()
                                                             .map(Object::toString)
                                                             .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    protected void mutateModel(final ModelGenes models, final int model, final RandomGenerator random) {
        final int rotation = random.nextInt(1, 4);

        for(final Slot slot : AttributeSlots.of(models.root(model), models.context().types()::isOptional)) {
            if(attributes.contains(slot.attribute().getName())) {
                slot.set(((Integer) slot.get() + rotation) % 4);
            }
        }
    }

    @Override
    public String name() {
        return "policy-rotation";
    }
}
