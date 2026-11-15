package de.evoal.core.api.dynamic;

import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

import org.eclipse.emf.ecore.*;

import de.evoal.models.core.ecore.Space;
import de.evoal.languages.model.base.expressions.*;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.interpreter.numeric.NumericConversions;

@Slf4j
public abstract class ModelTransformer {
    @Inject
    private ValueConverter converter;

    @Inject
    private DynamicEClassProvider provider;

    /**
     * The space of the optimisation problem
     */
    protected Space space;

    /**
     * Registers the generated packages of the transformer before it creates its first dynamic object.
     */
    @PostConstruct
    private void registerMappedPackages() {
        mappedPackages().forEach(provider::registerPackage);
    }

    /**
     * Returns the generated packages whose classes carry DL-Mapping annotations and that are
     *   required by this transformer. They are registered at the {@link DynamicEClassProvider}.
     *
     * @return The packages to register.
     */
    protected abstract Collection<EPackage> mappedPackages();

    /**
     * Checks the configured-by annotations of the references of the given runtime model
     *   (see {@link DynamicEClassProvider#CONFIGURED_BY_SOURCE}): every object held by an
     *   annotated reference has to be an instance of the annotated DL type. The root and all
     *   its contents are checked.
     *
     * @param root The root of the runtime model.
     * @return The root.
     *
     * @throws IllegalArgumentException if a reference holds a configuration of the wrong DL type.
     */
    protected <T extends EObject> T checkConfiguredBy(final T root) {
        checkConfiguredByOf(root);
        root.eAllContents().forEachRemaining(this::checkConfiguredByOf);

        return root;
    }

    private void checkConfiguredByOf(final EObject owner) {
        for(final EReference reference : owner.eClass().getEAllReferences()) {
            final String expected = DynamicEClassProvider.findConfiguringType(reference).orElse(null);
            if(expected == null) {
                continue;
            }

            final Object value = owner.eGet(reference);
            final List<?> values = reference.isMany() ? (List<?>) value : (value == null ? List.of() : List.of(value));

            for(final Object element : values) {
                if(element instanceof EObject configuration && !DynamicEClassProvider.isInstanceOf(configuration, expected)) {
                    throw new IllegalArgumentException("'" + owner.eClass().getName() + "." + reference.getName() + "' requires a configuration of type '" + expected + "', but got '" + DynamicEClassProvider.dlTypeOf(configuration) + "'.");
                }
            }
        }
    }

    /**
     * Converts a parsed instance into a runtime object, including the default values of
     *   attributes that are not specified.
     *
     * @param instance The parsed instance.
     * @return The runtime object.
     */
    public <T> T createDynamic(final Instance instance) {
        return (T) converter.setSpace(space)
                            .setTargetType(null)
                            .convert(instance);
    }

    /**
     * Creates a runtime object for a DL type without a parsed {@link Instance}, e.g., for
     *   steps that are added during the transformation. Numeric values are converted to the
     *   type of the feature, see {@link NumericConversions}.
     *
     * @param definition The DL type to instantiate.
     * @param values Attribute values by attribute name (plain Java values, lists for arrays).
     * @return The runtime object.
     */
    public <T> T createDynamic(final ClassDefinition definition, final Map<String, ?> values) {
        final EClass clazz = provider.toEClass(definition);
        final EObject object = provider.getEObject(clazz);

        for(final Map.Entry<String, ?> entry : values.entrySet()) {
            final EStructuralFeature feature = clazz.getEStructuralFeature(entry.getKey());
            if(feature == null) {
                throw new IllegalArgumentException("Type '" + definition.getName() + "' has no attribute '" + entry.getKey() + "'.");
            }

            final Object value = NumericConversions.toType(entry.getValue(), feature.getEType());
            if(feature.isMany()) {
                final List<Object> list = (List<Object>) object.eGet(feature);
                list.clear();
                list.addAll((Collection<?>) value);
            } else {
                object.eSet(feature, value);
            }
        }

        converter.setSpace(space)
                 .applyDefaults(object, definition, values.keySet());

        return (T) object;
    }
}
