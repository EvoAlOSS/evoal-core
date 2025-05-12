/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.base.BasePackage;

import de.evoal.languages.model.base.definitions.DefinitionsPackage;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;

import de.evoal.languages.model.base.types.TypesPackage;

import de.evoal.languages.model.execution.ExecutionPackage;
import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.mll.MllFactory;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.PartialSurrogateFunctionDefinition;
import de.evoal.languages.model.mll.PredictStatement;
import de.evoal.languages.model.mll.SurrogateDefinition;
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
	private EClass machineLearningModuleEClass = null;

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
	private EClass partialSurrogateFunctionDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predictStatementEClass = null;

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
		DefinitionsPackage.eINSTANCE.eClass();
		ExpressionsPackage.eINSTANCE.eClass();
		BasePackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();
		ExecutionPackage.eINSTANCE.eClass();

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
	public EClass getMachineLearningModule() {
		return machineLearningModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningModule_Imports() {
		return (EReference)machineLearningModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningModule_Definitions() {
		return (EReference)machineLearningModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningModule_Body() {
		return (EReference)machineLearningModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMachineLearningModule_Name() {
		return (EAttribute)machineLearningModuleEClass.getEStructuralFeatures().get(3);
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
	public EReference getSurrogateDefinition_Functions() {
		return (EReference)surrogateDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPartialSurrogateFunctionDefinition() {
		return partialSurrogateFunctionDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPartialSurrogateFunctionDefinition_Inputs() {
		return (EReference)partialSurrogateFunctionDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPartialSurrogateFunctionDefinition_Outputs() {
		return (EReference)partialSurrogateFunctionDefinitionEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getPredictStatement_ModelFilename() {
		return (EAttribute)predictStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPredictStatement_TrainingData() {
		return (EAttribute)predictStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPredictStatement_Measurements() {
		return (EReference)predictStatementEClass.getEStructuralFeatures().get(3);
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
		machineLearningModuleEClass = createEClass(MACHINE_LEARNING_MODULE);
		createEReference(machineLearningModuleEClass, MACHINE_LEARNING_MODULE__IMPORTS);
		createEReference(machineLearningModuleEClass, MACHINE_LEARNING_MODULE__DEFINITIONS);
		createEReference(machineLearningModuleEClass, MACHINE_LEARNING_MODULE__BODY);
		createEAttribute(machineLearningModuleEClass, MACHINE_LEARNING_MODULE__NAME);

		surrogateDefinitionEClass = createEClass(SURROGATE_DEFINITION);
		createEReference(surrogateDefinitionEClass, SURROGATE_DEFINITION__FUNCTIONS);

		partialSurrogateFunctionDefinitionEClass = createEClass(PARTIAL_SURROGATE_FUNCTION_DEFINITION);
		createEReference(partialSurrogateFunctionDefinitionEClass, PARTIAL_SURROGATE_FUNCTION_DEFINITION__INPUTS);
		createEReference(partialSurrogateFunctionDefinitionEClass, PARTIAL_SURROGATE_FUNCTION_DEFINITION__OUTPUTS);

		predictStatementEClass = createEClass(PREDICT_STATEMENT);
		createEReference(predictStatementEClass, PREDICT_STATEMENT__SURROGATE);
		createEAttribute(predictStatementEClass, PREDICT_STATEMENT__MODEL_FILENAME);
		createEAttribute(predictStatementEClass, PREDICT_STATEMENT__TRAINING_DATA);
		createEReference(predictStatementEClass, PREDICT_STATEMENT__MEASUREMENTS);
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
		BasePackage theBasePackage = (BasePackage)EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI);
		ExecutionPackage theExecutionPackage = (ExecutionPackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionPackage.eNS_URI);
		DefinitionsPackage theDefinitionsPackage = (DefinitionsPackage)EPackage.Registry.INSTANCE.getEPackage(DefinitionsPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		surrogateDefinitionEClass.getESuperTypes().add(theExecutionPackage.getNamedVariable());
		partialSurrogateFunctionDefinitionEClass.getESuperTypes().add(theExpressionsPackage.getInstance());
		predictStatementEClass.getESuperTypes().add(theExecutionPackage.getStatement());

		// Initialize classes and features; add operations and parameters
		initEClass(machineLearningModuleEClass, MachineLearningModule.class, "MachineLearningModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMachineLearningModule_Imports(), theBasePackage.getImport(), null, "imports", null, 0, -1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMachineLearningModule_Definitions(), this.getSurrogateDefinition(), null, "definitions", null, 0, -1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMachineLearningModule_Body(), theExecutionPackage.getBlock(), null, "body", null, 1, 1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMachineLearningModule_Name(), ecorePackage.getEString(), "name", null, 1, 1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(surrogateDefinitionEClass, SurrogateDefinition.class, "SurrogateDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSurrogateDefinition_Functions(), this.getPartialSurrogateFunctionDefinition(), null, "functions", null, 1, -1, SurrogateDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(surrogateDefinitionEClass, theDefinitionsPackage.getDataDescription(), "getInputs", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(surrogateDefinitionEClass, theDefinitionsPackage.getDataDescription(), "getOutputs", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(partialSurrogateFunctionDefinitionEClass, PartialSurrogateFunctionDefinition.class, "PartialSurrogateFunctionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPartialSurrogateFunctionDefinition_Inputs(), theDefinitionsPackage.getDataDescription(), null, "inputs", null, 1, -1, PartialSurrogateFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPartialSurrogateFunctionDefinition_Outputs(), theDefinitionsPackage.getDataDescription(), null, "outputs", null, 1, -1, PartialSurrogateFunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(predictStatementEClass, PredictStatement.class, "PredictStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPredictStatement_Surrogate(), this.getSurrogateDefinition(), null, "surrogate", null, 1, 1, PredictStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPredictStatement_ModelFilename(), ecorePackage.getEString(), "modelFilename", null, 1, 1, PredictStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPredictStatement_TrainingData(), ecorePackage.getEString(), "trainingData", null, 1, 1, PredictStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPredictStatement_Measurements(), theExecutionPackage.getBlock(), null, "measurements", null, 1, 1, PredictStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
			   "base", "platform:/resource/de.evoal.languages.model.base/model/model.ecore#/",
			   "defs", "platform:/resource/de.evoal.languages.model.base/model/definitions.ecore#/",
			   "exec", "execution.ecore#/",
			   "expr", "platform:/resource/de.evoal.languages.model.base/model/expressions.ecore#/"
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
		  (getMachineLearningModule_Imports(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getMachineLearningModule_Definitions(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getSurrogateDefinition_Functions(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getPartialSurrogateFunctionDefinition_Inputs(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getPartialSurrogateFunctionDefinition_Outputs(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
	}

} //MllPackageImpl
