/**
 */
package de.evoal.languages.model.base.expressions.impl;

import de.evoal.languages.model.base.expressions.ConstantExpression;
import de.evoal.languages.model.base.expressions.ExpressionsPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ConstantExpressionImpl extends ReadExpressionImpl implements ConstantExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstantExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.CONSTANT_EXPRESSION;
	}

} //ConstantExpressionImpl
