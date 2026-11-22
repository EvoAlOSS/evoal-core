package de.evoal.pipeline.impl.components.misc;

import java.util.Arrays;
import java.util.Optional;

import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.constraints.ConstraintCheckerComponent;
import de.evoal.core.api.validation.constraints.ConstraintCheckers;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import lombok.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * The filters 'constraint-validation' ({@link ConstraintValidation}) and 'condition-filter'
 *   ({@link ConditionFilter}) on the data of {@code constrained.ddl}: 'a' has
 *   {@code @UpperBoundary { boundary := 1.0; }}, and the DDL declares
 *   {@code constraint(data 'a' + data 'b' < 1.5, "sum")}.
 */
public class FiltersTest {
    /**
     * Checks {@code @UpperBoundary { boundary := 1.0; }} like its checker in core, which needs
     *   CDI.
     */
    private static final ConstraintCheckers CHECKERS = new ConstraintCheckers() {
        @Override
        public Optional<ConstraintCheckerComponent> create(final @NonNull Instance annotation) {
            if(!"UpperBoundary".equals(annotation.getDefinition().getName())) {
                return Optional.empty();
            }

            return Optional.of(value -> ((Number) value).doubleValue() > 1.0
                                        ? ConstraintCheck.violated("is " + value + ", but must be <= 1.0")
                                        : ConstraintCheck.satisfied());
        }
    };

    private static Space pipelineOf(final GeneratorModule module) {
        return new Space(new EClassProvider().eClassFor(module));
    }

    private static Space reads(final Space pipeline, final String... names) {
        return pipeline.subSpace(Arrays.stream(names)
                                       .map(name -> pipeline.find(name).orElseThrow()));
    }

    private static TypedEObject row(final Space pipeline, final Object... namesAndValues) {
        final TypedEObject row = pipeline.newEObject();
        for(int i = 0; i < namesAndValues.length; i += 2) {
            row.eSet(pipeline.find((String) namesAndValues[i]).orElseThrow(), namesAndValues[i + 1]);
        }

        return row;
    }

    @Nested
    public class Validation {
        private final Space pipeline = dataOf("constrained.ddl");

        private static Space dataOf(final String file) {
            final DataDescriptionModule module = LanguageHelper.loadFromClasspath("de/evoal/pipeline/test/" + file);

            return new Space(new EClassProvider().eClassFor(module));
        }

        private ConstraintValidation validation(final int maximum, final String... reads) throws InitializationException {
            return validation(pipeline, maximum, reads);
        }

        private ConstraintValidation validation(final Space data, final int maximum, final String... reads) throws InitializationException {
            return new ConstraintValidation(maximum, CHECKERS, data, reads(data, reads));
        }

        @Test
        public void aRowPassesIfItSatisfiesTheAnnotationsAndTheConstraints() throws InitializationException {
            final ConstraintValidation validation = validation(10, "a", "b");

            Assertions.assertTrue(validation.test(row(pipeline, "a", 0.5, "b", 0.5)));
        }

        @Test
        public void aRowThatViolatesAnAnnotationIsDropped() throws InitializationException {
            final ConstraintValidation validation = validation(10, "a", "b");

            Assertions.assertFalse(validation.test(row(pipeline, "a", 1.2, "b", 0.0)));
        }

        @Test
        public void aRowThatViolatesAConstraintIsDropped() throws InitializationException {
            final ConstraintValidation validation = validation(10, "a", "b");

            Assertions.assertFalse(validation.test(row(pipeline, "a", 0.9, "b", 0.7)));
        }

        @Test
        public void aStrictConstraintDropsTheBoundary() throws InitializationException {
            final ConstraintValidation validation = validation(10, "a", "b");

            Assertions.assertFalse(validation.test(row(pipeline, "a", 0.75, "b", 0.75)));
        }

        @Test
        public void aConstraintOnUnreadDataStopsAtStartUp() {
            final InitializationException e = Assertions.assertThrows(InitializationException.class, () -> validation(10, "a"));

            Assertions.assertTrue(e.getMessage().contains("'b'"), e.getMessage());
        }

        @Test
        public void anEqualityStopsAtStartUp() {
            final InitializationException e = Assertions.assertThrows(InitializationException.class, () -> validation(dataOf("equality.ddl"), 10, "p", "q"));

            Assertions.assertTrue(e.getMessage().contains("equality"), e.getMessage());
        }

        @Test
        public void aConstraintThatIsNoAnnotationStopsAtStartUp() {
            final InitializationException e = Assertions.assertThrows(InitializationException.class, () -> validation(dataOf("unsupported.ddl"), 10, "u"));

            Assertions.assertTrue(e.getMessage().contains("'u'"), e.getMessage());
            Assertions.assertTrue(e.getMessage().contains("not supported"), e.getMessage());
        }

        @Test
        public void tooManyRejectionsInARowStopTheRun() throws InitializationException {
            final ConstraintValidation validation = validation(2, "a", "b");

            Assertions.assertFalse(validation.test(row(pipeline, "a", 1.2, "b", 0.0)));
            Assertions.assertTrue(validation.test(row(pipeline, "a", 0.5, "b", 0.0)));
            Assertions.assertFalse(validation.test(row(pipeline, "a", 1.2, "b", 0.0)));

            final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                                                                    () -> validation.test(row(pipeline, "a", 1.3, "b", 0.0)));
            Assertions.assertTrue(e.getMessage().contains("2 rows in a row"), e.getMessage());
            Assertions.assertTrue(e.getMessage().contains("@UpperBoundary"), e.getMessage());
        }
    }

    @Nested
    public class Condition {
        private final GeneratorModule module = LanguageHelper.loadFromClasspath("de/evoal/pipeline/test/filters.generator");

        private final Space pipeline = pipelineOf(module);

        /**
         * The condition of the step of 'gap': data 'a' < 0.25 OR data 'a' > 0.75.
         */
        private final Expression condition = ((ConcreteStep) module.getPipelines()
                                                                   .getFirst()
                                                                   .getSteps()
                                                                   .getFirst()).getInstance()
                                                                               .findAttribute("condition")
                                                                               .getValue();

        @Test
        public void theRowsThatSatisfyTheConditionPass() throws InitializationException {
            final ConditionFilter filter = new ConditionFilter(10, condition, pipeline, reads(pipeline, "a"));

            Assertions.assertTrue(filter.test(row(pipeline, "a", 0.1)));
            Assertions.assertFalse(filter.test(row(pipeline, "a", 0.5)));
            Assertions.assertTrue(filter.test(row(pipeline, "a", 0.9)));
        }

        @Test
        public void aConditionOnUnreadDataStopsAtStartUp() {
            final InitializationException e = Assertions.assertThrows(InitializationException.class,
                                                                      () -> new ConditionFilter(10, condition, pipeline, reads(pipeline, "b")));

            Assertions.assertTrue(e.getMessage().contains("'a'"), e.getMessage());
        }
    }
}
