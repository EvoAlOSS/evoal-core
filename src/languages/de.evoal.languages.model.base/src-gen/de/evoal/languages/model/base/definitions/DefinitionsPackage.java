/**
 */
package de.evoal.languages.model.base.definitions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.base.definitions.DefinitionsFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore' expr='expressions.ecore#/' types='types.ecore#/'"
 * @generated
 */
public interface DefinitionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "definitions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "https://www.evoal.de/languages/base/definitions/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "defs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DefinitionsPackage eINSTANCE = de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.ConstrainedImpl <em>Constrained</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.ConstrainedImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getConstrained()
	 * @generated
	 */
	int CONSTRAINED = 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED__CONSTRAINTS = 0;

	/**
	 * The number of structural features of the '<em>Constrained</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Constrained</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.DefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getDefinition()
	 * @generated
	 */
	int DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION__CONSTRAINTS = CONSTRAINED__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION__NAME = CONSTRAINED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_FEATURE_COUNT = CONSTRAINED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_OPERATION_COUNT = CONSTRAINED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.TypeDefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getTypeDefinition()
	 * @generated
	 */
	int TYPE_DEFINITION = 3;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.LiteralDefinitionImpl <em>Literal Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.LiteralDefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getLiteralDefinition()
	 * @generated
	 */
	int LITERAL_DEFINITION = 4;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.ScaledDefinitionImpl <em>Scaled Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.ScaledDefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getScaledDefinition()
	 * @generated
	 */
	int SCALED_DEFINITION = 5;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.ClassDefinitionImpl <em>Class Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.ClassDefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getClassDefinition()
	 * @generated
	 */
	int CLASS_DEFINITION = 6;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.AttributeDefinitionImpl <em>Attribute Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.AttributeDefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getAttributeDefinition()
	 * @generated
	 */
	int ATTRIBUTE_DEFINITION = 7;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.EnumLiteralDefinitionImpl <em>Enum Literal Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.EnumLiteralDefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getEnumLiteralDefinition()
	 * @generated
	 */
	int ENUM_LITERAL_DEFINITION = 8;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.EnumDefinitionImpl <em>Enum Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.EnumDefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getEnumDefinition()
	 * @generated
	 */
	int ENUM_DEFINITION = 9;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.DataTypeDefinitionImpl <em>Data Type Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.DataTypeDefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getDataTypeDefinition()
	 * @generated
	 */
	int DATA_TYPE_DEFINITION = 10;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.DataTypeTypeDefinitionImpl <em>Data Type Type Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.DataTypeTypeDefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getDataTypeTypeDefinition()
	 * @generated
	 */
	int DATA_TYPE_TYPE_DEFINITION = 11;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.DataDescriptionImpl <em>Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.DataDescriptionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getDataDescription()
	 * @generated
	 */
	int DATA_DESCRIPTION = 12;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.BaseDataDescriptionImpl <em>Base Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.BaseDataDescriptionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getBaseDataDescription()
	 * @generated
	 */
	int BASE_DATA_DESCRIPTION = 13;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.TypedBaseDataDescriptionImpl <em>Typed Base Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.TypedBaseDataDescriptionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getTypedBaseDataDescription()
	 * @generated
	 */
	int TYPED_BASE_DATA_DESCRIPTION = 14;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.UntypedBaseDataDescriptionImpl <em>Untyped Base Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.UntypedBaseDataDescriptionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getUntypedBaseDataDescription()
	 * @generated
	 */
	int UNTYPED_BASE_DATA_DESCRIPTION = 15;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.StructuredDataDescriptionImpl <em>Structured Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.StructuredDataDescriptionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getStructuredDataDescription()
	 * @generated
	 */
	int STRUCTURED_DATA_DESCRIPTION = 16;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.FunctionDefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getFunctionDefinition()
	 * @generated
	 */
	int FUNCTION_DEFINITION = 17;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.ParameterImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 18;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.ConstantDefinitionImpl <em>Constant Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.ConstantDefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getConstantDefinition()
	 * @generated
	 */
	int CONSTANT_DEFINITION = 19;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.FunctionNameImpl <em>Function Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.FunctionNameImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getFunctionName()
	 * @generated
	 */
	int FUNCTION_NAME = 20;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.DefinedFunctionNameImpl <em>Defined Function Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.DefinedFunctionNameImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getDefinedFunctionName()
	 * @generated
	 */
	int DEFINED_FUNCTION_NAME = 21;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.impl.ValueDefinitionImpl <em>Value Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.impl.ValueDefinitionImpl
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getValueDefinition()
	 * @generated
	 */
	int VALUE_DEFINITION = 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_DEFINITION__CONSTRAINTS = DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_DEFINITION__NAME = DEFINITION__NAME;

	/**
	 * The number of structural features of the '<em>Value Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Value Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_DEFINITION_OPERATION_COUNT = DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION__CONSTRAINTS = DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION__NAME = DEFINITION__NAME;

	/**
	 * The number of structural features of the '<em>Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DEFINITION_OPERATION_COUNT = DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DEFINITION__CONSTRAINTS = VALUE_DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DEFINITION__NAME = VALUE_DEFINITION__NAME;

	/**
	 * The number of structural features of the '<em>Literal Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DEFINITION_FEATURE_COUNT = VALUE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Literal Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_DEFINITION_OPERATION_COUNT = VALUE_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALED_DEFINITION__SCALE = 0;

	/**
	 * The number of structural features of the '<em>Scaled Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALED_DEFINITION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Scaled Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCALED_DEFINITION_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DEFINITION__CONSTRAINTS = TYPE_DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DEFINITION__NAME = TYPE_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DEFINITION__ATTRIBUTES = TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DEFINITION__SUPER_TYPE = TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DEFINITION__ABSTRACT = TYPE_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Class Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DEFINITION_FEATURE_COUNT = TYPE_DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Find Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DEFINITION___FIND_ATTRIBUTE__STRING = TYPE_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get All Attributes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DEFINITION___GET_ALL_ATTRIBUTES = TYPE_DEFINITION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Class Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DEFINITION_OPERATION_COUNT = TYPE_DEFINITION_OPERATION_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__CONSTRAINTS = DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__NAME = DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__TYPE = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initialisation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__INITIALISATION = DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION__OPTIONAL = DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Attribute Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_DEFINITION_OPERATION_COUNT = DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_DEFINITION__CONSTRAINTS = LITERAL_DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_DEFINITION__NAME = LITERAL_DEFINITION__NAME;

	/**
	 * The number of structural features of the '<em>Enum Literal Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_DEFINITION_FEATURE_COUNT = LITERAL_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Enum Literal Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_DEFINITION_OPERATION_COUNT = LITERAL_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_DEFINITION__CONSTRAINTS = TYPE_DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_DEFINITION__NAME = TYPE_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_DEFINITION__SCALE = TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_DEFINITION__LITERALS = TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enum Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_DEFINITION_FEATURE_COUNT = TYPE_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Enum Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_DEFINITION_OPERATION_COUNT = TYPE_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__CONSTRAINTS = TYPE_DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__NAME = TYPE_DEFINITION__NAME;

	/**
	 * The number of structural features of the '<em>Data Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION_FEATURE_COUNT = TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION_OPERATION_COUNT = TYPE_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_TYPE_DEFINITION__CONSTRAINTS = DATA_TYPE_DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_TYPE_DEFINITION__NAME = DATA_TYPE_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_TYPE_DEFINITION__SCALE = DATA_TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Type Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_TYPE_DEFINITION_FEATURE_COUNT = DATA_TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Data Type Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_TYPE_DEFINITION_OPERATION_COUNT = DATA_TYPE_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION__CONSTRAINTS = DATA_TYPE_DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION__NAME = DATA_TYPE_DEFINITION__NAME;

	/**
	 * The number of structural features of the '<em>Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_FEATURE_COUNT = DATA_TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_OPERATION_COUNT = DATA_TYPE_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_DESCRIPTION__CONSTRAINTS = DATA_DESCRIPTION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_DESCRIPTION__NAME = DATA_DESCRIPTION__NAME;

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
	 * The operation id for the '<em>Get Scale</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_DESCRIPTION___GET_SCALE = DATA_DESCRIPTION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Base Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_DATA_DESCRIPTION_OPERATION_COUNT = DATA_DESCRIPTION_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_BASE_DATA_DESCRIPTION__CONSTRAINTS = BASE_DATA_DESCRIPTION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_BASE_DATA_DESCRIPTION__NAME = BASE_DATA_DESCRIPTION__NAME;

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
	 * The operation id for the '<em>Get Scale</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_BASE_DATA_DESCRIPTION___GET_SCALE = BASE_DATA_DESCRIPTION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Typed Base Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_BASE_DATA_DESCRIPTION_OPERATION_COUNT = BASE_DATA_DESCRIPTION_OPERATION_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_BASE_DATA_DESCRIPTION__CONSTRAINTS = BASE_DATA_DESCRIPTION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_BASE_DATA_DESCRIPTION__NAME = BASE_DATA_DESCRIPTION__NAME;

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
	 * The operation id for the '<em>Get Scale</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_BASE_DATA_DESCRIPTION___GET_SCALE = BASE_DATA_DESCRIPTION___GET_SCALE;

	/**
	 * The number of operations of the '<em>Untyped Base Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_BASE_DATA_DESCRIPTION_OPERATION_COUNT = BASE_DATA_DESCRIPTION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_DESCRIPTION__CONSTRAINTS = DATA_DESCRIPTION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_DESCRIPTION__NAME = DATA_DESCRIPTION__NAME;

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
	 * The number of operations of the '<em>Structured Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURED_DATA_DESCRIPTION_OPERATION_COUNT = DATA_DESCRIPTION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__CONSTRAINTS = DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__NAME = DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__TYPE = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__PARAMETERS = DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Function Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Function Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION_OPERATION_COUNT = DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__CONSTRAINTS = DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DEFINITION__CONSTRAINTS = LITERAL_DEFINITION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DEFINITION__NAME = LITERAL_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DEFINITION__TYPE = LITERAL_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DEFINITION__VALUE = LITERAL_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constant Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DEFINITION_FEATURE_COUNT = LITERAL_DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Constant Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_DEFINITION_OPERATION_COUNT = LITERAL_DEFINITION_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_NAME_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Function Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_NAME_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_FUNCTION_NAME__DEFINITION = FUNCTION_NAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Defined Function Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_FUNCTION_NAME_FEATURE_COUNT = FUNCTION_NAME_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Defined Function Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINED_FUNCTION_NAME_OPERATION_COUNT = FUNCTION_NAME_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.ScaleType <em>Scale Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.ScaleType
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getScaleType()
	 * @generated
	 */
	int SCALE_TYPE = 22;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.base.definitions.RepresentationType <em>Representation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.base.definitions.RepresentationType
	 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getRepresentationType()
	 * @generated
	 */
	int REPRESENTATION_TYPE = 23;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.Constrained <em>Constrained</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constrained</em>'.
	 * @see de.evoal.languages.model.base.definitions.Constrained
	 * @generated
	 */
	EClass getConstrained();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.definitions.Constrained#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see de.evoal.languages.model.base.definitions.Constrained#getConstraints()
	 * @see #getConstrained()
	 * @generated
	 */
	EReference getConstrained_Constraints();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.Definition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.Definition
	 * @generated
	 */
	EClass getDefinition();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.definitions.Definition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.base.definitions.Definition#getName()
	 * @see #getDefinition()
	 * @generated
	 */
	EAttribute getDefinition_Name();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.TypeDefinition <em>Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.TypeDefinition
	 * @generated
	 */
	EClass getTypeDefinition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.LiteralDefinition <em>Literal Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.LiteralDefinition
	 * @generated
	 */
	EClass getLiteralDefinition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.ScaledDefinition <em>Scaled Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scaled Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.ScaledDefinition
	 * @generated
	 */
	EClass getScaledDefinition();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.definitions.ScaledDefinition#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see de.evoal.languages.model.base.definitions.ScaledDefinition#getScale()
	 * @see #getScaledDefinition()
	 * @generated
	 */
	EAttribute getScaledDefinition_Scale();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.ClassDefinition <em>Class Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.ClassDefinition
	 * @generated
	 */
	EClass getClassDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.definitions.ClassDefinition#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see de.evoal.languages.model.base.definitions.ClassDefinition#getAttributes()
	 * @see #getClassDefinition()
	 * @generated
	 */
	EReference getClassDefinition_Attributes();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.definitions.ClassDefinition#getSuperType <em>Super Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Type</em>'.
	 * @see de.evoal.languages.model.base.definitions.ClassDefinition#getSuperType()
	 * @see #getClassDefinition()
	 * @generated
	 */
	EReference getClassDefinition_SuperType();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.definitions.ClassDefinition#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see de.evoal.languages.model.base.definitions.ClassDefinition#isAbstract()
	 * @see #getClassDefinition()
	 * @generated
	 */
	EAttribute getClassDefinition_Abstract();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.definitions.ClassDefinition#findAttribute(java.lang.String) <em>Find Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Find Attribute</em>' operation.
	 * @see de.evoal.languages.model.base.definitions.ClassDefinition#findAttribute(java.lang.String)
	 * @generated
	 */
	EOperation getClassDefinition__FindAttribute__String();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.definitions.ClassDefinition#getAllAttributes() <em>Get All Attributes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get All Attributes</em>' operation.
	 * @see de.evoal.languages.model.base.definitions.ClassDefinition#getAllAttributes()
	 * @generated
	 */
	EOperation getClassDefinition__GetAllAttributes();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.AttributeDefinition <em>Attribute Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.AttributeDefinition
	 * @generated
	 */
	EClass getAttributeDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.definitions.AttributeDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.base.definitions.AttributeDefinition#getType()
	 * @see #getAttributeDefinition()
	 * @generated
	 */
	EReference getAttributeDefinition_Type();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.definitions.AttributeDefinition#getInitialisation <em>Initialisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialisation</em>'.
	 * @see de.evoal.languages.model.base.definitions.AttributeDefinition#getInitialisation()
	 * @see #getAttributeDefinition()
	 * @generated
	 */
	EReference getAttributeDefinition_Initialisation();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.definitions.AttributeDefinition#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see de.evoal.languages.model.base.definitions.AttributeDefinition#isOptional()
	 * @see #getAttributeDefinition()
	 * @generated
	 */
	EAttribute getAttributeDefinition_Optional();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.EnumLiteralDefinition <em>Enum Literal Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.EnumLiteralDefinition
	 * @generated
	 */
	EClass getEnumLiteralDefinition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.EnumDefinition <em>Enum Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.EnumDefinition
	 * @generated
	 */
	EClass getEnumDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.definitions.EnumDefinition#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see de.evoal.languages.model.base.definitions.EnumDefinition#getLiterals()
	 * @see #getEnumDefinition()
	 * @generated
	 */
	EReference getEnumDefinition_Literals();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.DataTypeDefinition <em>Data Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.DataTypeDefinition
	 * @generated
	 */
	EClass getDataTypeDefinition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.DataTypeTypeDefinition <em>Data Type Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Type Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.DataTypeTypeDefinition
	 * @generated
	 */
	EClass getDataTypeTypeDefinition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.DataDescription <em>Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Description</em>'.
	 * @see de.evoal.languages.model.base.definitions.DataDescription
	 * @generated
	 */
	EClass getDataDescription();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.BaseDataDescription <em>Base Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Data Description</em>'.
	 * @see de.evoal.languages.model.base.definitions.BaseDataDescription
	 * @generated
	 */
	EClass getBaseDataDescription();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.base.definitions.BaseDataDescription#getRepresentation <em>Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Representation</em>'.
	 * @see de.evoal.languages.model.base.definitions.BaseDataDescription#getRepresentation()
	 * @see #getBaseDataDescription()
	 * @generated
	 */
	EAttribute getBaseDataDescription_Representation();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.definitions.BaseDataDescription#getScale() <em>Get Scale</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Scale</em>' operation.
	 * @see de.evoal.languages.model.base.definitions.BaseDataDescription#getScale()
	 * @generated
	 */
	EOperation getBaseDataDescription__GetScale();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.TypedBaseDataDescription <em>Typed Base Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Base Data Description</em>'.
	 * @see de.evoal.languages.model.base.definitions.TypedBaseDataDescription
	 * @generated
	 */
	EClass getTypedBaseDataDescription();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.definitions.TypedBaseDataDescription#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.base.definitions.TypedBaseDataDescription#getType()
	 * @see #getTypedBaseDataDescription()
	 * @generated
	 */
	EReference getTypedBaseDataDescription_Type();

	/**
	 * Returns the meta object for the '{@link de.evoal.languages.model.base.definitions.TypedBaseDataDescription#getScale() <em>Get Scale</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Scale</em>' operation.
	 * @see de.evoal.languages.model.base.definitions.TypedBaseDataDescription#getScale()
	 * @generated
	 */
	EOperation getTypedBaseDataDescription__GetScale();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.UntypedBaseDataDescription <em>Untyped Base Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Untyped Base Data Description</em>'.
	 * @see de.evoal.languages.model.base.definitions.UntypedBaseDataDescription
	 * @generated
	 */
	EClass getUntypedBaseDataDescription();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.StructuredDataDescription <em>Structured Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structured Data Description</em>'.
	 * @see de.evoal.languages.model.base.definitions.StructuredDataDescription
	 * @generated
	 */
	EClass getStructuredDataDescription();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.definitions.StructuredDataDescription#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.base.definitions.StructuredDataDescription#getType()
	 * @see #getStructuredDataDescription()
	 * @generated
	 */
	EReference getStructuredDataDescription_Type();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.FunctionDefinition <em>Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.FunctionDefinition
	 * @generated
	 */
	EClass getFunctionDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.definitions.FunctionDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.base.definitions.FunctionDefinition#getType()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EReference getFunctionDefinition_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.base.definitions.FunctionDefinition#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.evoal.languages.model.base.definitions.FunctionDefinition#getParameters()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EReference getFunctionDefinition_Parameters();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see de.evoal.languages.model.base.definitions.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.definitions.Parameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.base.definitions.Parameter#getType()
	 * @see #getParameter()
	 * @generated
	 */
	EReference getParameter_Type();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.ConstantDefinition <em>Constant Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.ConstantDefinition
	 * @generated
	 */
	EClass getConstantDefinition();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.definitions.ConstantDefinition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.base.definitions.ConstantDefinition#getType()
	 * @see #getConstantDefinition()
	 * @generated
	 */
	EReference getConstantDefinition_Type();

	/**
	 * Returns the meta object for the containment reference '{@link de.evoal.languages.model.base.definitions.ConstantDefinition#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see de.evoal.languages.model.base.definitions.ConstantDefinition#getValue()
	 * @see #getConstantDefinition()
	 * @generated
	 */
	EReference getConstantDefinition_Value();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.FunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Name</em>'.
	 * @see de.evoal.languages.model.base.definitions.FunctionName
	 * @generated
	 */
	EClass getFunctionName();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.DefinedFunctionName <em>Defined Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Defined Function Name</em>'.
	 * @see de.evoal.languages.model.base.definitions.DefinedFunctionName
	 * @generated
	 */
	EClass getDefinedFunctionName();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.base.definitions.DefinedFunctionName#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.DefinedFunctionName#getDefinition()
	 * @see #getDefinedFunctionName()
	 * @generated
	 */
	EReference getDefinedFunctionName_Definition();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.base.definitions.ValueDefinition <em>Value Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Definition</em>'.
	 * @see de.evoal.languages.model.base.definitions.ValueDefinition
	 * @generated
	 */
	EClass getValueDefinition();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.base.definitions.ScaleType <em>Scale Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Scale Type</em>'.
	 * @see de.evoal.languages.model.base.definitions.ScaleType
	 * @generated
	 */
	EEnum getScaleType();

	/**
	 * Returns the meta object for enum '{@link de.evoal.languages.model.base.definitions.RepresentationType <em>Representation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Representation Type</em>'.
	 * @see de.evoal.languages.model.base.definitions.RepresentationType
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
	DefinitionsFactory getDefinitionsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.ConstrainedImpl <em>Constrained</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.ConstrainedImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getConstrained()
		 * @generated
		 */
		EClass CONSTRAINED = eINSTANCE.getConstrained();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINED__CONSTRAINTS = eINSTANCE.getConstrained_Constraints();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.DefinitionImpl <em>Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getDefinition()
		 * @generated
		 */
		EClass DEFINITION = eINSTANCE.getDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINITION__NAME = eINSTANCE.getDefinition_Name();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.TypeDefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getTypeDefinition()
		 * @generated
		 */
		EClass TYPE_DEFINITION = eINSTANCE.getTypeDefinition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.LiteralDefinitionImpl <em>Literal Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.LiteralDefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getLiteralDefinition()
		 * @generated
		 */
		EClass LITERAL_DEFINITION = eINSTANCE.getLiteralDefinition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.ScaledDefinitionImpl <em>Scaled Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.ScaledDefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getScaledDefinition()
		 * @generated
		 */
		EClass SCALED_DEFINITION = eINSTANCE.getScaledDefinition();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCALED_DEFINITION__SCALE = eINSTANCE.getScaledDefinition_Scale();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.ClassDefinitionImpl <em>Class Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.ClassDefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getClassDefinition()
		 * @generated
		 */
		EClass CLASS_DEFINITION = eINSTANCE.getClassDefinition();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DEFINITION__ATTRIBUTES = eINSTANCE.getClassDefinition_Attributes();

		/**
		 * The meta object literal for the '<em><b>Super Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DEFINITION__SUPER_TYPE = eINSTANCE.getClassDefinition_SuperType();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS_DEFINITION__ABSTRACT = eINSTANCE.getClassDefinition_Abstract();

		/**
		 * The meta object literal for the '<em><b>Find Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS_DEFINITION___FIND_ATTRIBUTE__STRING = eINSTANCE.getClassDefinition__FindAttribute__String();

		/**
		 * The meta object literal for the '<em><b>Get All Attributes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CLASS_DEFINITION___GET_ALL_ATTRIBUTES = eINSTANCE.getClassDefinition__GetAllAttributes();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.AttributeDefinitionImpl <em>Attribute Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.AttributeDefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getAttributeDefinition()
		 * @generated
		 */
		EClass ATTRIBUTE_DEFINITION = eINSTANCE.getAttributeDefinition();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_DEFINITION__TYPE = eINSTANCE.getAttributeDefinition_Type();

		/**
		 * The meta object literal for the '<em><b>Initialisation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_DEFINITION__INITIALISATION = eINSTANCE.getAttributeDefinition_Initialisation();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_DEFINITION__OPTIONAL = eINSTANCE.getAttributeDefinition_Optional();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.EnumLiteralDefinitionImpl <em>Enum Literal Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.EnumLiteralDefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getEnumLiteralDefinition()
		 * @generated
		 */
		EClass ENUM_LITERAL_DEFINITION = eINSTANCE.getEnumLiteralDefinition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.EnumDefinitionImpl <em>Enum Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.EnumDefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getEnumDefinition()
		 * @generated
		 */
		EClass ENUM_DEFINITION = eINSTANCE.getEnumDefinition();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_DEFINITION__LITERALS = eINSTANCE.getEnumDefinition_Literals();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.DataTypeDefinitionImpl <em>Data Type Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.DataTypeDefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getDataTypeDefinition()
		 * @generated
		 */
		EClass DATA_TYPE_DEFINITION = eINSTANCE.getDataTypeDefinition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.DataTypeTypeDefinitionImpl <em>Data Type Type Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.DataTypeTypeDefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getDataTypeTypeDefinition()
		 * @generated
		 */
		EClass DATA_TYPE_TYPE_DEFINITION = eINSTANCE.getDataTypeTypeDefinition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.DataDescriptionImpl <em>Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.DataDescriptionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getDataDescription()
		 * @generated
		 */
		EClass DATA_DESCRIPTION = eINSTANCE.getDataDescription();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.BaseDataDescriptionImpl <em>Base Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.BaseDataDescriptionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getBaseDataDescription()
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
		 * The meta object literal for the '<em><b>Get Scale</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BASE_DATA_DESCRIPTION___GET_SCALE = eINSTANCE.getBaseDataDescription__GetScale();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.TypedBaseDataDescriptionImpl <em>Typed Base Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.TypedBaseDataDescriptionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getTypedBaseDataDescription()
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
		 * The meta object literal for the '<em><b>Get Scale</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TYPED_BASE_DATA_DESCRIPTION___GET_SCALE = eINSTANCE.getTypedBaseDataDescription__GetScale();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.UntypedBaseDataDescriptionImpl <em>Untyped Base Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.UntypedBaseDataDescriptionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getUntypedBaseDataDescription()
		 * @generated
		 */
		EClass UNTYPED_BASE_DATA_DESCRIPTION = eINSTANCE.getUntypedBaseDataDescription();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.StructuredDataDescriptionImpl <em>Structured Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.StructuredDataDescriptionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getStructuredDataDescription()
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
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.FunctionDefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getFunctionDefinition()
		 * @generated
		 */
		EClass FUNCTION_DEFINITION = eINSTANCE.getFunctionDefinition();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DEFINITION__TYPE = eINSTANCE.getFunctionDefinition_Type();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DEFINITION__PARAMETERS = eINSTANCE.getFunctionDefinition_Parameters();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.ParameterImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER__TYPE = eINSTANCE.getParameter_Type();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.ConstantDefinitionImpl <em>Constant Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.ConstantDefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getConstantDefinition()
		 * @generated
		 */
		EClass CONSTANT_DEFINITION = eINSTANCE.getConstantDefinition();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_DEFINITION__TYPE = eINSTANCE.getConstantDefinition_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTANT_DEFINITION__VALUE = eINSTANCE.getConstantDefinition_Value();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.FunctionNameImpl <em>Function Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.FunctionNameImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getFunctionName()
		 * @generated
		 */
		EClass FUNCTION_NAME = eINSTANCE.getFunctionName();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.DefinedFunctionNameImpl <em>Defined Function Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.DefinedFunctionNameImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getDefinedFunctionName()
		 * @generated
		 */
		EClass DEFINED_FUNCTION_NAME = eINSTANCE.getDefinedFunctionName();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEFINED_FUNCTION_NAME__DEFINITION = eINSTANCE.getDefinedFunctionName_Definition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.impl.ValueDefinitionImpl <em>Value Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.impl.ValueDefinitionImpl
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getValueDefinition()
		 * @generated
		 */
		EClass VALUE_DEFINITION = eINSTANCE.getValueDefinition();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.ScaleType <em>Scale Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.ScaleType
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getScaleType()
		 * @generated
		 */
		EEnum SCALE_TYPE = eINSTANCE.getScaleType();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.base.definitions.RepresentationType <em>Representation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.base.definitions.RepresentationType
		 * @see de.evoal.languages.model.base.definitions.impl.DefinitionsPackageImpl#getRepresentationType()
		 * @generated
		 */
		EEnum REPRESENTATION_TYPE = eINSTANCE.getRepresentationType();

	}

} //DefinitionsPackage
