/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.execution;

import de.evoal.models.core.cdi.EvoalComponent;

import de.evoal.models.core.ecore.TypedEObject;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optimisation Function</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.evoal.models.v202704.optimisation.execution.ExecutionPackage#getOptimisationFunction()
 * @model superTypes="de.evoal.models.v202704.core.EvoalComponent&lt;de.evoal.models.v202704.optimisation.execution.OptimisationFunction&gt;"
 *        annotation="https://evoal.de/v202610/models/core/configured-by type='de.evoal.optimisation.core.optimisation-function'"
 * @generated
 */
public interface OptimisationFunction extends EObject, EvoalComponent<OptimisationFunction> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="de.evoal.models.v202704.optimisation.TypedEObject" required="true" inputDataType="de.evoal.models.v202704.optimisation.TypedEObject" inputRequired="true"
	 * @generated
	 */
	TypedEObject evaluate(TypedEObject input);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Checks if several threads may call {@link #evaluate} at the same time. A function
	 *   that is not thread-safe is evaluated on one thread. Functions that only delegate
	 *   forward the answer of their delegate.
	 * 
	 * @return <code>true</code> iff {@link #evaluate} may be called concurrently.
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isThreadSafe();

} // OptimisationFunction
