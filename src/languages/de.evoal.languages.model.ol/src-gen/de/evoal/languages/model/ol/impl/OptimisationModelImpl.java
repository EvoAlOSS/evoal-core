/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol.impl;

import de.evoal.languages.model.ol.AlgorithmInstance;
import de.evoal.languages.model.ol.Import;
import de.evoal.languages.model.ol.OLPackage;
import de.evoal.languages.model.ol.OptimisationModel;

import de.evoal.languages.model.ol.ProblemInstance;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Optimisation Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ol.impl.OptimisationModelImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.impl.OptimisationModelImpl#getProblem <em>Problem</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.impl.OptimisationModelImpl#getAlgorithm <em>Algorithm</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OptimisationModelImpl extends MinimalEObjectImpl.Container implements OptimisationModel {
	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<de.evoal.languages.model.base.Import> imports;

	/**
	 * The cached value of the '{@link #getProblem() <em>Problem</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProblem()
	 * @generated
	 * @ordered
	 */
	protected ProblemInstance problem;

	/**
	 * The cached value of the '{@link #getAlgorithm() <em>Algorithm</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithm()
	 * @generated
	 * @ordered
	 */
	protected AlgorithmInstance algorithm;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OptimisationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OLPackage.Literals.OPTIMISATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<de.evoal.languages.model.base.Import> getImports() {
		if (imports == null) {
			imports = new EObjectContainmentEList<de.evoal.languages.model.base.Import>(de.evoal.languages.model.base.Import.class, this, OLPackage.OPTIMISATION_MODEL__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProblemInstance getProblem() {
		return problem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProblem(ProblemInstance newProblem, NotificationChain msgs) {
		ProblemInstance oldProblem = problem;
		problem = newProblem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OLPackage.OPTIMISATION_MODEL__PROBLEM, oldProblem, newProblem);
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
	public void setProblem(ProblemInstance newProblem) {
		if (newProblem != problem) {
			NotificationChain msgs = null;
			if (problem != null)
				msgs = ((InternalEObject)problem).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OLPackage.OPTIMISATION_MODEL__PROBLEM, null, msgs);
			if (newProblem != null)
				msgs = ((InternalEObject)newProblem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OLPackage.OPTIMISATION_MODEL__PROBLEM, null, msgs);
			msgs = basicSetProblem(newProblem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OLPackage.OPTIMISATION_MODEL__PROBLEM, newProblem, newProblem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AlgorithmInstance getAlgorithm() {
		return algorithm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAlgorithm(AlgorithmInstance newAlgorithm, NotificationChain msgs) {
		AlgorithmInstance oldAlgorithm = algorithm;
		algorithm = newAlgorithm;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OLPackage.OPTIMISATION_MODEL__ALGORITHM, oldAlgorithm, newAlgorithm);
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
	public void setAlgorithm(AlgorithmInstance newAlgorithm) {
		if (newAlgorithm != algorithm) {
			NotificationChain msgs = null;
			if (algorithm != null)
				msgs = ((InternalEObject)algorithm).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OLPackage.OPTIMISATION_MODEL__ALGORITHM, null, msgs);
			if (newAlgorithm != null)
				msgs = ((InternalEObject)newAlgorithm).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OLPackage.OPTIMISATION_MODEL__ALGORITHM, null, msgs);
			msgs = basicSetAlgorithm(newAlgorithm, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OLPackage.OPTIMISATION_MODEL__ALGORITHM, newAlgorithm, newAlgorithm));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OLPackage.OPTIMISATION_MODEL__IMPORTS:
				return ((InternalEList<?>)getImports()).basicRemove(otherEnd, msgs);
			case OLPackage.OPTIMISATION_MODEL__PROBLEM:
				return basicSetProblem(null, msgs);
			case OLPackage.OPTIMISATION_MODEL__ALGORITHM:
				return basicSetAlgorithm(null, msgs);
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
			case OLPackage.OPTIMISATION_MODEL__IMPORTS:
				return getImports();
			case OLPackage.OPTIMISATION_MODEL__PROBLEM:
				return getProblem();
			case OLPackage.OPTIMISATION_MODEL__ALGORITHM:
				return getAlgorithm();
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
			case OLPackage.OPTIMISATION_MODEL__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends de.evoal.languages.model.base.Import>)newValue);
				return;
			case OLPackage.OPTIMISATION_MODEL__PROBLEM:
				setProblem((ProblemInstance)newValue);
				return;
			case OLPackage.OPTIMISATION_MODEL__ALGORITHM:
				setAlgorithm((AlgorithmInstance)newValue);
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
			case OLPackage.OPTIMISATION_MODEL__IMPORTS:
				getImports().clear();
				return;
			case OLPackage.OPTIMISATION_MODEL__PROBLEM:
				setProblem((ProblemInstance)null);
				return;
			case OLPackage.OPTIMISATION_MODEL__ALGORITHM:
				setAlgorithm((AlgorithmInstance)null);
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
			case OLPackage.OPTIMISATION_MODEL__IMPORTS:
				return imports != null && !imports.isEmpty();
			case OLPackage.OPTIMISATION_MODEL__PROBLEM:
				return problem != null;
			case OLPackage.OPTIMISATION_MODEL__ALGORITHM:
				return algorithm != null;
		}
		return super.eIsSet(featureID);
	}

} //OptimisationModelImpl
