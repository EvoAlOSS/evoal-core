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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODULE__IMPORTS = 1;

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
	 * The number of structural features of the '<em>Data Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.DataDescriptionImpl <em>Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.DataDescriptionImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataDescription()
	 * @generated
	 */
	int DATA_DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION__CONSTRAINTS = 1;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION__REPRESENTATION = 2;

	/**
	 * The number of structural features of the '<em>Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.TypedDataDescriptionImpl <em>Typed Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.TypedDataDescriptionImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getTypedDataDescription()
	 * @generated
	 */
	int TYPED_DATA_DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_DATA_DESCRIPTION__NAME = DATA_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_DATA_DESCRIPTION__CONSTRAINTS = DATA_DESCRIPTION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_DATA_DESCRIPTION__REPRESENTATION = DATA_DESCRIPTION__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_DATA_DESCRIPTION__TYPE = DATA_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_DATA_DESCRIPTION_FEATURE_COUNT = DATA_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.UntypedDataDescriptionImpl <em>Untyped Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.UntypedDataDescriptionImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getUntypedDataDescription()
	 * @generated
	 */
	int UNTYPED_DATA_DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_DATA_DESCRIPTION__NAME = DATA_DESCRIPTION__NAME;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_DATA_DESCRIPTION__CONSTRAINTS = DATA_DESCRIPTION__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Representation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_DATA_DESCRIPTION__REPRESENTATION = DATA_DESCRIPTION__REPRESENTATION;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_DATA_DESCRIPTION__SCALE = DATA_DESCRIPTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Untyped Data Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNTYPED_DATA_DESCRIPTION_FEATURE_COUNT = DATA_DESCRIPTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.DataReferenceImpl <em>Data Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.DataReferenceImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataReference()
	 * @generated
	 */
	int DATA_REFERENCE = 5;

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
	int SELF_REFERENCE = 6;

	/**
	 * The number of structural features of the '<em>Self Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_REFERENCE_FEATURE_COUNT = BasePackage.VALUE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.ScaleType <em>Scale Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.ScaleType
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getScaleType()
	 * @generated
	 */
	int SCALE_TYPE = 7;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.RepresentationType <em>Representation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.RepresentationType
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getRepresentationType()
	 * @generated
	 */
	int REPRESENTATION_TYPE = 8;


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
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.DataDescription <em>Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Description</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescription
	 * @generated
	 */
	EClass getDataDescription();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.DataDescription#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescription#getName()
	 * @see #getDataDescription()
	 * @generated
	 */
	EAttribute getDataDescription_Name();

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
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.DataDescription#getRepresentation <em>Representation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Representation</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescription#getRepresentation()
	 * @see #getDataDescription()
	 * @generated
	 */
	EAttribute getDataDescription_Representation();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.TypedDataDescription <em>Typed Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Data Description</em>'.
	 * @see de.evoal.languages.model.ddl.TypedDataDescription
	 * @generated
	 */
	EClass getTypedDataDescription();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.ddl.TypedDataDescription#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see de.evoal.languages.model.ddl.TypedDataDescription#getType()
	 * @see #getTypedDataDescription()
	 * @generated
	 */
	EReference getTypedDataDescription_Type();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.UntypedDataDescription <em>Untyped Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Untyped Data Description</em>'.
	 * @see de.evoal.languages.model.ddl.UntypedDataDescription
	 * @generated
	 */
	EClass getUntypedDataDescription();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.UntypedDataDescription#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see de.evoal.languages.model.ddl.UntypedDataDescription#getScale()
	 * @see #getUntypedDataDescription()
	 * @generated
	 */
	EAttribute getUntypedDataDescription_Scale();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.DataDescriptionImpl <em>Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.DataDescriptionImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataDescription()
		 * @generated
		 */
		EClass DATA_DESCRIPTION = eINSTANCE.getDataDescription();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_DESCRIPTION__NAME = eINSTANCE.getDataDescription_Name();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION__CONSTRAINTS = eINSTANCE.getDataDescription_Constraints();

		/**
		 * The meta object literal for the '<em><b>Representation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_DESCRIPTION__REPRESENTATION = eINSTANCE.getDataDescription_Representation();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.TypedDataDescriptionImpl <em>Typed Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.TypedDataDescriptionImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getTypedDataDescription()
		 * @generated
		 */
		EClass TYPED_DATA_DESCRIPTION = eINSTANCE.getTypedDataDescription();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_DATA_DESCRIPTION__TYPE = eINSTANCE.getTypedDataDescription_Type();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.UntypedDataDescriptionImpl <em>Untyped Data Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.UntypedDataDescriptionImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getUntypedDataDescription()
		 * @generated
		 */
		EClass UNTYPED_DATA_DESCRIPTION = eINSTANCE.getUntypedDataDescription();

		/**
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNTYPED_DATA_DESCRIPTION__SCALE = eINSTANCE.getUntypedDataDescription_Scale();

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
