/**
 */
package de.evoal.languages.model.mll.impl;

import de.evoal.languages.model.ddl.DataDescription;

import de.evoal.languages.model.mll.BlockStatement;
import de.evoal.languages.model.mll.MllPackage;
import de.evoal.languages.model.mll.Prediction;
import de.evoal.languages.model.mll.SurrogateDefinition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prediction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.evoal.languages.model.mll.impl.PredictionImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.PredictionImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.PredictionImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link de.evoal.languages.model.mll.impl.PredictionImpl#getQuality <em>Quality</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PredictionImpl extends MinimalEObjectImpl.Container implements Prediction {
	/**
	 * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinition()
	 * @generated
	 * @ordered
	 */
	protected SurrogateDefinition definition;

	/**
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<DataDescription> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<DataDescription> outputs;

	/**
	 * The cached value of the '{@link #getQuality() <em>Quality</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuality()
	 * @generated
	 * @ordered
	 */
	protected BlockStatement quality;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredictionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MllPackage.Literals.PREDICTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SurrogateDefinition getDefinition() {
		if (definition != null && definition.eIsProxy()) {
			InternalEObject oldDefinition = (InternalEObject)definition;
			definition = (SurrogateDefinition)eResolveProxy(oldDefinition);
			if (definition != oldDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MllPackage.PREDICTION__DEFINITION, oldDefinition, definition));
			}
		}
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SurrogateDefinition basicGetDefinition() {
		return definition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDefinition(SurrogateDefinition newDefinition) {
		SurrogateDefinition oldDefinition = definition;
		definition = newDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.PREDICTION__DEFINITION, oldDefinition, definition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataDescription> getInputs() {
		if (inputs == null) {
			inputs = new EObjectResolvingEList<DataDescription>(DataDescription.class, this, MllPackage.PREDICTION__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DataDescription> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectResolvingEList<DataDescription>(DataDescription.class, this, MllPackage.PREDICTION__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlockStatement getQuality() {
		return quality;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQuality(BlockStatement newQuality, NotificationChain msgs) {
		BlockStatement oldQuality = quality;
		quality = newQuality;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MllPackage.PREDICTION__QUALITY, oldQuality, newQuality);
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
	public void setQuality(BlockStatement newQuality) {
		if (newQuality != quality) {
			NotificationChain msgs = null;
			if (quality != null)
				msgs = ((InternalEObject)quality).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MllPackage.PREDICTION__QUALITY, null, msgs);
			if (newQuality != null)
				msgs = ((InternalEObject)newQuality).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MllPackage.PREDICTION__QUALITY, null, msgs);
			msgs = basicSetQuality(newQuality, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MllPackage.PREDICTION__QUALITY, newQuality, newQuality));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MllPackage.PREDICTION__QUALITY:
				return basicSetQuality(null, msgs);
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
			case MllPackage.PREDICTION__DEFINITION:
				if (resolve) return getDefinition();
				return basicGetDefinition();
			case MllPackage.PREDICTION__INPUTS:
				return getInputs();
			case MllPackage.PREDICTION__OUTPUTS:
				return getOutputs();
			case MllPackage.PREDICTION__QUALITY:
				return getQuality();
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
			case MllPackage.PREDICTION__DEFINITION:
				setDefinition((SurrogateDefinition)newValue);
				return;
			case MllPackage.PREDICTION__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends DataDescription>)newValue);
				return;
			case MllPackage.PREDICTION__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends DataDescription>)newValue);
				return;
			case MllPackage.PREDICTION__QUALITY:
				setQuality((BlockStatement)newValue);
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
			case MllPackage.PREDICTION__DEFINITION:
				setDefinition((SurrogateDefinition)null);
				return;
			case MllPackage.PREDICTION__INPUTS:
				getInputs().clear();
				return;
			case MllPackage.PREDICTION__OUTPUTS:
				getOutputs().clear();
				return;
			case MllPackage.PREDICTION__QUALITY:
				setQuality((BlockStatement)null);
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
			case MllPackage.PREDICTION__DEFINITION:
				return definition != null;
			case MllPackage.PREDICTION__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case MllPackage.PREDICTION__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case MllPackage.PREDICTION__QUALITY:
				return quality != null;
		}
		return super.eIsSet(featureID);
	}

} //PredictionImpl
