/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ordered Iteration Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Result of an iteration step
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.OrderedIterationStep#getRanks <em>Ranks</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getOrderedIterationStep()
 * @model
 * @generated
 */
public interface OrderedIterationStep extends IterationStep {
	/**
	 * Returns the value of the '<em><b>Ranks</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.models.v202704.optimisation.memory.Rank}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * List of ranks (result of this step).
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ranks</em>' containment reference list.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getOrderedIterationStep_Ranks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rank> getRanks();

} // OrderedIterationStep
