/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Minimise Goal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * Optimisation goal for minimisation.
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see de.evoal.languages.model.ol.OLPackage#getMinimiseGoal()
 * @model
 * @generated
 */
public interface MinimiseGoal extends OptimisationGoal {
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

} // MinimiseGoal
