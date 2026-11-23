/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory.impl;

import de.evoal.models.v202704.optimisation.memory.IndividualRecord;
import de.evoal.models.v202704.optimisation.memory.Iteration;
import de.evoal.models.v202704.optimisation.memory.IterationStep;
import de.evoal.models.v202704.optimisation.memory.MemoryPackage;
import de.evoal.models.v202704.optimisation.memory.Rank;

import java.util.Collection;

import java.util.stream.Stream;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.IterationImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.IterationImpl#getSteps <em>Steps</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.IterationImpl#getRanks <em>Ranks</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.IterationImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.IterationImpl#getBestSoFar <em>Best So Far</em>}</li>
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
	 * The cached value of the '{@link #getMetrics() <em>Metrics</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetrics()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, Number> metrics;

	/**
	 * The cached value of the '{@link #getBestSoFar() <em>Best So Far</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBestSoFar()
	 * @generated
	 * @ordered
	 */
	protected IndividualRecord bestSoFar;

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
	public void setNumber(int newNumber) {
		int oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MemoryPackage.ITERATION__NUMBER, oldNumber, number));
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
	public EMap<String, Number> getMetrics() {
		if (metrics == null) {
			metrics = new EcoreEMap<String,Number>(MemoryPackage.Literals.METRIC_ENTRY, MetricEntryImpl.class, this, MemoryPackage.ITERATION__METRICS);
		}
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IndividualRecord getBestSoFar() {
		if (bestSoFar != null && bestSoFar.eIsProxy()) {
			InternalEObject oldBestSoFar = (InternalEObject)bestSoFar;
			bestSoFar = (IndividualRecord)eResolveProxy(oldBestSoFar);
			if (bestSoFar != oldBestSoFar) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MemoryPackage.ITERATION__BEST_SO_FAR, oldBestSoFar, bestSoFar));
			}
		}
		return bestSoFar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndividualRecord basicGetBestSoFar() {
		return bestSoFar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBestSoFar(IndividualRecord newBestSoFar) {
		IndividualRecord oldBestSoFar = bestSoFar;
		bestSoFar = newBestSoFar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MemoryPackage.ITERATION__BEST_SO_FAR, oldBestSoFar, bestSoFar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Stream<IndividualRecord> bestIndividuals() {
		return getRanks()
		.get(0)
		.getMembers()
		.stream();
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Stream<IndividualRecord> survivedIndividuals() {
		return getRanks()
		.stream()
		.flatMap(r -> r.getMembers().stream());
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int numberOfSurvivedIndividuals() {
		return (int) survivedIndividuals().count();
		
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
			case MemoryPackage.ITERATION__METRICS:
				return ((InternalEList<?>)getMetrics()).basicRemove(otherEnd, msgs);
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
			case MemoryPackage.ITERATION__METRICS:
				if (coreType) return getMetrics();
				else return getMetrics().map();
			case MemoryPackage.ITERATION__BEST_SO_FAR:
				if (resolve) return getBestSoFar();
				return basicGetBestSoFar();
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
			case MemoryPackage.ITERATION__NUMBER:
				setNumber((Integer)newValue);
				return;
			case MemoryPackage.ITERATION__STEPS:
				getSteps().clear();
				getSteps().addAll((Collection<? extends IterationStep>)newValue);
				return;
			case MemoryPackage.ITERATION__RANKS:
				getRanks().clear();
				getRanks().addAll((Collection<? extends Rank>)newValue);
				return;
			case MemoryPackage.ITERATION__METRICS:
				((EStructuralFeature.Setting)getMetrics()).set(newValue);
				return;
			case MemoryPackage.ITERATION__BEST_SO_FAR:
				setBestSoFar((IndividualRecord)newValue);
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
			case MemoryPackage.ITERATION__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case MemoryPackage.ITERATION__STEPS:
				getSteps().clear();
				return;
			case MemoryPackage.ITERATION__RANKS:
				getRanks().clear();
				return;
			case MemoryPackage.ITERATION__METRICS:
				getMetrics().clear();
				return;
			case MemoryPackage.ITERATION__BEST_SO_FAR:
				setBestSoFar((IndividualRecord)null);
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
			case MemoryPackage.ITERATION__METRICS:
				return metrics != null && !metrics.isEmpty();
			case MemoryPackage.ITERATION__BEST_SO_FAR:
				return bestSoFar != null;
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
