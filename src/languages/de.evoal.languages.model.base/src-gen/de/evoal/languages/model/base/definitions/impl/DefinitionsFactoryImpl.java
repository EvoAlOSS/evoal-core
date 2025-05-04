/**
 */
package de.evoal.languages.model.base.definitions.impl;

import de.evoal.languages.model.base.definitions.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DefinitionsFactoryImpl extends EFactoryImpl implements DefinitionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DefinitionsFactory init() {
		try {
			DefinitionsFactory theDefinitionsFactory = (DefinitionsFactory)EPackage.Registry.INSTANCE.getEFactory(DefinitionsPackage.eNS_URI);
			if (theDefinitionsFactory != null) {
				return theDefinitionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DefinitionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinitionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DefinitionsPackage.SCALED_DEFINITION: return createScaledDefinition();
			case DefinitionsPackage.TYPE_DEFINITION: return createTypeDefinition();
			case DefinitionsPackage.ATTRIBUTE_DEFINITION: return createAttributeDefinition();
			case DefinitionsPackage.ENUM_LITERAL_DEFINITION: return createEnumLiteralDefinition();
			case DefinitionsPackage.ENUM_DEFINITION: return createEnumDefinition();
			case DefinitionsPackage.DATA_TYPE_TYPE_DEFINITION: return createDataTypeTypeDefinition();
			case DefinitionsPackage.TYPED_BASE_DATA_DESCRIPTION: return createTypedBaseDataDescription();
			case DefinitionsPackage.UNTYPED_BASE_DATA_DESCRIPTION: return createUntypedBaseDataDescription();
			case DefinitionsPackage.STRUCTURED_DATA_DESCRIPTION: return createStructuredDataDescription();
			case DefinitionsPackage.DATA_TYPE: return createDataType();
			case DefinitionsPackage.FUNCTION_DEFINITION: return createFunctionDefinition();
			case DefinitionsPackage.PARAMETER: return createParameter();
			case DefinitionsPackage.CONSTANT_DEFINITION: return createConstantDefinition();
			case DefinitionsPackage.FUNCTION_NAME: return createFunctionName();
			case DefinitionsPackage.DEFINED_FUNCTION_NAME: return createDefinedFunctionName();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DefinitionsPackage.SCALE_TYPE:
				return createScaleTypeFromString(eDataType, initialValue);
			case DefinitionsPackage.REPRESENTATION_TYPE:
				return createRepresentationTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DefinitionsPackage.SCALE_TYPE:
				return convertScaleTypeToString(eDataType, instanceValue);
			case DefinitionsPackage.REPRESENTATION_TYPE:
				return convertRepresentationTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScaledDefinition createScaledDefinition() {
		ScaledDefinitionImpl scaledDefinition = new ScaledDefinitionImpl();
		return scaledDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeDefinition createTypeDefinition() {
		TypeDefinitionImpl typeDefinition = new TypeDefinitionImpl();
		return typeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeDefinition createAttributeDefinition() {
		AttributeDefinitionImpl attributeDefinition = new AttributeDefinitionImpl();
		return attributeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumLiteralDefinition createEnumLiteralDefinition() {
		EnumLiteralDefinitionImpl enumLiteralDefinition = new EnumLiteralDefinitionImpl();
		return enumLiteralDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumDefinition createEnumDefinition() {
		EnumDefinitionImpl enumDefinition = new EnumDefinitionImpl();
		return enumDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataTypeTypeDefinition createDataTypeTypeDefinition() {
		DataTypeTypeDefinitionImpl dataTypeTypeDefinition = new DataTypeTypeDefinitionImpl();
		return dataTypeTypeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedBaseDataDescription createTypedBaseDataDescription() {
		TypedBaseDataDescriptionImpl typedBaseDataDescription = new TypedBaseDataDescriptionImpl();
		return typedBaseDataDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UntypedBaseDataDescription createUntypedBaseDataDescription() {
		UntypedBaseDataDescriptionImpl untypedBaseDataDescription = new UntypedBaseDataDescriptionImpl();
		return untypedBaseDataDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StructuredDataDescription createStructuredDataDescription() {
		StructuredDataDescriptionImpl structuredDataDescription = new StructuredDataDescriptionImpl();
		return structuredDataDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionDefinition createFunctionDefinition() {
		FunctionDefinitionImpl functionDefinition = new FunctionDefinitionImpl();
		return functionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstantDefinition createConstantDefinition() {
		ConstantDefinitionImpl constantDefinition = new ConstantDefinitionImpl();
		return constantDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionName createFunctionName() {
		FunctionNameImpl functionName = new FunctionNameImpl();
		return functionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefinedFunctionName createDefinedFunctionName() {
		DefinedFunctionNameImpl definedFunctionName = new DefinedFunctionNameImpl();
		return definedFunctionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScaleType createScaleTypeFromString(EDataType eDataType, String initialValue) {
		ScaleType result = ScaleType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScaleTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepresentationType createRepresentationTypeFromString(EDataType eDataType, String initialValue) {
		RepresentationType result = RepresentationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRepresentationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DefinitionsPackage getDefinitionsPackage() {
		return (DefinitionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DefinitionsPackage getPackage() {
		return DefinitionsPackage.eINSTANCE;
	}

} //DefinitionsFactoryImpl
