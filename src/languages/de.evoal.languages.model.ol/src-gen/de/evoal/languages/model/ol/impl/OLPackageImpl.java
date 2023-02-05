/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol.impl;

import de.evoal.languages.model.ddl.DdlPackage;

import de.evoal.languages.model.dl.DlPackage;

import de.evoal.languages.model.el.ELPackage;

import de.evoal.languages.model.instance.InstancePackage;

import de.evoal.languages.model.ol.Constraint;
import de.evoal.languages.model.ol.ConstraintStatement;
import de.evoal.languages.model.ol.DataReference;
import de.evoal.languages.model.ol.FunctionName;
import de.evoal.languages.model.ol.OLFactory;
import de.evoal.languages.model.ol.OLPackage;
import de.evoal.languages.model.ol.OptimisationModel;
import de.evoal.languages.model.ol.Use;

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
	private EClass optimisationModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataReferenceEClass = null;

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
		DdlPackage.eINSTANCE.eClass();
		DlPackage.eINSTANCE.eClass();
		ELPackage.eINSTANCE.eClass();
		InstancePackage.eINSTANCE.eClass();

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
	public EClass getOptimisationModel() {
		return optimisationModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOptimisationModel_Uses() {
		return (EReference)optimisationModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOptimisationModel_Instance() {
		return (EReference)optimisationModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOptimisationModel_Constraints() {
		return (EReference)optimisationModelEClass.getEStructuralFeatures().get(2);
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
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraint_Statements() {
		return (EReference)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstraintStatement() {
		return constraintStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstraintStatement_ConstraintExpression() {
		return (EReference)constraintStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionName() {
		return functionNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionName_Definition() {
		return (EReference)functionNameEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataReference() {
		return dataReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataReference_Definition() {
		return (EReference)dataReferenceEClass.getEStructuralFeatures().get(0);
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
		optimisationModelEClass = createEClass(OPTIMISATION_MODEL);
		createEReference(optimisationModelEClass, OPTIMISATION_MODEL__USES);
		createEReference(optimisationModelEClass, OPTIMISATION_MODEL__INSTANCE);
		createEReference(optimisationModelEClass, OPTIMISATION_MODEL__CONSTRAINTS);

		useEClass = createEClass(USE);
		createEAttribute(useEClass, USE__IMPORT_URI);

		constraintEClass = createEClass(CONSTRAINT);
		createEReference(constraintEClass, CONSTRAINT__STATEMENTS);

		constraintStatementEClass = createEClass(CONSTRAINT_STATEMENT);
		createEReference(constraintStatementEClass, CONSTRAINT_STATEMENT__CONSTRAINT_EXPRESSION);

		functionNameEClass = createEClass(FUNCTION_NAME);
		createEReference(functionNameEClass, FUNCTION_NAME__DEFINITION);

		dataReferenceEClass = createEClass(DATA_REFERENCE);
		createEReference(dataReferenceEClass, DATA_REFERENCE__DEFINITION);
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
		InstancePackage theInstancePackage = (InstancePackage)EPackage.Registry.INSTANCE.getEPackage(InstancePackage.eNS_URI);
		ELPackage theELPackage = (ELPackage)EPackage.Registry.INSTANCE.getEPackage(ELPackage.eNS_URI);
		DlPackage theDlPackage = (DlPackage)EPackage.Registry.INSTANCE.getEPackage(DlPackage.eNS_URI);
		DdlPackage theDdlPackage = (DdlPackage)EPackage.Registry.INSTANCE.getEPackage(DdlPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		functionNameEClass.getESuperTypes().add(theELPackage.getFunctionName());
		dataReferenceEClass.getESuperTypes().add(theELPackage.getValueReference());

		// Initialize classes and features; add operations and parameters
		initEClass(optimisationModelEClass, OptimisationModel.class, "OptimisationModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOptimisationModel_Uses(), this.getUse(), null, "uses", null, 0, -1, OptimisationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOptimisationModel_Instance(), theInstancePackage.getInstance(), null, "instance", null, 0, 1, OptimisationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOptimisationModel_Constraints(), this.getConstraint(), null, "constraints", null, 0, 1, OptimisationModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(useEClass, Use.class, "Use", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUse_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, Use.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraint_Statements(), this.getConstraintStatement(), null, "statements", null, 0, -1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintStatementEClass, ConstraintStatement.class, "ConstraintStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraintStatement_ConstraintExpression(), theELPackage.getCall(), null, "constraintExpression", null, 0, 1, ConstraintStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionNameEClass, FunctionName.class, "FunctionName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionName_Definition(), theDlPackage.getFunctionDefinition(), null, "definition", null, 0, 1, FunctionName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataReferenceEClass, DataReference.class, "DataReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataReference_Definition(), theDdlPackage.getDataDescription(), null, "definition", null, 0, 1, DataReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
			   "dl", "platform:/resource/de.evoal.languages.model.dl/model/model.ecore#/",
			   "el", "platform:/resource/de.evoal.languages.model.el/model/model.ecore#/",
			   "instance", "platform:/resource/de.evoal.languages.model.instance/model/model.ecore#/"
		   });
	}

} //OLPackageImpl
