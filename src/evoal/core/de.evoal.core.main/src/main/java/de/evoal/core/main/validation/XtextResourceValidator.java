package de.evoal.core.main.validation;

import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.api.validation.context.DiagnosticsContext;
import de.evoal.core.api.validation.context.ResourceContext;
import de.evoal.core.api.validation.context.XtextResourceContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.core.api.validation.model.MetaValidator;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
public class XtextResourceValidator implements MetaValidator {
    @Inject
    private Event<Diagnostics> events;

    @Override
    public int priority() {
        return 100;
    }

    @Override
    @SneakyThrows(EvoalIOException.class)
    public void validate(final @NonNull Resource resource) {
        log.info("Checking resource '{}' for parser errors and warnings.", resource.getURI());
        final DiagnosticsContext context = new ResourceContext(resource);

        // first we try to resolve all proxies if it wasn't done so far
        EcoreUtil.resolveAll(resource);

        boolean errorInResource = false;

        // check individual files for errors and warning
        log.info("Resource '{}' is loaded: {}.", resource.getURI(), resource.isLoaded());

        if(!resource.getErrors().isEmpty()) {
            errorInResource = true;

            for(Resource.Diagnostic diagnostic : resource.getErrors()) {
                log.error("Fire " + diagnostic);
                events.fire(new Diagnostics(Diagnostics.Level.Error, new XtextResourceContext(resource, diagnostic.getLine(), diagnostic.getColumn()), diagnostic.getMessage()));
            }
        }

        if(!resource.getWarnings().isEmpty()) {
            for(Resource.Diagnostic diagnostic : resource.getWarnings()) {
                log.warn("Fire " + diagnostic);
                events.fire(new Diagnostics(Diagnostics.Level.Warning, new XtextResourceContext(resource, diagnostic.getLine(), diagnostic.getColumn()), diagnostic.getMessage()));
            }
        }

        if(errorInResource) {
            throw new EvoalIOException("One of the loaded DSL files contains an error. Please check the log for details.");
        }
    }
}
