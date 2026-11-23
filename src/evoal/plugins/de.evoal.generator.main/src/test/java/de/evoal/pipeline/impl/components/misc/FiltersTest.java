package de.evoal.pipeline.impl.components.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.random.RandomGenerator;
import java.util.stream.Stream;

import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.api.validation.constraints.ConfiguredChecker;
import de.evoal.core.api.validation.constraints.ConstraintCheck;
import de.evoal.core.api.validation.constraints.ConstraintCheckers;
import de.evoal.core.api.validation.constraints.Severity;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.ValueDefinitionReference;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.pipeline.impl.components.misc.ConstraintValidation.RowReaction;
import lombok.NonNull;
import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * The filters 'constraint-validation' ({@link ConstraintValidation}), 'condition-filter'
 *   ({@link ConditionFilter}) and 'rejection-sampling' ({@link RejectionSampling}) on the data of {@code constrained.ddl}: 'a' has
 *   {@code @UpperBoundary { boundary := 1.0; }}, 'd' has
 *   {@code @LowerBoundary { boundary := 0.0; severity := Severity.warning; }}, and the DDL
 *   declares {@code constraint(data 'a' + data 'b' < 1.5, "sum")}.
 */
public class FiltersTest {
    /**
     * Checks {@code @UpperBoundary { boundary := 1.0; }} and
     *   {@code @LowerBoundary { boundary := 0.0; }} like their checkers in core, which need
     *   CDI; the severity is read from the parsed annotation.
     */
    private static final ConstraintCheckers CHECKERS = new ConstraintCheckers() {
        @Override
        public Optional<ConfiguredChecker> create(final @NonNull Instance annotation) {
            return switch(annotation.getDefinition().getName()) {
                case "UpperBoundary" -> Optional.of(new ConfiguredChecker(
                        value -> ((Number) value).doubleValue() > 1.0
                                 ? ConstraintCheck.violated("is " + value + ", but must be <= 1.0")
                                 : ConstraintCheck.satisfied(),
                        severityOf(annotation)));
                case "LowerBoundary" -> Optional.of(new ConfiguredChecker(
                        value -> ((Number) value).doubleValue() < 0.0
                                 ? ConstraintCheck.violated("is " + value + ", but must be >= 0.0")
                                 : ConstraintCheck.satisfied(),
                        severityOf(annotation)));
                default -> Optional.empty();
            };
        }

        /**
         * @return The severity the annotation states with a resolved literal, otherwise error.
         */
        private static Severity severityOf(final Instance annotation) {
            return annotation.getAttributes()
                             .stream()
                             .filter(attribute -> "severity".equals(attribute.getDefinition().getName()))
                             .flatMap(attribute -> stream(attribute.getValue()))
                             .filter(ValueDefinitionReference.class::isInstance)
                             .map(reference -> ((ValueDefinitionReference) reference).getDefinition())
                             .filter(definition -> definition != null && !definition.eIsProxy())
                             .map(definition -> Severity.of(definition.getName()))
                             .findFirst()
                             .orElse(Severity.ERROR);
        }

        private static Stream<EObject> stream(final Expression expression) {
            final List<EObject> contents = new ArrayList<>();
            contents.add(expression);
            expression.eAllContents().forEachRemaining(contents::add);
            return contents.stream();
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
            return validation(data, maximum, RowReaction.DROP, RowReaction.KEEP, reads);
        }

        private ConstraintValidation validation(final Space data, final int maximum, final RowReaction errors, final RowReaction warnings,
                                                final String... reads) throws InitializationException {
            return new ConstraintValidation(maximum, errors, warnings, CHECKERS, data, reads(data, reads));
        }

        @Test
        public void aRowThatViolatesAWarningIsKeptAndCounted() throws InitializationException {
            final ConstraintValidation validation = validation(10, "a", "b", "d");

            Assertions.assertTrue(validation.test(row(pipeline, "a", 0.5, "b", 0.5, "d", -1.0)));
            Assertions.assertTrue(validation.test(row(pipeline, "a", 0.5, "b", 0.5, "d", -2.0)));
            Assertions.assertTrue(validation.test(row(pipeline, "a", 0.5, "b", 0.5, "d", 1.0)));
            Assertions.assertEquals(2, validation.keptViolations("'d' (@LowerBoundary)"));
        }

        @Test
        public void aRowThatAlsoViolatesAnErrorIsDroppedAndNotCountedAsKept() throws InitializationException {
            final ConstraintValidation validation = validation(10, "a", "b", "d");

            Assertions.assertFalse(validation.test(row(pipeline, "a", 1.2, "b", 0.0, "d", -1.0)));
            Assertions.assertEquals(0, validation.keptViolations("'d' (@LowerBoundary)"));
        }

        @Test
        public void warningsMayDropRows() throws InitializationException {
            final ConstraintValidation validation = validation(pipeline, 10, RowReaction.DROP, RowReaction.DROP, "a", "b", "d");

            Assertions.assertFalse(validation.test(row(pipeline, "a", 0.5, "b", 0.5, "d", -1.0)));
        }

        @Test
        public void errorsMayBeKept() throws InitializationException {
            final ConstraintValidation validation = validation(pipeline, 10, RowReaction.KEEP, RowReaction.KEEP, "a", "b");

            Assertions.assertTrue(validation.test(row(pipeline, "a", 1.2, "b", 0.0)));
            Assertions.assertTrue(validation.test(row(pipeline, "a", 0.9, "b", 0.7)));
            Assertions.assertEquals(1, validation.keptViolations("'a' (@UpperBoundary)"));
            Assertions.assertEquals(1, validation.keptViolations("'data 'a' + data 'b' < 1.5'"));
        }

        @Test
        public void stopEndsTheRunWithTheRowAndTheConstraint() throws InitializationException {
            final ConstraintValidation validation = validation(pipeline, 10, RowReaction.STOP, RowReaction.KEEP, "a", "b");

            final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                                                                    () -> validation.test(row(pipeline, "a", 1.2, "b", 0.0)));
            Assertions.assertTrue(e.getMessage().contains("'a' = 1.2"), e.getMessage());
            Assertions.assertTrue(e.getMessage().contains("@UpperBoundary"), e.getMessage());
        }

