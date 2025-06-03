/**
 */
package de.evoal.languages.model.base.expressions;

import de.evoal.languages.model.base.definitions.LiteralDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Literal Definition Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.LiteralDefinitionReference#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getLiteralDefinitionReference()
 * @model
 * @generated
 */
public interface LiteralDefinitionReference extends ValueReference {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(LiteralDefinition)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getLiteralDefinitionReference_Definition()
	 * @model
	 * @generated
	 */
	LiteralDefinition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.LiteralDefinitionReference#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(LiteralDefinition value);

} // LiteralDefinitionReference
