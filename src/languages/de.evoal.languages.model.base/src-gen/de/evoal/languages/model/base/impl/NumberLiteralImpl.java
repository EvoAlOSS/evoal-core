/**
 */
package de.evoal.languages.model.base.impl;

import de.evoal.languages.model.base.BasePackage;
import de.evoal.languages.model.base.Factor;
import de.evoal.languages.model.base.NumberLiteral;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Number Literal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.base.impl.NumberLiteralImpl#getFactor <em>Factor</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class NumberLiteralImpl extends LiteralImpl implements NumberLiteral {
	/**
	 * The default value of the '{@link #getFactor() <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactor()
	 * @generated
	 * @ordered
	 */
	protected static final Factor FACTOR_EDEFAULT = Factor.NONE;

	/**
	 * The cached value of the '{@link #getFactor() <em>Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactor()
	 * @generated
	 * @ordered
	 */
	protected Factor factor = FACTOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumberLiteralImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BasePackage.Literals.NUMBER_LITERAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Factor getFactor() {
		return factor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFactor(Factor newFactor) {
		Factor oldFactor = factor;
		factor = newFactor == null ? FACTOR_EDEFAULT : newFactor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BasePackage.NUMBER_LITERAL__FACTOR, oldFactor, factor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BasePackage.NUMBER_LITERAL__FACTOR:
				return getFactor();
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
			case BasePackage.NUMBER_LITERAL__FACTOR:
				setFactor((Factor)newValue);
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
			case BasePackage.NUMBER_LITERAL__FACTOR:
				setFactor(FACTOR_EDEFAULT);
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
			case BasePackage.NUMBER_LITERAL__FACTOR:
				return factor != FACTOR_EDEFAULT;
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
		result.append(" (factor: ");
		result.append(factor);
		result.append(')');
		return result.toString();
	}

} //NumberLiteralImpl
