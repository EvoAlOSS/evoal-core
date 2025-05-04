/**
 */
package de.evoal.languages.model.mll;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prediction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.Prediction#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.Prediction#getInputs <em>Inputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.Prediction#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.Prediction#getQuality <em>Quality</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getPrediction()
 * @model
 * @generated
 */
public interface Prediction extends EObject {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(SurrogateDefinition)
	 * @see de.evoal.languages.model.mll.MllPackage#getPrediction_Definition()
	 * @model required="true"
	 * @generated
	 */
	SurrogateDefinition getDefinition();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.Prediction#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(SurrogateDefinition value);

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.definitions.DataDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getPrediction_Inputs()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<de.evoal.languages.model.base.definitions.DataDescription> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.definitions.DataDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getPrediction_Outputs()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<de.evoal.languages.model.base.definitions.DataDescription> getOutputs();

	/**
	 * Returns the value of the '<em><b>Quality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Configuration of quality estimation.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Quality</em>' containment reference.
	 * @see #setQuality(BlockStatement)
	 * @see de.evoal.languages.model.mll.MllPackage#getPrediction_Quality()
	 * @model containment="true"
	 * @generated
	 */
	BlockStatement getQuality();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.Prediction#getQuality <em>Quality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality</em>' containment reference.
	 * @see #getQuality()
	 * @generated
	 */
	void setQuality(BlockStatement value);

} // Prediction
