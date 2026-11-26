package de.evoal.pipeline.impl.components.io;

import de.evoal.core.api.ecore.io.EObjectIOFactory;
import de.evoal.core.api.ecore.io.EObjectWriter;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.stream.Stream;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.dynamic.DynamicPackage;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.ecore.Space;

@Dependent
@Slf4j
@Named("de.evoal.pipeline.io.writer")
public class Writer extends PipelineComponentImpl {
    @Inject
    private AttributeHelper helper;

    private EObjectWriter writer;

    private EStructuralFeature [] features;

    int counter = 0;
    @Override
    @SneakyThrows(EvoalIOException.class)
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        writer.add(object);
        log.info("Adding {}", ++counter);

        return object;
    }

    /**
     * Opens the file for the features of the step's {@code reads}, in their order.
     *
     * @throws InitializationException if the step reads no features (#357) or the file cannot
     *   be opened.
     */
    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        final Space reads = getReads();
        if(reads == null || reads.isEmpty()) {
            throw new InitializationException("'writer' writes the features of its 'reads'; add reads [...] to the step.");
        }

        final String filename = helper.lookup(configuration, "filename");
        final File file = new File(filename);

        log.info("Writing data to {}", file.getAbsolutePath());

        try {
            writer = EObjectIOFactory.writer(file, reads);
        } catch (final EvoalIOException e) {
            log.error("Failed to open {} for writing.", file.getAbsolutePath(), e);
            throw new InitializationException("Failed to open " + file.getAbsolutePath() + " for writing.", e);
        }

        return this;
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
