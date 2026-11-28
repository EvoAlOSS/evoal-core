/**
 */
package de.evoal.languages.model.base.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.IntegerLiteral#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getIntegerLiteral()
 * @model
 * @generated
 */
public interface IntegerLiteral extends NumberLiteral {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' attribute.
	 * @see #setLiteral(int)
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getIntegerLiteral_Literal()
	 * @model required="true"
	 * @generated
	 */
	int getLiteral();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.expressions.IntegerLiteral#getLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' attribute.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The value of the literal scaled by its factor: an integer if the scaled value is a whole number in the range of int (e.g. 5k, 3000m), a real number otherwise (e.g. 100µ, 1500m, 5G).
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="de.evoal.languages.model.base.expressions.Number" required="true"
	 * @generated
	 */
	Number getValue();

} // IntegerLiteral
