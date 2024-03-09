/**
 */
package de.evoal.languages.model.ddl;

import de.evoal.languages.model.base.TypeDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Structured Data Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * Representation for structured data descriptions.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.StructuredDataDescription#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getStructuredDataDescription()
 * @model
 * @generated
 */
public interface StructuredDataDescription extends DataDescription {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(TypeDefinition)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getStructuredDataDescription_Type()
	 * @model required="true"
	 * @generated
	 */
	TypeDefinition getType();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.StructuredDataDescription#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeDefinition value);

} // StructuredDataDescription
