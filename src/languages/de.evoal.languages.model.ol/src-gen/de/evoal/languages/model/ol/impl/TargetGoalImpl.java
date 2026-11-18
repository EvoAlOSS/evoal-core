/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol.impl;

import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.Literal;

import de.evoal.languages.model.ol.Direction;
import de.evoal.languages.model.ol.OLPackage;
import de.evoal.languages.model.ol.TargetGoal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Target Goal</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ol.impl.TargetGoalImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.impl.TargetGoalImpl#isFromEvaluation <em>From Evaluation</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.impl.TargetGoalImpl#getDistance <em>Distance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetGoalImpl extends OptimisationGoalImpl implements TargetGoal {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Literal value;

	/**
	 * The default value of the '{@link #isFromEvaluation() <em>From Evaluation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFromEvaluation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FROM_EVALUATION_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isFromEvaluation() <em>From Evaluation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFromEvaluation()
	 * @generated
	 * @ordered
	 */
	protected boolean fromEvaluation = FROM_EVALUATION_EDEFAULT;
	/**
	 * The cached value of the '{@link #getDistance() <em>Distance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistance()
	 * @generated
	 * @ordered
	 */
	protected Instance distance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TargetGoalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OLPackage.Literals.TARGET_GOAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Literal getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(Literal newValue, NotificationChain msgs) {
		Literal oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OLPackage.TARGET_GOAL__VALUE, oldValue, newValue);
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
	public void setValue(Literal newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OLPackage.TARGET_GOAL__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OLPackage.TARGET_GOAL__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OLPackage.TARGET_GOAL__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFromEvaluation() {
		return fromEvaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFromEvaluation(boolean newFromEvaluation) {
		boolean oldFromEvaluation = fromEvaluation;
		fromEvaluation = newFromEvaluation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OLPackage.TARGET_GOAL__FROM_EVALUATION, oldFromEvaluation, fromEvaluation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Instance getDistance() {
		return distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDistance(Instance newDistance, NotificationChain msgs) {
		Instance oldDistance = distance;
		distance = newDistance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OLPackage.TARGET_GOAL__DISTANCE, oldDistance, newDistance);
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
	public void setDistance(Instance newDistance) {
		if (newDistance != distance) {
			NotificationChain msgs = null;
			if (distance != null)
				msgs = ((InternalEObject)distance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OLPackage.TARGET_GOAL__DISTANCE, null, msgs);
			if (newDistance != null)
				msgs = ((InternalEObject)newDistance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OLPackage.TARGET_GOAL__DISTANCE, null, msgs);
			msgs = basicSetDistance(newDistance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OLPackage.TARGET_GOAL__DISTANCE, newDistance, newDistance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Direction getDirection() {
		return Direction.TARGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OLPackage.TARGET_GOAL__VALUE:
				return basicSetValue(null, msgs);
			case OLPackage.TARGET_GOAL__DISTANCE:
				return basicSetDistance(null, msgs);
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
			case OLPackage.TARGET_GOAL__VALUE:
				return getValue();
			case OLPackage.TARGET_GOAL__FROM_EVALUATION:
				return isFromEvaluation();
			case OLPackage.TARGET_GOAL__DISTANCE:
				return getDistance();
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
			case OLPackage.TARGET_GOAL__VALUE:
				setValue((Literal)newValue);
				return;
			case OLPackage.TARGET_GOAL__FROM_EVALUATION:
				setFromEvaluation((Boolean)newValue);
				return;
			case OLPackage.TARGET_GOAL__DISTANCE:
				setDistance((Instance)newValue);
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
			case OLPackage.TARGET_GOAL__VALUE:
				setValue((Literal)null);
				return;
			case OLPackage.TARGET_GOAL__FROM_EVALUATION:
				setFromEvaluation(FROM_EVALUATION_EDEFAULT);
				return;
			case OLPackage.TARGET_GOAL__DISTANCE:
				setDistance((Instance)null);
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
			case OLPackage.TARGET_GOAL__VALUE:
				return value != null;
			case OLPackage.TARGET_GOAL__FROM_EVALUATION:
				return fromEvaluation != FROM_EVALUATION_EDEFAULT;
			case OLPackage.TARGET_GOAL__DISTANCE:
				return distance != null;
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
		result.append(" (fromEvaluation: ");
		result.append(fromEvaluation);
		result.append(')');
		return result.toString();
	}

} //TargetGoalImpl
