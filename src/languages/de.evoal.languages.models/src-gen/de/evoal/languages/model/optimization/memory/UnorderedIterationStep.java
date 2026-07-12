/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.memory;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unordered Iteration Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.optimization.memory.UnorderedIterationStep#getIndividuals <em>Individuals</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getUnorderedIterationStep()
 * @model
 * @generated
 */
public interface UnorderedIterationStep extends IterationStep {
	/**
	 * Returns the value of the '<em><b>Individuals</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.optimization.memory.Individual}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * List of ranks (result of this step).
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Individuals</em>' containment reference list.
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getUnorderedIterationStep_Individuals()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Individual> getIndividuals();

} // UnorderedIterationStep
