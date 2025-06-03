/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol.impl;

import de.evoal.languages.model.base.BasePackage;

import de.evoal.languages.model.base.definitions.DefinitionsPackage;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;

import de.evoal.languages.model.base.types.TypesPackage;

import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.OLFactory;
import de.evoal.languages.model.ol.OLPackage;
import de.evoal.languages.model.ol.OptimisationModule;
import de.evoal.languages.model.ol.ProblemInstance;

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
	private EClass algorithmInstanceEClass = null;

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
	public EReference getOptimisationModule_Imports() {
		return (EReference)optimisationModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOptimisationModule_Problem() {
		return (EReference)optimisationModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOptimisationModule_Algorithm() {
		return (EReference)optimisationModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOptimisationModule_Name() {
		return (EAttribute)optimisationModuleEClass.getEStructuralFeatures().get(3);
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
	public EAttribute getProblemInstance_Name() {
		return (EAttribute)problemInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProblemInstance_Documentation() {
		return (EReference)problemInstanceEClass.getEStructuralFeatures().get(1);
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
		createEReference(optimisationModuleEClass, OPTIMISATION_MODULE__IMPORTS);
		createEReference(optimisationModuleEClass, OPTIMISATION_MODULE__PROBLEM);
		createEReference(optimisationModuleEClass, OPTIMISATION_MODULE__ALGORITHM);
		createEAttribute(optimisationModuleEClass, OPTIMISATION_MODULE__NAME);

		problemInstanceEClass = createEClass(PROBLEM_INSTANCE);
		createEAttribute(problemInstanceEClass, PROBLEM_INSTANCE__NAME);
		createEReference(problemInstanceEClass, PROBLEM_INSTANCE__DOCUMENTATION);

		algorithmInstanceEClass = createEClass(ALGORITHM_INSTANCE);
		createEReference(algorithmInstanceEClass, ALGORITHM_INSTANCE__PROBLEM);
		createEReference(algorithmInstanceEClass, ALGORITHM_INSTANCE__DOCUMENTATION);
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
		algorithmInstanceEClass.getESuperTypes().add(theExpressionsPackage.getInstance());

		// Initialize classes and features; add operations and parameters
		initEClass(optimisationModuleEClass, OptimisationModule.class, "OptimisationModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptimisationModule_Imports(), theBasePackage.getImport(), null, "imports", null, 0, -1, OptimisationModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOptimisationModule_Problem(), this.getProblemInstance(), null, "problem", null, 0, 1, OptimisationModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOptimisationModule_Algorithm(), this.getAlgorithmInstance(), null, "algorithm", null, 0, 1, OptimisationModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOptimisationModule_Name(), ecorePackage.getEString(), "name", null, 1, 1, OptimisationModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(problemInstanceEClass, ProblemInstance.class, "ProblemInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProblemInstance_Name(), ecorePackage.getEString(), "name", null, 1, 1, ProblemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProblemInstance_Documentation(), theExpressionsPackage.getArray(), null, "documentation", null, 0, 1, ProblemInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(algorithmInstanceEClass, AlgorithmInstance.class, "AlgorithmInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlgorithmInstance_Problem(), this.getProblemInstance(), null, "problem", null, 1, 1, AlgorithmInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlgorithmInstance_Documentation(), theExpressionsPackage.getArray(), null, "documentation", null, 0, 1, AlgorithmInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
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
			   "el", "platform:/resource/de.evoal.languages.model.base/model/model.ecore#/"
		   });
	}

} //OLPackageImpl
