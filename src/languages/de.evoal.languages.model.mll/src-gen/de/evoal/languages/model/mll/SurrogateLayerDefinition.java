/**
 */
package de.evoal.languages.model.mll;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Surrogate Layer Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.SurrogateLayerDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.SurrogateLayerDefinition#getFunctions <em>Functions</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getSurrogateLayerDefinition()
 * @model
 * @generated
 */
public interface SurrogateLayerDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.languages.model.mll.MllPackage#getSurrogateLayerDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.SurrogateLayerDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getSurrogateLayerDefinition_Functions()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<PartialSurrogateFunctionDefinition> getFunctions();

} // SurrogateLayerDefinition
