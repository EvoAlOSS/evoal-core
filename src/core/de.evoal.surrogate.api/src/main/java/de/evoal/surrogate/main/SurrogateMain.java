package de.evoal.surrogate.main;

import de.evoal.core.api.cdi.BeanFactory;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.core.api.cdi.MainClass;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.evoal.languages.model.mll.MachineLearningConfiguration;
import de.evoal.surrogate.api.SurrogateBlackboardEntry;
import de.evoal.surrogate.main.internal.StatementExecutor;
import de.evoal.surrogate.main.internal.SymbolTable;
import lombok.extern.slf4j.Slf4j;

/**
 * Program for pre-calculating regressions to minimize runtime overhead of
 *   recalculating them.
 */
@Slf4j
@Named("surrogate-training")
@ApplicationScoped
public class SurrogateMain implements MainClass {

    @Inject
    @BlackboardValue(SurrogateBlackboardEntry.SURROGATE_CONFIGURATION)
    private MachineLearningConfiguration mlConfiguration;

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
