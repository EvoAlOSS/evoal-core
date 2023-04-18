/**
 */
package de.evoal.languages.model.base;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A TypeDefinition defines a dict-like structured type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.TypeDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.TypeDefinition#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.TypeDefinition#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.TypeDefinition#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.BasePackage#getTypeDefinition()
 * @model
 * @generated
 */
public interface TypeDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of the type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.languages.model.base.BasePackage#getTypeDefinition_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.TypeDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.AttributeDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A collection of attributes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see de.evoal.languages.model.base.BasePackage#getTypeDefinition_Attributes()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AttributeDefinition> getAttributes();

	/**
	 * Returns the value of the '<em><b>Super Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A type definition may has a super type (similar to OOP).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Super Type</em>' reference.
	 * @see #setSuperType(TypeDefinition)
	 * @see de.evoal.languages.model.base.BasePackage#getTypeDefinition_SuperType()
	 * @model
	 * @generated
	 */
	TypeDefinition getSuperType();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.TypeDefinition#getSuperType <em>Super Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Type</em>' reference.
	 * @see #getSuperType()
	 * @generated
	 */
	void setSuperType(TypeDefinition value);

	/**
	 * Returns the value of the '<em><b>Abstract</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Declares this type as abstract (prevents instance creation of this type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Abstract</em>' attribute.
	 * @see #setAbstract(boolean)
	 * @see de.evoal.languages.model.base.BasePackage#getTypeDefinition_Abstract()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.TypeDefinition#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

} // TypeDefinition
