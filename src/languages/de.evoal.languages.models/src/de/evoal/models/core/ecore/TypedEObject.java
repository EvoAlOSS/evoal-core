package de.evoal.models.core.ecore;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.function.Function;

import de.evoal.languages.model.interpreter.numeric.NumericConversions;

/**
 * Enhanced EObject that allows access using EStructuralFeature and includes type casting.
 */
public class TypedEObject implements EObject {
    private final Space space;
    private final EObject delegate;

    public TypedEObject(final Space space) {
    	Objects.requireNonNull(space);
    	
        this.space = space;
        this.delegate = new DynamicEObjectImpl(space.getEClass());
    }

    public TypedEObject(final TypedEObject object) {
    	Objects.requireNonNull(object);

    	this.space = object.space;
        this.delegate = EcoreUtil.copy(object);
    }

    public Space eSpace() {
        return space;
    }

    @Override
    public EClass eClass() {
        return delegate.eClass();
    }

    @Override
    public Resource eResource() {
        return delegate.eResource();
    }

    @Override
    public EObject eContainer() {
        return delegate.eContainer();
    }

    @Override
    public EStructuralFeature eContainingFeature() {
        return delegate.eContainmentFeature();
    }

    @Override
    public EReference eContainmentFeature() {
        return delegate.eContainmentFeature();
    }

    @Override
    public EList<EObject> eContents() {
        return delegate.eContents();
    }

    @Override
    public TreeIterator<EObject> eAllContents() {
        return delegate.eAllContents();
    }

    @Override
    public boolean eIsProxy() {
        return delegate.eIsProxy();
    }

    @Override
    public EList<EObject> eCrossReferences() {
        return delegate.eCrossReferences();
    }

    @Override
    public Object eGet(EStructuralFeature eStructuralFeature) {
        return delegate.eGet(eStructuralFeature);
    }

    public Boolean eGetAsBoolean(EStructuralFeature eStructuralFeature) {
        return (Boolean)delegate.eGet(eStructuralFeature);
    }

    public Double eGetAsDouble(EStructuralFeature eStructuralFeature) {
        return convert(eStructuralFeature, NumericConversions::toDouble);
    }

    public float eGetAsFloat(EStructuralFeature eStructuralFeature) {
        return convert(eStructuralFeature, NumericConversions::toFloat);
    }

    public Integer eGetAsInteger(EStructuralFeature eStructuralFeature) {
        return convert(eStructuralFeature, NumericConversions::toInteger);
    }

    /**
     * Reads the feature and converts its value using {@link NumericConversions}.
     *
     * @throws IllegalArgumentException if the value cannot be converted without loss.
     */
    private <T> T convert(final EStructuralFeature eStructuralFeature, final Function<Object, T> conversion) {
        final Object value = delegate.eGet(eStructuralFeature);

        try {
            return conversion.apply(value);
        } catch (final IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid value of feature '" + eStructuralFeature.getName() + "': " + e.getMessage(), e);
        }
    }

    public Number eGetAsNumber(EStructuralFeature eStructuralFeature) {
        return (Number)delegate.eGet(eStructuralFeature);
    }

    public String eGetAsString(EStructuralFeature eStructuralFeature) {
        return (String)delegate.eGet(eStructuralFeature);
    }

    @Override
    public Object eGet(EStructuralFeature eStructuralFeature, boolean b) {
        return delegate.eGet(eStructuralFeature, b);
    }

    @Override
    public void eSet(EStructuralFeature eStructuralFeature, Object o) {
        delegate.eSet(eStructuralFeature, o);
    }

    @Override
    public boolean eIsSet(EStructuralFeature eStructuralFeature) {
        return delegate.eIsSet(eStructuralFeature);
    }

    @Override
    public void eUnset(EStructuralFeature eStructuralFeature) {
        delegate.eUnset(eStructuralFeature);
    }

    @Override
    public Object eInvoke(EOperation eOperation, EList<?> eList) throws InvocationTargetException {
        return delegate.eInvoke(eOperation, eList);
    }

    @Override
    public EList<Adapter> eAdapters() {
        return delegate.eAdapters();
    }

    @Override
    public boolean eDeliver() {
        return delegate.eDeliver();
    }

    @Override
    public void eSetDeliver(boolean b) {
        delegate.eSetDeliver(b);
    }

    @Override
    public void eNotify(Notification notification) {
        delegate.eNotify(notification);
    }

    public final TypedEObject copy() {
        return new TypedEObject(this);
    }
    
    @Override
    public String toString() {
    	final StringBuilder builder = new StringBuilder("[");
    	
    	boolean needsComma = false;
    	for(final EStructuralFeature feature : space) {
    		if(needsComma) {
    			builder.append(", ");
    			
    		}
    		
    		builder.append(feature.getName());
    		builder.append("=");
    		builder.append(eGet(feature));
    		
    		needsComma = true;
    	}
    	
    	
    	builder.append("]");
    	
    	return builder.toString();
    }
}
