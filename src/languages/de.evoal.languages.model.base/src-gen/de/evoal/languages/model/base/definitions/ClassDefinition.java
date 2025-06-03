/**
 */
package de.evoal.languages.model.base.definitions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A ClassDefinition defines a dict-like structured type.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.definitions.ClassDefinition#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.definitions.ClassDefinition#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.definitions.ClassDefinition#isAbstract <em>Abstract</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getClassDefinition()
 * @model
 * @generated
 */
public interface ClassDefinition extends TypeDefinition {
	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.definitions.AttributeDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A collection of attributes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getClassDefinition_Attributes()
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
	 * @see #setSuperType(ClassDefinition)
	 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getClassDefinition_SuperType()
	 * @model
	 * @generated
	 */
	ClassDefinition getSuperType();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.definitions.ClassDefinition#getSuperType <em>Super Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Type</em>' reference.
	 * @see #getSuperType()
	 * @generated
	 */
	void setSuperType(ClassDefinition value);

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
	 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getClassDefinition_Abstract()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isAbstract();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.definitions.ClassDefinition#isAbstract <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract</em>' attribute.
	 * @see #isAbstract()
	 * @generated
	 */
	void setAbstract(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameRequired="true"
	 * @generated
	 */
	AttributeDefinition findAttribute(String name);

} // ClassDefinition
