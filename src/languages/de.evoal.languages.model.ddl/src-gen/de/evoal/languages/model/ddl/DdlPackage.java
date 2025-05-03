/**
 */
package de.evoal.languages.model.ddl;

import de.evoal.languages.model.base.BasePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.ddl.DdlFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import base='platform:/resource/de.evoal.languages.model.base/model/model.ecore#/' dl='platform:/resource/de.evoal.languages.model.dl/model/model.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore'"
 * @generated
 */
public interface DdlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ddl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/ddl/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ddl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DdlPackage eINSTANCE = de.evoal.languages.model.ddl.impl.DdlPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl <em>Data Description Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataDescriptionModule()
	 * @generated
	 */
	int DATA_DESCRIPTION_MODULE = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE__IMPORTS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE__TYPES = 2;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE__DESCRIPTIONS = 3;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE__CONSTRAINTS = 4;

	/**
	 * The number of structural features of the '<em>Data Description Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.DataTypeDefinitionImpl <em>Data Type Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.DataTypeDefinitionImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataTypeDefinition()
	 * @generated
	 */
	int DATA_TYPE_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__SCALE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__CONSTRAINTS = 3;

	/**
	 * The feature id for the '<em><b>Constraints2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__CONSTRAINTS2 = 4;

	/**
	 * The number of structural features of the '<em>Data Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.BaseDataTypeDefinitionImpl <em>Base Data Type Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.BaseDataTypeDefinitionImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getBaseDataTypeDefinition()
	 * @generated
	 */
	int BASE_DATA_TYPE_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_TYPE_DEFINITION__SCALE = DATA_TYPE_DEFINITION__SCALE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_TYPE_DEFINITION__NAME = DATA_TYPE_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_TYPE_DEFINITION__DESCRIPTION = DATA_TYPE_DEFINITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_TYPE_DEFINITION__CONSTRAINTS = DATA_TYPE_DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Constraints2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_TYPE_DEFINITION__CONSTRAINTS2 = DATA_TYPE_DEFINITION__CONSTRAINTS2;

	/**
	 * The number of structural features of the '<em>Base Data Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_TYPE_DEFINITION_FEATURE_COUNT = DATA_TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.EnumLiteralImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getEnumLiteral()
	 * @generated
	 */
	int ENUM_LITERAL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL__NAME = 0;

	/**
	 * The number of structural features of the '<em>Enum Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.EnumTypeDefinitionImpl <em>Enum Type Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.EnumTypeDefinitionImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getEnumTypeDefinition()
	 * @generated
	 */
	int ENUM_TYPE_DEFINITION = 4;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE_DEFINITION__SCALE = DATA_TYPE_DEFINITION__SCALE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE_DEFINITION__NAME = DATA_TYPE_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE_DEFINITION__DESCRIPTION = DATA_TYPE_DEFINITION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE_DEFINITION__CONSTRAINTS = DATA_TYPE_DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Constraints2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE_DEFINITION__CONSTRAINTS2 = DATA_TYPE_DEFINITION__CONSTRAINTS2;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE_DEFINITION__LITERALS = DATA_TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_TYPE_DEFINITION_FEATURE_COUNT = DATA_TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.DataDescriptionImpl <em>Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.DataDescriptionImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataDescription()
	 * @generated
	 */
	int DATA_DESCRIPTION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION__NAME = BasePackage.DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION__CONSTRAINTS = BasePackage.DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION__CONSTRAINTS2 = BasePackage.DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_FEATURE_COUNT = BasePackage.DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.BaseDataDescriptionImpl <em>Base Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.BaseDataDescriptionImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getBaseDataDescription()
	 * @generated
	 */
	int BASE_DATA_DESCRIPTION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_DESCRIPTION__NAME = DATA_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_DESCRIPTION__CONSTRAINTS = DATA_DESCRIPTION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Constraints2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_DESCRIPTION__CONSTRAINTS2 = DATA_DESCRIPTION__CONSTRAINTS2;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_DESCRIPTION__REPRESENTATION = DATA_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Base Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_DESCRIPTION_FEATURE_COUNT = DATA_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.TypedBaseDataDescriptionImpl <em>Typed Base Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.TypedBaseDataDescriptionImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getTypedBaseDataDescription()
	 * @generated
	 */
	int TYPED_BASE_DATA_DESCRIPTION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_BASE_DATA_DESCRIPTION__NAME = BASE_DATA_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_BASE_DATA_DESCRIPTION__CONSTRAINTS = BASE_DATA_DESCRIPTION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Constraints2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_BASE_DATA_DESCRIPTION__CONSTRAINTS2 = BASE_DATA_DESCRIPTION__CONSTRAINTS2;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_BASE_DATA_DESCRIPTION__REPRESENTATION = BASE_DATA_DESCRIPTION__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_BASE_DATA_DESCRIPTION__TYPE = BASE_DATA_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Base Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_BASE_DATA_DESCRIPTION_FEATURE_COUNT = BASE_DATA_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.StructuredDataDescriptionImpl <em>Structured Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.StructuredDataDescriptionImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getStructuredDataDescription()
	 * @generated
	 */
	int STRUCTURED_DATA_DESCRIPTION = 9;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.UntypedBaseDataDescriptionImpl <em>Untyped Base Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.UntypedBaseDataDescriptionImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getUntypedBaseDataDescription()
	 * @generated
	 */
	int UNTYPED_BASE_DATA_DESCRIPTION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_BASE_DATA_DESCRIPTION__NAME = BASE_DATA_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_BASE_DATA_DESCRIPTION__CONSTRAINTS = BASE_DATA_DESCRIPTION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Constraints2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_BASE_DATA_DESCRIPTION__CONSTRAINTS2 = BASE_DATA_DESCRIPTION__CONSTRAINTS2;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_BASE_DATA_DESCRIPTION__REPRESENTATION = BASE_DATA_DESCRIPTION__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_BASE_DATA_DESCRIPTION__SCALE = BASE_DATA_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Untyped Base Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_BASE_DATA_DESCRIPTION_FEATURE_COUNT = BASE_DATA_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_DESCRIPTION__NAME = DATA_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_DESCRIPTION__CONSTRAINTS = DATA_DESCRIPTION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Constraints2</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_DESCRIPTION__CONSTRAINTS2 = DATA_DESCRIPTION__CONSTRAINTS2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_DESCRIPTION__TYPE = DATA_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Structured Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_DESCRIPTION_FEATURE_COUNT = DATA_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.DataReferenceImpl <em>Data Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.DataReferenceImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataReference()
	 * @generated
	 */
	int DATA_REFERENCE = 10;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_REFERENCE__DEFINITION = BasePackage.VALUE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_REFERENCE_FEATURE_COUNT = BasePackage.VALUE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.SelfReferenceImpl <em>Self Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.SelfReferenceImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getSelfReference()
	 * @generated
	 */
	int SELF_REFERENCE = 11;

	/**
	 * The number of structural features of the '<em>Self Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_REFERENCE_FEATURE_COUNT = BasePackage.VALUE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.DataTypeImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 12;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__DEFINITION = BasePackage.TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = BasePackage.TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.EnumLiteralReferenceImpl <em>Enum Literal Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.EnumLiteralReferenceImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getEnumLiteralReference()
	 * @generated
	 */
	int ENUM_LITERAL_REFERENCE = 13;

	/**
	 * The feature id for the '<em><b>Literal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_REFERENCE__LITERAL = BasePackage.LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_REFERENCE_FEATURE_COUNT = BasePackage.LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.ScaleType <em>Scale Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.ScaleType
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getScaleType()
	 * @generated
	 */
	int SCALE_TYPE = 14;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.RepresentationType <em>Representation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.RepresentationType
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getRepresentationType()
	 * @generated
	 */
	int REPRESENTATION_TYPE = 15;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.DataDescriptionModule <em>Data Description Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Description Module</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule
	 * @generated
	 */
	EClass getDataDescriptionModule();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.DataDescriptionModule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule#getName()
	 * @see #getDataDescriptionModule()
	 * @generated
	 */
	EAttribute getDataDescriptionModule_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescriptionModule#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule#getImports()
	 * @see #getDataDescriptionModule()
	 * @generated
	 */
	EReference getDataDescriptionModule_Imports();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescriptionModule#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule#getTypes()
	 * @see #getDataDescriptionModule()
	 * @generated
	 */
	EReference getDataDescriptionModule_Types();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescriptionModule#getDescriptions <em>Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptions</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule#getDescriptions()
	 * @see #getDataDescriptionModule()
	 * @generated
	 */
	EReference getDataDescriptionModule_Descriptions();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescriptionModule#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule#getConstraints()
	 * @see #getDataDescriptionModule()
	 * @generated
	 */
	EReference getDataDescriptionModule_Constraints();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.DataTypeDefinition <em>Data Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Definition</em>'.
	 * @see de.evoal.languages.model.ddl.DataTypeDefinition
	 * @generated
	 */
	EClass getDataTypeDefinition();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.DataTypeDefinition#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see de.evoal.languages.model.ddl.DataTypeDefinition#getScale()
	 * @see #getDataTypeDefinition()
	 * @generated
	 */
	EAttribute getDataTypeDefinition_Scale();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.DataTypeDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.ddl.DataTypeDefinition#getName()
	 * @see #getDataTypeDefinition()
	 * @generated
	 */
	EAttribute getDataTypeDefinition_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.DataTypeDefinition#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.evoal.languages.model.ddl.DataTypeDefinition#getDescription()
	 * @see #getDataTypeDefinition()
	 * @generated
	 */
	EAttribute getDataTypeDefinition_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataTypeDefinition#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see de.evoal.languages.model.ddl.DataTypeDefinition#getConstraints()
	 * @see #getDataTypeDefinition()
	 * @generated
	 */
	EReference getDataTypeDefinition_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataTypeDefinition#getConstraints2 <em>Constraints2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints2</em>'.
	 * @see de.evoal.languages.model.ddl.DataTypeDefinition#getConstraints2()
	 * @see #getDataTypeDefinition()
	 * @generated
	 */
	EReference getDataTypeDefinition_Constraints2();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.BaseDataTypeDefinition <em>Base Data Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Data Type Definition</em>'.
	 * @see de.evoal.languages.model.ddl.BaseDataTypeDefinition
	 * @generated
	 */
	EClass getBaseDataTypeDefinition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.EnumLiteral <em>Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal</em>'.
	 * @see de.evoal.languages.model.ddl.EnumLiteral
	 * @generated
	 */
	EClass getEnumLiteral();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.EnumLiteral#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.ddl.EnumLiteral#getName()
	 * @see #getEnumLiteral()
	 * @generated
	 */
	EAttribute getEnumLiteral_Name();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.EnumTypeDefinition <em>Enum Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Type Definition</em>'.
	 * @see de.evoal.languages.model.ddl.EnumTypeDefinition
	 * @generated
	 */
	EClass getEnumTypeDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.EnumTypeDefinition#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see de.evoal.languages.model.ddl.EnumTypeDefinition#getLiterals()
	 * @see #getEnumTypeDefinition()
	 * @generated
	 */
	EReference getEnumTypeDefinition_Literals();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.DataDescription <em>Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Description</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescription
	 * @generated
	 */
	EClass getDataDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescription#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescription#getConstraints()
	 * @see #getDataDescription()
	 * @generated
	 */
	EReference getDataDescription_Constraints();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescription#getConstraints2 <em>Constraints2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints2</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescription#getConstraints2()
	 * @see #getDataDescription()
	 * @generated
	 */
	EReference getDataDescription_Constraints2();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.BaseDataDescription <em>Base Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Data Description</em>'.
	 * @see de.evoal.languages.model.ddl.BaseDataDescription
	 * @generated
	 */
	EClass getBaseDataDescription();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.BaseDataDescription#getRepresentation <em>Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Representation</em>'.
	 * @see de.evoal.languages.model.ddl.BaseDataDescription#getRepresentation()
	 * @see #getBaseDataDescription()
	 * @generated
	 */
	EAttribute getBaseDataDescription_Representation();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.TypedBaseDataDescription <em>Typed Base Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Base Data Description</em>'.
	 * @see de.evoal.languages.model.ddl.TypedBaseDataDescription
	 * @generated
	 */
	EClass getTypedBaseDataDescription();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.ddl.TypedBaseDataDescription#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.ddl.TypedBaseDataDescription#getType()
	 * @see #getTypedBaseDataDescription()
	 * @generated
	 */
	EReference getTypedBaseDataDescription_Type();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.StructuredDataDescription <em>Structured Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structured Data Description</em>'.
	 * @see de.evoal.languages.model.ddl.StructuredDataDescription
	 * @generated
	 */
	EClass getStructuredDataDescription();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.ddl.StructuredDataDescription#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.ddl.StructuredDataDescription#getType()
	 * @see #getStructuredDataDescription()
	 * @generated
	 */
	EReference getStructuredDataDescription_Type();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.UntypedBaseDataDescription <em>Untyped Base Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Untyped Base Data Description</em>'.
	 * @see de.evoal.languages.model.ddl.UntypedBaseDataDescription
	 * @generated
	 */
	EClass getUntypedBaseDataDescription();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.UntypedBaseDataDescription#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see de.evoal.languages.model.ddl.UntypedBaseDataDescription#getScale()
	 * @see #getUntypedBaseDataDescription()
	 * @generated
	 */
	EAttribute getUntypedBaseDataDescription_Scale();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.DataReference <em>Data Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Reference</em>'.
	 * @see de.evoal.languages.model.ddl.DataReference
	 * @generated
	 */
	EClass getDataReference();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.ddl.DataReference#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.ddl.DataReference#getDefinition()
	 * @see #getDataReference()
	 * @generated
	 */
	EReference getDataReference_Definition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.SelfReference <em>Self Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Self Reference</em>'.
	 * @see de.evoal.languages.model.ddl.SelfReference
	 * @generated
	 */
	EClass getSelfReference();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see de.evoal.languages.model.ddl.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.ddl.DataType#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.ddl.DataType#getDefinition()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_Definition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.EnumLiteralReference <em>Enum Literal Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Reference</em>'.
	 * @see de.evoal.languages.model.ddl.EnumLiteralReference
	 * @generated
	 */
	EClass getEnumLiteralReference();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.ddl.EnumLiteralReference#getLiteral <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Literal</em>'.
	 * @see de.evoal.languages.model.ddl.EnumLiteralReference#getLiteral()
	 * @see #getEnumLiteralReference()
	 * @generated
	 */
	EReference getEnumLiteralReference_Literal();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.ddl.ScaleType <em>Scale Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Scale Type</em>'.
	 * @see de.evoal.languages.model.ddl.ScaleType
	 * @generated
	 */
	EEnum getScaleType();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.ddl.RepresentationType <em>Representation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Representation Type</em>'.
	 * @see de.evoal.languages.model.ddl.RepresentationType
	 * @generated
	 */
	EEnum getRepresentationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DdlFactory getDdlFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl <em>Data Description Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.DataDescriptionModuleImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataDescriptionModule()
		 * @generated
		 */
		EClass DATA_DESCRIPTION_MODULE = eINSTANCE.getDataDescriptionModule();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_DESCRIPTION_MODULE__NAME = eINSTANCE.getDataDescriptionModule_Name();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION_MODULE__IMPORTS = eINSTANCE.getDataDescriptionModule_Imports();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION_MODULE__TYPES = eINSTANCE.getDataDescriptionModule_Types();

		/**
		 * The meta object literal for the '<em><b>Descriptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION_MODULE__DESCRIPTIONS = eINSTANCE.getDataDescriptionModule_Descriptions();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION_MODULE__CONSTRAINTS = eINSTANCE.getDataDescriptionModule_Constraints();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.DataTypeDefinitionImpl <em>Data Type Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.DataTypeDefinitionImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataTypeDefinition()
		 * @generated
		 */
		EClass DATA_TYPE_DEFINITION = eINSTANCE.getDataTypeDefinition();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_DEFINITION__SCALE = eINSTANCE.getDataTypeDefinition_Scale();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_DEFINITION__NAME = eINSTANCE.getDataTypeDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_DEFINITION__DESCRIPTION = eINSTANCE.getDataTypeDefinition_Description();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_DEFINITION__CONSTRAINTS = eINSTANCE.getDataTypeDefinition_Constraints();

		/**
		 * The meta object literal for the '<em><b>Constraints2</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_DEFINITION__CONSTRAINTS2 = eINSTANCE.getDataTypeDefinition_Constraints2();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.BaseDataTypeDefinitionImpl <em>Base Data Type Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.BaseDataTypeDefinitionImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getBaseDataTypeDefinition()
		 * @generated
		 */
		EClass BASE_DATA_TYPE_DEFINITION = eINSTANCE.getBaseDataTypeDefinition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.EnumLiteralImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getEnumLiteral()
		 * @generated
		 */
		EClass ENUM_LITERAL = eINSTANCE.getEnumLiteral();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUM_LITERAL__NAME = eINSTANCE.getEnumLiteral_Name();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.EnumTypeDefinitionImpl <em>Enum Type Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.EnumTypeDefinitionImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getEnumTypeDefinition()
		 * @generated
		 */
		EClass ENUM_TYPE_DEFINITION = eINSTANCE.getEnumTypeDefinition();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_TYPE_DEFINITION__LITERALS = eINSTANCE.getEnumTypeDefinition_Literals();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.DataDescriptionImpl <em>Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.DataDescriptionImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataDescription()
		 * @generated
		 */
		EClass DATA_DESCRIPTION = eINSTANCE.getDataDescription();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION__CONSTRAINTS = eINSTANCE.getDataDescription_Constraints();

		/**
		 * The meta object literal for the '<em><b>Constraints2</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION__CONSTRAINTS2 = eINSTANCE.getDataDescription_Constraints2();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.BaseDataDescriptionImpl <em>Base Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.BaseDataDescriptionImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getBaseDataDescription()
		 * @generated
		 */
		EClass BASE_DATA_DESCRIPTION = eINSTANCE.getBaseDataDescription();

		/**
		 * The meta object literal for the '<em><b>Representation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASE_DATA_DESCRIPTION__REPRESENTATION = eINSTANCE.getBaseDataDescription_Representation();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.TypedBaseDataDescriptionImpl <em>Typed Base Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.TypedBaseDataDescriptionImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getTypedBaseDataDescription()
		 * @generated
		 */
		EClass TYPED_BASE_DATA_DESCRIPTION = eINSTANCE.getTypedBaseDataDescription();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_BASE_DATA_DESCRIPTION__TYPE = eINSTANCE.getTypedBaseDataDescription_Type();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.StructuredDataDescriptionImpl <em>Structured Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.StructuredDataDescriptionImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getStructuredDataDescription()
		 * @generated
		 */
		EClass STRUCTURED_DATA_DESCRIPTION = eINSTANCE.getStructuredDataDescription();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCTURED_DATA_DESCRIPTION__TYPE = eINSTANCE.getStructuredDataDescription_Type();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.UntypedBaseDataDescriptionImpl <em>Untyped Base Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.UntypedBaseDataDescriptionImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getUntypedBaseDataDescription()
		 * @generated
		 */
		EClass UNTYPED_BASE_DATA_DESCRIPTION = eINSTANCE.getUntypedBaseDataDescription();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNTYPED_BASE_DATA_DESCRIPTION__SCALE = eINSTANCE.getUntypedBaseDataDescription_Scale();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.DataReferenceImpl <em>Data Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.DataReferenceImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataReference()
		 * @generated
		 */
		EClass DATA_REFERENCE = eINSTANCE.getDataReference();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_REFERENCE__DEFINITION = eINSTANCE.getDataReference_Definition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.SelfReferenceImpl <em>Self Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.SelfReferenceImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getSelfReference()
		 * @generated
		 */
		EClass SELF_REFERENCE = eINSTANCE.getSelfReference();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.DataTypeImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__DEFINITION = eINSTANCE.getDataType_Definition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.EnumLiteralReferenceImpl <em>Enum Literal Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.EnumLiteralReferenceImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getEnumLiteralReference()
		 * @generated
		 */
		EClass ENUM_LITERAL_REFERENCE = eINSTANCE.getEnumLiteralReference();

		/**
		 * The meta object literal for the '<em><b>Literal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL_REFERENCE__LITERAL = eINSTANCE.getEnumLiteralReference_Literal();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.ScaleType <em>Scale Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.ScaleType
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getScaleType()
		 * @generated
		 */
		EEnum SCALE_TYPE = eINSTANCE.getScaleType();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.RepresentationType <em>Representation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.RepresentationType
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getRepresentationType()
		 * @generated
		 */
		EEnum REPRESENTATION_TYPE = eINSTANCE.getRepresentationType();

	}

} //DdlPackage
