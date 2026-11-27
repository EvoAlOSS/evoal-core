package de.evoal.optimisation.api.steps;

import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import de.evoal.models.core.exceptions.InitializationException;

import de.evoal.optimisation.api.cdi.TerminationCriterionProducer;
import de.evoal.optimisation.api.checks.CandidateCheck;
import de.evoal.optimisation.api.checks.CandidateCheckProducer;
import de.evoal.optimisation.api.checks.CheckPoint;
import de.evoal.optimisation.api.checks.CheckReaction;
import de.evoal.optimisation.api.checks.ConfiguredCheck;
import de.evoal.optimisation.api.evaluation.ConfiguredEvaluationStrategy;
import de.evoal.optimisation.api.evaluation.EvaluationStrategy;
import de.evoal.optimisation.api.evaluation.SampleAggregation;
import de.evoal.optimisation.api.fitness.Evaluator;
import de.evoal.optimisation.main.evaluation.ReEvaluation;
import de.evoal.optimisation.main.evaluation.Resampling;

public class TemplateAlgorithmTest {
    /**
     * An algorithm that supports the reactions warn and resample only.
     */
    private static final class SamplingAlgorithm extends TemplateAlgorithm {
        private boolean configured;

        @Override
        protected Set<CheckPoint> checkPoints() {
            return Set.of(CheckPoint.NEW_CANDIDATES);
        }

        @Override
        protected void configure(final EObject configuration) {
            configured = true;
        }

        @Override
        protected Set<CheckReaction> reactions() {
            return EnumSet.of(CheckReaction.WARN, CheckReaction.RESAMPLE);
        }

        @Override
        protected Template template() {
            return new Template(List.of(), List.of());
        }
    }

    private static SamplingAlgorithm algorithmWith(final CandidateCheck check) throws Exception {
        final ConfiguredCheck configured = new ConfiguredCheck(check, () -> null);
        final CandidateCheckProducer checks = Mockito.mock(CandidateCheckProducer.class);
        Mockito.when(checks.create(Mockito.any(), Mockito.any(), Mockito.anyBoolean())).thenReturn(List.of(configured));

        final SamplingAlgorithm algorithm = new SamplingAlgorithm();
        inject(algorithm, "checkProducer", checks);
        inject(algorithm, "producer", Mockito.mock(TerminationCriterionProducer.class));

        return algorithm;
    }

    private static CandidateCheck check(final CheckReaction reaction) {
        final CandidateCheck check = Mockito.mock(CandidateCheck.class, Mockito.CALLS_REAL_METHODS);
        Mockito.doReturn(reaction).when(check).reaction();
        Mockito.doReturn(Optional.empty()).when(check).repair();
        Mockito.doReturn("constraint-check").when(check).name();

        return check;
    }

    private static void inject(final Object target, final String name, final Object value)
            throws ReflectiveOperationException {
        final Field field = TemplateAlgorithm.class.getDeclaredField(name);
        field.setAccessible(true);
        field.set(target, value);
    }

    @Nested
    @DisplayName("given an algorithm that supports warn and resample")
    class RestrictedReactions {
        @Test
        public void supportedReactionIsAccepted() throws Exception {
            // given
            final SamplingAlgorithm algorithm = algorithmWith(check(CheckReaction.RESAMPLE));

            // when
            algorithm.init(Mockito.mock(EObject.class));

            // then
            Assertions.assertTrue(algorithm.configured);
        }

        @Test
        public void unsupportedReactionIsRejected() throws Exception {
            // given
            final SamplingAlgorithm algorithm = algorithmWith(check(CheckReaction.REPLACE));

            // when
            final InitializationException exception = Assertions.assertThrows(InitializationException.class,
                                                                              () -> algorithm.init(Mockito.mock(EObject.class)));

            // then
            Assertions.assertTrue(exception.getMessage().contains("replace"), exception.getMessage());
            Assertions.assertFalse(algorithm.configured);
        }
    }

