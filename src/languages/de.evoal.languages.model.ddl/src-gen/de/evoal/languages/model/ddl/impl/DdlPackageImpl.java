/**
 */
package de.evoal.languages.model.ddl.impl;

import de.evoal.languages.model.base.BasePackage;

import de.evoal.languages.model.ddl.DataDescription;
import de.evoal.languages.model.ddl.DataDescriptionModel;
import de.evoal.languages.model.ddl.DataReference;
import de.evoal.languages.model.ddl.DataTypeDefinition;
import de.evoal.languages.model.ddl.DdlFactory;
import de.evoal.languages.model.ddl.DdlPackage;
import de.evoal.languages.model.ddl.RepresentationType;
import de.evoal.languages.model.ddl.ScaleType;
import de.evoal.languages.model.ddl.SelfReference;
import de.evoal.languages.model.ddl.TypedDataDescription;
import de.evoal.languages.model.ddl.UntypedDataDescription;

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
public class DdlPackageImpl extends EPackageImpl implements DdlPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataDescriptionModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedDataDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass untypedDataDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selfReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scaleTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum representationTypeEEnum = null;

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
	 * @see de.evoal.languages.model.ddl.DdlPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DdlPackageImpl() {
		super(eNS_URI, DdlFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DdlPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DdlPackage init() {
		if (isInited) return (DdlPackage)EPackage.Registry.INSTANCE.getEPackage(DdlPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDdlPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DdlPackageImpl theDdlPackage = registeredDdlPackage instanceof DdlPackageImpl ? (DdlPackageImpl)registeredDdlPackage : new DdlPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		BasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDdlPackage.createPackageContents();

		// Initialize created meta-data
		theDdlPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDdlPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DdlPackage.eNS_URI, theDdlPackage);
		return theDdlPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataDescriptionModel() {
		return dataDescriptionModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataDescriptionModel_Name() {
		return (EAttribute)dataDescriptionModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataDescriptionModel_Imports() {
		return (EReference)dataDescriptionModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataDescriptionModel_Types() {
		return (EReference)dataDescriptionModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataDescriptionModel_Descriptions() {
		return (EReference)dataDescriptionModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataDescriptionModel_Constraints() {
		return (EReference)dataDescriptionModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataTypeDefinition() {
		return dataTypeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataTypeDefinition_Scale() {
		return (EAttribute)dataTypeDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataTypeDefinition_Name() {
		return (EAttribute)dataTypeDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataTypeDefinition_Description() {
		return (EAttribute)dataTypeDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataTypeDefinition_Constraints() {
		return (EReference)dataTypeDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDataDescription() {
		return dataDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataDescription_Name() {
		return (EAttribute)dataDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDataDescription_Constraints() {
		return (EReference)dataDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDataDescription_Representation() {
		return (EAttribute)dataDescriptionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypedDataDescription() {
		return typedDataDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypedDataDescription_Type() {
		return (EReference)typedDataDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUntypedDataDescription() {
		return untypedDataDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUntypedDataDescription_Scale() {
		return (EAttribute)untypedDataDescriptionEClass.getEStructuralFeatures().get(0);
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
	public EClass getSelfReference() {
		return selfReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getScaleType() {
		return scaleTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getRepresentationType() {
		return representationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DdlFactory getDdlFactory() {
		return (DdlFactory)getEFactoryInstance();
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
		dataDescriptionModelEClass = createEClass(DATA_DESCRIPTION_MODEL);
		createEAttribute(dataDescriptionModelEClass, DATA_DESCRIPTION_MODEL__NAME);
		createEReference(dataDescriptionModelEClass, DATA_DESCRIPTION_MODEL__IMPORTS);
		createEReference(dataDescriptionModelEClass, DATA_DESCRIPTION_MODEL__TYPES);
		createEReference(dataDescriptionModelEClass, DATA_DESCRIPTION_MODEL__DESCRIPTIONS);
		createEReference(dataDescriptionModelEClass, DATA_DESCRIPTION_MODEL__CONSTRAINTS);

		dataTypeDefinitionEClass = createEClass(DATA_TYPE_DEFINITION);
		createEAttribute(dataTypeDefinitionEClass, DATA_TYPE_DEFINITION__SCALE);
		createEAttribute(dataTypeDefinitionEClass, DATA_TYPE_DEFINITION__NAME);
		createEAttribute(dataTypeDefinitionEClass, DATA_TYPE_DEFINITION__DESCRIPTION);
		createEReference(dataTypeDefinitionEClass, DATA_TYPE_DEFINITION__CONSTRAINTS);

		dataDescriptionEClass = createEClass(DATA_DESCRIPTION);
		createEAttribute(dataDescriptionEClass, DATA_DESCRIPTION__NAME);
		createEReference(dataDescriptionEClass, DATA_DESCRIPTION__CONSTRAINTS);
		createEAttribute(dataDescriptionEClass, DATA_DESCRIPTION__REPRESENTATION);

		typedDataDescriptionEClass = createEClass(TYPED_DATA_DESCRIPTION);
		createEReference(typedDataDescriptionEClass, TYPED_DATA_DESCRIPTION__TYPE);

		untypedDataDescriptionEClass = createEClass(UNTYPED_DATA_DESCRIPTION);
		createEAttribute(untypedDataDescriptionEClass, UNTYPED_DATA_DESCRIPTION__SCALE);

		dataReferenceEClass = createEClass(DATA_REFERENCE);
		createEReference(dataReferenceEClass, DATA_REFERENCE__DEFINITION);

		selfReferenceEClass = createEClass(SELF_REFERENCE);

		// Create enums
		scaleTypeEEnum = createEEnum(SCALE_TYPE);
		representationTypeEEnum = createEEnum(REPRESENTATION_TYPE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		typedDataDescriptionEClass.getESuperTypes().add(this.getDataDescription());
		untypedDataDescriptionEClass.getESuperTypes().add(this.getDataDescription());
		dataReferenceEClass.getESuperTypes().add(theBasePackage.getValueReference());
		selfReferenceEClass.getESuperTypes().add(theBasePackage.getValueReference());

		// Initialize classes and features; add operations and parameters
		initEClass(dataDescriptionModelEClass, DataDescriptionModel.class, "DataDescriptionModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataDescriptionModel_Name(), ecorePackage.getEString(), "name", null, 1, 1, DataDescriptionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataDescriptionModel_Imports(), theBasePackage.getImport(), null, "imports", null, 0, -1, DataDescriptionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataDescriptionModel_Types(), this.getDataTypeDefinition(), null, "types", null, 0, -1, DataDescriptionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataDescriptionModel_Descriptions(), this.getDataDescription(), null, "descriptions", null, 0, -1, DataDescriptionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDataDescriptionModel_Constraints(), theBasePackage.getExpression(), null, "constraints", null, 0, -1, DataDescriptionModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataTypeDefinitionEClass, DataTypeDefinition.class, "DataTypeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataTypeDefinition_Scale(), this.getScaleType(), "scale", null, 0, 1, DataTypeDefinition.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataTypeDefinition_Name(), ecorePackage.getEString(), "name", null, 1, 1, DataTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataTypeDefinition_Description(), ecorePackage.getEString(), "description", null, 0, 1, DataTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataTypeDefinition_Constraints(), theBasePackage.getExpression(), null, "constraints", null, 0, -1, DataTypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataDescriptionEClass, DataDescription.class, "DataDescription", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataDescription_Name(), ecorePackage.getEString(), "name", null, 1, 1, DataDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataDescription_Constraints(), theBasePackage.getExpression(), null, "constraints", null, 0, -1, DataDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDataDescription_Representation(), this.getRepresentationType(), "representation", "real", 1, 1, DataDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(dataDescriptionEClass, this.getScaleType(), "getScale", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(typedDataDescriptionEClass, TypedDataDescription.class, "TypedDataDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedDataDescription_Type(), this.getDataTypeDefinition(), null, "type", null, 1, 1, TypedDataDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(typedDataDescriptionEClass, this.getScaleType(), "getScale", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(untypedDataDescriptionEClass, UntypedDataDescription.class, "UntypedDataDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUntypedDataDescription_Scale(), this.getScaleType(), "scale", null, 0, 1, UntypedDataDescription.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataReferenceEClass, DataReference.class, "DataReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataReference_Definition(), this.getDataDescription(), null, "definition", null, 1, 1, DataReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selfReferenceEClass, SelfReference.class, "SelfReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(scaleTypeEEnum, ScaleType.class, "ScaleType");
		addEEnumLiteral(scaleTypeEEnum, ScaleType.NOMINAL);
		addEEnumLiteral(scaleTypeEEnum, ScaleType.ORDINAL);
		addEEnumLiteral(scaleTypeEEnum, ScaleType.CARDINAL);
		addEEnumLiteral(scaleTypeEEnum, ScaleType.QUOTIENT);

		initEEnum(representationTypeEEnum, RepresentationType.class, "RepresentationType");
		addEEnumLiteral(representationTypeEEnum, RepresentationType.REAL);
		addEEnumLiteral(representationTypeEEnum, RepresentationType.INTEGER);
		addEEnumLiteral(representationTypeEEnum, RepresentationType.BOOLEAN);
		addEEnumLiteral(representationTypeEEnum, RepresentationType.STRING);

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
			   "dl", "platform:/resource/de.evoal.languages.model.dl/model/model.ecore#/",
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore",
			   "el", "platform:/resource/de.evoal.languages.model.base/model/model.ecore#/"
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
		  (getDataDescriptionModel_Imports(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getDataDescriptionModel_Types(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getDataDescriptionModel_Descriptions(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getDataDescriptionModel_Constraints(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getDataTypeDefinition_Constraints(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getDataDescription_Constraints(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
	}

} //DdlPackageImpl
