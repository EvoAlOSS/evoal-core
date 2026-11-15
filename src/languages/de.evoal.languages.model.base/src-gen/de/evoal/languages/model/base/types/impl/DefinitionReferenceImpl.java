/**
 */
package de.evoal.languages.model.base.types.impl;

import de.evoal.languages.model.base.definitions.TypeDefinition;
import de.evoal.languages.model.base.types.DefinitionReference;
import de.evoal.languages.model.base.types.TypesPackage;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definition Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class DefinitionReferenceImpl extends TypeImpl implements DefinitionReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DefinitionReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.DEFINITION_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeDefinition getDefinition() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TypesPackage.DEFINITION_REFERENCE___GET_DEFINITION:
				return getDefinition();
		}
		return super.eInvoke(operationID, arguments);
	}

} //DefinitionReferenceImpl