    /**
     * @return A strategy of the run whose objectives {@code invalid} cannot be aggregated.
     */
    private static ConfiguredEvaluationStrategy strategyOfRun(final EvaluationStrategy strategy, final List<String> invalid) {
        final ConfiguredEvaluationStrategy configured = Mockito.mock(ConfiguredEvaluationStrategy.class);
        Mockito.when(configured.strategy()).thenReturn(strategy);
        Mockito.when(configured.objectivesThatCannotBeAggregated()).thenReturn(invalid);

        return configured;
    }

    @Nested
    @DisplayName("given an evaluation strategy")
    class EvaluationStrategies {
        @Test
        public void resamplingIsSupportedByEveryAlgorithm() throws Exception {
            // given
            final SamplingAlgorithm algorithm = algorithmWith(check(CheckReaction.WARN));
            inject(algorithm, "evaluationStrategy", strategyOfRun(new Resampling(2, SampleAggregation.MEAN), List.of()));

            // when
            algorithm.init(Mockito.mock(EObject.class));

            // then
            Assertions.assertTrue(algorithm.configured);
            Assertions.assertEquals(List.of(), algorithm.reEvaluation(Mockito.mock(Evaluator.class)));
        }

        @Test
        public void reEvaluationIsRejectedByAnAlgorithmWithoutCarriedOverMembers() throws Exception {
            // given
            final SamplingAlgorithm algorithm = algorithmWith(check(CheckReaction.WARN));
            inject(algorithm, "evaluationStrategy", strategyOfRun(new ReEvaluation(1, SampleAggregation.MEAN), List.of()));

            // when
            final InitializationException exception = Assertions.assertThrows(InitializationException.class,
                                                                              () -> algorithm.init(Mockito.mock(EObject.class)));

            // then
            Assertions.assertTrue(exception.getMessage().contains("re-evaluation"), exception.getMessage());
        }

        @Test
        public void anAlgorithmThatSupportsReEvaluationGetsTheStep() throws Exception {
            // given
            final ReEvaluatingAlgorithm algorithm = new ReEvaluatingAlgorithm();
            inject(algorithm, "checkProducer", Mockito.mock(CandidateCheckProducer.class));
            inject(algorithm, "producer", Mockito.mock(TerminationCriterionProducer.class));
            inject(algorithm, "evaluationStrategy", strategyOfRun(new ReEvaluation(1, SampleAggregation.MEAN), List.of()));

            // when
            algorithm.init(Mockito.mock(EObject.class));

            // then
            final List<Step> steps = algorithm.reEvaluation(Mockito.mock(Evaluator.class));
            Assertions.assertEquals(1, steps.size());
            Assertions.assertInstanceOf(ReEvaluatePopulation.class, steps.getFirst());
        }

        @Test
        public void objectivesThatAreNotRealValuedCannotBeAggregated() throws Exception {
            // given
            final SamplingAlgorithm algorithm = algorithmWith(check(CheckReaction.WARN));
            inject(algorithm, "evaluationStrategy", strategyOfRun(new Resampling(2, SampleAggregation.MEAN), List.of("score")));

            // when
            final InitializationException exception = Assertions.assertThrows(InitializationException.class,
                                                                              () -> algorithm.init(Mockito.mock(EObject.class)));

            // then
            Assertions.assertTrue(exception.getMessage().contains("score"), exception.getMessage());
            Assertions.assertFalse(algorithm.configured);
        }
    }

    /**
     * An algorithm that carries its members over and supports re-evaluation.
     */
    private static final class ReEvaluatingAlgorithm extends TemplateAlgorithm {
        @Override
        protected boolean supportsReEvaluation() {
            return true;
        }

        @Override
        protected void configure(final EObject configuration) {
        }

        @Override
        protected Template template() {
            return new Template(List.of(), List.of());
        }
    }
}
