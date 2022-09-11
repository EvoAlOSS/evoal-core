/**
 */
package de.evoal.languages.model.el.impl;

import de.evoal.languages.model.el.ELPackage;
import de.evoal.languages.model.el.Expression;
import de.evoal.languages.model.el.Parantheses;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parantheses</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.el.impl.ParanthesesImpl#getSubExpression <em>Sub Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParanthesesImpl extends CallOrLiteralOrReferenceOrParanthesesImpl implements Parantheses {
	/**
	 * The cached value of the '{@link #getSubExpression() <em>Sub Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression subExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParanthesesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ELPackage.Literals.PARANTHESES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getSubExpression() {
		return subExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSubExpression(Expression newSubExpression, NotificationChain msgs) {
		Expression oldSubExpression = subExpression;
		subExpression = newSubExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ELPackage.PARANTHESES__SUB_EXPRESSION, oldSubExpression, newSubExpression);
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
	public void setSubExpression(Expression newSubExpression) {
		if (newSubExpression != subExpression) {
			NotificationChain msgs = null;
			if (subExpression != null)
				msgs = ((InternalEObject)subExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ELPackage.PARANTHESES__SUB_EXPRESSION, null, msgs);
			if (newSubExpression != null)
				msgs = ((InternalEObject)newSubExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ELPackage.PARANTHESES__SUB_EXPRESSION, null, msgs);
			msgs = basicSetSubExpression(newSubExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ELPackage.PARANTHESES__SUB_EXPRESSION, newSubExpression, newSubExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ELPackage.PARANTHESES__SUB_EXPRESSION:
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
			case ELPackage.PARANTHESES__SUB_EXPRESSION:
				return getSubExpression();
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
			case ELPackage.PARANTHESES__SUB_EXPRESSION:
				setSubExpression((Expression)newValue);
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
			case ELPackage.PARANTHESES__SUB_EXPRESSION:
				setSubExpression((Expression)null);
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
			case ELPackage.PARANTHESES__SUB_EXPRESSION:
				return subExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //ParanthesesImpl
