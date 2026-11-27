package de.evoal.surrogate.main;

import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.MainClass;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.core.api.literature.ConfigurationLiterature;
import de.evoal.core.api.provenance.RunRecord;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import de.evoal.surrogate.main.gof.GofCalculatorFunction;
import de.evoal.surrogate.main.literature.SurrogateLiterature;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.core.api.interpreter.ProgramInterpreter;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.models.v202704.pipeline.PipelineModule;
import de.evoal.models.v202704.pipeline.PipelinePackage;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.execution.ExecutionPackage;
import de.evoal.languages.model.execution.ModelFunction;
import org.eclipse.emf.ecore.EPackage;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.surrogate.main.cdi.MachineLearningModuleLoader;
import de.evoal.surrogate.main.internal.SurrogateModelTransformer;
import de.evoal.surrogate.main.internal.MLLProgramExecutionSwitch;
import de.evoal.surrogate.main.internal.UseCaseDerivation;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Trains a surrogate model as configured in an MLL file: runs the learning use case and, if
 *   the module has them (written out, or derived for {@code testing with [...]} and
 *   {@code assessing with [...]}), the testing and the resampling use case. Use cases and
 *   settings that the module leaves out are derived from the learning task
 *   ({@link UseCaseDerivation}).
 */
@Slf4j
@ApplicationScoped
@Application(
        name = SurrogateMain.NAME,
        documentation = """
Application for training a surrogate function based on a given MLL file.
"""
)
public class SurrogateMain implements MainClass {
    /**
     * The name of the application, the value of {@code -Bcore:main}.
     */
    public static final String NAME = "surrogate-training";

    /**
     * The packages of the pipeline runtime model that the literature walker enters: the
     *   pipelines are variables of the program, and calls refer to them in expressions.
     */
    private static final Set<EPackage> PIPELINE_MODEL = Set.of(PipelinePackage.eINSTANCE, ExecutionPackage.eINSTANCE,
                                                                  ExpressionsPackage.eINSTANCE);


    @Inject
    private MachineLearningModuleLoader mlLoader;

    @Inject
    private EClassProvider provider;

    @Inject
    private EAnnotationHelper helper;

    @Inject
    private DefinitionModuleLoader dlLoader;

    @Inject
    private SurrogateModelTransformer transformer;

    @Inject
    private Blackboard board;

    /**
     * Reads the attributes of the configurations for their literature.
     */
    @Inject
    private AttributeEvaluator evaluator;

    /**
     * Records the DL types of the training for the model file.
     */
    @Inject
    private SurrogateLiterature literature;

    @Override
    public void run() {
        log.info("Loading model from configuration.");
        final MachineLearningModule module = mlLoader.load();

        log.info("Generating dynamic EClass for model.");
        final EClass model = provider.eClassFor(module);
        final Space space = new Space(model);

        new UseCaseDerivation(dlLoader).derive(module);

        log.info("Converting machine learning model to pipeline model.");
        final List<EStructuralFeature> useCases = List.of(
                MllPackage.eINSTANCE.getMachineLearningModule_LearningUseCase(),
                MllPackage.eINSTANCE.getMachineLearningModule_TestingUseCase(),
                MllPackage.eINSTANCE.getMachineLearningModule_ResamplingUseCase());
        final PipelineModule pModule = transformer.transform(module, space, useCases, dlLoader, helper);

        writeLiterature(pModule);

        log.info("Running use cases: learning{}{}", module.getTestingUseCase() != null ? ", testing" : "",
                 module.getResamplingUseCase() != null ? ", resampling" : "");
        final ProgramInterpreter executor = new ProgramInterpreter((state) -> {
            state.setSpace(space);
            goodnessOfFitFunction(pModule).ifPresent(function -> GofCalculatorFunction.bind(state, function));
            return BeanFactory.create(MLLProgramExecutionSwitch.class)
                              .setState(state);
        });
        executor.execute(pModule.getProgram(), space);

        log.info("Finished surrogate model training.");
    }

    /**
     * @return The program function {@code goodness-of-fit}, whose body is {@code specify gof}.
     */
    private static Optional<ModelFunction> goodnessOfFitFunction(final PipelineModule pModule) {
        return pModule.getProgram()
                      .getFunctions()
                      .stream()
                      .filter(ModelFunction.class::isInstance)
                      .map(ModelFunction.class::cast)
                      .filter(function -> "goodness-of-fit".equals(function.getName()))
                      .findFirst();
    }

    /**
     * Names the folder of the run's provenance ({@code provenance/<configuration file>} in the
     *   execution folder), writes the literature of the training into it and records its DL
     *   types for the model file.
     */
    private void writeLiterature(final PipelineModule pModule) {
        final String configurationFile = board.get(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION_FILE);
        final Path folder = Path.of(RunRecord.FOLDER, Path.of(configurationFile).getFileName().toString());
        RunRecord.current().setFolder(folder);

        final List<Definition> definitions = ConfigurationLiterature.of(evaluator, PIPELINE_MODEL)
                                                                    .definitions(pModule);
        literature.trained(definitions);

        try {
            ConfigurationLiterature.citationsOf(definitions)
                                   .write(folder);
        } catch(final IOException e) {
            log.error("Failed to write the literature of the training to '{}'.", folder, e);
        }
    }
}
