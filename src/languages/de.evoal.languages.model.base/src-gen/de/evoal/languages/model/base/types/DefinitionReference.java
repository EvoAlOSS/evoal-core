/**
 */
package de.evoal.languages.model.base.types;

import de.evoal.languages.model.base.definitions.Definition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * References to self-defined types.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.types.DefinitionReference#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.types.TypesPackage#getDefinitionReference()
 * @model
 * @generated
 */
public interface DefinitionReference extends Type {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(Definition)
	 * @see de.evoal.languages.model.base.types.TypesPackage#getDefinitionReference_Definition()
	 * @model required="true"
	 * @generated
	 */
	Definition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.types.DefinitionReference#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(Definition value);

} // DefinitionReference
