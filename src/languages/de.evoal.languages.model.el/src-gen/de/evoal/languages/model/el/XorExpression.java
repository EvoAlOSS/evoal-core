/**
 */
package de.evoal.languages.model.el;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xor Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.el.XorExpression#getSubExpressions <em>Sub Expressions</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.el.ELPackage#getXorExpression()
 * @model
 * @generated
 */
public interface XorExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Sub Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.el.AndExpression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Expressions</em>' containment reference list.
	 * @see de.evoal.languages.model.el.ELPackage#getXorExpression_SubExpressions()
	 * @model containment="true" required="true"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<AndExpression> getSubExpressions();

} // XorExpression
