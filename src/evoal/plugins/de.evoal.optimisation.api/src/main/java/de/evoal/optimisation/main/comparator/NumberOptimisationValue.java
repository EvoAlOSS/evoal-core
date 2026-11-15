package de.evoal.optimisation.main.comparator;

import de.evoal.languages.model.interpreter.numeric.ArithmeticNumberOperations;
import de.evoal.models.core.ecore.TypedEObject;
import de.evoal.models.v202704.optimisation.execution.OptimisationValue;
import de.evoal.models.v202704.optimisation.execution.OptimisationValueWithDistance;
import lombok.NonNull;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

abstract class NumberOptimisationValue extends Number implements OptimisationValueWithDistance {
    protected final NumberOptimisationValueImpl delegate ;

    protected NumberOptimisationValue(final NumberOptimisationValueImpl delegate) {
        this.delegate = delegate;
    }

    public Number getFitnessValue() {
        return delegate.fitnessValue;
    }

    @Override
    public int compareTo(final @NonNull OptimisationValue other) {
        return delegate.compareTo(other);
    }

    @Override
    public List<Object> toStatistics() {
        return Collections.singletonList(delegate.fitnessValue);
    }

    @Override
    public boolean isBetter(OptimisationValue other) {
        return delegate.isBetter(other);
    }

    @Override
    public boolean isEqual(OptimisationValue other) {
        return delegate.isEqual(other);
    }

    @Override
    public boolean isWorse(OptimisationValue other) {
        return delegate.isWorse(other);
    }

    @Override
    public TypedEObject toOptmisationSpace() {
        return delegate.optimisationSpaceValue;
    }

    @Override
    public double distanceFrom(final @NonNull OptimisationValue other) {
        if(!(other instanceof NumberOptimisationValue otherNumeric)) {
            throw new IllegalArgumentException("Only allowed to compare NumericOptimisationValue");
        }

        final Number distance = ArithmeticNumberOperations.minus(this.delegate.fitnessValue, otherNumeric.delegate.fitnessValue);
        return ArithmeticNumberOperations.abs(distance).doubleValue();
    }

    @Override
    public int intValue() {
        return delegate.fitnessValue.intValue();
    }

    @Override
    public long longValue() {
        return delegate.fitnessValue.longValue();
    }

    @Override
    public float floatValue() {
        return delegate.fitnessValue.floatValue();
    }

    @Override
    public double doubleValue() {
        return delegate.fitnessValue.doubleValue();
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
        return delegate.eContainingFeature();
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
    public Object eGet(EStructuralFeature feature) {
        return delegate.eGet(feature);
    }

    @Override
    public Object eGet(EStructuralFeature feature, boolean resolve) {
        return delegate.eGet(feature, resolve);
    }

    @Override
    public void eSet(EStructuralFeature feature, Object newValue) {
        delegate.eSet(feature, newValue);
    }

    @Override
    public boolean eIsSet(EStructuralFeature feature) {
        return delegate.eIsSet(feature);
    }

    @Override
    public void eUnset(EStructuralFeature feature) {
        delegate.eUnset(feature);
    }

    @Override
    public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
        return delegate.eInvoke(operation, arguments);
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
    public void eSetDeliver(boolean deliver) {
        delegate.eSetDeliver(deliver);
    }

    @Override
    public void eNotify(Notification notification) {
        delegate.eNotify(notification);
    }
}
