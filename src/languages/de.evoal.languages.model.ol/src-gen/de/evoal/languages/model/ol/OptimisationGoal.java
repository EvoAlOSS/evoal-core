/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

import de.evoal.languages.model.base.expressions.TypeDefinitionReference;

import org.eclipse.emf.ecore.EObject;

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
 *   <li>{@link de.evoal.languages.model.ol.OptimisationGoal#getData <em>Data</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationGoal()
 * @model abstract="true"
 * @generated
 */
public interface OptimisationGoal extends EObject {
	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The data to optimise.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Data</em>' containment reference.
	 * @see #setData(TypeDefinitionReference)
	 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationGoal_Data()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TypeDefinitionReference getData();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.OptimisationGoal#getData <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' containment reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(TypeDefinitionReference value);

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
