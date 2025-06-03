/**
 */
package de.evoal.languages.model.base.definitions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A enum-based type definition.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.definitions.EnumDefinition#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getEnumDefinition()
 * @model
 * @generated
 */
public interface EnumDefinition extends TypeDefinition, ScaledDefinition {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.definitions.EnumLiteralDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * List of enum literals.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getEnumDefinition_Literals()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<EnumLiteralDefinition> getLiterals();

} // EnumDefinition
