/**
 * (c) EvoAl project
 */
package de.evoal.models.v202704.pipeline;

import de.evoal.languages.model.execution.Program;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A pipeline module that may contains several pipelines and execute them.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.pipeline.PipelineModule#getProgram <em>Program</em>}</li>
 * </ul>
 *
 * @see de.evoal.models.v202704.pipeline.PipelinePackage#getPipelineModule()
 * @model
 * @generated
 */
public interface PipelineModule extends de.evoal.languages.model.base.Module {
	/**
	 * Returns the value of the '<em><b>Program</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Pipeline definitions that can be used in the statements section.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Program</em>' containment reference.
	 * @see #setProgram(Program)
	 * @see de.evoal.models.v202704.pipeline.PipelinePackage#getPipelineModule_Program()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Program getProgram();

	/**
	 * Sets the value of the '{@link de.evoal.models.v202704.pipeline.PipelineModule#getProgram <em>Program</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Program</em>' containment reference.
	 * @see #getProgram()
	 * @generated
	 */
	void setProgram(Program value);

} // PipelineModule
