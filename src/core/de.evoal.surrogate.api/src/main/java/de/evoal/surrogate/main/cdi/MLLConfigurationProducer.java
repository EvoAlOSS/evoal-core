package de.evoal.surrogate.main.cdi;

import com.google.inject.Injector;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.cdi.BlackboardValue;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.ddl.impl.DdlPackageImpl;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.dl.impl.DlPackageImpl;
import de.evoal.languages.model.base.dsl.BaseLanguageStandaloneSetup;
import de.evoal.languages.model.base.impl.BasePackageImpl;
import de.evoal.languages.model.mll.dsl.MachineLearningLanguageStandaloneSetup;
import de.evoal.languages.model.mll.MachineLearningConfiguration;
import de.evoal.languages.model.mll.impl.MllPackageImpl;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.File;
import java.util.Optional;

@ApplicationScoped
@Slf4j
public class MLLConfigurationProducer {
    public void loadModel(final @Observes BlackboardEntry value, final Blackboard board) {
        if(!value.isSame(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION_FILE)) {
            return;
        }

        final String configurationFile = board.get(value.getLabel());

        log.info("Using surrogate configuration from '{}'.", configurationFile);

        initializeEMF();

        final File file = new File(configurationFile);

        if(!file.isFile()) {
            log.info("Configured surrogate configuration is a folder.");
            throw  new IllegalArgumentException("Please specify a surrogate file.");
        }

        if(!file.canRead()) {
            log.info("Configured surrogate configuration cannot be read.");
            throw  new IllegalArgumentException("Please specify a readable surrogate file.");
        }

        final MachineLearningConfiguration configuration = read(file).get();
        board.bind(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION, configuration);
    }

    /**
     * Initialize the model packages and perform the parser setup.
     */
    private void initializeEMF() {
        DdlPackageImpl.init();
        BasePackageImpl.init();
        DlPackageImpl.init();
        MllPackageImpl.init();

        DataDescriptionLanguageStandaloneSetup.doSetup();
        BaseLanguageStandaloneSetup.doSetup();
        DefinitionLanguageStandaloneSetup.doSetup();
        MachineLearningLanguageStandaloneSetup.doSetup();
    }

    /**
     * Parses the given generator file and returns the corresponding model.
     *
     * @param modelFile The model file to read.
     * @return The data validation model or an empty optional.
     */
    private Optional<MachineLearningConfiguration> read(final File modelFile) {
        log.info("Reading model file {}.", modelFile);

        final Injector injector = new MachineLearningLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
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

            return Optional.of((MachineLearningConfiguration) resource.getContents().get(0));
        } catch (final Exception e) {
            log.error("Unable to to generator file '{}'.", modelFile, e);
            return Optional.empty();
        }
    }

    @Produces @Dependent
    @BlackboardValue(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION)
    public MachineLearningConfiguration injectMachineLearningConfiguration(final InjectionPoint ip, final Blackboard board) {
        final BlackboardValue value = ip.getAnnotated().getAnnotation(BlackboardValue.class);
        final Object result = board.get(value.value());

        if(result instanceof MachineLearningConfiguration) {
            return (MachineLearningConfiguration)result;
        }

        throw new IllegalArgumentException("Unable to handle type " + result.getClass());
    }
}
