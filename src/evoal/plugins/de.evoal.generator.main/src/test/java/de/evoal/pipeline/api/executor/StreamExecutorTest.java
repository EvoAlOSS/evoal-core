package de.evoal.pipeline.api.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.DoublePredicate;
import java.util.stream.Stream;

import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.pipeline.api.model.PipelineComponent;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.pipeline.api.model.PipelineComposite;
import de.evoal.pipeline.api.model.PipelineFilterImpl;
import de.evoal.pipeline.api.model.PipelineSource;
import de.evoal.pipeline.impl.components.misc.Limit;
import lombok.NonNull;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Filters in the {@link StreamExecutor}: a filter drops rows, and a limit after it counts the
 *   rows that passed.
 */
public class StreamExecutorTest {
    private final Space space = new Space(new EClassProvider().eClassFor(
            LanguageHelper.<DataDescriptionModule>loadFromClasspath("de/evoal/pipeline/test/data.ddl")));

    private final EStructuralFeature x = space.find("x").orElseThrow();

    /**
     * An endless source of the rows x = 0, 1, 2, ...
     */
    private final class Counter extends PipelineComponentImpl implements PipelineSource {
        @Override
        public @NonNull Stream<@NonNull TypedEObject> toStream() {
            return Stream.iterate(0.0, value -> value + 1.0)
                         .map(value -> {
                             final TypedEObject row = space.newEObject();
                             row.eSet(x, value);
                             return row;
                         });
        }

        @Override
        public @NonNull TypedEObject apply(final @NonNull TypedEObject object) {
            return object;
        }
    }

    /**
     * Passes on the rows whose x satisfies a condition.
     */
    private final class Condition extends PipelineFilterImpl {
        private final DoublePredicate condition;

        private Condition(final int maximumConsecutiveRejections, final DoublePredicate condition) {
            super("condition", maximumConsecutiveRejections);
            this.condition = condition;
        }

        @Override
        protected Optional<String> violation(final @NonNull TypedEObject row) {
            final double value = (Double) row.eGet(x);

            return condition.test(value) ? Optional.empty() : Optional.of("has x = " + value);
        }
    }

    /**
     * Records the x of every row it sees.
     */
    private static final class Recorder extends PipelineComponentImpl {
        private final EStructuralFeature feature;

        private final List<Double> values = new ArrayList<>();

        private Recorder(final EStructuralFeature feature) {
            this.feature = feature;
        }

        @Override
        public @NonNull TypedEObject apply(final @NonNull TypedEObject object) {
            values.add((Double) object.eGet(feature));
            return object;
        }
    }

    private static PipelineComposite pipeline(final PipelineComponent... components) {
        return new PipelineComposite(List.of(components));
    }

    @Test
    public void theLimitCountsTheRowsThatPassedTheFilter() {
        final Recorder recorder = new Recorder(x);

        new StreamExecutor().execute(pipeline(new Counter(), new Condition(10, value -> value % 2.0 == 0.0), new Limit(4), recorder));

        Assertions.assertEquals(List.of(0.0, 2.0, 4.0, 6.0), recorder.values);
    }

    @Test
    public void aFilterThatDropsTooManyRowsInARowStopsTheRun() {
        final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                () -> new StreamExecutor().execute(pipeline(new Counter(), new Condition(3, value -> value >= 100.0), new Limit(4))));

        Assertions.assertTrue(e.getMessage().contains("'condition' dropped 3 rows in a row"), e.getMessage());
        Assertions.assertTrue(e.getMessage().contains("x = 2.0"), e.getMessage());
    }
}
