/**
 */
package de.evoal.languages.model.base.impl;

import de.evoal.languages.model.base.AddOrSubtractExpression;
import de.evoal.languages.model.base.BasePackage;
import de.evoal.languages.model.base.ComparisonExpression;
import de.evoal.languages.model.base.PartialComparisonExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Comparison Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.impl.ComparisonExpressionImpl#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link de.evoal.languages.model.base.impl.ComparisonExpressionImpl#getComparison <em>Comparison</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComparisonExpressionImpl extends MinimalEObjectImpl.Container implements ComparisonExpression {
	/**
	 * The cached value of the '{@link #getLeftOperand() <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftOperand()
	 * @generated
	 * @ordered
	 */
	protected AddOrSubtractExpression leftOperand;

	/**
	 * The cached value of the '{@link #getComparison() <em>Comparison</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComparison()
	 * @generated
	 * @ordered
	 */
	protected EList<PartialComparisonExpression> comparison;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComparisonExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.COMPARISON_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AddOrSubtractExpression getLeftOperand() {
		return leftOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftOperand(AddOrSubtractExpression newLeftOperand, NotificationChain msgs) {
		AddOrSubtractExpression oldLeftOperand = leftOperand;
		leftOperand = newLeftOperand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BasePackage.COMPARISON_EXPRESSION__LEFT_OPERAND, oldLeftOperand, newLeftOperand);
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
	public void setLeftOperand(AddOrSubtractExpression newLeftOperand) {
		if (newLeftOperand != leftOperand) {
			NotificationChain msgs = null;
			if (leftOperand != null)
				msgs = ((InternalEObject)leftOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BasePackage.COMPARISON_EXPRESSION__LEFT_OPERAND, null, msgs);
			if (newLeftOperand != null)
				msgs = ((InternalEObject)newLeftOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BasePackage.COMPARISON_EXPRESSION__LEFT_OPERAND, null, msgs);
			msgs = basicSetLeftOperand(newLeftOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.COMPARISON_EXPRESSION__LEFT_OPERAND, newLeftOperand, newLeftOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PartialComparisonExpression> getComparison() {
		if (comparison == null) {
			comparison = new EObjectContainmentEList<PartialComparisonExpression>(PartialComparisonExpression.class, this, BasePackage.COMPARISON_EXPRESSION__COMPARISON);
		}
		return comparison;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BasePackage.COMPARISON_EXPRESSION__LEFT_OPERAND:
				return basicSetLeftOperand(null, msgs);
			case BasePackage.COMPARISON_EXPRESSION__COMPARISON:
				return ((InternalEList<?>)getComparison()).basicRemove(otherEnd, msgs);
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
			case BasePackage.COMPARISON_EXPRESSION__LEFT_OPERAND:
				return getLeftOperand();
			case BasePackage.COMPARISON_EXPRESSION__COMPARISON:
				return getComparison();
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
			case BasePackage.COMPARISON_EXPRESSION__LEFT_OPERAND:
				setLeftOperand((AddOrSubtractExpression)newValue);
				return;
			case BasePackage.COMPARISON_EXPRESSION__COMPARISON:
				getComparison().clear();
				getComparison().addAll((Collection<? extends PartialComparisonExpression>)newValue);
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
			case BasePackage.COMPARISON_EXPRESSION__LEFT_OPERAND:
				setLeftOperand((AddOrSubtractExpression)null);
				return;
			case BasePackage.COMPARISON_EXPRESSION__COMPARISON:
				getComparison().clear();
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
			case BasePackage.COMPARISON_EXPRESSION__LEFT_OPERAND:
				return leftOperand != null;
			case BasePackage.COMPARISON_EXPRESSION__COMPARISON:
				return comparison != null && !comparison.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComparisonExpressionImpl
