/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Individual Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * The complete record of an individual, contained in the iteration that produced it:
 *   its values, its relationships and its properties.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.IndividualRecord#getRelationships <em>Relationships</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.IndividualRecord#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIndividualRecord()
 * @model
 * @generated
 */
public interface IndividualRecord extends Individual {
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
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIndividualRecord_Relationships()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Relationship> getRelationships();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Object},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Further details of the individual, e.g., its age, by property name. The properties
	 *   are defined in {@link Execution#getPropertyDefinitions()} with the scope
	 *   {@link PropertyScope#INDIVIDUAL}.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getIndividualRecord_Properties()
	 * @model mapType="de.evoal.models.v202704.optimisation.memory.PropertyEntry&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EJavaObject&gt;"
	 * @generated
	 */
	EMap<String, Object> getProperties();

} // IndividualRecord
