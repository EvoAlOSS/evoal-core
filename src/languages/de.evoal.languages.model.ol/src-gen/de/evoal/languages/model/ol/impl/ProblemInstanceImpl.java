/**
 * (c) EvoAl Project
 */
package de.evoal.languages.model.ol.impl;

import de.evoal.languages.model.base.expressions.Array;
import de.evoal.languages.model.base.expressions.Instance;
import de.evoal.languages.model.base.expressions.TypeDefinitionReference;

import de.evoal.languages.model.base.expressions.impl.InstanceImpl;

import de.evoal.languages.model.ol.OLPackage;
import de.evoal.languages.model.ol.OptimisationGoal;
import de.evoal.languages.model.ol.ProblemInstance;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Problem Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.ol.impl.ProblemInstanceImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.impl.ProblemInstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.impl.ProblemInstanceImpl#getOptimisationFunction <em>Optimisation Function</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.impl.ProblemInstanceImpl#getOptimisationSpace <em>Optimisation Space</em>}</li>
 *   <li>{@link de.evoal.languages.model.ol.impl.ProblemInstanceImpl#getSearchSpace <em>Search Space</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProblemInstanceImpl extends InstanceImpl implements ProblemInstance {
	/**
	 * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected Array documentation;

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
	protected Instance optimisationFunction;

	/**
	 * The cached value of the '{@link #getOptimisationSpace() <em>Optimisation Space</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimisationSpace()
	 * @generated
	 * @ordered
	 */
	protected EList<OptimisationGoal> optimisationSpace;

	/**
	 * The cached value of the '{@link #getSearchSpace() <em>Search Space</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSearchSpace()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeDefinitionReference> searchSpace;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProblemInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OLPackage.Literals.PROBLEM_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Array getDocumentation() {
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDocumentation(Array newDocumentation, NotificationChain msgs) {
		Array oldDocumentation = documentation;
		documentation = newDocumentation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OLPackage.PROBLEM_INSTANCE__DOCUMENTATION, oldDocumentation, newDocumentation);
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
	public void setDocumentation(Array newDocumentation) {
		if (newDocumentation != documentation) {
			NotificationChain msgs = null;
			if (documentation != null)
				msgs = ((InternalEObject)documentation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OLPackage.PROBLEM_INSTANCE__DOCUMENTATION, null, msgs);
			if (newDocumentation != null)
				msgs = ((InternalEObject)newDocumentation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OLPackage.PROBLEM_INSTANCE__DOCUMENTATION, null, msgs);
			msgs = basicSetDocumentation(newDocumentation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OLPackage.PROBLEM_INSTANCE__DOCUMENTATION, newDocumentation, newDocumentation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, OLPackage.PROBLEM_INSTANCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Instance getOptimisationFunction() {
		return optimisationFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOptimisationFunction(Instance newOptimisationFunction, NotificationChain msgs) {
		Instance oldOptimisationFunction = optimisationFunction;
		optimisationFunction = newOptimisationFunction;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OLPackage.PROBLEM_INSTANCE__OPTIMISATION_FUNCTION, oldOptimisationFunction, newOptimisationFunction);
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
	public void setOptimisationFunction(Instance newOptimisationFunction) {
		if (newOptimisationFunction != optimisationFunction) {
			NotificationChain msgs = null;
			if (optimisationFunction != null)
				msgs = ((InternalEObject)optimisationFunction).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OLPackage.PROBLEM_INSTANCE__OPTIMISATION_FUNCTION, null, msgs);
			if (newOptimisationFunction != null)
				msgs = ((InternalEObject)newOptimisationFunction).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OLPackage.PROBLEM_INSTANCE__OPTIMISATION_FUNCTION, null, msgs);
			msgs = basicSetOptimisationFunction(newOptimisationFunction, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OLPackage.PROBLEM_INSTANCE__OPTIMISATION_FUNCTION, newOptimisationFunction, newOptimisationFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<OptimisationGoal> getOptimisationSpace() {
		if (optimisationSpace == null) {
			optimisationSpace = new EObjectContainmentEList<OptimisationGoal>(OptimisationGoal.class, this, OLPackage.PROBLEM_INSTANCE__OPTIMISATION_SPACE);
		}
		return optimisationSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypeDefinitionReference> getSearchSpace() {
		if (searchSpace == null) {
			searchSpace = new EObjectContainmentEList<TypeDefinitionReference>(TypeDefinitionReference.class, this, OLPackage.PROBLEM_INSTANCE__SEARCH_SPACE);
		}
		return searchSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OLPackage.PROBLEM_INSTANCE__DOCUMENTATION:
				return basicSetDocumentation(null, msgs);
			case OLPackage.PROBLEM_INSTANCE__OPTIMISATION_FUNCTION:
				return basicSetOptimisationFunction(null, msgs);
			case OLPackage.PROBLEM_INSTANCE__OPTIMISATION_SPACE:
				return ((InternalEList<?>)getOptimisationSpace()).basicRemove(otherEnd, msgs);
			case OLPackage.PROBLEM_INSTANCE__SEARCH_SPACE:
				return ((InternalEList<?>)getSearchSpace()).basicRemove(otherEnd, msgs);
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
			case OLPackage.PROBLEM_INSTANCE__DOCUMENTATION:
				return getDocumentation();
			case OLPackage.PROBLEM_INSTANCE__NAME:
				return getName();
			case OLPackage.PROBLEM_INSTANCE__OPTIMISATION_FUNCTION:
				return getOptimisationFunction();
			case OLPackage.PROBLEM_INSTANCE__OPTIMISATION_SPACE:
				return getOptimisationSpace();
			case OLPackage.PROBLEM_INSTANCE__SEARCH_SPACE:
				return getSearchSpace();
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
			case OLPackage.PROBLEM_INSTANCE__DOCUMENTATION:
				setDocumentation((Array)newValue);
				return;
			case OLPackage.PROBLEM_INSTANCE__NAME:
				setName((String)newValue);
				return;
			case OLPackage.PROBLEM_INSTANCE__OPTIMISATION_FUNCTION:
				setOptimisationFunction((Instance)newValue);
				return;
			case OLPackage.PROBLEM_INSTANCE__OPTIMISATION_SPACE:
				getOptimisationSpace().clear();
				getOptimisationSpace().addAll((Collection<? extends OptimisationGoal>)newValue);
				return;
			case OLPackage.PROBLEM_INSTANCE__SEARCH_SPACE:
				getSearchSpace().clear();
				getSearchSpace().addAll((Collection<? extends TypeDefinitionReference>)newValue);
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
			case OLPackage.PROBLEM_INSTANCE__DOCUMENTATION:
				setDocumentation((Array)null);
				return;
			case OLPackage.PROBLEM_INSTANCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case OLPackage.PROBLEM_INSTANCE__OPTIMISATION_FUNCTION:
				setOptimisationFunction((Instance)null);
				return;
			case OLPackage.PROBLEM_INSTANCE__OPTIMISATION_SPACE:
				getOptimisationSpace().clear();
				return;
			case OLPackage.PROBLEM_INSTANCE__SEARCH_SPACE:
				getSearchSpace().clear();
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
			case OLPackage.PROBLEM_INSTANCE__DOCUMENTATION:
				return documentation != null;
			case OLPackage.PROBLEM_INSTANCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case OLPackage.PROBLEM_INSTANCE__OPTIMISATION_FUNCTION:
				return optimisationFunction != null;
			case OLPackage.PROBLEM_INSTANCE__OPTIMISATION_SPACE:
				return optimisationSpace != null && !optimisationSpace.isEmpty();
			case OLPackage.PROBLEM_INSTANCE__SEARCH_SPACE:
				return searchSpace != null && !searchSpace.isEmpty();
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

} //ProblemInstanceImpl
