package de.evoal.core.main;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntries;
import de.evoal.core.api.board.CoreBlackboardEntries;
import de.evoal.core.api.cdi.Application;
import de.evoal.core.api.cdi.Commandline;
import de.evoal.core.api.cdi.MainClass;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.Bean;

import lombok.extern.slf4j.Slf4j;
import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;
import org.apache.deltaspike.core.util.metadata.AnnotationInstanceProvider;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Main class for EvoAl. The concrete runtime behaviour depends on the used blackboard
 *   configuration.
 */
@Slf4j
public final class Evoal {

    /**
     * Some libraries use Java's unified logging facility. This method installs
     *   a logging bridge that reroutes all logging from JUL to SLF4J.
     */
    private static void installJavaLoggingToSLF4JBridge() {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }

    public static void main(final String ... args) {
        installJavaLoggingToSLF4JBridge();
        log.info("Starting up EvoAl");

        log.info("Booting CDI container");
        final CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();
        cdiContainer.boot();
        cdiContainer.getContextControl()
                    .startContext(ApplicationScoped.class);

        if(args.length == 0 || args.length == 1 && "--help".equals(args[0])) {
            printUsage();
        } else {
            log.info("Setting up black board");
            final Blackboard board = BeanProvider.getContextualReference(Blackboard.class);
            board.readArguments(args);

            log.info("Fetching main class and handing over control");
            try {
                final String mainName = board.get(CoreBlackboardEntries.MAIN);
                MainClass main = null;

                try {
                    final Application annotation = AnnotationInstanceProvider.of(Application.class, Map.of("name", mainName));
                    main = BeanProvider.getContextualReference(MainClass.class, annotation);
                } catch (final Throwable e) {
                    logMainError(e);
                    System.exit(1);
                }

                main.run();
            } catch (final Throwable e) {
                log.error("Main class threw an exception.", e);
            }
        }
        
        log.info("Shutting down CDI container");
        cdiContainer.shutdown();
    }

    private static void printUsage() {
        System.out.println();
        System.out.println();
        System.out.println("EvoAl is a launcher application for different functions.");
        System.out.println("  To invoke EvoAl correctly, you first have to specify the function you want to");
        System.out.println("  use and the necessary parameters. All parameters are passed by using the -B ");
        System.out.println("  switch, e.g., '-Bcore:main=heuristic-search'. The part after the -B specifies");
        System.out.println("  the parameter name and the corresponding value is given after the equals sign.");
        System.out.println("  Your EvoAl installation supports the following functions and parameters:");
        System.out.println();

        final Set<Bean<BlackboardEntries>> entriesBeans = BeanProvider.getBeanDefinitions(BlackboardEntries.class, true, true);
        final Map<String, List<Commandline>> parameters = new HashMap<>();

        for(final Bean<BlackboardEntries> bean : entriesBeans) {
            final Class<?> clazz = bean.getBeanClass();
            for(final Field field : clazz.getDeclaredFields()) {
                if(!field.isAnnotationPresent(Commandline.class)) {
                    continue;
                }

                final Commandline annotation = field.getAnnotation(Commandline.class);

                for(final String main : annotation.main()) {
                    parameters.putIfAbsent(main, new LinkedList<>());

                    final List<Commandline> annotations = parameters.get(main);
                    annotations.add(annotation);

                }
            }
        }

        final Set<Bean<MainClass>> beans = BeanProvider.getBeanDefinitions(MainClass.class, true, true);
        for(final Bean<MainClass> bean : beans) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------");
            final Application app = bean.getBeanClass().getAnnotation(Application.class);
            System.out.println("  -Bcore:main=" + app.name());
            printIntended(4, app.documentation());

            final List<Commandline> annotations = parameters.getOrDefault(app.name(), new LinkedList<>());
            for(final Commandline annotation : annotations) {
                System.out.println();
                System.out.println("    -B" + annotation.name() + "=");
                printIntended(6, annotation.doc());
            }
        }

        final List<Commandline> annotations = parameters.getOrDefault("", new LinkedList<>());
        if(annotations != null) {
            System.out.println();
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("  General parameters:");
            for(final Commandline annotation : annotations) {
                System.out.println("    " + annotation.name() + ":");
                printIntended(6, annotation.doc());
                System.out.println();
            }
        }
    }

    private static void printIntended(final int nmrWhitespaces, final String text) {
        for(final String part : text.split("\\r?\\n")) {
            System.out.println(" ".repeat(nmrWhitespaces) + part);
        }
    }

    private static void logMainError(final Throwable e) {
        log.error("Filed to create main.", e);
        log.error("Name of main class was not set correctly. Please specify the main class via command line (-B{}=<name>).", CoreBlackboardEntries.MAIN);
        Set<Bean<MainClass>> beans = BeanProvider.getBeanDefinitions(MainClass.class, true, true);
        log.error("  possible names are:");

        for(final Bean<MainClass> bean : beans) {
            log.error("    {}", bean.getBeanClass().getAnnotation(Application.class).name());
        }
    }
}
