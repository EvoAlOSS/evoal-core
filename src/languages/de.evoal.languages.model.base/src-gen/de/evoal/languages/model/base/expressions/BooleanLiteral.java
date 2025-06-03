/**
 */
package de.evoal.languages.model.base.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.BooleanLiteral#isLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getBooleanLiteral()
 * @model
 * @generated
 */
public interface BooleanLiteral extends Literal {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' attribute.
	 * @see #setLiteral(boolean)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getBooleanLiteral_Literal()
	 * @model required="true"
	 * @generated
	 */
	boolean isLiteral();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.BooleanLiteral#isLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' attribute.
	 * @see #isLiteral()
	 * @generated
	 */
	void setLiteral(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Boolean getValue();

} // BooleanLiteral
