package de.evoal.optimisation.ea.main.operators;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.evoal.core.api.languages.AttributeEvaluator;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.expressions.Attribute;
import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.dynamic.ClassMapping;
import de.evoal.languages.model.dynamic.DynamicPackage;

import de.evoal.optimisation.ea.api.genotype.MeasurementScale;
import de.evoal.optimisation.ea.api.genotype.Representation;
import de.evoal.optimisation.ea.api.operators.Applicability;

/**
 * Reads the DL annotation {@code @Applicability} of an operator type. The DL is the only
 *   place where the applicability of an operator is stated.
 */
@ApplicationScoped
public class ApplicabilityReader {
    /**
     * The name of the annotation type.
     */
    private static final String ANNOTATION = "Applicability";

    @Inject
    private AttributeEvaluator evaluator;

    /**
     * @param definition The DL type of an operator.
     * @return The applicability of the type or of its nearest super type that declares one.
     * @throws IllegalStateException if no type declares one.
     */
    public Applicability of(final ClassDefinition definition) {
        for(ClassDefinition type = definition; type != null; type = type.getSuperType()) {
            final Optional<Instance> annotation = type.getConstraints()
                                                      .stream()
                                                      .filter(Instance.class::isInstance)
                                                      .map(Instance.class::cast)
                                                      .filter(instance -> ANNOTATION.equals(instance.getDefinition().getName()))
                                                      .findFirst();
            if(annotation.isPresent()) {
                return toApplicability(annotation.get());
            }
        }

        throw new IllegalStateException("The operator type '" + definition.getName() + "' has no @" + ANNOTATION + ".");
    }

    /**
     * @param configuration The configuration of an operator.
     * @return The applicability of the operator's DL type.
     */
    public Applicability of(final EObject configuration) {
        return of(definitionOf(configuration.eClass()));
    }

    /**
     * @param module A type of the DL module that declares the operator type.
     * @param name The name of the operator type, e.g. {@code sbx-crossover}.
     * @return The applicability of the operator type.
     * @throws IllegalStateException if the module has no such type.
     */
    public Applicability of(final ClassDefinition module, final String name) {
        final EObject container = module.eContainer();
        final Iterator<EObject> contents = container.eAllContents();
        while(contents.hasNext()) {
            if(contents.next() instanceof ClassDefinition definition && name.equals(definition.getName())) {
                return of(definition);
            }
        }

        throw new IllegalStateException("The DL module has no type '" + name + "'.");
    }

    /**
     * @return The DL type that the dynamic class of a configuration was created from.
     * @throws IllegalStateException if the class was not created from a DL type.
     */
    public static ClassDefinition definitionOf(final EClass eClass) {
        final EAnnotation annotation = eClass.getEAnnotation(DynamicPackage.eNS_URI);
        if(annotation != null) {
            for(final EObject content : annotation.getContents()) {
                if(content instanceof ClassMapping mapping) {
                    return mapping.getSource();
                }
            }
        }

        throw new IllegalStateException("The class '" + eClass.getName() + "' was not created from a DL type.");
    }

    private Applicability toApplicability(final Instance annotation) {
        final Set<Representation> representations = EnumSet.noneOf(Representation.class);
        MeasurementScale minimum = MeasurementScale.NOMINAL;

        for(final Attribute attribute : annotation.getAttributes()) {
            final String name = attribute.getDefinition().getName();
            final Object value = evaluate(attribute.getValue());

            switch(name) {
                case "representations" -> elements(value).forEach(element -> representations.add(Representation.of(literalName(element))));
                case "minimum-scale" -> minimum = MeasurementScale.of(literalName(value));
                default -> throw new IllegalStateException("Unknown attribute '" + name + "' of @" + ANNOTATION + ".");
            }
        }

        return new Applicability(representations, minimum);
    }

    @SuppressWarnings("deprecation")
    private Object evaluate(final Expression expression) {
        return evaluator.evaluate(expression);
    }

    private static List<?> elements(final Object value) {
        if(value instanceof Collection<?> collection) {
            return List.copyOf(collection);
        }
        if(value instanceof Object[] array) {
            return List.of(array);
        }

        return List.of(value);
    }

    /**
     * @return The name of an enumeration literal, without the name of the enumeration.
     */
    private static String literalName(final Object literal) {
        final String name = switch(literal) {
            case EEnumLiteral eLiteral -> eLiteral.getName();
            case Enumerator enumerator -> enumerator.getName();
            case String text -> text;
            case EObject object -> {
                final EStructuralFeature nameFeature = object.eClass().getEStructuralFeature("name");
                if(nameFeature == null) {
                    throw new IllegalStateException("Cannot read the enumeration literal " + object + ".");
                }
                yield String.valueOf(object.eGet(nameFeature));
            }
            default -> throw new IllegalStateException("Cannot read the enumeration literal " + literal + ".");
        };

        final int dot = name.lastIndexOf('.');
        return dot < 0 ? name : name.substring(dot + 1);
    }
}
