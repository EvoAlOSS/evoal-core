/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol;

import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Instance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Algorithm Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * An optimisation algirthm instance.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ol.AlgorithmInstance#getProblem <em>Problem</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.AlgorithmInstance#getDocumentation <em>Documentation</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.ol.OLPackage#getAlgorithmInstance()
 * @model
 * @generated
 */
public interface AlgorithmInstance extends Instance {
	/**
	 * Returns the value of the '<em><b>Problem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The problem to solve.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Problem</em>' reference.
	 * @see #setProblem(ProblemInstance)
	 * @see de.evoal.languages.model.ol.OLPackage#getAlgorithmInstance_Problem()
	 * @model required="true"
	 * @generated
	 */
	ProblemInstance getProblem();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.AlgorithmInstance#getProblem <em>Problem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Problem</em>' reference.
	 * @see #getProblem()
	 * @generated
	 */
	void setProblem(ProblemInstance value);

	/**
	 * Returns the value of the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The data to log.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Documentation</em>' containment reference.
	 * @see #setDocumentation(Array)
	 * @see de.evoal.languages.model.ol.OLPackage#getAlgorithmInstance_Documentation()
	 * @model containment="true"
	 * @generated
	 */
	Array getDocumentation();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.ol.AlgorithmInstance#getDocumentation <em>Documentation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Documentation</em>' containment reference.
	 * @see #getDocumentation()
	 * @generated
	 */
	void setDocumentation(Array value);

} // AlgorithmInstance
