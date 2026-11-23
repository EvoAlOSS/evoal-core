package de.evoal.surrogate.main.internal;

import de.evoal.core.api.languages.base.ElementSwitch;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.StringLiteral;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.execution.CallBuiltinFunction;
import de.evoal.languages.model.execution.Statement;
import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.generator.PipelineStep;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import org.eclipse.emf.ecore.EObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

/**
 * The derivation of the use cases of an MLL module and the settings of their standard steps
 *   from the learning task (#325).
 */
public class UseCaseDerivationTest {
    private static MachineLearningModule load(final String file) {
        return LanguageHelper.loadFromClasspath("de/evoal/surrogate/main/internal/" + file);
    }

    private static MachineLearningModule loadAndDerive(final String file) {
        final MachineLearningModule module = load(file);

        new UseCaseDerivation(Mockito.mock(DefinitionModuleLoader.class)).derive(module);

        return module;
    }

    private static String nameOf(final Statement statement) {
        final CallBuiltinFunction call = (CallBuiltinFunction) statement;

        return ((DefinitionModule) call.getDefinition().eContainer()).getName() + "." + call.getDefinition().getName();
    }

    private static List<EObject> executedSteps(final List<Statement> statements) {
        final CallBuiltinFunction execute = (CallBuiltinFunction) statements.get(0);

        final Array steps = (Array) ElementSwitch.elementOf(execute.getParameters().get(0)).orElseThrow();

        return steps.getValues()
                    .stream()
                    .map(v -> (EObject) ElementSwitch.elementOf(v).orElseThrow())
                    .toList();
    }

    private static String describe(final EObject step) {
        if(step instanceof ConcreteStep concrete) {
            return "step " + concrete.getInstance().getDefinition().getName();
        }

        return "pipeline " + ((PipelineStep) step).getDefinition().getName();
    }

    private static List<String> names(final List<TypeDefinitionReference> features) {
        return features.stream()
                       .map(f -> f.getDefinition().getName())
                       .toList();
    }

    private static List<EObject> valuesOf(final Instance instance, final String attribute) {
        final Attribute value = instance.findAttribute(attribute);

        return ((Array) ElementSwitch.elementOf(value.getValue()).orElseThrow()).getValues()
                                                                                .stream()
                                                                                .map(v -> (EObject) ElementSwitch.elementOf(v).orElseThrow())
                                                                                .toList();
    }

    private static List<String> featuresOf(final Instance instance, final String attribute) {
        return valuesOf(instance, attribute).stream()
                                            .map(v -> ((DataDescription) ((TypeDefinitionReference) v).getDefinition()).getName())
                                            .toList();
    }

    private static List<String> stringsOf(final Instance instance, final String attribute) {
        return valuesOf(instance, attribute).stream()
                                            .map(v -> ((StringLiteral) v).getLiteral())
                                            .toList();
    }

    @Nested
    @DisplayName("given a module without use cases")
    class DefaultUseCases {
        private final MachineLearningModule module = loadAndDerive("default-use-cases.mll");

        @Test
        public void learningLoadsValidatesPreparesLearnsAssessesAndStores() {
            // when
            final List<Statement> statements = module.getLearningUseCase().getStatements();

            // then
            Assertions.assertEquals(List.of("de.evoal.pipeline.base.execute",
                                            "de.evoal.surrogate.pipeline.gof-calculator",
                                            "de.evoal.surrogate.pipeline.store-model"),
                                    statements.stream().map(UseCaseDerivationTest::nameOf).toList());
            Assertions.assertEquals(List.of("step training-data-loader", "pipeline validation", "pipeline preparation", "step model-learner"),
                                    executedSteps(statements).stream().map(UseCaseDerivationTest::describe).toList());
        }

        @Test
        public void predictingPreparesAndPredicts() {
            // when
            final List<EObject> steps = List.copyOf(module.getPredictionUseCase().getSteps());

            // then
            Assertions.assertEquals("predicting", module.getPredictionUseCase().getName());
            Assertions.assertEquals(List.of("pipeline preparation", "step model-prediction"),
                                    steps.stream().map(UseCaseDerivationTest::describe).toList());
        }

