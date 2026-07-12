/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.languages.model.optimization.memory.impl;

import de.evoal.languages.model.optimization.memory.Iteration;
import de.evoal.languages.model.optimization.memory.IterationStep;
import de.evoal.languages.model.optimization.memory.MemoryPackage;

import de.evoal.languages.model.optimization.memory.Rank;
import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.optimization.memory.impl.IterationImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link de.evoal.languages.model.optimization.memory.impl.IterationImpl#getSteps <em>Steps</em>}</li>
 *   <li>{@link de.evoal.languages.model.optimization.memory.impl.IterationImpl#getRanks <em>Ranks</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IterationImpl extends StateImpl implements Iteration {
	/**
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSteps() <em>Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<IterationStep> steps;

	/**
	 * The cached value of the '{@link #getRanks() <em>Ranks</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRanks()
	 * @generated
	 * @ordered
	 */
	protected EList<Rank> ranks;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IterationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MemoryPackage.Literals.ITERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IterationStep> getSteps() {
		if (steps == null) {
			steps = new EObjectContainmentEList<IterationStep>(IterationStep.class, this, MemoryPackage.ITERATION__STEPS);
		}
		return steps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Rank> getRanks() {
		if (ranks == null) {
			ranks = new EObjectContainmentEList<Rank>(Rank.class, this, MemoryPackage.ITERATION__RANKS);
		}
		return ranks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MemoryPackage.ITERATION__STEPS:
				return ((InternalEList<?>)getSteps()).basicRemove(otherEnd, msgs);
			case MemoryPackage.ITERATION__RANKS:
				return ((InternalEList<?>)getRanks()).basicRemove(otherEnd, msgs);
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
			case MemoryPackage.ITERATION__NUMBER:
				return getNumber();
			case MemoryPackage.ITERATION__STEPS:
				return getSteps();
			case MemoryPackage.ITERATION__RANKS:
				return getRanks();
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
			case MemoryPackage.ITERATION__STEPS:
				getSteps().clear();
				getSteps().addAll((Collection<? extends IterationStep>)newValue);
				return;
			case MemoryPackage.ITERATION__RANKS:
				getRanks().clear();
				getRanks().addAll((Collection<? extends Rank>)newValue);
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
			case MemoryPackage.ITERATION__STEPS:
				getSteps().clear();
				return;
			case MemoryPackage.ITERATION__RANKS:
				getRanks().clear();
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
			case MemoryPackage.ITERATION__NUMBER:
				return number != NUMBER_EDEFAULT;
			case MemoryPackage.ITERATION__STEPS:
				return steps != null && !steps.isEmpty();
			case MemoryPackage.ITERATION__RANKS:
				return ranks != null && !ranks.isEmpty();
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
		result.append(" (number: ");
		result.append(number);
		result.append(')');
		return result.toString();
	}

} //IterationImpl
