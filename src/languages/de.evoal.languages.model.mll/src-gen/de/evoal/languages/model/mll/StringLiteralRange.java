/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.base.StringLiteral;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.StringLiteralRange#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getStringLiteralRange()
 * @model
 * @generated
 */
public interface StringLiteralRange extends Range {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.StringLiteral}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getStringLiteralRange_Elements()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<StringLiteral> getElements();

} // StringLiteralRange