        @Test
        public void predictionReadsTheInputsAndWritesTheOutputs() {
            // when
            final ConcreteStep prediction = (ConcreteStep) module.getPredictionUseCase().getSteps().get(1);

            // then
            Assertions.assertEquals(List.of("x:0", "x:1"), names(prediction.getReads()));
            Assertions.assertEquals(List.of("y:0"), names(prediction.getWrites()));
        }

        @Test
        public void testingLoadsValidatesAndAssessesTheTestData() {
            // when
            final List<EObject> steps = executedSteps(module.getTestingUseCase().getStatements());

            // then
            Assertions.assertEquals(List.of("step test-data-loader", "pipeline validation", "step assessment-data"),
                                    steps.stream().map(UseCaseDerivationTest::describe).toList());
            final Instance loader = ((ConcreteStep) steps.get(0)).getInstance();
            Assertions.assertEquals(List.of("test.json"), stringsOf(loader, "testing-files"));
            Assertions.assertEquals(List.of("x:0", "x:1"), featuresOf(loader, "input-features"));
            Assertions.assertEquals(List.of("y:0"), featuresOf(loader, "output-features"));
        }

        @Test
        public void theLoaderGetsTheTrainingDataOfTheTask() {
            // when
            final ConcreteStep loader = (ConcreteStep) executedSteps(module.getLearningUseCase().getStatements()).get(0);

            // then
            Assertions.assertEquals(List.of("x:0", "x:1", "y:0"), names(loader.getWrites()));
            Assertions.assertEquals(List.of("training.json"), stringsOf(loader.getInstance(), "training-files"));
            Assertions.assertEquals(List.of("x:0", "x:1"), featuresOf(loader.getInstance(), "input-features"));
            Assertions.assertEquals(List.of("y:0"), featuresOf(loader.getInstance(), "output-features"));
        }

        @Test
        public void theLearnerGetsTheModelTheFileAndTheFeaturesOfTheTask() {
            // when
            final ConcreteStep learner = (ConcreteStep) executedSteps(module.getLearningUseCase().getStatements()).get(3);
            final Instance instance = learner.getInstance();

            // then
            Assertions.assertEquals(List.of("x:0", "x:1", "y:0"), names(learner.getReads()));
            Assertions.assertEquals("test-model", ((Instance) instance.findAttribute("model").getValue()).getDefinition().getName());
            Assertions.assertEquals("output/model.pson", ((StringLiteral) instance.findAttribute("model-file").getValue()).getLiteral());
            Assertions.assertEquals(List.of("x:0", "x:1"), featuresOf(instance, "input-features"));
            Assertions.assertEquals(List.of("y:0"), featuresOf(instance, "output-features"));
        }

        @Test
        public void theEffectiveUseCasesArePrintedInMllSyntax() {
            // when
            final String printed = new UseCasePrinter().print(module);

            // then
            Assertions.assertTrue(printed.contains("specify learning"), printed);
            Assertions.assertTrue(printed.contains("step { component 'model-prediction' {} reads [data 'x:0', data 'x:1'] writes [data 'y:0'] }"), printed);
            Assertions.assertTrue(printed.contains("'testing-files' := [\"test.json\"];"), printed);
        }
    }

    @Nested
    @DisplayName("given written-out use cases with partial settings")
    class DerivedSettings {
        private final MachineLearningModule module = loadAndDerive("derived-settings.mll");

        @Test
        public void writtenOutUseCasesAreKept() {
            // when
            final List<Statement> statements = module.getLearningUseCase().getStatements();

            // then
            Assertions.assertEquals(1, statements.size());
            Assertions.assertEquals(List.of("step training-data-loader", "pipeline validation", "step model-learner"),
                                    executedSteps(statements).stream().map(UseCaseDerivationTest::describe).toList());
            Assertions.assertNull(module.getTestingUseCase());
        }

        @Test
        public void statedSettingsAreKeptAndMissingOnesDerived() {
            // when
            final List<EObject> steps = executedSteps(module.getLearningUseCase().getStatements());
            final ConcreteStep loader = (ConcreteStep) steps.get(0);
            final ConcreteStep learner = (ConcreteStep) steps.get(2);

            // then
            Assertions.assertEquals(List.of("other.json"), stringsOf(loader.getInstance(), "training-files"));
            Assertions.assertEquals(List.of("x:0", "x:1"), featuresOf(loader.getInstance(), "input-features"));
            Assertions.assertEquals(List.of("x:0"), featuresOf(learner.getInstance(), "input-features"));
            Assertions.assertEquals(List.of("y:0"), featuresOf(learner.getInstance(), "output-features"));
        }

