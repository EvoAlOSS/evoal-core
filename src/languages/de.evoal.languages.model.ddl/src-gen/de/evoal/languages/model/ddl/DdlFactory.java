/**
 */
package de.evoal.languages.model.ddl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.ddl.DdlPackage
 * @generated
 */
public interface DdlFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DdlFactory eINSTANCE = de.evoal.languages.model.ddl.impl.DdlFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Data Description Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Description Module</em>'.
	 * @generated
	 */
	DataDescriptionModule createDataDescriptionModule();

	/**
	 * Returns a new object of class '<em>Base Data Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Base Data Type Definition</em>'.
	 * @generated
	 */
	BaseDataTypeDefinition createBaseDataTypeDefinition();

	/**
	 * Returns a new object of class '<em>Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal</em>'.
	 * @generated
	 */
	EnumLiteral createEnumLiteral();

	/**
	 * Returns a new object of class '<em>Enum Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Type Definition</em>'.
	 * @generated
	 */
	EnumTypeDefinition createEnumTypeDefinition();

	/**
	 * Returns a new object of class '<em>Typed Base Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Base Data Description</em>'.
	 * @generated
	 */
	TypedBaseDataDescription createTypedBaseDataDescription();

	/**
	 * Returns a new object of class '<em>Structured Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Data Description</em>'.
	 * @generated
	 */
	StructuredDataDescription createStructuredDataDescription();

	/**
	 * Returns a new object of class '<em>Untyped Base Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Untyped Base Data Description</em>'.
	 * @generated
	 */
	UntypedBaseDataDescription createUntypedBaseDataDescription();

	/**
	 * Returns a new object of class '<em>Data Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Reference</em>'.
	 * @generated
	 */
	DataReference createDataReference();

	/**
	 * Returns a new object of class '<em>Self Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Self Reference</em>'.
	 * @generated
	 */
	SelfReference createSelfReference();

	/**
	 * Returns a new object of class '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type</em>'.
	 * @generated
	 */
	DataType createDataType();

	/**
	 * Returns a new object of class '<em>Enum Literal Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal Reference</em>'.
	 * @generated
	 */
	EnumLiteralReference createEnumLiteralReference();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DdlPackage getDdlPackage();

} //DdlFactory
