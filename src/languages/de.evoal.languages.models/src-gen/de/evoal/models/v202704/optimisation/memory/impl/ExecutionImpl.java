/**
 * Copyright Text	(c) EvoAl project
 */
package de.evoal.models.v202704.optimisation.memory.impl;

import de.evoal.models.v202704.optimisation.memory.Execution;
import de.evoal.models.v202704.optimisation.memory.FitnessComponentDefinition;
import de.evoal.models.v202704.optimisation.memory.MemoryPackage;
import de.evoal.models.v202704.optimisation.memory.MetricDefinition;
import de.evoal.models.v202704.optimisation.memory.PropertyDefinition;
import de.evoal.models.v202704.optimisation.memory.ReproducibilityNote;
import de.evoal.models.v202704.optimisation.memory.State;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.ExecutionImpl#getInputSpace <em>Input Space</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.ExecutionImpl#getOutputSpace <em>Output Space</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.ExecutionImpl#getStates <em>States</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.ExecutionImpl#getMetricDefinitions <em>Metric Definitions</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.ExecutionImpl#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.ExecutionImpl#getPropertyDefinitions <em>Property Definitions</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.ExecutionImpl#getFitnessComponents <em>Fitness Components</em>}</li>
 *   <li>{@link de.evoal.models.v202704.optimisation.memory.impl.ExecutionImpl#getReproducibilityNotes <em>Reproducibility Notes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExecutionImpl extends MinimalEObjectImpl.Container implements Execution {
	/**
	 * The cached value of the '{@link #getInputSpace() <em>Input Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputSpace()
	 * @generated
	 * @ordered
	 */
	protected EClass inputSpace;

	/**
	 * The cached value of the '{@link #getOutputSpace() <em>Output Space</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputSpace()
	 * @generated
	 * @ordered
	 */
	protected EClass outputSpace;

	/**
	 * The cached value of the '{@link #getStates() <em>States</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStates()
	 * @generated
	 * @ordered
	 */
	protected EList<State> states;

	/**
	 * The cached value of the '{@link #getMetricDefinitions() <em>Metric Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetricDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<MetricDefinition> metricDefinitions;

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
	 * The cached value of the '{@link #getPropertyDefinitions() <em>Property Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyDefinition> propertyDefinitions;

	/**
	 * The cached value of the '{@link #getFitnessComponents() <em>Fitness Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFitnessComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<FitnessComponentDefinition> fitnessComponents;

	/**
	 * The cached value of the '{@link #getReproducibilityNotes() <em>Reproducibility Notes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReproducibilityNotes()
	 * @generated
	 * @ordered
	 */
	protected EList<ReproducibilityNote> reproducibilityNotes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MemoryPackage.Literals.EXECUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInputSpace() {
		if (inputSpace != null && inputSpace.eIsProxy()) {
			InternalEObject oldInputSpace = (InternalEObject)inputSpace;
			inputSpace = (EClass)eResolveProxy(oldInputSpace);
			if (inputSpace != oldInputSpace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MemoryPackage.EXECUTION__INPUT_SPACE, oldInputSpace, inputSpace));
			}
		}
		return inputSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetInputSpace() {
		return inputSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInputSpace(EClass newInputSpace) {
		EClass oldInputSpace = inputSpace;
		inputSpace = newInputSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MemoryPackage.EXECUTION__INPUT_SPACE, oldInputSpace, inputSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOutputSpace() {
		if (outputSpace != null && outputSpace.eIsProxy()) {
			InternalEObject oldOutputSpace = (InternalEObject)outputSpace;
			outputSpace = (EClass)eResolveProxy(oldOutputSpace);
			if (outputSpace != oldOutputSpace) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MemoryPackage.EXECUTION__OUTPUT_SPACE, oldOutputSpace, outputSpace));
			}
		}
		return outputSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetOutputSpace() {
		return outputSpace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOutputSpace(EClass newOutputSpace) {
		EClass oldOutputSpace = outputSpace;
		outputSpace = newOutputSpace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MemoryPackage.EXECUTION__OUTPUT_SPACE, oldOutputSpace, outputSpace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<State> getStates() {
		if (states == null) {
			states = new EObjectContainmentEList<State>(State.class, this, MemoryPackage.EXECUTION__STATES);
		}
		return states;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MetricDefinition> getMetricDefinitions() {
		if (metricDefinitions == null) {
			metricDefinitions = new EObjectContainmentEList<MetricDefinition>(MetricDefinition.class, this, MemoryPackage.EXECUTION__METRIC_DEFINITIONS);
		}
		return metricDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, Number> getMetrics() {
		if (metrics == null) {
			metrics = new EcoreEMap<String,Number>(MemoryPackage.Literals.METRIC_ENTRY, MetricEntryImpl.class, this, MemoryPackage.EXECUTION__METRICS);
		}
		return metrics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyDefinition> getPropertyDefinitions() {
		if (propertyDefinitions == null) {
			propertyDefinitions = new EObjectContainmentEList<PropertyDefinition>(PropertyDefinition.class, this, MemoryPackage.EXECUTION__PROPERTY_DEFINITIONS);
		}
		return propertyDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FitnessComponentDefinition> getFitnessComponents() {
		if (fitnessComponents == null) {
			fitnessComponents = new EObjectContainmentEList<FitnessComponentDefinition>(FitnessComponentDefinition.class, this, MemoryPackage.EXECUTION__FITNESS_COMPONENTS);
		}
		return fitnessComponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ReproducibilityNote> getReproducibilityNotes() {
		if (reproducibilityNotes == null) {
			reproducibilityNotes = new EObjectContainmentEList<ReproducibilityNote>(ReproducibilityNote.class, this, MemoryPackage.EXECUTION__REPRODUCIBILITY_NOTES);
		}
		return reproducibilityNotes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MemoryPackage.EXECUTION__STATES:
				return ((InternalEList<?>)getStates()).basicRemove(otherEnd, msgs);
			case MemoryPackage.EXECUTION__METRIC_DEFINITIONS:
				return ((InternalEList<?>)getMetricDefinitions()).basicRemove(otherEnd, msgs);
			case MemoryPackage.EXECUTION__METRICS:
				return ((InternalEList<?>)getMetrics()).basicRemove(otherEnd, msgs);
			case MemoryPackage.EXECUTION__PROPERTY_DEFINITIONS:
				return ((InternalEList<?>)getPropertyDefinitions()).basicRemove(otherEnd, msgs);
			case MemoryPackage.EXECUTION__FITNESS_COMPONENTS:
				return ((InternalEList<?>)getFitnessComponents()).basicRemove(otherEnd, msgs);
			case MemoryPackage.EXECUTION__REPRODUCIBILITY_NOTES:
				return ((InternalEList<?>)getReproducibilityNotes()).basicRemove(otherEnd, msgs);
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
			case MemoryPackage.EXECUTION__INPUT_SPACE:
				if (resolve) return getInputSpace();
				return basicGetInputSpace();
			case MemoryPackage.EXECUTION__OUTPUT_SPACE:
				if (resolve) return getOutputSpace();
				return basicGetOutputSpace();
			case MemoryPackage.EXECUTION__STATES:
				return getStates();
			case MemoryPackage.EXECUTION__METRIC_DEFINITIONS:
				return getMetricDefinitions();
			case MemoryPackage.EXECUTION__METRICS:
				if (coreType) return getMetrics();
				else return getMetrics().map();
			case MemoryPackage.EXECUTION__PROPERTY_DEFINITIONS:
				return getPropertyDefinitions();
			case MemoryPackage.EXECUTION__FITNESS_COMPONENTS:
				return getFitnessComponents();
			case MemoryPackage.EXECUTION__REPRODUCIBILITY_NOTES:
				return getReproducibilityNotes();
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
			case MemoryPackage.EXECUTION__INPUT_SPACE:
				setInputSpace((EClass)newValue);
				return;
			case MemoryPackage.EXECUTION__OUTPUT_SPACE:
				setOutputSpace((EClass)newValue);
				return;
			case MemoryPackage.EXECUTION__STATES:
				getStates().clear();
				getStates().addAll((Collection<? extends State>)newValue);
				return;
			case MemoryPackage.EXECUTION__METRIC_DEFINITIONS:
				getMetricDefinitions().clear();
				getMetricDefinitions().addAll((Collection<? extends MetricDefinition>)newValue);
				return;
			case MemoryPackage.EXECUTION__METRICS:
				((EStructuralFeature.Setting)getMetrics()).set(newValue);
				return;
			case MemoryPackage.EXECUTION__PROPERTY_DEFINITIONS:
				getPropertyDefinitions().clear();
				getPropertyDefinitions().addAll((Collection<? extends PropertyDefinition>)newValue);
				return;
			case MemoryPackage.EXECUTION__FITNESS_COMPONENTS:
				getFitnessComponents().clear();
				getFitnessComponents().addAll((Collection<? extends FitnessComponentDefinition>)newValue);
				return;
			case MemoryPackage.EXECUTION__REPRODUCIBILITY_NOTES:
				getReproducibilityNotes().clear();
				getReproducibilityNotes().addAll((Collection<? extends ReproducibilityNote>)newValue);
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
			case MemoryPackage.EXECUTION__INPUT_SPACE:
				setInputSpace((EClass)null);
				return;
			case MemoryPackage.EXECUTION__OUTPUT_SPACE:
				setOutputSpace((EClass)null);
				return;
			case MemoryPackage.EXECUTION__STATES:
				getStates().clear();
				return;
			case MemoryPackage.EXECUTION__METRIC_DEFINITIONS:
				getMetricDefinitions().clear();
				return;
			case MemoryPackage.EXECUTION__METRICS:
				getMetrics().clear();
				return;
			case MemoryPackage.EXECUTION__PROPERTY_DEFINITIONS:
				getPropertyDefinitions().clear();
				return;
			case MemoryPackage.EXECUTION__FITNESS_COMPONENTS:
				getFitnessComponents().clear();
				return;
			case MemoryPackage.EXECUTION__REPRODUCIBILITY_NOTES:
				getReproducibilityNotes().clear();
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
			case MemoryPackage.EXECUTION__INPUT_SPACE:
				return inputSpace != null;
			case MemoryPackage.EXECUTION__OUTPUT_SPACE:
				return outputSpace != null;
			case MemoryPackage.EXECUTION__STATES:
				return states != null && !states.isEmpty();
			case MemoryPackage.EXECUTION__METRIC_DEFINITIONS:
				return metricDefinitions != null && !metricDefinitions.isEmpty();
			case MemoryPackage.EXECUTION__METRICS:
				return metrics != null && !metrics.isEmpty();
			case MemoryPackage.EXECUTION__PROPERTY_DEFINITIONS:
				return propertyDefinitions != null && !propertyDefinitions.isEmpty();
			case MemoryPackage.EXECUTION__FITNESS_COMPONENTS:
				return fitnessComponents != null && !fitnessComponents.isEmpty();
			case MemoryPackage.EXECUTION__REPRODUCIBILITY_NOTES:
				return reproducibilityNotes != null && !reproducibilityNotes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ExecutionImpl
