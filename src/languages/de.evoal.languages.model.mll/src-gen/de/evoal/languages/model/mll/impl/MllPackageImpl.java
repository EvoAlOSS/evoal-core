/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.el.ELPackage;

import de.evoal.languages.model.ddl.DdlPackage;

import de.evoal.languages.model.dl.DlPackage;

import de.evoal.languages.model.instance.InstancePackage;

import de.evoal.languages.model.mll.BlockStatement;
import de.evoal.languages.model.mll.CallStatement;
import de.evoal.languages.model.mll.CounterRange;
import de.evoal.languages.model.mll.DefinedFunctionName;
import de.evoal.languages.model.mll.ForStatement;
import de.evoal.languages.model.mll.MachineLearningConfiguration;
import de.evoal.languages.model.mll.MllFactory;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.PartialSurrogateFunction;
import de.evoal.languages.model.mll.PredictStatement;
import de.evoal.languages.model.mll.Prediction;
import de.evoal.languages.model.mll.Range;
import de.evoal.languages.model.mll.Statement;
import de.evoal.languages.model.mll.StringLiteralRange;
import de.evoal.languages.model.mll.SurrogateDefinition;
import de.evoal.languages.model.mll.SurrogateLayer;
import de.evoal.languages.model.mll.Use;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MllPackageImpl extends EPackageImpl implements MllPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass machineLearningConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass surrogateDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass surrogateLayerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass partialSurrogateFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predictionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predictStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass counterRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralRangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definedFunctionNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.evoal.languages.model.mll.MllPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MllPackageImpl() {
		super(eNS_URI, MllFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link MllPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MllPackage init() {
		if (isInited) return (MllPackage)EPackage.Registry.INSTANCE.getEPackage(MllPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMllPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MllPackageImpl theMllPackage = registeredMllPackage instanceof MllPackageImpl ? (MllPackageImpl)registeredMllPackage : new MllPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		DdlPackage.eINSTANCE.eClass();
		DlPackage.eINSTANCE.eClass();
		ELPackage.eINSTANCE.eClass();
		InstancePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theMllPackage.createPackageContents();

		// Initialize created meta-data
		theMllPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMllPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MllPackage.eNS_URI, theMllPackage);
		return theMllPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMachineLearningConfiguration() {
		return machineLearningConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningConfiguration_Uses() {
		return (EReference)machineLearningConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningConfiguration_Definitions() {
		return (EReference)machineLearningConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningConfiguration_Statements() {
		return (EReference)machineLearningConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSurrogateDefinition() {
		return surrogateDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSurrogateDefinition_Name() {
		return (EAttribute)surrogateDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSurrogateDefinition_Inputs() {
		return (EReference)surrogateDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSurrogateDefinition_Outputs() {
		return (EReference)surrogateDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSurrogateDefinition_Layers() {
		return (EReference)surrogateDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSurrogateLayer() {
		return surrogateLayerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSurrogateLayer_Name() {
		return (EAttribute)surrogateLayerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSurrogateLayer_Functions() {
		return (EReference)surrogateLayerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPartialSurrogateFunction() {
		return partialSurrogateFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPartialSurrogateFunction_Name() {
		return (EReference)partialSurrogateFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPartialSurrogateFunction_Inputs() {
		return (EReference)partialSurrogateFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPartialSurrogateFunction_Outputs() {
		return (EReference)partialSurrogateFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPartialSurrogateFunction_Parameters() {
		return (EReference)partialSurrogateFunctionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPrediction() {
		return predictionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrediction_Definition() {
		return (EReference)predictionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrediction_Inputs() {
		return (EReference)predictionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrediction_Outputs() {
		return (EReference)predictionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPrediction_Quality() {
		return (EReference)predictionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCallStatement() {
		return callStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCallStatement_Call() {
		return (EReference)callStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBlockStatement() {
		return blockStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBlockStatement_Statements() {
		return (EReference)blockStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPredictStatement() {
		return predictStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredictStatement_Surrogate() {
		return (EReference)predictStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPredictStatement_Filename() {
		return (EAttribute)predictStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredictStatement_Statements() {
		return (EReference)predictStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getForStatement() {
		return forStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getForStatement_Name() {
		return (EAttribute)forStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForStatement_Range() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getForStatement_Statements() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRange() {
		return rangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCounterRange() {
		return counterRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCounterRange_Start() {
		return (EAttribute)counterRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCounterRange_End() {
		return (EAttribute)counterRangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStringLiteralRange() {
		return stringLiteralRangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStringLiteralRange_Elements() {
		return (EReference)stringLiteralRangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDefinedFunctionName() {
		return definedFunctionNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDefinedFunctionName_Definition() {
		return (EReference)definedFunctionNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUse() {
		return useEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUse_ImportURI() {
		return (EAttribute)useEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MllFactory getMllFactory() {
		return (MllFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		machineLearningConfigurationEClass = createEClass(MACHINE_LEARNING_CONFIGURATION);
		createEReference(machineLearningConfigurationEClass, MACHINE_LEARNING_CONFIGURATION__USES);
		createEReference(machineLearningConfigurationEClass, MACHINE_LEARNING_CONFIGURATION__DEFINITIONS);
		createEReference(machineLearningConfigurationEClass, MACHINE_LEARNING_CONFIGURATION__STATEMENTS);

		surrogateDefinitionEClass = createEClass(SURROGATE_DEFINITION);
		createEAttribute(surrogateDefinitionEClass, SURROGATE_DEFINITION__NAME);
		createEReference(surrogateDefinitionEClass, SURROGATE_DEFINITION__INPUTS);
		createEReference(surrogateDefinitionEClass, SURROGATE_DEFINITION__OUTPUTS);
		createEReference(surrogateDefinitionEClass, SURROGATE_DEFINITION__LAYERS);

		surrogateLayerEClass = createEClass(SURROGATE_LAYER);
		createEAttribute(surrogateLayerEClass, SURROGATE_LAYER__NAME);
		createEReference(surrogateLayerEClass, SURROGATE_LAYER__FUNCTIONS);

		partialSurrogateFunctionEClass = createEClass(PARTIAL_SURROGATE_FUNCTION);
		createEReference(partialSurrogateFunctionEClass, PARTIAL_SURROGATE_FUNCTION__NAME);
		createEReference(partialSurrogateFunctionEClass, PARTIAL_SURROGATE_FUNCTION__INPUTS);
		createEReference(partialSurrogateFunctionEClass, PARTIAL_SURROGATE_FUNCTION__OUTPUTS);
		createEReference(partialSurrogateFunctionEClass, PARTIAL_SURROGATE_FUNCTION__PARAMETERS);

		predictionEClass = createEClass(PREDICTION);
		createEReference(predictionEClass, PREDICTION__DEFINITION);
		createEReference(predictionEClass, PREDICTION__INPUTS);
		createEReference(predictionEClass, PREDICTION__OUTPUTS);
		createEReference(predictionEClass, PREDICTION__QUALITY);

		statementEClass = createEClass(STATEMENT);

		callStatementEClass = createEClass(CALL_STATEMENT);
		createEReference(callStatementEClass, CALL_STATEMENT__CALL);

		blockStatementEClass = createEClass(BLOCK_STATEMENT);
		createEReference(blockStatementEClass, BLOCK_STATEMENT__STATEMENTS);

		predictStatementEClass = createEClass(PREDICT_STATEMENT);
		createEReference(predictStatementEClass, PREDICT_STATEMENT__SURROGATE);
		createEAttribute(predictStatementEClass, PREDICT_STATEMENT__FILENAME);
		createEReference(predictStatementEClass, PREDICT_STATEMENT__STATEMENTS);

		forStatementEClass = createEClass(FOR_STATEMENT);
		createEAttribute(forStatementEClass, FOR_STATEMENT__NAME);
		createEReference(forStatementEClass, FOR_STATEMENT__RANGE);
		createEReference(forStatementEClass, FOR_STATEMENT__STATEMENTS);

		rangeEClass = createEClass(RANGE);

		counterRangeEClass = createEClass(COUNTER_RANGE);
		createEAttribute(counterRangeEClass, COUNTER_RANGE__START);
		createEAttribute(counterRangeEClass, COUNTER_RANGE__END);

		stringLiteralRangeEClass = createEClass(STRING_LITERAL_RANGE);
		createEReference(stringLiteralRangeEClass, STRING_LITERAL_RANGE__ELEMENTS);

		definedFunctionNameEClass = createEClass(DEFINED_FUNCTION_NAME);
		createEReference(definedFunctionNameEClass, DEFINED_FUNCTION_NAME__DEFINITION);

		useEClass = createEClass(USE);
		createEAttribute(useEClass, USE__IMPORT_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		DdlPackage theDdlPackage = (DdlPackage)EPackage.Registry.INSTANCE.getEPackage(DdlPackage.eNS_URI);
		DlPackage theDlPackage = (DlPackage)EPackage.Registry.INSTANCE.getEPackage(DlPackage.eNS_URI);
		InstancePackage theInstancePackage = (InstancePackage)EPackage.Registry.INSTANCE.getEPackage(InstancePackage.eNS_URI);
		ELPackage theELPackage = (ELPackage)EPackage.Registry.INSTANCE.getEPackage(ELPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		callStatementEClass.getESuperTypes().add(this.getStatement());
		blockStatementEClass.getESuperTypes().add(this.getStatement());
		predictStatementEClass.getESuperTypes().add(this.getStatement());
		forStatementEClass.getESuperTypes().add(this.getStatement());
		counterRangeEClass.getESuperTypes().add(this.getRange());
		stringLiteralRangeEClass.getESuperTypes().add(this.getRange());
		definedFunctionNameEClass.getESuperTypes().add(theELPackage.getFunctionName());

		// Initialize classes and features; add operations and parameters
		initEClass(machineLearningConfigurationEClass, MachineLearningConfiguration.class, "MachineLearningConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMachineLearningConfiguration_Uses(), this.getUse(), null, "uses", null, 0, -1, MachineLearningConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMachineLearningConfiguration_Definitions(), this.getSurrogateDefinition(), null, "definitions", null, 0, -1, MachineLearningConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMachineLearningConfiguration_Statements(), this.getStatement(), null, "statements", null, 0, -1, MachineLearningConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(surrogateDefinitionEClass, SurrogateDefinition.class, "SurrogateDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSurrogateDefinition_Name(), ecorePackage.getEString(), "name", null, 1, 1, SurrogateDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSurrogateDefinition_Inputs(), theDdlPackage.getDataDescription(), null, "inputs", null, 1, -1, SurrogateDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSurrogateDefinition_Outputs(), theDdlPackage.getDataDescription(), null, "outputs", null, 1, -1, SurrogateDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSurrogateDefinition_Layers(), this.getSurrogateLayer(), null, "layers", null, 1, -1, SurrogateDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(surrogateLayerEClass, SurrogateLayer.class, "SurrogateLayer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSurrogateLayer_Name(), ecorePackage.getEString(), "name", null, 1, 1, SurrogateLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSurrogateLayer_Functions(), this.getPartialSurrogateFunction(), null, "functions", null, 1, -1, SurrogateLayer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(partialSurrogateFunctionEClass, PartialSurrogateFunction.class, "PartialSurrogateFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartialSurrogateFunction_Name(), theDlPackage.getTypeDefinition(), null, "name", null, 1, 1, PartialSurrogateFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPartialSurrogateFunction_Inputs(), theDdlPackage.getDataDescription(), null, "inputs", null, 1, -1, PartialSurrogateFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPartialSurrogateFunction_Outputs(), theDdlPackage.getDataDescription(), null, "outputs", null, 1, -1, PartialSurrogateFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPartialSurrogateFunction_Parameters(), theInstancePackage.getAttribute(), null, "parameters", null, 0, -1, PartialSurrogateFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(predictionEClass, Prediction.class, "Prediction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrediction_Definition(), this.getSurrogateDefinition(), null, "definition", null, 1, 1, Prediction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrediction_Inputs(), theDdlPackage.getDataDescription(), null, "inputs", null, 1, -1, Prediction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPrediction_Outputs(), theDdlPackage.getDataDescription(), null, "outputs", null, 1, -1, Prediction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPrediction_Quality(), this.getBlockStatement(), null, "quality", null, 0, 1, Prediction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(callStatementEClass, CallStatement.class, "CallStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallStatement_Call(), theELPackage.getCall(), null, "call", null, 1, 1, CallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockStatementEClass, BlockStatement.class, "BlockStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockStatement_Statements(), this.getStatement(), null, "statements", null, 0, -1, BlockStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(predictStatementEClass, PredictStatement.class, "PredictStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPredictStatement_Surrogate(), this.getSurrogateDefinition(), null, "surrogate", null, 1, 1, PredictStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPredictStatement_Filename(), ecorePackage.getEString(), "filename", null, 1, 1, PredictStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPredictStatement_Statements(), this.getCallStatement(), null, "statements", null, 0, -1, PredictStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(forStatementEClass, ForStatement.class, "ForStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getForStatement_Name(), ecorePackage.getEString(), "name", null, 1, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Range(), this.getRange(), null, "range", null, 1, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Statements(), this.getStatement(), null, "statements", null, 0, -1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rangeEClass, Range.class, "Range", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(counterRangeEClass, CounterRange.class, "CounterRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCounterRange_Start(), ecorePackage.getEInt(), "start", null, 1, 1, CounterRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCounterRange_End(), ecorePackage.getEInt(), "end", null, 1, 1, CounterRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringLiteralRangeEClass, StringLiteralRange.class, "StringLiteralRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStringLiteralRange_Elements(), theELPackage.getStringLiteral(), null, "elements", null, 0, -1, StringLiteralRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(definedFunctionNameEClass, DefinedFunctionName.class, "DefinedFunctionName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefinedFunctionName_Definition(), theDlPackage.getFunctionDefinition(), null, "definition", null, 1, 1, DefinedFunctionName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(useEClass, Use.class, "Use", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUse_ImportURI(), ecorePackage.getEString(), "importURI", null, 1, 1, Use.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://www.eclipse.org/OCL/Collection
		createCollectionAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "ddl", "platform:/resource/de.evoal.languages.model.ddl/model/model.ecore#/",
			   "dl", "platform:/resource/de.evoal.languages.model.dl/model/model.ecore#/",
			   "el", "platform:/resource/de.evoal.languages.model.el/model/model.ecore#/",
			   "instance", "platform:/resource/de.evoal.languages.model.instance/model/model.ecore#/"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Collection</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createCollectionAnnotations() {
		String source = "http://www.eclipse.org/OCL/Collection";
		addAnnotation
		  (getMachineLearningConfiguration_Uses(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getMachineLearningConfiguration_Definitions(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getMachineLearningConfiguration_Statements(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getSurrogateDefinition_Inputs(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getSurrogateDefinition_Outputs(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getSurrogateDefinition_Layers(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getSurrogateLayer_Functions(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getPartialSurrogateFunction_Inputs(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getPartialSurrogateFunction_Outputs(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getPartialSurrogateFunction_Parameters(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getPrediction_Inputs(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getPrediction_Outputs(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getBlockStatement_Statements(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getPredictStatement_Statements(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getForStatement_Statements(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getStringLiteralRange_Elements(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
	}

} //MllPackageImpl
