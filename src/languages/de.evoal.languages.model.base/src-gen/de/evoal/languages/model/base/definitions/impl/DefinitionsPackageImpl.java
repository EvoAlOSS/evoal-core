/**
 */
package de.evoal.languages.model.base.definitions.impl;

import de.evoal.languages.model.base.definitions.AttributeDefinition;
import de.evoal.languages.model.base.definitions.BaseDataDescription;
import de.evoal.languages.model.base.definitions.ClassDefinition;
import de.evoal.languages.model.base.definitions.ConstantDefinition;
import de.evoal.languages.model.base.definitions.Constrained;
import de.evoal.languages.model.base.definitions.DataDescription;
import de.evoal.languages.model.base.definitions.DataTypeDefinition;
import de.evoal.languages.model.base.definitions.DataTypeTypeDefinition;
import de.evoal.languages.model.base.definitions.DefinedFunctionName;
import de.evoal.languages.model.base.definitions.Definition;
import de.evoal.languages.model.base.definitions.DefinitionsFactory;
import de.evoal.languages.model.base.definitions.DefinitionsPackage;
import de.evoal.languages.model.base.definitions.EnumDefinition;
import de.evoal.languages.model.base.definitions.EnumLiteralDefinition;
import de.evoal.languages.model.base.definitions.FunctionDefinition;
import de.evoal.languages.model.base.definitions.FunctionName;
import de.evoal.languages.model.base.definitions.LiteralDefinition;
import de.evoal.languages.model.base.definitions.Parameter;
import de.evoal.languages.model.base.definitions.RepresentationType;
import de.evoal.languages.model.base.definitions.ScaleType;
import de.evoal.languages.model.base.definitions.ScaledDefinition;
import de.evoal.languages.model.base.definitions.StructuredDataDescription;
import de.evoal.languages.model.base.definitions.TypeDefinition;
import de.evoal.languages.model.base.definitions.TypedBaseDataDescription;
import de.evoal.languages.model.base.definitions.UntypedBaseDataDescription;

import de.evoal.languages.model.base.definitions.ValueDefinition;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;

import de.evoal.languages.model.base.expressions.impl.ExpressionsPackageImpl;

import de.evoal.languages.model.base.types.TypesPackage;

