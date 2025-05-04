/**
 */
package de.evoal.languages.model.base.definitions;

import de.evoal.languages.model.base.expressions.Expression;
import de.evoal.languages.model.base.types.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An attribute (similar to a Java field).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.definitions.AttributeDefinition#getType <em>Type</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.definitions.AttributeDefinition#getInitialisation <em>Initialisation</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getAttributeDefinition()
 * @model
 * @generated
 */
public interface AttributeDefinition extends Definition {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Type of the attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(Type)
	 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getAttributeDefinition_Type()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.definitions.AttributeDefinition#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

	/**
	 * Returns the value of the '<em><b>Initialisation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A default value for the attribute.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Initialisation</em>' containment reference.
	 * @see #setInitialisation(Expression)
	 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#getAttributeDefinition_Initialisation()
	 * @model containment="true"
	 * @generated
	 */
	Expression getInitialisation();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.definitions.AttributeDefinition#getInitialisation <em>Initialisation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialisation</em>' containment reference.
	 * @see #getInitialisation()
	 * @generated
	 */
	void setInitialisation(Expression value);

} // AttributeDefinition
