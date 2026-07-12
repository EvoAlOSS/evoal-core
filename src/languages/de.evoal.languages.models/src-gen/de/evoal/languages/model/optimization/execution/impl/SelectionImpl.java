/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.execution.impl;

import de.evoal.languages.model.optimization.execution.ExecutionPackage;
import de.evoal.languages.model.optimization.execution.Selection;

import de.evoal.languages.model.optimization.memory.IterationStep;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SelectionImpl extends MinimalEObjectImpl.Container implements Selection {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.SELECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IterationStep select(IterationStep input) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

} //SelectionImpl
