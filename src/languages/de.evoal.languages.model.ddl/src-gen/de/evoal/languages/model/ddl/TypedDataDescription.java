/**
 */
package de.evoal.languages.model.ddl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Data Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A typed data description.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.TypedDataDescription#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getTypedDataDescription()
 * @model
 * @generated
 */
public interface TypedDataDescription extends DataDescription {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type associated to this data description.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(DataTypeDefinition)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getTypedDataDescription_Type()
	 * @model required="true"
	 * @generated
	 */
	DataTypeDefinition getType();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.TypedDataDescription#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DataTypeDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the scale of the associated data type.
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	ScaleType getScale();

} // TypedDataDescription
