package de.evoal.core.api.ecore;

import de.evoal.core.api.utils.Requirements;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A model-space. A model-space consists of a set of 'features' and the corresponding EClass.
 */
@Slf4j
public class Space extends LinkedHashSet<EStructuralFeature> {
    @Getter
    private final EClass eClass;

    public Space(final EClass eClass) {
        this(eClass, eClass.getEAllStructuralFeatures());
    }

    private Space(final EClass eClass, final Collection<EStructuralFeature> features) {
        super(features);
        this.eClass = eClass;
    }

    public TypedEObject newEObject() {
        return new TypedEObject(eClass);
    }

    /**
     * Merges two spaces.
     *
     * @precondition this.eClass == other.eClass
     */
    public Space merge(final Space other) {
        Requirements.requireEqual(this.eClass, other.eClass);


        final Space result = new Space(eClass, this);
        result.addAll(other);

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Space '")
                .append(eClass.getName())
                .append("' [");
        for (EStructuralFeature feature : this) {
            builder.append(feature.getName())
                   .append(", ");
        }
        builder.append("]");

        return builder.toString();
    }

    public Space subSpace(final Collection<EStructuralFeature> features) {
        return new Space(eClass, features);
    }

    public Space subSpace(final Stream<EStructuralFeature> features) {
        return new Space(eClass, features.collect(Collectors.toUnmodifiableList()));
    }
}
