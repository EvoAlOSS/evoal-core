/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.memory.impl;

import de.evoal.languages.model.optimization.memory.MemoryPackage;
import de.evoal.languages.model.optimization.memory.State;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class StateImpl extends MinimalEObjectImpl.Container implements State {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MemoryPackage.Literals.STATE;
	}

} //StateImpl
