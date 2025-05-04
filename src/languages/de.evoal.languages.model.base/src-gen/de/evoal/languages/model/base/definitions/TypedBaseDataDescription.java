/**
 */
package de.evoal.languages.model.base.definitions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Base Data Description</b></em>'.
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
 *   <li>{@link de.evoal.languages.model.base.definitions.TypedBaseDataDescription#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getTypedBaseDataDescription()
 * @model
 * @generated
 */
public interface TypedBaseDataDescription extends BaseDataDescription {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The type associated to this data description.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(DataTypeTypeDefinition)
	 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getTypedBaseDataDescription_Type()
	 * @model required="true"
	 * @generated
	 */
	DataTypeTypeDefinition getType();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.definitions.TypedBaseDataDescription#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DataTypeTypeDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the scale of the associated data type.
	 * <!-- end-model-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	ScaleType getScale();

} // TypedBaseDataDescription
