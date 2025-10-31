/**
 * EvoAl project
 */
package de.evoal.languages.model.pipeline;

import de.evoal.languages.model.base.expressions.Instance;

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
 *   <li>{@link de.evoal.languages.model.pipeline.ConcreteStep#getInstance <em>Instance</em>}</li>
 *   <li>{@link de.evoal.languages.model.pipeline.ConcreteStep#getReads <em>Reads</em>}</li>
 *   <li>{@link de.evoal.languages.model.pipeline.ConcreteStep#getWrites <em>Writes</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.pipeline.PipelinePackage#getConcreteStep()
 * @model
 * @generated
 */
public interface ConcreteStep extends Step {
	/**
	 * Returns the value of the '<em><b>Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The component reference and its configuration.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Instance</em>' containment reference.
	 * @see #setInstance(Instance)
	 * @see de.evoal.languages.model.pipeline.PipelinePackage#getConcreteStep_Instance()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Instance getInstance();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.pipeline.ConcreteStep#getInstance <em>Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance</em>' containment reference.
	 * @see #getInstance()
	 * @generated
	 */
	void setInstance(Instance value);

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
	 * @see de.evoal.languages.model.pipeline.PipelinePackage#getConcreteStep_Reads()
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
	 * @see de.evoal.languages.model.pipeline.PipelinePackage#getConcreteStep_Writes()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<EStructuralFeature> getWrites();

} // ConcreteStep
