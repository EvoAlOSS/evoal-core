/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.impl;

import de.evoal.models.v202704.optimisation.OptimisationPackage;

import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stream</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class StreamImpl<T> extends MinimalEObjectImpl.Container implements Stream<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StreamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptimisationPackage.Literals.STREAM;
	}

} //StreamImpl
