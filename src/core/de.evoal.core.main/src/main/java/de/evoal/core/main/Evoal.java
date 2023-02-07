package de.evoal.core.main;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.MainClass;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.Bean;

import lombok.extern.slf4j.Slf4j;
import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;

import java.util.Set;

/**
 * Main class for EvoAl. The concrete runtime behaviour depends on the used blackboard
 *   configuration.
 */
@Slf4j
public final class Evoal {
    public static void main(final String ... args) {
        log.info("Starting up EvoAl");

        log.info("Booting CDI container");
        final CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.boot();
        cdiContainer.getContextControl().startContext(ApplicationScoped.class);

        log.info("Setting up black board");
        final Blackboard board = BeanProvider.getContextualReference(Blackboard.class);
        board.readArguments(args);

        log.info("Fetching main class and handing over control");
        try {
            final String mainName = board.get(BlackboardEntry.MAIN);
            MainClass main = null;

            try {
                main = BeanProvider.getContextualReference(mainName, false, MainClass.class);
            } catch(final Throwable e) {
                logMainError(e);
                System.exit(1);
            }

            main.run();
        } catch (final Throwable e) {
            log.error("Main class threw an exception.", e);
        }

        log.info("Shutting down CDI container");
        cdiContainer.shutdown();
    }

    private static void logMainError(final Throwable e) {
        log.error("Filed to create main.", e);
        log.error("Name of main class was not set correctly. Please specify the main class via command line (-B{}=<name>).", BlackboardEntry.MAIN);
        Set<Bean<MainClass>> beans = BeanProvider.getBeanDefinitions(MainClass.class, true, true);
        log.error("  possible names are:");

        for(final Bean<MainClass> bean : beans) {
            log.error("    {}", bean.getName());
        }
    }
}
