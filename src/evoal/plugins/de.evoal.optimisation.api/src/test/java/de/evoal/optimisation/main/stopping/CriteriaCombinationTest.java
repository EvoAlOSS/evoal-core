package de.evoal.optimisation.main.stopping;

import java.lang.reflect.Field;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;
import de.evoal.models.v202704.optimisation.execution.impl.TerminationCriterionImpl;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.MemoryFactory;

public class CriteriaCombinationTest {
    private final Iteration iteration = MemoryFactory.eINSTANCE.createIteration();

    /**
     * A criterion with a fixed result that counts how often it was checked.
     */
    private static final class Fixed extends TerminationCriterionImpl {
        private final boolean result;

        private int checks;

        Fixed(final boolean result) {
            this.result = result;
        }

        @Override
        public boolean shouldTerminate(final Iteration iteration) {
            checks += 1;
            return result;
        }
    }

    @Test
    public void anyOfIsSatisfiedByOneCriterion() {
        Assertions.assertTrue(new AnyOfCriterion(List.of(new Fixed(false), new Fixed(true))).shouldTerminate(iteration));
        Assertions.assertFalse(new AnyOfCriterion(List.of(new Fixed(false), new Fixed(false))).shouldTerminate(iteration));
    }

    @Test
    public void allOfNeedsAllCriteria() {
        Assertions.assertTrue(new AllOfCriterion(List.of(new Fixed(true), new Fixed(true))).shouldTerminate(iteration));
        Assertions.assertFalse(new AllOfCriterion(List.of(new Fixed(true), new Fixed(false))).shouldTerminate(iteration));
    }

    @Test
    public void everyCriterionIsCheckedAlthoughTheResultIsDecided() {
        // given
        final Fixed afterTrue = new Fixed(false);
        final Fixed afterFalse = new Fixed(true);
        final AnyOfCriterion anyOf = new AnyOfCriterion(List.of(new Fixed(true), afterTrue));
        final AllOfCriterion allOf = new AllOfCriterion(List.of(new Fixed(false), afterFalse));

        // when
        anyOf.shouldTerminate(iteration);
        allOf.shouldTerminate(iteration);

        // then
        Assertions.assertEquals(1, afterTrue.checks);
        Assertions.assertEquals(1, afterFalse.checks);
    }

    @Test
    public void combinationsCanBeNested() {
        // given: any-of(all-of(true, false), all-of(true, true))
        final TerminationCriterion nested = new AnyOfCriterion(List.of(
                new AllOfCriterion(List.of(new Fixed(true), new Fixed(false))),
                new AllOfCriterion(List.of(new Fixed(true), new Fixed(true)))));

        // when / then
        Assertions.assertTrue(nested.shouldTerminate(iteration));
    }

    @Test
    public void aCombinationWithoutCriteriaIsRejected() throws Exception {
        // given
        final EObject configuration = Mockito.mock(EObject.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(configuration.eClass().getName()).thenReturn("all-of");
        final AttributeHelper helper = Mockito.mock(AttributeHelper.class);
        Mockito.when(helper.lookup(configuration, "criteria")).thenReturn(List.of());

        final AllOfCriterion criterion = new AllOfCriterion();
        final Field field = CriteriaCombination.class.getDeclaredField("helper");
        field.setAccessible(true);
        field.set(criterion, helper);

        // when / then
        Assertions.assertThrows(InitializationException.class, () -> criterion.init(configuration));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new AnyOfCriterion(List.of()));
    }
}
