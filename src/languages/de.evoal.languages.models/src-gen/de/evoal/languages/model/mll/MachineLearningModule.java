/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.base.Import;
import de.evoal.languages.model.execution.Block;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Machine Learning Module</b></em>'.
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
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningModule#getImports <em>Imports</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningModule#getDefinitions <em>Definitions</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningModule#getBody <em>Body</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningModule#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningModule()
 * @model
 * @generated
 */
public interface MachineLearningModule extends EObject {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.base.Import}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Import statements
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningModule_Imports()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<Import> getImports();

	/**
	 * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link de.evoal.languages.model.mll.SurrogateDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of configured predictions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Definitions</em>' containment reference list.
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningModule_Definitions()
	 * @model containment="true" ordered="false"
	 *        annotation="http://www.eclipse.org/OCL/Collection nullFree='false'"
	 * @generated
	 */
	EList<SurrogateDefinition> getDefinitions();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of predictions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Block)
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningModule_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Block getBody();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.MachineLearningModule#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Block value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningModule_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.MachineLearningModule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // MachineLearningModule
