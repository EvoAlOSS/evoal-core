/**
 */
package de.evoal.languages.model.mll;

import de.evoal.languages.model.base.BasePackage;
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
 * /*
 * The definition language allows us to define types and functions for
 * configuration purposes.import ecore : 'http://www.eclipse.org/emf/2002/Ecore';
 * <!-- end-model-doc -->
 * @see de.evoal.languages.model.mll.MllFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ddl='platform:/resource/de.evoal.languages.model.ddl/model/model.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore' el='platform:/resource/de.evoal.languages.model.base/model/model.ecore#/' instance='platform:/resource/de.evoal.languages.model.instance/model/model.ecore#/'"
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
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.MachineLearningConfigurationImpl <em>Machine Learning Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.MachineLearningConfigurationImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getMachineLearningConfiguration()
	 * @generated
	 */
	int MACHINE_LEARNING_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_CONFIGURATION__IMPORTS = 0;

	/**
	 * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_CONFIGURATION__DEFINITIONS = 1;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_CONFIGURATION__STATEMENTS = 2;

	/**
	 * The number of structural features of the '<em>Machine Learning Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MACHINE_LEARNING_CONFIGURATION_FEATURE_COUNT = 3;

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
	int SURROGATE_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURROGATE_DEFINITION__INPUTS = 1;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURROGATE_DEFINITION__OUTPUTS = 2;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURROGATE_DEFINITION__LAYERS = 3;

	/**
	 * The number of structural features of the '<em>Surrogate Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURROGATE_DEFINITION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.SurrogateLayerDefinitionImpl <em>Surrogate Layer Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.SurrogateLayerDefinitionImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getSurrogateLayerDefinition()
	 * @generated
	 */
	int SURROGATE_LAYER_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURROGATE_LAYER_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURROGATE_LAYER_DEFINITION__FUNCTIONS = 1;

	/**
	 * The number of structural features of the '<em>Surrogate Layer Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURROGATE_LAYER_DEFINITION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.PartialSurrogateFunctionDefinitionImpl <em>Partial Surrogate Function Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.PartialSurrogateFunctionDefinitionImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getPartialSurrogateFunctionDefinition()
	 * @generated
	 */
	int PARTIAL_SURROGATE_FUNCTION_DEFINITION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_SURROGATE_FUNCTION_DEFINITION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS = 1;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS = 2;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_SURROGATE_FUNCTION_DEFINITION__PARAMETERS = 3;

	/**
	 * The number of structural features of the '<em>Partial Surrogate Function Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTIAL_SURROGATE_FUNCTION_DEFINITION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.PredictionImpl <em>Prediction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.PredictionImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getPrediction()
	 * @generated
	 */
	int PREDICTION = 4;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICTION__DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICTION__INPUTS = 1;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICTION__OUTPUTS = 2;

	/**
	 * The feature id for the '<em><b>Quality</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICTION__QUALITY = 3;

	/**
	 * The number of structural features of the '<em>Prediction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICTION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.StatementImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 5;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.CallStatementImpl <em>Call Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.CallStatementImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getCallStatement()
	 * @generated
	 */
	int CALL_STATEMENT = 6;

	/**
	 * The feature id for the '<em><b>Call</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATEMENT__CALL = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Call Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.BlockStatementImpl <em>Block Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.BlockStatementImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getBlockStatement()
	 * @generated
	 */
	int BLOCK_STATEMENT = 7;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.PredictStatementImpl <em>Predict Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.PredictStatementImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getPredictStatement()
	 * @generated
	 */
	int PREDICT_STATEMENT = 8;

	/**
	 * The feature id for the '<em><b>Surrogate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICT_STATEMENT__SURROGATE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICT_STATEMENT__MODEL_FILENAME = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Training Data</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICT_STATEMENT__TRAINING_DATA = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICT_STATEMENT__STATEMENTS = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Predict Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICT_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.ForStatementImpl <em>For Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.ForStatementImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getForStatement()
	 * @generated
	 */
	int FOR_STATEMENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__NAME = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__RANGE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__STATEMENTS = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>For Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.RangeImpl <em>Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.RangeImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getRange()
	 * @generated
	 */
	int RANGE = 10;

	/**
	 * The number of structural features of the '<em>Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.CounterRangeImpl <em>Counter Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.CounterRangeImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getCounterRange()
	 * @generated
	 */
	int COUNTER_RANGE = 11;

	/**
	 * The feature id for the '<em><b>Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_RANGE__START = RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_RANGE__END = RANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Counter Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_RANGE_FEATURE_COUNT = RANGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.StringLiteralRangeImpl <em>String Literal Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.StringLiteralRangeImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getStringLiteralRange()
	 * @generated
	 */
	int STRING_LITERAL_RANGE = 12;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_RANGE__ELEMENTS = RANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_RANGE_FEATURE_COUNT = RANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.mll.impl.DefinedFunctionNameImpl <em>Defined Function Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.mll.impl.DefinedFunctionNameImpl
	 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getDefinedFunctionName()
	 * @generated
	 */
	int DEFINED_FUNCTION_NAME = 13;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_FUNCTION_NAME__DEFINITION = BasePackage.FUNCTION_NAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Defined Function Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_FUNCTION_NAME_FEATURE_COUNT = BasePackage.FUNCTION_NAME_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.MachineLearningConfiguration <em>Machine Learning Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Machine Learning Configuration</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningConfiguration
	 * @generated
	 */
	EClass getMachineLearningConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.MachineLearningConfiguration#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningConfiguration#getImports()
	 * @see #getMachineLearningConfiguration()
	 * @generated
	 */
	EReference getMachineLearningConfiguration_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.MachineLearningConfiguration#getDefinitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Definitions</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningConfiguration#getDefinitions()
	 * @see #getMachineLearningConfiguration()
	 * @generated
	 */
	EReference getMachineLearningConfiguration_Definitions();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.MachineLearningConfiguration#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see de.evoal.languages.model.mll.MachineLearningConfiguration#getStatements()
	 * @see #getMachineLearningConfiguration()
	 * @generated
	 */
	EReference getMachineLearningConfiguration_Statements();

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
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.mll.SurrogateDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.mll.SurrogateDefinition#getName()
	 * @see #getSurrogateDefinition()
	 * @generated
	 */
	EAttribute getSurrogateDefinition_Name();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.languages.model.mll.SurrogateDefinition#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see de.evoal.languages.model.mll.SurrogateDefinition#getInputs()
	 * @see #getSurrogateDefinition()
	 * @generated
	 */
	EReference getSurrogateDefinition_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.languages.model.mll.SurrogateDefinition#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see de.evoal.languages.model.mll.SurrogateDefinition#getOutputs()
	 * @see #getSurrogateDefinition()
	 * @generated
	 */
	EReference getSurrogateDefinition_Outputs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.SurrogateDefinition#getLayers <em>Layers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Layers</em>'.
	 * @see de.evoal.languages.model.mll.SurrogateDefinition#getLayers()
	 * @see #getSurrogateDefinition()
	 * @generated
	 */
	EReference getSurrogateDefinition_Layers();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.SurrogateLayerDefinition <em>Surrogate Layer Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Surrogate Layer Definition</em>'.
	 * @see de.evoal.languages.model.mll.SurrogateLayerDefinition
	 * @generated
	 */
	EClass getSurrogateLayerDefinition();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.mll.SurrogateLayerDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.mll.SurrogateLayerDefinition#getName()
	 * @see #getSurrogateLayerDefinition()
	 * @generated
	 */
	EAttribute getSurrogateLayerDefinition_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.SurrogateLayerDefinition#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see de.evoal.languages.model.mll.SurrogateLayerDefinition#getFunctions()
	 * @see #getSurrogateLayerDefinition()
	 * @generated
	 */
	EReference getSurrogateLayerDefinition_Functions();

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
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Name</em>'.
	 * @see de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition#getName()
	 * @see #getPartialSurrogateFunctionDefinition()
	 * @generated
	 */
	EReference getPartialSurrogateFunctionDefinition_Name();

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
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition#getParameters()
	 * @see #getPartialSurrogateFunctionDefinition()
	 * @generated
	 */
	EReference getPartialSurrogateFunctionDefinition_Parameters();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.Prediction <em>Prediction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prediction</em>'.
	 * @see de.evoal.languages.model.mll.Prediction
	 * @generated
	 */
	EClass getPrediction();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.mll.Prediction#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.mll.Prediction#getDefinition()
	 * @see #getPrediction()
	 * @generated
	 */
	EReference getPrediction_Definition();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.languages.model.mll.Prediction#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see de.evoal.languages.model.mll.Prediction#getInputs()
	 * @see #getPrediction()
	 * @generated
	 */
	EReference getPrediction_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link de.evoal.languages.model.mll.Prediction#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see de.evoal.languages.model.mll.Prediction#getOutputs()
	 * @see #getPrediction()
	 * @generated
	 */
	EReference getPrediction_Outputs();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.mll.Prediction#getQuality <em>Quality</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Quality</em>'.
	 * @see de.evoal.languages.model.mll.Prediction#getQuality()
	 * @see #getPrediction()
	 * @generated
	 */
	EReference getPrediction_Quality();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see de.evoal.languages.model.mll.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.CallStatement <em>Call Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Statement</em>'.
	 * @see de.evoal.languages.model.mll.CallStatement
	 * @generated
	 */
	EClass getCallStatement();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.mll.CallStatement#getCall <em>Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Call</em>'.
	 * @see de.evoal.languages.model.mll.CallStatement#getCall()
	 * @see #getCallStatement()
	 * @generated
	 */
	EReference getCallStatement_Call();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.BlockStatement <em>Block Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Statement</em>'.
	 * @see de.evoal.languages.model.mll.BlockStatement
	 * @generated
	 */
	EClass getBlockStatement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.BlockStatement#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see de.evoal.languages.model.mll.BlockStatement#getStatements()
	 * @see #getBlockStatement()
	 * @generated
	 */
	EReference getBlockStatement_Statements();

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
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.PredictStatement#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see de.evoal.languages.model.mll.PredictStatement#getStatements()
	 * @see #getPredictStatement()
	 * @generated
	 */
	EReference getPredictStatement_Statements();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Statement</em>'.
	 * @see de.evoal.languages.model.mll.ForStatement
	 * @generated
	 */
	EClass getForStatement();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.mll.ForStatement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.mll.ForStatement#getName()
	 * @see #getForStatement()
	 * @generated
	 */
	EAttribute getForStatement_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.mll.ForStatement#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Range</em>'.
	 * @see de.evoal.languages.model.mll.ForStatement#getRange()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Range();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.ForStatement#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see de.evoal.languages.model.mll.ForStatement#getStatements()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Statements();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.Range <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range</em>'.
	 * @see de.evoal.languages.model.mll.Range
	 * @generated
	 */
	EClass getRange();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.CounterRange <em>Counter Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Counter Range</em>'.
	 * @see de.evoal.languages.model.mll.CounterRange
	 * @generated
	 */
	EClass getCounterRange();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.mll.CounterRange#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start</em>'.
	 * @see de.evoal.languages.model.mll.CounterRange#getStart()
	 * @see #getCounterRange()
	 * @generated
	 */
	EAttribute getCounterRange_Start();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.mll.CounterRange#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End</em>'.
	 * @see de.evoal.languages.model.mll.CounterRange#getEnd()
	 * @see #getCounterRange()
	 * @generated
	 */
	EAttribute getCounterRange_End();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.StringLiteralRange <em>String Literal Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Range</em>'.
	 * @see de.evoal.languages.model.mll.StringLiteralRange
	 * @generated
	 */
	EClass getStringLiteralRange();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.mll.StringLiteralRange#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see de.evoal.languages.model.mll.StringLiteralRange#getElements()
	 * @see #getStringLiteralRange()
	 * @generated
	 */
	EReference getStringLiteralRange_Elements();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.mll.DefinedFunctionName <em>Defined Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Defined Function Name</em>'.
	 * @see de.evoal.languages.model.mll.DefinedFunctionName
	 * @generated
	 */
	EClass getDefinedFunctionName();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.mll.DefinedFunctionName#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.mll.DefinedFunctionName#getDefinition()
	 * @see #getDefinedFunctionName()
	 * @generated
	 */
	EReference getDefinedFunctionName_Definition();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.MachineLearningConfigurationImpl <em>Machine Learning Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.MachineLearningConfigurationImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getMachineLearningConfiguration()
		 * @generated
		 */
		EClass MACHINE_LEARNING_CONFIGURATION = eINSTANCE.getMachineLearningConfiguration();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_CONFIGURATION__IMPORTS = eINSTANCE.getMachineLearningConfiguration_Imports();

		/**
		 * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_CONFIGURATION__DEFINITIONS = eINSTANCE.getMachineLearningConfiguration_Definitions();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MACHINE_LEARNING_CONFIGURATION__STATEMENTS = eINSTANCE.getMachineLearningConfiguration_Statements();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SURROGATE_DEFINITION__NAME = eINSTANCE.getSurrogateDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SURROGATE_DEFINITION__INPUTS = eINSTANCE.getSurrogateDefinition_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SURROGATE_DEFINITION__OUTPUTS = eINSTANCE.getSurrogateDefinition_Outputs();

		/**
		 * The meta object literal for the '<em><b>Layers</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SURROGATE_DEFINITION__LAYERS = eINSTANCE.getSurrogateDefinition_Layers();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.SurrogateLayerDefinitionImpl <em>Surrogate Layer Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.SurrogateLayerDefinitionImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getSurrogateLayerDefinition()
		 * @generated
		 */
		EClass SURROGATE_LAYER_DEFINITION = eINSTANCE.getSurrogateLayerDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SURROGATE_LAYER_DEFINITION__NAME = eINSTANCE.getSurrogateLayerDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SURROGATE_LAYER_DEFINITION__FUNCTIONS = eINSTANCE.getSurrogateLayerDefinition_Functions();

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
		 * The meta object literal for the '<em><b>Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTIAL_SURROGATE_FUNCTION_DEFINITION__NAME = eINSTANCE.getPartialSurrogateFunctionDefinition_Name();

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
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTIAL_SURROGATE_FUNCTION_DEFINITION__PARAMETERS = eINSTANCE.getPartialSurrogateFunctionDefinition_Parameters();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.PredictionImpl <em>Prediction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.PredictionImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getPrediction()
		 * @generated
		 */
		EClass PREDICTION = eINSTANCE.getPrediction();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICTION__DEFINITION = eINSTANCE.getPrediction_Definition();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICTION__INPUTS = eINSTANCE.getPrediction_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICTION__OUTPUTS = eINSTANCE.getPrediction_Outputs();

		/**
		 * The meta object literal for the '<em><b>Quality</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICTION__QUALITY = eINSTANCE.getPrediction_Quality();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.StatementImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.CallStatementImpl <em>Call Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.CallStatementImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getCallStatement()
		 * @generated
		 */
		EClass CALL_STATEMENT = eINSTANCE.getCallStatement();

		/**
		 * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_STATEMENT__CALL = eINSTANCE.getCallStatement_Call();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.BlockStatementImpl <em>Block Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.BlockStatementImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getBlockStatement()
		 * @generated
		 */
		EClass BLOCK_STATEMENT = eINSTANCE.getBlockStatement();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_STATEMENT__STATEMENTS = eINSTANCE.getBlockStatement_Statements();

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
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICT_STATEMENT__STATEMENTS = eINSTANCE.getPredictStatement_Statements();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.ForStatementImpl <em>For Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.ForStatementImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getForStatement()
		 * @generated
		 */
		EClass FOR_STATEMENT = eINSTANCE.getForStatement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOR_STATEMENT__NAME = eINSTANCE.getForStatement_Name();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__RANGE = eINSTANCE.getForStatement_Range();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__STATEMENTS = eINSTANCE.getForStatement_Statements();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.RangeImpl <em>Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.RangeImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getRange()
		 * @generated
		 */
		EClass RANGE = eINSTANCE.getRange();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.CounterRangeImpl <em>Counter Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.CounterRangeImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getCounterRange()
		 * @generated
		 */
		EClass COUNTER_RANGE = eINSTANCE.getCounterRange();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUNTER_RANGE__START = eINSTANCE.getCounterRange_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUNTER_RANGE__END = eINSTANCE.getCounterRange_End();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.StringLiteralRangeImpl <em>String Literal Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.StringLiteralRangeImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getStringLiteralRange()
		 * @generated
		 */
		EClass STRING_LITERAL_RANGE = eINSTANCE.getStringLiteralRange();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_LITERAL_RANGE__ELEMENTS = eINSTANCE.getStringLiteralRange_Elements();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.mll.impl.DefinedFunctionNameImpl <em>Defined Function Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.mll.impl.DefinedFunctionNameImpl
		 * @see de.evoal.languages.model.mll.impl.MllPackageImpl#getDefinedFunctionName()
		 * @generated
		 */
		EClass DEFINED_FUNCTION_NAME = eINSTANCE.getDefinedFunctionName();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINED_FUNCTION_NAME__DEFINITION = eINSTANCE.getDefinedFunctionName_Definition();

	}

} //MllPackage
