/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.memory.impl;

import de.evoal.languages.model.optimization.memory.Execution;
import de.evoal.languages.model.optimization.memory.MemoryPackage;
import de.evoal.languages.model.optimization.memory.State;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.optimization.memory.impl.ExecutionImpl#getInputSpace <em>Input Space</em>}</li>
 *   <li>{@link de.evoal.languages.model.optimization.memory.impl.ExecutionImpl#getOutputSpace <em>Output Space</em>}</li>
 *   <li>{@link de.evoal.languages.model.optimization.memory.impl.ExecutionImpl#getStates <em>States</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExecutionImpl extends MinimalEObjectImpl.Container implements Execution {
	/**
	 * The cached value of the '{@link #getInputSpace() <em>Input Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSpace()
	 * @generated
	 * @ordered
	 */
	protected EClass inputSpace;

	/**
	 * The cached value of the '{@link #getOutputSpace() <em>Output Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputSpace()
	 * @generated
	 * @ordered
	 */
	protected EClass outputSpace;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MemoryPackage.Literals.EXECUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInputSpace() {
		if (inputSpace != null && inputSpace.eIsProxy()) {
			InternalEObject oldInputSpace = (InternalEObject)inputSpace;
			inputSpace = (EClass)eResolveProxy(oldInputSpace);
			if (inputSpace != oldInputSpace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MemoryPackage.EXECUTION__INPUT_SPACE, oldInputSpace, inputSpace));
			}
		}
		return inputSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetInputSpace() {
		return inputSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInputSpace(EClass newInputSpace) {
		EClass oldInputSpace = inputSpace;
		inputSpace = newInputSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MemoryPackage.EXECUTION__INPUT_SPACE, oldInputSpace, inputSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOutputSpace() {
		if (outputSpace != null && outputSpace.eIsProxy()) {
			InternalEObject oldOutputSpace = (InternalEObject)outputSpace;
			outputSpace = (EClass)eResolveProxy(oldOutputSpace);
			if (outputSpace != oldOutputSpace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MemoryPackage.EXECUTION__OUTPUT_SPACE, oldOutputSpace, outputSpace));
			}
		}
		return outputSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetOutputSpace() {
		return outputSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutputSpace(EClass newOutputSpace) {
		EClass oldOutputSpace = outputSpace;
		outputSpace = newOutputSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MemoryPackage.EXECUTION__OUTPUT_SPACE, oldOutputSpace, outputSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, MemoryPackage.EXECUTION__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MemoryPackage.EXECUTION__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
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
			case MemoryPackage.EXECUTION__INPUT_SPACE:
				if (resolve) return getInputSpace();
				return basicGetInputSpace();
			case MemoryPackage.EXECUTION__OUTPUT_SPACE:
				if (resolve) return getOutputSpace();
				return basicGetOutputSpace();
			case MemoryPackage.EXECUTION__STATES:
				return getStates();
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
			case MemoryPackage.EXECUTION__INPUT_SPACE:
				setInputSpace((EClass)newValue);
				return;
			case MemoryPackage.EXECUTION__OUTPUT_SPACE:
				setOutputSpace((EClass)newValue);
				return;
			case MemoryPackage.EXECUTION__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
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
			case MemoryPackage.EXECUTION__INPUT_SPACE:
				setInputSpace((EClass)null);
				return;
			case MemoryPackage.EXECUTION__OUTPUT_SPACE:
				setOutputSpace((EClass)null);
				return;
			case MemoryPackage.EXECUTION__STATES:
				getStates().clear();
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
			case MemoryPackage.EXECUTION__INPUT_SPACE:
				return inputSpace != null;
			case MemoryPackage.EXECUTION__OUTPUT_SPACE:
				return outputSpace != null;
			case MemoryPackage.EXECUTION__STATES:
				return states != null && !states.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExecutionImpl
