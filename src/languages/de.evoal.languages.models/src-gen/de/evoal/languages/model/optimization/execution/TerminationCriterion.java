/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.execution;

import de.evoal.languages.model.optimization.memory.Iteration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Termination Criterion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * The algorithm's termination criterion. It checks, based on the current
 *   iteration, if the algorithm should stop.
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see de.evoal.languages.model.optimization.execution.ExecutionPackage#getTerminationCriterion()
 * @model
 * @generated
 */
public interface TerminationCriterion extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Checks if the algorithm should terminate.
	 * 
	 * @param iteration The iteration to check.
	 * 
	 * @return <code>true</code> iff the algorithm should terminate.
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true" iterationRequired="true"
	 * @generated
	 */
	boolean shouldTerminate(Iteration iteration);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Negation of the method {@link #shouldTerminate}.
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true" iterationRequired="true"
	 * @generated
	 */
	boolean shouldContinue(Iteration iteration);

} // TerminationCriterion
