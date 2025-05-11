/**
 * EvoAl project
 */
package de.evoal.languages.model.execution.impl;

import de.evoal.languages.model.execution.CallStatement;
import de.evoal.languages.model.execution.ExecutionPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class CallStatementImpl extends StatementImpl implements CallStatement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.CALL_STATEMENT;
	}

} //CallStatementImpl
