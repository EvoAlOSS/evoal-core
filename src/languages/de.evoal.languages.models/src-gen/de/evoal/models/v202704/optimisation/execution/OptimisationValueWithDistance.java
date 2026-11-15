/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.execution;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optimisation Value With Distance</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.evoal.models.v202704.optimisation.execution.ExecutionPackage#getOptimisationValueWithDistance()
 * @model abstract="true"
 * @generated
 */
public interface OptimisationValueWithDistance extends OptimisationValue {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Calculates the distance between two optimisation values.
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true" otherRequired="true"
	 * @generated
	 */
	double distanceFrom(OptimisationValue other);

} // OptimisationValueWithDistance
