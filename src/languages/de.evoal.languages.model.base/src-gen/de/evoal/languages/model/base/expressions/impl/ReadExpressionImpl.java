/**
 */
package de.evoal.languages.model.base.expressions.impl;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.base.expressions.ReadExpression;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Read Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ReadExpressionImpl extends ExpressionImpl implements ReadExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReadExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.READ_EXPRESSION;
	}

} //ReadExpressionImpl