        @Test
        public void stopTakesPrecedenceOverDrop() throws InitializationException {
            final ConstraintValidation validation = validation(pipeline, 10, RowReaction.DROP, RowReaction.STOP, "a", "b", "d");

            final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                                                                    () -> validation.test(row(pipeline, "a", 1.2, "b", 0.0, "d", -1.0)));
            Assertions.assertTrue(e.getMessage().contains("@LowerBoundary"), e.getMessage());
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

    @Nested
    public class Rejection {
        private final GeneratorModule module = LanguageHelper.loadFromClasspath("de/evoal/pipeline/test/filters.generator");

        private final Space pipeline = pipelineOf(module);

        /**
         * The acceptance probability of the pipeline 'more-where-a-is-large': data 'a'.
         */
        private final Expression probability = ((ConcreteStep) module.getPipelines()
                                                                     .get(2)
                                                                     .getSteps()
                                                                     .getFirst()).getInstance()
                                                                                 .findAttribute("acceptance-probability")
                                                                                 .getValue();

        /**
         * Returns the given numbers as nextDouble(), in order.
         */
        private static RandomGenerator numbers(final double... values) {
            final Iterator<Double> iterator = Arrays.stream(values).iterator();

            return new RandomGenerator() {
                @Override
                public long nextLong() {
                    throw new UnsupportedOperationException();
                }

                @Override
                public double nextDouble() {
                    return iterator.next();
                }
            };
        }

        private RejectionSampling sampling(final int maximum, final double... numbers) throws InitializationException {
            return new RejectionSampling(maximum, probability, pipeline, reads(pipeline, "a"), numbers(numbers));
        }

        @Test
        public void aRowIsKeptIfTheRandomNumberIsBelowTheProbability() throws InitializationException {
            final RejectionSampling sampling = sampling(10, 0.3, 0.3, 0.0, 0.99);

            Assertions.assertTrue(sampling.test(row(pipeline, "a", 0.5)));
            Assertions.assertFalse(sampling.test(row(pipeline, "a", 0.3)));
            Assertions.assertFalse(sampling.test(row(pipeline, "a", 0.0)));
            Assertions.assertTrue(sampling.test(row(pipeline, "a", 1.0)));
        }

        @Test
        public void tooManyRejectionsInARowStopTheRun() throws InitializationException {
            final RejectionSampling sampling = sampling(2, 0.5, 0.5);

            Assertions.assertFalse(sampling.test(row(pipeline, "a", 0.0)));

            final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                                                                    () -> sampling.test(row(pipeline, "a", 0.0)));
            Assertions.assertTrue(e.getMessage().contains("acceptance probability 0.0"), e.getMessage());
        }

        @Test
        public void aProbabilityOutsideTheUnitIntervalStopsTheRun() throws InitializationException {
            final RejectionSampling sampling = sampling(10, 0.5, 0.5);

            final IllegalStateException above = Assertions.assertThrows(IllegalStateException.class,
                                                                        () -> sampling.test(row(pipeline, "a", 1.5)));
            Assertions.assertTrue(above.getMessage().contains("1.5"), above.getMessage());
            Assertions.assertThrows(IllegalStateException.class, () -> sampling.test(row(pipeline, "a", -0.1)));
            Assertions.assertThrows(IllegalStateException.class, () -> sampling.test(row(pipeline, "a", Double.NaN)));
        }

        @Test
        public void aProbabilityOnUnreadDataStopsAtStartUp() {
            final InitializationException e = Assertions.assertThrows(InitializationException.class,
                    () -> new RejectionSampling(10, probability, pipeline, reads(pipeline, "b"), numbers()));

            Assertions.assertTrue(e.getMessage().contains("'a'"), e.getMessage());
        }
    }
}
