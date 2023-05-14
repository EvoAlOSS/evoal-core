/**
 */
package de.evoal.languages.model.base;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.RealLiteral#getLiteral <em>Literal</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.BasePackage#getRealLiteral()
 * @model
 * @generated
 */
public interface RealLiteral extends NumberLiteral {
	/**
	 * Returns the value of the '<em><b>Literal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal</em>' attribute.
	 * @see #setLiteral(double)
	 * @see de.evoal.languages.model.base.BasePackage#getRealLiteral_Literal()
	 * @model required="true"
	 * @generated
	 */
	double getLiteral();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.base.RealLiteral#getLiteral <em>Literal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal</em>' attribute.
	 * @see #getLiteral()
	 * @generated
	 */
	void setLiteral(double value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Double getValue();

} // RealLiteral
