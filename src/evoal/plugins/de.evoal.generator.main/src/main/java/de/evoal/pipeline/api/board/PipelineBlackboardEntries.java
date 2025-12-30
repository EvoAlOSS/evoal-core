package de.evoal.pipeline.api.board;

import de.evoal.core.api.board.BlackboardEntries;
import de.evoal.core.api.cdi.Commandline;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("de.evoal.pipeline.blackboard-entries")
public class PipelineBlackboardEntries implements BlackboardEntries {
    /**
     * Configuration file for the data generator.
     */
    @Commandline(main = "de.evoal.pipeline.pipeline", name = "pipeline:configuration-file", doc = "The pipeline configuration file to use.")
    public static final String PIPELINE_CONFIGURATION_FILE = "pipeline:configuration-file";
}
