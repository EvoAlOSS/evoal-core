/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.execution.ExecutionPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * The machine learning language allows us to define different aspects of machine learning.
 * 
 * <!-- end-model-doc -->
 * @see de.evoal.languages.model.mll.MllFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import base='platform:/resource/de.evoal.languages.model.base/model/model.ecore#/' defs='platform:/resource/de.evoal.languages.model.base/model/definitions.ecore#/' exec='execution.ecore#/' expr='platform:/resource/de.evoal.languages.model.base/model/expressions.ecore#/' generator='generator.ecore#/'"
 * @generated
 */
public interface MllPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "mll";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/mll/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mll";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MllPackage eINSTANCE = de.evoal.languages.model.mll.impl.MllPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.MachineLearningModuleImpl <em>Machine Learning Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.MachineLearningModuleImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getMachineLearningModule()
	 * @generated
	 */
	int MACHINE_LEARNING_MODULE = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE__IMPORTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Task</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE__TASK = 2;

	/**
	 * The feature id for the '<em><b>Validation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE__VALIDATION = 3;

	/**
	 * The feature id for the '<em><b>Preparation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE__PREPARATION = 4;

	/**
	 * The feature id for the '<em><b>Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE__MODEL = 5;

	/**
	 * The feature id for the '<em><b>Gof</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE__GOF = 6;

	/**
	 * The feature id for the '<em><b>Learning Use Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE__LEARNING_USE_CASE = 7;

	/**
	 * The feature id for the '<em><b>Prediction Use Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE__PREDICTION_USE_CASE = 8;

	/**
	 * The number of structural features of the '<em>Machine Learning Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE_FEATURE_COUNT = 9;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.TaskDescriptionImpl <em>Task Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.TaskDescriptionImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getTaskDescription()
	 * @generated
	 */
	int TASK_DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_DESCRIPTION__NAME = ExecutionPackage.NAMED_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_DESCRIPTION__INPUTS = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_DESCRIPTION__OUTPUTS = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Learning Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_DESCRIPTION__LEARNING_DATA = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Testing Data</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_DESCRIPTION__TESTING_DATA = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Model File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_DESCRIPTION__MODEL_FILE = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Gof File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_DESCRIPTION__GOF_FILE = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Task Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASK_DESCRIPTION_FEATURE_COUNT = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 6;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.MachineLearningModule <em>Machine Learning Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Learning Module</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningModule
	 * @generated
	 */
	EClass getMachineLearningModule();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.MachineLearningModule#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningModule#getImports()
	 * @see #getMachineLearningModule()
	 * @generated
	 */
	EReference getMachineLearningModule_Imports();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.mll.MachineLearningModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningModule#getName()
	 * @see #getMachineLearningModule()
	 * @generated
	 */
	EAttribute getMachineLearningModule_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.mll.MachineLearningModule#getTask <em>Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Task</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningModule#getTask()
	 * @see #getMachineLearningModule()
	 * @generated
	 */
	EReference getMachineLearningModule_Task();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.mll.MachineLearningModule#getValidation <em>Validation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Validation</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningModule#getValidation()
	 * @see #getMachineLearningModule()
	 * @generated
	 */
	EReference getMachineLearningModule_Validation();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.mll.MachineLearningModule#getPreparation <em>Preparation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Preparation</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningModule#getPreparation()
	 * @see #getMachineLearningModule()
	 * @generated
	 */
	EReference getMachineLearningModule_Preparation();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.mll.MachineLearningModule#getModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Model</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningModule#getModel()
	 * @see #getMachineLearningModule()
	 * @generated
	 */
	EReference getMachineLearningModule_Model();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.mll.MachineLearningModule#getGof <em>Gof</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Gof</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningModule#getGof()
	 * @see #getMachineLearningModule()
	 * @generated
	 */
	EReference getMachineLearningModule_Gof();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.mll.MachineLearningModule#getLearningUseCase <em>Learning Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Learning Use Case</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningModule#getLearningUseCase()
	 * @see #getMachineLearningModule()
	 * @generated
	 */
	EReference getMachineLearningModule_LearningUseCase();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.mll.MachineLearningModule#getPredictionUseCase <em>Prediction Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Prediction Use Case</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningModule#getPredictionUseCase()
	 * @see #getMachineLearningModule()
	 * @generated
	 */
	EReference getMachineLearningModule_PredictionUseCase();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.TaskDescription <em>Task Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Task Description</em>'.
	 * @see de.evoal.languages.model.mll.TaskDescription
	 * @generated
	 */
	EClass getTaskDescription();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.languages.model.mll.TaskDescription#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see de.evoal.languages.model.mll.TaskDescription#getInputs()
	 * @see #getTaskDescription()
	 * @generated
	 */
	EReference getTaskDescription_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.languages.model.mll.TaskDescription#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see de.evoal.languages.model.mll.TaskDescription#getOutputs()
	 * @see #getTaskDescription()
	 * @generated
	 */
	EReference getTaskDescription_Outputs();

	/**
	 * Returns the meta object for the attribute list '{@link de.evoal.languages.model.mll.TaskDescription#getLearningData <em>Learning Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Learning Data</em>'.
	 * @see de.evoal.languages.model.mll.TaskDescription#getLearningData()
	 * @see #getTaskDescription()
	 * @generated
	 */
	EAttribute getTaskDescription_LearningData();

	/**
	 * Returns the meta object for the attribute list '{@link de.evoal.languages.model.mll.TaskDescription#getTestingData <em>Testing Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Testing Data</em>'.
	 * @see de.evoal.languages.model.mll.TaskDescription#getTestingData()
	 * @see #getTaskDescription()
	 * @generated
	 */
	EAttribute getTaskDescription_TestingData();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.mll.TaskDescription#getModelFile <em>Model File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model File</em>'.
	 * @see de.evoal.languages.model.mll.TaskDescription#getModelFile()
	 * @see #getTaskDescription()
	 * @generated
	 */
	EAttribute getTaskDescription_ModelFile();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.mll.TaskDescription#getGofFile <em>Gof File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gof File</em>'.
	 * @see de.evoal.languages.model.mll.TaskDescription#getGofFile()
	 * @see #getTaskDescription()
	 * @generated
	 */
	EAttribute getTaskDescription_GofFile();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MllFactory getMllFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.MachineLearningModuleImpl <em>Machine Learning Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.MachineLearningModuleImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getMachineLearningModule()
		 * @generated
		 */
		EClass MACHINE_LEARNING_MODULE = eINSTANCE.getMachineLearningModule();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_MODULE__IMPORTS = eINSTANCE.getMachineLearningModule_Imports();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE_LEARNING_MODULE__NAME = eINSTANCE.getMachineLearningModule_Name();

		/**
		 * The meta object literal for the '<em><b>Task</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_MODULE__TASK = eINSTANCE.getMachineLearningModule_Task();

		/**
		 * The meta object literal for the '<em><b>Validation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_MODULE__VALIDATION = eINSTANCE.getMachineLearningModule_Validation();

		/**
		 * The meta object literal for the '<em><b>Preparation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_MODULE__PREPARATION = eINSTANCE.getMachineLearningModule_Preparation();

		/**
		 * The meta object literal for the '<em><b>Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_MODULE__MODEL = eINSTANCE.getMachineLearningModule_Model();

		/**
		 * The meta object literal for the '<em><b>Gof</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_MODULE__GOF = eINSTANCE.getMachineLearningModule_Gof();

		/**
		 * The meta object literal for the '<em><b>Learning Use Case</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_MODULE__LEARNING_USE_CASE = eINSTANCE.getMachineLearningModule_LearningUseCase();

		/**
		 * The meta object literal for the '<em><b>Prediction Use Case</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_MODULE__PREDICTION_USE_CASE = eINSTANCE.getMachineLearningModule_PredictionUseCase();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.TaskDescriptionImpl <em>Task Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.TaskDescriptionImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getTaskDescription()
		 * @generated
		 */
		EClass TASK_DESCRIPTION = eINSTANCE.getTaskDescription();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_DESCRIPTION__INPUTS = eINSTANCE.getTaskDescription_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASK_DESCRIPTION__OUTPUTS = eINSTANCE.getTaskDescription_Outputs();

		/**
		 * The meta object literal for the '<em><b>Learning Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_DESCRIPTION__LEARNING_DATA = eINSTANCE.getTaskDescription_LearningData();

		/**
		 * The meta object literal for the '<em><b>Testing Data</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_DESCRIPTION__TESTING_DATA = eINSTANCE.getTaskDescription_TestingData();

		/**
		 * The meta object literal for the '<em><b>Model File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_DESCRIPTION__MODEL_FILE = eINSTANCE.getTaskDescription_ModelFile();

		/**
		 * The meta object literal for the '<em><b>Gof File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TASK_DESCRIPTION__GOF_FILE = eINSTANCE.getTaskDescription_GofFile();

	}

} //MllPackage
