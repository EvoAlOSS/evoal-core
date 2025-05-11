/**
 * EvoAl project
 */
package de.evoal.languages.model.execution;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;

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
 * @see de.evoal.languages.model.execution.ExecutionFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import base='platform:/resource/de.evoal.languages.model.base/model/model.ecore#/' defs='platform:/resource/de.evoal.languages.model.base/model/definitions.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore' expr='platform:/resource/de.evoal.languages.model.base/model/expressions.ecore#/'"
 * @generated
 */
public interface ExecutionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "execution";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/execution/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "exec";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionPackage eINSTANCE = de.evoal.languages.model.execution.impl.ExecutionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.ExecutionModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.ExecutionModuleImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getExecutionModule()
	 * @generated
	 */
	int EXECUTION_MODULE = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_MODULE__IMPORTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_MODULE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Program</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_MODULE__PROGRAM = 2;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_MODULE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.ProgramImpl <em>Program</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.ProgramImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getProgram()
	 * @generated
	 */
	int PROGRAM = 1;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__FUNCTIONS = 0;

	/**
	 * The feature id for the '<em><b>Main</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__MAIN = 1;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM__VARIABLES = 2;

	/**
	 * The number of structural features of the '<em>Program</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROGRAM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.FunctionImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 2;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.ModelFunctionImpl <em>Model Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.ModelFunctionImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getModelFunction()
	 * @generated
	 */
	int MODEL_FUNCTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FUNCTION__NAME = FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FUNCTION__VARIABLES = FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FUNCTION__BODY = FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Model Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_FUNCTION_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.StatementImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 4;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.CallStatementImpl <em>Call Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.CallStatementImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getCallStatement()
	 * @generated
	 */
	int CALL_STATEMENT = 5;

	/**
	 * The number of structural features of the '<em>Call Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.CallModelFunctionImpl <em>Call Model Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.CallModelFunctionImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getCallModelFunction()
	 * @generated
	 */
	int CALL_MODEL_FUNCTION = 6;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MODEL_FUNCTION__FUNCTION = CALL_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Call Model Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_MODEL_FUNCTION_FEATURE_COUNT = CALL_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.CallBuiltinFunctionImpl <em>Call Builtin Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.CallBuiltinFunctionImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getCallBuiltinFunction()
	 * @generated
	 */
	int CALL_BUILTIN_FUNCTION = 7;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_BUILTIN_FUNCTION__DEFINITION = CALL_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_BUILTIN_FUNCTION__PARAMETERS = CALL_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Call Builtin Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_BUILTIN_FUNCTION_FEATURE_COUNT = CALL_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.BlockImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 8;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.ForStatementImpl <em>For Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.ForStatementImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getForStatement()
	 * @generated
	 */
	int FOR_STATEMENT = 9;

	/**
	 * The feature id for the '<em><b>Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__VAR = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__RANGE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>For Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.RangeImpl <em>Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.RangeImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getRange()
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
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.CounterRangeImpl <em>Counter Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.CounterRangeImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getCounterRange()
	 * @generated
	 */
	int COUNTER_RANGE = 11;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_RANGE__START = RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_RANGE__END = RANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Increment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_RANGE__INCREMENT = RANGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Counter Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTER_RANGE_FEATURE_COUNT = RANGE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.ValueRangeImpl <em>Value Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.ValueRangeImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getValueRange()
	 * @generated
	 */
	int VALUE_RANGE = 12;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RANGE__ELEMENTS = RANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_RANGE_FEATURE_COUNT = RANGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.VariableReferenceImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getVariableReference()
	 * @generated
	 */
	int VARIABLE_REFERENCE = 13;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE__VARIABLE = ExpressionsPackage.VALUE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_REFERENCE_FEATURE_COUNT = ExpressionsPackage.VALUE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.VariableImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 14;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.execution.impl.NamedVariableImpl <em>Named Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.execution.impl.NamedVariableImpl
	 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getNamedVariable()
	 * @generated
	 */
	int NAMED_VARIABLE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_VARIABLE__NAME = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_VARIABLE_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.ExecutionModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see de.evoal.languages.model.execution.ExecutionModule
	 * @generated
	 */
	EClass getExecutionModule();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.execution.ExecutionModule#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see de.evoal.languages.model.execution.ExecutionModule#getImports()
	 * @see #getExecutionModule()
	 * @generated
	 */
	EReference getExecutionModule_Imports();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.execution.ExecutionModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.execution.ExecutionModule#getName()
	 * @see #getExecutionModule()
	 * @generated
	 */
	EAttribute getExecutionModule_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.execution.ExecutionModule#getProgram <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Program</em>'.
	 * @see de.evoal.languages.model.execution.ExecutionModule#getProgram()
	 * @see #getExecutionModule()
	 * @generated
	 */
	EReference getExecutionModule_Program();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Program</em>'.
	 * @see de.evoal.languages.model.execution.Program
	 * @generated
	 */
	EClass getProgram();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.execution.Program#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see de.evoal.languages.model.execution.Program#getFunctions()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Functions();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.execution.Program#getMain <em>Main</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Main</em>'.
	 * @see de.evoal.languages.model.execution.Program#getMain()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Main();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.execution.Program#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see de.evoal.languages.model.execution.Program#getVariables()
	 * @see #getProgram()
	 * @generated
	 */
	EReference getProgram_Variables();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see de.evoal.languages.model.execution.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.ModelFunction <em>Model Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Function</em>'.
	 * @see de.evoal.languages.model.execution.ModelFunction
	 * @generated
	 */
	EClass getModelFunction();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.execution.ModelFunction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.execution.ModelFunction#getName()
	 * @see #getModelFunction()
	 * @generated
	 */
	EAttribute getModelFunction_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.execution.ModelFunction#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see de.evoal.languages.model.execution.ModelFunction#getVariables()
	 * @see #getModelFunction()
	 * @generated
	 */
	EReference getModelFunction_Variables();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.execution.ModelFunction#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see de.evoal.languages.model.execution.ModelFunction#getBody()
	 * @see #getModelFunction()
	 * @generated
	 */
	EReference getModelFunction_Body();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see de.evoal.languages.model.execution.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.CallStatement <em>Call Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Statement</em>'.
	 * @see de.evoal.languages.model.execution.CallStatement
	 * @generated
	 */
	EClass getCallStatement();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.CallModelFunction <em>Call Model Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Model Function</em>'.
	 * @see de.evoal.languages.model.execution.CallModelFunction
	 * @generated
	 */
	EClass getCallModelFunction();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.execution.CallModelFunction#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see de.evoal.languages.model.execution.CallModelFunction#getFunction()
	 * @see #getCallModelFunction()
	 * @generated
	 */
	EReference getCallModelFunction_Function();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.CallBuiltinFunction <em>Call Builtin Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Builtin Function</em>'.
	 * @see de.evoal.languages.model.execution.CallBuiltinFunction
	 * @generated
	 */
	EClass getCallBuiltinFunction();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.execution.CallBuiltinFunction#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.execution.CallBuiltinFunction#getDefinition()
	 * @see #getCallBuiltinFunction()
	 * @generated
	 */
	EReference getCallBuiltinFunction_Definition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.execution.CallBuiltinFunction#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.evoal.languages.model.execution.CallBuiltinFunction#getParameters()
	 * @see #getCallBuiltinFunction()
	 * @generated
	 */
	EReference getCallBuiltinFunction_Parameters();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see de.evoal.languages.model.execution.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.execution.Block#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see de.evoal.languages.model.execution.Block#getStatements()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Statements();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Statement</em>'.
	 * @see de.evoal.languages.model.execution.ForStatement
	 * @generated
	 */
	EClass getForStatement();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.execution.ForStatement#getVar <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Var</em>'.
	 * @see de.evoal.languages.model.execution.ForStatement#getVar()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Var();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.execution.ForStatement#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Range</em>'.
	 * @see de.evoal.languages.model.execution.ForStatement#getRange()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Range();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.execution.ForStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see de.evoal.languages.model.execution.ForStatement#getBody()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Body();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.Range <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range</em>'.
	 * @see de.evoal.languages.model.execution.Range
	 * @generated
	 */
	EClass getRange();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.CounterRange <em>Counter Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Counter Range</em>'.
	 * @see de.evoal.languages.model.execution.CounterRange
	 * @generated
	 */
	EClass getCounterRange();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.execution.CounterRange#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start</em>'.
	 * @see de.evoal.languages.model.execution.CounterRange#getStart()
	 * @see #getCounterRange()
	 * @generated
	 */
	EReference getCounterRange_Start();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.execution.CounterRange#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End</em>'.
	 * @see de.evoal.languages.model.execution.CounterRange#getEnd()
	 * @see #getCounterRange()
	 * @generated
	 */
	EReference getCounterRange_End();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.execution.CounterRange#getIncrement <em>Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Increment</em>'.
	 * @see de.evoal.languages.model.execution.CounterRange#getIncrement()
	 * @see #getCounterRange()
	 * @generated
	 */
	EReference getCounterRange_Increment();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.ValueRange <em>Value Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Range</em>'.
	 * @see de.evoal.languages.model.execution.ValueRange
	 * @generated
	 */
	EClass getValueRange();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.execution.ValueRange#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see de.evoal.languages.model.execution.ValueRange#getElements()
	 * @see #getValueRange()
	 * @generated
	 */
	EReference getValueRange_Elements();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.VariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Reference</em>'.
	 * @see de.evoal.languages.model.execution.VariableReference
	 * @generated
	 */
	EClass getVariableReference();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.execution.VariableReference#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see de.evoal.languages.model.execution.VariableReference#getVariable()
	 * @see #getVariableReference()
	 * @generated
	 */
	EReference getVariableReference_Variable();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see de.evoal.languages.model.execution.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.execution.NamedVariable <em>Named Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Variable</em>'.
	 * @see de.evoal.languages.model.execution.NamedVariable
	 * @generated
	 */
	EClass getNamedVariable();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.execution.NamedVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.execution.NamedVariable#getName()
	 * @see #getNamedVariable()
	 * @generated
	 */
	EAttribute getNamedVariable_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExecutionFactory getExecutionFactory();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.ExecutionModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.ExecutionModuleImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getExecutionModule()
		 * @generated
		 */
		EClass EXECUTION_MODULE = eINSTANCE.getExecutionModule();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_MODULE__IMPORTS = eINSTANCE.getExecutionModule_Imports();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_MODULE__NAME = eINSTANCE.getExecutionModule_Name();

		/**
		 * The meta object literal for the '<em><b>Program</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_MODULE__PROGRAM = eINSTANCE.getExecutionModule_Program();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.ProgramImpl <em>Program</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.ProgramImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getProgram()
		 * @generated
		 */
		EClass PROGRAM = eINSTANCE.getProgram();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__FUNCTIONS = eINSTANCE.getProgram_Functions();

		/**
		 * The meta object literal for the '<em><b>Main</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__MAIN = eINSTANCE.getProgram_Main();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROGRAM__VARIABLES = eINSTANCE.getProgram_Variables();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.FunctionImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.ModelFunctionImpl <em>Model Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.ModelFunctionImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getModelFunction()
		 * @generated
		 */
		EClass MODEL_FUNCTION = eINSTANCE.getModelFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_FUNCTION__NAME = eINSTANCE.getModelFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_FUNCTION__VARIABLES = eINSTANCE.getModelFunction_Variables();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_FUNCTION__BODY = eINSTANCE.getModelFunction_Body();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.StatementImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.CallStatementImpl <em>Call Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.CallStatementImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getCallStatement()
		 * @generated
		 */
		EClass CALL_STATEMENT = eINSTANCE.getCallStatement();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.CallModelFunctionImpl <em>Call Model Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.CallModelFunctionImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getCallModelFunction()
		 * @generated
		 */
		EClass CALL_MODEL_FUNCTION = eINSTANCE.getCallModelFunction();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_MODEL_FUNCTION__FUNCTION = eINSTANCE.getCallModelFunction_Function();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.CallBuiltinFunctionImpl <em>Call Builtin Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.CallBuiltinFunctionImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getCallBuiltinFunction()
		 * @generated
		 */
		EClass CALL_BUILTIN_FUNCTION = eINSTANCE.getCallBuiltinFunction();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_BUILTIN_FUNCTION__DEFINITION = eINSTANCE.getCallBuiltinFunction_Definition();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_BUILTIN_FUNCTION__PARAMETERS = eINSTANCE.getCallBuiltinFunction_Parameters();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.BlockImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__STATEMENTS = eINSTANCE.getBlock_Statements();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.ForStatementImpl <em>For Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.ForStatementImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getForStatement()
		 * @generated
		 */
		EClass FOR_STATEMENT = eINSTANCE.getForStatement();

		/**
		 * The meta object literal for the '<em><b>Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__VAR = eINSTANCE.getForStatement_Var();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__RANGE = eINSTANCE.getForStatement_Range();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__BODY = eINSTANCE.getForStatement_Body();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.RangeImpl <em>Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.RangeImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getRange()
		 * @generated
		 */
		EClass RANGE = eINSTANCE.getRange();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.CounterRangeImpl <em>Counter Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.CounterRangeImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getCounterRange()
		 * @generated
		 */
		EClass COUNTER_RANGE = eINSTANCE.getCounterRange();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTER_RANGE__START = eINSTANCE.getCounterRange_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTER_RANGE__END = eINSTANCE.getCounterRange_End();

		/**
		 * The meta object literal for the '<em><b>Increment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTER_RANGE__INCREMENT = eINSTANCE.getCounterRange_Increment();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.ValueRangeImpl <em>Value Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.ValueRangeImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getValueRange()
		 * @generated
		 */
		EClass VALUE_RANGE = eINSTANCE.getValueRange();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALUE_RANGE__ELEMENTS = eINSTANCE.getValueRange_Elements();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.VariableReferenceImpl <em>Variable Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.VariableReferenceImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getVariableReference()
		 * @generated
		 */
		EClass VARIABLE_REFERENCE = eINSTANCE.getVariableReference();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_REFERENCE__VARIABLE = eINSTANCE.getVariableReference_Variable();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.VariableImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.execution.impl.NamedVariableImpl <em>Named Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.execution.impl.NamedVariableImpl
		 * @see de.evoal.languages.model.execution.impl.ExecutionPackageImpl#getNamedVariable()
		 * @generated
		 */
		EClass NAMED_VARIABLE = eINSTANCE.getNamedVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_VARIABLE__NAME = eINSTANCE.getNamedVariable_Name();

	}

} //ExecutionPackage
