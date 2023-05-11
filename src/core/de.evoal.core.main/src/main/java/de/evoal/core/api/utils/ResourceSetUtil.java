package de.evoal.core.api.utils;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;

import javax.enterprise.context.ApplicationScoped;

/**
 * Helper
 */
@Slf4j
@ApplicationScoped
public class ResourceSetUtil {
    public void checkResourceErrors(final @NonNull ResourceSet rs) throws EvoalIOException {
        log.info("Checking resource set for warnings and errors.");

        // first we try to resolve all proxies if it wasn't done so far
        rs.getResources()
          .forEach(EcoreUtil::resolveAll);

        boolean errorInResource = false;

        // check individual files for errors and warning
        for(final Resource resource : rs.getResources()) {
            log.info("Resource '{}' is loaded: {}.", resource.getURI(), resource.isLoaded());

            if(!resource.getErrors().isEmpty()) {
                errorInResource = true;

                for(Resource.Diagnostic diagnostic : resource.getErrors()) {
                    log.error("  error in resource: {}", diagnostic);
                }
            }

            if(!resource.getWarnings().isEmpty()) {
                for(Resource.Diagnostic diagnostic : resource.getWarnings()) {
                    log.warn("  warning in resource: {}", diagnostic);
                }
            }
        }

        if(errorInResource) {
            throw new EvoalIOException("One of the loaded DSL files contains an error. Please check the log for details.");
        }
    }
}
