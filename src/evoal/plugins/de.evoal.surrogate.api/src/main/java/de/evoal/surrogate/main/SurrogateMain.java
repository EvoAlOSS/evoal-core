package de.evoal.surrogate.main;

import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.MainClass;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.models.core.ecore.Space;
import de.evoal.core.api.interpreter.ProgramInterpreter;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.models.v202704.pipeline.PipelineModule;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.surrogate.main.cdi.MachineLearningModuleLoader;
import de.evoal.surrogate.main.internal.DefaultBehaviourInjector;
import de.evoal.surrogate.main.internal.SurrogateModelTransformer;
import de.evoal.surrogate.main.internal.MLLProgramExecutionSwitch;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.List;

/**
 * Trains a surrogate model as configured in an MLL file: runs the learning use case and, if
 *   the module has one (written out or added for {@code testing with [...]}), the testing use
 *   case.
 */
@Slf4j
@ApplicationScoped
@Application(
        name = "surrogate-training",
        documentation = """
Application for training a surrogate function based on a given MLL file.
"""
)
public class SurrogateMain implements MainClass {

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

    @Override
    public void run() {
        log.info("Loading model from configuration.");
        final MachineLearningModule module = mlLoader.load();

        log.info("Generating dynamic EClass for model.");
        final EClass model = provider.eClassFor(module);
        final Space space = new Space(model);

        log.info("Making implicit behaviour explicit in model.");
        new DefaultBehaviourInjector(dlLoader, module.getTask().getInputs(), module.getTask().getOutputs()).inject(module);

        if(module.getLearningUseCase() == null) {
            throw new IllegalStateException("The MLL file has no learning use case: add 'specify learning begin ... end;' to its 'use cases'.");
        }

        log.info("Converting machine learning model to pipeline model.");
        final List<EStructuralFeature> useCases = List.of(
                MllPackage.eINSTANCE.getMachineLearningModule_LearningUseCase(),
                MllPackage.eINSTANCE.getMachineLearningModule_TestingUseCase());
        final PipelineModule pModule = transformer.transform(module, space, useCases, dlLoader, helper);

        log.info("Running use cases: learning{}", module.getTestingUseCase() != null ? ", testing" : "");
        final ProgramInterpreter executor = new ProgramInterpreter((state) -> {
            state.setSpace(space);
            return BeanFactory.create(MLLProgramExecutionSwitch.class)
                              .setState(state);
        });
        executor.execute(pModule.getProgram(), space);

        log.info("Finished surrogate model training.");
    }
}
