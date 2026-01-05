package de.evoal.pipeline.api.cdi;

import com.google.inject.Injector;
import de.evoal.core.api.languages.ModuleLoaderBase;
import de.evoal.languages.model.base.dsl.BaseLanguageStandaloneSetup;
import de.evoal.languages.model.base.impl.BasePackageImpl;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.ddl.impl.DdlPackageImpl;
import de.evoal.languages.model.dl.DefinitionModule;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.dl.impl.DlPackageImpl;
import de.evoal.languages.model.generator.dsl.GeneratorDSLStandaloneSetup;
import de.evoal.languages.model.generator.impl.GeneratorPackageImpl;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.resource.Resource;

@ApplicationScoped
@Slf4j
public class DefinitionModuleLoader extends ModuleLoaderBase<DefinitionModule> {
    @Override
    protected Injector setupInjector() {
        return new DefinitionLanguageStandaloneSetup().createInjectorAndDoEMFRegistration();
    }

    @Override
    protected DefinitionModule toModule(Resource resource) {
        return (DefinitionModule) resource.getContents().get(0);
    }

    @Override
    protected void initializeEMF() {
        DdlPackageImpl.init();
        BasePackageImpl.init();
        DlPackageImpl.init();
        GeneratorPackageImpl.init();

        DataDescriptionLanguageStandaloneSetup.doSetup();
        BaseLanguageStandaloneSetup.doSetup();
        DefinitionLanguageStandaloneSetup.doSetup();
        GeneratorDSLStandaloneSetup.doSetup();
    }
}
