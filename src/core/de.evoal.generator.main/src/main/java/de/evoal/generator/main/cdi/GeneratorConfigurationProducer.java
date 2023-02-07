package de.evoal.generator.main.cdi;

import com.google.inject.Injector;

import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.generator.api.GeneratorBlackboardEntries;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.ddl.impl.DdlPackageImpl;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.dl.impl.DlPackageImpl;
import de.evoal.languages.model.el.dsl.ExpressionLanguageStandaloneSetup;
import de.evoal.languages.model.el.impl.ELPackageImpl;
import de.evoal.languages.model.generator.dsl.GeneratorDSLStandaloneSetup;
import de.evoal.languages.model.generator.Configuration;
import de.evoal.languages.model.generator.impl.GeneratorPackageImpl;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.File;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

@ApplicationScoped
@Slf4j
public class GeneratorConfigurationProducer {
    public void loadModel(final @Observes BlackboardEntry value, final Blackboard board) {
        if(!value.isSame(GeneratorBlackboardEntries.GENERATOR_CONFIGURATION_FILE)) {
            return;
        }

        final String configurationFile = board.get(value.getLabel());

        log.info("Using generator configuration from '{}'.", configurationFile);

        initializeEMF();

        final File file = new File(configurationFile);

        if(!file.isFile()) {
            log.info("Configured generator configuration is a folder.");
            throw  new IllegalArgumentException("Please specify a generator file.");
        }

        if(!file.canRead()) {
            log.info("Configured generator configuration cannot be read.");
            throw  new IllegalArgumentException("Please specify a readable genrator file.");
        }

        final Configuration configuration = read(file).get();
        board.bind(GeneratorBlackboardEntries.GENERATOR_CONFIGURATION, configuration);
    }

    /**
     * Initialize the model packages and perform the parser setup.
     */
    private void initializeEMF() {
        DdlPackageImpl.init();
        ELPackageImpl.init();
        DlPackageImpl.init();
        GeneratorPackageImpl.init();

        DataDescriptionLanguageStandaloneSetup.doSetup();
        ExpressionLanguageStandaloneSetup.doSetup();
        DefinitionLanguageStandaloneSetup.doSetup();
        GeneratorDSLStandaloneSetup.doSetup();
    }

    /**
     * Parses the given generator file and returns the corresponding model.
     *
     * @param modelFile The model file to read.
     * @return The data validation model or an empty optional.
     */
    private Optional<Configuration> read(final File modelFile) {
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

            return Optional.of((Configuration) resource.getContents().get(0));
        } catch (final Exception e) {
            log.error("Unable to to generator file '{}'.", modelFile, e);
            return Optional.empty();
        }
    }

    @Produces
    @BlackboardValue(GeneratorBlackboardEntries.GENERATOR_CONFIGURATION)
    public Configuration injectIntegerValue(final InjectionPoint ip, final Blackboard board) {
        final BlackboardValue value = ip.getAnnotated().getAnnotation(BlackboardValue.class);
        final Object result = board.get(value.value());

        if(result instanceof Configuration) {
            return (Configuration)result;
        }

        throw new IllegalArgumentException("Unable to handle type " + result.getClass());
    }
}
