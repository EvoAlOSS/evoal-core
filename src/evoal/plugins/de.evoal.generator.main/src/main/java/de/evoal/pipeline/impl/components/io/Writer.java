package de.evoal.pipeline.impl.components.io;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.io.PropertiesIOFactory;
import de.evoal.core.api.properties.io.PropertiesWriter;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.EvoalIOException;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.Definition;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.dynamic.DynamicPackage;
import de.evoal.pipeline.api.model.ComponentImpl;
import de.evoal.pipeline.api.model.TypedEObject;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.Collection;
import java.util.stream.Stream;

@Dependent
@Slf4j
@Named("de.evoal.pipeline.io.writer")
public class Writer extends ComponentImpl {
    @Inject
    private AttributeHelper helper;

    private PropertiesWriter writer;

    private PropertiesSpecification specification;

    private EStructuralFeature [] features;

    int counter = 0;
    @Override
    @SneakyThrows(EvoalIOException.class)
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        final Properties properties = new Properties(specification);

        for(int i = 0; i < features.length; i++) {
            properties.set(i, object.eGet(features[i]));
        }

        writer.add(properties);
        log.info("Adding {}", ++counter);

        return object;
    }

    @Override
    public ComponentImpl init(final Instance configuration) throws InitializationException {
        super.init(configuration);

        final String filename = helper.lookup(configuration, "filename");
        final File file = new File(filename);

        log.info("Writing data to {}", file.getAbsolutePath());
        final Collection<EStructuralFeature> reads = getReads();

        final Stream<Definition> definitions =
                reads.stream()
                    .map(ef -> ef.getEAnnotation(DynamicPackage.eNS_URI))
                    .flatMap(a -> a.getContents().stream())
                    .filter(de.evoal.languages.model.dynamic.Definition.class::isInstance)
                    .map(de.evoal.languages.model.dynamic.Definition.class::cast)
                    .map(de.evoal.languages.model.dynamic.Definition::getSource);

        specification =
                PropertiesSpecification.builder()
                        .add(definitions)
                        .build();

        features = reads.toArray(EStructuralFeature[]::new);

        try {
            writer = PropertiesIOFactory.writer(file, specification);
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
