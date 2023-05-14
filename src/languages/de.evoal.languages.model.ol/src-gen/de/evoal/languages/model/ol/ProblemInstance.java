/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

import de.evoal.languages.model.base.Array;
import de.evoal.languages.model.base.Instance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Problem Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ol.ProblemInstance#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.ProblemInstance#getDocumentation <em>Documentation</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ol.OLPackage#getProblemInstance()
 * @model
 * @generated
 */
public interface ProblemInstance extends Instance {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.languages.model.ol.OLPackage#getProblemInstance_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.ProblemInstance#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Documentation</em>' containment reference.
	 * @see #setDocumentation(Array)
	 * @see de.evoal.languages.model.ol.OLPackage#getProblemInstance_Documentation()
	 * @model containment="true"
	 * @generated
	 */
	Array getDocumentation();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.ProblemInstance#getDocumentation <em>Documentation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documentation</em>' containment reference.
	 * @see #getDocumentation()
	 * @generated
	 */
	void setDocumentation(Array value);

} // ProblemInstance
