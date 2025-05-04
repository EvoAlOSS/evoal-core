/**
 */
package de.evoal.languages.model.base.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add Or Subtract Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.AddOrSubtractExpression#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.expressions.AddOrSubtractExpression#getOperators <em>Operators</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.expressions.AddOrSubtractExpression#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getAddOrSubtractExpression()
 * @model
 * @generated
 */
public interface AddOrSubtractExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' containment reference.
	 * @see #setLeftOperand(MultiplyDivideModuloExpression)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getAddOrSubtractExpression_LeftOperand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MultiplyDivideModuloExpression getLeftOperand();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.AddOrSubtractExpression#getLeftOperand <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' containment reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
	void setLeftOperand(MultiplyDivideModuloExpression value);

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.AddOrSubtractOperator}.
	 * The literals are from the enumeration {@link de.evoal.languages.model.base.expressions.AddOrSubtractOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute list.
	 * @see de.evoal.languages.model.base.expressions.AddOrSubtractOperator
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getAddOrSubtractExpression_Operators()
	 * @model annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<AddOrSubtractOperator> getOperators();

	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getAddOrSubtractExpression_Operands()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<MultiplyDivideModuloExpression> getOperands();

} // AddOrSubtractExpression
