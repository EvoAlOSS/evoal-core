/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.base.Import;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.execution.Block;
import de.evoal.languages.model.generator.PipelineDefinition;
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
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningModule#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningModule#getTask <em>Task</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningModule#getValidation <em>Validation</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningModule#getPreparation <em>Preparation</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningModule#getModel <em>Model</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningModule#getGof <em>Gof</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningModule#getLearningUseCase <em>Learning Use Case</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.MachineLearningModule#getPredictionUseCase <em>Prediction Use Case</em>}</li>
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
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * Name of the module (necessary for importing).
	 * 
	 * <!-- end-model-doc -->
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

	/**
	 * Returns the value of the '<em><b>Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * An abstract description of the learning task.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Task</em>' containment reference.
	 * @see #setTask(TaskDescription)
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningModule_Task()
	 * @model containment="true" required="true"
	 * @generated
	 */
	TaskDescription getTask();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.MachineLearningModule#getTask <em>Task</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task</em>' containment reference.
	 * @see #getTask()
	 * @generated
	 */
	void setTask(TaskDescription value);

	/**
	 * Returns the value of the '<em><b>Validation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The data validation pipeline.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Validation</em>' containment reference.
	 * @see #setValidation(PipelineDefinition)
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningModule_Validation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PipelineDefinition getValidation();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.MachineLearningModule#getValidation <em>Validation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validation</em>' containment reference.
	 * @see #getValidation()
	 * @generated
	 */
	void setValidation(PipelineDefinition value);

	/**
	 * Returns the value of the '<em><b>Preparation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The data preparation pipeline.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Preparation</em>' containment reference.
	 * @see #setPreparation(PipelineDefinition)
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningModule_Preparation()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PipelineDefinition getPreparation();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.MachineLearningModule#getPreparation <em>Preparation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preparation</em>' containment reference.
	 * @see #getPreparation()
	 * @generated
	 */
	void setPreparation(PipelineDefinition value);

	/**
	 * Returns the value of the '<em><b>Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The actual model configuration to use.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model</em>' containment reference.
	 * @see #setModel(Instance)
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningModule_Model()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Instance getModel();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.MachineLearningModule#getModel <em>Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model</em>' containment reference.
	 * @see #getModel()
	 * @generated
	 */
	void setModel(Instance value);

	/**
	 * Returns the value of the '<em><b>Gof</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The goodness of fit pipeline.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Gof</em>' containment reference.
	 * @see #setGof(Block)
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningModule_Gof()
	 * @model containment="true"
	 * @generated
	 */
	Block getGof();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.MachineLearningModule#getGof <em>Gof</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gof</em>' containment reference.
	 * @see #getGof()
	 * @generated
	 */
	void setGof(Block value);

	/**
	 * Returns the value of the '<em><b>Learning Use Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The learning use-case pipeline.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Learning Use Case</em>' containment reference.
	 * @see #setLearningUseCase(Block)
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningModule_LearningUseCase()
	 * @model containment="true"
	 * @generated
	 */
	Block getLearningUseCase();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.MachineLearningModule#getLearningUseCase <em>Learning Use Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Learning Use Case</em>' containment reference.
	 * @see #getLearningUseCase()
	 * @generated
	 */
	void setLearningUseCase(Block value);

	/**
	 * Returns the value of the '<em><b>Prediction Use Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 
	 * The prediction use-case pipeline.
	 * 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Prediction Use Case</em>' containment reference.
	 * @see #setPredictionUseCase(PipelineDefinition)
	 * @see de.evoal.languages.model.mll.MllPackage#getMachineLearningModule_PredictionUseCase()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PipelineDefinition getPredictionUseCase();

	/**
	 * Sets the value of the '{@link de.evoal.languages.model.mll.MachineLearningModule#getPredictionUseCase <em>Prediction Use Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prediction Use Case</em>' containment reference.
	 * @see #getPredictionUseCase()
	 * @generated
	 */
	void setPredictionUseCase(PipelineDefinition value);

} // MachineLearningModule
