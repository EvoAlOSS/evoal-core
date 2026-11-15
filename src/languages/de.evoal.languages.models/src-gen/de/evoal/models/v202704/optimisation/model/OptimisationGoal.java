/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.model;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optimisation Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * An optimisation goal.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.OptimisationGoal#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getOptimisationGoal()
 * @model abstract="true"
 * @generated
 */
public interface OptimisationGoal extends EObject {
	/**
	 * Returns the value of the '<em><b>Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The data to optimise.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Data</em>' reference.
	 * @see #setData(EStructuralFeature)
	 * @see de.evoal.models.v202704.optimisation.model.ModelPackage#getOptimisationGoal_Data()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getData();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.model.OptimisationGoal#getData <em>Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(EStructuralFeature value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Returns the optimisation direction
	 * 
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Direction getDirection();

} // OptimisationGoal
