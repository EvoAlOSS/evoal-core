/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.base.expressions;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Reference to an attribute
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.AttributeReference#getSelf <em>Self</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.expressions.AttributeReference#getChain <em>Chain</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getAttributeReference()
 * @model
 * @generated
 */
public interface AttributeReference extends ReadExpression {
	/**
	 * Returns the value of the '<em><b>Self</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Reference to the instance itself.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Self</em>' containment reference.
	 * @see #setSelf(SelfReference)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getAttributeReference_Self()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SelfReference getSelf();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.AttributeReference#getSelf <em>Self</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Self</em>' containment reference.
	 * @see #getSelf()
	 * @generated
	 */
	void setSelf(SelfReference value);

	/**
	 * Returns the value of the '<em><b>Chain</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.ValueDefinitionReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Chain of references.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Chain</em>' containment reference list.
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getAttributeReference_Chain()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<ValueDefinitionReference> getChain();

} // AttributeReference
