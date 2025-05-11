/**
 * EvoAl project
 */
package de.evoal.languages.model.execution;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Model Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * Call of a {@see ModelFunction}.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.execution.CallModelFunction#getFunction <em>Function</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.execution.ExecutionPackage#getCallModelFunction()
 * @model
 * @generated
 */
public interface CallModelFunction extends CallStatement {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Reference to the model function called.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Function</em>' reference.
	 * @see #setFunction(ModelFunction)
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getCallModelFunction_Function()
	 * @model required="true"
	 * @generated
	 */
	ModelFunction getFunction();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.execution.CallModelFunction#getFunction <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(ModelFunction value);

} // CallModelFunction
