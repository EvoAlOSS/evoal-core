/**
 * EvoAl project
 */
package de.evoal.languages.model.pipeline;

import de.evoal.languages.model.base.expressions.Literal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A processing step.
 * 
 * <!-- end-model-doc -->
 *
 *
 * @see de.evoal.languages.model.pipeline.PipelinePackage#getStep()
 * @model abstract="true"
 * @generated
 */
public interface Step extends Literal {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Step getValue();

} // Step
