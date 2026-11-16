/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.model.impl;

import de.evoal.models.v202704.core.Configuration;

import de.evoal.models.v202704.optimisation.model.ModelPackage;
import de.evoal.models.v202704.optimisation.model.OptimisationGoal;
import de.evoal.models.v202704.optimisation.model.Problem;

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
 * An implementation of the model object '<em><b>Problem</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.impl.ProblemImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.impl.ProblemImpl#getOptimisationFunction <em>Optimisation Function</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.impl.ProblemImpl#getOptimisationSpace <em>Optimisation Space</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.impl.ProblemImpl#getGoals <em>Goals</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.impl.ProblemImpl#getSearchSpace <em>Search Space</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.model.impl.ProblemImpl#getDocumentation <em>Documentation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProblemImpl extends MinimalEObjectImpl.Container implements Problem {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOptimisationFunction() <em>Optimisation Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimisationFunction()
	 * @generated
	 * @ordered
	 */
	protected Configuration optimisationFunction;

	/**
	 * The cached value of the '{@link #getOptimisationSpace() <em>Optimisation Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimisationSpace()
	 * @generated
	 * @ordered
	 */
	protected EClass optimisationSpace;

	/**
	 * The cached value of the '{@link #getGoals() <em>Goals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoals()
	 * @generated
	 * @ordered
	 */
	protected EList<OptimisationGoal> goals;

	/**
	 * The cached value of the '{@link #getSearchSpace() <em>Search Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchSpace()
	 * @generated
	 * @ordered
	 */
	protected EClass searchSpace;

	/**
	 * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected EList<Configuration> documentation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProblemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PROBLEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROBLEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Configuration getOptimisationFunction() {
		return optimisationFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOptimisationFunction(Configuration newOptimisationFunction, NotificationChain msgs) {
		Configuration oldOptimisationFunction = optimisationFunction;
		optimisationFunction = newOptimisationFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.PROBLEM__OPTIMISATION_FUNCTION, oldOptimisationFunction, newOptimisationFunction);
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
	public void setOptimisationFunction(Configuration newOptimisationFunction) {
		if (newOptimisationFunction != optimisationFunction) {
			NotificationChain msgs = null;
			if (optimisationFunction != null)
				msgs = ((InternalEObject)optimisationFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PROBLEM__OPTIMISATION_FUNCTION, null, msgs);
			if (newOptimisationFunction != null)
				msgs = ((InternalEObject)newOptimisationFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.PROBLEM__OPTIMISATION_FUNCTION, null, msgs);
			msgs = basicSetOptimisationFunction(newOptimisationFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROBLEM__OPTIMISATION_FUNCTION, newOptimisationFunction, newOptimisationFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOptimisationSpace() {
		if (optimisationSpace != null && optimisationSpace.eIsProxy()) {
			InternalEObject oldOptimisationSpace = (InternalEObject)optimisationSpace;
			optimisationSpace = (EClass)eResolveProxy(oldOptimisationSpace);
			if (optimisationSpace != oldOptimisationSpace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PROBLEM__OPTIMISATION_SPACE, oldOptimisationSpace, optimisationSpace));
			}
		}
		return optimisationSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetOptimisationSpace() {
		return optimisationSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOptimisationSpace(EClass newOptimisationSpace) {
		EClass oldOptimisationSpace = optimisationSpace;
		optimisationSpace = newOptimisationSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROBLEM__OPTIMISATION_SPACE, oldOptimisationSpace, optimisationSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<OptimisationGoal> getGoals() {
		if (goals == null) {
			goals = new EObjectContainmentEList<OptimisationGoal>(OptimisationGoal.class, this, ModelPackage.PROBLEM__GOALS);
		}
		return goals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSearchSpace() {
		if (searchSpace != null && searchSpace.eIsProxy()) {
			InternalEObject oldSearchSpace = (InternalEObject)searchSpace;
			searchSpace = (EClass)eResolveProxy(oldSearchSpace);
			if (searchSpace != oldSearchSpace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PROBLEM__SEARCH_SPACE, oldSearchSpace, searchSpace));
			}
		}
		return searchSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetSearchSpace() {
		return searchSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSearchSpace(EClass newSearchSpace) {
		EClass oldSearchSpace = searchSpace;
		searchSpace = newSearchSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PROBLEM__SEARCH_SPACE, oldSearchSpace, searchSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Configuration> getDocumentation() {
		if (documentation == null) {
			documentation = new EObjectContainmentEList<Configuration>(Configuration.class, this, ModelPackage.PROBLEM__DOCUMENTATION);
		}
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PROBLEM__OPTIMISATION_FUNCTION:
				return basicSetOptimisationFunction(null, msgs);
			case ModelPackage.PROBLEM__GOALS:
				return ((InternalEList<?>)getGoals()).basicRemove(otherEnd, msgs);
			case ModelPackage.PROBLEM__DOCUMENTATION:
				return ((InternalEList<?>)getDocumentation()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.PROBLEM__NAME:
				return getName();
			case ModelPackage.PROBLEM__OPTIMISATION_FUNCTION:
				return getOptimisationFunction();
			case ModelPackage.PROBLEM__OPTIMISATION_SPACE:
				if (resolve) return getOptimisationSpace();
				return basicGetOptimisationSpace();
			case ModelPackage.PROBLEM__GOALS:
				return getGoals();
			case ModelPackage.PROBLEM__SEARCH_SPACE:
				if (resolve) return getSearchSpace();
				return basicGetSearchSpace();
			case ModelPackage.PROBLEM__DOCUMENTATION:
				return getDocumentation();
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
			case ModelPackage.PROBLEM__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.PROBLEM__OPTIMISATION_FUNCTION:
				setOptimisationFunction((Configuration)newValue);
				return;
			case ModelPackage.PROBLEM__OPTIMISATION_SPACE:
				setOptimisationSpace((EClass)newValue);
				return;
			case ModelPackage.PROBLEM__GOALS:
				getGoals().clear();
				getGoals().addAll((Collection<? extends OptimisationGoal>)newValue);
				return;
			case ModelPackage.PROBLEM__SEARCH_SPACE:
				setSearchSpace((EClass)newValue);
				return;
			case ModelPackage.PROBLEM__DOCUMENTATION:
				getDocumentation().clear();
				getDocumentation().addAll((Collection<? extends Configuration>)newValue);
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
			case ModelPackage.PROBLEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.PROBLEM__OPTIMISATION_FUNCTION:
				setOptimisationFunction((Configuration)null);
				return;
			case ModelPackage.PROBLEM__OPTIMISATION_SPACE:
				setOptimisationSpace((EClass)null);
				return;
			case ModelPackage.PROBLEM__GOALS:
				getGoals().clear();
				return;
			case ModelPackage.PROBLEM__SEARCH_SPACE:
				setSearchSpace((EClass)null);
				return;
			case ModelPackage.PROBLEM__DOCUMENTATION:
				getDocumentation().clear();
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
			case ModelPackage.PROBLEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.PROBLEM__OPTIMISATION_FUNCTION:
				return optimisationFunction != null;
			case ModelPackage.PROBLEM__OPTIMISATION_SPACE:
				return optimisationSpace != null;
			case ModelPackage.PROBLEM__GOALS:
				return goals != null && !goals.isEmpty();
			case ModelPackage.PROBLEM__SEARCH_SPACE:
				return searchSpace != null;
			case ModelPackage.PROBLEM__DOCUMENTATION:
				return documentation != null && !documentation.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ProblemImpl
