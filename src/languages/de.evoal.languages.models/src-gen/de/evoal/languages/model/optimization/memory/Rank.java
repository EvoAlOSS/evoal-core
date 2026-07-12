/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.memory;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rank</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A rank of individuals of same fitness.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.optimization.memory.Rank#getNumber <em>Number</em>}</li>
 *   <li>{@link de.evoal.languages.model.optimization.memory.Rank#getMembers <em>Members</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getRank()
 * @model
 * @generated
 */
public interface Rank extends EObject {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The rank number.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getRank_Number()
	 * @model required="true"
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.optimization.memory.Rank#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.optimization.memory.Individual}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The members of the rank.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see de.evoal.languages.model.optimization.memory.MemoryPackage#getRank_Members()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Individual> getMembers();

} // Rank
