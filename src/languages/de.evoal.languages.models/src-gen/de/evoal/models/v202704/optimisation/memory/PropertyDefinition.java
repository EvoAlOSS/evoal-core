/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Defines a property the individuals or relationships of an execution record.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.PropertyDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.PropertyDefinition#getScope <em>Scope</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.PropertyDefinition#getValueType <em>Value Type</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.PropertyDefinition#isList <em>List</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.PropertyDefinition#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getPropertyDefinition()
 * @model
 * @generated
 */
public interface PropertyDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The name of the property, unique within its scope, e.g., <code>reason</code>.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getPropertyDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.PropertyDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link de.evoal.models.v202704.optimisation.memory.PropertyScope}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Where the values of the property are recorded.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see de.evoal.models.v202704.optimisation.memory.PropertyScope
	 * @see #setScope(PropertyScope)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getPropertyDefinition_Scope()
	 * @model required="true"
	 * @generated
	 */
	PropertyScope getScope();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.PropertyDefinition#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see de.evoal.models.v202704.optimisation.memory.PropertyScope
	 * @see #getScope()
	 * @generated
	 */
	void setScope(PropertyScope value);

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.evoal.models.v202704.optimisation.memory.PropertyValueType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The type of the property's values, or of their elements if {@link #isList()}.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see de.evoal.models.v202704.optimisation.memory.PropertyValueType
	 * @see #setValueType(PropertyValueType)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getPropertyDefinition_ValueType()
	 * @model required="true"
	 * @generated
	 */
	PropertyValueType getValueType();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.PropertyDefinition#getValueType <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' attribute.
	 * @see de.evoal.models.v202704.optimisation.memory.PropertyValueType
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(PropertyValueType value);

	/**
	 * Returns the value of the '<em><b>List</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Whether a value is a list of values of the {@link #getValueType()}.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>List</em>' attribute.
	 * @see #setList(boolean)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getPropertyDefinition_List()
	 * @model required="true"
	 * @generated
	 */
	boolean isList();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.PropertyDefinition#isList <em>List</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' attribute.
	 * @see #isList()
	 * @generated
	 */
	void setList(boolean value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * What the property describes.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getPropertyDefinition_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.PropertyDefinition#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // PropertyDefinition