        @Test
        public void aStatedSubsetIsKeptAndTheMissingListDerived() {
            // when
            final ConcreteStep prediction = (ConcreteStep) module.getPredictionUseCase().getSteps().get(0);

            // then
            Assertions.assertEquals(List.of("x:0"), names(prediction.getReads()));
            Assertions.assertEquals(List.of("y:0"), names(prediction.getWrites()));
        }
    }

    @Nested
    @DisplayName("given features outside the learning task")
    class OutsideFeatures {
        @Test
        public void theModuleIsRejectedWithEveryWrongFeature() {
            // when
            final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                                                                     () -> loadAndDerive("outside-features.mll"));

            // then
            Assertions.assertTrue(e.getMessage().contains("Module 'outside-features', use case 'predicting', step 'model-prediction': 'reads' contains 'z:0'"), e.getMessage());
            Assertions.assertTrue(e.getMessage().contains("Module 'outside-features', use case 'learning', step 'model-learner': 'input-features' contains 'y:0'"), e.getMessage());
        }
    }

    @Nested
    @DisplayName("given a written-out testing use case without test data")
    class TestingWithoutData {
        @Test
        public void theModuleIsRejected() {
            // when
            final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                                                                     () -> loadAndDerive("testing-without-data.mll"));

            // then
            Assertions.assertTrue(e.getMessage().contains("use case 'testing', step 'test-data-loader': no test data"), e.getMessage());
        }
    }

    @Nested
    @DisplayName("given a written-out use case")
    class PrintedUseCase {
        @Test
        public void eachStepOfThePipelineIsPrintedOnItsOwnLine() {
            // given
            final MachineLearningModule module = loadAndDerive("derived-settings.mll");

            // when
            final String printed = new UseCasePrinter().print(module);

            // then
            Assertions.assertTrue(printed.contains("'execute'([\n"), printed);
            Assertions.assertTrue(printed.contains("\n      pipeline 'validation',\n"), printed);
        }
    }

    @Nested
    @DisplayName("given preparation steps")
    class PreparationSteps {
        private final MachineLearningModule module = loadAndDerive("preparation.mll");

        private ConcreteStep step(final int index) {
            return (ConcreteStep) module.getPreparation().getSteps().get(index);
        }

        @Test
        public void theyReadAndWriteTheFeaturesTheyName() {
            // then
            Assertions.assertEquals(List.of("x:0", "x:1"), names(step(0).getReads()));
            Assertions.assertEquals(List.of("x:0", "x:1"), names(step(0).getWrites()));
            Assertions.assertEquals(List.of("y:0"), names(step(1).getReads()));
        }

        @Test
        public void statedParametersAreKept() {
            // then
            Assertions.assertEquals(1, ((Array) ElementSwitch.elementOf(step(1).getInstance().findAttribute("μ").getValue()).orElseThrow()).getValues().size());
        }

        @Test
        public void theDefaultUseCasesPrepareTheData() {
            // then
            Assertions.assertEquals(List.of("step training-data-loader", "pipeline validation", "pipeline preparation", "step model-learner"),
                                    executedSteps(module.getLearningUseCase().getStatements()).stream().map(UseCaseDerivationTest::describe).toList());
            Assertions.assertEquals("pipeline preparation", describe(module.getPredictionUseCase().getSteps().getFirst()));
        }
    }

    @Nested
    @DisplayName("given resampling schemes")
    class ResamplingSchemes {
        private final MachineLearningModule module = loadAndDerive("resampling.mll");

        private List<Statement> statements() {
            return module.getResamplingUseCase().getStatements();
        }

        private List<String> stepsOf(final Statement statement, final int parameter) {
            final CallBuiltinFunction call = (CallBuiltinFunction) statement;
            final Array steps = (Array) ElementSwitch.elementOf(call.getParameters().get(parameter)).orElseThrow();

            return steps.getValues()
                        .stream()
                        .map(v -> describe((EObject) ElementSwitch.elementOf(v).orElseThrow()))
                        .toList();
        }

        @Test
        public void eachSchemeIsResampledInOrderAndTheModelIsStoredAgain() {
            // then
            Assertions.assertEquals(List.of("de.evoal.surrogate.pipeline.resample",
                                            "de.evoal.surrogate.pipeline.resample",
                                            "de.evoal.surrogate.pipeline.resample",
                                            "de.evoal.surrogate.pipeline.resample",
                                            "de.evoal.surrogate.pipeline.store-model"),
                                    statements().stream().map(UseCaseDerivationTest::nameOf).toList());
            Assertions.assertEquals(List.of("k-fold-cross-validation", "leave-one-out-cross-validation", "bootstrap", "block-cross-validation"),
                                    statements().subList(0, 4)
                                                .stream()
                                                .map(s -> ((Instance) ElementSwitch.elementOf(((CallBuiltinFunction) s).getParameters().get(0)).orElseThrow())
                                                        .getDefinition().getName())
                                                .toList());
        }

        @Test
        public void aPartLearnsLikeTheLearningUseCaseAndIsAssessedAfterValidation() {
            // then
            Assertions.assertEquals(List.of("pipeline validation", "pipeline preparation", "step model-learner"), stepsOf(statements().get(0), 1));
            Assertions.assertEquals(List.of("pipeline validation"), stepsOf(statements().get(0), 2));
        }

        @Test
        public void theLearnerOfAPartGetsTheDerivedSettings() {
            // when
            final CallBuiltinFunction call = (CallBuiltinFunction) statements().get(0);
            final Array steps = (Array) ElementSwitch.elementOf(call.getParameters().get(1)).orElseThrow();
            final ConcreteStep learner = (ConcreteStep) ElementSwitch.elementOf(steps.getValues().get(2)).orElseThrow();

            // then
            Assertions.assertEquals(List.of("x:0", "x:1", "y:0"), names(learner.getReads()));
            Assertions.assertEquals(List.of("x:0", "x:1"), featuresOf(learner.getInstance(), "input-features"));
            Assertions.assertNotNull(learner.getInstance().findAttribute("model"));
        }

        @Test
        public void theResamplingUseCaseIsPrinted() {
            // when
            final String printed = new UseCasePrinter().print(module);

            // then
            Assertions.assertTrue(printed.contains("specify resampling"), printed);
            Assertions.assertTrue(printed.contains("'resample'('k-fold-cross-validation' { 'k' := 5; }, ["), printed);
        }

        @Test
        public void withoutSchemesThereIsNoResamplingUseCase() {
            // when
            final MachineLearningModule withoutSchemes = loadAndDerive("default-use-cases.mll");

            // then
            Assertions.assertNull(withoutSchemes.getResamplingUseCase());
        }
    }

    @Nested
    @DisplayName("given wrong resampling schemes")
    class WrongResamplingSchemes {
        @Test
        public void aSchemeStatedTwiceIsRejected() {
            // when
            final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                                                                     () -> loadAndDerive("resampling-twice.mll"));

            // then
            Assertions.assertTrue(e.getMessage().contains("'k-fold-cross-validation' is stated twice"), e.getMessage());
        }

        @Test
        public void blocksNamedByAFeatureOfTheTaskAreRejected() {
            // when
            final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                                                                     () -> loadAndDerive("given-blocks-on-input.mll"));

            // then
            Assertions.assertTrue(e.getMessage().contains("the feature 'x:1' of 'given-blocks' is a feature of the learning task"), e.getMessage());
        }
    }

    @Nested
    @DisplayName("given wrong preparation steps")
    class WrongPreparationSteps {
        @Test
        public void theModuleIsRejectedWithEveryError() {
            // when
            final IllegalStateException e = Assertions.assertThrows(IllegalStateException.class,
                                                                     () -> loadAndDerive("wrong-preparation.mll"));

            // then
            final String where = "Module 'wrong-preparation', pipeline 'preparation', step ";
            Assertions.assertTrue(e.getMessage().contains(where + "'min-max-normalisation': 'features' contains 'z:0'"), e.getMessage());
            Assertions.assertTrue(e.getMessage().contains(where + "'min-max-normalisation': 'inverse' is derived"), e.getMessage());
            Assertions.assertTrue(e.getMessage().contains(where + "'z-score-normalisation': 'μ' has 2 values but the step has 1 features."), e.getMessage());
            Assertions.assertTrue(e.getMessage().contains(where + "'z-score-normalisation': states 'μ' but not 'σ'"), e.getMessage());
        }
    }
}
