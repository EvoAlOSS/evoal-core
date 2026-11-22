package de.evoal.surrogate.main.internal;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.StringLiteral;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.execution.CallBuiltinFunction;
import de.evoal.languages.model.execution.CallModelFunction;
import de.evoal.languages.model.execution.Statement;
import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.generator.PipelineStep;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.models.core.ecore.Space;
import de.evoal.models.v202704.pipeline.PipelineModule;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * The testing use case of an MLL file: parsed, added by default for {@code testing with [...]},
 *   and run after the learning use case (#234).
 */
public class TestingUseCaseTest {
    private static MachineLearningModule load(final String file) {
        return LanguageHelper.loadFromClasspath("de/evoal/surrogate/main/internal/" + file);
    }

    private static MachineLearningModule loadAndInject(final String file) {
        final MachineLearningModule module = load(file);

        new DefaultBehaviourInjector(Mockito.mock(DefinitionModuleLoader.class), module.getTask().getInputs(), module.getTask().getOutputs())
                .inject(module);

        return module;
    }

    private static String nameOf(final Statement statement) {
        final CallBuiltinFunction call = (CallBuiltinFunction) statement;

        return ((DefinitionModule) call.getDefinition().eContainer()).getName() + "." + call.getDefinition().getName();
    }

    private static String typeOf(final Object step) {
        return ((ConcreteStep) step).getInstance().getDefinition().getName();
    }

    @Nested
    @DisplayName("given test data and no testing use case")
    class DefaultTestingUseCase {
        private final MachineLearningModule module = loadAndInject("with-test-data.mll");

        @Test
        public void theUseCaseExecutesThePipelineAssessesAndStores() {
            // when
            final List<Statement> statements = module.getTestingUseCase().getStatements();

            // then
            Assertions.assertEquals(List.of("de.evoal.pipeline.base.execute",
                                            "de.evoal.surrogate.pipeline.gof-calculator",
                                            "de.evoal.surrogate.pipeline.store-model"),
                                    statements.stream().map(TestingUseCaseTest::nameOf).toList());
        }

        @Test
        public void thePipelineLoadsValidatesAndCollectsTheTestData() {
            // when
            final CallBuiltinFunction execute = (CallBuiltinFunction) module.getTestingUseCase().getStatements().get(0);
            final List<?> steps = ((Array) execute.getParameters().get(0)).getValues();

            // then
            Assertions.assertEquals(3, steps.size());
            Assertions.assertEquals("test-data-loader", typeOf(steps.get(0)));
            Assertions.assertEquals(2, ((ConcreteStep) steps.get(0)).getWrites().size());
            Assertions.assertSame(module.getValidation(), ((PipelineStep) steps.get(1)).getDefinition());
            Assertions.assertEquals("assessment-data", typeOf(steps.get(2)));
            Assertions.assertEquals(2, ((ConcreteStep) steps.get(2)).getReads().size());
        }

        @Test
        public void theCollectedDataIsTheTestData() {
            // when
            final CallBuiltinFunction execute = (CallBuiltinFunction) module.getTestingUseCase().getStatements().get(0);
            final ConcreteStep assessment = (ConcreteStep) ((Array) execute.getParameters().get(0)).getValues().get(2);

            // then
            final StringLiteral dataSet = (StringLiteral) assessment.getInstance().findAttribute("data-set").getValue();
            Assertions.assertEquals("test", dataSet.getLiteral());
        }
    }

    @Nested
    @DisplayName("given a learning and a testing use case")
    class UseCaseOrder {
        @Test
        public void theUseCasesRunInTheOrderLearningTesting() {
            // given
            final MachineLearningModule module = load("use-case-order.mll");
            final Space space = new Space(new EClassProvider().eClassFor(module));
            final List<EStructuralFeature> useCases = List.of(
                    MllPackage.eINSTANCE.getMachineLearningModule_LearningUseCase(),
                    MllPackage.eINSTANCE.getMachineLearningModule_TestingUseCase());

            // when
            final PipelineModule converted = new SurrogateModelTransformer()
                    .transform(module, space, useCases, Mockito.mock(DefinitionModuleLoader.class), new EAnnotationHelper());

            // then
            Assertions.assertEquals(List.of("learning", "testing"),
                                    converted.getProgram()
                                             .getMain()
                                             .getBody()
                                             .getStatements()
                                             .stream()
                                             .map(s -> ((CallModelFunction) s).getFunction().getName())
                                             .toList());
        }
    }

    @Nested
    @DisplayName("given no test data")
    class NoTestData {
        @Test
        public void noTestingUseCaseIsAdded() {
            // when
            final MachineLearningModule module = loadAndInject("without-test-data.mll");

            // then
            Assertions.assertNull(module.getTestingUseCase());
        }
    }

    @Nested
    @DisplayName("given a written-out testing use case")
    class WrittenOutTestingUseCase {
        @Test
        public void theUseCaseIsParsed() {
            // when
            final MachineLearningModule module = load("written-testing.mll");

            // then
            Assertions.assertEquals(List.of("de.evoal.surrogate.pipeline.gof-calculator"),
                                    module.getTestingUseCase().getStatements().stream().map(TestingUseCaseTest::nameOf).toList());
        }

        @Test
        public void theUseCaseIsKept() {
            // when
            final MachineLearningModule module = loadAndInject("written-testing.mll");

            // then
            Assertions.assertEquals(1, module.getTestingUseCase().getStatements().size());
        }
    }
}
