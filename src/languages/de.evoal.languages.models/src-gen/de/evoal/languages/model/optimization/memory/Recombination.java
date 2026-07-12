/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.memory;


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
 *   <li>{@link de.evoal.languages.model.optimization.memory.Recombination#getOther <em>Other</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getRecombination()
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
	 * The recombination that is the related one.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Other</em>' reference.
	 * @see #setOther(Recombination)
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getRecombination_Other()
	 * @model required="true"
	 * @generated
	 */
	Recombination getOther();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.optimization.memory.Recombination#getOther <em>Other</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Other</em>' reference.
	 * @see #getOther()
	 * @generated
	 */
	void setOther(Recombination value);

} // Recombination
