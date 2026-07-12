/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.memory;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A memory state for iteration-based algorithms.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.optimization.memory.Iteration#getNumber <em>Number</em>}</li>
 *   <li>{@link de.evoal.languages.model.optimization.memory.Iteration#getSteps <em>Steps</em>}</li>
 *   <li>{@link de.evoal.languages.model.optimization.memory.Iteration#getRanks <em>Ranks</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getIteration()
 * @model
 * @generated
 */
public interface Iteration extends State {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The iteration number. Please note that iteration 0 represents
	 *   the initial population. The iteration numbers are used
	 *   consecutively.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getIteration_Number()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	int getNumber();

	/**
	 * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.optimization.memory.IterationStep}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Intermediate iteration steps, e.g., recombination and mutation.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Steps</em>' containment reference list.
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getIteration_Steps()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<IterationStep> getSteps();

	/**
	 * Returns the value of the '<em><b>Ranks</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.optimization.memory.Rank}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The final individuals of the iteration.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ranks</em>' containment reference list.
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getIteration_Ranks()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Rank> getRanks();

} // Iteration
