/**
 * EvoAl Project
 */
package de.evoal.languages.model.dynamic.impl;

import de.evoal.languages.model.base.definitions.DefinitionsPackage;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;

import de.evoal.languages.model.base.types.TypesPackage;

import de.evoal.languages.model.dynamic.Definition;
import de.evoal.languages.model.dynamic.DynamicFactory;
import de.evoal.languages.model.dynamic.DynamicPackage;

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
public class DynamicPackageImpl extends EPackageImpl implements DynamicPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definitionEClass = null;

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
	 * @see de.evoal.languages.model.dynamic.DynamicPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DynamicPackageImpl() {
		super(eNS_URI, DynamicFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DynamicPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DynamicPackage init() {
		if (isInited) return (DynamicPackage)EPackage.Registry.INSTANCE.getEPackage(DynamicPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDynamicPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DynamicPackageImpl theDynamicPackage = registeredDynamicPackage instanceof DynamicPackageImpl ? (DynamicPackageImpl)registeredDynamicPackage : new DynamicPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		DefinitionsPackage.eINSTANCE.eClass();
		ExpressionsPackage.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDynamicPackage.createPackageContents();

		// Initialize created meta-data
		theDynamicPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDynamicPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DynamicPackage.eNS_URI, theDynamicPackage);
		return theDynamicPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDefinition() {
		return definitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDefinition_Source() {
		return (EReference)definitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DynamicFactory getDynamicFactory() {
		return (DynamicFactory)getEFactoryInstance();
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
		definitionEClass = createEClass(DEFINITION);
		createEReference(definitionEClass, DEFINITION__SOURCE);
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
		DefinitionsPackage theDefinitionsPackage = (DefinitionsPackage)EPackage.Registry.INSTANCE.getEPackage(DefinitionsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(definitionEClass, Definition.class, "Definition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefinition_Source(), theDefinitionsPackage.getDefinition(), null, "source", null, 1, 1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
			   "base", "platform:/resource/de.evoal.languages.model.base/model/model.ecore#/",
			   "defs", "platform:/resource/de.evoal.languages.model.base/model/definitions.ecore#/",
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

} //DynamicPackageImpl
