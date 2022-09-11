/**
 */
package de.evoal.languages.model.el;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Comparison Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.el.ComparisonExpression#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link de.evoal.languages.model.el.ComparisonExpression#getComparison <em>Comparison</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.el.ELPackage#getComparisonExpression()
 * @model
 * @generated
 */
public interface ComparisonExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Operand</em>' containment reference.
	 * @see #setLeftOperand(AddOrSubtractExpression)
	 * @see de.evoal.languages.model.el.ELPackage#getComparisonExpression_LeftOperand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AddOrSubtractExpression getLeftOperand();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.el.ComparisonExpression#getLeftOperand <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Operand</em>' containment reference.
	 * @see #getLeftOperand()
	 * @generated
	 */
	void setLeftOperand(AddOrSubtractExpression value);

	/**
	 * Returns the value of the '<em><b>Comparison</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.el.PartialComparisonExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comparison</em>' containment reference list.
	 * @see de.evoal.languages.model.el.ELPackage#getComparisonExpression_Comparison()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<PartialComparisonExpression> getComparison();

} // ComparisonExpression
