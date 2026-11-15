/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.base.types;

import de.evoal.languages.model.base.definitions.EnumDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Definition Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.types.EnumDefinitionReference#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.types.TypesPackage#getEnumDefinitionReference()
 * @model
 * @generated
 */
public interface EnumDefinitionReference extends DefinitionReference {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(EnumDefinition)
	 * @see de.evoal.languages.model.base.types.TypesPackage#getEnumDefinitionReference_Definition()
	 * @model required="true"
	 * @generated
	 */
	EnumDefinition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.types.EnumDefinitionReference#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(EnumDefinition value);

} // EnumDefinitionReference
