package de.evoal.core.main.producer;

import com.google.inject.Injector;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import de.evoal.core.api.board.CoreBlackboardEntries;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;

import de.evoal.core.api.utils.ResourceSetUtil;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.ddl.impl.DdlPackageImpl;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.dl.impl.DlPackageImpl;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.languages.model.ol.dsl.OptimisationLanguageStandaloneSetup;
import de.evoal.languages.model.ol.impl.OLPackageImpl;
import de.evoal.languages.model.utils.scoping.ClasspathGlobalScopeProvider;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import javax.inject.Inject;
import java.io.File;

@ApplicationScoped
@Slf4j
public class OptimisationModuleLoader {
    @Inject
    private Blackboard board;

    private OptimisationModule model;

    @Inject
    private ResourceSetUtil setValidation;

    public void load(final @Observes BlackboardEntry entry) {
        if(!entry.isSame(CoreBlackboardEntries.OPTIMISATION_CONFIGURATION_FILE)) {
            return;
        }

        final String configurationFileName = board.get(CoreBlackboardEntries.OPTIMISATION_CONFIGURATION_FILE);
        log.info("Loading optimisation configuration from {}.",  configurationFileName);

        final File configurationFile = new File(configurationFileName);
        if(!configurationFile.exists() || ! configurationFile.canRead()) {
            log.error("Unable to read optimisation configuration file '{}'", configurationFileName);
            throw new IllegalArgumentException("Unable to read optimisation configuration file: " + configurationFileName);
        }

        final File folder = configurationFile.getAbsoluteFile().getParentFile();
        ClasspathGlobalScopeProvider.SEARCH_PATH.add(folder.toString());
        log.info("Adding {} to search path.", folder);

        initializeEMF();

        final Injector ealInjector = new OptimisationLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
        // do not remove the following line even if the injector is not used. Otherwise, parsing ol files breaks.
        final Injector idlInjector = new DefinitionLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();

        final XtextResourceSet resourceSet = ealInjector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        resourceSet.addLoadOption(XtextResource.OPTION_ENCODING, "UTF-8");

        try {
            log.info("Continue by loading the OL file.");
            final URI modelURI = URI.createFileURI(configurationFile.getAbsolutePath());

            log.info("Loading ol model from URI {}.", modelURI);

            final Resource resource = resourceSet.getResource(modelURI, true);
            resource.load(resourceSet.getLoadOptions());

            setValidation.checkResourceErrors(resourceSet);

            model = (OptimisationModule) resource.getContents().get(0);
            board.bind(CoreBlackboardEntries.OPTIMISATION_CONFIGURATION, model);
        } catch (final Exception e) {
            log.error("Unable to load optimisation configuration file '{}'.", configurationFile, e);
         }
    }

    /**
     * Initialize the model packages and perform the parser setup.
     */
    private void initializeEMF() {
        OLPackageImpl.init();
        DlPackageImpl.init();
        DdlPackageImpl.init();

        OptimisationLanguageStandaloneSetup.doSetup();
        DefinitionLanguageStandaloneSetup.doSetup();
        DataDescriptionLanguageStandaloneSetup.doSetup();
    }

    @Produces
    @Dependent
    public OptimisationModule getConfiguration() {
        return model;
    }
}
