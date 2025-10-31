package de.evoal.surrogate.api.io.pson;

import com.fasterxml.jackson.databind.module.SimpleModule;
import de.evoal.core.api.ecore.Space;
import de.evoal.languages.model.pipeline.PipelineDefinition;
import de.evoal.pipeline.api.cdi.DefinitionModuleLoader;
import de.evoal.surrogate.api.io.ModelStorage;
import de.evoal.surrogate.main.jackson.PipelineDeserializer;
import de.evoal.surrogate.main.jackson.PipelineSerializer;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Optional;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import com.fasterxml.jackson.databind.ObjectMapper;

@Dependent
@Named("pson")
@Slf4j
public class PSONModelStorage implements ModelStorage {
    @Getter
    private Optional<SurrogateConfiguration> configuration = Optional.empty();

    private File file;

    @Getter
    private Space inputSpace;

    @Inject
    private DefinitionModuleLoader loader;

    @Getter
    private Space outputSpace;

    @SneakyThrows
    public void store(final SurrogateConfiguration configuration) {
        log.info("Storing predictive configuration from {}.", file);

        final PipelineSerializer serializer = new PipelineSerializer();
        final SimpleModule module = new SimpleModule();
        module.addSerializer(PipelineDefinition.class, serializer);

        new ObjectMapper()
                .registerModule(module)
                .writerWithDefaultPrettyPrinter()
                .writeValue(file, configuration);
    }

    @Override
    public String getStorageExtension() {
        return "pson";
    }

    @Override
    public ModelStorage setLocation(final URI location) {
        this.file = new File(location.getPath());

        return this;
    }

    @Override
    public ModelStorage setSpaces(final Space inputSpace, final Space outputSpace) {
        this.inputSpace = inputSpace;
        this.outputSpace = outputSpace;

        return this;
    }

    @SneakyThrows
    public void load() {
        try(final InputStream is = new FileInputStream(file)) {
            final Space functionSpace = inputSpace.merge(outputSpace);
            final PipelineDeserializer serializer = new PipelineDeserializer(loader, functionSpace);
            final SimpleModule module = new SimpleModule();
            module.addDeserializer(PipelineDefinition.class, serializer);

            final SurrogateConfiguration configuration =
                    new ObjectMapper()
                        .registerModule(module)
                        .readValue(is, SurrogateConfiguration.class);

            this.configuration = Optional.of(configuration);
        } catch (final IOException e) {
            log.error("Failed to load predictive configuration from {}.", file, e);

            throw new IllegalStateException("Failed to load predictive configuration from " + file);
        }
    }

    @Override
    public String getModelName() {
        load();
        return configuration.get().getName();
    }
}
