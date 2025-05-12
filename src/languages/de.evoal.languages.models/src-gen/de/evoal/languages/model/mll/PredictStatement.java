/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.execution.Block;
import de.evoal.languages.model.execution.Statement;

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
 *   <li>{@link de.evoal.languages.model.mll.PredictStatement#getModelFilename <em>Model Filename</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.PredictStatement#getTrainingData <em>Training Data</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.PredictStatement#getMeasurements <em>Measurements</em>}</li>
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
	 * Returns the value of the '<em><b>Model Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model Filename</em>' attribute.
	 * @see #setModelFilename(String)
	 * @see de.evoal.languages.model.mll.MllPackage#getPredictStatement_ModelFilename()
	 * @model required="true"
	 * @generated
	 */
	String getModelFilename();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.PredictStatement#getModelFilename <em>Model Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Filename</em>' attribute.
	 * @see #getModelFilename()
	 * @generated
	 */
	void setModelFilename(String value);

	/**
	 * Returns the value of the '<em><b>Training Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Training Data</em>' attribute.
	 * @see #setTrainingData(String)
	 * @see de.evoal.languages.model.mll.MllPackage#getPredictStatement_TrainingData()
	 * @model required="true"
	 * @generated
	 */
	String getTrainingData();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.PredictStatement#getTrainingData <em>Training Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Training Data</em>' attribute.
	 * @see #getTrainingData()
	 * @generated
	 */
	void setTrainingData(String value);

	/**
	 * Returns the value of the '<em><b>Measurements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurements</em>' containment reference.
	 * @see #setMeasurements(Block)
	 * @see de.evoal.languages.model.mll.MllPackage#getPredictStatement_Measurements()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Block getMeasurements();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.PredictStatement#getMeasurements <em>Measurements</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measurements</em>' containment reference.
	 * @see #getMeasurements()
	 * @generated
	 */
	void setMeasurements(Block value);

} // PredictStatement
