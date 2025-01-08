package de.evoal.pipeline.impl.components.io;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.Definition;
import de.evoal.languages.model.base.Instance;
import de.evoal.languages.model.dynamic.DynamicPackage;
import de.evoal.pipeline.api.model.ComponentImpl;
import de.evoal.pipeline.api.model.TypedEObject;
import de.evoal.pipeline.impl.internal.DynamicAnnotationsPackage;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

@Dependent
@Slf4j
@Named("de.evoal.pipeline.io.reader")
public class Reader extends ComponentImpl {
    @Inject
    private AttributeHelper helper;

    private Iterator<Properties> iterator;

    private PropertySpecification [] pSpec;

    private EStructuralFeature [] features;

    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        if(!iterator.hasNext()) {
            throw new IllegalStateException("Iterator is empty");
        }

        final Properties p = iterator.next();

        for(int i = 0; i < pSpec.length; i++) {
            object.eSet(features[i], p.get(pSpec[i]));
        }

        return object;
    }

    @Override
    public ComponentImpl init(final Instance configuration) throws InitializationException {
        super.init(configuration);

        final String filename = helper.lookup(configuration, "filename");
        final File file = new File(filename);

        log.info("Reading data from {}", file.getAbsolutePath());
        final DynamicAnnotationsPackage daPackage = DynamicAnnotationsPackage.eINSTANCE;

        final Collection<EStructuralFeature> writes = getWrites();

        final Stream<Definition> definitions =
                writes.stream()
                        .map(ef -> ef.getEAnnotation(DynamicPackage.eNS_URI))
                        .flatMap(a -> a.getContents().stream())
                        .filter(de.evoal.languages.model.dynamic.Definition.class::isInstance)
                        .map(de.evoal.languages.model.dynamic.Definition.class::cast)
                        .map(de.evoal.languages.model.dynamic.Definition::getSource);

        final PropertiesSpecification specification =
                PropertiesSpecification.builder()
                        .add(definitions)
                        .build();

        // order should be (by construction) be the same.
        pSpec = specification.getProperties().toArray(PropertySpecification[]::new);
        features = writes.toArray(EStructuralFeature[]::new);
        Requirements.requireSameSize(pSpec, features);

        iterator = new FileBasedPropertiesStreamSupplier(file, specification)
                .get()
                .iterator();

        return this;
    }
}
