/**
 * EvoAl project
 */
package de.evoal.languages.model.execution.impl;

import de.evoal.languages.model.base.expressions.Literal;

import de.evoal.languages.model.base.expressions.ReadExpression;
import de.evoal.languages.model.execution.CounterRange;
import de.evoal.languages.model.execution.ExecutionPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Counter Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.execution.impl.CounterRangeImpl#getStart <em>Start</em>}</li>
 *   <li>{@link de.evoal.languages.model.execution.impl.CounterRangeImpl#getEnd <em>End</em>}</li>
 *   <li>{@link de.evoal.languages.model.execution.impl.CounterRangeImpl#getIncrement <em>Increment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CounterRangeImpl extends RangeImpl implements CounterRange {
	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected ReadExpression start;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected ReadExpression end;

	/**
	 * The cached value of the '{@link #getIncrement() <em>Increment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncrement()
	 * @generated
	 * @ordered
	 */
	protected ReadExpression increment;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CounterRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.COUNTER_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReadExpression getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStart(ReadExpression newStart, NotificationChain msgs) {
		ReadExpression oldStart = start;
		start = newStart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionPackage.COUNTER_RANGE__START, oldStart, newStart);
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
	public void setStart(ReadExpression newStart) {
		if (newStart != start) {
			NotificationChain msgs = null;
			if (start != null)
				msgs = ((InternalEObject)start).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionPackage.COUNTER_RANGE__START, null, msgs);
			if (newStart != null)
				msgs = ((InternalEObject)newStart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExecutionPackage.COUNTER_RANGE__START, null, msgs);
			msgs = basicSetStart(newStart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.COUNTER_RANGE__START, newStart, newStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReadExpression getEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEnd(ReadExpression newEnd, NotificationChain msgs) {
		ReadExpression oldEnd = end;
		end = newEnd;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionPackage.COUNTER_RANGE__END, oldEnd, newEnd);
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
	public void setEnd(ReadExpression newEnd) {
		if (newEnd != end) {
			NotificationChain msgs = null;
			if (end != null)
				msgs = ((InternalEObject)end).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionPackage.COUNTER_RANGE__END, null, msgs);
			if (newEnd != null)
				msgs = ((InternalEObject)newEnd).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExecutionPackage.COUNTER_RANGE__END, null, msgs);
			msgs = basicSetEnd(newEnd, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.COUNTER_RANGE__END, newEnd, newEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReadExpression getIncrement() {
		return increment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncrement(ReadExpression newIncrement, NotificationChain msgs) {
		ReadExpression oldIncrement = increment;
		increment = newIncrement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionPackage.COUNTER_RANGE__INCREMENT, oldIncrement, newIncrement);
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
	public void setIncrement(ReadExpression newIncrement) {
		if (newIncrement != increment) {
			NotificationChain msgs = null;
			if (increment != null)
				msgs = ((InternalEObject)increment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionPackage.COUNTER_RANGE__INCREMENT, null, msgs);
			if (newIncrement != null)
				msgs = ((InternalEObject)newIncrement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExecutionPackage.COUNTER_RANGE__INCREMENT, null, msgs);
			msgs = basicSetIncrement(newIncrement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.COUNTER_RANGE__INCREMENT, newIncrement, newIncrement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionPackage.COUNTER_RANGE__START:
				return basicSetStart(null, msgs);
			case ExecutionPackage.COUNTER_RANGE__END:
				return basicSetEnd(null, msgs);
			case ExecutionPackage.COUNTER_RANGE__INCREMENT:
				return basicSetIncrement(null, msgs);
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
			case ExecutionPackage.COUNTER_RANGE__START:
				return getStart();
			case ExecutionPackage.COUNTER_RANGE__END:
				return getEnd();
			case ExecutionPackage.COUNTER_RANGE__INCREMENT:
				return getIncrement();
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
			case ExecutionPackage.COUNTER_RANGE__START:
				setStart((ReadExpression)newValue);
				return;
			case ExecutionPackage.COUNTER_RANGE__END:
				setEnd((ReadExpression)newValue);
				return;
			case ExecutionPackage.COUNTER_RANGE__INCREMENT:
				setIncrement((ReadExpression)newValue);
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
			case ExecutionPackage.COUNTER_RANGE__START:
				setStart((ReadExpression)null);
				return;
			case ExecutionPackage.COUNTER_RANGE__END:
				setEnd((ReadExpression)null);
				return;
			case ExecutionPackage.COUNTER_RANGE__INCREMENT:
				setIncrement((ReadExpression)null);
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
			case ExecutionPackage.COUNTER_RANGE__START:
				return start != null;
			case ExecutionPackage.COUNTER_RANGE__END:
				return end != null;
			case ExecutionPackage.COUNTER_RANGE__INCREMENT:
				return increment != null;
		}
		return super.eIsSet(featureID);
	}

} //CounterRangeImpl
