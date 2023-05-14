/**
 */
package de.evoal.languages.model.ddl.impl;

import de.evoal.languages.model.base.impl.ValueReferenceImpl;

import de.evoal.languages.model.ddl.DdlPackage;
import de.evoal.languages.model.ddl.SelfReference;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Self Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SelfReferenceImpl extends ValueReferenceImpl implements SelfReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelfReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DdlPackage.Literals.SELF_REFERENCE;
	}

} //SelfReferenceImpl
