/**
 */
package de.evoal.languages.model.el;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.el.Call#getFunction <em>Function</em>}</li>
 *   <li>{@link de.evoal.languages.model.el.Call#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.el.ELPackage#getCall()
 * @model
 * @generated
 */
public interface Call extends CallOrLiteralOrReferenceOrParantheses {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' containment reference.
	 * @see #setFunction(FunctionName)
	 * @see de.evoal.languages.model.el.ELPackage#getCall_Function()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FunctionName getFunction();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.el.Call#getFunction <em>Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' containment reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(FunctionName value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.el.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see de.evoal.languages.model.el.ELPackage#getCall_Parameters()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Expression> getParameters();

} // Call
