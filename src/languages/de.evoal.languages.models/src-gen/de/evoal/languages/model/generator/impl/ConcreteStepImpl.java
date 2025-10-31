/**
 * EvoAl Project
 */
package de.evoal.languages.model.generator.impl;

import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;

import de.evoal.languages.model.generator.ConcreteStep;
import de.evoal.languages.model.generator.GeneratorPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.generator.impl.ConcreteStepImpl#getInstance <em>Instance</em>}</li>
 *   <li>{@link de.evoal.languages.model.generator.impl.ConcreteStepImpl#getReads <em>Reads</em>}</li>
 *   <li>{@link de.evoal.languages.model.generator.impl.ConcreteStepImpl#getWrites <em>Writes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConcreteStepImpl extends StepImpl implements ConcreteStep {
	/**
	 * The cached value of the '{@link #getInstance() <em>Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstance()
	 * @generated
	 * @ordered
	 */
	protected Instance instance;

	/**
	 * The cached value of the '{@link #getReads() <em>Reads</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReads()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeDefinitionReference> reads;

	/**
	 * The cached value of the '{@link #getWrites() <em>Writes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWrites()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeDefinitionReference> writes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcreteStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.CONCRETE_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Instance getInstance() {
		return instance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstance(Instance newInstance, NotificationChain msgs) {
		Instance oldInstance = instance;
		instance = newInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratorPackage.CONCRETE_STEP__INSTANCE, oldInstance, newInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstance(Instance newInstance) {
		if (newInstance != instance) {
			NotificationChain msgs = null;
			if (instance != null)
				msgs = ((InternalEObject)instance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.CONCRETE_STEP__INSTANCE, null, msgs);
			if (newInstance != null)
				msgs = ((InternalEObject)newInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.CONCRETE_STEP__INSTANCE, null, msgs);
			msgs = basicSetInstance(newInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.CONCRETE_STEP__INSTANCE, newInstance, newInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypeDefinitionReference> getReads() {
		if (reads == null) {
			reads = new EObjectContainmentEList<TypeDefinitionReference>(TypeDefinitionReference.class, this, GeneratorPackage.CONCRETE_STEP__READS);
		}
		return reads;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypeDefinitionReference> getWrites() {
		if (writes == null) {
			writes = new EObjectContainmentEList<TypeDefinitionReference>(TypeDefinitionReference.class, this, GeneratorPackage.CONCRETE_STEP__WRITES);
		}
		return writes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.CONCRETE_STEP__INSTANCE:
				return basicSetInstance(null, msgs);
			case GeneratorPackage.CONCRETE_STEP__READS:
				return ((InternalEList<?>)getReads()).basicRemove(otherEnd, msgs);
			case GeneratorPackage.CONCRETE_STEP__WRITES:
				return ((InternalEList<?>)getWrites()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.CONCRETE_STEP__INSTANCE:
				return getInstance();
			case GeneratorPackage.CONCRETE_STEP__READS:
				return getReads();
			case GeneratorPackage.CONCRETE_STEP__WRITES:
				return getWrites();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GeneratorPackage.CONCRETE_STEP__INSTANCE:
				setInstance((Instance)newValue);
				return;
			case GeneratorPackage.CONCRETE_STEP__READS:
				getReads().clear();
				getReads().addAll((Collection<? extends TypeDefinitionReference>)newValue);
				return;
			case GeneratorPackage.CONCRETE_STEP__WRITES:
				getWrites().clear();
				getWrites().addAll((Collection<? extends TypeDefinitionReference>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GeneratorPackage.CONCRETE_STEP__INSTANCE:
				setInstance((Instance)null);
				return;
			case GeneratorPackage.CONCRETE_STEP__READS:
				getReads().clear();
				return;
			case GeneratorPackage.CONCRETE_STEP__WRITES:
				getWrites().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GeneratorPackage.CONCRETE_STEP__INSTANCE:
				return instance != null;
			case GeneratorPackage.CONCRETE_STEP__READS:
				return reads != null && !reads.isEmpty();
			case GeneratorPackage.CONCRETE_STEP__WRITES:
				return writes != null && !writes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConcreteStepImpl
