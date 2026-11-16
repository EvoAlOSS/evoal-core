/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.impl;

import de.evoal.models.v202704.optimisation.OptimisationPackage;

import java.util.List;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ListImpl<T> extends MinimalEObjectImpl.Container implements List<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimisationPackage.Literals.LIST;
	}

} //ListImpl
