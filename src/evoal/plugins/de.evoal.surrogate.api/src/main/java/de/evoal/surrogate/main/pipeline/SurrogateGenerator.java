package de.evoal.surrogate.main.pipeline;

import de.evoal.core.api.properties.Properties;
import de.evoal.core.api.properties.PropertiesSpecification;
import de.evoal.core.api.properties.PropertySpecification;
import de.evoal.core.api.utils.InitializationException;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.pipeline.api.model.ComponentImpl;
import de.evoal.pipeline.api.model.TypedEObject;
import de.evoal.pipeline.api.model.dynamic.EAnnotationHelper;
import de.evoal.pipeline.api.model.dynamic.SubSpace;
import de.evoal.surrogate.api.function.SurrogateFunction;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EStructuralFeature;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

@Dependent
@Named("de.evoal.surrogate.pipeline.surrogate")
@Slf4j
public class SurrogateGenerator extends ComponentImpl {

    @Inject
    private EAnnotationHelper helper;
    @Inject
    private SurrogateFunction function;

    private PropertiesSpecification inputSpecification;
    private PropertiesSpecification outputSpecification;

    private Map<PropertySpecification, EStructuralFeature> propertyToFeature = new HashMap<>();
    private Map<EStructuralFeature, PropertySpecification> featureToProperty = new HashMap<>();

    @Override
    public ComponentImpl init(final Instance configuration) throws InitializationException {
        this.inputSpecification = function.getInputSpecification();
        this.outputSpecification = function.getOutputSpecification();

        addToMappings(getReads());
        addToMappings(getWrites());

        return super.init(configuration);
    }

    private void addToMappings(final SubSpace features) {
        for(final EStructuralFeature feature : features) {
            final PropertySpecification specification = toSpecification(feature);

            propertyToFeature.put(specification, feature);
            featureToProperty.put(feature, specification);
        }

    }

    private PropertySpecification toSpecification(final EStructuralFeature feature) {
        log.info("Converting {} to property specification.", feature.getName());
        log.info("  Annotations are {}", feature.getEAnnotations());
        EAnnotation ann = feature.getEAnnotations().get(0);
        log.info("    source is {}", ann.getSource());
        log.info("    contents is {}", ann.getContents());
        final DataDescription description = helper.dataDescriptionOf(feature).get();

        return new PropertySpecification(description.getName(), description);
    }

    @Override
    public @NonNull TypedEObject apply(final @NonNull TypedEObject object) {
        final Properties in = new Properties(inputSpecification);
        copyInProperties(object, in);

        final Properties out = function.apply(in);
        copyOutProperties(out, object);

        return object;
    }

    private void copyOutProperties(final Properties source, final TypedEObject target) {
        for(final EStructuralFeature feature : getWrites()) {
            final PropertySpecification property = featureToProperty.get(feature);

            final Object data = source.get(property);
            target.eSet(feature, data);
        }
    }

    private void copyInProperties(final TypedEObject source, final Properties target) {
        for(final EStructuralFeature feature : getReads()) {
            final PropertySpecification property = featureToProperty.get(feature);

            final Object data = source.eGet(feature);
            target.put(property, data);
        }
    }

}
