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

/**
 * Program for pre-calculating regressions to minimize runtime overhead of
 *   recalculating them.
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

        log.info("Converting machine learning model to pipeline model.");
        final EStructuralFeature learningUseCase = MllPackage.eINSTANCE.getMachineLearningModule_LearningUseCase();
        final PipelineModule pModule = transformer.transform(module, space, learningUseCase, dlLoader, helper);

        log.info("Running use case: learning");
        final ProgramInterpreter executor = new ProgramInterpreter((state) -> {
            state.setSpace(space);
            return BeanFactory.create(MLLProgramExecutionSwitch.class)
                              .setState(state);
        });
        executor.execute(pModule.getProgram(), space);

        log.info("Finished surrogate model training.");
    }
}
