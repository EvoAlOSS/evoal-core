/**
 */
package de.evoal.languages.model.ddl.util;

import de.evoal.languages.model.base.Definition;
import de.evoal.languages.model.base.Literal;
import de.evoal.languages.model.base.Type;
import de.evoal.languages.model.base.Value;
import de.evoal.languages.model.base.ValueReference;

import de.evoal.languages.model.ddl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.evoal.languages.model.ddl.DdlPackage
 * @generated
 */
public class DdlAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DdlPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DdlAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DdlPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DdlSwitch<Adapter> modelSwitch =
		new DdlSwitch<Adapter>() {
			@Override
			public Adapter caseDataDescriptionModule(DataDescriptionModule object) {
				return createDataDescriptionModuleAdapter();
			}
			@Override
			public Adapter caseDataTypeDefinition(DataTypeDefinition object) {
				return createDataTypeDefinitionAdapter();
			}
			@Override
			public Adapter caseBaseDataTypeDefinition(BaseDataTypeDefinition object) {
				return createBaseDataTypeDefinitionAdapter();
			}
			@Override
			public Adapter caseEnumLiteral(EnumLiteral object) {
				return createEnumLiteralAdapter();
			}
			@Override
			public Adapter caseEnumTypeDefinition(EnumTypeDefinition object) {
				return createEnumTypeDefinitionAdapter();
			}
			@Override
			public Adapter caseDataDescription(DataDescription object) {
				return createDataDescriptionAdapter();
			}
			@Override
			public Adapter caseBaseDataDescription(BaseDataDescription object) {
				return createBaseDataDescriptionAdapter();
			}
			@Override
			public Adapter caseTypedBaseDataDescription(TypedBaseDataDescription object) {
				return createTypedBaseDataDescriptionAdapter();
			}
			@Override
			public Adapter caseUntypedBaseDataDescription(UntypedBaseDataDescription object) {
				return createUntypedBaseDataDescriptionAdapter();
			}
			@Override
			public Adapter caseStructuredDataDescription(StructuredDataDescription object) {
				return createStructuredDataDescriptionAdapter();
			}
			@Override
			public Adapter caseDataReference(DataReference object) {
				return createDataReferenceAdapter();
			}
			@Override
			public Adapter caseSelfReference(SelfReference object) {
				return createSelfReferenceAdapter();
			}
			@Override
			public Adapter caseDataType(DataType object) {
				return createDataTypeAdapter();
			}
			@Override
			public Adapter caseEnumLiteralReference(EnumLiteralReference object) {
				return createEnumLiteralReferenceAdapter();
			}
			@Override
			public Adapter caseDefinition(Definition object) {
				return createDefinitionAdapter();
			}
			@Override
			public Adapter caseValue(Value object) {
				return createValueAdapter();
			}
			@Override
			public Adapter caseValueReference(ValueReference object) {
				return createValueReferenceAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseLiteral(Literal object) {
				return createLiteralAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.DataDescriptionModule <em>Data Description Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.DataDescriptionModule
	 * @generated
	 */
	public Adapter createDataDescriptionModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.DataTypeDefinition <em>Data Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.DataTypeDefinition
	 * @generated
	 */
	public Adapter createDataTypeDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.BaseDataTypeDefinition <em>Base Data Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.BaseDataTypeDefinition
	 * @generated
	 */
	public Adapter createBaseDataTypeDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.EnumLiteral <em>Enum Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.EnumLiteral
	 * @generated
	 */
	public Adapter createEnumLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.EnumTypeDefinition <em>Enum Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.EnumTypeDefinition
	 * @generated
	 */
	public Adapter createEnumTypeDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.DataDescription <em>Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.DataDescription
	 * @generated
	 */
	public Adapter createDataDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.BaseDataDescription <em>Base Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.BaseDataDescription
	 * @generated
	 */
	public Adapter createBaseDataDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.TypedBaseDataDescription <em>Typed Base Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.TypedBaseDataDescription
	 * @generated
	 */
	public Adapter createTypedBaseDataDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.StructuredDataDescription <em>Structured Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.StructuredDataDescription
	 * @generated
	 */
	public Adapter createStructuredDataDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.UntypedBaseDataDescription <em>Untyped Base Data Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.UntypedBaseDataDescription
	 * @generated
	 */
	public Adapter createUntypedBaseDataDescriptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.DataReference <em>Data Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.DataReference
	 * @generated
	 */
	public Adapter createDataReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.SelfReference <em>Self Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.SelfReference
	 * @generated
	 */
	public Adapter createSelfReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.ddl.EnumLiteralReference <em>Enum Literal Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.ddl.EnumLiteralReference
	 * @generated
	 */
	public Adapter createEnumLiteralReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.base.Definition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.base.Definition
	 * @generated
	 */
	public Adapter createDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.base.Value <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.base.Value
	 * @generated
	 */
	public Adapter createValueAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.base.ValueReference <em>Value Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.base.ValueReference
	 * @generated
	 */
	public Adapter createValueReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.base.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.base.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.evoal.languages.model.base.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.evoal.languages.model.base.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DdlAdapterFactory
