/**
 */
package de.evoal.languages.model.ddl;

import de.evoal.languages.model.el.ELPackage;
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
 *        annotation="http://www.eclipse.org/OCL/Import dl='platform:/resource/de.evoal.languages.model.dl/model/model.ecore#/' ecore='http://www.eclipse.org/emf/2002/Ecore' el='platform:/resource/de.evoal.languages.model.el/model/model.ecore#/'"
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
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.DataDescriptionModelImpl <em>Data Description Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.DataDescriptionModelImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataDescriptionModel()
	 * @generated
	 */
	int DATA_DESCRIPTION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Uses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODEL__USES = 0;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODEL__TYPES = 1;

	/**
	 * The feature id for the '<em><b>Descriptions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODEL__DESCRIPTIONS = 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODEL__CONSTRAINTS = 3;

	/**
	 * The number of structural features of the '<em>Data Description Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DESCRIPTION_MODEL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.UseImpl <em>Use</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.UseImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getUse()
	 * @generated
	 */
	int USE = 1;

	/**
	 * The feature id for the '<em><b>Import URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE__IMPORT_URI = 0;

	/**
	 * The number of structural features of the '<em>Use</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.DataTypeImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__SCALE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__CONSTRAINTS = 3;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.DataDescriptionImpl <em>Data Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.DataDescriptionImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataDescription()
	 * @generated
	 */
	int DATA_DESCRIPTION = 3;

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
	int TYPED_DATA_DESCRIPTION = 4;

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
	int UNTYPED_DATA_DESCRIPTION = 5;

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
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.FunctionNameImpl <em>Function Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.FunctionNameImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getFunctionName()
	 * @generated
	 */
	int FUNCTION_NAME = 6;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_NAME__DEFINITION = ELPackage.FUNCTION_NAME_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_NAME_FEATURE_COUNT = ELPackage.FUNCTION_NAME_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.DataReferenceImpl <em>Data Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.DataReferenceImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataReference()
	 * @generated
	 */
	int DATA_REFERENCE = 7;

	/**
	 * The feature id for the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_REFERENCE__DEFINITION = ELPackage.VALUE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_REFERENCE_FEATURE_COUNT = ELPackage.VALUE_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.impl.SelfReferenceImpl <em>Self Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.impl.SelfReferenceImpl
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getSelfReference()
	 * @generated
	 */
	int SELF_REFERENCE = 8;

	/**
	 * The number of structural features of the '<em>Self Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELF_REFERENCE_FEATURE_COUNT = ELPackage.VALUE_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.ScaleType <em>Scale Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.ScaleType
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getScaleType()
	 * @generated
	 */
	int SCALE_TYPE = 9;


	/**
	 * The meta object id for the '{@link de.evoal.languages.model.ddl.RepresentationType <em>Representation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.evoal.languages.model.ddl.RepresentationType
	 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getRepresentationType()
	 * @generated
	 */
	int REPRESENTATION_TYPE = 10;


	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.DataDescriptionModel <em>Data Description Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Description Model</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModel
	 * @generated
	 */
	EClass getDataDescriptionModel();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescriptionModel#getUses <em>Uses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Uses</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModel#getUses()
	 * @see #getDataDescriptionModel()
	 * @generated
	 */
	EReference getDataDescriptionModel_Uses();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescriptionModel#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModel#getTypes()
	 * @see #getDataDescriptionModel()
	 * @generated
	 */
	EReference getDataDescriptionModel_Types();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescriptionModel#getDescriptions <em>Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Descriptions</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModel#getDescriptions()
	 * @see #getDataDescriptionModel()
	 * @generated
	 */
	EReference getDataDescriptionModel_Descriptions();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataDescriptionModel#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModel#getConstraints()
	 * @see #getDataDescriptionModel()
	 * @generated
	 */
	EReference getDataDescriptionModel_Constraints();

	/**
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.Use <em>Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use</em>'.
	 * @see de.evoal.languages.model.ddl.Use
	 * @generated
	 */
	EClass getUse();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.Use#getImportURI <em>Import URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Import URI</em>'.
	 * @see de.evoal.languages.model.ddl.Use#getImportURI()
	 * @see #getUse()
	 * @generated
	 */
	EAttribute getUse_ImportURI();

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
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.DataType#getScale <em>Scale</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scale</em>'.
	 * @see de.evoal.languages.model.ddl.DataType#getScale()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Scale();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.DataType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.evoal.languages.model.ddl.DataType#getName()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.evoal.languages.model.ddl.DataType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.evoal.languages.model.ddl.DataType#getDescription()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Description();

	/**
	 * Returns the meta object for the containment reference list '{@link de.evoal.languages.model.ddl.DataType#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see de.evoal.languages.model.ddl.DataType#getConstraints()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_Constraints();

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
	 * Returns the meta object for class '{@link de.evoal.languages.model.ddl.FunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Name</em>'.
	 * @see de.evoal.languages.model.ddl.FunctionName
	 * @generated
	 */
	EClass getFunctionName();

	/**
	 * Returns the meta object for the reference '{@link de.evoal.languages.model.ddl.FunctionName#getDefinition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Definition</em>'.
	 * @see de.evoal.languages.model.ddl.FunctionName#getDefinition()
	 * @see #getFunctionName()
	 * @generated
	 */
	EReference getFunctionName_Definition();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.DataDescriptionModelImpl <em>Data Description Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.DataDescriptionModelImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getDataDescriptionModel()
		 * @generated
		 */
		EClass DATA_DESCRIPTION_MODEL = eINSTANCE.getDataDescriptionModel();

		/**
		 * The meta object literal for the '<em><b>Uses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION_MODEL__USES = eINSTANCE.getDataDescriptionModel_Uses();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION_MODEL__TYPES = eINSTANCE.getDataDescriptionModel_Types();

		/**
		 * The meta object literal for the '<em><b>Descriptions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION_MODEL__DESCRIPTIONS = eINSTANCE.getDataDescriptionModel_Descriptions();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_DESCRIPTION_MODEL__CONSTRAINTS = eINSTANCE.getDataDescriptionModel_Constraints();

		/**
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.UseImpl <em>Use</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.UseImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getUse()
		 * @generated
		 */
		EClass USE = eINSTANCE.getUse();

		/**
		 * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE__IMPORT_URI = eINSTANCE.getUse_ImportURI();

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
		 * The meta object literal for the '<em><b>Scale</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__SCALE = eINSTANCE.getDataType_Scale();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__NAME = eINSTANCE.getDataType_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__DESCRIPTION = eINSTANCE.getDataType_Description();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__CONSTRAINTS = eINSTANCE.getDataType_Constraints();

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
		 * The meta object literal for the '{@link de.evoal.languages.model.ddl.impl.FunctionNameImpl <em>Function Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.evoal.languages.model.ddl.impl.FunctionNameImpl
		 * @see de.evoal.languages.model.ddl.impl.DdlPackageImpl#getFunctionName()
		 * @generated
		 */
		EClass FUNCTION_NAME = eINSTANCE.getFunctionName();

		/**
		 * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_NAME__DEFINITION = eINSTANCE.getFunctionName_Definition();

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
