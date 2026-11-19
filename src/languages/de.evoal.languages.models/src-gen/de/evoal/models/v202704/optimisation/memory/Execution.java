/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * *
 * A single optimisation run.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Execution#getInputSpace <em>Input Space</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Execution#getOutputSpace <em>Output Space</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Execution#getStates <em>States</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Execution#getMetricDefinitions <em>Metric Definitions</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Execution#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Execution#getPropertyDefinitions <em>Property Definitions</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Execution#getFitnessComponents <em>Fitness Components</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.Execution#getReproducibilityNotes <em>Reproducibility Notes</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getExecution()
 * @model
 * @generated
 */
public interface Execution extends EObject {
	/**
	 * Returns the value of the '<em><b>Input Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Definition of the input space (aka the search space of the
	 *   optimisation problem).
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input Space</em>' reference.
	 * @see #setInputSpace(EClass)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getExecution_InputSpace()
	 * @model required="true"
	 * @generated
	 */
	EClass getInputSpace();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.Execution#getInputSpace <em>Input Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Space</em>' reference.
	 * @see #getInputSpace()
	 * @generated
	 */
	void setInputSpace(EClass value);

	/**
	 * Returns the value of the '<em><b>Output Space</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * Definition of the output space (aka the optimisation space of
	 *   the optimisation problem).
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output Space</em>' reference.
	 * @see #setOutputSpace(EClass)
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getExecution_OutputSpace()
	 * @model required="true"
	 * @generated
	 */
	EClass getOutputSpace();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.optimisation.memory.Execution#getOutputSpace <em>Output Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Space</em>' reference.
	 * @see #getOutputSpace()
	 * @generated
	 */
	void setOutputSpace(EClass value);

	/**
	 * Returns the value of the '<em><b>States</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.models.v202704.optimisation.memory.State}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The memory states of the execution.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>States</em>' containment reference list.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getExecution_States()
	 * @model containment="true"
	 * @generated
	 */
	EList<State> getStates();

	/**
	 * Returns the value of the '<em><b>Metric Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.models.v202704.optimisation.memory.MetricDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The metrics this execution and its iterations record. Every key of
	 *   {@link #getMetrics()} and of {@link Iteration#getMetrics()} is defined here.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Definitions</em>' containment reference list.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getExecution_MetricDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<MetricDefinition> getMetricDefinitions();

	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.Number},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The values of the metrics that describe the whole execution, e.g.,
	 *   limits, by metric name. The metrics are defined in
	 *   {@link #getMetricDefinitions()} with the scope {@link MetricScope#EXECUTION}.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metrics</em>' map.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getExecution_Metrics()
	 * @model mapType="de.evoal.models.v202704.optimisation.memory.MetricEntry&lt;org.eclipse.emf.ecore.EString, de.evoal.models.v202704.optimisation.Number&gt;"
	 * @generated
	 */
	EMap<String, Number> getMetrics();

	/**
	 * Returns the value of the '<em><b>Property Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.models.v202704.optimisation.memory.PropertyDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The properties the individuals and relationships of this execution record. Every
	 *   key of {@link Individual#getProperties()} and of {@link Relationship#getProperties()}
	 *   is defined here.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Property Definitions</em>' containment reference list.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getExecution_PropertyDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<PropertyDefinition> getPropertyDefinitions();

	/**
	 * Returns the value of the '<em><b>Fitness Components</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.models.v202704.optimisation.memory.FitnessComponentDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The components of the fitness, in the order of the values of
	 *   {@link Individual#getFitness()}. The same for all individuals of the execution.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Fitness Components</em>' containment reference list.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getExecution_FitnessComponents()
	 * @model containment="true"
	 * @generated
	 */
	EList<FitnessComponentDefinition> getFitnessComponents();

	/**
	 * Returns the value of the '<em><b>Reproducibility Notes</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.models.v202704.optimisation.memory.ReproducibilityNote}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * *
	 * The parts of the execution whose results may not be reproducible on
	 *   other platforms, e.g. because they use native numeric libraries. Empty if
	 *   the execution is fully reproducible with the same seed.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reproducibility Notes</em>' containment reference list.
	 * @see de.evoal.models.v202704.optimisation.memory.MemoryPackage#getExecution_ReproducibilityNotes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReproducibilityNote> getReproducibilityNotes();

} // Execution
