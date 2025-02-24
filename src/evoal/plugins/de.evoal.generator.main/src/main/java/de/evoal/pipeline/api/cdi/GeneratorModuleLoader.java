package de.evoal.pipeline.api.cdi;

import com.google.inject.Injector;
import de.evoal.languages.model.base.dsl.BaseLanguageStandaloneSetup;
import de.evoal.languages.model.base.impl.BasePackageImpl;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.ddl.impl.DdlPackageImpl;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.dl.impl.DlPackageImpl;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.languages.model.generator.dsl.GeneratorDSLStandaloneSetup;
import de.evoal.languages.model.generator.impl.GeneratorPackageImpl;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.File;
import java.util.Optional;

@Dependent @Slf4j
public class GeneratorModuleLoader {
    public GeneratorModule load(final @NonNull String configurationFile) {
        log.info("Using pipeline configuration from '{}'.", configurationFile);

        initializeEMF();

        final File file = new File(configurationFile);

        if(!file.isFile()) {
            log.info("Pipeline configuration is a folder.");
            throw  new IllegalArgumentException("Please specify a pipeline file.");
        }

        if(!file.canRead()) {
            log.info("Configured pipeline configuration cannot be read.");
            throw  new IllegalArgumentException("Please specify a readable pipeline file.");
        }

        return read(file).get();
    }

    /**
     * Initialize the model packages and perform the parser setup.
     */
    private void initializeEMF() {
        DdlPackageImpl.init();
        BasePackageImpl.init();
        DlPackageImpl.init();
        GeneratorPackageImpl.init();

        DataDescriptionLanguageStandaloneSetup.doSetup();
        BaseLanguageStandaloneSetup.doSetup();
        DefinitionLanguageStandaloneSetup.doSetup();
        GeneratorDSLStandaloneSetup.doSetup();
    }

    /**
     * Parses the given generator file and returns the corresponding model.
     *
     * @param modelFile The model file to read.
     * @return The data validation model or an empty optional.
     */
    private Optional<GeneratorModule> read(final File modelFile) {
        log.info("Reading model file {}.", modelFile);

        final Injector injector = new GeneratorDSLStandaloneSetup().createInjectorAndDoEMFRegistration();
        final XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        resourceSet.addLoadOption(XtextResource.OPTION_ENCODING, "UTF-8");

        try {
            final URI modelURI = URI.createFileURI(modelFile.getAbsolutePath());
            final Resource resource = resourceSet.getResource(modelURI, true);
            resource.load(resourceSet.getLoadOptions());

            if(!resource.getErrors().isEmpty()) {
                for(Resource.Diagnostic diagnostic : resource.getErrors()) {
                    log.error("Error while processing rule '{}': {}", modelFile, diagnostic);
                }
            }

            if(!resource.getWarnings().isEmpty()) {
                for(Resource.Diagnostic diagnostic : resource.getWarnings()) {
                    log.error("Warning while processing rule '{}': {}", modelFile, diagnostic);
                }
            }

            return Optional.of((GeneratorModule) resource.getContents().get(0));
        } catch (final Exception e) {
            log.error("Unable to to generator file '{}'.", modelFile, e);
            return Optional.empty();
        }
    }
}
