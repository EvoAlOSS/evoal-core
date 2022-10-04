/**
 */
package de.evoal.languages.model.el;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.el.NumberLiteral#getFactor <em>Factor</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.el.ELPackage#getNumberLiteral()
 * @model abstract="true"
 * @generated
 */
public interface NumberLiteral extends Literal {
	/**
	 * Returns the value of the '<em><b>Factor</b></em>' attribute.
	 * The default value is <code>"None"</code>.
	 * The literals are from the enumeration {@link de.evoal.languages.model.el.Factor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Factor</em>' attribute.
	 * @see de.evoal.languages.model.el.Factor
	 * @see #setFactor(Factor)
	 * @see de.evoal.languages.model.el.ELPackage#getNumberLiteral_Factor()
	 * @model default="None" required="true"
	 * @generated
	 */
	Factor getFactor();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.el.NumberLiteral#getFactor <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Factor</em>' attribute.
	 * @see de.evoal.languages.model.el.Factor
	 * @see #getFactor()
	 * @generated
	 */
	void setFactor(Factor value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Object getValue();

} // NumberLiteral
