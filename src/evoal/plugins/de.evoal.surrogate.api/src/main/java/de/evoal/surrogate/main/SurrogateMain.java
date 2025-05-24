package de.evoal.surrogate.main;

import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import de.evoal.core.interpreter.api.ProgramInterpreter;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.pipeline.PipelineModule;
import de.evoal.core.api.dynamic.EClassProvider;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import de.evoal.surrogate.main.internal.MLLModelConverter;
import de.evoal.surrogate.main.internal.MLLProgramExecutionSwitch;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;

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
    @BlackboardValue(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION)
    private MachineLearningModule module;

    @Inject
    private EClassProvider provider;

    @Override
    public void run() {
        log.info("Training surrogate models and measuring GOF values.");

        final EClass space = provider.eClassFor(module);
        final MLLModelConverter converter = new MLLModelConverter(space);
        final PipelineModule pModule = converter.convert(module);

        final ProgramInterpreter executor = new ProgramInterpreter((state) -> {
            state.setSpace(space);
            return BeanFactory.create(MLLProgramExecutionSwitch.class)
                              .setState(state);
        });
        executor.execute(pModule.getProgram(), space);

        log.info("Finished surrogate model training.");
    }
}
