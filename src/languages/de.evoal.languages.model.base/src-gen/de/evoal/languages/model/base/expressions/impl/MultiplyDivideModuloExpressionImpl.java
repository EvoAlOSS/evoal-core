/**
 */
package de.evoal.languages.model.base.expressions.impl;

import de.evoal.languages.model.base.expressions.ExpressionsPackage;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloExpression;
import de.evoal.languages.model.base.expressions.MultiplyDivideModuloOperator;
import de.evoal.languages.model.base.expressions.PowerOfExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multiply Divide Modulo Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.expressions.impl.MultiplyDivideModuloExpressionImpl#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.expressions.impl.MultiplyDivideModuloExpressionImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.expressions.impl.MultiplyDivideModuloExpressionImpl#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiplyDivideModuloExpressionImpl extends ExpressionImpl implements MultiplyDivideModuloExpression {
	/**
	 * The cached value of the '{@link #getLeftOperand() <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftOperand()
	 * @generated
	 * @ordered
	 */
	protected PowerOfExpression leftOperand;

	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<MultiplyDivideModuloOperator> operators;

	/**
	 * The cached value of the '{@link #getOperands() <em>Operands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperands()
	 * @generated
	 * @ordered
	 */
	protected EList<PowerOfExpression> operands;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiplyDivideModuloExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.MULTIPLY_DIVIDE_MODULO_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PowerOfExpression getLeftOperand() {
		return leftOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftOperand(PowerOfExpression newLeftOperand, NotificationChain msgs) {
		PowerOfExpression oldLeftOperand = leftOperand;
		leftOperand = newLeftOperand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND, oldLeftOperand, newLeftOperand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLeftOperand(PowerOfExpression newLeftOperand) {
		if (newLeftOperand != leftOperand) {
			NotificationChain msgs = null;
			if (leftOperand != null)
				msgs = ((InternalEObject)leftOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND, null, msgs);
			if (newLeftOperand != null)
				msgs = ((InternalEObject)newLeftOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND, null, msgs);
			msgs = basicSetLeftOperand(newLeftOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND, newLeftOperand, newLeftOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MultiplyDivideModuloOperator> getOperators() {
		if (operators == null) {
			operators = new EDataTypeUniqueEList<MultiplyDivideModuloOperator>(MultiplyDivideModuloOperator.class, this, ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERATORS);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PowerOfExpression> getOperands() {
		if (operands == null) {
			operands = new EObjectContainmentEList<PowerOfExpression>(PowerOfExpression.class, this, ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERANDS);
		}
		return operands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND:
				return basicSetLeftOperand(null, msgs);
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERANDS:
				return ((InternalEList<?>)getOperands()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND:
				return getLeftOperand();
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERATORS:
				return getOperators();
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERANDS:
				return getOperands();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND:
				setLeftOperand((PowerOfExpression)newValue);
				return;
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends MultiplyDivideModuloOperator>)newValue);
				return;
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERANDS:
				getOperands().clear();
				getOperands().addAll((Collection<? extends PowerOfExpression>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND:
				setLeftOperand((PowerOfExpression)null);
				return;
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERATORS:
				getOperators().clear();
				return;
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERANDS:
				getOperands().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__LEFT_OPERAND:
				return leftOperand != null;
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERATORS:
				return operators != null && !operators.isEmpty();
			case ExpressionsPackage.MULTIPLY_DIVIDE_MODULO_EXPRESSION__OPERANDS:
				return operands != null && !operands.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (operators: ");
		result.append(operators);
		result.append(')');
		return result.toString();
	}

} //MultiplyDivideModuloExpressionImpl
