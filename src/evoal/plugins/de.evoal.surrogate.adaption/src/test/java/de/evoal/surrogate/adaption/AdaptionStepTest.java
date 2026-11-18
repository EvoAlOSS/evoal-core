package de.evoal.surrogate.adaption;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.optimisation.api.fitness.Fitness;
import de.evoal.optimisation.api.fitness.FitnessComponent;
import de.evoal.optimisation.api.fitness.FitnessContext;
import de.evoal.optimisation.api.fitness.FitnessLayout;
import de.evoal.optimisation.api.fitness.Goal;
import de.evoal.optimisation.api.fitness.TargetDistance;

public class AdaptionStepTest {
    /**
     * An adaption of the objective {@code y} that adds 1 to its value.
     */
    private static final class AddingOne extends AdaptionStep {
        @Override
        protected double adapt(final TypedEObject candidate, final String objective, final double value) {
            return value + 1.0;
        }

        @Override
        public AddingOne init(final EObject configuration) {
            return this;
        }

        @Override
        protected Set<String> prepare() {
            return Set.of("y");
        }
    }

    private static EStructuralFeature feature(final String name) {
        final EAttribute feature = EcoreFactory.eINSTANCE.createEAttribute();
        feature.setName(name);

        return feature;
    }

    /**
     * The test adaption does not look at the candidate.
     */
    private static final FitnessContext CONTEXT = new FitnessContext(null, null, null);

    private static final EStructuralFeature Y = feature("y");

    private static final EStructuralFeature Z = feature("z");

    private static double adaptedFitnessOf(final Goal goal, final double canonical) {
        final FitnessLayout layout = new FitnessLayout(List.of(FitnessComponent.of(goal)));
        final Fitness fitness = new Fitness(layout, new double[] {canonical});

        return new AddingOne().apply(CONTEXT, fitness).value(0);
    }

    @Test
    public void aMinimisedObjectiveIsAdaptedAsObjectiveValue() {
        // the objective value 2 becomes 3, which is the fitness 3
        Assertions.assertEquals(3.0, adaptedFitnessOf(new Goal.Minimise(Y), 2.0));
    }

    @Test
    public void aMaximisedObjectiveIsAdaptedAsObjectiveValue() {
        // the fitness -2 is the objective value 2, which becomes 3, i.e. the fitness -3
        Assertions.assertEquals(-3.0, adaptedFitnessOf(new Goal.Maximise(Y), -2.0));
    }

    @Test
    public void componentsOfOtherObjectivesStayUnchanged() {
        // given
        final FitnessLayout layout = new FitnessLayout(List.of(FitnessComponent.of(new Goal.Minimise(Y)),
                                                               FitnessComponent.of(new Goal.Minimise(Z)),
                                                               FitnessComponent.named("helper")));
        final Fitness fitness = new Fitness(layout, new double[] {1.0, 1.0, 1.0});

        // when
        final Fitness adapted = new AddingOne().apply(CONTEXT, fitness);

        // then
        Assertions.assertArrayEquals(new double[] {2.0, 1.0, 1.0}, adapted.values());
        Assertions.assertSame(layout, adapted.layout());
    }

    @Test
    public void aTargetGoalOfAnAdaptedObjectiveIsRejected() {
        // given
        final TargetDistance absolute = (value, target) -> Math.abs(value - target);
        final Goal target = new Goal.Target(Y, 1.0, absolute);
        final FitnessLayout layout = new FitnessLayout(List.of(FitnessComponent.of(target)));
        final AddingOne step = new AddingOne();

        // when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> step.layout(layout));
    }

    @Test
    public void aTargetGoalOfAnotherObjectiveIsAccepted() {
        // given
        final TargetDistance absolute = (value, target) -> Math.abs(value - target);
        final Goal target = new Goal.Target(Z, 1.0, absolute);
        final FitnessLayout layout = new FitnessLayout(List.of(FitnessComponent.of(target)));
        final AddingOne step = new AddingOne();

        // when, then
        Assertions.assertSame(layout, step.layout(layout));
    }
}
