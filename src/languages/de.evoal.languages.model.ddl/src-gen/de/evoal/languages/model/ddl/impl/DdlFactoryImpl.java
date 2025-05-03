/**
 */
package de.evoal.languages.model.ddl.impl;

import de.evoal.languages.model.ddl.*;

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
public class DdlFactoryImpl extends EFactoryImpl implements DdlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DdlFactory init() {
		try {
			DdlFactory theDdlFactory = (DdlFactory)EPackage.Registry.INSTANCE.getEFactory(DdlPackage.eNS_URI);
			if (theDdlFactory != null) {
				return theDdlFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DdlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DdlFactoryImpl() {
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
			case DdlPackage.DATA_DESCRIPTION_MODULE: return createDataDescriptionModule();
			case DdlPackage.BASE_DATA_TYPE_DEFINITION: return createBaseDataTypeDefinition();
			case DdlPackage.ENUM_LITERAL: return createEnumLiteral();
			case DdlPackage.ENUM_TYPE_DEFINITION: return createEnumTypeDefinition();
			case DdlPackage.TYPED_BASE_DATA_DESCRIPTION: return createTypedBaseDataDescription();
			case DdlPackage.UNTYPED_BASE_DATA_DESCRIPTION: return createUntypedBaseDataDescription();
			case DdlPackage.STRUCTURED_DATA_DESCRIPTION: return createStructuredDataDescription();
			case DdlPackage.DATA_REFERENCE: return createDataReference();
			case DdlPackage.SELF_REFERENCE: return createSelfReference();
			case DdlPackage.DATA_TYPE: return createDataType();
			case DdlPackage.ENUM_LITERAL_REFERENCE: return createEnumLiteralReference();
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
			case DdlPackage.SCALE_TYPE:
				return createScaleTypeFromString(eDataType, initialValue);
			case DdlPackage.REPRESENTATION_TYPE:
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
			case DdlPackage.SCALE_TYPE:
				return convertScaleTypeToString(eDataType, instanceValue);
			case DdlPackage.REPRESENTATION_TYPE:
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
	public DataDescriptionModule createDataDescriptionModule() {
		DataDescriptionModuleImpl dataDescriptionModule = new DataDescriptionModuleImpl();
		return dataDescriptionModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BaseDataTypeDefinition createBaseDataTypeDefinition() {
		BaseDataTypeDefinitionImpl baseDataTypeDefinition = new BaseDataTypeDefinitionImpl();
		return baseDataTypeDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumLiteral createEnumLiteral() {
		EnumLiteralImpl enumLiteral = new EnumLiteralImpl();
		return enumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumTypeDefinition createEnumTypeDefinition() {
		EnumTypeDefinitionImpl enumTypeDefinition = new EnumTypeDefinitionImpl();
		return enumTypeDefinition;
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
	public DataReference createDataReference() {
		DataReferenceImpl dataReference = new DataReferenceImpl();
		return dataReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SelfReference createSelfReference() {
		SelfReferenceImpl selfReference = new SelfReferenceImpl();
		return selfReference;
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
	public EnumLiteralReference createEnumLiteralReference() {
		EnumLiteralReferenceImpl enumLiteralReference = new EnumLiteralReferenceImpl();
		return enumLiteralReference;
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
	public DdlPackage getDdlPackage() {
		return (DdlPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DdlPackage getPackage() {
		return DdlPackage.eINSTANCE;
	}

} //DdlFactoryImpl
