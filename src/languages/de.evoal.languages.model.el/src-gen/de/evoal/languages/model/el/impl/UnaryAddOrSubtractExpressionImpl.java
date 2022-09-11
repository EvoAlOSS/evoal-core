/**
 */
package de.evoal.languages.model.el.impl;

import de.evoal.languages.model.el.AddOrSubtractOperator;
import de.evoal.languages.model.el.CallOrLiteralOrReferenceOrParantheses;
import de.evoal.languages.model.el.ELPackage;
import de.evoal.languages.model.el.UnaryAddOrSubtractExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unary Add Or Subtract Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.el.impl.UnaryAddOrSubtractExpressionImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link de.evoal.languages.model.el.impl.UnaryAddOrSubtractExpressionImpl#getSubExpression <em>Sub Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnaryAddOrSubtractExpressionImpl extends MinimalEObjectImpl.Container implements UnaryAddOrSubtractExpression {
	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<AddOrSubtractOperator> operators;

	/**
	 * The cached value of the '{@link #getSubExpression() <em>Sub Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubExpression()
	 * @generated
	 * @ordered
	 */
	protected CallOrLiteralOrReferenceOrParantheses subExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnaryAddOrSubtractExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ELPackage.Literals.UNARY_ADD_OR_SUBTRACT_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AddOrSubtractOperator> getOperators() {
		if (operators == null) {
			operators = new EDataTypeUniqueEList<AddOrSubtractOperator>(AddOrSubtractOperator.class, this, ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__OPERATORS);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CallOrLiteralOrReferenceOrParantheses getSubExpression() {
		return subExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubExpression(CallOrLiteralOrReferenceOrParantheses newSubExpression, NotificationChain msgs) {
		CallOrLiteralOrReferenceOrParantheses oldSubExpression = subExpression;
		subExpression = newSubExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION, oldSubExpression, newSubExpression);
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
	public void setSubExpression(CallOrLiteralOrReferenceOrParantheses newSubExpression) {
		if (newSubExpression != subExpression) {
			NotificationChain msgs = null;
			if (subExpression != null)
				msgs = ((InternalEObject)subExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION, null, msgs);
			if (newSubExpression != null)
				msgs = ((InternalEObject)newSubExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION, null, msgs);
			msgs = basicSetSubExpression(newSubExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION, newSubExpression, newSubExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION:
				return basicSetSubExpression(null, msgs);
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
			case ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__OPERATORS:
				return getOperators();
			case ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION:
				return getSubExpression();
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
			case ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends AddOrSubtractOperator>)newValue);
				return;
			case ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION:
				setSubExpression((CallOrLiteralOrReferenceOrParantheses)newValue);
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
			case ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__OPERATORS:
				getOperators().clear();
				return;
			case ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION:
				setSubExpression((CallOrLiteralOrReferenceOrParantheses)null);
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
			case ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__OPERATORS:
				return operators != null && !operators.isEmpty();
			case ELPackage.UNARY_ADD_OR_SUBTRACT_EXPRESSION__SUB_EXPRESSION:
				return subExpression != null;
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

} //UnaryAddOrSubtractExpressionImpl
