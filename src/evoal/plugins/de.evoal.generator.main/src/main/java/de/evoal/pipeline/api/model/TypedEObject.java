package de.evoal.pipeline.api.model;

import lombok.NonNull;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;

import java.lang.reflect.InvocationTargetException;

public class TypedEObject implements EObject {
    private final EObject delegate;

    public TypedEObject(final @NonNull EObject delegate) {
        this.delegate = delegate;
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

    public Double eGetAsDouble(EStructuralFeature eStructuralFeature) {
        return ((Number)delegate.eGet(eStructuralFeature)).doubleValue();
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
}
