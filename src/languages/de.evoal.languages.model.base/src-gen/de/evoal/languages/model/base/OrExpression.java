/**
 */
package de.evoal.languages.model.base;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Or Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.OrExpression#getSubExpressions <em>Sub Expressions</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.base.BasePackage#getOrExpression()
 * @model
 * @generated
 */
public interface OrExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Sub Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.XorExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Expressions</em>' containment reference list.
	 * @see de.evoal.languages.model.base.BasePackage#getOrExpression_SubExpressions()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<XorExpression> getSubExpressions();

} // OrExpression
