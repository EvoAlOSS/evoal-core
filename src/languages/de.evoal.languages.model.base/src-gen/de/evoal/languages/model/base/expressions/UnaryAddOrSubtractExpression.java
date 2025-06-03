/**
 */
package de.evoal.languages.model.base.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Add Or Subtract Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression#getOperators <em>Operators</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression#getSubExpression <em>Sub Expression</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getUnaryAddOrSubtractExpression()
 * @model
 * @generated
 */
public interface UnaryAddOrSubtractExpression extends ReadExpression {
	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.AddOrSubtractOperator}.
	 * The literals are from the enumeration {@link de.evoal.languages.model.base.expressions.AddOrSubtractOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute list.
	 * @see de.evoal.languages.model.base.expressions.AddOrSubtractOperator
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getUnaryAddOrSubtractExpression_Operators()
	 * @model annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<AddOrSubtractOperator> getOperators();

	/**
	 * Returns the value of the '<em><b>Sub Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Expression</em>' containment reference.
	 * @see #setSubExpression(ReadExpression)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getUnaryAddOrSubtractExpression_SubExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ReadExpression getSubExpression();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.UnaryAddOrSubtractExpression#getSubExpression <em>Sub Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Expression</em>' containment reference.
	 * @see #getSubExpression()
	 * @generated
	 */
	void setSubExpression(ReadExpression value);

} // UnaryAddOrSubtractExpression
