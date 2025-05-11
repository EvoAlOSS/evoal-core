/**
 * EvoAl project
 */
package de.evoal.languages.model.execution;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A program.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.execution.Program#getFunctions <em>Functions</em>}</li>
 *   <li>{@link de.evoal.languages.model.execution.Program#getMain <em>Main</em>}</li>
 *   <li>{@link de.evoal.languages.model.execution.Program#getVariables <em>Variables</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.execution.ExecutionPackage#getProgram()
 * @model
 * @generated
 */
public interface Program extends EObject {
	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.execution.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The functions of the program.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getProgram_Functions()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Main</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The entry function.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Main</em>' reference.
	 * @see #setMain(ModelFunction)
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getProgram_Main()
	 * @model required="true"
	 * @generated
	 */
	ModelFunction getMain();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.execution.Program#getMain <em>Main</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Main</em>' reference.
	 * @see #getMain()
	 * @generated
	 */
	void setMain(ModelFunction value);

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.execution.Variable}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * List of global variables.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getProgram_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariables();

} // Program
