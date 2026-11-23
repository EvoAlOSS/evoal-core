/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Individual Stub</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Stands for the record of an individual of an earlier iteration: it has the id and
 *   the values of the record, but neither its relationships nor its properties, and
 *   it is not contained in an iteration. A stub refers to no other individual, so a
 *   run keeps only the iterations it needs, not every earlier one. The record is in
 *   the ranks of iteration {@link #getIteration()}; in the written memory model,
 *   iteration and id find it.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.IndividualStub#getIteration <em>Iteration</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIndividualStub()
 * @model
 * @generated
 */
public interface IndividualStub extends Individual {
	/**
	 * Returns the value of the '<em><b>Iteration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The number of the iteration whose ranks contain the record.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Iteration</em>' attribute.
	 * @see #setIteration(int)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIndividualStub_Iteration()
	 * @model required="true"
	 * @generated
	 */
	int getIteration();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.IndividualStub#getIteration <em>Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iteration</em>' attribute.
	 * @see #getIteration()
	 * @generated
	 */
	void setIteration(int value);

} // IndividualStub
