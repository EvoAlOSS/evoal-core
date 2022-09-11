/**
 */
package de.evoal.languages.model.el;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.el.NotExpression#isNegated <em>Negated</em>}</li>
 *   <li>{@link de.evoal.languages.model.el.NotExpression#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.el.ELPackage#getNotExpression()
 * @model
 * @generated
 */
public interface NotExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Negated</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Negated</em>' attribute.
	 * @see #setNegated(boolean)
	 * @see de.evoal.languages.model.el.ELPackage#getNotExpression_Negated()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isNegated();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.el.NotExpression#isNegated <em>Negated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Negated</em>' attribute.
	 * @see #isNegated()
	 * @generated
	 */
	void setNegated(boolean value);

	/**
	 * Returns the value of the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operand</em>' containment reference.
	 * @see #setOperand(ComparisonExpression)
	 * @see de.evoal.languages.model.el.ELPackage#getNotExpression_Operand()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ComparisonExpression getOperand();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.el.NotExpression#getOperand <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operand</em>' containment reference.
	 * @see #getOperand()
	 * @generated
	 */
	void setOperand(ComparisonExpression value);

} // NotExpression
