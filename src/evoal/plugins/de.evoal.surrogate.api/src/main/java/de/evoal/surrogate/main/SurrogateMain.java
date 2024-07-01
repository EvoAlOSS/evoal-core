package de.evoal.surrogate.main;

import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import de.evoal.surrogate.main.internal.StatementExecutor;
import de.evoal.surrogate.main.internal.SymbolTable;
import lombok.extern.slf4j.Slf4j;

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
    private MachineLearningModule mlConfiguration;

    @Inject

    @Override
    public void run() {
        log.info("Training surrogate models and measuring GOF values.");

        final SymbolTable globalTable = new SymbolTable(null);
        mlConfiguration.getDefinitions()
                        .stream()
                        .forEach(def -> globalTable.put(def.getName(), def));

        final StatementExecutor executor = BeanFactory.create(StatementExecutor.class);
        executor.setSymbolTable(globalTable);

        mlConfiguration.getStatements()
                       .forEach(executor::evaluate);

        log.info("Finished surrogate model training.");
    }
}
