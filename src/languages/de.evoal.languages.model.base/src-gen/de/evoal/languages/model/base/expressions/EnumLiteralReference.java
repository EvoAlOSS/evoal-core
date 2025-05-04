/**
 */
package de.evoal.languages.model.base.expressions;

import de.evoal.languages.model.base.definitions.EnumLiteralDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.EnumLiteralReference#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getEnumLiteralReference()
 * @model
 * @generated
 */
public interface EnumLiteralReference extends ValueReference {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(EnumLiteralDefinition)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getEnumLiteralReference_Definition()
	 * @model
	 * @generated
	 */
	EnumLiteralDefinition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.EnumLiteralReference#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(EnumLiteralDefinition value);

} // EnumLiteralReference
