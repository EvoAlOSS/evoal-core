/**
 * EvoAl project
 */
package de.evoal.languages.model.execution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A execution module contains statements to execute.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.execution.ExecutionModule#getProgram <em>Program</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.execution.ExecutionPackage#getExecutionModule()
 * @model
 * @generated
 */
public interface ExecutionModule extends de.evoal.languages.model.base.Module {
	/**
	 * Returns the value of the '<em><b>Program</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The program to execute.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Program</em>' containment reference.
	 * @see #setProgram(Program)
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getExecutionModule_Program()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Program getProgram();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.execution.ExecutionModule#getProgram <em>Program</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Program</em>' containment reference.
	 * @see #getProgram()
	 * @generated
	 */
	void setProgram(Program value);

} // ExecutionModule
