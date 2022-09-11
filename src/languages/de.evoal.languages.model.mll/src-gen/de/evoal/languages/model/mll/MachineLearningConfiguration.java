/**
 */
package de.evoal.languages.model.mll;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine Learning Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Entry point for the model.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningConfiguration#getUses <em>Uses</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningConfiguration#getDefinitions <em>Definitions</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningConfiguration#getPredictions <em>Predictions</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningConfiguration()
 * @model
 * @generated
 */
public interface MachineLearningConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Uses</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.mll.Use}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Import statements
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Uses</em>' containment reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningConfiguration_Uses()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Use> getUses();

	/**
	 * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.mll.SurrogateDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of configured predictions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Definitions</em>' containment reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningConfiguration_Definitions()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<SurrogateDefinition> getDefinitions();

	/**
	 * Returns the value of the '<em><b>Predictions</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.mll.Prediction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of predictions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Predictions</em>' containment reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningConfiguration_Predictions()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Prediction> getPredictions();

} // MachineLearningConfiguration
