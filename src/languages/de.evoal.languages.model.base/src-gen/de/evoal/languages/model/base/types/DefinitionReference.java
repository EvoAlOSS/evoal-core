/**
 */
package de.evoal.languages.model.base.types;

import de.evoal.languages.model.base.definitions.TypeDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Definition Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *  * References to self-defined types.
 *  
 * <!-- end-model-doc -->
 *
 *
 * @see de.evoal.languages.model.base.types.TypesPackage#getDefinitionReference()
 * @model abstract="true"
 * @generated
 */
public interface DefinitionReference extends Type {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	TypeDefinition getDefinition();

} // DefinitionReference
