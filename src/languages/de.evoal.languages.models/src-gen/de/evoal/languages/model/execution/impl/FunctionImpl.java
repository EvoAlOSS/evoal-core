/**
 * EvoAl project
 */
package de.evoal.languages.model.execution.impl;

import de.evoal.languages.model.execution.ExecutionPackage;
import de.evoal.languages.model.execution.Function;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class FunctionImpl extends MinimalEObjectImpl.Container implements Function {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.FUNCTION;
	}

} //FunctionImpl
