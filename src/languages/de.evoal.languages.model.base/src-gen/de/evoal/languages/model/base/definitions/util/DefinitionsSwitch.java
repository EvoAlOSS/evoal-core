/**
 */
package de.evoal.languages.model.base.definitions.util;

import de.evoal.languages.model.base.definitions.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.base.definitions.DefinitionsPackage
 * @generated
 */
public class DefinitionsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DefinitionsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefinitionsSwitch() {
		if (modelPackage == null) {
			modelPackage = DefinitionsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DefinitionsPackage.CONSTRAINED: {
				Constrained constrained = (Constrained)theEObject;
				T result = caseConstrained(constrained);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.DEFINITION: {
				Definition definition = (Definition)theEObject;
				T result = caseDefinition(definition);
				if (result == null) result = caseConstrained(definition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.SCALED_DEFINITION: {
				ScaledDefinition scaledDefinition = (ScaledDefinition)theEObject;
				T result = caseScaledDefinition(scaledDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.TYPE_DEFINITION: {
				TypeDefinition typeDefinition = (TypeDefinition)theEObject;
				T result = caseTypeDefinition(typeDefinition);
				if (result == null) result = caseDefinition(typeDefinition);
				if (result == null) result = caseConstrained(typeDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.ATTRIBUTE_DEFINITION: {
				AttributeDefinition attributeDefinition = (AttributeDefinition)theEObject;
				T result = caseAttributeDefinition(attributeDefinition);
				if (result == null) result = caseDefinition(attributeDefinition);
				if (result == null) result = caseConstrained(attributeDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.ENUM_LITERAL_DEFINITION: {
				EnumLiteralDefinition enumLiteralDefinition = (EnumLiteralDefinition)theEObject;
				T result = caseEnumLiteralDefinition(enumLiteralDefinition);
				if (result == null) result = caseDefinition(enumLiteralDefinition);
				if (result == null) result = caseConstrained(enumLiteralDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.ENUM_DEFINITION: {
				EnumDefinition enumDefinition = (EnumDefinition)theEObject;
				T result = caseEnumDefinition(enumDefinition);
				if (result == null) result = caseDefinition(enumDefinition);
				if (result == null) result = caseScaledDefinition(enumDefinition);
				if (result == null) result = caseConstrained(enumDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.DATA_TYPE_DEFINITION: {
				DataTypeDefinition dataTypeDefinition = (DataTypeDefinition)theEObject;
				T result = caseDataTypeDefinition(dataTypeDefinition);
				if (result == null) result = caseDefinition(dataTypeDefinition);
				if (result == null) result = caseConstrained(dataTypeDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.DATA_TYPE_TYPE_DEFINITION: {
				DataTypeTypeDefinition dataTypeTypeDefinition = (DataTypeTypeDefinition)theEObject;
				T result = caseDataTypeTypeDefinition(dataTypeTypeDefinition);
				if (result == null) result = caseDataTypeDefinition(dataTypeTypeDefinition);
				if (result == null) result = caseScaledDefinition(dataTypeTypeDefinition);
				if (result == null) result = caseDefinition(dataTypeTypeDefinition);
				if (result == null) result = caseConstrained(dataTypeTypeDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.DATA_DESCRIPTION: {
				DataDescription dataDescription = (DataDescription)theEObject;
				T result = caseDataDescription(dataDescription);
				if (result == null) result = caseDataTypeDefinition(dataDescription);
				if (result == null) result = caseDefinition(dataDescription);
				if (result == null) result = caseConstrained(dataDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.BASE_DATA_DESCRIPTION: {
				BaseDataDescription baseDataDescription = (BaseDataDescription)theEObject;
				T result = caseBaseDataDescription(baseDataDescription);
				if (result == null) result = caseDataDescription(baseDataDescription);
				if (result == null) result = caseDataTypeDefinition(baseDataDescription);
				if (result == null) result = caseDefinition(baseDataDescription);
				if (result == null) result = caseConstrained(baseDataDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.TYPED_BASE_DATA_DESCRIPTION: {
				TypedBaseDataDescription typedBaseDataDescription = (TypedBaseDataDescription)theEObject;
				T result = caseTypedBaseDataDescription(typedBaseDataDescription);
				if (result == null) result = caseBaseDataDescription(typedBaseDataDescription);
				if (result == null) result = caseDataDescription(typedBaseDataDescription);
				if (result == null) result = caseDataTypeDefinition(typedBaseDataDescription);
				if (result == null) result = caseDefinition(typedBaseDataDescription);
				if (result == null) result = caseConstrained(typedBaseDataDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.UNTYPED_BASE_DATA_DESCRIPTION: {
				UntypedBaseDataDescription untypedBaseDataDescription = (UntypedBaseDataDescription)theEObject;
				T result = caseUntypedBaseDataDescription(untypedBaseDataDescription);
				if (result == null) result = caseBaseDataDescription(untypedBaseDataDescription);
				if (result == null) result = caseScaledDefinition(untypedBaseDataDescription);
				if (result == null) result = caseDataDescription(untypedBaseDataDescription);
				if (result == null) result = caseDataTypeDefinition(untypedBaseDataDescription);
				if (result == null) result = caseDefinition(untypedBaseDataDescription);
				if (result == null) result = caseConstrained(untypedBaseDataDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.STRUCTURED_DATA_DESCRIPTION: {
				StructuredDataDescription structuredDataDescription = (StructuredDataDescription)theEObject;
				T result = caseStructuredDataDescription(structuredDataDescription);
				if (result == null) result = caseDataDescription(structuredDataDescription);
				if (result == null) result = caseDataTypeDefinition(structuredDataDescription);
				if (result == null) result = caseDefinition(structuredDataDescription);
				if (result == null) result = caseConstrained(structuredDataDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.DATA_TYPE: {
				DataType dataType = (DataType)theEObject;
				T result = caseDataType(dataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.FUNCTION_DEFINITION: {
				FunctionDefinition functionDefinition = (FunctionDefinition)theEObject;
				T result = caseFunctionDefinition(functionDefinition);
				if (result == null) result = caseDefinition(functionDefinition);
				if (result == null) result = caseConstrained(functionDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseDefinition(parameter);
				if (result == null) result = caseConstrained(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.CONSTANT_DEFINITION: {
				ConstantDefinition constantDefinition = (ConstantDefinition)theEObject;
				T result = caseConstantDefinition(constantDefinition);
				if (result == null) result = caseDefinition(constantDefinition);
				if (result == null) result = caseConstrained(constantDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.FUNCTION_NAME: {
				FunctionName functionName = (FunctionName)theEObject;
				T result = caseFunctionName(functionName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DefinitionsPackage.DEFINED_FUNCTION_NAME: {
				DefinedFunctionName definedFunctionName = (DefinedFunctionName)theEObject;
				T result = caseDefinedFunctionName(definedFunctionName);
				if (result == null) result = caseFunctionName(definedFunctionName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constrained</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constrained</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstrained(Constrained object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinition(Definition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scaled Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scaled Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScaledDefinition(ScaledDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeDefinition(TypeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeDefinition(AttributeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteralDefinition(EnumLiteralDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumDefinition(EnumDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeDefinition(DataTypeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Type Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeTypeDefinition(DataTypeTypeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataDescription(DataDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Data Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseDataDescription(BaseDataDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Base Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Base Data Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedBaseDataDescription(TypedBaseDataDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Untyped Base Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Untyped Base Data Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUntypedBaseDataDescription(UntypedBaseDataDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structured Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structured Data Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuredDataDescription(StructuredDataDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionDefinition(FunctionDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstantDefinition(ConstantDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionName(FunctionName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Defined Function Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Defined Function Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinedFunctionName(DefinedFunctionName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DefinitionsSwitch
