/**
 * EvoAl project
 */
package de.evoal.languages.model.execution;

import de.evoal.languages.model.base.expressions.ReadExpression;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * A list of 'pre-defined' values to iterate over.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.execution.ValueRange#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.execution.ExecutionPackage#getValueRange()
 * @model
 * @generated
 */
public interface ValueRange extends Range {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.ReadExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The literals to iterate over.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see de.evoal.languages.model.execution.ExecutionPackage#getValueRange_Elements()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<ReadExpression> getElements();

} // ValueRange
