/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.model.impl;

import de.evoal.models.v202704.core.Configuration;

import de.evoal.models.v202704.optimisation.model.ModelPackage;
import de.evoal.models.v202704.optimisation.model.OptimisationModule;
import de.evoal.models.v202704.optimisation.model.Problem;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Optimisation Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.impl.OptimisationModuleImpl#getAlgorithm <em>Algorithm</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.impl.OptimisationModuleImpl#getProblem <em>Problem</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptimisationModuleImpl extends MinimalEObjectImpl.Container implements OptimisationModule {
	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected Configuration algorithm;

	/**
	 * The cached value of the '{@link #getProblem() <em>Problem</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblem()
	 * @generated
	 * @ordered
	 */
	protected Problem problem;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptimisationModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.OPTIMISATION_MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Configuration getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlgorithm(Configuration newAlgorithm, NotificationChain msgs) {
		Configuration oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.OPTIMISATION_MODULE__ALGORITHM, oldAlgorithm, newAlgorithm);
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
	public void setAlgorithm(Configuration newAlgorithm) {
		if (newAlgorithm != algorithm) {
			NotificationChain msgs = null;
			if (algorithm != null)
				msgs = ((InternalEObject)algorithm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.OPTIMISATION_MODULE__ALGORITHM, null, msgs);
			if (newAlgorithm != null)
				msgs = ((InternalEObject)newAlgorithm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.OPTIMISATION_MODULE__ALGORITHM, null, msgs);
			msgs = basicSetAlgorithm(newAlgorithm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPTIMISATION_MODULE__ALGORITHM, newAlgorithm, newAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Problem getProblem() {
		return problem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProblem(Problem newProblem, NotificationChain msgs) {
		Problem oldProblem = problem;
		problem = newProblem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.OPTIMISATION_MODULE__PROBLEM, oldProblem, newProblem);
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
	public void setProblem(Problem newProblem) {
		if (newProblem != problem) {
			NotificationChain msgs = null;
			if (problem != null)
				msgs = ((InternalEObject)problem).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.OPTIMISATION_MODULE__PROBLEM, null, msgs);
			if (newProblem != null)
				msgs = ((InternalEObject)newProblem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.OPTIMISATION_MODULE__PROBLEM, null, msgs);
			msgs = basicSetProblem(newProblem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPTIMISATION_MODULE__PROBLEM, newProblem, newProblem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.OPTIMISATION_MODULE__ALGORITHM:
				return basicSetAlgorithm(null, msgs);
			case ModelPackage.OPTIMISATION_MODULE__PROBLEM:
				return basicSetProblem(null, msgs);
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
			case ModelPackage.OPTIMISATION_MODULE__ALGORITHM:
				return getAlgorithm();
			case ModelPackage.OPTIMISATION_MODULE__PROBLEM:
				return getProblem();
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
			case ModelPackage.OPTIMISATION_MODULE__ALGORITHM:
				setAlgorithm((Configuration)newValue);
				return;
			case ModelPackage.OPTIMISATION_MODULE__PROBLEM:
				setProblem((Problem)newValue);
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
			case ModelPackage.OPTIMISATION_MODULE__ALGORITHM:
				setAlgorithm((Configuration)null);
				return;
			case ModelPackage.OPTIMISATION_MODULE__PROBLEM:
				setProblem((Problem)null);
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
			case ModelPackage.OPTIMISATION_MODULE__ALGORITHM:
				return algorithm != null;
			case ModelPackage.OPTIMISATION_MODULE__PROBLEM:
				return problem != null;
		}
		return super.eIsSet(featureID);
	}

} //OptimisationModuleImpl
