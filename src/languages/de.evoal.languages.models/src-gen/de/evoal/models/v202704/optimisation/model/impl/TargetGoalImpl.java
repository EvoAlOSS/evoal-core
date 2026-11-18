/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.model.impl;

import de.evoal.models.v202704.core.Configuration;
import de.evoal.models.v202704.optimisation.model.Direction;
import de.evoal.models.v202704.optimisation.model.ModelPackage;
import de.evoal.models.v202704.optimisation.model.TargetGoal;

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
 *   <li>{@link de.evoal.models.v202704.optimisation.model.impl.TargetGoalImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.impl.TargetGoalImpl#isFromEvaluation <em>From Evaluation</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.impl.TargetGoalImpl#getDistance <em>Distance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TargetGoalImpl extends OptimisationGoalImpl implements TargetGoal {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected Object value = VALUE_EDEFAULT;

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
	protected Configuration distance;

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
		return ModelPackage.Literals.TARGET_GOAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(Object newValue) {
		Object oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TARGET_GOAL__VALUE, oldValue, value));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TARGET_GOAL__FROM_EVALUATION, oldFromEvaluation, fromEvaluation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Configuration getDistance() {
		return distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDistance(Configuration newDistance, NotificationChain msgs) {
		Configuration oldDistance = distance;
		distance = newDistance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.TARGET_GOAL__DISTANCE, oldDistance, newDistance);
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
	public void setDistance(Configuration newDistance) {
		if (newDistance != distance) {
			NotificationChain msgs = null;
			if (distance != null)
				msgs = ((InternalEObject)distance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.TARGET_GOAL__DISTANCE, null, msgs);
			if (newDistance != null)
				msgs = ((InternalEObject)newDistance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.TARGET_GOAL__DISTANCE, null, msgs);
			msgs = basicSetDistance(newDistance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TARGET_GOAL__DISTANCE, newDistance, newDistance));
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
			case ModelPackage.TARGET_GOAL__DISTANCE:
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
			case ModelPackage.TARGET_GOAL__VALUE:
				return getValue();
			case ModelPackage.TARGET_GOAL__FROM_EVALUATION:
				return isFromEvaluation();
			case ModelPackage.TARGET_GOAL__DISTANCE:
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
			case ModelPackage.TARGET_GOAL__VALUE:
				setValue(newValue);
				return;
			case ModelPackage.TARGET_GOAL__FROM_EVALUATION:
				setFromEvaluation((Boolean)newValue);
				return;
			case ModelPackage.TARGET_GOAL__DISTANCE:
				setDistance((Configuration)newValue);
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
			case ModelPackage.TARGET_GOAL__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case ModelPackage.TARGET_GOAL__FROM_EVALUATION:
				setFromEvaluation(FROM_EVALUATION_EDEFAULT);
				return;
			case ModelPackage.TARGET_GOAL__DISTANCE:
				setDistance((Configuration)null);
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
			case ModelPackage.TARGET_GOAL__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case ModelPackage.TARGET_GOAL__FROM_EVALUATION:
				return fromEvaluation != FROM_EVALUATION_EDEFAULT;
			case ModelPackage.TARGET_GOAL__DISTANCE:
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
		result.append(" (value: ");
		result.append(value);
		result.append(", fromEvaluation: ");
		result.append(fromEvaluation);
		result.append(')');
		return result.toString();
	}

} //TargetGoalImpl
