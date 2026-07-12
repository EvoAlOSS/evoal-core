/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.execution.impl;

import de.evoal.languages.model.optimization.execution.ExecutionPackage;
import de.evoal.languages.model.optimization.execution.TerminationCriterion;

import de.evoal.languages.model.optimization.memory.Iteration;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Termination Criterion</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TerminationCriterionImpl extends MinimalEObjectImpl.Container implements TerminationCriterion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TerminationCriterionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.TERMINATION_CRITERION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean shouldTerminate(Iteration iteration) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean shouldContinue(final Iteration iteration) {
		return !shouldTerminate(iteration);
		
	}

} //TerminationCriterionImpl
