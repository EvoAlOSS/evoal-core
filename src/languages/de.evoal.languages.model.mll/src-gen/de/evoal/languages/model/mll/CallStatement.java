/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.el.Call;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.CallStatement#getCall <em>Call</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getCallStatement()
 * @model
 * @generated
 */
public interface CallStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call</em>' containment reference.
	 * @see #setCall(Call)
	 * @see de.evoal.languages.model.mll.MllPackage#getCallStatement_Call()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Call getCall();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.CallStatement#getCall <em>Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call</em>' containment reference.
	 * @see #getCall()
	 * @generated
	 */
	void setCall(Call value);

} // CallStatement
