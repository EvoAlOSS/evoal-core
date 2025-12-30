package de.evoal.surrogate.main.cdi;

import com.google.inject.Injector;
import de.evoal.core.api.languages.ModuleLoaderBase;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.ddl.impl.DdlPackageImpl;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.mll.dsl.MachineLearningLanguageStandaloneSetup;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.mll.impl.MllPackageImpl;
import de.evoal.surrogate.api.SurrogateBlackboardEntries;
import org.eclipse.emf.ecore.resource.Resource;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class MachineLearningModuleLoader extends ModuleLoaderBase<MachineLearningModule> {

    public MachineLearningModule load() {
        final String configurationFileName = board.get(SurrogateBlackboardEntries.SURROGATE_CONFIGURATION_FILE);

        return load(configurationFileName);
    }

    @Override
    protected void initializeEMF() {
        MllPackageImpl.init();
        DdlPackageImpl.init();

        MachineLearningLanguageStandaloneSetup.doSetup();
        DataDescriptionLanguageStandaloneSetup.doSetup();
    }

    @Override
    protected Injector setupInjector() {
        final Injector injector = new MachineLearningLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();

        new DataDescriptionLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
        new DefinitionLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();

        return injector;
    }

    protected MachineLearningModule toModule(final Resource resource) {
        return (MachineLearningModule) resource.getContents().get(0);
    }
}
