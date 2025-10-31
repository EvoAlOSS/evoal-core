/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.base.definitions.DataDescription;

import de.evoal.languages.model.execution.NamedVariable;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 * Definition of a learning task.
 * 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.TaskDescription#getInputs <em>Inputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.TaskDescription#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.TaskDescription#getLearningData <em>Learning Data</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.TaskDescription#getTestingData <em>Testing Data</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.TaskDescription#getModelFile <em>Model File</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.TaskDescription#getGofFile <em>Gof File</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getTaskDescription()
 * @model
 * @generated
 */
public interface TaskDescription extends NamedVariable {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.definitions.DataDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The inputs of the learning task.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getTaskDescription_Inputs()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<DataDescription> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.definitions.DataDescription}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The outputs of the learning task.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getTaskDescription_Outputs()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<DataDescription> getOutputs();

	/**
	 * Returns the value of the '<em><b>Learning Data</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * A set of files (or directories) containing learning data.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Learning Data</em>' attribute list.
	 * @see de.evoal.languages.model.mll.MllPackage#getTaskDescription_LearningData()
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<String> getLearningData();

	/**
	 * Returns the value of the '<em><b>Testing Data</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * A set of files (or directories) containing training data.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Testing Data</em>' attribute list.
	 * @see de.evoal.languages.model.mll.MllPackage#getTaskDescription_TestingData()
	 * @model ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<String> getTestingData();

	/**
	 * Returns the value of the '<em><b>Model File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The filename of the learned model.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model File</em>' attribute.
	 * @see #setModelFile(String)
	 * @see de.evoal.languages.model.mll.MllPackage#getTaskDescription_ModelFile()
	 * @model required="true"
	 * @generated
	 */
	String getModelFile();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.TaskDescription#getModelFile <em>Model File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model File</em>' attribute.
	 * @see #getModelFile()
	 * @generated
	 */
	void setModelFile(String value);

	/**
	 * Returns the value of the '<em><b>Gof File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The filename of the GoF file.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gof File</em>' attribute.
	 * @see #setGofFile(String)
	 * @see de.evoal.languages.model.mll.MllPackage#getTaskDescription_GofFile()
	 * @model
	 * @generated
	 */
	String getGofFile();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.TaskDescription#getGofFile <em>Gof File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gof File</em>' attribute.
	 * @see #getGofFile()
	 * @generated
	 */
	void setGofFile(String value);

} // TaskDescription
