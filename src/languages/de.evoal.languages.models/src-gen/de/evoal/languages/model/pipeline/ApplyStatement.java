/**
 * EvoAl project
 */
package de.evoal.languages.model.pipeline;

import de.evoal.languages.model.base.expressions.Literal;

import de.evoal.languages.model.execution.Statement;
import de.evoal.languages.model.execution.VariableReference;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Apply Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.pipeline.ApplyStatement#getFile <em>File</em>}</li>
 *   <li>{@link de.evoal.languages.model.pipeline.ApplyStatement#getCount <em>Count</em>}</li>
 *   <li>{@link de.evoal.languages.model.pipeline.ApplyStatement#getPipelines <em>Pipelines</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.pipeline.PipelinePackage#getApplyStatement()
 * @model
 * @generated
 */
public interface ApplyStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(String)
	 * @see de.evoal.languages.model.pipeline.PipelinePackage#getApplyStatement_File()
	 * @model
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.pipeline.ApplyStatement#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

	/**
	 * Returns the value of the '<em><b>Count</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Count</em>' containment reference.
	 * @see #setCount(Literal)
	 * @see de.evoal.languages.model.pipeline.PipelinePackage#getApplyStatement_Count()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Literal getCount();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.pipeline.ApplyStatement#getCount <em>Count</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Count</em>' containment reference.
	 * @see #getCount()
	 * @generated
	 */
	void setCount(Literal value);

	/**
	 * Returns the value of the '<em><b>Pipelines</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.execution.VariableReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pipelines</em>' containment reference list.
	 * @see de.evoal.languages.model.pipeline.PipelinePackage#getApplyStatement_Pipelines()
	 * @model containment="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<VariableReference> getPipelines();

} // ApplyStatement
