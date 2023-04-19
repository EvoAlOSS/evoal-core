/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol.impl;

import de.evoal.languages.model.instance.Array;
import de.evoal.languages.model.instance.Instance;

import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.OLPackage;
import de.evoal.languages.model.ol.Problem;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Algorithm Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ol.impl.AlgorithmInstanceImpl#getProblem <em>Problem</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.impl.AlgorithmInstanceImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.impl.AlgorithmInstanceImpl#getDocumentation <em>Documentation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AlgorithmInstanceImpl extends MinimalEObjectImpl.Container implements AlgorithmInstance {
	/**
	 * The cached value of the '{@link #getProblem() <em>Problem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblem()
	 * @generated
	 * @ordered
	 */
	protected Problem problem;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected de.evoal.languages.model.base.Instance algorithm;

	/**
	 * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected de.evoal.languages.model.base.Array documentation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlgorithmInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OLPackage.Literals.ALGORITHM_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Problem getProblem() {
		if (problem != null && problem.eIsProxy()) {
			InternalEObject oldProblem = (InternalEObject)problem;
			problem = (Problem)eResolveProxy(oldProblem);
			if (problem != oldProblem) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OLPackage.ALGORITHM_INSTANCE__PROBLEM, oldProblem, problem));
			}
		}
		return problem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Problem basicGetProblem() {
		return problem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProblem(Problem newProblem) {
		Problem oldProblem = problem;
		problem = newProblem;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OLPackage.ALGORITHM_INSTANCE__PROBLEM, oldProblem, problem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public de.evoal.languages.model.base.Instance getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlgorithm(de.evoal.languages.model.base.Instance newAlgorithm, NotificationChain msgs) {
		de.evoal.languages.model.base.Instance oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OLPackage.ALGORITHM_INSTANCE__ALGORITHM, oldAlgorithm, newAlgorithm);
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
	public void setAlgorithm(de.evoal.languages.model.base.Instance newAlgorithm) {
		if (newAlgorithm != algorithm) {
			NotificationChain msgs = null;
			if (algorithm != null)
				msgs = ((InternalEObject)algorithm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OLPackage.ALGORITHM_INSTANCE__ALGORITHM, null, msgs);
			if (newAlgorithm != null)
				msgs = ((InternalEObject)newAlgorithm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OLPackage.ALGORITHM_INSTANCE__ALGORITHM, null, msgs);
			msgs = basicSetAlgorithm(newAlgorithm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OLPackage.ALGORITHM_INSTANCE__ALGORITHM, newAlgorithm, newAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public de.evoal.languages.model.base.Array getDocumentation() {
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDocumentation(de.evoal.languages.model.base.Array newDocumentation, NotificationChain msgs) {
		de.evoal.languages.model.base.Array oldDocumentation = documentation;
		documentation = newDocumentation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OLPackage.ALGORITHM_INSTANCE__DOCUMENTATION, oldDocumentation, newDocumentation);
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
	public void setDocumentation(de.evoal.languages.model.base.Array newDocumentation) {
		if (newDocumentation != documentation) {
			NotificationChain msgs = null;
			if (documentation != null)
				msgs = ((InternalEObject)documentation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OLPackage.ALGORITHM_INSTANCE__DOCUMENTATION, null, msgs);
			if (newDocumentation != null)
				msgs = ((InternalEObject)newDocumentation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OLPackage.ALGORITHM_INSTANCE__DOCUMENTATION, null, msgs);
			msgs = basicSetDocumentation(newDocumentation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OLPackage.ALGORITHM_INSTANCE__DOCUMENTATION, newDocumentation, newDocumentation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OLPackage.ALGORITHM_INSTANCE__ALGORITHM:
				return basicSetAlgorithm(null, msgs);
			case OLPackage.ALGORITHM_INSTANCE__DOCUMENTATION:
				return basicSetDocumentation(null, msgs);
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
			case OLPackage.ALGORITHM_INSTANCE__PROBLEM:
				if (resolve) return getProblem();
				return basicGetProblem();
			case OLPackage.ALGORITHM_INSTANCE__ALGORITHM:
				return getAlgorithm();
			case OLPackage.ALGORITHM_INSTANCE__DOCUMENTATION:
				return getDocumentation();
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
			case OLPackage.ALGORITHM_INSTANCE__PROBLEM:
				setProblem((Problem)newValue);
				return;
			case OLPackage.ALGORITHM_INSTANCE__ALGORITHM:
				setAlgorithm((de.evoal.languages.model.base.Instance)newValue);
				return;
			case OLPackage.ALGORITHM_INSTANCE__DOCUMENTATION:
				setDocumentation((de.evoal.languages.model.base.Array)newValue);
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
			case OLPackage.ALGORITHM_INSTANCE__PROBLEM:
				setProblem((Problem)null);
				return;
			case OLPackage.ALGORITHM_INSTANCE__ALGORITHM:
				setAlgorithm((de.evoal.languages.model.base.Instance)null);
				return;
			case OLPackage.ALGORITHM_INSTANCE__DOCUMENTATION:
				setDocumentation((de.evoal.languages.model.base.Array)null);
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
			case OLPackage.ALGORITHM_INSTANCE__PROBLEM:
				return problem != null;
			case OLPackage.ALGORITHM_INSTANCE__ALGORITHM:
				return algorithm != null;
			case OLPackage.ALGORITHM_INSTANCE__DOCUMENTATION:
				return documentation != null;
		}
		return super.eIsSet(featureID);
	}

} //AlgorithmInstanceImpl
