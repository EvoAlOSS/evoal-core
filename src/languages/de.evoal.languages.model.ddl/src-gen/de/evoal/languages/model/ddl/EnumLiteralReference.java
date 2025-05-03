/**
 */
package de.evoal.languages.model.ddl;

import de.evoal.languages.model.base.Literal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ddl.EnumLiteralReference#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ddl.DdlPackage#getEnumLiteralReference()
 * @model
 * @generated
 */
public interface EnumLiteralReference extends Literal {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' reference.
	 * @see #setLiteral(EnumLiteral)
	 * @see de.evoal.languages.model.ddl.DdlPackage#getEnumLiteralReference_Literal()
	 * @model required="true"
	 * @generated
	 */
	EnumLiteral getLiteral();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ddl.EnumLiteralReference#getLiteral <em>Literal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' reference.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(EnumLiteral value);

} // EnumLiteralReference
