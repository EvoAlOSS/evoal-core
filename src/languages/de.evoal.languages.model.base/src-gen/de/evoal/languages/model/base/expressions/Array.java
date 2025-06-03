/**
 */
package de.evoal.languages.model.base.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.Array#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getArray()
 * @model
 * @generated
 */
public interface Array extends ReadExpression {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.expressions.ReadExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' containment reference list.
	 * @see de.evoal.languages.model.base.expressions.ExpressionsPackage#getArray_Values()
	 * @model containment="true"
	 * @generated
	 */
	EList<ReadExpression> getValues();

} // Array
