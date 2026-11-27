package de.evoal.pipeline.api.board;

import de.evoal.core.api.board.BlackboardEntries;
import de.evoal.core.api.cdi.Commandline;
import de.evoal.pipeline.impl.PipelineRunner;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@ApplicationScoped
@Named("de.evoal.pipeline.blackboard-entries")
public class PipelineBlackboardEntries implements BlackboardEntries {
    /**
     * Configuration file for the data generator.
     */
    @Commandline(main = PipelineRunner.NAME, name = "pipeline:configuration-file", doc = "The generator file whose pipelines and write statements are run, e.g., training-data.generator.")
    public static final String PIPELINE_CONFIGURATION_FILE = "pipeline:configuration-file";
}
