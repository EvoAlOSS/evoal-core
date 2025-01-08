package de.evoal.pipeline.api.cdi;

import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.languages.model.generator.PipelineDefinition;
import de.evoal.pipeline.impl.internal.NamedPipeline;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.Dependent;
import java.util.Collection;
import java.util.Collections;

@Dependent
@Slf4j
public class PipelineCollector {

    public  @NonNull Collection<NamedPipeline> convert(final GeneratorModule module) {
        return module.getPipelines()
                     .stream()
                     .map(this::toPipeline)
                     .toList();
    }

    private @NonNull NamedPipeline toPipeline(final PipelineDefinition definition) {
        return new NamedPipeline(definition.getName(), Collections.unmodifiableList(definition.getSteps()));
    }
}
