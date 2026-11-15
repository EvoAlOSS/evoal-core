/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.execution;

import de.evoal.models.core.ecore.TypedEObject;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optimisation Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * The optimisation value is an abstract type that allows comparing them.
 *   The information stored depend on the concrete implementation.
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see de.evoal.models.v202704.optimisation.execution.ExecutionPackage#getOptimisationValue()
 * @model abstract="true" superTypes="de.evoal.models.v202704.optimisation.Comparable&lt;de.evoal.models.v202704.optimisation.execution.OptimisationValue&gt;"
 * @generated
 */
public interface OptimisationValue extends EObject, Comparable<OptimisationValue> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Checks iff this value is better than the other.
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true" otherRequired="true"
	 * @generated
	 */
	boolean isBetter(OptimisationValue other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Checks iff two optimisation values are equal.
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true" otherRequired="true"
	 * @generated
	 */
	boolean isEqual(OptimisationValue other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Checks iff this value is worse than the other.
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true" otherRequired="true"
	 * @generated
	 */
	boolean isWorse(OptimisationValue other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns the optimisation space value of the optimisation value.
	 * 
	 * <!-- end-model-doc -->
	 * @model dataType="de.evoal.models.v202704.optimisation.TypedEObject" required="true"
	 * @generated
	 */
	TypedEObject toOptmisationSpace();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model type="de.evoal.models.v202704.optimisation.List&lt;org.eclipse.emf.ecore.EJavaObject&gt;" required="true" many="false"
	 * @generated
	 */
	List<Object> toStatistics();

} // OptimisationValue
