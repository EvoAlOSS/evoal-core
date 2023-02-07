package de.evoal.generator.api;

import de.evoal.core.api.board.BlackboardEntries;
import de.evoal.core.api.cdi.Commandline;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("generator-entries")
public class GeneratorBlackboardEntries implements BlackboardEntries {
    /**
     * Loaded generator configuration.
     */
    public static final String GENERATOR_CONFIGURATION = "generator:configuration";

    /**
     * Configuration file for the data generator.
     */
    @Commandline(main = "data-generator", name = "generator:configuration-file", doc = "The generator file to use.")
    public static final String GENERATOR_CONFIGURATION_FILE = "generator:configuration-file";
}
