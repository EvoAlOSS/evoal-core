package de.evoal.pipeline.api.cdi;

import com.google.inject.Injector;
import de.evoal.core.api.languages.ModuleLoaderBase;
import de.evoal.languages.model.base.dsl.BaseLanguageStandaloneSetup;
import de.evoal.languages.model.base.impl.BasePackageImpl;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.ddl.impl.DdlPackageImpl;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.dl.impl.DlPackageImpl;
import de.evoal.languages.model.generator.GeneratorModule;
import de.evoal.languages.model.generator.dsl.GeneratorDSLStandaloneSetup;
import de.evoal.languages.model.generator.impl.GeneratorPackageImpl;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Loads a pipeline configuration (a {@code .generator} file) and the files it imports, and
 *   validates them like every other configuration before the pipeline runs.
 */
@ApplicationScoped
@Slf4j
public class GeneratorModuleLoader extends ModuleLoaderBase<GeneratorModule> {
    @Override
    protected Injector setupInjector() {
        return new GeneratorDSLStandaloneSetup().createInjectorAndDoEMFRegistration();
    }

    @Override
    protected GeneratorModule toModule(final Resource resource) {
        return (GeneratorModule) resource.getContents().get(0);
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
