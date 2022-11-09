package de.evoal.core.main.cdi.producer;

import com.google.inject.Injector;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.board.BlackboardEntry;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;

import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.eal.EAModel;
import de.evoal.languages.model.eal.dsl.EvolutionaryAlgorithmLanguageStandaloneSetup;
import de.evoal.languages.model.dl.impl.DlPackageImpl;
import de.evoal.languages.model.eal.impl.EALPackageImpl;
import de.evoal.languages.model.el.dsl.ExpressionLanguageStandaloneSetup;
import de.evoal.languages.model.el.impl.ELPackageImpl;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;

@ApplicationScoped
@Slf4j
public class EvolutionaryAlgorithmModelLoader {
    @Inject
    private Blackboard board;
    private EAModel model;

    public void load(final @Observes BlackboardEntry entry) {
        if(!BlackboardEntry.EA_CONFIGURATION_FILE.equals(entry)) {
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

        final Injector ealInjector = new EvolutionaryAlgorithmLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
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

            model = (EAModel) resource.getContents().get(0);
            board.bind(BlackboardEntry.EA_CONFIGURATION, model);
        } catch (final Exception e) {
            log.error("Unable to evolutionary algorithm configuration file '{}'.", configurationFile, e);
         }
    }

    /**
     * Initialize the model packages and perform the parser setup.
     */
    private void initializeEMF() {
        EALPackageImpl.init();
        DlPackageImpl.init();
        EALPackageImpl.init();

        /*
        if (!EPackage.Registry.INSTANCE.containsKey("https://www.evoal.de/languages/idl/1.0.0")) {
            EPackage.Registry.INSTANCE.put("https://www.evoal.de/languages/idl/1.0.0", DlPackage.eINSTANCE);
        }
*/
        ExpressionLanguageStandaloneSetup.doSetup();
        DefinitionLanguageStandaloneSetup.doSetup();
        EvolutionaryAlgorithmLanguageStandaloneSetup.doSetup();
    }

    @Produces
    @Dependent
    public EAModel getConfiguration() {
        return model;
    }
}
