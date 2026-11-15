/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.base.types;

import de.evoal.languages.model.base.definitions.ClassDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Definition Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.types.ClassDefinitionReference#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.types.TypesPackage#getClassDefinitionReference()
 * @model
 * @generated
 */
public interface ClassDefinitionReference extends DefinitionReference {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(ClassDefinition)
	 * @see de.evoal.languages.model.base.types.TypesPackage#getClassDefinitionReference_Definition()
	 * @model required="true"
	 * @generated
	 */
	ClassDefinition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.types.ClassDefinitionReference#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(ClassDefinition value);

} // ClassDefinitionReference
