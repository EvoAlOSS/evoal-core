/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.memory;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A single optimisation run.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.optimization.memory.Execution#getInputSpace <em>Input Space</em>}</li>
 *   <li>{@link de.evoal.languages.model.optimization.memory.Execution#getOutputSpace <em>Output Space</em>}</li>
 *   <li>{@link de.evoal.languages.model.optimization.memory.Execution#getStates <em>States</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getExecution()
 * @model
 * @generated
 */
public interface Execution extends EObject {
	/**
	 * Returns the value of the '<em><b>Input Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Definition of the input space (aka the search space of the
	 *   optimisation problem).
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input Space</em>' reference.
	 * @see #setInputSpace(EClass)
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getExecution_InputSpace()
	 * @model required="true"
	 * @generated
	 */
	EClass getInputSpace();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.optimization.memory.Execution#getInputSpace <em>Input Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Space</em>' reference.
	 * @see #getInputSpace()
	 * @generated
	 */
	void setInputSpace(EClass value);

	/**
	 * Returns the value of the '<em><b>Output Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Definition of the output space (aka the optimisation space of
	 *   the optimisation problem).
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output Space</em>' reference.
	 * @see #setOutputSpace(EClass)
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getExecution_OutputSpace()
	 * @model required="true"
	 * @generated
	 */
	EClass getOutputSpace();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.optimization.memory.Execution#getOutputSpace <em>Output Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Space</em>' reference.
	 * @see #getOutputSpace()
	 * @generated
	 */
	void setOutputSpace(EClass value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.optimization.memory.State}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The memory states of the execution.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getExecution_States()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<State> getStates();

} // Execution
