/**
 * (c) EvoAl project
 */
package de.evoal.models.v202704.pipeline;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A step that consists of an entire pipeline.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.pipeline.PipelineStep#getDefinition <em>Definition</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.pipeline.PipelinePackage#getPipelineStep()
 * @model
 * @generated
 */
public interface PipelineStep extends Step {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The pipeline definition of this step.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(PipelineDefinition)
	 * @see de.evoal.models.v202704.pipeline.PipelinePackage#getPipelineStep_Definition()
	 * @model required="true"
	 * @generated
	 */
	PipelineDefinition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.pipeline.PipelineStep#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(PipelineDefinition value);

} // PipelineStep
