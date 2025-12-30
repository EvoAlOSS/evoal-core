package de.evoal.optimisation.main.producer;

import com.google.inject.Injector;
import de.evoal.core.api.board.Blackboard;
import de.evoal.core.api.languages.ModuleLoaderBase;
import jakarta.enterprise.context.ApplicationScoped;

import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.ddl.impl.DdlPackageImpl;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.dl.impl.DlPackageImpl;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.languages.model.ol.dsl.OptimisationLanguageStandaloneSetup;
import de.evoal.languages.model.ol.impl.OLPackageImpl;
import de.evoal.optimisation.api.board.OptimisationBlackboardEntries;
import jakarta.enterprise.inject.Produces;
import org.eclipse.emf.ecore.resource.Resource;

import java.util.*;

@ApplicationScoped
public class OptimisationModuleLoader extends ModuleLoaderBase<OptimisationModule> {
    @Override
    protected void initializeEMF() {
        OLPackageImpl.init();
        DlPackageImpl.init();
        DdlPackageImpl.init();

        OptimisationLanguageStandaloneSetup.doSetup();
        DefinitionLanguageStandaloneSetup.doSetup();
        DataDescriptionLanguageStandaloneSetup.doSetup();

    }

    @Override
    protected Injector setupInjector() {
        final Injector injector = new OptimisationLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();

        // do not remove the following line even if the injector is not used. Otherwise, parsing ol files breaks.
        new DefinitionLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();

        return injector;
    }

    protected OptimisationModule toModule(final Resource resource) {
        return (OptimisationModule) resource.getContents().get(0);
    }

    @Produces
    public OptimisationModule create(final Blackboard board) {
        return board.get(OptimisationBlackboardEntries.OPTIMISATION_CONFIGURATION);
    }
}
