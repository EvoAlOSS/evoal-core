/**
 */
package de.evoal.languages.model.base.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comparison Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.ComparisonExpression#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.expressions.ComparisonExpression#getComparison <em>Comparison</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getComparisonExpression()
 * @model
 * @generated
 */
public interface ComparisonExpression extends Value {
	/**
	 * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' containment reference.
	 * @see #setLeftOperand(AddOrSubtractExpression)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getComparisonExpression_LeftOperand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AddOrSubtractExpression getLeftOperand();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.ComparisonExpression#getLeftOperand <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' containment reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
	void setLeftOperand(AddOrSubtractExpression value);

	/**
	 * Returns the value of the '<em><b>Comparison</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.PartialComparisonExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comparison</em>' containment reference list.
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getComparisonExpression_Comparison()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<PartialComparisonExpression> getComparison();

} // ComparisonExpression
