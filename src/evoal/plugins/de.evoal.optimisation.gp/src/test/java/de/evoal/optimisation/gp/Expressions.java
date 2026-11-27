package de.evoal.optimisation.gp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import de.evoal.core.api.dynamic.DynamicEClassProvider;
import de.evoal.core.junit.dsl.LanguageHelper;
import de.evoal.languages.model.base.Module;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.dl.DefinitionModule;

import de.evoal.optimisation.gp.api.ExpressionTypes;

/**
 * The types of a test DL module that imports the genetic programming library, and trees built
 *   from them.
 */
public final class Expressions {
    /**
     * The DL types of all loaded modules by their qualified names.
     */
    private final Map<String, ClassDefinition> definitions = new HashMap<>();

    private final DynamicEClassProvider dynamicClasses = new DynamicEClassProvider();

    /**
     * The name of the test module.
     */
    private final String module;

    /**
     * @param resource The test DL module on the class path, e.g.
     *   {@code de/evoal/optimisation/gp/test/terms.dl}.
     */
    public Expressions(final String resource) {
        final DefinitionModule loaded = LanguageHelper.loadFromClasspath(resource);
        module = loaded.getName();

        for(final Resource each : loaded.eResource().getResourceSet().getResources()) {
            each.getAllContents()
                .forEachRemaining(this::addIfType);
        }
    }

    /**
     * @return A constant of the test type with the value.
     */
    public EObject constant(final String type, final double value) {
        final EObject constant = node(test(type));
        constant.eSet(constant.eClass().getEStructuralFeature(ExpressionTypes.VALUE), value);

        return constant;
    }

    /**
     * @return The provider of the classes of the DL types.
     */
    public DynamicEClassProvider dynamicClasses() {
        return dynamicClasses;
    }

    /**
     * @return A function node of the library with its operands.
     */
    public EObject function(final String type, final EObject... operands) {
        final EObject node = node(library(type));
        final List<EReference> containments = node.eClass().getEAllContainments();
        for(int i = 0; i < operands.length; ++i) {
            node.eSet(containments.get(i), operands[i]);
        }

        return node;
    }

    /**
     * @return The class of a DL type of the library.
     */
    public EClass library(final String name) {
        return type(ExpressionTypes.MODULE + "." + name);
    }

    /**
     * @return A new object of the class.
     */
    public EObject node(final EClass type) {
        return dynamicClasses.getEObject(type);
    }

    /**
     * @return The class of a DL type of the test module.
     */
    public EClass test(final String name) {
        return type(module + "." + name);
    }

    /**
     * @return The class of the DL type with the qualified name.
     */
    public EClass type(final String qualifiedName) {
        final ClassDefinition definition = definitions.get(qualifiedName);
        if(definition == null) {
            throw new IllegalArgumentException("Unknown DL type " + qualifiedName + ", known: " + definitions.keySet());
        }

        return dynamicClasses.toEClass(definition);
    }

    /**
     * @return A variable node of the test type.
     */
    public EObject variable(final String type) {
        return node(test(type));
    }

    private void addIfType(final EObject element) {
        if(element instanceof ClassDefinition definition
           && definition.eContainer() instanceof Module owner) {
            definitions.put(owner.getName() + "." + definition.getName(), definition);
        }
    }
}
