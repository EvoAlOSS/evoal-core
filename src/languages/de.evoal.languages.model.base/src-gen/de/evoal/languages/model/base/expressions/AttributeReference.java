/**
 */
package de.evoal.languages.model.base.expressions;

import de.evoal.languages.model.base.definitions.AttributeDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.AttributeReference#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getAttributeReference()
 * @model
 * @generated
 */
public interface AttributeReference extends ReadExpression {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(AttributeDefinition)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getAttributeReference_Definition()
	 * @model required="true"
	 * @generated
	 */
	AttributeDefinition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.AttributeReference#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(AttributeDefinition value);

} // AttributeReference
