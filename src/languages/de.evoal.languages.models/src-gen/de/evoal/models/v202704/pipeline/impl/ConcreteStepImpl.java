/**
 * (c) EvoAl project
 */
package de.evoal.models.v202704.pipeline.impl;

import de.evoal.models.v202704.core.Configuration;

import de.evoal.models.v202704.pipeline.ConcreteStep;
import de.evoal.models.v202704.pipeline.PipelinePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Concrete Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.models.v202704.pipeline.impl.ConcreteStepImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link de.evoal.models.v202704.pipeline.impl.ConcreteStepImpl#getReads <em>Reads</em>}</li>
 *   <li>{@link de.evoal.models.v202704.pipeline.impl.ConcreteStepImpl#getWrites <em>Writes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConcreteStepImpl extends StepImpl implements ConcreteStep {
	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected Configuration configuration;

	/**
	 * The cached value of the '{@link #getReads() <em>Reads</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReads()
	 * @generated
	 * @ordered
	 */
	protected EList<EStructuralFeature> reads;

	/**
	 * The cached value of the '{@link #getWrites() <em>Writes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWrites()
	 * @generated
	 * @ordered
	 */
	protected EList<EStructuralFeature> writes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConcreteStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PipelinePackage.Literals.CONCRETE_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Configuration getConfiguration() {
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(Configuration newConfiguration, NotificationChain msgs) {
		Configuration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PipelinePackage.CONCRETE_STEP__CONFIGURATION, oldConfiguration, newConfiguration);
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
	public void setConfiguration(Configuration newConfiguration) {
		if (newConfiguration != configuration) {
			NotificationChain msgs = null;
			if (configuration != null)
				msgs = ((InternalEObject)configuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PipelinePackage.CONCRETE_STEP__CONFIGURATION, null, msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PipelinePackage.CONCRETE_STEP__CONFIGURATION, null, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PipelinePackage.CONCRETE_STEP__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EStructuralFeature> getReads() {
		if (reads == null) {
			reads = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, PipelinePackage.CONCRETE_STEP__READS);
		}
		return reads;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EStructuralFeature> getWrites() {
		if (writes == null) {
			writes = new EObjectResolvingEList<EStructuralFeature>(EStructuralFeature.class, this, PipelinePackage.CONCRETE_STEP__WRITES);
		}
		return writes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PipelinePackage.CONCRETE_STEP__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
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
			case PipelinePackage.CONCRETE_STEP__CONFIGURATION:
				return getConfiguration();
			case PipelinePackage.CONCRETE_STEP__READS:
				return getReads();
			case PipelinePackage.CONCRETE_STEP__WRITES:
				return getWrites();
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
			case PipelinePackage.CONCRETE_STEP__CONFIGURATION:
				setConfiguration((Configuration)newValue);
				return;
			case PipelinePackage.CONCRETE_STEP__READS:
				getReads().clear();
				getReads().addAll((Collection<? extends EStructuralFeature>)newValue);
				return;
			case PipelinePackage.CONCRETE_STEP__WRITES:
				getWrites().clear();
				getWrites().addAll((Collection<? extends EStructuralFeature>)newValue);
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
			case PipelinePackage.CONCRETE_STEP__CONFIGURATION:
				setConfiguration((Configuration)null);
				return;
			case PipelinePackage.CONCRETE_STEP__READS:
				getReads().clear();
				return;
			case PipelinePackage.CONCRETE_STEP__WRITES:
				getWrites().clear();
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
			case PipelinePackage.CONCRETE_STEP__CONFIGURATION:
				return configuration != null;
			case PipelinePackage.CONCRETE_STEP__READS:
				return reads != null && !reads.isEmpty();
			case PipelinePackage.CONCRETE_STEP__WRITES:
				return writes != null && !writes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConcreteStepImpl
