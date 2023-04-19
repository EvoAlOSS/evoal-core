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
	 * Returns a new object of class '<em>Data Description Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Description Model</em>'.
	 * @generated
	 */
	DataDescriptionModel createDataDescriptionModel();

	/**
	 * Returns a new object of class '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import</em>'.
	 * @generated
	 */
	Import createImport();

	/**
	 * Returns a new object of class '<em>Data Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Definition</em>'.
	 * @generated
	 */
	DataTypeDefinition createDataTypeDefinition();

	/**
	 * Returns a new object of class '<em>Typed Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Data Description</em>'.
	 * @generated
	 */
	TypedDataDescription createTypedDataDescription();

	/**
	 * Returns a new object of class '<em>Untyped Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Untyped Data Description</em>'.
	 * @generated
	 */
	UntypedDataDescription createUntypedDataDescription();

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
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DdlPackage getDdlPackage();

} //DdlFactory
