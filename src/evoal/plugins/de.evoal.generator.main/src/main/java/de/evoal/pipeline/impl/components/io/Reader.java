package de.evoal.pipeline.impl.components.io;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.properties.stream.FileBasedPropertiesStreamSupplier;
import de.evoal.core.api.utils.AttributeHelper;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.core.api.utils.Requirements;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dynamic.DynamicPackage;
import de.evoal.pipeline.api.model.ComponentImpl;
import de.evoal.pipeline.api.model.TypedEObject;
import de.evoal.pipeline.api.model.dynamic.SubSpace;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.File;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

@Dependent
@Slf4j
@Named("de.evoal.pipeline.io.reader")
public class Reader extends ComponentImpl {
    private Function<Properties, Object> [] converters;

    private EStructuralFeature [] features;

    @Inject
    private AttributeHelper helper;

    private Iterator<Properties> iterator;

    private PropertySpecification [] pSpec;


    @Override
    public @NonNull TypedEObject apply(@NonNull TypedEObject object) {
        if(!iterator.hasNext()) {
            throw new IllegalStateException("Iterator is empty");
        }

        final Properties p = iterator.next();

        for(int i = 0; i < pSpec.length; i++) {
            object.eSet(features[i], converters[i].apply(p));
        }

        return object;
    }

    @Override
    public ComponentImpl init(final Instance configuration) throws InitializationException {
        super.init(configuration);

        final String filename = helper.lookup(configuration, "filename");
        final File file = new File(filename);

        log.info("Reading data from {}", file.getAbsolutePath());

        final SubSpace writes = getWrites();

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

        final List<Function<Properties, Object>> inputConverts = new LinkedList<>();

        for(int i = 0; i < features.length; ++i) {
            final PropertySpecification spec = specification.getProperties().get(i);

            Requirements.requireInstanceOf(spec.type(), BaseDataDescription.class);
            final BaseDataDescription bdd = (BaseDataDescription) spec.type();

            inputConverts.add(toConverter(features[i], i));
        }

        converters = inputConverts.toArray(new Function[0]);
        Requirements.requireSameSize(pSpec, converters);


        iterator = new FileBasedPropertiesStreamSupplier(file, specification)
                .get()
                .iterator();

        return this;
    }

    private final static EcorePackage ePackage = EcorePackage.eINSTANCE;
    private Function<Properties, Object> toConverter(final EStructuralFeature feature, final int index) {
        final EClassifier classifier = feature.getEType();

        if(ePackage.getEDouble().equals(classifier)) {
            return p -> ((Number)p.get(index)).doubleValue();
        } else if(ePackage.getEInt().equals(classifier)) {
            return p -> ((Number)p.get(index)).intValue();
        } else if(ePackage.getEBoolean().equals(classifier)) {
            return p -> ((Number)p.get(index)).intValue() != 0;
        } else if(ePackage.getEString().equals(classifier)) {
            return p -> Objects.toString(p.get(index));
        }

        throw new UnsupportedOperationException("Not yet implemented: " +classifier.getName());
    }
}
