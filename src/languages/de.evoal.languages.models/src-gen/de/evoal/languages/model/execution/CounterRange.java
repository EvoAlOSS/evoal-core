/**
 * EvoAl project
 */
package de.evoal.languages.model.execution;

import de.evoal.languages.model.base.expressions.Literal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Counter Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A counter-based range. The
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.execution.CounterRange#getStart <em>Start</em>}</li>
 *   <li>{@link de.evoal.languages.model.execution.CounterRange#getEnd <em>End</em>}</li>
 *   <li>{@link de.evoal.languages.model.execution.CounterRange#getIncrement <em>Increment</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.execution.ExecutionPackage#getCounterRange()
 * @model
 * @generated
 */
public interface CounterRange extends Range {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The starting value (inclusive).
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Start</em>' containment reference.
	 * @see #setStart(Literal)
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getCounterRange_Start()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Literal getStart();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.execution.CounterRange#getStart <em>Start</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' containment reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(Literal value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The ending value (inclusive).
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>End</em>' containment reference.
	 * @see #setEnd(Literal)
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getCounterRange_End()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Literal getEnd();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.execution.CounterRange#getEnd <em>End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' containment reference.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(Literal value);

	/**
	 * Returns the value of the '<em><b>Increment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The increment for each iteration.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Increment</em>' containment reference.
	 * @see #setIncrement(Literal)
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getCounterRange_Increment()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Literal getIncrement();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.execution.CounterRange#getIncrement <em>Increment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Increment</em>' containment reference.
	 * @see #getIncrement()
	 * @generated
	 */
	void setIncrement(Literal value);

} // CounterRange
