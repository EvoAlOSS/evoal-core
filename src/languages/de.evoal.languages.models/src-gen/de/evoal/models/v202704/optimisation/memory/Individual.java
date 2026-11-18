/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;

import de.evoal.models.core.ecore.TypedEObject;

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
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Individual#getId <em>Id</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Individual#getInput <em>Input</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Individual#getOutput <em>Output</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Individual#getFitness <em>Fitness</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Individual#getRelationships <em>Relationships</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIndividual()
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
	 * @see #setId(int)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIndividual_Id()
	 * @model required="true"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.Individual#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Input</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The values of the input space.
	 * 
	 * @constraint individual.input.eClass() == execution.inputSpace
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input</em>' attribute.
	 * @see #setInput(TypedEObject)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIndividual_Input()
	 * @model dataType="de.evoal.models.v202704.optimisation.TypedEObject" required="true"
	 * @generated
	 */
	TypedEObject getInput();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.Individual#getInput <em>Input</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input</em>' attribute.
	 * @see #getInput()
	 * @generated
	 */
	void setInput(TypedEObject value);

	/**
	 * Returns the value of the '<em><b>Output</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The values of the output space.
	 * 
	 * @constraint individual.output.eClass() == execution.outputSpace
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output</em>' attribute.
	 * @see #setOutput(TypedEObject)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIndividual_Output()
	 * @model dataType="de.evoal.models.v202704.optimisation.TypedEObject" required="true"
	 * @generated
	 */
	TypedEObject getOutput();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.Individual#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(TypedEObject value);

	/**
	 * Returns the value of the '<em><b>Fitness</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Double}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The fitness computed from the output: one value per fitness component, in the
	 *   order of {@link Execution#getFitnessComponents()}. The fitness is canonical,
	 *   i.e., smaller values are better. Empty if the algorithm computes no fitness.
	 * 
	 * @constraint individual.fitness.isEmpty() || individual.fitness.size() == execution.fitnessComponents.size()
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fitness</em>' attribute list.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIndividual_Fitness()
	 * @model
	 * @generated
	 */
	EList<Double> getFitness();

	/**
	 * Returns the value of the '<em><b>Relationships</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.models.v202704.optimisation.memory.Relationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The relations to other individuals.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Relationships</em>' containment reference list.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIndividual_Relationships()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Relationship> getRelationships();

} // Individual
