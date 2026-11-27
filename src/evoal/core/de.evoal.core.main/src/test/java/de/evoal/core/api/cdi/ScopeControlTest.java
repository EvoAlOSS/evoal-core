package de.evoal.core.api.cdi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import jakarta.enterprise.context.ContextNotActiveException;
import jakarta.enterprise.context.spi.Contextual;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import de.evoal.core.main.cdi.ScopedValueContext;

public class ScopeControlTest {
    private TestScopes scopes;

    private ScopeControl control;

    private final Contextual<Object> runBean = TestScopes.bean(Object::new);

    private final Contextual<Object> evaluationBean = TestScopes.bean(Object::new);

    @BeforeEach
    public void createScopes() throws ReflectiveOperationException {
        scopes = new TestScopes();
        control = scopes.control();
    }

    private Object runBean() {
        return TestScopes.get(scopes.runContext(), runBean);
    }

    private Object evaluationBean() {
        return TestScopes.get(scopes.evaluationContext(), evaluationBean);
    }

    @Test
    public void scopedBeansNeedAnOpenScope() {
        Assertions.assertFalse(control.isEvaluationActive());
        Assertions.assertFalse(control.isRunActive());
        Assertions.assertThrows(ContextNotActiveException.class, this::runBean);
        Assertions.assertThrows(ContextNotActiveException.class, this::evaluationBean);
        Assertions.assertThrows(IllegalStateException.class, control::runNumber);
    }

    @Test
    public void aRunNeedsAnEvaluation() {
        // given
        final boolean[] ran = { false };

        // when
        final IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class,
                                                                        () -> control.inRun(3, () -> ran[0] = true));

        // then
        Assertions.assertFalse(ran[0]);
        Assertions.assertTrue(exception.getMessage().contains("evaluation"), exception.getMessage());
    }

    @Test
    public void aRunScopedBeanLivesUntilTheEndOfTheRun() {
        // given
        final List<Object> instances = new ArrayList<>();

        // when
        control.inEvaluation(() -> control.inRun(0, () -> {
            instances.add(runBean());
            instances.add(runBean());
            Mockito.verify(runBean, Mockito.never()).destroy(ArgumentMatchers.any(), ArgumentMatchers.any());
        }));

        // then
        Assertions.assertSame(instances.get(0), instances.get(1));
        Mockito.verify(runBean).destroy(ArgumentMatchers.same(instances.get(0)), ArgumentMatchers.any());
        Assertions.assertFalse(control.isRunActive());
    }

    @Test
    public void everyRunGetsANewInstanceAndTheEvaluationKeepsItsInstance() {
        // given
        final List<Object> runInstances = new ArrayList<>();
        final List<Object> evaluationInstances = new ArrayList<>();

        // when
        control.inEvaluation(() -> {
            for(int run = 0; run < 2; ++run) {
                control.inRun(run, () -> {
                    runInstances.add(runBean());
                    evaluationInstances.add(evaluationBean());
                });
            }
            Mockito.verify(evaluationBean, Mockito.never()).destroy(ArgumentMatchers.any(), ArgumentMatchers.any());
        });

        // then
        Assertions.assertNotSame(runInstances.get(0), runInstances.get(1));
        Mockito.verify(runBean, Mockito.times(2)).destroy(ArgumentMatchers.any(), ArgumentMatchers.any());

        Assertions.assertSame(evaluationInstances.get(0), evaluationInstances.get(1));
        Mockito.verify(evaluationBean).destroy(ArgumentMatchers.same(evaluationInstances.get(0)), ArgumentMatchers.any());
        Assertions.assertFalse(control.isEvaluationActive());
    }

    @Test
    public void theRunNumberIsTheNumberOfTheOpenRun() {
        // given
        final long[] numbers = new long[2];

        // when
        control.inEvaluation(() -> {
            control.inRun(7, () -> numbers[0] = control.runNumber());
            control.inRun(8, () -> numbers[1] = control.runNumber());
        });

        // then
        Assertions.assertArrayEquals(new long[] { 7, 8 }, numbers);
    }

    @Test
    public void allThreadsOfARunSeeTheSameInstance() throws Exception {
        // given
        final ExecutorService threads = Executors.newFixedThreadPool(2);
        final List<Object> instances = new ArrayList<>();

        try {
            // when
            control.inEvaluation(() -> control.inRun(0, () -> {
                instances.add(runBean());

                final ScopeControl.Bindings bindings = control.capture();
                instances.add(threads.submit(() -> bindings.call(this::runBean)).get());
                instances.add(threads.submit(() -> bindings.call(this::runBean)).get());
            }));
        } finally {
            threads.shutdownNow();
        }

        // then
        Assertions.assertEquals(3, instances.size());
        Assertions.assertSame(instances.get(0), instances.get(1));
        Assertions.assertSame(instances.get(0), instances.get(2));
    }

    @Test
    public void otherThreadsSeeNoScopeWithoutTheBindings() throws Exception {
        // given
        final ExecutorService threads = Executors.newSingleThreadExecutor();
        final boolean[] active = { true };

        try {
            // when
            control.inEvaluation(() -> control.inRun(0, () -> active[0] = threads.submit(control::isRunActive).get()));
        } finally {
            threads.shutdownNow();
        }

        // then
        Assertions.assertFalse(active[0]);
    }

    @Test
    public void aNestedRunHasItsOwnInstances() {
        // given
        final List<Object> instances = new ArrayList<>();
        final long[] numbers = new long[3];

        // when
        control.inEvaluation(() -> control.inRun(1, () -> {
            instances.add(runBean());
            numbers[0] = control.runNumber();

            control.inRun(2, () -> {
                instances.add(runBean());
                numbers[1] = control.runNumber();
            });

            instances.add(runBean());
            numbers[2] = control.runNumber();
        }));

        // then
        Assertions.assertNotSame(instances.get(0), instances.get(1));
        Assertions.assertSame(instances.get(0), instances.get(2));
        Assertions.assertArrayEquals(new long[] { 1, 2, 1 }, numbers);
    }

    @Test
    public void theBeansAreDestroyedWhenTheBodyFails() {
        // given
        final Object[] instance = new Object[1];
        final IllegalArgumentException failure = new IllegalArgumentException("failed");

        // when
        final IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> control.inEvaluation(() -> control.inRun(0, () -> {
            instance[0] = runBean();
            throw failure;
        })));

        // then
        Assertions.assertSame(failure, thrown);
        Mockito.verify(runBean).destroy(ArgumentMatchers.same(instance[0]), ArgumentMatchers.any());
        Assertions.assertFalse(control.isRunActive());
        Assertions.assertFalse(control.isEvaluationActive());
    }

    @Test
    public void bindingsWithoutOpenScopesCallTheOperation() {
        // given
        final ScopeControl.Bindings bindings = control.capture();

        // when
        final boolean active = bindings.call(control::isRunActive);

        // then
        Assertions.assertFalse(active);
    }

    @Test
    public void aContextWithoutABoundInstanceIsInactive() {
        final ScopedValueContext context = scopes.runContext();

        Assertions.assertFalse(context.isActive());
        Assertions.assertTrue(context.current().isEmpty());
    }
}
