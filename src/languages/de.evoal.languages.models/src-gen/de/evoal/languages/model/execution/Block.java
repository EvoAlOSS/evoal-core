/**
 * EvoAl project
 */
package de.evoal.languages.model.execution;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A block of statements.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.execution.Block#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.execution.ExecutionPackage#getBlock()
 * @model
 * @generated
 */
public interface Block extends Statement {
	/**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.execution.Statement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Ordered list of statements.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getBlock_Statements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getStatements();

} // Block
