package de.evoal.core.arff.utils;

import de.evoal.languages.model.ddl.DataDescriptionModel;
import de.evoal.languages.model.ddl.DdlPackage;
import de.evoal.languages.model.ddl.dsl.DataDescriptionLanguageStandaloneSetup;
import lombok.NonNull;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import java.io.File;
import java.util.List;

public class LanguageUtils {

    /**
     * Loads an EMF model and returns the model instance.
     *
     * @param path Path of the model to load.
     *
     * @return A valid reference to the model
     *
     * @throws Exception If there is any problem while loading the model
     */
    public static <T extends EObject> T load(final @NonNull File path, final Class<T> cl) {
        loadPackages();
        
        final URI modelURI = URI.createFileURI(path.toString());
        return load(modelURI, cl);
    }

    private static void loadPackages() {
        DdlPackage.eINSTANCE.getName();
        DataDescriptionLanguageStandaloneSetup.doSetup();
    }

    private static <T extends EObject> T load(final URI modelURI, final Class<T> cl) {
        final ResourceSet rs = new ResourceSetImpl();
        final Resource modelResource = rs.getResource(modelURI, true);

        final List<EObject> resourceContents = modelResource.getContents();

        if(resourceContents.isEmpty()) {
            throw new RuntimeException(String.format("Resource %s is empty.", modelURI));
        }

        if(resourceContents.size() > 1) {
            throw new RuntimeException(String.format("Resource %s has to many members.", modelURI));
        }

        final EObject root = resourceContents.get(0);

        try {
            return cl.cast(root);
        } catch(final ClassCastException e) {
            throw new RuntimeException("Loaded object cannot be casted to " + cl.getName(), e);
        }
    }
}
