/**
 */
package de.evoal.languages.model.base.expressions;

import de.evoal.languages.model.base.definitions.ValueDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Definition Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.ValueDefinitionReference#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getValueDefinitionReference()
 * @model
 * @generated
 */
public interface ValueDefinitionReference extends ValueReference {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(ValueDefinition)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getValueDefinitionReference_Definition()
	 * @model required="true"
	 * @generated
	 */
	ValueDefinition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.ValueDefinitionReference#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(ValueDefinition value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isEnumLiteralReference();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	boolean isAttributeReference();

} // ValueDefinitionReference
