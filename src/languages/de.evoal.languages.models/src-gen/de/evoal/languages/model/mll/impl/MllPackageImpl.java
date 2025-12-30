/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.base.BasePackage;

import de.evoal.languages.model.base.definitions.DefinitionsPackage;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;

import de.evoal.languages.model.base.types.TypesPackage;

import de.evoal.languages.model.execution.ExecutionPackage;

import de.evoal.languages.model.generator.GeneratorPackage;

import de.evoal.languages.model.mll.MachineLearningModule;
import de.evoal.languages.model.mll.MllFactory;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.TaskDescription;

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
	private EClass taskDescriptionEClass = null;

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
		GeneratorPackage.eINSTANCE.eClass();

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
	public EAttribute getMachineLearningModule_Name() {
		return (EAttribute)machineLearningModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningModule_Task() {
		return (EReference)machineLearningModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningModule_Validation() {
		return (EReference)machineLearningModuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningModule_Preparation() {
		return (EReference)machineLearningModuleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningModule_Model() {
		return (EReference)machineLearningModuleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningModule_Gof() {
		return (EReference)machineLearningModuleEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningModule_LearningUseCase() {
		return (EReference)machineLearningModuleEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMachineLearningModule_PredictionUseCase() {
		return (EReference)machineLearningModuleEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTaskDescription() {
		return taskDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTaskDescription_Inputs() {
		return (EReference)taskDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTaskDescription_Outputs() {
		return (EReference)taskDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTaskDescription_LearningData() {
		return (EAttribute)taskDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTaskDescription_TestingData() {
		return (EAttribute)taskDescriptionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTaskDescription_ModelFile() {
		return (EAttribute)taskDescriptionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTaskDescription_GofFile() {
		return (EAttribute)taskDescriptionEClass.getEStructuralFeatures().get(5);
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
		createEAttribute(machineLearningModuleEClass, MACHINE_LEARNING_MODULE__NAME);
		createEReference(machineLearningModuleEClass, MACHINE_LEARNING_MODULE__TASK);
		createEReference(machineLearningModuleEClass, MACHINE_LEARNING_MODULE__VALIDATION);
		createEReference(machineLearningModuleEClass, MACHINE_LEARNING_MODULE__PREPARATION);
		createEReference(machineLearningModuleEClass, MACHINE_LEARNING_MODULE__MODEL);
		createEReference(machineLearningModuleEClass, MACHINE_LEARNING_MODULE__GOF);
		createEReference(machineLearningModuleEClass, MACHINE_LEARNING_MODULE__LEARNING_USE_CASE);
		createEReference(machineLearningModuleEClass, MACHINE_LEARNING_MODULE__PREDICTION_USE_CASE);

		taskDescriptionEClass = createEClass(TASK_DESCRIPTION);
		createEReference(taskDescriptionEClass, TASK_DESCRIPTION__INPUTS);
		createEReference(taskDescriptionEClass, TASK_DESCRIPTION__OUTPUTS);
		createEAttribute(taskDescriptionEClass, TASK_DESCRIPTION__LEARNING_DATA);
		createEAttribute(taskDescriptionEClass, TASK_DESCRIPTION__TESTING_DATA);
		createEAttribute(taskDescriptionEClass, TASK_DESCRIPTION__MODEL_FILE);
		createEAttribute(taskDescriptionEClass, TASK_DESCRIPTION__GOF_FILE);
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
		GeneratorPackage theGeneratorPackage = (GeneratorPackage)EPackage.Registry.INSTANCE.getEPackage(GeneratorPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		ExecutionPackage theExecutionPackage = (ExecutionPackage)EPackage.Registry.INSTANCE.getEPackage(ExecutionPackage.eNS_URI);
		DefinitionsPackage theDefinitionsPackage = (DefinitionsPackage)EPackage.Registry.INSTANCE.getEPackage(DefinitionsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		taskDescriptionEClass.getESuperTypes().add(theExecutionPackage.getNamedVariable());

		// Initialize classes and features; add operations and parameters
		initEClass(machineLearningModuleEClass, MachineLearningModule.class, "MachineLearningModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMachineLearningModule_Imports(), theBasePackage.getImport(), null, "imports", null, 0, -1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMachineLearningModule_Name(), ecorePackage.getEString(), "name", null, 1, 1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMachineLearningModule_Task(), this.getTaskDescription(), null, "task", null, 1, 1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMachineLearningModule_Validation(), theGeneratorPackage.getPipelineDefinition(), null, "validation", null, 1, 1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMachineLearningModule_Preparation(), theGeneratorPackage.getPipelineDefinition(), null, "preparation", null, 1, 1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMachineLearningModule_Model(), theExpressionsPackage.getInstance(), null, "model", null, 1, 1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMachineLearningModule_Gof(), theExecutionPackage.getBlock(), null, "gof", null, 0, 1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMachineLearningModule_LearningUseCase(), theExecutionPackage.getBlock(), null, "learningUseCase", null, 0, 1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMachineLearningModule_PredictionUseCase(), theGeneratorPackage.getPipelineDefinition(), null, "predictionUseCase", null, 1, 1, MachineLearningModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taskDescriptionEClass, TaskDescription.class, "TaskDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTaskDescription_Inputs(), theDefinitionsPackage.getDataDescription(), null, "inputs", null, 1, -1, TaskDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTaskDescription_Outputs(), theDefinitionsPackage.getDataDescription(), null, "outputs", null, 1, -1, TaskDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTaskDescription_LearningData(), ecorePackage.getEString(), "learningData", null, 1, -1, TaskDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTaskDescription_TestingData(), ecorePackage.getEString(), "testingData", null, 0, -1, TaskDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTaskDescription_ModelFile(), ecorePackage.getEString(), "modelFile", null, 1, 1, TaskDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTaskDescription_GofFile(), ecorePackage.getEString(), "gofFile", null, 0, 1, TaskDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
			   "expr", "platform:/resource/de.evoal.languages.model.base/model/expressions.ecore#/",
			   "generator", "generator.ecore#/"
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
		  (getTaskDescription_Inputs(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getTaskDescription_Outputs(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getTaskDescription_LearningData(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getTaskDescription_TestingData(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
	}

} //MllPackageImpl
