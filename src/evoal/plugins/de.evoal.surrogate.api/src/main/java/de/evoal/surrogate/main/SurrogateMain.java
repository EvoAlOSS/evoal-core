package de.evoal.surrogate.main;

import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.pipeline.PipelineModule;
import de.evoal.pipeline.api.model.dynamic.EClassProvider;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import de.evoal.surrogate.main.internal.DSLConverter;
import de.evoal.surrogate.main.internal.ProgramExecutor;
import de.evoal.surrogate.main.internal.InterpreterState;
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

    @Override
    public void run() {
        log.info("Training surrogate models and measuring GOF values.");

        //final EClassProvider provider = new EClassProvider();
        //final EClass space = provider.eClassFor(module);
        //final DSLConverter converter = new DSLConverter(space);
        //final PipelineModule pModule = converter.convert(module);

        final InterpreterState globalTable = new InterpreterState();
        //pModule.getProgram()
        //       .getVariables()
        //       .stream()
        //       .forEach(def -> globalTable.put(def, def));

        final ProgramExecutor executor = BeanFactory.create(ProgramExecutor.class);
        executor.setSymbolTable(globalTable);
        //executor.execute(pModule.getProgram());
        executor.execute(module.getStatements());

        log.info("Finished surrogate model training.");
    }
}
