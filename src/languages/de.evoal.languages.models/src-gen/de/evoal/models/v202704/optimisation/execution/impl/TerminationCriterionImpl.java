/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.execution.impl;

import de.evoal.models.v202704.core.impl.EvoalComponentImpl;

import de.evoal.models.v202704.optimisation.execution.ExecutionPackage;
import de.evoal.models.v202704.optimisation.execution.TerminationCriterion;

import de.evoal.models.v202704.optimisation.memory.Iteration;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Termination Criterion</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class TerminationCriterionImpl extends EvoalComponentImpl<TerminationCriterion> implements TerminationCriterion {
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
