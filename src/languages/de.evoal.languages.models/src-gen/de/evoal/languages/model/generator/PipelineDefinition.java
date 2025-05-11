/**
 * EvoAl Project
 */
package de.evoal.languages.model.generator;

import de.evoal.languages.model.execution.NamedVariable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pipeline Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.generator.PipelineDefinition#getSteps <em>Steps</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.generator.GeneratorPackage#getPipelineDefinition()
 * @model
 * @generated
 */
public interface PipelineDefinition extends NamedVariable {
	/**
	 * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.generator.Step}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps</em>' containment reference list.
	 * @see de.evoal.languages.model.generator.GeneratorPackage#getPipelineDefinition_Steps()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Step> getSteps();

} // PipelineDefinition
