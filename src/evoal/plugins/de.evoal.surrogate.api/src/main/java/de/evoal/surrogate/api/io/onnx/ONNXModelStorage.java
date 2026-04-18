package de.evoal.surrogate.api.io.onnx;


import ai.onnxruntime.*;
import de.evoal.core.api.ecore.Space;
import de.evoal.languages.model.pipeline.PipelineDefinition;
import de.evoal.surrogate.api.io.ModelStorage;

import de.evoal.surrogate.api.io.pson.Parameter;
import de.evoal.surrogate.api.io.pson.SurrogateConfiguration;
import de.evoal.surrogate.main.jackson.ParameterSerializer;
import de.evoal.surrogate.main.jackson.PipelineSerializer;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import ai.onnxruntime.OrtSession;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Optional;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;
import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.cfg.MapperBuilder;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.databind.module.SimpleModule;


@Dependent
@Named("onnx")
//@Default // Okay I have to admit I asked chat here, but it seems like beanManager.getBeans(Bla.class).stream().filter(b -> b.getName().equals("onnx")) would fail if we aren't also a default bean I am not exactly sure why
@Slf4j
public class ONNXModelStorage implements ModelStorage {

    @Getter
    private Optional<SurrogateConfiguration> configuration = Optional.empty();

    @Getter
    private Optional<OrtSession> session=Optional.empty();

    private File file;

/*
    @Inject
    private DefinitionModuleLoader loader;
*/

    @Getter
    private Space outputSpace;

    @Getter
    private Space inputSpace;

    @Override
    public Space getInputSpace() {
        return this.inputSpace;
    }

    @SneakyThrows
    public void store(SurrogateConfiguration configuration, final OrtSession ortSession) {
        log.info("Storing predictive configuration from {}.", file);

        final SimpleModule module = new SimpleModule();
        module.addSerializer(PipelineDefinition.class, new PipelineSerializer());
        module.addSerializer(Parameter.class, new ParameterSerializer());

        JsonMapper.builder()
                .addModule(module)
                .build()
                .writeValue(file, configuration);

        this.session = Optional.of(ortSession);

    }

    @SneakyThrows
    public void load() throws IOException, OrtException
    {

        OrtEnvironment env = OrtEnvironment.getEnvironment();
        OrtSession session = env.createSession(file.getPath());
        this.session = Optional.of(session);
    }

    @Override
    public String getModelName() {
        String modelName = null;
        /*try
        {
            log.info("getModelName --> Loading onnx model from {}.",file.toString());
            load();
            log.info("getModelName --> Loaded onnx model from {}.",file.toString());
            modelName=session.get().getMetadata().getGraphName();
            log.info("getModelName --> Model Name is now: {}",modelName);

        }catch (Exception e){log.error(e.getMessage());}
        log.info("getModelName --> Catch --> Model Name is now: {}",modelName);*/
        //let's try something: //ToDo: Fix this
        modelName="de.evoal.surrogate.api.ml.general-onnx";
        return modelName;
    }

    @Override
    public String getStorageExtension() {
        return "onnx";
    }

    @Override
    public ModelStorage setLocation(URI location) {
        this.file = new File(location.getPath());

        return this;
    }

    @Override
    public ModelStorage setSpaces(Space inputSpace, Space outputSpace) {
        log.info("setSpaces:inputSpace:{}, outputSpace{}",inputSpace.toString(),outputSpace.toString());
        this.inputSpace=inputSpace;
        this.outputSpace=outputSpace;
        log.info("setSpaces:inputSpace:{}, outputSpace{}",this.inputSpace.toString(),this.outputSpace.toString());

        return this;
    }

}