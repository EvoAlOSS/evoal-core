/**
 */
package de.evoal.languages.model.base.definitions;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage
 * @generated
 */
public interface DefinitionsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DefinitionsFactory eINSTANCE = de.evoal.languages.model.base.definitions.impl.DefinitionsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Class Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Definition</em>'.
	 * @generated
	 */
	ClassDefinition createClassDefinition();

	/**
	 * Returns a new object of class '<em>Attribute Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Definition</em>'.
	 * @generated
	 */
	AttributeDefinition createAttributeDefinition();

	/**
	 * Returns a new object of class '<em>Enum Literal Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal Definition</em>'.
	 * @generated
	 */
	EnumLiteralDefinition createEnumLiteralDefinition();

	/**
	 * Returns a new object of class '<em>Enum Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Definition</em>'.
	 * @generated
	 */
	EnumDefinition createEnumDefinition();

	/**
	 * Returns a new object of class '<em>Data Type Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Type Definition</em>'.
	 * @generated
	 */
	DataTypeTypeDefinition createDataTypeTypeDefinition();

	/**
	 * Returns a new object of class '<em>Typed Base Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Typed Base Data Description</em>'.
	 * @generated
	 */
	TypedBaseDataDescription createTypedBaseDataDescription();

	/**
	 * Returns a new object of class '<em>Untyped Base Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Untyped Base Data Description</em>'.
	 * @generated
	 */
	UntypedBaseDataDescription createUntypedBaseDataDescription();

	/**
	 * Returns a new object of class '<em>Structured Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structured Data Description</em>'.
	 * @generated
	 */
	StructuredDataDescription createStructuredDataDescription();

	/**
	 * Returns a new object of class '<em>Function Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Definition</em>'.
	 * @generated
	 */
	FunctionDefinition createFunctionDefinition();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Constant Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constant Definition</em>'.
	 * @generated
	 */
	ConstantDefinition createConstantDefinition();

	/**
	 * Returns a new object of class '<em>Function Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Name</em>'.
	 * @generated
	 */
	FunctionName createFunctionName();

	/**
	 * Returns a new object of class '<em>Defined Function Name</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Defined Function Name</em>'.
	 * @generated
	 */
	DefinedFunctionName createDefinedFunctionName();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DefinitionsPackage getDefinitionsPackage();

} //DefinitionsFactory
