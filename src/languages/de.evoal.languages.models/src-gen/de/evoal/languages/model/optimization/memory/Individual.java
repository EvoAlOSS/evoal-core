/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.memory;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Individual</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A single individual at a given point of the execution.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.optimization.memory.Individual#getId <em>Id</em>}</li>
 *   <li>{@link de.evoal.languages.model.optimization.memory.Individual#getInput <em>Input</em>}</li>
 *   <li>{@link de.evoal.languages.model.optimization.memory.Individual#getOutput <em>Output</em>}</li>
 *   <li>{@link de.evoal.languages.model.optimization.memory.Individual#getRelationships <em>Relationships</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getIndividual()
 * @model
 * @generated
 */
public interface Individual extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The unique identifier of the individual.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getIndividual_Id()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	int getId();

	/**
	 * Returns the value of the '<em><b>Input</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The values of the input space.
	 * 
	 * @constraint individual.input.eClass() == execution.inputSpace
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input</em>' reference.
	 * @see #setInput(EObject)
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getIndividual_Input()
	 * @model required="true"
	 * @generated
	 */
	EObject getInput();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.optimization.memory.Individual#getInput <em>Input</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' reference.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(EObject value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The values of the output space.
	 * 
	 * @constraint individual.output.eClass() == execution.outputSpace
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output</em>' reference.
	 * @see #setOutput(EObject)
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getIndividual_Output()
	 * @model required="true"
	 * @generated
	 */
	EObject getOutput();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.optimization.memory.Individual#getOutput <em>Output</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(EObject value);

	/**
	 * Returns the value of the '<em><b>Relationships</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.optimization.memory.Relationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The relations to other individuals.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Relationships</em>' containment reference list.
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getIndividual_Relationships()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Relationship> getRelationships();

} // Individual
