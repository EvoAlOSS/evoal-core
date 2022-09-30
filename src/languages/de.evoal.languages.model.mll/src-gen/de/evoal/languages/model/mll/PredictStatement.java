/**
 */
package de.evoal.languages.model.mll;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predict Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.PredictStatement#getSurrogate <em>Surrogate</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.PredictStatement#getFilename <em>Filename</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.PredictStatement#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getPredictStatement()
 * @model
 * @generated
 */
public interface PredictStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Surrogate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Surrogate</em>' reference.
	 * @see #setSurrogate(SurrogateDefinition)
	 * @see de.evoal.languages.model.mll.MllPackage#getPredictStatement_Surrogate()
	 * @model required="true"
	 * @generated
	 */
	SurrogateDefinition getSurrogate();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.PredictStatement#getSurrogate <em>Surrogate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Surrogate</em>' reference.
	 * @see #getSurrogate()
	 * @generated
	 */
	void setSurrogate(SurrogateDefinition value);

	/**
	 * Returns the value of the '<em><b>Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filename</em>' attribute.
	 * @see #setFilename(String)
	 * @see de.evoal.languages.model.mll.MllPackage#getPredictStatement_Filename()
	 * @model required="true"
	 * @generated
	 */
	String getFilename();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.PredictStatement#getFilename <em>Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' attribute.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(String value);

	/**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.mll.CallStatement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getPredictStatement_Statements()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<CallStatement> getStatements();

} // PredictStatement
