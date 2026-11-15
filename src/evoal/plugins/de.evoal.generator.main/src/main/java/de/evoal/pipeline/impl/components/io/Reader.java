package de.evoal.pipeline.impl.components.io;

import de.evoal.core.api.dynamic.EAnnotationHelper;
import de.evoal.core.api.ecore.stream.FileBasedEObjectStreamSupplier;
import de.evoal.pipeline.api.model.PipelineSource;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.models.core.exceptions.InitializationException;
import de.evoal.core.api.utils.Requirements;
import de.evoal.pipeline.api.model.PipelineComponentImpl;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.core.ecore.Space;

@Slf4j
@Dependent
@Named("de.evoal.pipeline.io.reader")
public class Reader extends PipelineComponentImpl implements PipelineSource {
//    private final static EcorePackage ePackage = EcorePackage.eINSTANCE;

    private Function<Properties, Object> [] converters;

    @Inject
    private EAnnotationHelper provider;

    private EStructuralFeature [] features;

    @Inject
    private AttributeHelper helper;

    private Iterator<TypedEObject> iterator;

    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        log.info("Reading data set.");

        if(!iterator.hasNext()) {
            throw new IllegalStateException("Iterator is empty");
        }

        final TypedEObject p = iterator.next();

        final Space space = getWrites();
        for(final EStructuralFeature feature : space) {
            object.eSet(feature, p.eGet(feature));
        }

        return object;
    }

    @Override
    public PipelineComponentImpl init(final EObject configuration) throws InitializationException {
        super.init(configuration);

        final String filename = helper.lookup(configuration, "filename");
        final File file = new File(filename);

        log.info("Reading data from {}", file.getAbsolutePath());
        Requirements.requireTrue(file.exists());
        Requirements.requireTrue(file.canRead());

        final Space space = getWrites();
        iterator = new FileBasedEObjectStreamSupplier(file, space)
                .get()
                .iterator();

        return this;
    }

    @Override
    public @NonNull Stream<@NonNull TypedEObject> toStream() {
        log.info("Generating data stream for space {}.", getPipelineSpace());

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED),
                false)
                .map(p -> {
                    final TypedEObject object = getPipelineSpace().newEObject();

                    final Space space = getWrites();
                    for(final EStructuralFeature feature : space) {
                        object.eSet(feature, p.eGet(feature));
                    }

                    return object;
                });
    }
}
