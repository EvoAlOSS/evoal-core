/**
 * EvoAl Project
 */
package de.evoal.languages.model.generator;

import de.evoal.languages.model.execution.Block;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.generator.GeneratorModule#getPipelines <em>Pipelines</em>}</li>
 *   <li>{@link de.evoal.languages.model.generator.GeneratorModule#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.generator.GeneratorPackage#getGeneratorModule()
 * @model
 * @generated
 */
public interface GeneratorModule extends de.evoal.languages.model.base.Module {
	/**
	 * Returns the value of the '<em><b>Pipelines</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.generator.PipelineDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The configured pipelines that may be executed.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Pipelines</em>' containment reference list.
	 * @see de.evoal.languages.model.generator.GeneratorPackage#getGeneratorModule_Pipelines()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<PipelineDefinition> getPipelines();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The execution of the generator
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Block)
	 * @see de.evoal.languages.model.generator.GeneratorPackage#getGeneratorModule_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Block getBody();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.generator.GeneratorModule#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Block value);

} // GeneratorModule
