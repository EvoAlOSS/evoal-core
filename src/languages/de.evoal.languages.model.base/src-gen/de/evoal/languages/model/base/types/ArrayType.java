/**
 */
package de.evoal.languages.model.base.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An array type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.types.ArrayType#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.types.TypesPackage#getArrayType()
 * @model
 * @generated
 */
public interface ArrayType extends BaseType {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The allowed types of the elements.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference.
	 * @see #setElements(Type)
	 * @see de.evoal.languages.model.base.types.TypesPackage#getArrayType_Elements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Type getElements();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.types.ArrayType#getElements <em>Elements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elements</em>' containment reference.
	 * @see #getElements()
	 * @generated
	 */
	void setElements(Type value);

} // ArrayType
