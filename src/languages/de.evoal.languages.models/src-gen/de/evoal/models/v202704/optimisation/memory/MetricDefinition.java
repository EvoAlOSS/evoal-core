/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * Defines a metric the iterations of an execution record.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getKind <em>Kind</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getValueType <em>Value Type</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getScope <em>Scope</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getMetricDefinition()
 * @model
 * @generated
 */
public interface MetricDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The unique name of the metric, e.g., <code>evaluations.real</code>.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getMetricDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link de.evoal.models.v202704.optimisation.memory.MetricKind}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * How the metric changes over the iterations.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricKind
	 * @see #setKind(MetricKind)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getMetricDefinition_Kind()
	 * @model required="true"
	 * @generated
	 */
	MetricKind getKind();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(MetricKind value);

	/**
	 * Returns the value of the '<em><b>Value Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.evoal.models.v202704.optimisation.memory.MetricValueType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The type of the metric's values.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Value Type</em>' attribute.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricValueType
	 * @see #setValueType(MetricValueType)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getMetricDefinition_ValueType()
	 * @model required="true"
	 * @generated
	 */
	MetricValueType getValueType();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getValueType <em>Value Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Type</em>' attribute.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricValueType
	 * @see #getValueType()
	 * @generated
	 */
	void setValueType(MetricValueType value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link de.evoal.models.v202704.optimisation.memory.MetricScope}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Where the values of the metric are recorded.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricScope
	 * @see #setScope(MetricScope)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getMetricDefinition_Scope()
	 * @model required="true"
	 * @generated
	 */
	MetricScope getScope();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see de.evoal.models.v202704.optimisation.memory.MetricScope
	 * @see #getScope()
	 * @generated
	 */
	void setScope(MetricScope value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * What the metric measures.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getMetricDefinition_Description()
	 * @model required="true"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.MetricDefinition#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // MetricDefinition
