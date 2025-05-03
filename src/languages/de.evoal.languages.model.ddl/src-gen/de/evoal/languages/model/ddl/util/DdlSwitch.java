/**
 */
package de.evoal.languages.model.ddl.util;

import de.evoal.languages.model.base.Definition;
import de.evoal.languages.model.base.Literal;
import de.evoal.languages.model.base.Type;
import de.evoal.languages.model.base.Value;
import de.evoal.languages.model.base.ValueReference;

import de.evoal.languages.model.ddl.*;

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
 * @see de.evoal.languages.model.ddl.DdlPackage
 * @generated
 */
public class DdlSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DdlPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DdlSwitch() {
		if (modelPackage == null) {
			modelPackage = DdlPackage.eINSTANCE;
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
			case DdlPackage.DATA_DESCRIPTION_MODULE: {
				DataDescriptionModule dataDescriptionModule = (DataDescriptionModule)theEObject;
				T result = caseDataDescriptionModule(dataDescriptionModule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.DATA_TYPE_DEFINITION: {
				DataTypeDefinition dataTypeDefinition = (DataTypeDefinition)theEObject;
				T result = caseDataTypeDefinition(dataTypeDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.BASE_DATA_TYPE_DEFINITION: {
				BaseDataTypeDefinition baseDataTypeDefinition = (BaseDataTypeDefinition)theEObject;
				T result = caseBaseDataTypeDefinition(baseDataTypeDefinition);
				if (result == null) result = caseDataTypeDefinition(baseDataTypeDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.ENUM_LITERAL: {
				EnumLiteral enumLiteral = (EnumLiteral)theEObject;
				T result = caseEnumLiteral(enumLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.ENUM_TYPE_DEFINITION: {
				EnumTypeDefinition enumTypeDefinition = (EnumTypeDefinition)theEObject;
				T result = caseEnumTypeDefinition(enumTypeDefinition);
				if (result == null) result = caseDataTypeDefinition(enumTypeDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.DATA_DESCRIPTION: {
				DataDescription dataDescription = (DataDescription)theEObject;
				T result = caseDataDescription(dataDescription);
				if (result == null) result = caseDefinition(dataDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.BASE_DATA_DESCRIPTION: {
				BaseDataDescription baseDataDescription = (BaseDataDescription)theEObject;
				T result = caseBaseDataDescription(baseDataDescription);
				if (result == null) result = caseDataDescription(baseDataDescription);
				if (result == null) result = caseDefinition(baseDataDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.TYPED_BASE_DATA_DESCRIPTION: {
				TypedBaseDataDescription typedBaseDataDescription = (TypedBaseDataDescription)theEObject;
				T result = caseTypedBaseDataDescription(typedBaseDataDescription);
				if (result == null) result = caseBaseDataDescription(typedBaseDataDescription);
				if (result == null) result = caseDataDescription(typedBaseDataDescription);
				if (result == null) result = caseDefinition(typedBaseDataDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.UNTYPED_BASE_DATA_DESCRIPTION: {
				UntypedBaseDataDescription untypedBaseDataDescription = (UntypedBaseDataDescription)theEObject;
				T result = caseUntypedBaseDataDescription(untypedBaseDataDescription);
				if (result == null) result = caseBaseDataDescription(untypedBaseDataDescription);
				if (result == null) result = caseDataDescription(untypedBaseDataDescription);
				if (result == null) result = caseDefinition(untypedBaseDataDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.STRUCTURED_DATA_DESCRIPTION: {
				StructuredDataDescription structuredDataDescription = (StructuredDataDescription)theEObject;
				T result = caseStructuredDataDescription(structuredDataDescription);
				if (result == null) result = caseDataDescription(structuredDataDescription);
				if (result == null) result = caseDefinition(structuredDataDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.DATA_REFERENCE: {
				DataReference dataReference = (DataReference)theEObject;
				T result = caseDataReference(dataReference);
				if (result == null) result = caseValueReference(dataReference);
				if (result == null) result = caseValue(dataReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.SELF_REFERENCE: {
				SelfReference selfReference = (SelfReference)theEObject;
				T result = caseSelfReference(selfReference);
				if (result == null) result = caseValueReference(selfReference);
				if (result == null) result = caseValue(selfReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.DATA_TYPE: {
				DataType dataType = (DataType)theEObject;
				T result = caseDataType(dataType);
				if (result == null) result = caseType(dataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DdlPackage.ENUM_LITERAL_REFERENCE: {
				EnumLiteralReference enumLiteralReference = (EnumLiteralReference)theEObject;
				T result = caseEnumLiteralReference(enumLiteralReference);
				if (result == null) result = caseLiteral(enumLiteralReference);
				if (result == null) result = caseValue(enumLiteralReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Description Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Description Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataDescriptionModule(DataDescriptionModule object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Base Data Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Data Type Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseDataTypeDefinition(BaseDataTypeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteral(EnumLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Type Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumTypeDefinition(EnumTypeDefinition object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Data Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataReference(DataReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Self Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Self Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelfReference(SelfReference object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteralReference(EnumLiteralReference object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValue(Value object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueReference(ValueReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteral(Literal object) {
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

} //DdlSwitch
