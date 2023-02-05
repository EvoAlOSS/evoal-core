/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol.impl;

import de.evoal.languages.model.el.Call;

import de.evoal.languages.model.ol.ConstraintStatement;
import de.evoal.languages.model.ol.OLPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constraint Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ol.impl.ConstraintStatementImpl#getConstraintExpression <em>Constraint Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConstraintStatementImpl extends MinimalEObjectImpl.Container implements ConstraintStatement {
	/**
	 * The cached value of the '{@link #getConstraintExpression() <em>Constraint Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraintExpression()
	 * @generated
	 * @ordered
	 */
	protected Call constraintExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstraintStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OLPackage.Literals.CONSTRAINT_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Call getConstraintExpression() {
		return constraintExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraintExpression(Call newConstraintExpression, NotificationChain msgs) {
		Call oldConstraintExpression = constraintExpression;
		constraintExpression = newConstraintExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OLPackage.CONSTRAINT_STATEMENT__CONSTRAINT_EXPRESSION, oldConstraintExpression, newConstraintExpression);
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
	public void setConstraintExpression(Call newConstraintExpression) {
		if (newConstraintExpression != constraintExpression) {
			NotificationChain msgs = null;
			if (constraintExpression != null)
				msgs = ((InternalEObject)constraintExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OLPackage.CONSTRAINT_STATEMENT__CONSTRAINT_EXPRESSION, null, msgs);
			if (newConstraintExpression != null)
				msgs = ((InternalEObject)newConstraintExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OLPackage.CONSTRAINT_STATEMENT__CONSTRAINT_EXPRESSION, null, msgs);
			msgs = basicSetConstraintExpression(newConstraintExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OLPackage.CONSTRAINT_STATEMENT__CONSTRAINT_EXPRESSION, newConstraintExpression, newConstraintExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OLPackage.CONSTRAINT_STATEMENT__CONSTRAINT_EXPRESSION:
				return basicSetConstraintExpression(null, msgs);
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
			case OLPackage.CONSTRAINT_STATEMENT__CONSTRAINT_EXPRESSION:
				return getConstraintExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OLPackage.CONSTRAINT_STATEMENT__CONSTRAINT_EXPRESSION:
				setConstraintExpression((Call)newValue);
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
			case OLPackage.CONSTRAINT_STATEMENT__CONSTRAINT_EXPRESSION:
				setConstraintExpression((Call)null);
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
			case OLPackage.CONSTRAINT_STATEMENT__CONSTRAINT_EXPRESSION:
				return constraintExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ConstraintStatementImpl
