/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fitness Component Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Defines a component of the fitness of the individuals of an execution.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.FitnessComponentDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.FitnessComponentDefinition#getObjective <em>Objective</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getFitnessComponentDefinition()
 * @model
 * @generated
 */
public interface FitnessComponentDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The name of the component, unique within the execution.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getFitnessComponentDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.FitnessComponentDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Objective</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The objective of the goal the component was derived from, {@code null}
	 *   if the component belongs to no goal (e.g., a constraint violation).
	 * 
	 * @constraint component.objective == null || component.objective.eContainingClass() == execution.outputSpace
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Objective</em>' reference.
	 * @see #setObjective(EStructuralFeature)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getFitnessComponentDefinition_Objective()
	 * @model
	 * @generated
	 */
	EStructuralFeature getObjective();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.FitnessComponentDefinition#getObjective <em>Objective</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Objective</em>' reference.
	 * @see #getObjective()
	 * @generated
	 */
	void setObjective(EStructuralFeature value);

} // FitnessComponentDefinition
