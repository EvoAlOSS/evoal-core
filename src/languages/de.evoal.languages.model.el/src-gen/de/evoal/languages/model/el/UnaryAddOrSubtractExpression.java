/**
 */
package de.evoal.languages.model.el;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Add Or Subtract Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.el.UnaryAddOrSubtractExpression#getOperators <em>Operators</em>}</li>
 *   <li>{@link de.evoal.languages.model.el.UnaryAddOrSubtractExpression#getSubExpression <em>Sub Expression</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.el.ELPackage#getUnaryAddOrSubtractExpression()
 * @model
 * @generated
 */
public interface UnaryAddOrSubtractExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute list.
	 * The list contents are of type {@link de.evoal.languages.model.el.AddOrSubtractOperator}.
	 * The literals are from the enumeration {@link de.evoal.languages.model.el.AddOrSubtractOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute list.
	 * @see de.evoal.languages.model.el.AddOrSubtractOperator
	 * @see de.evoal.languages.model.el.ELPackage#getUnaryAddOrSubtractExpression_Operators()
	 * @model annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<AddOrSubtractOperator> getOperators();

	/**
	 * Returns the value of the '<em><b>Sub Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Expression</em>' containment reference.
	 * @see #setSubExpression(CallOrLiteralOrReferenceOrParantheses)
	 * @see de.evoal.languages.model.el.ELPackage#getUnaryAddOrSubtractExpression_SubExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CallOrLiteralOrReferenceOrParantheses getSubExpression();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.el.UnaryAddOrSubtractExpression#getSubExpression <em>Sub Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Expression</em>' containment reference.
	 * @see #getSubExpression()
	 * @generated
	 */
	void setSubExpression(CallOrLiteralOrReferenceOrParantheses value);

} // UnaryAddOrSubtractExpression
