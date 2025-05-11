/**
 * EvoAl project
 */
package de.evoal.languages.model.execution;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A for-loop ... it does what is sounds like.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.execution.ForStatement#getVar <em>Var</em>}</li>
 *   <li>{@link de.evoal.languages.model.execution.ForStatement#getRange <em>Range</em>}</li>
 *   <li>{@link de.evoal.languages.model.execution.ForStatement#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.execution.ExecutionPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The loop variable.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Var</em>' containment reference.
	 * @see #setVar(NamedVariable)
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getForStatement_Var()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NamedVariable getVar();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.execution.ForStatement#getVar <em>Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var</em>' containment reference.
	 * @see #getVar()
	 * @generated
	 */
	void setVar(NamedVariable value);

	/**
	 * Returns the value of the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The range to iterate over. See the implementations for details.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Range</em>' containment reference.
	 * @see #setRange(Range)
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getForStatement_Range()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Range getRange();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.execution.ForStatement#getRange <em>Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' containment reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(Range value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The loop body.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Block)
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getForStatement_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Block getBody();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.execution.ForStatement#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Block value);

} // ForStatement
