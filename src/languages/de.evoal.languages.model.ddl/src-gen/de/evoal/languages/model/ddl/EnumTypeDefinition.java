/**
 */
package de.evoal.languages.model.ddl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Type Definition</b></em>'.
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
 *   <li>{@link de.evoal.languages.model.ddl.EnumTypeDefinition#getLiterals <em>Literals</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getEnumTypeDefinition()
 * @model
 * @generated
 */
public interface EnumTypeDefinition extends DataTypeDefinition {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.ddl.EnumLiteral}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * List of enum literals.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see de.evoal.languages.model.ddl.DdlPackage#getEnumTypeDefinition_Literals()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<EnumLiteral> getLiterals();

} // EnumTypeDefinition
