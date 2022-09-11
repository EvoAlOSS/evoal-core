/**
 */
package de.evoal.languages.model.el.impl;

import de.evoal.languages.model.el.AndExpression;
import de.evoal.languages.model.el.ELPackage;
import de.evoal.languages.model.el.NotExpression;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>And Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.el.impl.AndExpressionImpl#getSubExpressions <em>Sub Expressions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AndExpressionImpl extends MinimalEObjectImpl.Container implements AndExpression {
	/**
	 * The cached value of the '{@link #getSubExpressions() <em>Sub Expressions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubExpressions()
	 * @generated
	 * @ordered
	 */
	protected EList<NotExpression> subExpressions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AndExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ELPackage.Literals.AND_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NotExpression> getSubExpressions() {
		if (subExpressions == null) {
			subExpressions = new EObjectContainmentEList<NotExpression>(NotExpression.class, this, ELPackage.AND_EXPRESSION__SUB_EXPRESSIONS);
		}
		return subExpressions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ELPackage.AND_EXPRESSION__SUB_EXPRESSIONS:
				return ((InternalEList<?>)getSubExpressions()).basicRemove(otherEnd, msgs);
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
			case ELPackage.AND_EXPRESSION__SUB_EXPRESSIONS:
				return getSubExpressions();
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
			case ELPackage.AND_EXPRESSION__SUB_EXPRESSIONS:
				getSubExpressions().clear();
				getSubExpressions().addAll((Collection<? extends NotExpression>)newValue);
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
			case ELPackage.AND_EXPRESSION__SUB_EXPRESSIONS:
				getSubExpressions().clear();
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
			case ELPackage.AND_EXPRESSION__SUB_EXPRESSIONS:
				return subExpressions != null && !subExpressions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AndExpressionImpl
