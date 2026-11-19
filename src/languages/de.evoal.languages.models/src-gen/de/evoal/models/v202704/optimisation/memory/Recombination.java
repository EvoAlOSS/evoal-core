/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recombination</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * The source is a recombined version of the target individuals.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Recombination#getOther <em>Other</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getRecombination()
 * @model
 * @generated
 */
public interface Recombination extends Relationship {
	/**
	 * Returns the value of the '<em><b>Other</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The recombination of the sibling: the other child of the same recombination.
	 *   Not set if the sibling is not recorded, e.g., because it did not survive the
	 *   replacement.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Other</em>' reference.
	 * @see #setOther(Recombination)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getRecombination_Other()
	 * @model
	 * @generated
	 */
	Recombination getOther();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.Recombination#getOther <em>Other</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other</em>' reference.
	 * @see #getOther()
	 * @generated
	 */
	void setOther(Recombination value);

} // Recombination
