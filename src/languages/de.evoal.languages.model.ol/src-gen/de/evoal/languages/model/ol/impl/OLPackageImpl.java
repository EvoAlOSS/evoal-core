/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol.impl;

import de.evoal.languages.model.base.BasePackage;

import de.evoal.languages.model.base.definitions.DefinitionsPackage;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;

import de.evoal.languages.model.base.types.TypesPackage;

import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.Direction;
import de.evoal.languages.model.ol.MaximiseGoal;
import de.evoal.languages.model.ol.MinimiseGoal;
import de.evoal.languages.model.ol.OLFactory;
import de.evoal.languages.model.ol.OLPackage;
import de.evoal.languages.model.ol.OptimisationGoal;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.languages.model.ol.ProblemInstance;
import de.evoal.languages.model.ol.TargetGoal;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OLPackageImpl extends EPackageImpl implements OLPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optimisationModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass problemInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass optimisationGoalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass maximiseGoalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass minimiseGoalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetGoalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass algorithmInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionEEnum = null;

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
	 * @see de.evoal.languages.model.ol.OLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OLPackageImpl() {
		super(eNS_URI, OLFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OLPackage init() {
		if (isInited) return (OLPackage)EPackage.Registry.INSTANCE.getEPackage(OLPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredOLPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		OLPackageImpl theOLPackage = registeredOLPackage instanceof OLPackageImpl ? (OLPackageImpl)registeredOLPackage : new OLPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BasePackage.eINSTANCE.eClass();
		ExpressionsPackage.eINSTANCE.eClass();
		DefinitionsPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOLPackage.createPackageContents();

		// Initialize created meta-data
		theOLPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOLPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OLPackage.eNS_URI, theOLPackage);
		return theOLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOptimisationModule() {
		return optimisationModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOptimisationModule_Algorithm() {
		return (EReference)optimisationModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOptimisationModule_Imports() {
		return (EReference)optimisationModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOptimisationModule_Name() {
		return (EAttribute)optimisationModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOptimisationModule_Problem() {
		return (EReference)optimisationModuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProblemInstance() {
		return problemInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblemInstance_Documentation() {
		return (EReference)problemInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProblemInstance_Name() {
		return (EAttribute)problemInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblemInstance_OptimisationFunction() {
		return (EReference)problemInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblemInstance_OptimisationSpace() {
		return (EReference)problemInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblemInstance_SearchSpace() {
		return (EReference)problemInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOptimisationGoal() {
		return optimisationGoalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOptimisationGoal_Data() {
		return (EReference)optimisationGoalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMaximiseGoal() {
		return maximiseGoalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMinimiseGoal() {
		return minimiseGoalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTargetGoal() {
		return targetGoalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTargetGoal_Value() {
		return (EReference)targetGoalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAlgorithmInstance() {
		return algorithmInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAlgorithmInstance_Problem() {
		return (EReference)algorithmInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAlgorithmInstance_Documentation() {
		return (EReference)algorithmInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDirection() {
		return directionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OLFactory getOLFactory() {
		return (OLFactory)getEFactoryInstance();
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
		optimisationModuleEClass = createEClass(OPTIMISATION_MODULE);
		createEReference(optimisationModuleEClass, OPTIMISATION_MODULE__ALGORITHM);
		createEReference(optimisationModuleEClass, OPTIMISATION_MODULE__IMPORTS);
		createEAttribute(optimisationModuleEClass, OPTIMISATION_MODULE__NAME);
		createEReference(optimisationModuleEClass, OPTIMISATION_MODULE__PROBLEM);

		problemInstanceEClass = createEClass(PROBLEM_INSTANCE);
		createEReference(problemInstanceEClass, PROBLEM_INSTANCE__DOCUMENTATION);
		createEAttribute(problemInstanceEClass, PROBLEM_INSTANCE__NAME);
		createEReference(problemInstanceEClass, PROBLEM_INSTANCE__OPTIMISATION_FUNCTION);
		createEReference(problemInstanceEClass, PROBLEM_INSTANCE__OPTIMISATION_SPACE);
		createEReference(problemInstanceEClass, PROBLEM_INSTANCE__SEARCH_SPACE);

		optimisationGoalEClass = createEClass(OPTIMISATION_GOAL);
		createEReference(optimisationGoalEClass, OPTIMISATION_GOAL__DATA);

		maximiseGoalEClass = createEClass(MAXIMISE_GOAL);

		minimiseGoalEClass = createEClass(MINIMISE_GOAL);

		targetGoalEClass = createEClass(TARGET_GOAL);
		createEReference(targetGoalEClass, TARGET_GOAL__VALUE);

		algorithmInstanceEClass = createEClass(ALGORITHM_INSTANCE);
		createEReference(algorithmInstanceEClass, ALGORITHM_INSTANCE__PROBLEM);
		createEReference(algorithmInstanceEClass, ALGORITHM_INSTANCE__DOCUMENTATION);

		// Create enums
		directionEEnum = createEEnum(DIRECTION);
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
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		problemInstanceEClass.getESuperTypes().add(theExpressionsPackage.getInstance());
		maximiseGoalEClass.getESuperTypes().add(this.getOptimisationGoal());
		minimiseGoalEClass.getESuperTypes().add(this.getOptimisationGoal());
		targetGoalEClass.getESuperTypes().add(this.getOptimisationGoal());
		algorithmInstanceEClass.getESuperTypes().add(theExpressionsPackage.getInstance());

		// Initialize classes and features; add operations and parameters
		initEClass(optimisationModuleEClass, OptimisationModule.class, "OptimisationModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptimisationModule_Algorithm(), this.getAlgorithmInstance(), null, "algorithm", null, 0, 1, OptimisationModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOptimisationModule_Imports(), theBasePackage.getImport(), null, "imports", null, 0, -1, OptimisationModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOptimisationModule_Name(), ecorePackage.getEString(), "name", null, 1, 1, OptimisationModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOptimisationModule_Problem(), this.getProblemInstance(), null, "problem", null, 0, 1, OptimisationModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(problemInstanceEClass, ProblemInstance.class, "ProblemInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProblemInstance_Documentation(), theExpressionsPackage.getArray(), null, "documentation", null, 0, 1, ProblemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProblemInstance_Name(), ecorePackage.getEString(), "name", null, 1, 1, ProblemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProblemInstance_OptimisationFunction(), theExpressionsPackage.getInstance(), null, "optimisationFunction", null, 1, 1, ProblemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProblemInstance_OptimisationSpace(), this.getOptimisationGoal(), null, "optimisationSpace", null, 1, -1, ProblemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProblemInstance_SearchSpace(), theExpressionsPackage.getTypeDefinitionReference(), null, "searchSpace", null, 1, -1, ProblemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(optimisationGoalEClass, OptimisationGoal.class, "OptimisationGoal", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptimisationGoal_Data(), theExpressionsPackage.getTypeDefinitionReference(), null, "data", null, 1, 1, OptimisationGoal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(optimisationGoalEClass, this.getDirection(), "getDirection", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(maximiseGoalEClass, MaximiseGoal.class, "MaximiseGoal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(maximiseGoalEClass, this.getDirection(), "getDirection", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(minimiseGoalEClass, MinimiseGoal.class, "MinimiseGoal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(minimiseGoalEClass, this.getDirection(), "getDirection", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(targetGoalEClass, TargetGoal.class, "TargetGoal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetGoal_Value(), theExpressionsPackage.getLiteral(), null, "value", null, 1, 1, TargetGoal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(targetGoalEClass, this.getDirection(), "getDirection", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(algorithmInstanceEClass, AlgorithmInstance.class, "AlgorithmInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlgorithmInstance_Problem(), this.getProblemInstance(), null, "problem", null, 1, 1, AlgorithmInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlgorithmInstance_Documentation(), theExpressionsPackage.getArray(), null, "documentation", null, 0, 1, AlgorithmInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(directionEEnum, Direction.class, "Direction");
		addEEnumLiteral(directionEEnum, Direction.MAXIMISE);
		addEEnumLiteral(directionEEnum, Direction.MINIMISE);
		addEEnumLiteral(directionEEnum, Direction.TARGET);

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
			   "el", "platform:/resource/de.evoal.languages.model.base/model/model.ecore#/",
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
		  (getProblemInstance_OptimisationSpace(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getProblemInstance_SearchSpace(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
	}

} //OLPackageImpl
