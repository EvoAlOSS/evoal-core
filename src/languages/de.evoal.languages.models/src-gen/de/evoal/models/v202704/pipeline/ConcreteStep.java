/**
 * (c) EvoAl project
 */
package de.evoal.models.v202704.pipeline;

import de.evoal.models.v202704.core.Configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concrete Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A single processing step.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.pipeline.ConcreteStep#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link de.evoal.models.v202704.pipeline.ConcreteStep#getReads <em>Reads</em>}</li>
 *   <li>{@link de.evoal.models.v202704.pipeline.ConcreteStep#getWrites <em>Writes</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.pipeline.PipelinePackage#getConcreteStep()
 * @model
 * @generated
 */
public interface ConcreteStep extends Step {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The component reference and its configuration.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Configuration</em>' containment reference.
	 * @see #setConfiguration(Configuration)
	 * @see de.evoal.models.v202704.pipeline.PipelinePackage#getConcreteStep_Configuration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Configuration getConfiguration();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.pipeline.ConcreteStep#getConfiguration <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' containment reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(Configuration value);

	/**
	 * Returns the value of the '<em><b>Reads</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Information on the data read by this step.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Reads</em>' reference list.
	 * @see de.evoal.models.v202704.pipeline.PipelinePackage#getConcreteStep_Reads()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<EStructuralFeature> getReads();

	/**
	 * Returns the value of the '<em><b>Writes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Information on the data written by this step.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Writes</em>' reference list.
	 * @see de.evoal.models.v202704.pipeline.PipelinePackage#getConcreteStep_Writes()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<EStructuralFeature> getWrites();

} // ConcreteStep
