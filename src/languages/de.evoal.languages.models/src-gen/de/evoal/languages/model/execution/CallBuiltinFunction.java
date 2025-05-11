/**
 * EvoAl project
 */
package de.evoal.languages.model.execution;

import de.evoal.languages.model.base.definitions.FunctionDefinition;

import de.evoal.languages.model.base.expressions.Expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Builtin Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * Call of a built-in function (specified in a dl file).
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.execution.CallBuiltinFunction#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.evoal.languages.model.execution.CallBuiltinFunction#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.execution.ExecutionPackage#getCallBuiltinFunction()
 * @model
 * @generated
 */
public interface CallBuiltinFunction extends CallStatement {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Reference to built-in function definition;
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(FunctionDefinition)
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getCallBuiltinFunction_Definition()
	 * @model required="true"
	 * @generated
	 */
	FunctionDefinition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.execution.CallBuiltinFunction#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(FunctionDefinition value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Parameters to use for calling the function.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getCallBuiltinFunction_Parameters()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Expression> getParameters();

} // CallBuiltinFunction
