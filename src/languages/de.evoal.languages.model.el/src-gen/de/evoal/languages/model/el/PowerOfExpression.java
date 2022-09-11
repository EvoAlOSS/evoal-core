/**
 */
package de.evoal.languages.model.el;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Power Of Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.el.PowerOfExpression#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link de.evoal.languages.model.el.PowerOfExpression#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.el.ELPackage#getPowerOfExpression()
 * @model
 * @generated
 */
public interface PowerOfExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' containment reference.
	 * @see #setLeftOperand(UnaryAddOrSubtractExpression)
	 * @see de.evoal.languages.model.el.ELPackage#getPowerOfExpression_LeftOperand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	UnaryAddOrSubtractExpression getLeftOperand();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.el.PowerOfExpression#getLeftOperand <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' containment reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
	void setLeftOperand(UnaryAddOrSubtractExpression value);

	/**
	 * Returns the value of the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Operand</em>' containment reference.
	 * @see #setRightOperand(PowerOfExpression)
	 * @see de.evoal.languages.model.el.ELPackage#getPowerOfExpression_RightOperand()
	 * @model containment="true"
	 * @generated
	 */
	PowerOfExpression getRightOperand();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.el.PowerOfExpression#getRightOperand <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Operand</em>' containment reference.
	 * @see #getRightOperand()
	 * @generated
	 */
	void setRightOperand(PowerOfExpression value);

} // PowerOfExpression
