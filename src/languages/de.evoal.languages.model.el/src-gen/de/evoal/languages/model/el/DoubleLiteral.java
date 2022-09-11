/**
 */
package de.evoal.languages.model.el;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.el.DoubleLiteral#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.el.ELPackage#getDoubleLiteral()
 * @model
 * @generated
 */
public interface DoubleLiteral extends NumberLiteral {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(double)
	 * @see de.evoal.languages.model.el.ELPackage#getDoubleLiteral_Value()
	 * @model required="true"
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.el.DoubleLiteral#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

} // DoubleLiteral
