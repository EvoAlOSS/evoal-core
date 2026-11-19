/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Base class for relationships.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Relationship#getTarget <em>Target</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Relationship#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getRelationship()
 * @model abstract="true"
 * @generated
 */
public interface Relationship extends EObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference list.
	 * The list contents are of type {@link de.evoal.models.v202704.optimisation.memory.Individual}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The relationship targets.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Target</em>' reference list.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getRelationship_Target()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Individual> getTarget();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Object},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Further details of the relationship, e.g., the reason of a replacement, by property
	 *   name. The properties are defined in {@link Execution#getPropertyDefinitions()} with
	 *   the scope {@link PropertyScope#RELATIONSHIP}.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getRelationship_Properties()
	 * @model mapType="de.evoal.models.v202704.optimisation.memory.PropertyEntry&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject&gt;"
	 * @generated
	 */
	EMap<String, Object> getProperties();

} // Relationship
