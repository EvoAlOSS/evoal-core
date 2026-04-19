package de.evoal.core.junit.dsl;

import lombok.extern.slf4j.Slf4j;

import com.google.inject.Injector;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import de.evoal.languages.model.ddl.DdlPackage;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import de.evoal.languages.model.dl.dsl.DefinitionLanguageStandaloneSetup;
import de.evoal.languages.model.dl.impl.DlPackageImpl;
import de.evoal.languages.model.generator.GeneratorPackage;
import de.evoal.languages.model.generator.dsl.GeneratorDSLStandaloneSetup;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.dsl.MachineLearningLanguageStandaloneSetup;
import de.evoal.languages.model.ol.OLPackage;
import de.evoal.languages.model.ol.dsl.OptimisationLanguageStandaloneSetup;

@Slf4j
public final class LanguageHelper {
    private LanguageHelper() {}

    public static <T extends EObject> T loadFromClasspath(final String name) {
        initEMFandXTEXT();

        final String fileExtension = name.substring(name.lastIndexOf('.') + 1);

        return switch(fileExtension)  {
                case "ddl" -> loadFromClasspath(name, new DataDescriptionLanguageStandaloneSetup());
                case "dl" -> loadFromClasspath(name, new DefinitionLanguageStandaloneSetup());
                case "generator" -> loadFromClasspath(name, new GeneratorDSLStandaloneSetup());
                case "mll" -> loadFromClasspath(name, new MachineLearningLanguageStandaloneSetup());
                case "ol" ->  loadFromClasspath(name, new OptimisationLanguageStandaloneSetup());
                default -> null;
            };
    }

    private static void initEMFandXTEXT() {
        DdlPackage.eINSTANCE.eClass();
        DlPackageImpl.eINSTANCE.eClass();
        GeneratorPackage.eINSTANCE.eClass();
        MllPackage.eINSTANCE.eClass();
        OLPackage.eINSTANCE.eClass();

        DataDescriptionLanguageStandaloneSetup.doSetup();
        DefinitionLanguageStandaloneSetup.doSetup();
        GeneratorDSLStandaloneSetup.doSetup();
        MachineLearningLanguageStandaloneSetup.doSetup();
        OptimisationLanguageStandaloneSetup.doSetup();
    }

    private static <T extends EObject> T loadFromClasspath(final String name, final ISetup setup) {
        final Injector injector = setup.createInjectorAndDoEMFRegistration();
        final XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
        resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
        resourceSet.addLoadOption(XtextResource.OPTION_ENCODING, "UTF-8");

        try {
            final URI modelURI = URI.createURI("classpath:/" + name);
            final Resource resource = resourceSet.getResource(modelURI, true);
            resource.load(resourceSet.getLoadOptions());

            for(final Resource r : resourceSet.getResources()) {
                log.info("Checking resource {} for errors:", r.getURI());
                if (!r.getErrors().isEmpty()) {
                    for (Resource.Diagnostic diagnostic : r.getErrors()) {
                        log.error("Error while processing '{}}': {}", r.getURI(), diagnostic);
                    }
                }

                if (!r.getWarnings().isEmpty()) {
                    for (Resource.Diagnostic diagnostic : r.getWarnings()) {
                        log.warn("Warning while processing '{}': {}", r.getURI(), diagnostic);
                    }
                }
            }

            return (T) resource.getContents().get(0);
        } catch (final Exception e) {
            log.error("Unable to load model file '{}'.", name, e);
            throw new IllegalStateException();
        }
    }
}
