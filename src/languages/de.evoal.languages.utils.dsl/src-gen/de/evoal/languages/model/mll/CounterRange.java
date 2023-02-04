/**
 */
package de.evoal.languages.model.mll;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Counter Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.CounterRange#getStart <em>Start</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.CounterRange#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getCounterRange()
 * @model
 * @generated
 */
public interface CounterRange extends Range {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' attribute.
	 * @see #setStart(int)
	 * @see de.evoal.languages.model.mll.MllPackage#getCounterRange_Start()
	 * @model required="true"
	 * @generated
	 */
	int getStart();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.CounterRange#getStart <em>Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' attribute.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(int value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' attribute.
	 * @see #setEnd(int)
	 * @see de.evoal.languages.model.mll.MllPackage#getCounterRange_End()
	 * @model required="true"
	 * @generated
	 */
	int getEnd();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.CounterRange#getEnd <em>End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' attribute.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(int value);

} // CounterRange
