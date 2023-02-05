/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

import de.evoal.languages.model.instance.Instance;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Optimisation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ol.OptimisationModel#getUses <em>Uses</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.OptimisationModel#getInstance <em>Instance</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.OptimisationModel#getConstraints <em>Constraints</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModel()
 * @model
 * @generated
 */
public interface OptimisationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Uses</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.ol.Use}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uses</em>' containment reference list.
	 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModel_Uses()
	 * @model containment="true"
	 * @generated
	 */
	EList<Use> getUses();

	/**
	 * Returns the value of the '<em><b>Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance</em>' containment reference.
	 * @see #setInstance(Instance)
	 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModel_Instance()
	 * @model containment="true"
	 * @generated
	 */
	Instance getInstance();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.OptimisationModel#getInstance <em>Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' containment reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(Instance value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference.
	 * @see #setConstraints(Constraint)
	 * @see de.evoal.languages.model.ol.OLPackage#getOptimisationModel_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	Constraint getConstraints();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.OptimisationModel#getConstraints <em>Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraints</em>' containment reference.
	 * @see #getConstraints()
	 * @generated
	 */
	void setConstraints(Constraint value);

} // OptimisationModel
