package de.evoal.core.main.producer;

import com.google.inject.Injector;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;

import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.ol.OptimisationModel;
import de.evoal.languages.model.ol.dsl.OptimisationLanguageStandaloneSetup;
import de.evoal.languages.model.ol.impl.OLPackageImpl;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import javax.inject.Inject;
import java.io.File;

@ApplicationScoped
@Slf4j
public class EvolutionaryAlgorithmModelLoader {
    @Inject
    private Blackboard board;
    private OptimisationModel model;

    public void load(final @Observes BlackboardEntry entry) {
        if(!entry.isSame(BlackboardEntry.EA_CONFIGURATION_FILE)) {
            return;
        }

        final String configurationFileName = board.get(BlackboardEntry.EA_CONFIGURATION_FILE);
        log.info("Loading evolutionary algorithm configuration from {}.",  configurationFileName);

        final File configurationFile = new File(configurationFileName);
        if(!configurationFile.exists() || ! configurationFile.canRead()) {
            log.error("Unable to read evolutionary algorithm configuration file '{}'", configurationFileName);
            throw new IllegalArgumentException("Unable to read evolutionary algorithm configuration file: " + configurationFileName);
        }

        initializeEMF();

        final Injector ealInjector = new OptimisationLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
        // do not remove the following line even if the injector is not used. Otherwise, parsing eal files breaks.
        final Injector idlInjector = new DefinitionLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();

        final XtextResourceSet resourceSet = ealInjector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        resourceSet.addLoadOption(XtextResource.OPTION_ENCODING, "UTF-8");

        try {
            log.info("Continue by loading the EAL file.");
            final URI modelURI = URI.createFileURI(configurationFile.getAbsolutePath());

            log.info("Loading ea model from URI {}.", modelURI);

            final Resource resource = resourceSet.getResource(modelURI, true);
            resource.load(resourceSet.getLoadOptions());

            resourceSet.getResources()
                       .forEach(EcoreUtil::resolveAll);
            if(!resource.getErrors().isEmpty()) {
                for(Resource.Diagnostic diagnostic : resource.getErrors()) {
                    log.error("Error while processing rule '{}': {}", configurationFile, diagnostic);
                }
            }
            if(!resource.getWarnings().isEmpty()) {
                for(Resource.Diagnostic diagnostic : resource.getWarnings()) {
                    log.error("Warning while processing rule '{}': {}", configurationFile, diagnostic);
                }
            }

            if(!resource.getErrors().isEmpty()) {
                throw new IllegalArgumentException("EAL file contains errors. Please fix the file.");
            }

            model = (OptimisationModel) resource.getContents().get(0);
            board.bind(BlackboardEntry.EA_CONFIGURATION, model);
        } catch (final Exception e) {
            log.error("Unable to evolutionary algorithm configuration file '{}'.", configurationFile, e);
         }
    }

    /**
     * Initialize the model packages and perform the parser setup.
     */
    private void initializeEMF() {
        OLPackageImpl.init();

        OptimisationLanguageStandaloneSetup.doSetup();
        DataDescriptionLanguageStandaloneSetup.doSetup();
    }

    @Produces
    @Dependent
    public OptimisationModel getConfiguration() {
        return model;
    }
}
