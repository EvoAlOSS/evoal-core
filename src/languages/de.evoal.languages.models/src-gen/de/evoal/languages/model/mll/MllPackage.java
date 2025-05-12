/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;
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
 * The definition language allows us to define types and functions for
 *   configuration purposes
 * 
 * <!-- end-model-doc -->
 * @see de.evoal.languages.model.mll.MllFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import base='platform:/resource/de.evoal.languages.model.base/model/model.ecore#/' defs='platform:/resource/de.evoal.languages.model.base/model/definitions.ecore#/' exec='execution.ecore#/' expr='platform:/resource/de.evoal.languages.model.base/model/expressions.ecore#/'"
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
	 * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE__DEFINITIONS = 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE__BODY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE__NAME = 3;

	/**
	 * The number of structural features of the '<em>Machine Learning Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_MODULE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.SurrogateDefinitionImpl <em>Surrogate Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.SurrogateDefinitionImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getSurrogateDefinition()
	 * @generated
	 */
	int SURROGATE_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURROGATE_DEFINITION__NAME = ExecutionPackage.NAMED_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURROGATE_DEFINITION__FUNCTIONS = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Surrogate Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURROGATE_DEFINITION_FEATURE_COUNT = ExecutionPackage.NAMED_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.PartialSurrogateFunctionDefinitionImpl <em>Partial Surrogate Function Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.PartialSurrogateFunctionDefinitionImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getPartialSurrogateFunctionDefinition()
	 * @generated
	 */
	int PARTIAL_SURROGATE_FUNCTION_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_SURROGATE_FUNCTION_DEFINITION__DEFINITION = ExpressionsPackage.INSTANCE__DEFINITION;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_SURROGATE_FUNCTION_DEFINITION__ATTRIBUTES = ExpressionsPackage.INSTANCE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Partial Surrogate Function Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_SURROGATE_FUNCTION_DEFINITION_FEATURE_COUNT = ExpressionsPackage.INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.PredictStatementImpl <em>Predict Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.PredictStatementImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getPredictStatement()
	 * @generated
	 */
	int PREDICT_STATEMENT = 3;

	/**
	 * The feature id for the '<em><b>Surrogate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICT_STATEMENT__SURROGATE = ExecutionPackage.STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICT_STATEMENT__MODEL_FILENAME = ExecutionPackage.STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Training Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICT_STATEMENT__TRAINING_DATA = ExecutionPackage.STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Measurements</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICT_STATEMENT__MEASUREMENTS = ExecutionPackage.STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Predict Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICT_STATEMENT_FEATURE_COUNT = ExecutionPackage.STATEMENT_FEATURE_COUNT + 4;


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
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.MachineLearningModule#getDefinitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Definitions</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningModule#getDefinitions()
	 * @see #getMachineLearningModule()
	 * @generated
	 */
	EReference getMachineLearningModule_Definitions();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.mll.MachineLearningModule#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningModule#getBody()
	 * @see #getMachineLearningModule()
	 * @generated
	 */
	EReference getMachineLearningModule_Body();

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
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.SurrogateDefinition <em>Surrogate Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Surrogate Definition</em>'.
	 * @see de.evoal.languages.model.mll.SurrogateDefinition
	 * @generated
	 */
	EClass getSurrogateDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.SurrogateDefinition#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see de.evoal.languages.model.mll.SurrogateDefinition#getFunctions()
	 * @see #getSurrogateDefinition()
	 * @generated
	 */
	EReference getSurrogateDefinition_Functions();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition <em>Partial Surrogate Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partial Surrogate Function Definition</em>'.
	 * @see de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition
	 * @generated
	 */
	EClass getPartialSurrogateFunctionDefinition();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition#getInputs()
	 * @see #getPartialSurrogateFunctionDefinition()
	 * @generated
	 */
	EReference getPartialSurrogateFunctionDefinition_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition#getOutputs()
	 * @see #getPartialSurrogateFunctionDefinition()
	 * @generated
	 */
	EReference getPartialSurrogateFunctionDefinition_Outputs();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.PredictStatement <em>Predict Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predict Statement</em>'.
	 * @see de.evoal.languages.model.mll.PredictStatement
	 * @generated
	 */
	EClass getPredictStatement();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.mll.PredictStatement#getSurrogate <em>Surrogate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Surrogate</em>'.
	 * @see de.evoal.languages.model.mll.PredictStatement#getSurrogate()
	 * @see #getPredictStatement()
	 * @generated
	 */
	EReference getPredictStatement_Surrogate();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.mll.PredictStatement#getModelFilename <em>Model Filename</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Filename</em>'.
	 * @see de.evoal.languages.model.mll.PredictStatement#getModelFilename()
	 * @see #getPredictStatement()
	 * @generated
	 */
	EAttribute getPredictStatement_ModelFilename();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.mll.PredictStatement#getTrainingData <em>Training Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Training Data</em>'.
	 * @see de.evoal.languages.model.mll.PredictStatement#getTrainingData()
	 * @see #getPredictStatement()
	 * @generated
	 */
	EAttribute getPredictStatement_TrainingData();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.mll.PredictStatement#getMeasurements <em>Measurements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Measurements</em>'.
	 * @see de.evoal.languages.model.mll.PredictStatement#getMeasurements()
	 * @see #getPredictStatement()
	 * @generated
	 */
	EReference getPredictStatement_Measurements();

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
		 * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_MODULE__DEFINITIONS = eINSTANCE.getMachineLearningModule_Definitions();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_MODULE__BODY = eINSTANCE.getMachineLearningModule_Body();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MACHINE_LEARNING_MODULE__NAME = eINSTANCE.getMachineLearningModule_Name();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.SurrogateDefinitionImpl <em>Surrogate Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.SurrogateDefinitionImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getSurrogateDefinition()
		 * @generated
		 */
		EClass SURROGATE_DEFINITION = eINSTANCE.getSurrogateDefinition();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SURROGATE_DEFINITION__FUNCTIONS = eINSTANCE.getSurrogateDefinition_Functions();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.PartialSurrogateFunctionDefinitionImpl <em>Partial Surrogate Function Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.PartialSurrogateFunctionDefinitionImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getPartialSurrogateFunctionDefinition()
		 * @generated
		 */
		EClass PARTIAL_SURROGATE_FUNCTION_DEFINITION = eINSTANCE.getPartialSurrogateFunctionDefinition();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS = eINSTANCE.getPartialSurrogateFunctionDefinition_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS = eINSTANCE.getPartialSurrogateFunctionDefinition_Outputs();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.PredictStatementImpl <em>Predict Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.PredictStatementImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getPredictStatement()
		 * @generated
		 */
		EClass PREDICT_STATEMENT = eINSTANCE.getPredictStatement();

		/**
		 * The meta object literal for the '<em><b>Surrogate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICT_STATEMENT__SURROGATE = eINSTANCE.getPredictStatement_Surrogate();

		/**
		 * The meta object literal for the '<em><b>Model Filename</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDICT_STATEMENT__MODEL_FILENAME = eINSTANCE.getPredictStatement_ModelFilename();

		/**
		 * The meta object literal for the '<em><b>Training Data</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PREDICT_STATEMENT__TRAINING_DATA = eINSTANCE.getPredictStatement_TrainingData();

		/**
		 * The meta object literal for the '<em><b>Measurements</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICT_STATEMENT__MEASUREMENTS = eINSTANCE.getPredictStatement_Measurements();

	}

} //MllPackage
