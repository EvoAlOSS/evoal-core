/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;

import java.util.stream.Stream;

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
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Iteration#getNumber <em>Number</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Iteration#getSteps <em>Steps</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Iteration#getRanks <em>Ranks</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIteration()
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
	 * @see #setNumber(int)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIteration_Number()
	 * @model required="true"
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.Iteration#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.models.v202704.optimisation.memory.IterationStep}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Intermediate iteration steps, e.g., recombination and mutation.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Steps</em>' containment reference list.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIteration_Steps()
	 * @model containment="true"
	 * @generated
	 */
	EList<IterationStep> getSteps();

	/**
	 * Returns the value of the '<em><b>Ranks</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.models.v202704.optimisation.memory.Rank}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The final individuals of the iteration.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ranks</em>' containment reference list.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIteration_Ranks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rank> getRanks();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns a stream of the best individuals that survived the iteration.
	 * 
	 * <!-- end-model-doc -->
	 * @model type="de.evoal.models.v202704.optimisation.Stream&lt;de.evoal.models.v202704.optimisation.memory.Individual&gt;" required="true"
	 * @generated
	 */
	Stream<Individual> bestIndividuals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Returns a stream of the individuals that survived the iteration.
	 * 
	 * <!-- end-model-doc -->
	 * @model type="de.evoal.models.v202704.optimisation.Stream&lt;de.evoal.models.v202704.optimisation.memory.Individual&gt;" required="true"
	 * @generated
	 */
	Stream<Individual> survivedIndividuals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Calculates the number of individuals that survive the iteration.
	 *   This excludes individuals that were created as intermediate
	 *   individuals but that are not passed to next generation.
	 * 
	 * @return Positive number of individuals.
	 * *
	 * Negation of the method {@link #shouldTerminate}.
	 * 
	 * <!-- end-model-doc -->
	 * @model required="true"
	 * @generated
	 */
	int numberOfSurvivedIndividuals();

} // Iteration
