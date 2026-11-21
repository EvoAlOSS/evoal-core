package de.evoal.optimisation.main.constraints;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import de.evoal.core.api.languages.ModuleLoaderBase;
import de.evoal.languages.model.base.Import;
import de.evoal.languages.model.ddl.DataDescriptionModule;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.languages.model.ol.ProblemInstance;

/**
 * The DDL modules that the OL module specifying a problem imports with
 *   {@code import "data" from …;}. The {@code constraints} sections of these modules belong to
 *   the problem, in addition to those of the modules that declare its features, e.g., a module
 *   that holds only correlations estimated by a pipeline.
 */
public final class ImportedDataModules {
    /**
     * The language of a DDL import.
     */
    private static final String DATA = "data";

    private ImportedDataModules() {
    }

    /**
     * @param problem The problem of a run.
     * @return The imported DDL modules, in the order of the imports.
     * @throws IllegalArgumentException if an imported module cannot be loaded.
     */
    public static List<DataDescriptionModule> of(final ProblemInstance problem) {
        final OptimisationModule module = moduleOf(problem);
        if(module == null || module.eResource() == null) {
            return List.of();
        }

        final List<DataDescriptionModule> result = new ArrayList<>();
        for(final Import imp : module.getImports()) {
            if(DATA.equals(imp.getLanguage())) {
                result.add(load(module.eResource(), imp));
            }
        }

        return result;
    }

    private static DataDescriptionModule load(final Resource importing, final Import imp) {
        final ResourceSet resources = importing.getResourceSet();
        final String filename = "/" + imp.getFilename();

        Resource resource = resources.getResources()
                                     .stream()
                                     .filter(r -> r.getURI().toString().endsWith(filename))
                                     .findFirst()
                                     .orElse(null);
        if(resource == null) {
            try {
                resource = resources.getResource(ModuleLoaderBase.importedUri(importing, imp), true);
            } catch(final RuntimeException e) {
                throw new IllegalArgumentException("The DDL module '" + imp.getImportedNamespace() + "' imported by '"
                                                   + importing.getURI() + "' cannot be loaded.", e);
            }
        }

        if(resource == null || resource.getContents().isEmpty()
           || !(resource.getContents().getFirst() instanceof DataDescriptionModule ddl)) {
            throw new IllegalArgumentException("The DDL module '" + imp.getImportedNamespace() + "' imported by '"
                                               + importing.getURI() + "' cannot be found.");
        }

        return ddl;
    }

    private static OptimisationModule moduleOf(final ProblemInstance problem) {
        EObject current = problem;
        while(current != null && !(current instanceof OptimisationModule)) {
            current = current.eContainer();
        }

        return (OptimisationModule) current;
    }
}
