package de.evoal.models.core.ecore;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;

/**
 * A model-space. A model-space consists of a set of 'features' and the corresponding EClass.
 */
public class Space extends LinkedHashSet<EStructuralFeature> {
    private static final long serialVersionUID = -4519644872074233221L;
    
    private final EClass eClass;

    public Space(final EClass eClass) {
        this(eClass, eClass.getEAllStructuralFeatures());
    }

    private Space(final EClass eClass, final Collection<EStructuralFeature> features) {
        super(features);
        this.eClass = eClass;
    }
    
    public EClass getEClass() {
		return eClass;
	};


    public TypedEObject newEObject() {
        return new TypedEObject(this);
    }

    /**
     * Merges two spaces.
     */
    public Space merge(final Space other) {
    	if(this.eClass == other.eClass) {
	        final Space result = new Space(eClass, this);
	        result.addAll(other);
	
	        return result;
    	} else {
    		final EClass newSpace = EcoreFactory.eINSTANCE.createEClass();
    		newSpace.setName("Subclass of " + this.eClass.getName() + " and " +  other.eClass.getName());
    		newSpace.getESuperTypes().add(this.eClass);
    		newSpace.getESuperTypes().add(other.eClass);
    		
    		this.eClass.getEPackage().getEClassifiers().add(newSpace);
    		
    		return new Space(newSpace);
    	}
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
        return new Space(eClass, features.toList());
    }

    public Optional<EStructuralFeature> find(final String name) {
        return stream()
                .filter(f -> f.getName().equals(name))
                .findFirst();
    }
}
