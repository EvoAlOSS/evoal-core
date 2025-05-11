/**
 */
package de.evoal.languages.model.base.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiply Divide Modulo Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression#getOperators <em>Operators</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getMultiplyDivideModuloExpression()
 * @model
 * @generated
 */
public interface MultiplyDivideModuloExpression extends Value {
	/**
	 * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' containment reference.
	 * @see #setLeftOperand(PowerOfExpression)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getMultiplyDivideModuloExpression_LeftOperand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PowerOfExpression getLeftOperand();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression#getLeftOperand <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' containment reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
	void setLeftOperand(PowerOfExpression value);

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator}.
	 * The literals are from the enumeration {@link de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute list.
	 * @see de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getMultiplyDivideModuloExpression_Operators()
	 * @model annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<MultiplyDivideModuloOperator> getOperators();

	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.PowerOfExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getMultiplyDivideModuloExpression_Operands()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<PowerOfExpression> getOperands();

} // MultiplyDivideModuloExpression
