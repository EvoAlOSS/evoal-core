/**
 */
package de.evoal.languages.model.base;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Definition Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.InstanceDefinitionReference#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.InstanceDefinitionReference#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.BasePackage#getInstanceDefinitionReference()
 * @model
 * @generated
 */
public interface InstanceDefinitionReference extends ValueReference {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(TypeDefinition)
	 * @see de.evoal.languages.model.base.BasePackage#getInstanceDefinitionReference_Definition()
	 * @model required="true"
	 * @generated
	 */
	TypeDefinition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.InstanceDefinitionReference#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(TypeDefinition value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.languages.model.base.BasePackage#getInstanceDefinitionReference_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.InstanceDefinitionReference#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // InstanceDefinitionReference
