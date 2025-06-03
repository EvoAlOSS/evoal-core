/**
 */
package de.evoal.languages.model.base.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parantheses</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.Parantheses#getSubExpression <em>Sub Expression</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getParantheses()
 * @model
 * @generated
 */
public interface Parantheses extends ReadExpression {
	/**
	 * Returns the value of the '<em><b>Sub Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Expression</em>' containment reference.
	 * @see #setSubExpression(Expression)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getParantheses_SubExpression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getSubExpression();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.Parantheses#getSubExpression <em>Sub Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sub Expression</em>' containment reference.
	 * @see #getSubExpression()
	 * @generated
	 */
	void setSubExpression(Expression value);

} // Parantheses
