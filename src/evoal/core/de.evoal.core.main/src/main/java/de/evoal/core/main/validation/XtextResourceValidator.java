package de.evoal.core.main.validation;

import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.api.validation.context.XtextResourceContext;
import de.evoal.core.api.validation.model.Diagnostics;
import de.evoal.core.api.validation.model.MetaValidator;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Reports the problems that the languages find in a loaded resource: parser and linking errors,
 *   the checks of the language's Xtext validator (e.g. the module name has to match the file name,
 *   the scale rules of DDL constraints) and EMF's own checks of the model (e.g. required features).
 *   Each problem is fired as {@link Diagnostics} with the file, the line and the column. An error
 *   stops the loading with an {@link EvoalIOException}.
 */
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
        log.info("Checking resource '{}' for errors and warnings.", resource.getURI());

        // first we try to resolve all proxies if it wasn't done so far
        EcoreUtil.resolveAll(resource);

        final boolean errorInResource;
        if(resource instanceof XtextResource xtextResource) {
            errorInResource = reportIssuesOf(xtextResource);
        } else {
            errorInResource = reportDiagnosticsOf(resource);
        }

        if(errorInResource) {
            throw new EvoalIOException("One of the loaded DSL files contains an error. Please check the log for details.");
        }
    }

    /**
     * Runs all checks of the resource's language and fires its issues.
     *
     * @param resource The resource to check.
     * @return {@code true} if one of the issues is an error.
     */
    private boolean reportIssuesOf(final @NonNull XtextResource resource) {
        final IResourceValidator validator = resource.getResourceServiceProvider().getResourceValidator();
        final List<Issue> issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);

        boolean errorInResource = false;
        for(final Issue issue : issues) {
            final Optional<Diagnostics.Level> level = toLevel(issue.getSeverity());
            if(level.isEmpty()) {
                continue;
            }

            final int line = valueOrZero(issue.getLineNumber());
            final int column = valueOrZero(issue.getColumn());
            final XtextResourceContext context = new XtextResourceContext(resource, line, column);

            logIssue(level.get(), issue);
            events.fire(new Diagnostics(level.get(), context, issue.getMessage()));

            errorInResource |= Diagnostics.Level.Error.equals(level.get());
        }

        return errorInResource;
    }

    private static void logIssue(final @NonNull Diagnostics.Level level, final @NonNull Issue issue) {
        switch(level) {
            case Error -> log.error("Fire {}", issue);
            case Warning -> log.warn("Fire {}", issue);
            case Info -> log.info("Fire {}", issue);
        }
    }

    /**
     * Fires the parser errors and warnings of a resource that is not an Xtext resource.
     *
     * @param resource The resource to check.
     * @return {@code true} if the resource has an error.
     */
    private boolean reportDiagnosticsOf(final @NonNull Resource resource) {
        for(final Resource.Diagnostic diagnostic : resource.getErrors()) {
            log.error("Fire {}", diagnostic);
            final XtextResourceContext context = new XtextResourceContext(resource, diagnostic.getLine(), diagnostic.getColumn());
            events.fire(new Diagnostics(Diagnostics.Level.Error, context, diagnostic.getMessage()));
        }

        for(final Resource.Diagnostic diagnostic : resource.getWarnings()) {
            log.warn("Fire {}", diagnostic);
            final XtextResourceContext context = new XtextResourceContext(resource, diagnostic.getLine(), diagnostic.getColumn());
            events.fire(new Diagnostics(Diagnostics.Level.Warning, context, diagnostic.getMessage()));
        }

        return !resource.getErrors().isEmpty();
    }

    /**
     * Maps the severity of an Xtext issue to the level of EvoAl's diagnostics.
     *
     * @param severity The severity of the issue.
     * @return The level, or nothing for an ignored issue.
     */
    private static Optional<Diagnostics.Level> toLevel(final @NonNull Severity severity) {
        return switch(severity) {
            case ERROR -> Optional.of(Diagnostics.Level.Error);
            case WARNING -> Optional.of(Diagnostics.Level.Warning);
            case INFO -> Optional.of(Diagnostics.Level.Info);
            case IGNORE -> Optional.empty();
        };
    }

    /**
     * @param value A line or column of an issue, {@code null} if it is unknown.
     * @return The value, or {@code 0} if it is unknown.
     */
    private static int valueOrZero(final Integer value) {
        if(value == null) {
            return 0;
        }

        return value;
    }
}