import de.evoal.languages.model.base.types.impl.TypesPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DefinitionsPackageImpl extends EPackageImpl implements DefinitionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constrainedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scaledDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumLiteralDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumDefinitionEClass = null;

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
	private EClass dataTypeTypeDefinitionEClass = null;

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
	private EClass baseDataDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedBaseDataDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass untypedBaseDataDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuredDataDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantDefinitionEClass = null;

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
	private EClass definedFunctionNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueDefinitionEClass = null;

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
	 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DefinitionsPackageImpl() {
		super(eNS_URI, DefinitionsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DefinitionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DefinitionsPackage init() {
		if (isInited) return (DefinitionsPackage)EPackage.Registry.INSTANCE.getEPackage(DefinitionsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDefinitionsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DefinitionsPackageImpl theDefinitionsPackage = registeredDefinitionsPackage instanceof DefinitionsPackageImpl ? (DefinitionsPackageImpl)registeredDefinitionsPackage : new DefinitionsPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(registeredPackage instanceof ExpressionsPackageImpl ? registeredPackage : ExpressionsPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(registeredPackage instanceof TypesPackageImpl ? registeredPackage : TypesPackage.eINSTANCE);

		// Create package meta-data objects
		theDefinitionsPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theDefinitionsPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDefinitionsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DefinitionsPackage.eNS_URI, theDefinitionsPackage);
		return theDefinitionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstrained() {
		return constrainedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstrained_Constraints() {
		return (EReference)constrainedEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getDefinition_Name() {
		return (EAttribute)definitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeDefinition() {
		return typeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLiteralDefinition() {
		return literalDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getScaledDefinition() {
		return scaledDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getScaledDefinition_Scale() {
		return (EAttribute)scaledDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getClassDefinition() {
		return classDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassDefinition_Attributes() {
		return (EReference)classDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassDefinition_SuperType() {
		return (EReference)classDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getClassDefinition_Abstract() {
		return (EAttribute)classDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getClassDefinition__FindAttribute__String() {
		return classDefinitionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getClassDefinition__GetAllAttributes() {
		return classDefinitionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeDefinition() {
		return attributeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeDefinition_Type() {
		return (EReference)attributeDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeDefinition_Initialisation() {
		return (EReference)attributeDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributeDefinition_Optional() {
		return (EAttribute)attributeDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumLiteralDefinition() {
		return enumLiteralDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumDefinition() {
		return enumDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnumDefinition_Literals() {
		return (EReference)enumDefinitionEClass.getEStructuralFeatures().get(0);
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
	public EClass getDataTypeTypeDefinition() {
		return dataTypeTypeDefinitionEClass;
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
	public EClass getBaseDataDescription() {
		return baseDataDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getBaseDataDescription_Representation() {
		return (EAttribute)baseDataDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getBaseDataDescription__GetScale() {
		return baseDataDescriptionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypedBaseDataDescription() {
		return typedBaseDataDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypedBaseDataDescription_Type() {
		return (EReference)typedBaseDataDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTypedBaseDataDescription__GetScale() {
		return typedBaseDataDescriptionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUntypedBaseDataDescription() {
		return untypedBaseDataDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStructuredDataDescription() {
		return structuredDataDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStructuredDataDescription_Type() {
		return (EReference)structuredDataDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFunctionDefinition() {
		return functionDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionDefinition_Type() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFunctionDefinition_Parameters() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameter_Type() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConstantDefinition() {
		return constantDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstantDefinition_Type() {
		return (EReference)constantDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConstantDefinition_Value() {
		return (EReference)constantDefinitionEClass.getEStructuralFeatures().get(1);
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
	public EClass getValueDefinition() {
		return valueDefinitionEClass;
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
	public DefinitionsFactory getDefinitionsFactory() {
		return (DefinitionsFactory)getEFactoryInstance();
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
		constrainedEClass = createEClass(CONSTRAINED);
		createEReference(constrainedEClass, CONSTRAINED__CONSTRAINTS);

		definitionEClass = createEClass(DEFINITION);
		createEAttribute(definitionEClass, DEFINITION__NAME);

		valueDefinitionEClass = createEClass(VALUE_DEFINITION);

		typeDefinitionEClass = createEClass(TYPE_DEFINITION);

		literalDefinitionEClass = createEClass(LITERAL_DEFINITION);

		scaledDefinitionEClass = createEClass(SCALED_DEFINITION);
		createEAttribute(scaledDefinitionEClass, SCALED_DEFINITION__SCALE);

		classDefinitionEClass = createEClass(CLASS_DEFINITION);
		createEReference(classDefinitionEClass, CLASS_DEFINITION__ATTRIBUTES);
		createEReference(classDefinitionEClass, CLASS_DEFINITION__SUPER_TYPE);
		createEAttribute(classDefinitionEClass, CLASS_DEFINITION__ABSTRACT);
		createEOperation(classDefinitionEClass, CLASS_DEFINITION___FIND_ATTRIBUTE__STRING);
		createEOperation(classDefinitionEClass, CLASS_DEFINITION___GET_ALL_ATTRIBUTES);

		attributeDefinitionEClass = createEClass(ATTRIBUTE_DEFINITION);
		createEReference(attributeDefinitionEClass, ATTRIBUTE_DEFINITION__TYPE);
		createEReference(attributeDefinitionEClass, ATTRIBUTE_DEFINITION__INITIALISATION);
		createEAttribute(attributeDefinitionEClass, ATTRIBUTE_DEFINITION__OPTIONAL);

		enumLiteralDefinitionEClass = createEClass(ENUM_LITERAL_DEFINITION);

		enumDefinitionEClass = createEClass(ENUM_DEFINITION);
		createEReference(enumDefinitionEClass, ENUM_DEFINITION__LITERALS);

		dataTypeDefinitionEClass = createEClass(DATA_TYPE_DEFINITION);

		dataTypeTypeDefinitionEClass = createEClass(DATA_TYPE_TYPE_DEFINITION);

		dataDescriptionEClass = createEClass(DATA_DESCRIPTION);

		baseDataDescriptionEClass = createEClass(BASE_DATA_DESCRIPTION);
		createEAttribute(baseDataDescriptionEClass, BASE_DATA_DESCRIPTION__REPRESENTATION);
		createEOperation(baseDataDescriptionEClass, BASE_DATA_DESCRIPTION___GET_SCALE);

		typedBaseDataDescriptionEClass = createEClass(TYPED_BASE_DATA_DESCRIPTION);
		createEReference(typedBaseDataDescriptionEClass, TYPED_BASE_DATA_DESCRIPTION__TYPE);
		createEOperation(typedBaseDataDescriptionEClass, TYPED_BASE_DATA_DESCRIPTION___GET_SCALE);

		untypedBaseDataDescriptionEClass = createEClass(UNTYPED_BASE_DATA_DESCRIPTION);

		structuredDataDescriptionEClass = createEClass(STRUCTURED_DATA_DESCRIPTION);
		createEReference(structuredDataDescriptionEClass, STRUCTURED_DATA_DESCRIPTION__TYPE);

		functionDefinitionEClass = createEClass(FUNCTION_DEFINITION);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__TYPE);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__PARAMETERS);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__TYPE);

		constantDefinitionEClass = createEClass(CONSTANT_DEFINITION);
		createEReference(constantDefinitionEClass, CONSTANT_DEFINITION__TYPE);
		createEReference(constantDefinitionEClass, CONSTANT_DEFINITION__VALUE);

		functionNameEClass = createEClass(FUNCTION_NAME);

		definedFunctionNameEClass = createEClass(DEFINED_FUNCTION_NAME);
		createEReference(definedFunctionNameEClass, DEFINED_FUNCTION_NAME__DEFINITION);

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
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		definitionEClass.getESuperTypes().add(this.getConstrained());
		valueDefinitionEClass.getESuperTypes().add(this.getDefinition());
		typeDefinitionEClass.getESuperTypes().add(this.getDefinition());
		literalDefinitionEClass.getESuperTypes().add(this.getValueDefinition());
		classDefinitionEClass.getESuperTypes().add(this.getTypeDefinition());
		attributeDefinitionEClass.getESuperTypes().add(this.getDefinition());
		attributeDefinitionEClass.getESuperTypes().add(this.getValueDefinition());
		enumLiteralDefinitionEClass.getESuperTypes().add(this.getLiteralDefinition());
		enumDefinitionEClass.getESuperTypes().add(this.getTypeDefinition());
		enumDefinitionEClass.getESuperTypes().add(this.getScaledDefinition());
		dataTypeDefinitionEClass.getESuperTypes().add(this.getTypeDefinition());
		dataTypeTypeDefinitionEClass.getESuperTypes().add(this.getDataTypeDefinition());
		dataTypeTypeDefinitionEClass.getESuperTypes().add(this.getScaledDefinition());
		dataDescriptionEClass.getESuperTypes().add(this.getDataTypeDefinition());
		baseDataDescriptionEClass.getESuperTypes().add(this.getDataDescription());
		typedBaseDataDescriptionEClass.getESuperTypes().add(this.getBaseDataDescription());
		untypedBaseDataDescriptionEClass.getESuperTypes().add(this.getBaseDataDescription());
		untypedBaseDataDescriptionEClass.getESuperTypes().add(this.getScaledDefinition());
		structuredDataDescriptionEClass.getESuperTypes().add(this.getDataDescription());
		functionDefinitionEClass.getESuperTypes().add(this.getDefinition());
		parameterEClass.getESuperTypes().add(this.getDefinition());
		constantDefinitionEClass.getESuperTypes().add(this.getLiteralDefinition());
		definedFunctionNameEClass.getESuperTypes().add(this.getFunctionName());

		// Initialize classes, features, and operations; add parameters
		initEClass(constrainedEClass, Constrained.class, "Constrained", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstrained_Constraints(), theExpressionsPackage.getExpression(), null, "constraints", null, 0, -1, Constrained.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(definitionEClass, Definition.class, "Definition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueDefinitionEClass, ValueDefinition.class, "ValueDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeDefinitionEClass, TypeDefinition.class, "TypeDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(literalDefinitionEClass, LiteralDefinition.class, "LiteralDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scaledDefinitionEClass, ScaledDefinition.class, "ScaledDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScaledDefinition_Scale(), this.getScaleType(), "scale", null, 0, 1, ScaledDefinition.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classDefinitionEClass, ClassDefinition.class, "ClassDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassDefinition_Attributes(), this.getAttributeDefinition(), null, "attributes", null, 0, -1, ClassDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassDefinition_SuperType(), this.getClassDefinition(), null, "superType", null, 0, 1, ClassDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassDefinition_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 1, 1, ClassDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getClassDefinition__FindAttribute__String(), this.getAttributeDefinition(), "findAttribute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getClassDefinition__GetAllAttributes(), this.getAttributeDefinition(), "getAllAttributes", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEClass(attributeDefinitionEClass, AttributeDefinition.class, "AttributeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeDefinition_Type(), theTypesPackage.getType(), null, "type", null, 1, 1, AttributeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeDefinition_Initialisation(), theExpressionsPackage.getExpression(), null, "initialisation", null, 0, 1, AttributeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeDefinition_Optional(), ecorePackage.getEBoolean(), "optional", "false", 1, 1, AttributeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumLiteralDefinitionEClass, EnumLiteralDefinition.class, "EnumLiteralDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumDefinitionEClass, EnumDefinition.class, "EnumDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumDefinition_Literals(), this.getEnumLiteralDefinition(), null, "literals", null, 0, -1, EnumDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dataTypeDefinitionEClass, DataTypeDefinition.class, "DataTypeDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataTypeTypeDefinitionEClass, DataTypeTypeDefinition.class, "DataTypeTypeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataDescriptionEClass, DataDescription.class, "DataDescription", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(baseDataDescriptionEClass, BaseDataDescription.class, "BaseDataDescription", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBaseDataDescription_Representation(), this.getRepresentationType(), "representation", "real", 1, 1, BaseDataDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getBaseDataDescription__GetScale(), this.getScaleType(), "getScale", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(typedBaseDataDescriptionEClass, TypedBaseDataDescription.class, "TypedBaseDataDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedBaseDataDescription_Type(), this.getDefinition(), null, "type", null, 1, 1, TypedBaseDataDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTypedBaseDataDescription__GetScale(), this.getScaleType(), "getScale", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(untypedBaseDataDescriptionEClass, UntypedBaseDataDescription.class, "UntypedBaseDataDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(structuredDataDescriptionEClass, StructuredDataDescription.class, "StructuredDataDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuredDataDescription_Type(), this.getClassDefinition(), null, "type", null, 1, 1, StructuredDataDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionDefinitionEClass, FunctionDefinition.class, "FunctionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionDefinition_Type(), theTypesPackage.getType(), null, "type", null, 1, 1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDefinition_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_Type(), theTypesPackage.getType(), null, "type", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constantDefinitionEClass, ConstantDefinition.class, "ConstantDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstantDefinition_Type(), theTypesPackage.getType(), null, "type", null, 1, 1, ConstantDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstantDefinition_Value(), theExpressionsPackage.getExpression(), null, "value", null, 1, 1, ConstantDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionNameEClass, FunctionName.class, "FunctionName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(definedFunctionNameEClass, DefinedFunctionName.class, "DefinedFunctionName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefinedFunctionName_Definition(), this.getFunctionDefinition(), null, "definition", null, 1, 1, DefinedFunctionName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(scaleTypeEEnum, ScaleType.class, "ScaleType");
		addEEnumLiteral(scaleTypeEEnum, ScaleType.NOMINAL);
		addEEnumLiteral(scaleTypeEEnum, ScaleType.ORDINAL);
		addEEnumLiteral(scaleTypeEEnum, ScaleType.CARDINAL);
		addEEnumLiteral(scaleTypeEEnum, ScaleType.QUOTIENT);
		addEEnumLiteral(scaleTypeEEnum, ScaleType.UNKNOWN);

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
			   "ecore", "http://www.eclipse.org/emf/2002/Ecore",
			   "expr", "expressions.ecore#/",
			   "types", "types.ecore#/"
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
		  (getConstrained_Constraints(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getEnumDefinition_Literals(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
		addAnnotation
		  (getFunctionDefinition_Parameters(),
		   source,
		   new String[] {
			   "nullFree", "false"
		   });
	}

} //DefinitionsPackageImpl
